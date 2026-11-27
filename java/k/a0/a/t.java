package k.a0.a;

/* loaded from: classes.dex */
public class t extends k.x.w0 {
    private int c;
    private int d;

    static {
        k.y.c.b(t.class);
    }

    public t(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[2], bArrC[3]);
    }

    public int y() {
        return this.c;
    }

    public int z() {
        return this.d;
    }
}
