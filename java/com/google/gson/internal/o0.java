package com.google.gson.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes.dex */
abstract class o0 {
    public static final o0 a;

    static {
        o0 m0Var;
        if (a0.d()) {
            try {
                m0Var = new m0(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
            }
        } else {
            m0Var = null;
        }
        if (m0Var == null) {
            m0Var = new n0();
        }
        a = m0Var;
    }

    private o0() {
    }

    public abstract boolean a(AccessibleObject accessibleObject, Object obj);
}
