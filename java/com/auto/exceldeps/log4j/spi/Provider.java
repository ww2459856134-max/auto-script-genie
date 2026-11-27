package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.simple.SimpleLoggerContextFactory;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.LoaderUtil;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import org.jspecify.annotations.NullMarked;

@NullMarked
/* loaded from: classes.dex */
public class Provider {
    protected static final String CURRENT_VERSION = "2.6.0";
    private static final int DEFAULT_PRIORITY = -1;
    private static final String DISABLE_CONTEXT_MAP = "log4j2.disableThreadContextMap";
    private static final String DISABLE_THREAD_CONTEXT = "log4j2.disableThreadContext";

    @Deprecated
    public static final String FACTORY_PRIORITY = "FactoryPriority";
    private static final Logger LOGGER = StatusLogger.getLogger();

    @Deprecated
    public static final String LOGGER_CONTEXT_FACTORY = "LoggerContextFactory";
    public static final String PROVIDER_PROPERTY_NAME = "log4j.provider";

    @Deprecated
    public static final String THREAD_CONTEXT_MAP = "ThreadContextMap";

    @Deprecated
    private final WeakReference<ClassLoader> classLoader;

    @Deprecated
    private final String className;
    private final Class<? extends LoggerContextFactory> loggerContextFactoryClass;
    private final int priority;

    @Deprecated
    private final String threadContextMap;
    private final Class<? extends ThreadContextMap> threadContextMapClass;

    @Deprecated
    private final URL url;
    private final String versions;

    @Deprecated
    public Provider(Properties properties, URL url, ClassLoader classLoader) {
        this.url = url;
        this.classLoader = new WeakReference<>(classLoader);
        String property = properties.getProperty(FACTORY_PRIORITY);
        this.priority = property == null ? -1 : Integer.parseInt(property);
        this.className = properties.getProperty(LOGGER_CONTEXT_FACTORY);
        this.threadContextMap = properties.getProperty(THREAD_CONTEXT_MAP);
        this.loggerContextFactoryClass = null;
        this.threadContextMapClass = null;
        this.versions = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Provider)) {
            return false;
        }
        Provider provider = (Provider) obj;
        return Objects.equals(Integer.valueOf(this.priority), Integer.valueOf(provider.priority)) && Objects.equals(this.className, provider.className) && Objects.equals(this.loggerContextFactoryClass, provider.loggerContextFactoryClass) && Objects.equals(this.versions, provider.versions);
    }

    public String getClassName() {
        Class<? extends LoggerContextFactory> cls = this.loggerContextFactoryClass;
        return cls != null ? cls.getName() : this.className;
    }

    public LoggerContextFactory getLoggerContextFactory() throws ClassNotFoundException {
        Class<? extends LoggerContextFactory> clsLoadLoggerContextFactory = loadLoggerContextFactory();
        if (clsLoadLoggerContextFactory != null) {
            try {
                return (LoggerContextFactory) LoaderUtil.newInstanceOf(clsLoadLoggerContextFactory);
            } catch (ReflectiveOperationException e) {
                LOGGER.error("Failed to instantiate logger context factory {}.", clsLoadLoggerContextFactory.getName(), e);
            }
        }
        LOGGER.error("Falling back to simple logger context factory: {}", SimpleLoggerContextFactory.class.getName());
        return SimpleLoggerContextFactory.INSTANCE;
    }

    public Integer getPriority() {
        return Integer.valueOf(this.priority);
    }

    public String getThreadContextMap() {
        Class<? extends ThreadContextMap> cls = this.threadContextMapClass;
        return cls != null ? cls.getName() : this.threadContextMap;
    }

    public ThreadContextMap getThreadContextMapInstance() throws ClassNotFoundException {
        Class<? extends ThreadContextMap> clsLoadThreadContextMap = loadThreadContextMap();
        if (clsLoadThreadContextMap != null) {
            try {
                return (ThreadContextMap) LoaderUtil.newInstanceOf(clsLoadThreadContextMap);
            } catch (ReflectiveOperationException e) {
                LOGGER.error("Failed to instantiate logger context factory {}.", clsLoadThreadContextMap.getName(), e);
            }
        }
        PropertiesUtil properties = PropertiesUtil.getProperties();
        return (properties.getBooleanProperty(DISABLE_CONTEXT_MAP) || properties.getBooleanProperty(DISABLE_THREAD_CONTEXT)) ? NoOpThreadContextMap.INSTANCE : new DefaultThreadContextMap();
    }

    @Deprecated
    public URL getUrl() {
        return this.url;
    }

    public String getVersions() {
        String str = this.versions;
        return str != null ? str : "";
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.priority), this.className, this.loggerContextFactoryClass, this.versions);
    }

    public Class<? extends LoggerContextFactory> loadLoggerContextFactory() throws ClassNotFoundException {
        Class<? extends LoggerContextFactory> cls = this.loggerContextFactoryClass;
        if (cls != null) {
            return cls;
        }
        String className = getClassName();
        ClassLoader classLoader = this.classLoader.get();
        if (classLoader != null && className != null) {
            try {
                Class<?> clsLoadClass = classLoader.loadClass(className);
                if (LoggerContextFactory.class.isAssignableFrom(clsLoadClass)) {
                    return clsLoadClass.asSubclass(LoggerContextFactory.class);
                }
                LOGGER.error("Class {} specified in {} does not extend {}", className, getUrl(), LoggerContextFactory.class.getName());
            } catch (Exception e) {
                LOGGER.error("Unable to create class {} specified in {}", className, getUrl(), e);
            }
        }
        return null;
    }

    public Class<? extends ThreadContextMap> loadThreadContextMap() throws ClassNotFoundException {
        Class<? extends ThreadContextMap> cls = this.threadContextMapClass;
        if (cls != null) {
            return cls;
        }
        String threadContextMap = getThreadContextMap();
        ClassLoader classLoader = this.classLoader.get();
        if (classLoader != null && threadContextMap != null) {
            try {
                Class<?> clsLoadClass = classLoader.loadClass(threadContextMap);
                if (ThreadContextMap.class.isAssignableFrom(clsLoadClass)) {
                    return clsLoadClass.asSubclass(ThreadContextMap.class);
                }
                LOGGER.error("Class {} specified in {} does not extend {}", threadContextMap, getUrl(), ThreadContextMap.class.getName());
            } catch (Exception e) {
                LOGGER.error("Unable to load class {} specified in {}", threadContextMap, this.url, e);
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Provider '");
        sb.append(getClass().getName());
        sb.append("'");
        if (this.priority != -1) {
            sb.append("\n\tpriority = ");
            sb.append(this.priority);
        }
        String threadContextMap = getThreadContextMap();
        if (threadContextMap != null) {
            sb.append("\n\tthreadContextMap = ");
            sb.append(threadContextMap);
        }
        String className = getClassName();
        if (className != null) {
            sb.append("\n\tloggerContextFactory = ");
            sb.append(className);
        }
        if (this.url != null) {
            sb.append("\n\turl = ");
            sb.append(this.url);
        }
        if (Provider.class.equals(getClass())) {
            ClassLoader classLoader = this.classLoader.get();
            if (classLoader == null) {
                sb.append("\n\tclassLoader = null or not reachable");
            } else {
                sb.append("\n\tclassLoader = ");
                sb.append(classLoader);
            }
        }
        return sb.toString();
    }

    public Provider(Integer num, String str) {
        this(num, str, null, null);
    }

    public Provider(Integer num, String str, Class<? extends LoggerContextFactory> cls) {
        this(num, str, cls, null);
    }

    public Provider(Integer num, String str, Class<? extends LoggerContextFactory> cls, Class<? extends ThreadContextMap> cls2) {
        this.priority = num != null ? num.intValue() : -1;
        this.versions = str;
        this.loggerContextFactoryClass = cls;
        this.threadContextMapClass = cls2;
        this.className = null;
        this.threadContextMap = null;
        this.url = null;
        this.classLoader = new WeakReference<>(null);
    }
}
