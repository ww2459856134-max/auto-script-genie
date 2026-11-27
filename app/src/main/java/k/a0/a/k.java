package k.a0.a;

/* loaded from: classes.dex */
class k extends k.x.w0 {
    public static j g = new j();
    private byte c;
    private byte d;
    private int e;
    private String f;

    public k(f2 f2Var, k.w wVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        k.x.s0.d(bArrC[0], bArrC[1], bArrC[2], bArrC[3]);
        this.c = bArrC[5];
        this.d = bArrC[4];
        int i2 = bArrC[6];
        this.e = i2;
        if (bArrC[7] == 0) {
            byte[] bArr = new byte[i2];
            System.arraycopy(bArrC, 8, bArr, 0, i2);
            this.f = k.x.y0.d(bArr, this.e, 0, wVar);
        } else {
            byte[] bArr2 = new byte[i2 * 2];
            System.arraycopy(bArrC, 8, bArr2, 0, i2 * 2);
            this.f = k.x.y0.g(bArr2, this.e, 0);
        }
    }

    public boolean A() {
        return this.c == 0;
    }

    public String getName() {
        return this.f;
    }

    public boolean y() {
        return this.c == 2;
    }

    public boolean z() {
        return this.d != 0;
    }

    public k(f2 f2Var, j jVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        k.x.s0.d(bArrC[0], bArrC[1], bArrC[2], bArrC[3]);
        this.c = bArrC[5];
        this.d = bArrC[4];
        int i2 = bArrC[6];
        this.e = i2;
        byte[] bArr = new byte[i2];
        System.arraycopy(bArrC, 7, bArr, 0, i2);
        this.f = new String(bArr);
    }
}
