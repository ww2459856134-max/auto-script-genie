package n.a.a.n.c.t1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f6 implements l6, m6, n6 {
    private n.a.a.n.c.r1.w0 a(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, int i2, int i3) {
        try {
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
            int iF = n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var2, i2, i3));
            Boolean boolD = n.a.a.n.c.r1.z.d(n.a.a.n.c.r1.z.i(w0Var3, i2, i3), false);
            BigDecimal scale = bigDecimalValueOf.setScale(iF, RoundingMode.HALF_UP);
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            decimalFormat.setGroupingUsed(boolD == null || !boolD.booleanValue());
            decimalFormat.setMinimumFractionDigits(Math.max(iF, 0));
            decimalFormat.setMaximumFractionDigits(Math.max(iF, 0));
            return new n.a.a.n.c.r1.m0(decimalFormat.format(scale.doubleValue()));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        int length = w0VarArr.length;
        return length != 1 ? length != 2 ? length != 3 ? n.a.a.n.c.r1.o.e : a(w0VarArr[0], w0VarArr[1], w0VarArr[2], i2, i3) : a(w0VarArr[0], w0VarArr[1], n.a.a.n.c.r1.m.b, i2, i3) : a(w0VarArr[0], new n.a.a.n.c.r1.x(2.0d), n.a.a.n.c.r1.m.b, i2, i3);
    }
}
