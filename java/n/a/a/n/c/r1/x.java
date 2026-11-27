package n.a.a.n.c.r1;

import n.a.a.n.c.u1.e2;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.t1;

/* loaded from: classes.dex */
public final class x implements y, n0 {
    public static final x c = new x(0.0d);
    private final double a;
    private String b;

    public x(k2 k2Var) {
        if (k2Var == null) {
            throw new IllegalArgumentException("ptg must not be null");
        }
        if (k2Var instanceof t1) {
            this.a = ((t1) k2Var).p();
            return;
        }
        if (k2Var instanceof e2) {
            this.a = ((e2) k2Var).p();
            return;
        }
        throw new IllegalArgumentException("bad argument type (" + k2Var.getClass().getName() + ")");
    }

    @Override // n.a.a.n.c.r1.n0
    public String getStringValue() {
        if (this.b == null) {
            this.b = n.a.a.n.e.c0.h(this.a);
        }
        return this.b;
    }

    @Override // n.a.a.n.c.r1.y
    public double r() {
        return this.a;
    }

    public final String toString() {
        return x.class.getName() + " [" + getStringValue() + "]";
    }

    public x(double d) {
        this.a = d;
    }
}
