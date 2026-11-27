package n.a.a.n.c.t1;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ac implements p6 {
    private static double[][] a(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.u) {
            return (double[][]) Array.newInstance((Class<?>) double.class, 0, 0);
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            if (c0Var.t() > 1) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            w0Var = c0Var.o(c0Var.g());
        }
        if (w0Var == null) {
            throw new IllegalStateException("Parameter may not be null.");
        }
        if (!(w0Var instanceof n.a.a.n.c.r1.j)) {
            if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, 1, 1);
            dArr[0][0] = ((n.a.a.n.c.r1.y) w0Var).r();
            return dArr;
        }
        n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
        int width = jVar.getWidth();
        int iA = jVar.a();
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, iA, width);
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                n.a.a.n.c.r1.w0 w0VarK = jVar.k(i2, i3);
                if (!(w0VarK instanceof n.a.a.n.c.r1.y)) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                }
                dArr2[i2][i3] = ((n.a.a.n.c.r1.y) w0VarK).r();
            }
        }
        return dArr2;
    }

    private static double[] b(double[][] dArr) {
        if (dArr.length < 1) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length * dArr[0].length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            System.arraycopy(dArr[i2], 0, dArr2, dArr[0].length * i2, dArr[0].length);
        }
        return dArr2;
    }

    private static double[][] c(double[][] dArr) {
        if (dArr.length < 1) {
            return (double[][]) Array.newInstance((Class<?>) double.class, 0, 0);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, dArr.length * dArr[0].length, 1);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            for (int i3 = 0; i3 < dArr[0].length; i3++) {
                dArr2[(dArr[0].length * i2) + i3][0] = dArr[i2][i3];
            }
        }
        return dArr2;
    }

    private static double[][] d(int i2) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, i2, 1);
        for (int i3 = 0; i3 < i2; i3++) {
            dArr[i3][0] = i3 + 1.0d;
        }
        return dArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zb f(n.a.a.n.c.r1.w0[] w0VarArr) throws n.a.a.n.c.r1.p {
        double[][] dArrA;
        double[][] dArrA2;
        double[][] dArrA3;
        boolean z;
        double[][] dArrD;
        double[][] dArrC;
        int length = w0VarArr.length;
        if (length == 1) {
            dArrA = a(w0VarArr[0]);
            dArrA2 = (double[][]) Array.newInstance((Class<?>) double.class, 0, 0);
            dArrA3 = (double[][]) Array.newInstance((Class<?>) double.class, 0, 0);
        } else if (length == 2) {
            dArrA = a(w0VarArr[0]);
            dArrA2 = a(w0VarArr[1]);
            dArrA3 = (double[][]) Array.newInstance((Class<?>) double.class, 0, 0);
        } else {
            if (length != 3) {
                if (length != 4) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                }
                dArrA = a(w0VarArr[0]);
                dArrA2 = a(w0VarArr[1]);
                dArrA3 = a(w0VarArr[2]);
                if (!(w0VarArr[3] instanceof n.a.a.n.c.r1.m)) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                }
                z = !((n.a.a.n.c.r1.m) w0VarArr[3]).u();
                if (dArrA.length >= 1) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                }
                double[] dArrB = b(dArrA);
                double[][] dArr = dArrA3.length > 0 ? dArrA3 : (double[][]) Array.newInstance((Class<?>) double.class, 1, 1);
                if (dArrB.length == 1) {
                    throw new n.a.a.n.c.r1.v("Sample size too small");
                }
                if (dArrA.length != 1 && dArrA[0].length != 1) {
                    if (dArrA2.length < 1) {
                        dArrD = d(dArrB.length);
                        if (dArrA3.length < 1) {
                            dArr = dArrA;
                        }
                    } else {
                        dArrD = c(dArrA2);
                        if (dArrA3.length < 1) {
                            dArr = dArrA2;
                        }
                    }
                    dArrC = dArrA3.length > 0 ? c(dArrA3) : dArrA3;
                    if (dArrB.length != dArrD.length || dArrA.length != dArrA2.length) {
                        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
                    }
                } else if (dArrA2.length < 1) {
                    dArrD = d(dArrB.length);
                    if (dArrA3.length >= 1) {
                        dArrA = dArr;
                    }
                    if (dArrA3.length <= 0 || !(dArrD.length == 1 || dArrD[0].length == 1)) {
                        dArr = dArrA;
                        dArrC = dArrA3;
                    } else {
                        dArrC = c(dArrA3);
                        dArr = dArrA;
                    }
                } else {
                    double[][] dArrL = (dArrA2[0].length <= 1 || dArrA.length != 1) ? dArrA2 : l(dArrA2);
                    if (dArrA3.length < 1) {
                        dArrD = dArrL;
                        dArrA = dArrA2;
                        if (dArrA3.length <= 0) {
                            dArr = dArrA;
                            dArrC = dArrA3;
                        }
                    } else {
                        dArrD = dArrL;
                        dArrA = dArr;
                        if (dArrA3.length <= 0) {
                        }
                    }
                }
                if (dArrA3.length < 1) {
                    dArrC = dArrD;
                } else if (dArrA3.length == 1 && dArrA3[0].length > 1 && dArrA2.length > 1 && dArrA2[0].length == 1) {
                    dArrC = l(dArrA3);
                }
                if (dArrC[0].length != dArrD[0].length) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
                }
                if (dArrD[0].length >= dArrD.length) {
                    throw new n.a.a.n.c.r1.v("Sample size too small");
                }
                int length2 = dArr.length;
                int length3 = dArr[0].length;
                if (h(dArrD)) {
                    double[] dArr2 = new double[dArrC.length];
                    Arrays.fill(dArr2, Arrays.stream(dArrB).average().orElse(0.0d));
                    return new zb(dArr2, length3, length2);
                }
                i.b.ha.a.e.f.c.b bVar = new i.b.ha.a.e.f.c.b();
                if (z) {
                    bVar.g(true);
                }
                try {
                    bVar.i(dArrB, dArrD);
                    try {
                        double[] dArrB2 = bVar.b();
                        double[] dArr3 = new double[dArrC.length];
                        for (int i2 = 0; i2 < dArrC.length; i2++) {
                            dArr3[i2] = 0.0d;
                            if (z) {
                                for (int i3 = 0; i3 < dArrB2.length; i3++) {
                                    dArr3[i2] = dArr3[i2] + (dArrB2[i3] * dArrC[i2][i3]);
                                }
                            } else {
                                dArr3[i2] = dArrB2[0];
                                for (int i4 = 1; i4 < dArrB2.length; i4++) {
                                    dArr3[i2] = dArr3[i2] + (dArrB2[i4] * dArrC[i2][i4 - 1]);
                                }
                            }
                        }
                        return new zb(dArr3, length3, length2);
                    } catch (i.b.ha.a.e.c.w unused) {
                        throw new n.a.a.n.c.r1.v("Singular matrix in input");
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
                }
            }
            dArrA = a(w0VarArr[0]);
            dArrA2 = a(w0VarArr[1]);
            dArrA3 = a(w0VarArr[2]);
        }
        z = false;
        if (dArrA.length >= 1) {
        }
    }

    private static boolean h(double[][] dArr) {
        if (dArr.length == 0) {
            return false;
        }
        int length = dArr[0].length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < dArr[0].length; i2++) {
            double d = Double.NaN;
            int i3 = 0;
            while (true) {
                if (i3 < dArr.length) {
                    double d2 = dArr[i3][i2];
                    if (i3 > 0 && d2 != d) {
                        zArr[i2] = true;
                        break;
                    }
                    i3++;
                    d = d2;
                }
            }
        }
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    private static double[][] l(double[][] dArr) {
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, dArr[0].length, dArr.length);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            for (int i3 = 0; i3 < dArr[0].length; i3++) {
                dArr2[i3][i2] = dArr[i2][i3];
            }
        }
        return dArr2;
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 1 || w0VarArr.length > 4) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            zb zbVarF = f(w0VarArr);
            n.a.a.n.c.r1.w0[] w0VarArr2 = new n.a.a.n.c.r1.w0[zbVarF.a.length];
            for (int i4 = 0; i4 < zbVarF.a.length; i4++) {
                w0VarArr2[i4] = new n.a.a.n.c.r1.x(zbVarF.a[i4]);
            }
            return zbVarF.a.length == 1 ? w0VarArr2[0] : new n.a.a.n.c.e(i2, i3, (zbVarF.c + i2) - 1, (zbVarF.b + i3) - 1, w0VarArr2);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
