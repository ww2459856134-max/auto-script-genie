package com.google.gson.internal;

import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class j<T> implements i0<T> {
    j() {
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        return (T) new ConcurrentSkipListMap();
    }
}
