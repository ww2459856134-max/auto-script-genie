package k.b0.v;

/* loaded from: classes.dex */
abstract class e2 extends o implements k.x.o0 {

    /* renamed from: n, reason: collision with root package name */
    private static k.y.c f1897n = k.y.c.b(e2.class);

    /* renamed from: l, reason: collision with root package name */
    private k.x.o0 f1898l;

    /* renamed from: m, reason: collision with root package name */
    private k.x.j1.x f1899m;

    protected e2(k.x.o0 o0Var) {
        super(k.x.z0.E, o0Var);
        this.f1898l = o0Var;
    }

    @Override // k.b0.v.o
    void H(k.x.n0 n0Var, u2 u2Var, p3 p3Var) {
        super.H(n0Var, u2Var, p3Var);
        p3Var.o().l(this);
    }

    protected final byte[] I() {
        return super.y();
    }

    protected k.x.o0 J() {
        return this.f1898l;
    }

    protected byte[] K() {
        byte[] bArrY = super.y();
        q3 q3VarO = C().o();
        k.x.j1.x xVar = new k.x.j1.x(p(), q3VarO, q3VarO, q3VarO.r());
        this.f1899m = xVar;
        try {
            xVar.c();
        } catch (k.x.j1.w e) {
            f1897n.f(e.getMessage());
            k.x.j1.x xVar2 = new k.x.j1.x("\"ERROR\"", q3VarO, q3VarO, q3VarO.r());
            this.f1899m = xVar2;
            try {
                xVar2.c();
            } catch (k.x.j1.w unused) {
                k.y.a.a(false);
            }
        }
        byte[] bArrA = this.f1899m.a();
        int length = bArrA.length + 16;
        byte[] bArr = new byte[length];
        k.x.s0.f(bArrA.length, bArr, 14);
        System.arraycopy(bArrA, 0, bArr, 16, bArrA.length);
        bArr[8] = (byte) (bArr[8] | 2);
        byte[] bArr2 = new byte[bArrY.length + length];
        System.arraycopy(bArrY, 0, bArr2, 0, bArrY.length);
        System.arraycopy(bArr, 0, bArr2, bArrY.length, length);
        return bArr2;
    }

    @Override // k.c
    public k.f getType() {
        return this.f1898l.getType();
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        byte[] bArrJ = this.f1898l.j();
        byte[] bArr = new byte[bArrJ.length];
        System.arraycopy(bArrJ, 0, bArr, 0, bArrJ.length);
        bArr[8] = (byte) (bArr[8] | 2);
        return bArr;
    }

    @Override // k.c
    public String p() {
        return this.f1898l.p();
    }

    @Override // k.b0.v.o, k.x.c1
    public byte[] y() {
        byte[] bArrJ;
        byte[] bArrY = super.y();
        try {
            k.x.j1.x xVar = this.f1899m;
            if (xVar == null) {
                bArrJ = this.f1898l.j();
            } else {
                byte[] bArrA = xVar.a();
                byte[] bArr = new byte[bArrA.length + 16];
                k.x.s0.f(bArrA.length, bArr, 14);
                System.arraycopy(bArrA, 0, bArr, 16, bArrA.length);
                bArrJ = bArr;
            }
            bArrJ[8] = (byte) (bArrJ[8] | 2);
            byte[] bArr2 = new byte[bArrY.length + bArrJ.length];
            System.arraycopy(bArrY, 0, bArr2, 0, bArrY.length);
            System.arraycopy(bArrJ, 0, bArr2, bArrY.length, bArrJ.length);
            return bArr2;
        } catch (k.x.j1.w e) {
            f1897n.f(k.e.a(b(), getRow()) + " " + e.getMessage());
            return K();
        }
    }
}
