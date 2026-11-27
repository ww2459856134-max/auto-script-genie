package k.a0.a;

/* loaded from: classes.dex */
class j2 extends k.x.w0 {
    private int c;
    private int d;

    protected j2(f2 f2Var) {
        super(k.x.z0.Y0);
        byte[] bArrC = f2Var.c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[2], bArrC[3]);
    }

    public int y() {
        return (this.c * 100) / this.d;
    }
}
