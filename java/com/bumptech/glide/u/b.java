package com.bumptech.glide.u;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class b implements ThreadFactory {
    private b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, "glide-disk-lru-cache-thread");
        thread.setPriority(1);
        return thread;
    }

    /* synthetic */ b(a aVar) {
        this();
    }
}
