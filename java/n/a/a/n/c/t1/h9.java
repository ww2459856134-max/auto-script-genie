package n.a.a.n.c.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class h9 implements p6 {
    private static void a(n.a.a.n.c.r1.w0 w0Var, List<Double> list, boolean z) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        if (w0Var == n.a.a.n.c.r1.l.a || (w0Var instanceof n.a.a.n.c.r1.m) || (w0Var instanceof n.a.a.n.c.r1.m0)) {
            if (z) {
                throw n.a.a.n.c.r1.p.c();
            }
        } else {
            if (w0Var instanceof n.a.a.n.c.r1.x) {
                list.add(Double.valueOf(((n.a.a.n.c.r1.x) w0Var).r()));
                return;
            }
            throw new IllegalStateException("Unexpected value type (" + w0Var.getClass().getName() + ")");
        }
    }

    private static void b(n.a.a.n.c.r1.w0 w0Var, List<Double> list) throws n.a.a.n.c.r1.p {
        if (!(w0Var instanceof n.a.a.n.c.j1)) {
            if (!(w0Var instanceof n.a.a.n.c.r1.c0)) {
                a(w0Var, list, true);
                return;
            }
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            int iD = c0Var.d();
            for (int iG = c0Var.g(); iG <= iD; iG++) {
                a(c0Var.o(iG), list, true);
            }
            return;
        }
        n.a.a.n.c.j1 j1Var = (n.a.a.n.c.j1) w0Var;
        int width = j1Var.getWidth();
        int iA = j1Var.a();
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                a(j1Var.p(i2, i3), list, false);
            }
        }
    }

    public static double c(double[] dArr) throws n.a.a.n.c.r1.p {
        if (dArr.length < 2) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        int length = dArr.length;
        int[] iArr = new int[length];
        Arrays.fill(iArr, 1);
        int length2 = dArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i2 + 1;
            int length3 = dArr.length;
            for (int i4 = i3; i4 < length3; i4++) {
                if (dArr[i2] == dArr[i4]) {
                    iArr[i2] = iArr[i2] + 1;
                }
            }
            i2 = i3;
        }
        double d = 0.0d;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (iArr[i6] > i5) {
                d = dArr[i6];
                i5 = iArr[i6];
            }
        }
        if (i5 > 1) {
            return d;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        try {
            ArrayList arrayList = new ArrayList();
            for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
                b(w0Var, arrayList);
            }
            int size = arrayList.size();
            double[] dArr = new double[size];
            for (int i4 = 0; i4 < size; i4++) {
                dArr[i4] = ((Double) arrayList.get(i4)).doubleValue();
            }
            return new n.a.a.n.c.r1.x(c(dArr));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
