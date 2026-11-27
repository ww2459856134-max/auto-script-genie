package i.b.ha.a.e.g;

/* loaded from: classes.dex */
class h {
    public static final h d = new h(Double.NaN, 0.0d);
    public static final h e = new h(Double.POSITIVE_INFINITY, 0.0d);
    public static final h f = new h(Double.NEGATIVE_INFINITY, 0.0d);
    private final double a;
    private final double b;
    private final double c;

    h(double d2) {
        this.a = d2;
        double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToRawLongBits(d2) & (-134217728));
        this.b = dLongBitsToDouble;
        this.c = d2 - dLongBitsToDouble;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h d(long j2) {
        h hVar = new h(1.0d);
        h hVar2 = new h(this.a, this.b, this.c);
        for (long j3 = j2; j3 != 0; j3 >>>= 1) {
            if ((j3 & 1) != 0) {
                hVar = hVar.c(hVar2);
            }
            hVar2 = hVar2.c(hVar2);
        }
        return Double.isNaN(hVar.a) ? Double.isNaN(this.a) ? d : j.a(this.a) < 1.0d ? new h(j.e(0.0d, this.a), 0.0d) : (this.a >= 0.0d || (j2 & 1) != 1) ? e : f : hVar;
    }

    public h c(h hVar) {
        h hVar2 = new h(this.a * hVar.a);
        double d2 = this.c;
        double d3 = hVar.c;
        double d4 = hVar2.a;
        double d5 = this.b;
        double d6 = hVar.b;
        return new h(hVar2.b, hVar2.c + ((d2 * d3) - (((d4 - (d5 * d6)) - (d2 * d6)) - (d5 * d3))));
    }

    public h e() {
        h hVar = new h(1.0d / this.a);
        h hVarC = c(hVar);
        double d2 = (hVarC.b - 1.0d) + hVarC.c;
        return Double.isNaN(d2) ? hVar : new h(hVar.b, hVar.c - (d2 / this.a));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    h(double d2, double d3) {
        double d4;
        double d5;
        if (d2 != 0.0d) {
            d4 = d2 + d3;
        } else {
            if (d3 != 0.0d || Double.doubleToRawLongBits(d2) != Long.MIN_VALUE) {
                d5 = d3;
                this(d5, d2, d3);
            }
            d4 = -0.0d;
        }
        d5 = d4;
        this(d5, d2, d3);
    }

    h(double d2, double d3, double d4) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }
}
