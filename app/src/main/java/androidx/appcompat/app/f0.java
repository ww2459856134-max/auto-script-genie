package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;

/* loaded from: classes.dex */
class f0 implements h.a.o.b {
    private h.a.o.b a;
    final /* synthetic */ t0 b;

    public f0(t0 t0Var, h.a.o.b bVar) {
        this.b = t0Var;
        this.a = bVar;
    }

    @Override // h.a.o.b
    public boolean a(h.a.o.c cVar, Menu menu) {
        return this.a.a(cVar, menu);
    }

    @Override // h.a.o.b
    public boolean b(h.a.o.c cVar, MenuItem menuItem) {
        return this.a.b(cVar, menuItem);
    }

    @Override // h.a.o.b
    public boolean c(h.a.o.c cVar, Menu menu) {
        h.e.j.s0.W(this.b.Q);
        return this.a.c(cVar, menu);
    }

    @Override // h.a.o.b
    public void d(h.a.o.c cVar) {
        this.a.d(cVar);
        t0 t0Var = this.b;
        if (t0Var.J != null) {
            t0Var.f41h.getDecorView().removeCallbacks(this.b.K);
        }
        t0 t0Var2 = this.b;
        if (t0Var2.I != null) {
            t0Var2.V();
            t0 t0Var3 = this.b;
            h.e.j.z0 z0VarB = h.e.j.s0.b(t0Var3.I);
            z0VarB.a(0.0f);
            t0Var3.M = z0VarB;
            this.b.M.f(new e0(this));
        }
        t0 t0Var4 = this.b;
        t tVar = t0Var4.f43j;
        if (tVar != null) {
            tVar.n(t0Var4.H);
        }
        t0 t0Var5 = this.b;
        t0Var5.H = null;
        h.e.j.s0.W(t0Var5.Q);
    }
}
