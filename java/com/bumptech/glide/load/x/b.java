package com.bumptech.glide.load.x;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
class b implements ThreadFactory {
    b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(new a(this, runnable), "glide-active-resources");
    }
}
