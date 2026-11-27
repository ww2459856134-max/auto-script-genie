package i.b.ha.a.e.e;

/* loaded from: classes.dex */
final class c extends i.b.ha.a.e.g.d {
    final /* synthetic */ double a;
    final /* synthetic */ double b;

    c(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    @Override // i.b.ha.a.e.g.d
    protected double b(int i2, double d) {
        return 1.0d;
    }

    @Override // i.b.ha.a.e.g.d
    protected double c(int i2, double d) {
        if (i2 % 2 == 0) {
            double d2 = i2 / 2.0d;
            double d3 = (this.a - d2) * d2 * d;
            double d4 = this.b;
            double d5 = d2 * 2.0d;
            return d3 / (((d4 + d5) - 1.0d) * (d4 + d5));
        }
        double d6 = (i2 - 1.0d) / 2.0d;
        double d7 = this.b;
        double d8 = -((d7 + d6) * (this.a + d7 + d6) * d);
        double d9 = d6 * 2.0d;
        return d8 / ((d7 + d9) * ((d7 + d9) + 1.0d));
    }
}
