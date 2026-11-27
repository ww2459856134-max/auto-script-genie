package k.a0.a;

/* loaded from: classes.dex */
class e1 extends o implements k.o {

    /* renamed from: l, reason: collision with root package name */
    private int f1800l;

    /* renamed from: m, reason: collision with root package name */
    private String f1801m;

    public e1(f2 f2Var, n2 n2Var, k.x.n0 n0Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        int iD = k.x.s0.d(bArrC[6], bArrC[7], bArrC[8], bArrC[9]);
        this.f1800l = iD;
        this.f1801m = n2Var.A(iD);
    }

    @Override // k.o
    public String getString() {
        return this.f1801m;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.c;
    }

    @Override // k.c
    public String p() {
        return this.f1801m;
    }
}
