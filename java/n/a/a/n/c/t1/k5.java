package n.a.a.n.c.t1;

import java.util.Locale;

/* loaded from: classes.dex */
public final class k5 extends cc implements j6 {
    public static final j6 a = new k5();
    private static final long b = Long.parseLong("-549755813888");
    private static final long c = Long.parseLong("549755813887");

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 1 ? m(t0Var.t(), t0Var.k(), w0VarArr[0]) : w0VarArr.length == 2 ? i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        return i(i2, i3, w0Var, null);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        int iIntValue;
        String hexString;
        try {
            Double dK = n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
            if (dK == null) {
                return n.a.a.n.c.r1.o.e;
            }
            if (dK.longValue() < b || dK.longValue() > c) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            if (dK.doubleValue() < 0.0d) {
                iIntValue = 10;
            } else if (w0Var2 != null) {
                try {
                    Double dK2 = n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var2, i2, i3)));
                    if (dK2 == null) {
                        return n.a.a.n.c.r1.o.e;
                    }
                    iIntValue = dK2.intValue();
                    if (iIntValue < 0) {
                        return n.a.a.n.c.r1.o.f2385h;
                    }
                } catch (n.a.a.n.c.r1.p e) {
                    return e.a();
                }
            } else {
                iIntValue = 0;
            }
            if (iIntValue != 0) {
                hexString = String.format(Locale.ROOT, "%0" + iIntValue + "X", Integer.valueOf(dK.intValue()));
            } else {
                hexString = Long.toHexString(dK.longValue());
            }
            if (dK.doubleValue() < 0.0d) {
                hexString = "FF" + hexString.substring(2);
            }
            return new n.a.a.n.c.r1.m0(hexString.toUpperCase(Locale.ROOT));
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }
}
