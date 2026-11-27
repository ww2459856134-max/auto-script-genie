package h.e.j;

import android.view.WindowInsets;

/* loaded from: classes.dex */
class g1 extends i1 {
    final WindowInsets.Builder c;

    g1() {
        this.c = new WindowInsets.Builder();
    }

    @Override // h.e.j.i1
    e1 b() {
        a();
        e1 e1VarR = e1.r(this.c.build());
        e1VarR.m(this.b);
        return e1VarR;
    }

    @Override // h.e.j.i1
    void c(h.e.d.b bVar) {
        this.c.setMandatorySystemGestureInsets(bVar.d());
    }

    @Override // h.e.j.i1
    void d(h.e.d.b bVar) {
        this.c.setStableInsets(bVar.d());
    }

    @Override // h.e.j.i1
    void e(h.e.d.b bVar) {
        this.c.setSystemGestureInsets(bVar.d());
    }

    @Override // h.e.j.i1
    void f(h.e.d.b bVar) {
        this.c.setSystemWindowInsets(bVar.d());
    }

    @Override // h.e.j.i1
    void g(h.e.d.b bVar) {
        this.c.setTappableElementInsets(bVar.d());
    }

    g1(e1 e1Var) {
        WindowInsets.Builder builder;
        WindowInsets windowInsetsQ = e1Var.q();
        if (windowInsetsQ != null) {
            builder = new WindowInsets.Builder(windowInsetsQ);
        } else {
            builder = new WindowInsets.Builder();
        }
        this.c = builder;
    }
}
