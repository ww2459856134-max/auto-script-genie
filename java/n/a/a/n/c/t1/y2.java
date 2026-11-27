package n.a.a.n.c.t1;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
abstract class y2 {
    private static Double a(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var == null) {
            throw new IllegalArgumentException("ve must not be null");
        }
        if (w0Var instanceof n.a.a.n.c.r1.y) {
            return Double.valueOf(((n.a.a.n.c.r1.y) w0Var).r());
        }
        if (w0Var instanceof n.a.a.n.c.r1.n0) {
            return n.a.a.n.c.r1.z.k(((n.a.a.n.c.r1.n0) w0Var).getStringValue().trim());
        }
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        if (w0Var == n.a.a.n.c.r1.l.a) {
            return null;
        }
        throw new IllegalStateException("Invalid ValueEval type passed for conversion: (" + w0Var.getClass() + ")");
    }

    private static o5 b(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        o5 o5Var = new o5();
        if (w0Var instanceof n.a.a.n.c.i1) {
            n.a.a.n.c.i1 i1Var = (n.a.a.n.c.i1) w0Var;
            for (int iG = i1Var.g(); iG <= i1Var.d(); iG++) {
                int width = i1Var.getWidth();
                int iA = i1Var.a();
                for (int i2 = 0; i2 < iA; i2++) {
                    for (int i3 = 0; i3 < width; i3++) {
                        Double dA = a(i1Var.j(iG, i2, i3));
                        if (dA == null) {
                            o5Var.a(Double.NaN);
                        } else {
                            o5Var.a(dA.doubleValue());
                        }
                    }
                }
            }
            return o5Var;
        }
        if (w0Var instanceof n.a.a.n.c.j1) {
            n.a.a.n.c.j1 j1Var = (n.a.a.n.c.j1) w0Var;
            int width2 = j1Var.getWidth();
            int iA2 = j1Var.a();
            for (int i4 = 0; i4 < iA2; i4++) {
                for (int i5 = 0; i5 < width2; i5++) {
                    Double dA2 = a(j1Var.p(i4, i5));
                    if (dA2 == null) {
                        o5Var.a(Double.NaN);
                    } else {
                        o5Var.a(dA2.doubleValue());
                    }
                }
            }
            return o5Var;
        }
        if (!(w0Var instanceof n.a.a.n.c.r1.c0)) {
            Double dA3 = a(w0Var);
            if (dA3 == null) {
                o5Var.a(Double.NaN);
            } else {
                o5Var.a(dA3.doubleValue());
            }
            return o5Var;
        }
        n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
        for (int iG2 = c0Var.g(); iG2 <= c0Var.d(); iG2++) {
            Double dA4 = a(c0Var.o(iG2));
            if (dA4 == null) {
                o5Var.a(Double.NaN);
            } else {
                o5Var.a(dA4.doubleValue());
            }
        }
        return o5Var;
    }

    static List<o5> c(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) throws n.a.a.n.c.r1.p {
        double[] dArrC = b(w0Var).c();
        double[] dArrC2 = b(w0Var2).c();
        if (dArrC.length != dArrC2.length) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        o5 o5Var = new o5();
        o5 o5Var2 = new o5();
        int iMin = Math.min(dArrC.length, dArrC2.length);
        for (int i2 = 0; i2 < iMin; i2++) {
            if (!Double.isNaN(dArrC[i2]) && !Double.isNaN(dArrC2[i2])) {
                o5Var.a(dArrC[i2]);
                o5Var2.a(dArrC2[i2]);
            }
        }
        return Arrays.asList(o5Var, o5Var2);
    }
}
