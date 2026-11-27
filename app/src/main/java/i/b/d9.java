package i.b;

import android.media.projection.MediaProjection;
import android.util.Log;

/* loaded from: classes.dex */
class d9 extends MediaProjection.Callback {
    final /* synthetic */ i9 a;

    d9(i9 i9Var) {
        this.a = i9Var;
    }

    @Override // android.media.projection.MediaProjection.Callback
    public void onStop() {
        com.frame.y0.j("MediaProjectionStopCallback->onStop");
        if (this.a.g != h9.RUNNING) {
            com.frame.l1.i(1993);
            Log.i(this.a.a, "onStop: ");
            if (this.a.f1498i != null) {
                this.a.f1498i.unregisterCallback(this);
            }
            Log.i(this.a.a, "onStop1: ");
            if (this.a.f1500k != null) {
                this.a.f1500k.close();
            }
            Log.i(this.a.a, "onStop2: ");
            if (this.a.f1499j != null) {
                this.a.f1499j.release();
            }
            Log.i(this.a.a, "onStop3: ");
            if (this.a.f1503n) {
                this.a.f1503n = false;
                i9 i9Var = this.a;
                i9Var.p0(i9Var.f1501l, this.a.f1502m);
            } else {
                i9 i9Var2 = this.a;
                i9Var2.g = h9.IDLE;
                i9Var2.c = null;
            }
        }
        this.a.g = h9.IDLE;
    }
}
