package n.a.a.n.c.t1;

import java.util.List;

/* loaded from: classes.dex */
public class i6 extends d6 implements j6 {
    public static final i6 a = new i6();

    private i6() {
    }

    private static Double a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 3 ? n.a.a.n.c.r1.o.e : e(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1], w0VarArr[2]);
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            Double dA = a(w0Var, i2, i3);
            if (dA != null && !dA.isNaN() && !dA.isInfinite()) {
                List<o5> listC = y2.c(w0Var2, w0Var3);
                int i4 = 0;
                double[] dArrC = listC.get(0).c();
                double[] dArrC2 = listC.get(1).c();
                double d = q8.d(dArrC);
                double d2 = q8.d(dArrC2);
                int length = dArrC.length;
                double dPow = 0.0d;
                double d3 = 0.0d;
                while (i4 < length) {
                    double d4 = dArrC2[i4] - d2;
                    double d5 = d3 + ((dArrC[i4] - d) * d4);
                    dPow += Math.pow(d4, 2.0d);
                    i4++;
                    d3 = d5;
                }
                if (dPow == 0.0d) {
                    return n.a.a.n.c.r1.o.d;
                }
                double d6 = d3 / dPow;
                return new n.a.a.n.c.r1.x((d - (d2 * d6)) + (d6 * dA.doubleValue()));
            }
            return n.a.a.n.c.r1.o.e;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        } catch (Exception unused) {
            return n.a.a.n.c.r1.o.f2386i;
        }
    }
}
