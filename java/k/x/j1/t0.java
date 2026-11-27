package k.x.j1;

/* loaded from: classes.dex */
abstract class t0 {
    private t0 a;
    private boolean b = false;
    private boolean c = false;
    private s0 d = s0.a;

    abstract byte[] a();

    protected final s0 b() {
        return this.d;
    }

    abstract void c(StringBuffer stringBuffer);

    final boolean d() {
        return this.b;
    }

    protected void e() {
        this.c = true;
    }

    protected void f(t0 t0Var) {
        this.a = t0Var;
    }

    protected void g(s0 s0Var) {
        this.d = s0Var;
    }

    protected void h() {
        this.b = true;
        t0 t0Var = this.a;
        if (t0Var == null || t0Var.d()) {
            return;
        }
        this.a.h();
    }

    protected final boolean i() {
        return this.c;
    }
}
