package com.bumptech.glide.load.x;

import android.os.Process;

/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ Runnable c;

    a(b bVar, Runnable runnable) {
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        this.c.run();
    }
}
