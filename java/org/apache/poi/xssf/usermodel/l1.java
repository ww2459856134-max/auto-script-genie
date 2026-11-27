package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
final class l1 implements n.a.a.n.c.l {
    private final n.a.a.n.c.o a;
    private final z0 b;

    public l1(z0 z0Var, n1 n1Var) {
        this.b = z0Var;
        this.a = n1Var;
    }

    @Override // n.a.a.n.c.l
    public int a() {
        return this.b.a();
    }

    @Override // n.a.a.n.c.l
    public n.a.a.n.d.j b() {
        return this.b.b();
    }

    @Override // n.a.a.n.c.l
    public boolean c() {
        return this.b.c();
    }

    @Override // n.a.a.n.c.l
    public double d() {
        return this.b.d();
    }

    @Override // n.a.a.n.c.l
    public boolean e() {
        return this.b.e();
    }

    @Override // n.a.a.n.c.l
    public n.a.a.n.e.m f() {
        return this.b.f();
    }

    @Override // n.a.a.n.c.l
    public int g() {
        return this.b.g();
    }

    @Override // n.a.a.n.c.l
    public n.a.a.n.c.o getSheet() {
        return this.a;
    }

    @Override // n.a.a.n.c.l
    public n.a.a.n.d.j h() {
        return this.b.h();
    }

    @Override // n.a.a.n.c.l
    public int i() {
        return this.b.i();
    }

    @Override // n.a.a.n.c.l
    public Object j() {
        return this.b;
    }

    @Override // n.a.a.n.c.l
    public String k() {
        return this.b.q().getString();
    }

    public z0 l() {
        return this.b;
    }

    public l1(z0 z0Var) {
        this(z0Var, new n1(z0Var.getSheet()));
    }
}
