package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* loaded from: classes.dex */
abstract class n0 {
    private BroadcastReceiver a;
    final /* synthetic */ t0 b;

    n0(t0 t0Var) {
        this.b = t0Var;
    }

    void a() {
        BroadcastReceiver broadcastReceiver = this.a;
        if (broadcastReceiver != null) {
            try {
                this.b.g.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.a = null;
        }
    }

    abstract IntentFilter b();

    abstract int c();

    abstract void d();

    void e() {
        a();
        IntentFilter intentFilterB = b();
        if (intentFilterB == null || intentFilterB.countActions() == 0) {
            return;
        }
        if (this.a == null) {
            this.a = new m0(this);
        }
        this.b.g.registerReceiver(this.a, intentFilterB);
    }
}
