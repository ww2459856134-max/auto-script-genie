package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract class c8 implements b8 {
    private final Class<? extends n.a.a.n.c.r1.w0> a;

    protected c8(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var == null) {
            throw new IllegalStateException("targetValue cannot be null");
        }
        this.a = w0Var.getClass();
    }

    @Override // n.a.a.n.c.t1.b8
    public final a8 a(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var != null) {
            return this.a != w0Var.getClass() ? a8.e : b(w0Var);
        }
        throw new IllegalStateException("compare to value cannot be null");
    }

    protected abstract a8 b(n.a.a.n.c.r1.w0 w0Var);

    protected abstract String c();

    public String toString() {
        return getClass().getName() + " [" + c() + "]";
    }
}
