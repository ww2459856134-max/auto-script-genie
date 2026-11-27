package k.a0.a;

/* loaded from: classes.dex */
class u extends v implements k.g, k.x.o0, k.h {

    /* renamed from: o, reason: collision with root package name */
    private byte[] f1864o;

    public u(q1 q1Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, boolean z, y2 y2Var) throws k.x.j1.w {
        super(q1Var, q1Var.z(), n0Var, z, y2Var);
        this.f1864o = q1Var.j();
    }

    @Override // k.a0.a.v, k.c
    public k.f getType() {
        return k.f.f1990h;
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (a().y().A()) {
            return this.f1864o;
        }
        throw new k.x.j1.w(k.x.j1.w.e);
    }
}
