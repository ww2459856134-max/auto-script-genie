package k.a0.a;

/* loaded from: classes.dex */
public class s2 extends b implements k.i, k.x.o0, k.j {
    private int p;
    private k.x.j1.u q;

    static {
        k.y.c.b(s2.class);
    }

    public s2(f2 f2Var, j0 j0Var, int i2, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        super(f2Var, n0Var, tVar, a1Var, y2Var, j0Var.c());
        this.p = i2;
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
        k.x.j1.x xVar = new k.x.j1.x(D(), this, A(), C(), y().x().A());
        xVar.c();
        byte[] bArrA = xVar.a();
        int length = bArrA.length + 22;
        byte[] bArr = new byte[length];
        k.x.s0.f(getRow(), bArr, 0);
        k.x.s0.f(b(), bArr, 2);
        k.x.s0.f(z(), bArr, 4);
        bArr[6] = 2;
        bArr[8] = (byte) this.p;
        bArr[12] = -1;
        bArr[13] = -1;
        System.arraycopy(bArrA, 0, bArr, 22, bArrA.length);
        k.x.s0.f(bArrA.length, bArr, 20);
        int i2 = length - 6;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 6, bArr2, 0, i2);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        if (this.q == null) {
            this.q = k.x.j1.u.c(this.p);
        }
        k.x.j1.u uVar = this.q;
        if (uVar != k.x.j1.u.d) {
            return uVar.b();
        }
        return "ERROR " + this.p;
    }

    @Override // k.i
    public int q() {
        return this.p;
    }
}
