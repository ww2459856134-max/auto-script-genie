package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract class i4 implements z3 {
    private final g4 a;

    i4(g4 g4Var) {
        this.a = g4Var;
    }

    protected final boolean c(int i2) {
        return this.a.a(i2);
    }

    protected final boolean d(boolean z) {
        return this.a.b(z);
    }

    protected final int e() {
        return this.a.c();
    }

    protected abstract String f();

    public final String toString() {
        return getClass().getName() + " [" + this.a.f() + f() + "]";
    }
}
