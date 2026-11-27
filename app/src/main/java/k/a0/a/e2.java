package k.a0.a;

/* loaded from: classes.dex */
class e2 extends o implements k.o {

    /* renamed from: n, reason: collision with root package name */
    public static d2 f1802n = new d2();

    /* renamed from: l, reason: collision with root package name */
    private int f1803l;

    /* renamed from: m, reason: collision with root package name */
    private String f1804m;

    public e2(f2 f2Var, k.x.n0 n0Var, y2 y2Var, k.w wVar, d2 d2Var) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        int iC = k.x.s0.c(bArrC[6], bArrC[7]);
        this.f1803l = iC;
        this.f1804m = k.x.y0.d(bArrC, iC, 8, wVar);
    }

    @Override // k.o
    public String getString() {
        return this.f1804m;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.c;
    }

    @Override // k.c
    public String p() {
        return this.f1804m;
    }
}
