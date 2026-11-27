package k.a0.a;

/* loaded from: classes.dex */
class x extends k.x.w0 {
    private int c;

    public x(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        if (bArrC.length > 2) {
            this.c = k.x.s0.c(bArrC[2], bArrC[3]);
        }
    }

    public int y() {
        return this.c;
    }
}
