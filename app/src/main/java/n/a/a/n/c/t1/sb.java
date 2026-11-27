package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class sb extends cc {
    private static final n.a.a.n.c.r1.w0 b = new n.a.a.n.c.r1.x(1.0d);
    private final boolean a;

    protected sb(boolean z) {
        this.a = z;
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 l(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        return i(i2, i3, w0Var, b);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            String strB = vb.b(w0Var, i2, i3);
            int iA = vb.a(w0Var2, i2, i3);
            if (iA < 0) {
                return n.a.a.n.c.r1.o.e;
            }
            return new n.a.a.n.c.r1.m0(this.a ? strB.substring(0, Math.min(strB.length(), iA)) : strB.substring(Math.max(0, strB.length() - iA)));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
