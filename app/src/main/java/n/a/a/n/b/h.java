package n.a.a.n.b;

/* loaded from: classes.dex */
class h {
    final char a;
    final int b;
    final int c;
    final double d;
    double e = 0.0d;

    public h(char c, int i2, int i3, double d) {
        this.a = c;
        this.b = i2;
        this.c = i3;
        this.d = d;
    }

    public long a(double d) {
        double d2 = this.e;
        double d3 = d2 == 0.0d ? d / this.d : (d / this.d) % d2;
        char c = this.a;
        return (c == '0' || c == 's') ? Math.round(d3) : (long) d3;
    }
}
