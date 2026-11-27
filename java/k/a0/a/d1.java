package k.a0.a;

/* loaded from: classes.dex */
class d1 extends o implements k.o {

    /* renamed from: n, reason: collision with root package name */
    public static c1 f1793n = new c1();

    /* renamed from: l, reason: collision with root package name */
    private int f1794l;

    /* renamed from: m, reason: collision with root package name */
    private String f1795m;

    public d1(f2 f2Var, k.x.n0 n0Var, y2 y2Var, k.w wVar) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        int iC = k.x.s0.c(bArrC[6], bArrC[7]);
        this.f1794l = iC;
        if (bArrC[8] == 0) {
            this.f1795m = k.x.y0.d(bArrC, iC, 9, wVar);
        } else {
            this.f1795m = k.x.y0.g(bArrC, iC, 9);
        }
    }

    @Override // k.o
    public String getString() {
        return this.f1795m;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.c;
    }

    @Override // k.c
    public String p() {
        return this.f1795m;
    }

    public d1(f2 f2Var, k.x.n0 n0Var, y2 y2Var, k.w wVar, c1 c1Var) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        int iC = k.x.s0.c(bArrC[6], bArrC[7]);
        this.f1794l = iC;
        this.f1795m = k.x.y0.d(bArrC, iC, 8, wVar);
    }
}
