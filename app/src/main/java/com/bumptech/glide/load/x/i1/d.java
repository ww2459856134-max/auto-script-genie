package com.bumptech.glide.load.x.i1;

import android.util.Log;

/* loaded from: classes.dex */
class d implements e {
    d() {
    }

    @Override // com.bumptech.glide.load.x.i1.e
    public void a(Throwable th) {
        if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
            return;
        }
        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
    }
}
