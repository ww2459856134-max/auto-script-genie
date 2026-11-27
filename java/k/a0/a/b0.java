package k.a0.a;

/* loaded from: classes.dex */
class b0 extends o implements k.i, k.x.o0, k.j {

    /* renamed from: l, reason: collision with root package name */
    private int f1784l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f1785m;

    /* renamed from: n, reason: collision with root package name */
    private k.x.j1.u f1786n;

    public b0(f2 f2Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        this.f1785m = bArrC;
        k.y.a.a(bArrC[6] == 2);
        this.f1784l = this.f1785m[8];
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1993k;
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (!y().y().A()) {
            throw new k.x.j1.w(k.x.j1.w.e);
        }
        byte[] bArr = this.f1785m;
        byte[] bArr2 = new byte[bArr.length - 6];
        System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        if (this.f1786n == null) {
            this.f1786n = k.x.j1.u.c(this.f1784l);
        }
        k.x.j1.u uVar = this.f1786n;
        if (uVar != k.x.j1.u.d) {
            return uVar.b();
        }
        return "ERROR " + this.f1784l;
    }

    @Override // k.i
    public int q() {
        return this.f1784l;
    }
}
