package n.a.a.n.c.t1;

import com.auto.exceldeps.log4j.Logger;

/* loaded from: classes.dex */
public final class a7 implements j6 {
    private static final Logger a = n.a.a.i.b.a(a7.class);
    public static final j6 b = new a7();

    private a7() {
    }

    private static boolean a(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        if (length < 0) {
            return false;
        }
        if (Character.isWhitespace(charSequence.charAt(0))) {
            return true;
        }
        return Character.isWhitespace(charSequence.charAt(length));
    }

    private static boolean b(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.t0 t0Var) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, t0Var.t(), t0Var.k());
        if (w0VarI == n.a.a.n.c.r1.l.a || w0VarI == n.a.a.n.c.r1.u.a) {
            return false;
        }
        return n.a.a.n.c.r1.z.d(w0VarI, false).booleanValue();
    }

    private static n.a.a.n.c.r1.w0 d(n.a.a.n.c.t0 t0Var, String str, boolean z) {
        String str2;
        String strSubstring;
        String str3;
        String strTrim;
        String strTrim2;
        int iLastIndexOf = str.lastIndexOf(33);
        if (iLastIndexOf < 0) {
            strSubstring = str;
            str2 = null;
            str3 = null;
        } else {
            String[] strArrE = e(str.subSequence(0, iLastIndexOf));
            if (strArrE == null) {
                return n.a.a.n.c.r1.o.f;
            }
            str2 = strArrE[0];
            String str4 = strArrE[1];
            strSubstring = str.substring(iLastIndexOf + 1);
            str3 = str4;
        }
        if (z && n.a.a.n.d.r0.y.matcher(strSubstring).matches()) {
            try {
                return t0Var.h(n.a.a.n.c.b0.b0(strSubstring, (n.a.a.n.c.c0) t0Var.v(), t0Var.t()));
            } catch (n.a.a.n.c.x unused) {
                return n.a.a.n.c.r1.o.f;
            }
        }
        int iIndexOf = strSubstring.indexOf(58);
        if (iIndexOf < 0) {
            strTrim2 = strSubstring.trim();
            strTrim = null;
        } else {
            String strTrim3 = strSubstring.substring(0, iIndexOf).trim();
            strTrim = strSubstring.substring(iIndexOf + 1).trim();
            strTrim2 = strTrim3;
        }
        try {
            return t0Var.l(str2, str3, strTrim2, strTrim, z);
        } catch (Exception e) {
            a.atWarn().log("Indirect function: failed to parse reference {}", str, e);
            return n.a.a.n.c.r1.o.f;
        }
    }

    private static String[] e(CharSequence charSequence) {
        int i2;
        String strF;
        int length = charSequence.length() - 1;
        if (length < 0 || a(charSequence)) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        if (Character.isWhitespace(cCharAt)) {
            return null;
        }
        if (cCharAt != '\'') {
            if (cCharAt != '[') {
                return new String[]{null, charSequence.toString()};
            }
            int iLastIndexOf = charSequence.toString().lastIndexOf(93);
            if (iLastIndexOf < 0) {
                return null;
            }
            CharSequence charSequenceSubSequence = charSequence.subSequence(1, iLastIndexOf);
            if (a(charSequenceSubSequence)) {
                return null;
            }
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(iLastIndexOf + 1, charSequence.length());
            if (a(charSequenceSubSequence2)) {
                return null;
            }
            return new String[]{charSequenceSubSequence.toString(), charSequenceSubSequence2.toString()};
        }
        if (charSequence.charAt(length) != '\'') {
            return null;
        }
        char cCharAt2 = charSequence.charAt(1);
        if (Character.isWhitespace(cCharAt2)) {
            return null;
        }
        if (cCharAt2 == '[') {
            int iLastIndexOf2 = charSequence.toString().lastIndexOf(93);
            if (iLastIndexOf2 < 0 || (strF = f(charSequence.subSequence(2, iLastIndexOf2))) == null || a(strF)) {
                return null;
            }
            i2 = iLastIndexOf2 + 1;
        } else {
            i2 = 1;
            strF = null;
        }
        String strF2 = f(charSequence.subSequence(i2, length));
        if (strF2 == null) {
            return null;
        }
        return new String[]{strF, strF2};
    }

    private static String f(CharSequence charSequence) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 == '\'') {
                i2++;
                if (i2 >= length || (cCharAt = charSequence.charAt(i2)) != '\'') {
                    return null;
                }
                cCharAt2 = cCharAt;
            }
            sb.append(cCharAt2);
            i2++;
        }
        return sb.toString();
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        boolean zB = true;
        if (w0VarArr.length < 1) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            String strG = n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k()));
            int length = w0VarArr.length;
            if (length != 1) {
                if (length != 2) {
                    return n.a.a.n.c.r1.o.e;
                }
                zB = b(w0VarArr[1], t0Var);
            }
            return d(t0Var, strG, zB);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
