package n.a.a.n.c;

import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.q1;
import n.a.a.n.c.u1.x1;
import n.a.a.n.c.u1.y1;

/* loaded from: classes.dex */
final class w0 {
    public static final w0[] e = new w0[0];
    private final k2 a;
    private final w0[] b;
    private final boolean c;
    private final int d;

    public w0(k2 k2Var, w0[] w0VarArr) {
        if (k2Var == null) {
            throw new IllegalArgumentException("token must not be null");
        }
        this.a = k2Var;
        this.b = (w0[]) w0VarArr.clone();
        this.c = g(k2Var);
        int iF = 1;
        for (w0 w0Var : w0VarArr) {
            iF += w0Var.f();
        }
        this.d = this.c ? iF + w0VarArr.length : iF;
    }

    private void a(v0 v0Var) {
        c()[0].b(v0Var);
        int iB = v0Var.b();
        c()[1].b(v0Var);
        int iB2 = v0Var.b();
        n.a.a.n.c.u1.h1 h1VarP = n.a.a.n.c.u1.h1.p(v0Var.e(iB + 1, iB2) + 4);
        if (c().length > 2) {
            c()[2].b(v0Var);
            int iB3 = v0Var.b();
            n.a.a.n.c.u1.h1 h1VarQ = n.a.a.n.c.u1.h1.q(((v0Var.e(iB2 + 1, iB3) + 4) + 4) - 1);
            n.a.a.n.c.u1.h1 h1VarQ2 = n.a.a.n.c.u1.h1.q(3);
            v0Var.d(iB, h1VarP);
            v0Var.d(iB2, h1VarQ);
            v0Var.d(iB3, h1VarQ2);
        } else {
            n.a.a.n.c.u1.h1 h1VarQ3 = n.a.a.n.c.u1.h1.q(3);
            v0Var.d(iB, h1VarP);
            v0Var.d(iB2, h1VarQ3);
        }
        v0Var.a(this.a);
    }

    private void b(v0 v0Var) {
        if (g(this.a)) {
            a(v0Var);
            return;
        }
        k2 k2Var = this.a;
        boolean z = (k2Var instanceof y1) || (k2Var instanceof x1);
        if (z) {
            v0Var.a(k2Var);
        }
        for (int i2 = 0; i2 < c().length; i2++) {
            c()[i2].b(v0Var);
        }
        if (z) {
            return;
        }
        v0Var.a(this.a);
    }

    private int f() {
        return this.d;
    }

    private static boolean g(k2 k2Var) {
        if (k2Var instanceof q1) {
            return "IF".equals(((q1) k2Var).u());
        }
        return false;
    }

    public static k2[] h(w0 w0Var) {
        v0 v0Var = new v0(w0Var.f());
        w0Var.b(v0Var);
        return v0Var.c();
    }

    public w0[] c() {
        return this.b;
    }

    public int d() {
        k2 k2Var = this.a;
        int iL = k2Var instanceof n.a.a.n.c.u1.g1 ? 8 : k2Var.l();
        for (w0 w0Var : this.b) {
            iL += w0Var.d();
        }
        return iL;
    }

    public k2 e() {
        return this.a;
    }

    public w0(k2 k2Var) {
        this(k2Var, e);
    }

    public w0(k2 k2Var, w0 w0Var) {
        this(k2Var, new w0[]{w0Var});
    }

    public w0(k2 k2Var, w0 w0Var, w0 w0Var2) {
        this(k2Var, new w0[]{w0Var, w0Var2});
    }
}
