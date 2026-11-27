package n.a.a.n.c.t1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ea implements p6 {
    public static final p6 a = new ea();

    private ea() {
    }

    private n.a.a.n.c.r1.w0 a(List<Double> list, double d, int i2, boolean z) {
        double dDoubleValue = Double.MIN_VALUE;
        double dDoubleValue2 = Double.MAX_VALUE;
        if (z) {
            for (Double d2 : list) {
                if (d2.doubleValue() <= d && d2.doubleValue() > dDoubleValue) {
                    dDoubleValue = d2.doubleValue();
                }
                if (d2.doubleValue() > d && d2.doubleValue() < dDoubleValue2) {
                    dDoubleValue2 = d2.doubleValue();
                }
            }
        }
        double d3 = dDoubleValue2;
        double d4 = dDoubleValue;
        if (z && d4 != d && d3 != d) {
            int i3 = i2 < 5 ? 8 : i2 + 3;
            n.a.a.n.c.r1.w0 w0VarA = a(list, d4, i3, false);
            if (!(w0VarA instanceof n.a.a.n.c.r1.x)) {
                return w0VarA;
            }
            n.a.a.n.c.r1.w0 w0VarA2 = a(list, d3, i3, false);
            return !(w0VarA2 instanceof n.a.a.n.c.r1.x) ? w0VarA2 : c(d, d4, d3, (n.a.a.n.c.r1.x) w0VarA, (n.a.a.n.c.r1.x) w0VarA2, i2);
        }
        int i4 = 0;
        int i5 = 0;
        for (Double d5 : list) {
            if (d5.doubleValue() < d) {
                i5++;
            } else if (d5.doubleValue() > d) {
                i4++;
            }
        }
        if (i4 == list.size() || i5 == list.size()) {
            return n.a.a.n.c.r1.o.f2386i;
        }
        int i6 = i4 + i5;
        return i6 == 0 ? new n.a.a.n.c.r1.x(0.0d) : new n.a.a.n.c.r1.x(d(BigDecimal.valueOf(i5 / i6), i2));
    }

    public static List<n.a.a.n.c.r1.w0> b(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (!(w0Var instanceof n.a.a.n.c.r1.j)) {
            return Collections.singletonList(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
        }
        n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
        ArrayList arrayList = new ArrayList();
        for (int firstRow = jVar.getFirstRow(); firstRow <= jVar.getLastRow(); firstRow++) {
            for (int firstColumn = jVar.getFirstColumn(); firstColumn <= jVar.getLastColumn(); firstColumn++) {
                arrayList.add(n.a.a.n.c.r1.z.i(jVar.m(firstRow, firstColumn), firstRow, firstColumn));
            }
        }
        return arrayList;
    }

    public static n.a.a.n.c.r1.x c(double d, double d2, double d3, n.a.a.n.c.r1.x xVar, n.a.a.n.c.r1.x xVar2, int i2) {
        double d4 = d3 - d2;
        double d5 = d - d2;
        return new n.a.a.n.c.r1.x(d(BigDecimal.valueOf(xVar.r()).add(new BigDecimal(n.a.a.n.e.c0.h(xVar2.r() - xVar.r())).multiply(BigDecimal.valueOf(d5 / d4))), i2));
    }

    public static double d(BigDecimal bigDecimal, int i2) {
        return bigDecimal.setScale(i2 + 3, RoundingMode.HALF_UP).setScale(i2, RoundingMode.DOWN).doubleValue();
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        int i4;
        if (w0VarArr.length < 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[1], i2, i3));
            ArrayList arrayList = new ArrayList();
            try {
                for (n.a.a.n.c.r1.w0 w0Var : b(w0VarArr[0], i2, i3)) {
                    if (!(w0Var instanceof n.a.a.n.c.r1.l) && !(w0Var instanceof n.a.a.n.c.r1.u)) {
                        arrayList.add(Double.valueOf(n.a.a.n.c.r1.z.e(w0Var)));
                    }
                }
                if (arrayList.isEmpty()) {
                    return n.a.a.n.c.r1.o.f2385h;
                }
                if (w0VarArr.length > 2) {
                    try {
                        int iF = n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0VarArr[2], i2, i3));
                        if (iF < 1) {
                            return n.a.a.n.c.r1.o.f2385h;
                        }
                        i4 = iF;
                    } catch (n.a.a.n.c.r1.p e) {
                        return e.a();
                    }
                } else {
                    i4 = 3;
                }
                return a(arrayList, dE, i4, true);
            } catch (n.a.a.n.c.r1.p e2) {
                n.a.a.n.c.r1.o oVarA = e2.a();
                return oVarA != n.a.a.n.c.r1.o.f2386i ? oVarA : n.a.a.n.c.r1.o.f2385h;
            }
        } catch (n.a.a.n.c.r1.p e3) {
            n.a.a.n.c.r1.o oVarA2 = e3.a();
            n.a.a.n.c.r1.o oVar = n.a.a.n.c.r1.o.f2385h;
            return oVarA2 == oVar ? oVarA2 : oVar;
        }
    }
}
