package k.a0.a;

/* loaded from: classes.dex */
class a3 extends o implements k.o, k.x.o0, k.u {

    /* renamed from: l, reason: collision with root package name */
    private String f1778l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f1779m;

    static {
        k.y.c.b(a3.class);
    }

    public a3(f2 f2Var, j0 j0Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var, k.w wVar) {
        super(f2Var, n0Var, y2Var);
        this.f1779m = x().c();
        int iC = j0Var.c();
        f2 f2VarE = j0Var.e();
        int i2 = 0;
        while (f2VarE.e() != k.x.z0.D && i2 < 4) {
            f2VarE = j0Var.e();
            i2++;
        }
        k.y.a.b(i2 < 4, " @ " + iC);
        byte[] bArrC = f2VarE.c();
        f2 f2VarF = j0Var.f();
        while (f2VarF.e() == k.x.z0.v) {
            f2 f2VarE2 = j0Var.e();
            byte[] bArr = new byte[(bArrC.length + f2VarE2.d()) - 1];
            System.arraycopy(bArrC, 0, bArr, 0, bArrC.length);
            System.arraycopy(f2VarE2.c(), 1, bArr, bArrC.length, f2VarE2.d() - 1);
            f2VarF = j0Var.f();
            bArrC = bArr;
        }
        A(bArrC, wVar);
    }

    private void A(byte[] bArr, k.w wVar) {
        int iC = k.x.s0.c(bArr[0], bArr[1]);
        if (iC == 0) {
            this.f1778l = "";
            return;
        }
        int i2 = 2;
        byte b = bArr[2];
        if ((b & 15) != b) {
            iC = k.x.s0.c(bArr[0], (byte) 0);
            b = bArr[1];
        } else {
            i2 = 3;
        }
        boolean z = (b & 4) != 0;
        if ((b & 8) != 0) {
            i2 += 2;
        }
        if (z) {
            i2 += 4;
        }
        if ((b & 1) == 0) {
            this.f1778l = k.x.y0.d(bArr, iC, i2, wVar);
        } else {
            this.f1778l = k.x.y0.g(bArr, iC, i2);
        }
    }

    @Override // k.o
    public String getString() {
        return this.f1778l;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1991i;
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (!y().x().d().A()) {
            throw new k.x.j1.w(k.x.j1.w.e);
        }
        byte[] bArr = this.f1779m;
        byte[] bArr2 = new byte[bArr.length - 6];
        System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        return this.f1778l;
    }

    public a3(f2 f2Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        this.f1779m = x().c();
        this.f1778l = "";
    }
}
