package com.auto.exceldeps.log4j;

import com.auto.exceldeps.log4j.internal.LogManagerStatus;
import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.message.StringFormatterMessageFactory;
import com.auto.exceldeps.log4j.simple.SimpleLoggerContextFactory;
import com.auto.exceldeps.log4j.spi.LoggerContext;
import com.auto.exceldeps.log4j.spi.LoggerContextFactory;
import com.auto.exceldeps.log4j.spi.Terminable;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.ProviderUtil;
import com.auto.exceldeps.log4j.util.StackLocatorUtil;
import java.net.URI;

/* loaded from: classes.dex */
public class LogManager {

    @Deprecated
    public static final String FACTORY_PROPERTY_NAME = "log4j2.loggerContextFactory";
    public static final String ROOT_LOGGER_NAME = "";
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final String FQCN = LogManager.class.getName();
    private static volatile LoggerContextFactory factory = ProviderUtil.getProvider().getLoggerContextFactory();

    static {
        LogManagerStatus.setInitialized(true);
    }

    protected LogManager() {
    }

    private static Class<?> callerClass(Class<?> cls) {
        if (cls != null) {
            return cls;
        }
        Class<?> callerClass = StackLocatorUtil.getCallerClass(3);
        if (callerClass != null) {
            return callerClass;
        }
        throw new UnsupportedOperationException("No class provided, and an appropriate one cannot be found.");
    }

    public static boolean exists(String str) {
        return getContext().hasLogger(str);
    }

    public static LoggerContext getContext() {
        try {
            return factory.getContext(FQCN, null, null, true);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, null, null, true);
        }
    }

    public static LoggerContextFactory getFactory() {
        return factory;
    }

    public static Logger getFormatterLogger() {
        return getFormatterLogger(StackLocatorUtil.getCallerClass(2));
    }

    public static Logger getLogger() {
        return getLogger(StackLocatorUtil.getCallerClass(2));
    }

    public static Logger getRootLogger() {
        return getLogger("");
    }

    public static void setFactory(LoggerContextFactory loggerContextFactory) {
        factory = loggerContextFactory;
    }

    public static void shutdown() {
        shutdown(false);
    }

    public static Logger getFormatterLogger(Class<?> cls) {
        if (cls == null) {
            cls = StackLocatorUtil.getCallerClass(2);
        }
        return getLogger(cls, (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getLogger(Class<?> cls) {
        Class<?> clsCallerClass = callerClass(cls);
        return getContext(clsCallerClass.getClassLoader(), false).getLogger(clsCallerClass);
    }

    public static void shutdown(boolean z) {
        factory.shutdown(FQCN, null, z, false);
    }

    public static void shutdown(boolean z, boolean z2) {
        factory.shutdown(FQCN, null, z, z2);
    }

    public static LoggerContext getContext(boolean z) {
        try {
            return factory.getContext(FQCN, null, null, z, null, null);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, null, null, z, null, null);
        }
    }

    public static Logger getFormatterLogger(Object obj) {
        return getLogger(obj != null ? obj.getClass() : StackLocatorUtil.getCallerClass(2), (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getLogger(Class<?> cls, MessageFactory messageFactory) {
        Class<?> clsCallerClass = callerClass(cls);
        return getContext(clsCallerClass.getClassLoader(), false).getLogger(clsCallerClass, messageFactory);
    }

    public static void shutdown(LoggerContext loggerContext) {
        if (loggerContext instanceof Terminable) {
            ((Terminable) loggerContext).terminate();
        }
    }

    public static Logger getFormatterLogger(String str) {
        if (str == null) {
            return getFormatterLogger(StackLocatorUtil.getCallerClass(2));
        }
        return getLogger(str, (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getLogger(MessageFactory messageFactory) {
        return getLogger(StackLocatorUtil.getCallerClass(2), messageFactory);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z) {
        try {
            return factory.getContext(FQCN, classLoader, null, z);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, null, z);
        }
    }

    public static Logger getLogger(Object obj) {
        return getLogger(obj != null ? obj.getClass() : StackLocatorUtil.getCallerClass(2));
    }

    public static Logger getLogger(Object obj, MessageFactory messageFactory) {
        return getLogger(obj != null ? obj.getClass() : StackLocatorUtil.getCallerClass(2), messageFactory);
    }

    public static Logger getLogger(String str) {
        return str != null ? getContext(false).getLogger(str) : getLogger(StackLocatorUtil.getCallerClass(2));
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z, Object obj) {
        try {
            return factory.getContext(FQCN, classLoader, obj, z);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, obj, z);
        }
    }

    public static Logger getLogger(String str, MessageFactory messageFactory) {
        if (str != null) {
            return getContext(false).getLogger(str, messageFactory);
        }
        return getLogger(StackLocatorUtil.getCallerClass(2), messageFactory);
    }

    protected static Logger getLogger(String str, String str2) {
        return factory.getContext(str, null, null, false).getLogger(str2);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z, URI uri) {
        try {
            return factory.getContext(FQCN, classLoader, null, z, uri, null);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, null, z, uri, null);
        }
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z, Object obj, URI uri) {
        try {
            return factory.getContext(FQCN, classLoader, obj, z, uri, null);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, obj, z, uri, null);
        }
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z, Object obj, URI uri, String str) {
        try {
            return factory.getContext(FQCN, classLoader, obj, z, uri, str);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, obj, z, uri, str);
        }
    }

    protected static LoggerContext getContext(String str, boolean z) {
        try {
            return factory.getContext(str, null, null, z);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(str, null, null, z);
        }
    }

    protected static LoggerContext getContext(String str, ClassLoader classLoader, boolean z) {
        try {
            return factory.getContext(str, classLoader, null, z);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(str, classLoader, null, z);
        }
    }

    protected static LoggerContext getContext(String str, ClassLoader classLoader, boolean z, URI uri, String str2) {
        try {
            return factory.getContext(str, classLoader, null, z, uri, str2);
        } catch (IllegalStateException e) {
            LOGGER.warn("{} Using SimpleLogger", e.getMessage());
            return SimpleLoggerContextFactory.INSTANCE.getContext(str, classLoader, null, z);
        }
    }
}
