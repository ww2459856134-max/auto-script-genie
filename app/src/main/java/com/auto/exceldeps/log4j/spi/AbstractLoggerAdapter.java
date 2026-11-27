package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.LogManager;
import com.auto.exceldeps.log4j.util.LoaderUtil;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class AbstractLoggerAdapter<L> implements LoggerAdapter<L>, LoggerContextShutdownAware {
    protected final Map<LoggerContext, ConcurrentMap<String, L>> registry = new ConcurrentHashMap();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.lock.writeLock().lock();
        try {
            this.registry.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContextShutdownAware
    public void contextShutdown(LoggerContext loggerContext) {
        this.registry.remove(loggerContext);
    }

    protected abstract LoggerContext getContext();

    protected LoggerContext getContext(Class<?> cls) {
        ClassLoader classLoader = cls != null ? cls.getClassLoader() : null;
        if (classLoader == null) {
            classLoader = LoaderUtil.getThreadContextClassLoader();
        }
        return LogManager.getContext(classLoader, false);
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerAdapter
    public L getLogger(String str) {
        LoggerContext context = getContext();
        ConcurrentMap<String, L> loggersInContext = getLoggersInContext(context);
        L l2 = loggersInContext.get(str);
        if (l2 != null) {
            return l2;
        }
        loggersInContext.putIfAbsent(str, newLogger(str, context));
        return loggersInContext.get(str);
    }

    public Set<LoggerContext> getLoggerContexts() {
        return new HashSet(this.registry.keySet());
    }

    public ConcurrentMap<String, L> getLoggersInContext(LoggerContext loggerContext) {
        this.lock.readLock().lock();
        try {
            ConcurrentMap<String, L> concurrentMap = this.registry.get(loggerContext);
            if (concurrentMap != null) {
                return concurrentMap;
            }
            this.lock.writeLock().lock();
            try {
                ConcurrentMap<String, L> concurrentHashMap = this.registry.get(loggerContext);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.registry.put(loggerContext, concurrentHashMap);
                    if (loggerContext instanceof LoggerContextShutdownEnabled) {
                        ((LoggerContextShutdownEnabled) loggerContext).addShutdownListener(this);
                    }
                }
                return concurrentHashMap;
            } finally {
                this.lock.writeLock().unlock();
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    protected abstract L newLogger(String str, LoggerContext loggerContext);
}
