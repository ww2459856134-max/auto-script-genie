package k.a0.a;

/* loaded from: classes.dex */
public abstract class b extends o implements k.x.o0 {

    /* renamed from: l, reason: collision with root package name */
    private int f1780l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f1781m;

    /* renamed from: n, reason: collision with root package name */
    private k.x.j1.t f1782n;

    /* renamed from: o, reason: collision with root package name */
    private k.x.a1 f1783o;

    public b(f2 f2Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var, int i2) {
        super(f2Var, n0Var, y2Var);
        this.f1782n = tVar;
        this.f1783o = a1Var;
        this.f1780l = i2;
    }

    protected final k.x.j1.t A() {
        return this.f1782n;
    }

    final int B() {
        return this.f1780l;
    }

    protected final k.x.a1 C() {
        return this.f1783o;
    }

    protected final byte[] D() {
        return this.f1781m;
    }

    void E(byte[] bArr) {
        this.f1781m = bArr;
    }

    @Override // k.x.w0
    public f2 x() {
        return super.x();
    }
}
