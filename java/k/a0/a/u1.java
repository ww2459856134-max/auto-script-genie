package k.a0.a;

/* loaded from: classes.dex */
class u1 extends k.x.w0 {
    private int c;
    private int d;

    static {
        k.y.c.b(u1.class);
    }

    public u1(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        this.d = k.x.s0.c(bArrC[0], bArrC[1]);
        this.c = k.x.s0.c(bArrC[2], bArrC[3]);
    }

    public final int y() {
        return this.d;
    }

    public final int z() {
        return this.c;
    }
}
