package androidx.appcompat.app;

import android.view.View;

/* loaded from: classes.dex */
class a0 extends h.e.j.b1 {
    final /* synthetic */ b0 a;

    a0(b0 b0Var) {
        this.a = b0Var;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        this.a.c.I.setAlpha(1.0f);
        this.a.c.M.f(null);
        this.a.c.M = null;
    }

    @Override // h.e.j.b1, h.e.j.a1
    public void c(View view) {
        this.a.c.I.setVisibility(0);
    }
}
