package n.a.a.n.c.r1;

import java.time.DateTimeException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class z {
    private static final Pattern a = Pattern.compile("[\\x00-\\x20]*[+-]?(((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.(\\p{Digit}+)([eE][+-]?(\\p{Digit}+))?))[\\x00-\\x20]*");

    public static w0 a(j jVar, int i2, int i3) throws p {
        w0 w0VarB = b(jVar, i2, i3);
        if (w0VarB instanceof o) {
            throw new p((o) w0VarB);
        }
        return w0VarB;
    }

    private static w0 b(j jVar, int i2, int i3) throws p {
        if (jVar.s()) {
            if (jVar.q()) {
                return jVar.k(0, 0);
            }
            if (jVar.l(i2)) {
                return jVar.m(i2, jVar.getFirstColumn());
            }
            throw p.c();
        }
        if (jVar.q()) {
            if (jVar.i(i3)) {
                return jVar.m(jVar.getFirstRow(), i3);
            }
            throw p.c();
        }
        if (jVar.l(i2) && jVar.i(i3)) {
            return jVar.m(i2, i3);
        }
        throw p.c();
    }

    private static w0 c(c0 c0Var) {
        return c0Var.o(c0Var.g());
    }

    public static Boolean d(w0 w0Var, boolean z) throws p {
        if (w0Var == null || w0Var == l.a) {
            return null;
        }
        if (w0Var instanceof m) {
            return Boolean.valueOf(((m) w0Var).u());
        }
        if (w0Var instanceof m0) {
            if (z) {
                return null;
            }
            String stringValue = ((m0) w0Var).getStringValue();
            if (stringValue.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (stringValue.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            throw new p(o.e);
        }
        if (w0Var instanceof y) {
            double dR = ((y) w0Var).r();
            if (Double.isNaN(dR)) {
                throw new p(o.e);
            }
            return Boolean.valueOf(dR != 0.0d);
        }
        if (w0Var instanceof o) {
            throw new p((o) w0Var);
        }
        throw new IllegalStateException("Unexpected eval (" + w0Var.getClass().getName() + ")");
    }

    public static double e(w0 w0Var) throws p {
        if (w0Var == l.a) {
            return 0.0d;
        }
        if (w0Var instanceof y) {
            return ((y) w0Var).r();
        }
        if (w0Var instanceof m0) {
            String stringValue = ((m0) w0Var).getStringValue();
            Double dK = k(stringValue);
            if (dK == null) {
                dK = j(stringValue);
            }
            if (dK != null) {
                return dK.doubleValue();
            }
            throw p.c();
        }
        if (!(w0Var instanceof n.a.a.n.c.o0)) {
            throw new IllegalStateException("Unexpected arg eval type (" + w0Var.getClass().getName() + ")");
        }
        n.a.a.n.c.o0 o0Var = (n.a.a.n.c.o0) w0Var;
        w0 w0VarU = o0Var.u();
        if (w0VarU != w0Var) {
            return e(w0VarU);
        }
        throw new IllegalStateException("Circular lazy reference " + o0Var);
    }

    public static int f(w0 w0Var) throws p {
        if (w0Var == l.a) {
            return 0;
        }
        return (int) Math.floor(e(w0Var));
    }

    public static String g(w0 w0Var) {
        if (w0Var instanceof n0) {
            return ((n0) w0Var).getStringValue();
        }
        if (w0Var == l.a) {
            return "";
        }
        throw new IllegalArgumentException("Unexpected eval class (" + w0Var.getClass().getName() + ")");
    }

    public static w0 h(j jVar, n.a.a.n.c.l lVar) {
        n.a.a.n.e.m mVarF = lVar.f();
        int iG = lVar.g() - mVarF.b();
        int i2 = lVar.i() - mVarF.a();
        if (jVar.s()) {
            if (jVar.q()) {
                return jVar.k(0, 0);
            }
            if (iG < jVar.a()) {
                return jVar.k(iG, 0);
            }
        } else {
            if (!jVar.q() && iG < jVar.a() && i2 < jVar.getWidth()) {
                return jVar.k(iG, i2);
            }
            if (jVar.q() && i2 < jVar.getWidth()) {
                return jVar.k(0, i2);
            }
        }
        return o.f2386i;
    }

    public static w0 i(w0 w0Var, int i2, int i3) throws p {
        if (w0Var instanceof c0) {
            w0Var = c((c0) w0Var);
        } else if (w0Var instanceof j) {
            w0Var = a((j) w0Var, i2, i3);
        }
        if (w0Var instanceof o) {
            throw new p((o) w0Var);
        }
        return w0Var;
    }

    public static Double j(String str) {
        try {
            return n.a.a.n.d.y.y(str);
        } catch (DateTimeException unused) {
            return null;
        }
    }

    public static Double k(String str) {
        if (a.matcher(str).matches()) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
