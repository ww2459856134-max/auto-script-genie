package com.google.gson.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class m0 extends o0 {
    final /* synthetic */ Method b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m0(Method method) {
        super();
        this.b = method;
    }

    @Override // com.google.gson.internal.o0
    public boolean a(AccessibleObject accessibleObject, Object obj) {
        try {
            return ((Boolean) this.b.invoke(accessibleObject, obj)).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException("Failed invoking canAccess", e);
        }
    }
}
