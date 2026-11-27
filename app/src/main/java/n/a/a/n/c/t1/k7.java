package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class k7 {
    private static final double a = Math.log(10.0d);

    public static n.a.a.n.c.r1.w0 a(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        double dLog;
        if (w0VarArr.length != 1 && w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double D = y9.D(w0VarArr[0], i2, i3);
            if (w0VarArr.length == 1) {
                dLog = Math.log(D) / a;
            } else {
                double D2 = y9.D(w0VarArr[1], i2, i3);
                double dLog2 = Math.log(D);
                if (Double.compare(D2, 2.718281828459045d) != 0) {
                    dLog2 /= Math.log(D2);
                }
                dLog = dLog2;
            }
            y9.a(dLog);
            return new n.a.a.n.c.r1.x(dLog);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
