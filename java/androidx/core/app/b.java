package androidx.core.app;

import android.app.Activity;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ Activity c;

    b(Activity activity) {
        this.c = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.isFinishing() || l.i(this.c)) {
            return;
        }
        this.c.recreate();
    }
}
