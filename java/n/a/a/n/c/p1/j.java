package n.a.a.n.c.p1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.ea;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class j implements j6 {
    public static final j6 a = new j(c.a);

    private j(c cVar) {
    }

    private w0 a(List<Double> list, double d, int i2, boolean z) {
        double d2;
        double dDoubleValue;
        double dDoubleValue2 = Double.MAX_VALUE;
        if (z) {
            double dDoubleValue3 = Double.MIN_VALUE;
            dDoubleValue = Double.MIN_VALUE;
            double dDoubleValue4 = Double.MAX_VALUE;
            for (Double d3 : list) {
                if (d3.doubleValue() <= d && d3.doubleValue() > dDoubleValue) {
                    dDoubleValue = d3.doubleValue();
                }
                if (d3.doubleValue() > d && d3.doubleValue() < dDoubleValue4) {
                    dDoubleValue4 = d3.doubleValue();
                }
                if (d3.doubleValue() < dDoubleValue2) {
                    dDoubleValue2 = d3.doubleValue();
                }
                if (d3.doubleValue() > dDoubleValue3) {
                    dDoubleValue3 = d3.doubleValue();
                }
            }
            if (d < dDoubleValue2 || d > dDoubleValue3) {
                return n.a.a.n.c.r1.o.f2386i;
            }
            d2 = dDoubleValue4;
        } else {
            d2 = Double.MAX_VALUE;
            dDoubleValue = Double.MIN_VALUE;
        }
        if (!z || dDoubleValue == d || d2 == d) {
            int i3 = 0;
            Iterator<Double> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().doubleValue() < d) {
                    i3++;
                }
            }
            return new n.a.a.n.c.r1.x(ea.d(BigDecimal.valueOf((i3 + 1) / (list.size() + 1)), i2));
        }
        int i4 = i2 < 5 ? 8 : i2 + 3;
        w0 w0VarA = a(list, dDoubleValue, i4, false);
        if (!(w0VarA instanceof n.a.a.n.c.r1.x)) {
            return w0VarA;
        }
        w0 w0VarA2 = a(list, d2, i4, false);
        if (w0VarA2 instanceof n.a.a.n.c.r1.x) {
            return ea.c(d, dDoubleValue, d2, (n.a.a.n.c.r1.x) w0VarA, (n.a.a.n.c.r1.x) w0VarA2, i2);
        }
        return w0VarA2;
    }

    private w0 b(w0[] w0VarArr, int i2, int i3) {
        int i4;
        if (w0VarArr.length < 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[1], i2, i3));
            ArrayList arrayList = new ArrayList();
            try {
                for (w0 w0Var : ea.b(w0VarArr[0], i2, i3)) {
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

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        return b(w0VarArr, t0Var.t(), t0Var.k());
    }
}
