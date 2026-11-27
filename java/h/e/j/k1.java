package h.e.j;

import android.view.WindowInsets;

/* loaded from: classes.dex */
class k1 extends j1 {

    /* renamed from: m, reason: collision with root package name */
    private h.e.d.b f1314m;

    k1(e1 e1Var, WindowInsets windowInsets) {
        super(e1Var, windowInsets);
        this.f1314m = null;
    }

    @Override // h.e.j.o1
    e1 b() {
        return e1.r(this.c.consumeStableInsets());
    }

    @Override // h.e.j.o1
    e1 c() {
        return e1.r(this.c.consumeSystemWindowInsets());
    }

    @Override // h.e.j.o1
    final h.e.d.b g() {
        if (this.f1314m == null) {
            this.f1314m = h.e.d.b.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
        }
        return this.f1314m;
    }

    @Override // h.e.j.o1
    boolean j() {
        return this.c.isConsumed();
    }

    @Override // h.e.j.o1
    public void o(h.e.d.b bVar) {
        this.f1314m = bVar;
    }

    k1(e1 e1Var, k1 k1Var) {
        super(e1Var, k1Var);
        this.f1314m = null;
        this.f1314m = k1Var.f1314m;
    }
}
