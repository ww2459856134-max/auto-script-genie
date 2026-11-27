package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.message.ParameterizedMessageFactory;
import com.auto.exceldeps.log4j.spi.ExtendedLogger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes.dex */
public class LoggerRegistry<T extends ExtendedLogger> {
    private final ReadWriteLock lock;
    private final Map<String, Map<MessageFactory, T>> loggerByMessageFactoryByName;
    private final Lock readLock;
    private final Lock writeLock;

    public static class ConcurrentMapFactory<T extends ExtendedLogger> implements MapFactory<T> {
        @Override // com.auto.exceldeps.log4j.spi.LoggerRegistry.MapFactory
        public Map<String, T> createInnerMap() {
            return new ConcurrentHashMap();
        }

        @Override // com.auto.exceldeps.log4j.spi.LoggerRegistry.MapFactory
        public Map<String, Map<String, T>> createOuterMap() {
            return new ConcurrentHashMap();
        }

        @Override // com.auto.exceldeps.log4j.spi.LoggerRegistry.MapFactory
        public void putIfAbsent(Map<String, T> map, String str, T t) {
            map.putIfAbsent(str, t);
        }
    }

    public interface MapFactory<T extends ExtendedLogger> {
        Map<String, T> createInnerMap();

        Map<String, Map<String, T>> createOuterMap();

        void putIfAbsent(Map<String, T> map, String str, T t);
    }

    public static class WeakMapFactory<T extends ExtendedLogger> implements MapFactory<T> {
        @Override // com.auto.exceldeps.log4j.spi.LoggerRegistry.MapFactory
        public Map<String, T> createInnerMap() {
            return new WeakHashMap();
        }

        @Override // com.auto.exceldeps.log4j.spi.LoggerRegistry.MapFactory
        public Map<String, Map<String, T>> createOuterMap() {
            return new WeakHashMap();
        }

        @Override // com.auto.exceldeps.log4j.spi.LoggerRegistry.MapFactory
        public void putIfAbsent(Map<String, T> map, String str, T t) {
            map.put(str, t);
        }
    }

    public LoggerRegistry() {
        this.loggerByMessageFactoryByName = new HashMap();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<MessageFactory, T> createLoggerRefByMessageFactoryMap(String str) {
        return new WeakHashMap();
    }

    public T getLogger(String str) {
        Objects.requireNonNull(str, "name");
        return (T) getLogger(str, null);
    }

    public Collection<T> getLoggers() {
        this.readLock.lock();
        try {
            return (Collection) this.loggerByMessageFactoryByName.values().stream().flatMap(new Function() { // from class: com.auto.exceldeps.log4j.spi.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Map) obj).values().stream();
                }
            }).collect(Collectors.toList());
        } finally {
            this.readLock.unlock();
        }
    }

    public boolean hasLogger(String str) {
        Objects.requireNonNull(str, "name");
        return getLogger(str) != null;
    }

    public void putIfAbsent(String str, MessageFactory messageFactory, T t) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(t, "logger");
        this.writeLock.lock();
        if (messageFactory == null) {
            try {
                messageFactory = ParameterizedMessageFactory.INSTANCE;
            } finally {
                this.writeLock.unlock();
            }
        }
        this.loggerByMessageFactoryByName.computeIfAbsent(str, new Function() { // from class: com.auto.exceldeps.log4j.spi.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.createLoggerRefByMessageFactoryMap((String) obj);
            }
        }).putIfAbsent(messageFactory, t);
        if (!str.equals(t.getName()) || !messageFactory.equals(t.getMessageFactory())) {
            this.loggerByMessageFactoryByName.computeIfAbsent(t.getName(), new Function() { // from class: com.auto.exceldeps.log4j.spi.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.createLoggerRefByMessageFactoryMap((String) obj);
                }
            }).putIfAbsent(t.getMessageFactory(), t);
        }
    }

    public T getLogger(String str, MessageFactory messageFactory) {
        Objects.requireNonNull(str, "name");
        this.readLock.lock();
        try {
            Map<MessageFactory, T> map = this.loggerByMessageFactoryByName.get(str);
            if (messageFactory == null) {
                messageFactory = ParameterizedMessageFactory.INSTANCE;
            }
            return map == null ? null : map.get(messageFactory);
        } finally {
            this.readLock.unlock();
        }
    }

    public boolean hasLogger(String str, MessageFactory messageFactory) {
        Objects.requireNonNull(str, "name");
        return getLogger(str, messageFactory) != null;
    }

    public boolean hasLogger(String str, final Class<? extends MessageFactory> cls) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(cls, "messageFactoryClass");
        this.readLock.lock();
        try {
            return this.loggerByMessageFactoryByName.getOrDefault(str, Collections.emptyMap()).keySet().stream().anyMatch(new Predicate() { // from class: com.auto.exceldeps.log4j.spi.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return cls.equals(((MessageFactory) obj).getClass());
                }
            });
        } finally {
            this.readLock.unlock();
        }
    }

    public LoggerRegistry(MapFactory<T> mapFactory) {
        this();
    }

    public Collection<T> getLoggers(Collection<T> collection) {
        Objects.requireNonNull(collection, "destination");
        collection.addAll(getLoggers());
        return collection;
    }
}
