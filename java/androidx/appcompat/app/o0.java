package androidx.appcompat.app;

import android.content.IntentFilter;

/* loaded from: classes.dex */
class o0 extends n0 {
    private final c1 c;
    final /* synthetic */ t0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    o0(t0 t0Var, c1 c1Var) {
        super(t0Var);
        this.d = t0Var;
        this.c = c1Var;
    }

    @Override // androidx.appcompat.app.n0
    IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.n0
    public int c() {
        return this.c.d() ? 2 : 1;
    }

    @Override // androidx.appcompat.app.n0
    public void d() {
        this.d.F();
    }
}
