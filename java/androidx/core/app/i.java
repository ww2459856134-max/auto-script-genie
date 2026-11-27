package androidx.core.app;

import android.app.Application;

/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ Application c;
    final /* synthetic */ k d;

    i(Application application, k kVar) {
        this.c = application;
        this.d = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.unregisterActivityLifecycleCallbacks(this.d);
    }
}
