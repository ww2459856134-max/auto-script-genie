package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class l4 extends c6 {
    private double l(n.a.a.n.c.r1.w0 w0Var, z3 z3Var) {
        int iB;
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            iB = a4.c((n.a.a.n.c.r1.c0) w0Var, z3Var);
        } else {
            if (!(w0Var instanceof n.a.a.n.c.i1)) {
                throw new IllegalArgumentException("Bad range arg type (" + w0Var.getClass().getName() + ")");
            }
            iB = a4.b((n.a.a.n.c.i1) w0Var, z3Var);
        }
        return iB;
    }

    static z3 m(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) {
        n.a.a.n.c.r1.w0 w0VarO = o(w0Var, i2, i3);
        if (w0VarO instanceof n.a.a.n.c.r1.x) {
            return new j4(((n.a.a.n.c.r1.x) w0VarO).r(), g4.c);
        }
        if (w0VarO instanceof n.a.a.n.c.r1.m) {
            return new f4(((n.a.a.n.c.r1.m) w0VarO).u(), g4.c);
        }
        if (w0VarO instanceof n.a.a.n.c.r1.m0) {
            return n((n.a.a.n.c.r1.m0) w0VarO);
        }
        if (w0VarO instanceof n.a.a.n.c.r1.o) {
            return new h4(((n.a.a.n.c.r1.o) w0VarO).u(), g4.c);
        }
        if (w0VarO == n.a.a.n.c.r1.l.a) {
            return null;
        }
        throw new IllegalStateException("Unexpected type for criteria (" + w0VarO.getClass().getName() + ")");
    }

    private static z3 n(n.a.a.n.c.r1.m0 m0Var) {
        String stringValue = m0Var.getStringValue();
        g4 g4VarE = g4.e(stringValue);
        String strSubstring = stringValue.substring(g4VarE.d());
        Boolean boolP = p(strSubstring);
        if (boolP != null) {
            return new f4(boolP.booleanValue(), g4VarE);
        }
        Double dK = n.a.a.n.c.r1.z.k(strSubstring);
        if (dK != null) {
            return new j4(dK.doubleValue(), g4VarE);
        }
        n.a.a.n.c.r1.o oVarQ = q(strSubstring);
        return oVarQ != null ? new h4(oVarQ.u(), g4VarE) : new k4(strSubstring, g4VarE);
    }

    private static n.a.a.n.c.r1.w0 o(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) {
        try {
            return n.a.a.n.c.r1.z.i(w0Var, i2, i3);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Boolean p(String str) {
        if (str.length() < 1) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            if ("FALSE".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
        } else if (cCharAt == 'T') {
            if ("TRUE".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
        } else if (cCharAt != 'f') {
            if (cCharAt == 't') {
            }
        }
        return null;
    }

    private static n.a.a.n.c.r1.o q(String str) {
        if (str.length() >= 4 && str.charAt(0) == '#') {
            if (str.equals("#NULL!")) {
                return n.a.a.n.c.r1.o.c;
            }
            if (str.equals("#DIV/0!")) {
                return n.a.a.n.c.r1.o.d;
            }
            if (str.equals("#VALUE!")) {
                return n.a.a.n.c.r1.o.e;
            }
            if (str.equals("#REF!")) {
                return n.a.a.n.c.r1.o.f;
            }
            if (str.equals("#NAME?")) {
                return n.a.a.n.c.r1.o.g;
            }
            if (str.equals("#NUM!")) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            if (str.equals("#N/A")) {
                return n.a.a.n.c.r1.o.f2386i;
            }
        }
        return null;
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        z3 z3VarM = m(w0Var2, i2, i3);
        return z3VarM == null ? n.a.a.n.c.r1.x.c : new n.a.a.n.c.r1.x(l(w0Var, z3VarM));
    }
}
