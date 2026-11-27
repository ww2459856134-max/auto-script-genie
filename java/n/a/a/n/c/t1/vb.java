package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class vb implements p6 {
    protected static final n.a.a.n.d.w a = new n.a.a.n.d.w();
    public static final p6 b = new jb();
    public static final p6 c = new kb();
    public static final p6 d = new lb();
    public static final p6 e = new mb();
    public static final p6 f = new nb();
    public static final p6 g = new ob();

    /* renamed from: h, reason: collision with root package name */
    public static final p6 f2407h = new pb();

    /* renamed from: i, reason: collision with root package name */
    public static final p6 f2408i = new qb();

    /* renamed from: j, reason: collision with root package name */
    public static final p6 f2409j = new sb(true);

    /* renamed from: k, reason: collision with root package name */
    public static final p6 f2410k = new sb(false);

    /* renamed from: l, reason: collision with root package name */
    public static final j6 f2411l = new j6() { // from class: n.a.a.n.c.t1.r0
        @Override // n.a.a.n.c.t1.j6
        public final n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
            return vb.c(w0VarArr, t0Var);
        }
    };

    /* renamed from: m, reason: collision with root package name */
    public static final p6 f2412m = new p6() { // from class: n.a.a.n.c.t1.q0
        @Override // n.a.a.n.c.t1.p6
        public final n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
            return vb.d(w0VarArr, i2, i3);
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final p6 f2413n = new rb();

    /* renamed from: o, reason: collision with root package name */
    public static final p6 f2414o = new ib();
    public static final p6 p = new tb(true);
    public static final p6 q = new tb(false);

    protected static int a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
    }

    protected static String b(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
    }

    static /* synthetic */ n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        StringBuilder sb = new StringBuilder();
        for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
            try {
                if (w0Var instanceof n.a.a.n.c.r1.j) {
                    n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
                    for (int i2 = 0; i2 < jVar.a(); i2++) {
                        for (int i3 = 0; i3 < jVar.getWidth(); i3++) {
                            sb.append(b(jVar.k(i2, i3), t0Var.t(), t0Var.k()));
                        }
                    }
                } else {
                    sb.append(b(w0Var, t0Var.t(), t0Var.k()));
                }
            } catch (n.a.a.n.c.r1.p e2) {
                return e2.a();
            }
        }
        return new n.a.a.n.c.r1.m0(sb.toString());
    }

    static /* synthetic */ n.a.a.n.c.r1.w0 d(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
            try {
                sb.append(b(w0Var, i2, i3));
            } catch (n.a.a.n.c.r1.p e2) {
                return e2.a();
            }
        }
        return new n.a.a.n.c.r1.m0(sb.toString());
    }
}
