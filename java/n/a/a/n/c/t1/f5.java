package n.a.a.n.c.t1;

import java.util.Calendar;

/* loaded from: classes.dex */
public final class f5 extends d6 {
    public static final p6 a = new f5();

    private f5() {
    }

    private static double a(int i2, int i3, int i4) throws n.a.a.n.c.r1.p {
        if (i2 < 0) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        while (i3 < 0) {
            i2--;
            i3 += 12;
        }
        if (i2 == 1900 && i3 == 1 && i4 == 29) {
            return 60.0d;
        }
        Calendar calendarB = n.a.a.o.a1.b(i2, i3, (i2 != 1900 || ((i3 != 0 || i4 < 60) && (i3 != 1 || i4 < 30))) ? i4 : i4 - 1);
        if (i4 < 0 && calendarB.get(1) == 1900 && i3 > 1 && calendarB.get(2) < 2) {
            calendarB.add(5, 1);
        }
        return n.a.a.n.d.y.g(calendarB.getTime(), false);
    }

    private static int b(double d) {
        int i2 = (int) d;
        if (i2 < 0) {
            return -1;
        }
        return i2 < 1900 ? i2 + 1900 : i2;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            double dA = a(b(y9.D(w0Var, i2, i3)), (int) (y9.D(w0Var2, i2, i3) - 1.0d), (int) y9.D(w0Var3, i2, i3));
            y9.a(dA);
            return new n.a.a.n.c.r1.x(dA);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
