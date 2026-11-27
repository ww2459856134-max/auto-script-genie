package k.a0.a;

/* loaded from: classes.dex */
class g2 extends k.x.w0 {
    private boolean c;

    static {
        k.y.c.b(g2.class);
    }

    public g2(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]) == 1;
    }

    public boolean y() {
        return this.c;
    }
}
