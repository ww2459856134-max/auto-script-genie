package com.auto.exceldeps.log4j.util;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/* loaded from: classes.dex */
final class PrivateSecurityManagerStackTraceUtil {
    private static final PrivateSecurityManager SECURITY_MANAGER;

    private static final class PrivateSecurityManager extends SecurityManager {
        private PrivateSecurityManager() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PrivateSecurityManager privateSecurityManager = null;
        Object[] objArr = 0;
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(new RuntimePermission("createSecurityManager"));
            }
            privateSecurityManager = new PrivateSecurityManager();
        } catch (SecurityException unused) {
        }
        SECURITY_MANAGER = privateSecurityManager;
    }

    private PrivateSecurityManagerStackTraceUtil() {
    }

    static Deque<Class<?>> getCurrentStackTrace() {
        Class<?>[] classContext = SECURITY_MANAGER.getClassContext();
        ArrayDeque arrayDeque = new ArrayDeque(classContext.length);
        Collections.addAll(arrayDeque, classContext);
        return arrayDeque;
    }

    static boolean isEnabled() {
        return SECURITY_MANAGER != null;
    }
}
