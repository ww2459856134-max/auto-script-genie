package com.google.gson.internal;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class o<T> implements i0<T> {
    final /* synthetic */ Class a;

    o(z zVar, Class cls) {
        this.a = cls;
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        try {
            return (T) y0.a.d(this.a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create instance of " + this.a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }
}
