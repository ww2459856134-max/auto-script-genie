package k.a0.a;

/* loaded from: classes.dex */
public class a extends k.x.w0 {
    private int c;
    private int d;

    static {
        k.y.c.b(a.class);
    }

    a(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[2], bArrC[3]);
    }

    public boolean A() {
        return this.c == 1536;
    }

    public boolean B() {
        return this.d == 32;
    }

    boolean C() {
        return this.d == 5;
    }

    public boolean D() {
        return this.d == 16;
    }

    int y() {
        return x().d();
    }

    public boolean z() {
        return this.c == 1280;
    }
}
