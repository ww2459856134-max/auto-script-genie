package k.a0.a;

/* loaded from: classes.dex */
class l3 extends k.x.w0 {
    public static final k3 g;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;

    static {
        k.y.c.b(l3.class);
        g = new k3();
    }

    public l3(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        int i2 = iC & 512;
        this.c = (iC & 2) != 0;
        this.e = (iC & 8) != 0;
        this.d = (iC & 16) != 0;
        int i3 = iC & 256;
        this.f = (iC & 2048) != 0;
        k.x.s0.c(bArrC[10], bArrC[11]);
        k.x.s0.c(bArrC[12], bArrC[13]);
    }

    public boolean A() {
        return this.c;
    }

    public boolean B() {
        return this.f;
    }

    public boolean y() {
        return this.d;
    }

    public boolean z() {
        return this.e;
    }

    public l3(f2 f2Var, k3 k3Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        int i2 = iC & 512;
        this.c = (iC & 2) != 0;
        this.e = (iC & 8) != 0;
        this.d = (iC & 16) != 0;
        int i3 = iC & 256;
        this.f = (iC & 2048) != 0;
    }
}
