package n.a.a.n.c.t1;

import java.util.Locale;

/* loaded from: classes.dex */
final class tb extends dc {
    private final boolean a;

    public tb(boolean z) {
        this.a = z;
    }

    private n.a.a.n.c.r1.w0 l(String str, String str2, int i2) {
        int iIndexOf;
        if (this.a) {
            iIndexOf = str.indexOf(str2, i2);
        } else {
            Locale locale = Locale.ROOT;
            iIndexOf = str.toUpperCase(locale).indexOf(str2.toUpperCase(locale), i2);
        }
        return iIndexOf == -1 ? n.a.a.n.c.r1.o.e : new n.a.a.n.c.r1.x(iIndexOf + 1.0d);
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            String strB = vb.b(w0Var, i2, i3);
            String strB2 = vb.b(w0Var2, i2, i3);
            int iA = vb.a(w0Var3, i2, i3) - 1;
            return iA < 0 ? n.a.a.n.c.r1.o.e : l(strB2, strB, iA);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            return l(vb.b(w0Var2, i2, i3), vb.b(w0Var, i2, i3), 0);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
