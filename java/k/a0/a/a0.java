package k.a0.a;

/* loaded from: classes.dex */
class a0 extends k.x.w0 {
    public static z e;
    private int c;
    private int d;

    static {
        k.y.c.b(a0.class);
        e = new z();
    }

    public a0(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        if (bArrC.length == 10) {
            A(bArrC);
        } else {
            B(bArrC);
        }
    }

    private void A(byte[] bArr) {
        this.c = k.x.s0.c(bArr[2], bArr[3]);
        this.d = k.x.s0.c(bArr[6], bArr[7]);
    }

    private void B(byte[] bArr) {
        this.c = k.x.s0.d(bArr[4], bArr[5], bArr[6], bArr[7]);
        this.d = k.x.s0.c(bArr[10], bArr[11]);
    }

    public int y() {
        return this.d;
    }

    public int z() {
        return this.c;
    }

    public a0(f2 f2Var, z zVar) {
        super(f2Var);
        A(f2Var.c());
    }
}
