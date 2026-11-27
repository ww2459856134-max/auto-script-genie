package com.google.gson.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class k<T> implements i0<T> {
    k() {
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        return (T) new ConcurrentHashMap();
    }
}
