package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
class v0 extends y0 {
    final /* synthetic */ Method b;
    final /* synthetic */ int c;

    v0(Method method, int i2) {
        this.b = method;
        this.c = i2;
    }

    @Override // com.google.gson.internal.y0
    public <T> T d(Class<T> cls) throws Exception {
        y0.b(cls);
        return (T) this.b.invoke(null, cls, Integer.valueOf(this.c));
    }
}
