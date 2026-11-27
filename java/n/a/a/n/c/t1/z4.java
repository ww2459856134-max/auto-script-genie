package n.a.a.n.c.t1;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class z4 implements n6 {
    private final x4 a;

    public z4(x4 x4Var) {
        this.a = x4Var;
    }

    private static boolean a(n.a.a.n.c.r1.j jVar, int i2, n.a.a.n.c.r1.j jVar2) throws n.a.a.n.c.r1.p {
        int iA = jVar2.a();
        int i3 = 1;
        while (true) {
            boolean z = false;
            if (i3 >= iA) {
                return false;
            }
            int width = jVar2.getWidth();
            int i4 = 0;
            while (true) {
                if (i4 >= width) {
                    z = true;
                    break;
                }
                n.a.a.n.c.r1.w0 w0VarH = h(jVar2, i3, i4);
                if (!(w0VarH instanceof n.a.a.n.c.r1.l)) {
                    n.a.a.n.c.r1.w0 w0VarH2 = h(jVar2, 0, i4);
                    if (!(w0VarH2 instanceof n.a.a.n.c.r1.n0)) {
                        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                    }
                    if (!(b(w0VarH2, jVar) != -1)) {
                        if (n.a.a.n.c.r1.z.g(w0VarH).isEmpty()) {
                            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                        }
                        throw new n.a.a.n.c.r1.v("D* function with formula conditions");
                    }
                    if (!l(h(jVar, i2, b(w0VarH2, jVar)), w0VarH)) {
                        break;
                    }
                }
                i4++;
            }
            if (z) {
                return true;
            }
            i3++;
        }
    }

    private static int b(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.j jVar) throws n.a.a.n.c.r1.p {
        if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
            return c(jVar, n.a.a.n.c.r1.z.g(w0Var));
        }
        int iF = n.a.a.n.c.r1.z.f(w0Var) - 1;
        if (iF < 0 || iF >= jVar.getWidth()) {
            return -1;
        }
        return iF;
    }

    private static int c(n.a.a.n.c.r1.j jVar, String str) {
        int width = jVar.getWidth();
        for (int i2 = 0; i2 < width; i2++) {
            n.a.a.n.c.r1.w0 w0VarH = h(jVar, 0, i2);
            if (!(w0VarH instanceof n.a.a.n.c.r1.l) && !(w0VarH instanceof n.a.a.n.c.r1.o) && str.equalsIgnoreCase(n.a.a.n.c.r1.z.g(w0VarH))) {
                return i2;
            }
        }
        return -1;
    }

    private static Double d(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.y) {
            return Double.valueOf(((n.a.a.n.c.r1.y) w0Var).r());
        }
        if (w0Var instanceof n.a.a.n.c.r1.n0) {
            try {
                return Double.valueOf(Double.parseDouble(((n.a.a.n.c.r1.n0) w0Var).getStringValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static boolean f(String str) throws NumberFormatException {
        try {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException unused) {
                Double.parseDouble(str);
                return true;
            }
        } catch (NumberFormatException unused2) {
            return false;
        }
    }

    private static n.a.a.n.c.r1.w0 h(n.a.a.n.c.r1.j jVar, int i2, int i3) {
        try {
            return n.a.a.n.c.r1.z.i(jVar.p(i2, i3), jVar.getFirstRow() + i2, jVar.getFirstColumn() + i3);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private static boolean l(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) throws n.a.a.n.c.r1.p {
        if (!(w0Var2 instanceof n.a.a.n.c.r1.m0)) {
            if (!(w0Var2 instanceof n.a.a.n.c.r1.y)) {
                return (w0Var2 instanceof n.a.a.n.c.r1.o) && (w0Var instanceof n.a.a.n.c.r1.o) && ((n.a.a.n.c.r1.o) w0Var2).u() == ((n.a.a.n.c.r1.o) w0Var).u();
            }
            double dR = ((n.a.a.n.c.r1.y) w0Var2).r();
            Double d = d(w0Var);
            return d != null && dR == d.doubleValue();
        }
        String stringValue = ((n.a.a.n.c.r1.m0) w0Var2).getStringValue();
        if (stringValue.startsWith("<")) {
            String strSubstring = stringValue.substring(1);
            if (strSubstring.startsWith("=")) {
                return m(w0Var, y4.smallerEqualThan, strSubstring.substring(1));
            }
            if (!strSubstring.startsWith(">")) {
                return m(w0Var, y4.smallerThan, strSubstring);
            }
            String strSubstring2 = strSubstring.substring(1);
            return f(strSubstring2) ? m(w0Var, y4.notEqual, strSubstring2) : n(w0Var, y4.notEqual, strSubstring2);
        }
        if (stringValue.startsWith(">")) {
            String strSubstring3 = stringValue.substring(1);
            if (strSubstring3.startsWith("=")) {
                return m(w0Var, y4.largerEqualThan, strSubstring3.substring(1));
            }
            return m(w0Var, y4.largerThan, strSubstring3);
        }
        if (stringValue.startsWith("=")) {
            String strSubstring4 = stringValue.substring(1);
            return strSubstring4.isEmpty() ? w0Var instanceof n.a.a.n.c.r1.l : f(strSubstring4) ? m(w0Var, y4.equal, strSubstring4) : n(w0Var, y4.equal, strSubstring4);
        }
        if (stringValue.isEmpty()) {
            return w0Var instanceof n.a.a.n.c.r1.m0;
        }
        String lowerCase = (w0Var instanceof n.a.a.n.c.r1.l ? "" : n.a.a.n.c.r1.z.g(w0Var)).toLowerCase(n.a.a.o.a1.e());
        String lowerCase2 = stringValue.toLowerCase(n.a.a.o.a1.e());
        Pattern patternG = k4.g(lowerCase2);
        return patternG == null ? lowerCase.startsWith(lowerCase2) : patternG.matcher(lowerCase).matches();
    }

    private static boolean m(n.a.a.n.c.r1.w0 w0Var, y4 y4Var, String str) throws NumberFormatException, n.a.a.n.c.r1.p {
        double d;
        if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
            return false;
        }
        double dR = ((n.a.a.n.c.r1.y) w0Var).r();
        try {
            try {
                d = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                d = Double.parseDouble(str);
            }
            int iA = n.a.a.n.e.b0.a(dR, d);
            switch (w4.a[y4Var.ordinal()]) {
                case 1:
                    return iA > 0;
                case 2:
                    return iA >= 0;
                case 3:
                    return iA < 0;
                case 4:
                    return iA <= 0;
                case 5:
                    return iA == 0;
                case 6:
                    return iA != 0;
                default:
                    return false;
            }
        } catch (NumberFormatException unused2) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
    }

    private static boolean n(n.a.a.n.c.r1.w0 w0Var, y4 y4Var, String str) {
        String strG = w0Var instanceof n.a.a.n.c.r1.l ? "" : n.a.a.n.c.r1.z.g(w0Var);
        int i2 = w4.a[y4Var.ordinal()];
        if (i2 == 5) {
            return strG.equalsIgnoreCase(str);
        }
        if (i2 != 6) {
            return false;
        }
        return !strG.equalsIgnoreCase(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // n.a.a.n.c.t1.n6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        int iRound;
        int iA;
        if (!(w0Var instanceof n.a.a.n.c.r1.j) || !(w0Var3 instanceof n.a.a.n.c.r1.j)) {
            return n.a.a.n.c.r1.o.e;
        }
        n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
        n.a.a.n.c.r1.j jVar2 = (n.a.a.n.c.r1.j) w0Var3;
        u6 u6VarA = this.a.a();
        int i4 = -1;
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var2, i2, i3);
            iRound = w0VarI instanceof n.a.a.n.c.r1.y ? ((int) Math.round(((n.a.a.n.c.r1.y) w0VarI).r())) - 1 : b(w0VarI, jVar);
            if (iRound == -1) {
                try {
                    if (!u6VarA.c()) {
                        return n.a.a.n.c.r1.o.e;
                    }
                } catch (n.a.a.n.c.r1.p e) {
                    i4 = iRound;
                    e = e;
                    if (!u6VarA.c()) {
                        return e.a();
                    }
                    iRound = i4;
                    iA = jVar.a();
                    while (i < iA) {
                    }
                    return u6VarA.a();
                } catch (Exception unused) {
                    i4 = iRound;
                    if (!u6VarA.c()) {
                        return n.a.a.n.c.r1.o.e;
                    }
                    iRound = i4;
                    iA = jVar.a();
                    while (i < iA) {
                    }
                    return u6VarA.a();
                }
            }
        } catch (n.a.a.n.c.r1.p e2) {
            e = e2;
        } catch (Exception unused2) {
        }
        iA = jVar.a();
        for (int i5 = 1; i5 < iA; i5++) {
            try {
                if (a(jVar, i5, jVar2)) {
                    n.a.a.n.c.r1.w0 w0VarH = h(jVar, i5, iRound);
                    if (iRound < 0 && u6VarA.c() && !(w0VarH instanceof n.a.a.n.c.r1.y)) {
                        w0VarH = n.a.a.n.c.r1.x.c;
                    }
                    if (!u6VarA.b(w0VarH)) {
                        break;
                    }
                }
            } catch (n.a.a.n.c.r1.p unused3) {
                return n.a.a.n.c.r1.o.e;
            }
        }
        return u6VarA.a();
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        return w0VarArr.length == 3 ? e(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2]) : n.a.a.n.c.r1.o.e;
    }
}
