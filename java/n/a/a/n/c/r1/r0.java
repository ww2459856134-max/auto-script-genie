package n.a.a.n.c.r1;

/* loaded from: classes.dex */
final class r0 extends t0 {
    r0() {
    }

    @Override // n.a.a.n.c.r1.t0
    protected double l(double d, double d2) {
        return (d >= 0.0d || Math.abs(d2) <= 0.0d || Math.abs(d2) >= 1.0d) ? Math.pow(d, d2) : Math.pow(d * (-1.0d), d2) * (-1.0d);
    }
}
