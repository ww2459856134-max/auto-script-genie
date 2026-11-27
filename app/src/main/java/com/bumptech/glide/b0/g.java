package com.bumptech.glide.b0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class g implements Executor {
    private final Handler a = new Handler(Looper.getMainLooper());

    g() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
