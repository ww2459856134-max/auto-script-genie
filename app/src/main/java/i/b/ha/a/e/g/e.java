package i.b.ha.a.e.g;

/* loaded from: classes.dex */
class e {
    private final int a;
    private final double b;
    private final double c;

    e(double d) {
        int i2 = (int) (0.6366197723675814d * d);
        while (true) {
            double d2 = -i2;
            double d3 = 1.570796251296997d * d2;
            double d4 = d + d3;
            double d5 = 7.549789948768648E-8d * d2;
            double d6 = d5 + d4;
            double d7 = (-((d4 - d) - d3)) + (-((d6 - d4) - d5));
            double d8 = d2 * 6.123233995736766E-17d;
            double d9 = d8 + d6;
            double d10 = d7 + (-((d9 - d6) - d8));
            if (d9 > 0.0d) {
                this.a = i2;
                this.b = d9;
                this.c = d10;
                return;
            }
            i2--;
        }
    }

    int a() {
        return this.a;
    }

    double b() {
        return this.b;
    }

    double c() {
        return this.c;
    }
}
