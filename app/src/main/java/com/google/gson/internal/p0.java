package com.google.gson.internal;

import com.google.gson.b0;
import java.lang.reflect.AccessibleObject;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class p0 {
    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return o0.a.a(accessibleObject, obj);
    }

    public static b0.a b(List<com.google.gson.b0> list, Class<?> cls) {
        Iterator<com.google.gson.b0> it = list.iterator();
        while (it.hasNext()) {
            b0.a aVarA = it.next().a(cls);
            if (aVarA != b0.a.INDECISIVE) {
                return aVarA;
            }
        }
        return b0.a.ALLOW;
    }
}
