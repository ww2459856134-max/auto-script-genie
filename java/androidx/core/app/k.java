package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class k implements Application.ActivityLifecycleCallbacks {
    Object a;
    private Activity b;
    private final int c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;

    k(Activity activity) {
        this.b = activity;
        this.c = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.b == activity) {
            this.b = null;
            this.e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (!this.e || this.f || this.d || !l.h(this.a, this.c, activity)) {
            return;
        }
        this.f = true;
        this.a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.b == activity) {
            this.d = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
