package n.a.a.n.c.t1;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;

/* loaded from: classes.dex */
public class i3 extends b6 implements j6 {
    public static final j6 a = new i3();

    private int l(String str) {
        int length = str.length();
        int i2 = length - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i3 += (int) (Integer.parseInt(str.substring(i4, r4)) * Math.pow(2.0d, i2));
            i2--;
        }
        return i3;
    }

    private static String m(String str) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(Long.parseLong(str, 2) ^ ((1 << str.length()) - 1)));
        int length = str.length() - sb.length();
        if (length > 0) {
            sb.insert(0, n.a.a.o.j1.j('0', length));
        }
        return sb.toString();
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : m(t0Var.t(), t0Var.k(), w0VarArr[0]);
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        String strG;
        String strSubstring;
        boolean zStartsWith;
        String strValueOf;
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            strG = n.a.a.n.c.r1.z.g(c0Var.o(c0Var.g()));
        } else {
            strG = n.a.a.n.c.r1.z.g(w0Var);
        }
        if (strG.length() > 10) {
            return n.a.a.n.c.r1.o.f2385h;
        }
        if (strG.length() < 10) {
            strSubstring = strG;
            zStartsWith = true;
        } else {
            strSubstring = strG.substring(1);
            zStartsWith = strG.startsWith("0");
        }
        try {
            if (zStartsWith) {
                strValueOf = String.valueOf(l(strSubstring));
            } else {
                strValueOf = ProcessIdUtil.DEFAULT_PROCESSID + (l(m(strSubstring)) + 1);
            }
            return new n.a.a.n.c.r1.x(Long.parseLong(strValueOf));
        } catch (NumberFormatException unused) {
            return n.a.a.n.c.r1.o.f2385h;
        }
    }
}
