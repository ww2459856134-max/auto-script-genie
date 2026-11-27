package com.bumptech.glide.load.x.i1;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class c implements ThreadFactory {
    private final String a;
    final e b;
    final boolean c;
    private int d;

    c(String str, e eVar, boolean z) {
        this.a = str;
        this.b = eVar;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public synchronized Thread newThread(Runnable runnable) {
        b bVar;
        bVar = new b(this, runnable, "glide-" + this.a + "-thread-" + this.d);
        this.d = this.d + 1;
        return bVar;
    }
}
