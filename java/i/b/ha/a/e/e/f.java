package i.b.ha.a.e.e;

/* loaded from: classes.dex */
final class f extends i.b.ha.a.e.g.d {
    final /* synthetic */ double a;

    f(double d) {
        this.a = d;
    }

    @Override // i.b.ha.a.e.g.d
    protected double b(int i2, double d) {
        return (((i2 * 2.0d) + 1.0d) - this.a) + d;
    }

    @Override // i.b.ha.a.e.g.d
    protected double c(int i2, double d) {
        double d2 = i2;
        return d2 * (this.a - d2);
    }
}
