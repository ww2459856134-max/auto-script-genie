package n.a.a.n.c.t1;

import java.time.LocalDate;
import java.util.Calendar;

/* loaded from: classes.dex */
public class h5 extends dc {
    private static double l(double d, double d2, boolean z) {
        Calendar calendarM = m(d);
        int[] iArrN = n(m(d2), o(calendarM, z), z);
        return (((iArrN[0] * 360.0d) + (iArrN[1] * 30.0d)) + iArrN[2]) - (((r9[0] * 360.0d) + (r9[1] * 30.0d)) + r9[2]);
    }

    private static Calendar m(double d) {
        Calendar calendarA = n.a.a.o.a1.a();
        calendarA.setTime(n.a.a.n.d.y.l(d, false));
        return calendarA;
    }

    private static int[] n(Calendar calendar, int[] iArr, boolean z) {
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        int i4 = 30;
        int iMin = Math.min(30, calendar.get(5));
        if (z || calendar.get(5) != 31) {
            i4 = iMin;
        } else if (iArr[2] < 30) {
            calendar.set(5, 1);
            calendar.add(2, 1);
            i2 = calendar.get(1);
            i3 = calendar.get(2);
            i4 = 1;
        }
        return new int[]{i2, i3, i4};
    }

    private static int[] o(Calendar calendar, boolean z) {
        return new int[]{calendar.get(1), calendar.get(2), (z || !p(calendar)) ? Math.min(30, calendar.get(5)) : 30};
    }

    private static boolean p(Calendar calendar) {
        return calendar.get(5) == calendar.getActualMaximum(5);
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            LocalDate localDateE = i5.e(w0Var, i2, i3);
            LocalDate localDateE2 = i5.e(w0Var2, i2, i3);
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var3, i2, i3);
            boolean z = false;
            Boolean boolD = n.a.a.n.c.r1.z.d(w0VarI, false);
            double d = n.a.a.n.d.y.d(localDateE);
            double d2 = n.a.a.n.d.y.d(localDateE2);
            if (boolD != null && boolD.booleanValue()) {
                z = true;
            }
            return new n.a.a.n.c.r1.x(l(d, d2, z));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            return new n.a.a.n.c.r1.x(l(n.a.a.n.d.y.d(i5.e(w0Var, i2, i3)), n.a.a.n.d.y.d(i5.e(w0Var2, i2, i3)), false));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
