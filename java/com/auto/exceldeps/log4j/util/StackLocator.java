package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

@InternalApi
/* loaded from: classes.dex */
public final class StackLocator {
    private static final Class<?> DEFAULT_CALLER_CLASS;
    private static final Method GET_CALLER_CLASS_METHOD;
    private static final StackLocator INSTANCE;
    static final int JDK_7U25_OFFSET;
    private static final Logger LOGGER;

    static {
        StatusLogger logger = StatusLogger.getLogger();
        LOGGER = logger;
        Method method = null;
        DEFAULT_CALLER_CLASS = null;
        int i2 = -1;
        try {
            Class<?> cls = Class.forName("sun.reflect.Reflection", true, ClassLoader.getSystemClassLoader());
            Method declaredMethod = cls.getDeclaredMethod("getCallerClass", Integer.TYPE);
            Object objInvoke = declaredMethod.invoke(null, 0);
            declaredMethod.invoke(null, 0);
            if (objInvoke != null && objInvoke == cls) {
                if (declaredMethod.invoke(null, 1) == cls) {
                    logger.warn("Unexpected result from `sun.reflect.Reflection.getCallerClass(int)`, adjusting offset for future calls.");
                    method = declaredMethod;
                    i2 = 1;
                } else {
                    method = declaredMethod;
                    i2 = 0;
                }
            }
        } catch (Exception | LinkageError unused) {
            LOGGER.warn(System.getProperty("java.version", "").startsWith("1.8") ? "`sun.reflect.Reflection.getCallerClass(int)` is not supported. This will impact location-based features." : "Runtime environment or build system does not support multi-release JARs. This will impact location-based features.");
        }
        GET_CALLER_CLASS_METHOD = method;
        JDK_7U25_OFFSET = i2;
        INSTANCE = new StackLocator();
    }

    private StackLocator() {
    }

    public static StackLocator getInstance() {
        return INSTANCE;
    }

    private boolean isValid(StackTraceElement stackTraceElement) {
        if (stackTraceElement.isNativeMethod()) {
            return false;
        }
        String className = stackTraceElement.getClassName();
        if (className.startsWith("sun.reflect.")) {
            return false;
        }
        String methodName = stackTraceElement.getMethodName();
        if ((className.startsWith("java.lang.reflect.") && (methodName.equals("invoke") || methodName.equals("newInstance"))) || className.startsWith("jdk.internal.reflect.")) {
            return false;
        }
        if (className.equals("java.lang.Class") && methodName.equals("newInstance")) {
            return false;
        }
        return (className.equals("java.lang.invoke.MethodHandle") && methodName.startsWith("invoke")) ? false : true;
    }

    public StackTraceElement calcLocation(String str) {
        if (str == null) {
            return null;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        boolean z = false;
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            String className = stackTrace[i2].getClassName();
            if (str.equals(className)) {
                z = true;
            } else if (z && !str.equals(className)) {
                return stackTrace[i2];
            }
        }
        return null;
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(Class<?> cls, Predicate<Class<?>> predicate) {
        if (cls == null) {
            throw new IllegalArgumentException("sentinelClass cannot be null");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("callerPredicate cannot be null");
        }
        boolean z = false;
        int i2 = 2;
        while (true) {
            Class<?> callerClass = getCallerClass(i2);
            if (callerClass == null) {
                return DEFAULT_CALLER_CLASS;
            }
            if (cls.equals(callerClass)) {
                z = true;
            } else if (z && predicate.test(callerClass)) {
                return callerClass;
            }
            i2++;
        }
    }

    @PerformanceSensitive
    public Deque<Class<?>> getCurrentStackTrace() {
        if (PrivateSecurityManagerStackTraceUtil.isEnabled()) {
            return PrivateSecurityManagerStackTraceUtil.getCurrentStackTrace();
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i2 = 1;
        while (true) {
            Class<?> callerClass = getCallerClass(i2);
            if (callerClass == null) {
                return arrayDeque;
            }
            arrayDeque.addLast(callerClass);
            i2++;
        }
    }

    public StackTraceElement getStackTraceElement(int i2) {
        int i3 = 0;
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (isValid(stackTraceElement)) {
                if (i3 == i2) {
                    return stackTraceElement;
                }
                i3++;
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(i2));
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(int i2) {
        if (i2 >= 0) {
            Method method = GET_CALLER_CLASS_METHOD;
            if (method == null) {
                return DEFAULT_CALLER_CLASS;
            }
            try {
                return (Class) method.invoke(null, Integer.valueOf(i2 + 1 + JDK_7U25_OFFSET));
            } catch (Exception unused) {
                return DEFAULT_CALLER_CLASS;
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(i2));
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(String str, String str2) {
        boolean z = false;
        int i2 = 2;
        while (true) {
            Class<?> callerClass = getCallerClass(i2);
            if (callerClass != null) {
                if (str.equals(callerClass.getName())) {
                    z = true;
                } else if (z && callerClass.getName().startsWith(str2)) {
                    return callerClass;
                }
                i2++;
            } else {
                return DEFAULT_CALLER_CLASS;
            }
        }
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(Class<?> cls) {
        boolean z = false;
        int i2 = 2;
        while (true) {
            Class<?> callerClass = getCallerClass(i2);
            if (callerClass != null) {
                if (cls.equals(callerClass)) {
                    z = true;
                } else if (z) {
                    return callerClass;
                }
                i2++;
            } else {
                return Object.class;
            }
        }
    }
}
