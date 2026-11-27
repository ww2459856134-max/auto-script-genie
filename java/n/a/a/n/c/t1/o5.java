package n.a.a.n.c.t1;

import java.util.Arrays;

/* loaded from: classes.dex */
final class o5 {
    static final double[] c = new double[0];
    private double[] a = new double[8];
    private int b = 0;

    private void b(int i2) {
        double[] dArr = this.a;
        if (i2 > dArr.length) {
            this.a = Arrays.copyOf(dArr, (i2 * 3) / 2);
        }
    }

    public void a(double d) {
        b(this.b + 1);
        double[] dArr = this.a;
        int i2 = this.b;
        dArr[i2] = d;
        this.b = i2 + 1;
    }

    public double[] c() {
        int i2 = this.b;
        return i2 < 1 ? c : Arrays.copyOf(this.a, i2);
    }
}
