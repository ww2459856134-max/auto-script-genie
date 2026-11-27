package k.a0.a;

/* loaded from: classes.dex */
class f extends o implements k.a, k.x.o0, k.b {

    /* renamed from: l, reason: collision with root package name */
    private boolean f1805l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f1806m;

    public f(f2 f2Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        this.f1805l = false;
        byte[] bArrC = x().c();
        this.f1806m = bArrC;
        k.y.a.a(bArrC[6] != 2);
        this.f1805l = this.f1806m[8] == 1;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1992j;
    }

    @Override // k.a
    public boolean getValue() {
        return this.f1805l;
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (!y().y().A()) {
            throw new k.x.j1.w(k.x.j1.w.e);
        }
        byte[] bArr = this.f1806m;
        byte[] bArr2 = new byte[bArr.length - 6];
        System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        return new Boolean(this.f1805l).toString();
    }
}
