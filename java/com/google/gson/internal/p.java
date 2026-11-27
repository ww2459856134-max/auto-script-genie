package com.google.gson.internal;

import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class p<T> implements i0<T> {
    final /* synthetic */ com.google.gson.l a;
    final /* synthetic */ Type b;

    p(z zVar, com.google.gson.l lVar, Type type) {
        this.a = lVar;
        this.b = type;
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        return (T) this.a.a(this.b);
    }
}
