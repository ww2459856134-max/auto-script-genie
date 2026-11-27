package com.bumptech.glide.z.l;

import android.util.Log;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class i implements ViewTreeObserver.OnPreDrawListener {
    private final WeakReference<j> c;

    i(j jVar) {
        this.c = new WeakReference<>(jVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
        }
        j jVar = this.c.get();
        if (jVar == null) {
            return true;
        }
        jVar.a();
        return true;
    }
}
