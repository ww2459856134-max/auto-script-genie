package n.a.a.n.c.p1;

import java.util.ArrayList;
import n.a.a.n.c.r1.m0;
import n.a.a.n.c.r1.w0;

/* loaded from: classes.dex */
final class c {
    public static final c a = new c();

    private c() {
    }

    public double a(w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, (short) i3);
        if (!(w0VarI instanceof m0)) {
            return n.a.a.n.c.r1.z.e(w0VarI);
        }
        String stringValue = ((m0) w0VarI).getStringValue();
        Double dK = n.a.a.n.c.r1.z.k(stringValue);
        return dK != null ? dK.doubleValue() : n.a.a.n.d.y.e(n.a.a.n.e.u.a(stringValue), false);
    }

    public double[] b(w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (w0Var == null) {
            return new double[0];
        }
        if (w0Var instanceof m0) {
            return new double[]{a(w0Var, i2, i3)};
        }
        if (!(w0Var instanceof n.a.a.n.c.r1.k)) {
            return new double[]{n.a.a.n.c.r1.z.e(w0Var)};
        }
        ArrayList arrayList = new ArrayList();
        n.a.a.n.c.r1.k kVar = (n.a.a.n.c.r1.k) w0Var;
        for (int firstRow = kVar.getFirstRow(); firstRow <= kVar.getLastRow(); firstRow++) {
            for (int firstColumn = kVar.getFirstColumn(); firstColumn <= kVar.getLastColumn(); firstColumn++) {
                arrayList.add(Double.valueOf(a(kVar.m(firstRow, firstColumn), firstRow, firstColumn)));
            }
        }
        double[] dArr = new double[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            dArr[i4] = ((Double) arrayList.get(i4)).doubleValue();
        }
        return dArr;
    }

    public double c(w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (w0Var == null) {
            return 0.0d;
        }
        return n.a.a.n.c.r1.z.e(w0Var);
    }
}
