package k.a0.a;

/* loaded from: classes.dex */
class g extends o implements k.a {

    /* renamed from: l, reason: collision with root package name */
    private boolean f1807l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1808m;

    public g(f2 f2Var, k.x.n0 n0Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        this.f1807l = false;
        this.f1808m = false;
        byte[] bArrC = x().c();
        boolean z = bArrC[7] == 1;
        this.f1807l = z;
        if (z) {
            return;
        }
        this.f1808m = bArrC[6] == 1;
    }

    public boolean A() {
        return this.f1807l;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.e;
    }

    @Override // k.a
    public boolean getValue() {
        return this.f1808m;
    }

    @Override // k.c
    public String p() {
        k.y.a.a(!A());
        return new Boolean(this.f1808m).toString();
    }

    @Override // k.x.w0
    public f2 x() {
        return super.x();
    }
}
