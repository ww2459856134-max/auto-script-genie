package n.a.a.n.c;

import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.q1;

/* loaded from: classes.dex */
final class h1 {
    private final n1 a;
    private final p b;
    private final int c;
    private o d;

    public h1(n1 n1Var, p pVar, int i2) {
        if (i2 >= 0) {
            this.a = n1Var;
            this.b = pVar;
            this.c = i2;
        } else {
            throw new IllegalArgumentException("Invalid sheetIndex: " + i2 + ".");
        }
    }

    private o d() {
        if (this.d == null) {
            this.d = this.a.s(this.c);
        }
        return this.d;
    }

    public n.a.a.n.c.r1.w0 a(int i2, int i3) {
        return this.a.k(d(), this.c, i2, i3, this.b);
    }

    public int b() {
        return d().d();
    }

    public int c() {
        return this.a.x().b().c();
    }

    public String e() {
        return this.a.v(this.c);
    }

    public boolean f(int i2) {
        return d().e(i2);
    }

    public boolean g(int i2, int i3) {
        l lVarA = d().a(i2, i3);
        if (lVarA == null || lVarA.b() != n.a.a.n.d.j.FORMULA) {
            return false;
        }
        for (k2 k2Var : this.a.x().q(lVarA)) {
            if ((k2Var instanceof q1) && "SUBTOTAL".equals(((q1) k2Var).u())) {
                return true;
            }
        }
        return false;
    }
}
