package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;

/* loaded from: classes.dex */
class l0 extends n0 {
    private final PowerManager c;
    final /* synthetic */ t0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l0(t0 t0Var, Context context) {
        super(t0Var);
        this.d = t0Var;
        this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // androidx.appcompat.app.n0
    IntentFilter b() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.n0
    public int c() {
        return (Build.VERSION.SDK_INT < 21 || !h0.a(this.c)) ? 1 : 2;
    }

    @Override // androidx.appcompat.app.n0
    public void d() {
        this.d.F();
    }
}
