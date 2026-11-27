package n.a.a.n.c.t1;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class y8 implements p6 {
    public static final p6 a = new r8();
    public static final p6 b = new s8();
    public static final p6 c = new u8();
    public static final p6 d = new t8();

    public static void c(double[] dArr) throws n.a.a.n.c.r1.p {
        for (double d2 : dArr) {
            if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] d(double[][] dArr) throws n.a.a.n.c.r1.p {
        if (dArr == null || dArr.length < 1 || dArr[0].length < 1) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        double[] dArr2 = new double[dArr.length * dArr[0].length];
        int i2 = 0;
        for (double[] dArr3 : dArr) {
            int i3 = 0;
            while (i3 < dArr[0].length) {
                dArr2[i2] = dArr3[i3];
                i3++;
                i2++;
            }
        }
        return dArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[][] f(double[] dArr, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (i2 < 1 || i3 < 1 || dArr.length < 1) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, i2, i3);
        int i4 = 0;
        int i5 = 0;
        for (double d2 : dArr) {
            if (i4 < dArr2.length) {
                if (i5 == dArr2[0].length) {
                    i4++;
                    i5 = 0;
                }
                if (i4 < dArr2.length) {
                    dArr2[i4][i5] = d2;
                    i5++;
                }
            }
        }
        return dArr2;
    }
}
