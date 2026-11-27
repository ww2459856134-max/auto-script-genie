package com.bumptech.glide.b0;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class h implements Executor {
    h() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
