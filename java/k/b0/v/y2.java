package k.b0.v;

/* loaded from: classes.dex */
class y2 {
    private k.b0.p a = null;
    private k.b0.p b = null;
    private k.b0.m c = null;
    private k.b0.m d = null;
    private k.b0.m e = null;
    private k.b0.m f;

    static {
        k.y.c.b(y2.class);
    }

    private synchronized void h() {
        this.a = new k.b0.p(k.b0.t.a);
    }

    private synchronized void i() {
        this.f = new k.b0.m(k.b0.e.b);
    }

    private synchronized void j() {
        this.e = new k.b0.m(a(), new k.b0.c(";;;"));
    }

    private synchronized void k() {
        this.b = new k.b0.p(k.b0.t.b);
    }

    private synchronized void l() {
        this.d = new k.b0.m(e(), k.b0.j.a);
    }

    private synchronized void m() {
        k.b0.m mVar = new k.b0.m(a(), k.b0.j.a);
        this.c = mVar;
        mVar.Q(a());
    }

    public k.b0.p a() {
        if (this.a == null) {
            h();
        }
        return this.a;
    }

    public k.b0.m b() {
        if (this.f == null) {
            i();
        }
        return this.f;
    }

    public k.x.h1 c(k.x.h1 h1Var) {
        if (h1Var == k.b0.t.c) {
            h1Var = g();
        } else if (h1Var == k.b0.t.d) {
            h1Var = f();
        } else if (h1Var == k.b0.t.e) {
            h1Var = d();
        } else if (h1Var == z.f1986o) {
            h1Var = b();
        }
        if (h1Var.getFont() == k.b0.t.a) {
            h1Var.Q(a());
        } else if (h1Var.getFont() == k.b0.t.b) {
            h1Var.Q(e());
        }
        return h1Var;
    }

    public k.b0.m d() {
        if (this.e == null) {
            j();
        }
        return this.e;
    }

    public k.b0.p e() {
        if (this.b == null) {
            k();
        }
        return this.b;
    }

    public k.b0.m f() {
        if (this.d == null) {
            l();
        }
        return this.d;
    }

    public k.b0.m g() {
        if (this.c == null) {
            m();
        }
        return this.c;
    }
}
