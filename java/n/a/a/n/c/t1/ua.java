package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class ua extends ec {
    private static String a(String str, String str2, String str3) {
        if (str2.length() < 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                sb.append(str.substring(length));
                return sb.toString();
            }
            sb.append((CharSequence) str, length, iIndexOf);
            sb.append(str3);
            length = str2.length() + iIndexOf;
        }
    }

    private static String b(String str, String str2, String str3, int i2) {
        if (str2.length() < 1) {
            return str;
        }
        int length = 0;
        int i3 = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                return str;
            }
            i3++;
            if (i3 == i2) {
                return str.substring(0, iIndexOf) + str3 + str.substring(iIndexOf + str2.length());
            }
            length = iIndexOf + str2.length();
        }
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            return new n.a.a.n.c.r1.m0(a(vb.b(w0Var, i2, i3), vb.b(w0Var2, i2, i3), vb.b(w0Var3, i2, i3)));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.o6
    public n.a.a.n.c.r1.w0 j(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, n.a.a.n.c.r1.w0 w0Var4) {
        try {
            String strB = vb.b(w0Var, i2, i3);
            String strB2 = vb.b(w0Var2, i2, i3);
            String strB3 = vb.b(w0Var3, i2, i3);
            int iA = vb.a(w0Var4, i2, i3);
            return iA < 1 ? n.a.a.n.c.r1.o.e : new n.a.a.n.c.r1.m0(b(strB, strB2, strB3, iA));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
