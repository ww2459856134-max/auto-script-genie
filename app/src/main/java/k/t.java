package k;

import k.x.x0;

/* loaded from: classes.dex */
public final class t {
    private static final k.z.i S = k.z.i.a;
    private static final k.z.h T = k.z.h.b;
    private static final k.z.j U = k.z.j.c;
    private boolean A;
    private String B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private r O;
    private r P;
    private r Q;
    private s R;
    private k.z.i a;
    private k.z.h b;
    private k.z.j c;
    private boolean d;
    private boolean e;
    private boolean f;
    private l g;

    /* renamed from: h, reason: collision with root package name */
    private double f1995h;

    /* renamed from: i, reason: collision with root package name */
    private l f1996i;

    /* renamed from: j, reason: collision with root package name */
    private double f1997j;

    /* renamed from: k, reason: collision with root package name */
    private int f1998k;

    /* renamed from: l, reason: collision with root package name */
    private int f1999l;

    /* renamed from: m, reason: collision with root package name */
    private int f2000m;

    /* renamed from: n, reason: collision with root package name */
    private int f2001n;

    /* renamed from: o, reason: collision with root package name */
    private int f2002o;
    private int p;
    private int q;
    private double r;
    private double s;
    private double t;
    private double u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public t(s sVar) {
        this.R = sVar;
        this.a = S;
        this.b = T;
        this.c = U;
        this.d = false;
        this.e = false;
        this.f = false;
        this.f1995h = 0.5d;
        this.f1997j = 0.5d;
        this.p = 300;
        this.q = 300;
        this.r = 0.75d;
        this.s = 0.75d;
        this.t = 1.0d;
        this.u = 1.0d;
        this.v = false;
        this.w = true;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = true;
        this.D = 8;
        this.E = 255;
        this.f1999l = 100;
        this.M = 60;
        this.N = 100;
        this.F = 0;
        this.G = 0;
        this.J = 1;
        this.g = new l();
        this.f1996i = new l();
        this.K = true;
        this.L = true;
    }

    public int A() {
        return this.C;
    }

    public void A0(boolean z) {
        this.f = z;
    }

    public r B() {
        return this.O;
    }

    public void B0(boolean z) {
        this.w = z;
    }

    public boolean C() {
        return this.x;
    }

    public void C0(double d) {
        this.t = d;
    }

    public boolean D() {
        return this.y;
    }

    public void D0(boolean z) {
        this.H = z;
    }

    public r E() {
        return this.Q;
    }

    public void E0(int i2) {
        this.G = Math.max(i2, 0);
    }

    public r F() {
        return this.P;
    }

    public void F0(int i2) {
        this.q = i2;
    }

    public boolean G() {
        return this.L;
    }

    public void G0(int i2) {
        this.f1999l = i2;
    }

    public double H() {
        return this.s;
    }

    public int I() {
        return this.f1998k;
    }

    public boolean J() {
        return this.w;
    }

    public double K() {
        return this.t;
    }

    public int L() {
        return this.G;
    }

    public int M() {
        return this.q;
    }

    public int N() {
        return this.f1999l;
    }

    public boolean O() {
        return this.e;
    }

    public boolean P() {
        return this.I;
    }

    public boolean Q() {
        return this.d;
    }

    public boolean R() {
        return this.f;
    }

    public boolean S() {
        return this.H;
    }

    public void T(boolean z) {
        this.K = z;
    }

    public void U(double d) {
        this.u = d;
    }

    public void V(int i2) {
        this.J = i2;
    }

    public void W(int i2) {
        this.D = i2;
    }

    public void X(int i2) {
        this.E = i2;
    }

    public void Y(boolean z) {
        this.A = z;
    }

    public void Z(int i2) {
        this.f2002o = i2;
        this.v = true;
    }

    public boolean a() {
        return this.K;
    }

    public void a0(boolean z) {
        this.v = z;
    }

    public double b() {
        return this.u;
    }

    public void b0(int i2) {
        this.f2001n = i2;
        this.v = true;
    }

    public int c() {
        return this.J;
    }

    public void c0(l lVar) {
        this.f1996i = lVar;
    }

    public int d() {
        return this.D;
    }

    public void d0(double d) {
        this.f1997j = d;
    }

    public double e() {
        return 1.0d;
    }

    public void e0(l lVar) {
        this.g = lVar;
    }

    public int f() {
        return this.E;
    }

    public void f0(double d) {
        this.f1995h = d;
    }

    public double g() {
        return 0.75d;
    }

    public void g0(boolean z) {
        this.e = z;
    }

    public boolean h() {
        return this.A;
    }

    public void h0(boolean z) {
        this.I = z;
    }

    public int i() {
        return this.f2002o;
    }

    public void i0(int i2) {
        this.F = Math.max(i2, 0);
    }

    public boolean j() {
        return this.v;
    }

    public void j0(int i2) {
        this.p = i2;
    }

    public int k() {
        return this.f2001n;
    }

    public void k0(double d) {
        this.r = d;
    }

    public l l() {
        return this.f1996i;
    }

    public void l0(k.z.i iVar) {
        this.a = iVar;
    }

    public double m() {
        return this.f1997j;
    }

    public void m0(boolean z) {
        this.z = z;
    }

    public l n() {
        return this.g;
    }

    public void n0(k.z.h hVar) {
        this.b = hVar;
    }

    public double o() {
        return this.f1995h;
    }

    public void o0(int i2) {
        this.f2000m = i2;
    }

    public int p() {
        return this.F;
    }

    public void p0(k.z.j jVar) {
        this.c = jVar;
    }

    public int q() {
        return this.p;
    }

    public void q0(int i2) {
        this.C = i2;
    }

    public double r() {
        return this.r;
    }

    public void r0(int i2, int i3, int i4, int i5) {
        this.O = new x0(this.R, i2, i3, i4, i5);
    }

    public int s() {
        return this.N;
    }

    public void s0(boolean z) {
        this.x = z;
    }

    public k.z.i t() {
        return this.a;
    }

    public void t0(boolean z) {
        this.y = z;
    }

    public int u() {
        return this.M;
    }

    public void u0(int i2, int i3) {
        this.Q = new x0(this.R, i2, 0, i3, 65535);
    }

    public boolean v() {
        return this.z;
    }

    public void v0(int i2, int i3) {
        this.P = new x0(this.R, 0, i2, 255, i3);
    }

    public k.z.h w() {
        return this.b;
    }

    public void w0(boolean z) {
        this.d = z;
    }

    public int x() {
        return this.f2000m;
    }

    public void x0(boolean z) {
        this.L = z;
    }

    public k.z.j y() {
        return this.c;
    }

    public void y0(double d) {
        this.s = d;
    }

    public String z() {
        return this.B;
    }

    public void z0(int i2) {
        this.f1998k = i2;
        this.v = false;
    }

    public t(t tVar, s sVar) {
        k.y.a.a(tVar != null);
        this.R = sVar;
        this.a = tVar.a;
        this.b = tVar.b;
        this.c = tVar.c;
        this.d = tVar.d;
        this.e = tVar.e;
        this.f = false;
        this.f1995h = tVar.f1995h;
        this.f1997j = tVar.f1997j;
        this.f1998k = tVar.f1998k;
        this.f2000m = tVar.f2000m;
        this.f2001n = tVar.f2001n;
        this.f2002o = tVar.f2002o;
        this.p = tVar.p;
        this.q = tVar.q;
        this.r = tVar.r;
        this.s = tVar.s;
        this.t = tVar.t;
        this.u = tVar.u;
        this.v = tVar.v;
        this.B = tVar.B;
        this.C = tVar.C;
        this.D = tVar.D;
        this.E = tVar.E;
        this.f1999l = tVar.f1999l;
        this.M = tVar.M;
        this.N = tVar.N;
        this.w = tVar.w;
        this.A = tVar.A;
        this.z = tVar.z;
        this.F = tVar.F;
        this.G = tVar.G;
        this.I = tVar.I;
        this.H = tVar.H;
        this.J = tVar.J;
        this.g = new l(tVar.g);
        this.f1996i = new l(tVar.f1996i);
        this.K = tVar.K;
        this.L = tVar.L;
        if (tVar.O != null) {
            this.O = new x0(this.R, tVar.B().getTopLeft().b(), tVar.B().getTopLeft().getRow(), tVar.B().getBottomRight().b(), tVar.B().getBottomRight().getRow());
        }
        if (tVar.P != null) {
            this.P = new x0(this.R, tVar.F().getTopLeft().b(), tVar.F().getTopLeft().getRow(), tVar.F().getBottomRight().b(), tVar.F().getBottomRight().getRow());
        }
        if (tVar.Q != null) {
            this.Q = new x0(this.R, tVar.E().getTopLeft().b(), tVar.E().getTopLeft().getRow(), tVar.E().getBottomRight().b(), tVar.E().getBottomRight().getRow());
        }
    }
}
