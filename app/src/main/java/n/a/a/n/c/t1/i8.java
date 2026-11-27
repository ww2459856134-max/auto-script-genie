package n.a.a.n.c.t1;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
class i8 extends c8 {
    protected final String b;
    protected final Pattern c;
    protected final boolean d;
    protected final boolean e;

    protected i8(n.a.a.n.c.r1.m0 m0Var, boolean z, boolean z2) {
        super(m0Var);
        String stringValue = m0Var.getStringValue();
        this.b = stringValue;
        this.c = k4.g(stringValue);
        this.d = z;
        this.e = z2;
    }

    @Override // n.a.a.n.c.t1.c8
    protected a8 b(n.a.a.n.c.r1.w0 w0Var) {
        String strD = d(w0Var);
        Pattern pattern = this.c;
        return (pattern == null || (!this.e && this.d)) ? a8.f(this.b.compareToIgnoreCase(strD)) : a8.g(pattern.matcher(strD).matches());
    }

    @Override // n.a.a.n.c.t1.c8
    protected String c() {
        return this.b;
    }

    protected String d(n.a.a.n.c.r1.w0 w0Var) {
        return ((n.a.a.n.c.r1.m0) w0Var).getStringValue();
    }
}
