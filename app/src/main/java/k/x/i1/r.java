package k.x.i1;

import java.io.IOException;

/* loaded from: classes.dex */
public class r implements w {
    private y a;
    private e0 b;
    private boolean c;
    private int d;
    private k0 e = k0.a;
    private v f;
    private t g;

    /* renamed from: h, reason: collision with root package name */
    private int f2088h;

    static {
        k.y.c.b(s.class);
    }

    public r(e0 e0Var, t tVar, v vVar) {
        this.c = false;
        this.f = vVar;
        this.b = e0Var;
        this.g = tVar;
        this.c = false;
        tVar.b(e0Var.y());
        this.f.f(this);
        k.y.a.a(e0Var != null);
        l();
    }

    private y k() {
        if (!this.c) {
            l();
        }
        return this.a;
    }

    private void l() {
        this.c = true;
    }

    @Override // k.x.i1.w
    public e0 a() {
        return this.b;
    }

    @Override // k.x.i1.w
    public void b(k.b0.v.l0 l0Var) throws IOException {
    }

    @Override // k.x.i1.w
    public final int c() {
        if (!this.c) {
            l();
        }
        return this.d;
    }

    @Override // k.x.i1.w
    public boolean d() {
        return false;
    }

    @Override // k.x.i1.w
    public String e() {
        k.y.a.a(false);
        return null;
    }

    @Override // k.x.i1.w
    public boolean f() {
        return this.b.A();
    }

    @Override // k.x.i1.w
    public y g() {
        if (!this.c) {
            l();
        }
        k.y.a.a(this.e == k0.a);
        return k();
    }

    @Override // k.x.i1.w
    public k0 getOrigin() {
        return this.e;
    }

    @Override // k.x.i1.w
    public int getShapeId() {
        if (!this.c) {
            l();
        }
        return this.f2088h;
    }

    @Override // k.x.i1.w
    public void h(k.b0.v.l0 l0Var) throws IOException {
    }

    @Override // k.x.i1.w
    public final void i(int i2, int i3, int i4) {
        this.d = i2;
        this.f2088h = i4;
        if (this.e == k0.a) {
            this.e = k0.c;
        }
    }

    @Override // k.x.i1.w
    public void j(v vVar) {
        this.f = vVar;
    }
}
