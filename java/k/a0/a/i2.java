package k.a0.a;

/* loaded from: classes.dex */
public class i2 extends k.x.w0 {
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private int f1810h;

    /* renamed from: i, reason: collision with root package name */
    private int f1811i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1812j;

    static {
        k.y.c.b(i2.class);
    }

    i2(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[6], bArrC[7]);
        int iD = k.x.s0.d(bArrC[12], bArrC[13], bArrC[14], bArrC[15]);
        this.f1811i = iD & 7;
        this.f1812j = (iD & 16) != 0;
        this.e = (iD & 32) != 0;
        this.g = (iD & 64) == 0;
        this.f = (iD & 128) != 0;
        this.f1810h = (iD & 268369920) >> 16;
    }

    public int A() {
        return this.d;
    }

    public int B() {
        return this.c;
    }

    public int C() {
        return this.f1810h;
    }

    public boolean D() {
        return this.f;
    }

    public boolean E() {
        return this.e;
    }

    boolean F() {
        return this.d == 255;
    }

    public boolean G() {
        return this.g;
    }

    public boolean y() {
        return this.f1812j;
    }

    public int z() {
        return this.f1811i;
    }
}
