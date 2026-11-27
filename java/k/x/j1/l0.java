package k.x.j1;

/* loaded from: classes.dex */
class l0 extends p0 {
    private k.x.a1 e;
    private String f;
    private int g;

    static {
        k.y.c.b(l0.class);
    }

    public l0(k.x.a1 a1Var) {
        this.e = a1Var;
        k.y.a.a(a1Var != null);
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[5];
        i1 i1Var = i1.p;
        bArr[0] = i1Var.e();
        if (b() == s0.b) {
            bArr[0] = i1Var.c();
        }
        k.x.s0.f(this.g, bArr, 1);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.f);
    }

    public int j(byte[] bArr, int i2) throws w {
        try {
            int iC = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
            this.g = iC;
            this.f = this.e.b(iC - 1);
            return 4;
        } catch (k.x.t0 unused) {
            throw new w(w.f2148i, "");
        }
    }

    public l0(String str, k.x.a1 a1Var) throws w {
        this.f = str;
        this.e = a1Var;
        int iE = a1Var.e(str);
        this.g = iE;
        if (iE >= 0) {
            this.g = iE + 1;
            return;
        }
        throw new w(w.f2148i, this.f);
    }
}
