package k.b0.v;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;

/* loaded from: classes.dex */
public abstract class o extends k.x.c1 implements k.b0.k {

    /* renamed from: k, reason: collision with root package name */
    private static k.y.c f1916k = k.y.c.b(o.class);
    private int c;
    private int d;
    private k.x.h1 e;
    private k.x.n0 f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private p3 f1917h;

    /* renamed from: i, reason: collision with root package name */
    private k.b0.l f1918i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1919j;

    protected o(k.x.z0 z0Var, int i2, int i3) {
        this(z0Var, i2, i3, k.b0.t.c);
        this.f1919j = false;
    }

    private void B() {
        y2 y2VarT = this.f1917h.o().t();
        k.x.h1 h1VarC = y2VarT.c(this.e);
        this.e = h1VarC;
        try {
            if (h1VarC.isInitialized()) {
                return;
            }
            this.f.b(this.e);
        } catch (k.x.u0 unused) {
            f1916k.f("Maximum number of format records exceeded.  Using default format.");
            this.e = y2VarT.g();
        }
    }

    public final void A() {
        k.b0.l lVar = this.f1918i;
        if (lVar == null) {
            return;
        }
        if (this.f1919j) {
            this.f1919j = false;
            return;
        }
        if (lVar.b() != null) {
            k.x.i1.k kVar = new k.x.i1.k(this.f1918i.b(), this.d, this.c);
            kVar.x(this.f1918i.d());
            kVar.t(this.f1918i.c());
            this.f1917h.e(kVar);
            this.f1917h.o().i(kVar);
            this.f1918i.k(kVar);
        }
        if (this.f1918i.f()) {
            try {
                this.f1918i.e().h(this.d, this.c, this.f1917h.o(), this.f1917h.o(), this.f1917h.p());
            } catch (k.x.j1.w unused) {
                k.y.a.a(false);
            }
            this.f1917h.f(this);
            if (this.f1918i.g()) {
                if (this.f1917h.m() == null) {
                    k.x.i1.j jVar = new k.x.i1.j();
                    this.f1917h.e(jVar);
                    this.f1917h.o().i(jVar);
                    this.f1917h.v(jVar);
                }
                this.f1918i.j(this.f1917h.m());
            }
        }
    }

    public p3 C() {
        return this.f1917h;
    }

    final int D() {
        return this.e.I();
    }

    final boolean E() {
        return this.g;
    }

    public final void F(k.x.i1.k kVar) {
        this.f1917h.u(kVar);
    }

    public final void G() {
        this.f1917h.t(this);
    }

    void H(k.x.n0 n0Var, u2 u2Var, p3 p3Var) {
        this.g = true;
        this.f1917h = p3Var;
        this.f = n0Var;
        B();
        A();
    }

    @Override // k.c
    public int b() {
        return this.d;
    }

    @Override // k.c, k.a0.a.n
    public k.d c() {
        return this.f1918i;
    }

    @Override // k.b0.k
    public void d(k.b0.l lVar) {
        if (this.f1918i != null) {
            f1916k.f("current cell features for " + k.e.b(this) + " not null - overwriting");
            if (this.f1918i.f() && this.f1918i.e() != null && this.f1918i.e().b()) {
                k.x.w wVarE = this.f1918i.e();
                f1916k.f("Cannot add cell features to " + k.e.b(this) + " because it is part of the shared cell validation group " + k.e.a(wVarE.d(), wVarE.e()) + ProcessIdUtil.DEFAULT_PROCESSID + k.e.a(wVarE.f(), wVarE.g()));
                return;
            }
        }
        this.f1918i = lVar;
        lVar.n(this);
        if (this.g) {
            A();
        }
    }

    @Override // k.c
    public k.z.d e() {
        return this.e;
    }

    @Override // k.c
    public int getRow() {
        return this.c;
    }

    @Override // k.b0.k
    public void o(k.z.d dVar) {
        this.e = (k.x.h1) dVar;
        if (this.g) {
            k.y.a.a(this.f != null);
            B();
        }
    }

    @Override // k.b0.k
    public k.b0.l u() {
        return this.f1918i;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[6];
        k.x.s0.f(this.c, bArr, 0);
        k.x.s0.f(this.d, bArr, 2);
        k.x.s0.f(this.e.I(), bArr, 4);
        return bArr;
    }

    protected o(k.x.z0 z0Var, k.c cVar) {
        this(z0Var, cVar.b(), cVar.getRow());
        this.f1919j = true;
        this.e = (k.x.h1) cVar.e();
        if (cVar.c() != null) {
            k.b0.l lVar = new k.b0.l(cVar.c());
            this.f1918i = lVar;
            lVar.n(this);
        }
    }

    protected o(k.x.z0 z0Var, int i2, int i3, k.z.d dVar) {
        super(z0Var);
        this.c = i3;
        this.d = i2;
        this.e = (k.x.h1) dVar;
        this.g = false;
        this.f1919j = false;
    }
}
