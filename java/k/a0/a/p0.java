package k.a0.a;

/* loaded from: classes.dex */
class p0 extends o {

    /* renamed from: n, reason: collision with root package name */
    public static final o0 f1830n;

    /* renamed from: l, reason: collision with root package name */
    private o f1831l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1832m;

    static {
        k.y.c.b(p0.class);
        f1830n = new o0();
    }

    public p0(f2 f2Var, j0 j0Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var, k.w wVar) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        this.f1832m = false;
        if ((k.x.s0.c(bArrC[14], bArrC[15]) & 8) == 0) {
            if (bArrC[6] == 0 && bArrC[12] == -1 && bArrC[13] == -1) {
                this.f1831l = new a3(f2Var, j0Var, n0Var, tVar, a1Var, y2Var, wVar);
                return;
            }
            if (bArrC[6] == 1 && bArrC[12] == -1 && bArrC[13] == -1) {
                this.f1831l = new f(f2Var, n0Var, tVar, a1Var, y2Var);
                return;
            }
            if (bArrC[6] == 2 && bArrC[12] == -1 && bArrC[13] == -1) {
                this.f1831l = new b0(f2Var, n0Var, tVar, a1Var, y2Var);
                return;
            } else if (bArrC[6] == 3 && bArrC[12] == -1 && bArrC[13] == -1) {
                this.f1831l = new a3(f2Var, n0Var, tVar, a1Var, y2Var);
                return;
            } else {
                this.f1831l = new q1(f2Var, n0Var, tVar, a1Var, y2Var);
                return;
            }
        }
        this.f1832m = true;
        if (bArrC[6] == 0 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new x2(f2Var, j0Var, n0Var, tVar, a1Var, y2Var, wVar);
            return;
        }
        if (bArrC[6] == 3 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new x2(f2Var, j0Var, n0Var, tVar, a1Var, y2Var, x2.q);
            return;
        }
        if (bArrC[6] == 2 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new s2(f2Var, j0Var, bArrC[8], n0Var, tVar, a1Var, y2Var);
            return;
        }
        if (bArrC[6] == 1 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new q2(f2Var, j0Var, bArrC[8] == 1, n0Var, tVar, a1Var, y2Var);
            return;
        }
        u2 u2Var = new u2(f2Var, j0Var, k.x.c0.b(bArrC, 6), n0Var, tVar, a1Var, y2Var);
        u2Var.G(n0Var.f(z()));
        this.f1831l = u2Var;
    }

    final o A() {
        return this.f1831l;
    }

    final boolean B() {
        return this.f1832m;
    }

    @Override // k.c
    public k.f getType() {
        k.y.a.a(false);
        return k.f.b;
    }

    @Override // k.c
    public String p() {
        k.y.a.a(false);
        return "";
    }

    public p0(f2 f2Var, j0 j0Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, o0 o0Var, y2 y2Var, k.w wVar) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        this.f1832m = false;
        if (bArrC[6] == 0 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new a3(f2Var, j0Var, n0Var, tVar, a1Var, y2Var, wVar);
            return;
        }
        if (bArrC[6] == 1 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new f(f2Var, n0Var, tVar, a1Var, y2Var);
        } else if (bArrC[6] == 2 && bArrC[12] == -1 && bArrC[13] == -1) {
            this.f1831l = new b0(f2Var, n0Var, tVar, a1Var, y2Var);
        } else {
            this.f1831l = new q1(f2Var, n0Var, tVar, a1Var, y2Var);
        }
    }
}
