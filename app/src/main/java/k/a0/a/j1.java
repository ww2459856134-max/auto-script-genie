package k.a0.a;

/* loaded from: classes.dex */
class j1 extends k.x.w0 {
    private int c;
    private int d;
    private int e;
    private int f;
    private int[] g;

    static {
        k.y.c.b(j1.class);
    }

    public j1(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        int iD = x().d();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[2], bArrC[3]);
        int iC = k.x.s0.c(bArrC[iD - 2], bArrC[iD - 1]);
        this.e = iC;
        int i2 = (iC - this.d) + 1;
        this.f = i2;
        this.g = new int[i2];
        B(bArrC);
    }

    private void B(byte[] bArr) {
        int i2 = 4;
        for (int i3 = 0; i3 < this.f; i3++) {
            this.g[i3] = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
            i2 += 2;
        }
    }

    public int A(int i2) {
        return this.g[i2];
    }

    public int getRow() {
        return this.c;
    }

    public int y() {
        return this.d;
    }

    public int z() {
        return this.f;
    }
}
