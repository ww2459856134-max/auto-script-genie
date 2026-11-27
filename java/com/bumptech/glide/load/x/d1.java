package com.bumptech.glide.load.x;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
class d1 {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new c1());

    d1() {
    }

    synchronized void a(z0<?> z0Var, boolean z) {
        if (this.a || z) {
            this.b.obtainMessage(1, z0Var).sendToTarget();
        } else {
            this.a = true;
            z0Var.a();
            this.a = false;
        }
    }
}
