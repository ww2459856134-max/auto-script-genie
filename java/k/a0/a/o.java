package k.a0.a;

/* loaded from: classes.dex */
public abstract class o extends k.x.w0 implements k.c, n {

    /* renamed from: k, reason: collision with root package name */
    private static k.y.c f1823k = k.y.c.b(o.class);
    private int c;
    private int d;
    private int e;
    private k.x.n0 f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private k.x.h1 f1824h;

    /* renamed from: i, reason: collision with root package name */
    private y2 f1825i;

    /* renamed from: j, reason: collision with root package name */
    private k.d f1826j;

    protected o(f2 f2Var, k.x.n0 n0Var, y2 y2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[2], bArrC[3]);
        this.e = k.x.s0.c(bArrC[4], bArrC[5]);
        this.f1825i = y2Var;
        this.f = n0Var;
        this.g = false;
    }

    @Override // k.c
    public final int b() {
        return this.d;
    }

    @Override // k.c, k.a0.a.n
    public k.d c() {
        return this.f1826j;
    }

    @Override // k.c
    public k.z.d e() {
        if (!this.g) {
            this.f1824h = this.f.h(this.e);
            this.g = true;
        }
        return this.f1824h;
    }

    @Override // k.c
    public final int getRow() {
        return this.c;
    }

    @Override // k.a0.a.n
    public void h(k.d dVar) {
        if (this.f1826j != null) {
            f1823k.f("current cell features not null - overwriting");
        }
        this.f1826j = dVar;
    }

    protected y2 y() {
        return this.f1825i;
    }

    public final int z() {
        return this.e;
    }
}
