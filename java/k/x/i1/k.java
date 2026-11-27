package k.x.i1;

import java.io.IOException;
import k.x.y0;

/* loaded from: classes.dex */
public class k implements w {
    private static k.y.c x = k.y.c.b(k.class);
    private y a;
    private y b;
    private e0 c;
    private h0 d;
    private boolean e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2080h;

    /* renamed from: i, reason: collision with root package name */
    private int f2081i;

    /* renamed from: j, reason: collision with root package name */
    private double f2082j;

    /* renamed from: k, reason: collision with root package name */
    private double f2083k;

    /* renamed from: l, reason: collision with root package name */
    private k0 f2084l;

    /* renamed from: m, reason: collision with root package name */
    private v f2085m;

    /* renamed from: n, reason: collision with root package name */
    private t f2086n;

    /* renamed from: o, reason: collision with root package name */
    private l0 f2087o;
    private int p;
    private e0 q;
    private s0 r;
    private f0 s;
    private k.x.r t;
    private k.x.r u;
    private String v;
    private k.w w;

    public k(e0 e0Var, h0 h0Var, t tVar, v vVar, k.w wVar) {
        boolean z = false;
        this.e = false;
        this.f2085m = vVar;
        this.c = e0Var;
        this.f2086n = tVar;
        this.d = h0Var;
        this.e = false;
        this.w = wVar;
        this.f2084l = k0.a;
        tVar.a(e0Var.y());
        this.p = this.f2086n.c() - 1;
        this.f2085m.f(this);
        if (this.c != null && this.d != null) {
            z = true;
        }
        k.y.a.a(z);
        if (this.e) {
            return;
        }
        r();
    }

    private y n() {
        if (!this.e) {
            r();
        }
        return this.a;
    }

    private void r() {
        y yVarD = this.f2086n.d(this.p);
        this.a = yVarD;
        k.y.a.a(yVarD != null);
        z[] zVarArrN = this.a.n();
        n0 n0Var = (n0) this.a.n()[0];
        this.f = this.d.C();
        this.g = n0Var.m();
        l0 l0VarA = l0.a(n0Var.n());
        this.f2087o = l0VarA;
        if (l0VarA == l0.g) {
            x.f("Unknown shape type");
        }
        g gVar = null;
        for (int i2 = 0; i2 < zVarArrN.length && gVar == null; i2++) {
            if (zVarArrN[i2].h() == b0.f2046o) {
                gVar = (g) zVarArrN[i2];
            }
        }
        if (gVar == null) {
            x.f("client anchor not found");
        } else {
            this.f2080h = ((int) gVar.n()) - 1;
            this.f2081i = ((int) gVar.p()) + 1;
            this.f2082j = gVar.o() - gVar.n();
            this.f2083k = gVar.q() - gVar.p();
        }
        this.e = true;
    }

    @Override // k.x.i1.w
    public e0 a() {
        return this.c;
    }

    @Override // k.x.i1.w
    public void b(k.b0.v.l0 l0Var) throws IOException {
        if (this.f2084l == k0.a) {
            l0Var.e(this.d);
            e0 e0Var = this.q;
            if (e0Var != null) {
                l0Var.e(e0Var);
            }
            l0Var.e(this.r);
            l0Var.e(this.t);
            k.x.r rVar = this.u;
            if (rVar != null) {
                l0Var.e(rVar);
                return;
            }
            return;
        }
        l0Var.e(new h0(this.f, h0.f2071m));
        l0Var.e(new e0(new i().b()));
        l0Var.e(new s0(p()));
        byte[] bArr = new byte[(this.v.length() * 2) + 1];
        bArr[0] = 1;
        y0.e(this.v, bArr, 1);
        l0Var.e(new k.x.r(bArr));
        byte[] bArr2 = new byte[16];
        k.x.s0.f(0, bArr2, 0);
        k.x.s0.f(0, bArr2, 2);
        k.x.s0.f(this.v.length(), bArr2, 8);
        k.x.s0.f(0, bArr2, 10);
        l0Var.e(new k.x.r(bArr2));
    }

    @Override // k.x.i1.w
    public final int c() {
        if (!this.e) {
            r();
        }
        return this.f;
    }

    @Override // k.x.i1.w
    public boolean d() {
        return true;
    }

    @Override // k.x.i1.w
    public String e() {
        k.y.a.a(false);
        return null;
    }

    @Override // k.x.i1.w
    public boolean f() {
        return this.c.A();
    }

    @Override // k.x.i1.w
    public y g() {
        if (!this.e) {
            r();
        }
        if (this.f2084l == k0.a) {
            return n();
        }
        if (this.b == null) {
            this.b = new o0();
            this.b.m(new n0(this.f2087o, this.g, 2560));
            j0 j0Var = new j0();
            j0Var.m(344, false, false, 0);
            j0Var.m(385, false, false, 134217808);
            j0Var.m(387, false, false, 134217808);
            j0Var.m(959, false, false, 131074);
            this.b.m(j0Var);
            this.b.m(new g(this.f2080h + 1.3d, Math.max(0.0d, this.f2081i - 0.6d), this.f2080h + 1.3d + this.f2082j, this.f2081i + this.f2083k, 1));
            this.b.m(new h());
            this.b.m(new i());
        }
        return this.b;
    }

    @Override // k.x.i1.w
    public k0 getOrigin() {
        return this.f2084l;
    }

    @Override // k.x.i1.w
    public final int getShapeId() {
        if (!this.e) {
            r();
        }
        return this.g;
    }

    @Override // k.x.i1.w
    public void h(k.b0.v.l0 l0Var) throws IOException {
        if (this.f2084l == k0.a) {
            l0Var.e(this.s);
        } else {
            l0Var.e(new f0(this.f2080h, this.f2081i, this.f));
        }
    }

    public int hashCode() {
        return this.v.hashCode();
    }

    @Override // k.x.i1.w
    public final void i(int i2, int i3, int i4) {
        this.f = i2;
        this.g = i4;
        if (this.f2084l == k0.a) {
            this.f2084l = k0.c;
        }
    }

    @Override // k.x.i1.w
    public void j(v vVar) {
        this.f2085m = vVar;
    }

    public void k(e0 e0Var) {
        this.q = e0Var;
        this.f2086n.b(e0Var.y());
    }

    public int l() {
        return this.s.b();
    }

    public double m() {
        if (!this.e) {
            r();
        }
        return this.f2083k;
    }

    public int o() {
        return this.s.getRow();
    }

    public String p() {
        if (this.v == null) {
            k.y.a.a(this.t != null);
            byte[] bArrY = this.t.y();
            if (bArrY[0] == 0) {
                this.v = y0.d(bArrY, bArrY.length - 1, 1, this.w);
            } else {
                this.v = y0.g(bArrY, (bArrY.length - 1) / 2, 1);
            }
        }
        return this.v;
    }

    public double q() {
        if (!this.e) {
            r();
        }
        return this.f2082j;
    }

    public void s(k.x.r rVar) {
        this.u = rVar;
    }

    public void t(double d) {
        if (this.f2084l == k0.a) {
            if (!this.e) {
                r();
            }
            this.f2084l = k0.c;
        }
        this.f2083k = d;
    }

    public void u(f0 f0Var) {
        this.s = f0Var;
    }

    public void v(k.x.r rVar) {
        this.t = rVar;
    }

    public void w(s0 s0Var) {
        this.r = s0Var;
    }

    public void x(double d) {
        if (this.f2084l == k0.a) {
            if (!this.e) {
                r();
            }
            this.f2084l = k0.c;
        }
        this.f2082j = d;
    }

    public k(w wVar, v vVar, k.w wVar2) {
        this.e = false;
        k kVar = (k) wVar;
        k0 k0Var = kVar.f2084l;
        k0 k0Var2 = k0.a;
        k.y.a.a(k0Var == k0Var2);
        this.c = kVar.c;
        this.d = kVar.d;
        this.e = false;
        this.f2084l = k0Var2;
        this.f2086n = kVar.f2086n;
        this.f2085m = vVar;
        this.p = kVar.p;
        vVar.f(this);
        this.q = kVar.q;
        this.r = kVar.r;
        this.t = kVar.t;
        this.u = kVar.u;
        this.s = kVar.s;
        this.f2082j = kVar.f2082j;
        this.f2083k = kVar.f2083k;
        this.w = wVar2;
    }

    public k(String str, int i2, int i3) {
        this.e = false;
        this.e = true;
        this.f2084l = k0.b;
        this.f2080h = i2;
        this.f2081i = i3;
        this.f2087o = l0.f;
        this.v = str;
        this.f2082j = 3.0d;
        this.f2083k = 4.0d;
    }
}
