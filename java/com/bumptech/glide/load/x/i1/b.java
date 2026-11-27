package com.bumptech.glide.load.x.i1;

import android.os.Process;
import android.os.StrictMode;

/* loaded from: classes.dex */
class b extends Thread {
    final /* synthetic */ c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(c cVar, Runnable runnable, String str) {
        super(runnable, str);
        this.c = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(9);
        if (this.c.c) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            this.c.b.a(th);
        }
    }
}
