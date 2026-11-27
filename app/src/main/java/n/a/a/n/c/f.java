package n.a.a.n.c;

/* loaded from: classes.dex */
abstract class f implements k0 {
    public static final f[] c = new f[0];
    private final w a = new w();
    private n.a.a.n.c.r1.w0 b;

    protected f() {
    }

    private static boolean b(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        Class<?> cls;
        if (w0Var == null || (cls = w0Var.getClass()) != w0Var2.getClass()) {
            return false;
        }
        if (w0Var == n.a.a.n.c.r1.l.a) {
            return w0Var2 == w0Var;
        }
        if (cls == n.a.a.n.c.r1.x.class) {
            return ((n.a.a.n.c.r1.x) w0Var).r() == ((n.a.a.n.c.r1.x) w0Var2).r();
        }
        if (cls == n.a.a.n.c.r1.m0.class) {
            return ((n.a.a.n.c.r1.m0) w0Var).getStringValue().equals(((n.a.a.n.c.r1.m0) w0Var2).getStringValue());
        }
        if (cls == n.a.a.n.c.r1.m.class) {
            return ((n.a.a.n.c.r1.m) w0Var).u() == ((n.a.a.n.c.r1.m) w0Var2).u();
        }
        if (cls == n.a.a.n.c.r1.o.class) {
            return ((n.a.a.n.c.r1.o) w0Var).u() == ((n.a.a.n.c.r1.o) w0Var2).u();
        }
        throw new IllegalStateException("Unexpected value class (" + cls.getName() + ")");
    }

    public final void a(v vVar) {
        this.a.a(vVar);
    }

    public final void c(v vVar) {
        if (!this.a.c(vVar)) {
            throw new IllegalStateException("Specified formula cell is not consumed by this cell");
        }
    }

    public final n.a.a.n.c.r1.w0 d() {
        return this.b;
    }

    public final boolean e(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var == null) {
            throw new IllegalArgumentException("Did not expect to update to null");
        }
        boolean z = !b(this.b, w0Var);
        this.b = w0Var;
        return z;
    }
}
