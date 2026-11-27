package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
class w0 extends y0 {
    final /* synthetic */ Method b;

    w0(Method method) {
        this.b = method;
    }

    @Override // com.google.gson.internal.y0
    public <T> T d(Class<T> cls) throws Exception {
        y0.b(cls);
        return (T) this.b.invoke(null, cls, Object.class);
    }
}
