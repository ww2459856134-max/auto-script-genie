package k.a0.a;

/* loaded from: classes.dex */
class i1 implements k.c, n {

    /* renamed from: h, reason: collision with root package name */
    private static k.y.c f1809h = k.y.c.b(i1.class);
    private int a;
    private int b;
    private k.z.d c;
    private int d;
    private k.x.n0 e;
    private boolean f = false;
    private k.d g;

    public i1(int i2, int i3, int i4, k.x.n0 n0Var, y2 y2Var) {
        this.a = i2;
        this.b = i3;
        this.d = i4;
        this.e = n0Var;
    }

    @Override // k.c
    public final int b() {
        return this.b;
    }

    @Override // k.c, k.a0.a.n
    public k.d c() {
        return this.g;
    }

    @Override // k.c
    public k.z.d e() {
        if (!this.f) {
            this.c = this.e.h(this.d);
            this.f = true;
        }
        return this.c;
    }

    @Override // k.c
    public final int getRow() {
        return this.a;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.b;
    }

    @Override // k.a0.a.n
    public void h(k.d dVar) {
        if (this.g != null) {
            f1809h.f("current cell features not null - overwriting");
        }
        this.g = dVar;
    }

    @Override // k.c
    public String p() {
        return "";
    }
}
