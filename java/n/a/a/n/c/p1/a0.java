package n.a.a.n.c.p1;

import java.util.Calendar;
import n.a.a.o.a1;

/* loaded from: classes.dex */
abstract class a0 {
    private static double a(int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 <= i3; i5++) {
            i4 += n(i5) ? 366 : 365;
        }
        return i4 / ((i3 - i2) + 1.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static double b(int i2, int i3) {
        z zVarI = i(i2);
        z zVarI2 = i(i3);
        int i4 = zVarI.c;
        int i5 = zVarI2.c;
        if (i4 != 31 || i5 != 31) {
            if (i4 != 31) {
                if (i4 == 30 && i5 == 31) {
                    i5 = 30;
                } else if (zVarI.b == 2 && m(zVarI)) {
                    if (zVarI2.b == 2 && m(zVarI2)) {
                        i4 = 30;
                        i5 = 30;
                    } else {
                        i4 = 30;
                    }
                }
            }
        }
        return h(zVarI, zVarI2, i4, i5);
    }

    private static double c(int i2, int i3) {
        z zVarI = i(i2);
        z zVarI2 = i(i3);
        return j(zVarI.d, zVarI2.d) / (l(zVarI, zVarI2) ? a(zVarI.a, zVarI2.a) : o(zVarI, zVarI2) ? 366.0d : 365.0d);
    }

    private static double d(int i2, int i3) {
        return (i3 - i2) / 360.0d;
    }

    private static double e(double d, double d2) {
        return (d2 - d) / 365.0d;
    }

    private static double f(int i2, int i3) {
        z zVarI = i(i2);
        z zVarI2 = i(i3);
        int i4 = zVarI.c;
        int i5 = zVarI2.c;
        if (i4 == 31) {
            i4 = 30;
        }
        if (i5 == 31) {
            i5 = 30;
        }
        return h(zVarI, zVarI2, i4, i5);
    }

    public static double g(double d, double d2, int i2) throws n.a.a.n.c.r1.p {
        if (i2 < 0 || i2 >= 5) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
        }
        int iFloor = (int) Math.floor(d);
        int iFloor2 = (int) Math.floor(d2);
        if (iFloor == iFloor2) {
            return 0.0d;
        }
        if (iFloor > iFloor2) {
            iFloor2 = iFloor;
            iFloor = iFloor2;
        }
        if (i2 == 0) {
            return b(iFloor, iFloor2);
        }
        if (i2 == 1) {
            return c(iFloor, iFloor2);
        }
        if (i2 == 2) {
            return d(iFloor, iFloor2);
        }
        if (i2 == 3) {
            return e(iFloor, iFloor2);
        }
        if (i2 == 4) {
            return f(iFloor, iFloor2);
        }
        throw new IllegalStateException("cannot happen");
    }

    private static double h(z zVar, z zVar2, int i2, int i3) {
        return ((((zVar2.a - zVar.a) * 360.0d) + ((zVar2.b - zVar.b) * 30.0d)) + ((i3 - i2) * 1.0d)) / 360.0d;
    }

    private static z i(int i2) {
        Calendar calendarD = a1.d(a1.a);
        n.a.a.n.d.y.z(calendarD, i2, 0, false, false);
        return new z(calendarD);
    }

    private static int j(long j2, long j3) {
        long j4 = j3 - j2;
        if (((int) ((j4 % 86400000) / 3600000)) == 0) {
            return (int) ((j4 / 8.64E7d) + 0.5d);
        }
        throw new IllegalStateException("Unexpected date diff between " + j2 + " and " + j3);
    }

    private static int k(z zVar) {
        switch (zVar.b) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
            default:
                return n(zVar.a) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
    }

    private static boolean l(z zVar, z zVar2) {
        int i2 = zVar.a;
        int i3 = zVar2.a;
        if (i2 == i3) {
            return false;
        }
        if (i2 + 1 != i3) {
            return true;
        }
        int i4 = zVar.b;
        int i5 = zVar2.b;
        if (i4 > i5) {
            return false;
        }
        return i4 < i5 || zVar.c < zVar2.c;
    }

    private static boolean m(z zVar) {
        int i2 = zVar.c;
        return i2 >= 28 && i2 == k(zVar);
    }

    private static boolean n(int i2) {
        if (i2 % 4 != 0) {
            return false;
        }
        return i2 % 400 == 0 || i2 % 100 != 0;
    }

    private static boolean o(z zVar, z zVar2) {
        int i2;
        int i3;
        if (n(zVar.a)) {
            return zVar.a == zVar2.a || (i3 = zVar.b) == 1 || i3 == 2;
        }
        if (!n(zVar2.a) || (i2 = zVar2.b) == 1) {
            return false;
        }
        return i2 != 2 || zVar2.c == 29;
    }
}
