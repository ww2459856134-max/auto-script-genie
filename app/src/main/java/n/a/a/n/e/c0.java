package n.a.a.n.e;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public abstract class c0 {
    private static void a(StringBuilder sb, int i2) {
        if (i2 >= 10) {
            sb.append(i2);
        } else {
            sb.append('0');
            sb.append((char) (i2 + 48));
        }
    }

    private static void b(StringBuilder sb, a0 a0Var) {
        String strF;
        a0 a0VarH = a0Var.h();
        int iC = a0VarH.c();
        if (Math.abs(iC) > 98) {
            strF = a0VarH.g();
            if (strF.length() == 16) {
                iC++;
            }
        } else {
            strF = a0VarH.f();
        }
        int iC2 = c(strF);
        if (iC < 0) {
            e(sb, strF, iC, iC2);
        } else {
            d(sb, strF, iC, iC2);
        }
    }

    private static int c(String str) {
        int length = str.length() - 1;
        while (str.charAt(length) == '0') {
            length--;
            if (length < 0) {
                throw new IllegalStateException("No non-zero digits found");
            }
        }
        return length + 1;
    }

    private static void d(StringBuilder sb, String str, int i2, int i3) {
        if (i2 > 19) {
            sb.append(str.charAt(0));
            if (i3 > 1) {
                sb.append(NameUtil.PERIOD);
                sb.append(str.subSequence(1, i3));
            }
            sb.append("E+");
            a(sb, i2);
            return;
        }
        int i4 = (i3 - i2) - 1;
        if (i4 > 0) {
            int i5 = i2 + 1;
            sb.append(str.subSequence(0, i5));
            sb.append(NameUtil.PERIOD);
            sb.append(str.subSequence(i5, i3));
            return;
        }
        sb.append(str.subSequence(0, i3));
        for (int i6 = -i4; i6 > 0; i6--) {
            sb.append('0');
        }
    }

    private static void e(StringBuilder sb, String str, int i2, int i3) {
        int i4 = -i2;
        int i5 = i4 - 1;
        if (!f(i5 + 2 + i3)) {
            sb.append("0.");
            while (i5 > 0) {
                sb.append('0');
                i5--;
            }
            sb.append(str.subSequence(0, i3));
            return;
        }
        sb.append(str.charAt(0));
        if (i3 > 1) {
            sb.append(NameUtil.PERIOD);
            sb.append(str.subSequence(1, i3));
        }
        sb.append("E-");
        a(sb, i4);
    }

    private static boolean f(int i2) {
        return i2 > 20;
    }

    static String g(long j2) {
        boolean z = false;
        boolean z2 = j2 < 0;
        if (z2) {
            j2 &= Long.MAX_VALUE;
        }
        if (j2 == 0) {
            return z2 ? "-0" : "0";
        }
        v vVar = new v(j2);
        if (vVar.b() < -1022) {
            return z2 ? "-0" : "0";
        }
        if (vVar.b() != 1024) {
            z = z2;
        } else if (j2 == -276939487313920L) {
            return "3.484840871308E+308";
        }
        a0 a0VarD = vVar.d();
        StringBuilder sb = new StringBuilder(21);
        if (z) {
            sb.append(NameUtil.HYPHEN);
        }
        b(sb, a0VarD);
        return sb.toString();
    }

    public static String h(double d) {
        return g(Double.doubleToLongBits(d));
    }
}
