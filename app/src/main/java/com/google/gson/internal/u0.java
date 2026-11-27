package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
class u0 extends y0 {
    final /* synthetic */ Method b;
    final /* synthetic */ Object c;

    u0(Method method, Object obj) {
        this.b = method;
        this.c = obj;
    }

    @Override // com.google.gson.internal.y0
    public <T> T d(Class<T> cls) throws Exception {
        y0.b(cls);
        return (T) this.b.invoke(this.c, cls);
    }
}
