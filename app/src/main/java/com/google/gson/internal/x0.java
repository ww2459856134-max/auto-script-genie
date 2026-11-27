package com.google.gson.internal;

/* loaded from: classes.dex */
class x0 extends y0 {
    x0() {
    }

    @Override // com.google.gson.internal.y0
    public <T> T d(Class<T> cls) {
        throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
    }
}
