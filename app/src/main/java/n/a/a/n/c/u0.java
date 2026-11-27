package n.a.a.n.c;

import java.util.HashMap;
import java.util.Map;
import n.a.a.n.c.t1.a7;
import n.a.a.n.c.t1.j6;
import n.a.a.n.c.t1.p6;
import n.a.a.n.c.t1.x2;
import n.a.a.n.c.u1.a2;
import n.a.a.n.c.u1.d2;
import n.a.a.n.c.u1.g2;
import n.a.a.n.c.u1.i2;
import n.a.a.n.c.u1.j2;
import n.a.a.n.c.u1.n2;
import n.a.a.n.c.u1.r1;
import n.a.a.n.c.u1.s1;
import n.a.a.n.c.u1.u1;
import n.a.a.n.c.u1.u2;
import n.a.a.n.c.u1.v1;
import n.a.a.n.c.u1.v2;
import n.a.a.n.c.u1.w1;
import n.a.a.n.c.u1.w2;

/* loaded from: classes.dex */
abstract class u0 {
    private static final Map<Byte, p6> a = c();

    public static n.a.a.n.c.r1.w0 a(g2 g2Var, n.a.a.n.c.r1.w0[] w0VarArr, t0 t0Var) {
        n.a.a.n.c.r1.w0 w0VarB;
        if (g2Var == null) {
            throw new IllegalArgumentException("ptg must not be null");
        }
        p6 p6VarA = a.get(Byte.valueOf(g2Var.k()));
        j6 j6Var = null;
        if (p6VarA == null && (g2Var instanceof n.a.a.n.c.u1.y0)) {
            short sT = ((n.a.a.n.c.u1.y0) g2Var).t();
            if (sT == 148) {
                j6Var = a7.b;
            } else if (sT != 255) {
                p6VarA = n.a.a.n.c.r1.r.a(sT);
            } else {
                j6Var = k1.a;
            }
        }
        if (p6VarA != null) {
            return (!(p6VarA instanceof x2) || (w0VarB = b((x2) p6VarA, w0VarArr, t0Var)) == null) ? p6VarA.k(w0VarArr, t0Var.t(), t0Var.k()) : w0VarB;
        }
        if (j6Var != null) {
            return j6Var.c(w0VarArr, t0Var);
        }
        throw new IllegalStateException("Unexpected operation ptg class (" + g2Var.getClass().getName() + ")");
    }

    static n.a.a.n.c.r1.w0 b(x2 x2Var, n.a.a.n.c.r1.w0[] w0VarArr, t0 t0Var) {
        l lVarA = t0Var.v().l(t0Var.u()).a(t0Var.t(), t0Var.k());
        if (lVarA == null) {
            return null;
        }
        if (lVarA.e()) {
            n.a.a.n.e.m mVarF = lVarA.f();
            return x2Var.h(w0VarArr, mVarF.b(), mVarF.a());
        }
        if (t0Var.w()) {
            return x2Var.h(w0VarArr, t0Var.t(), t0Var.k());
        }
        return null;
    }

    private static Map<Byte, p6> c() {
        HashMap map = new HashMap(32);
        map.put(Byte.valueOf(n.a.a.n.c.u1.z0.d.k()), n.a.a.n.c.r1.t0.a);
        map.put(Byte.valueOf(u2.d.k()), n.a.a.n.c.r1.t0.e);
        map.put(Byte.valueOf(a2.d.k()), n.a.a.n.c.r1.t0.c);
        map.put(Byte.valueOf(n.a.a.n.c.u1.l1.d.k()), n.a.a.n.c.r1.t0.b);
        map.put(Byte.valueOf(j2.d.k()), n.a.a.n.c.r1.t0.d);
        map.put(Byte.valueOf(n.a.a.n.c.u1.j1.d.k()), n.a.a.n.c.r1.n.a);
        map.put(Byte.valueOf(w1.d.k()), n.a.a.n.c.r1.l0.e);
        map.put(Byte.valueOf(v1.d.k()), n.a.a.n.c.r1.l0.d);
        map.put(Byte.valueOf(n.a.a.n.c.u1.m1.d.k()), n.a.a.n.c.r1.l0.a);
        map.put(Byte.valueOf(r1.d.k()), n.a.a.n.c.r1.l0.b);
        map.put(Byte.valueOf(s1.d.k()), n.a.a.n.c.r1.l0.c);
        map.put(Byte.valueOf(d2.d.k()), n.a.a.n.c.r1.l0.f);
        map.put(Byte.valueOf(u1.d.k()), n.a.a.n.c.r1.t.a);
        map.put(Byte.valueOf(n2.d.k()), n.a.a.n.c.r1.b0.a);
        map.put(Byte.valueOf(w2.d.k()), n.a.a.n.c.r1.v0.a);
        map.put(Byte.valueOf(v2.d.k()), n.a.a.n.c.r1.u0.a);
        map.put(Byte.valueOf(i2.d.k()), n.a.a.n.c.r1.a0.a);
        return map;
    }
}
