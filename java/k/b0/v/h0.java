package k.b0.v;

/* loaded from: classes.dex */
class h0 extends k.x.c1 {
    private int c;
    private int[] d;
    private int[] e;
    private int f;

    public h0(int i2) {
        super(k.x.z0.u);
        this.f = 0;
        this.c = i2;
        int iB = B();
        this.d = new int[iB];
        this.e = new int[iB];
        this.f = 0;
    }

    public void A(int i2, int i3) {
        int[] iArr = this.d;
        int i4 = this.f;
        iArr[i4] = i2 + i3;
        this.e[i4] = i3;
        this.f = i4 + 1;
    }

    public int B() {
        int iC = C();
        if (iC != 0) {
            return ((this.c + iC) - 1) / iC;
        }
        return 0;
    }

    public int C() {
        return ((this.c + 128) - 1) / 128;
    }

    @Override // k.x.c1
    public byte[] y() {
        int iB = B();
        byte[] bArr = new byte[(iB * 8) + 2];
        k.x.s0.f(C(), bArr, 0);
        for (int i2 = 0; i2 < iB; i2++) {
            int i3 = i2 * 8;
            k.x.s0.a(this.d[i2], bArr, i3 + 2);
            k.x.s0.f(this.e[i2], bArr, i3 + 6);
        }
        return bArr;
    }
}
