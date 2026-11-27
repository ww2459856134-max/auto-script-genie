package n.a.a.n.c.t1;

import java.util.function.Function;

/* loaded from: classes.dex */
public abstract class l3 implements p6, x2 {
    public static final p6 a = new j3();
    public static final p6 b = new k3();
    public static final p6 c = new p6() { // from class: n.a.a.n.c.t1.i
        @Override // n.a.a.n.c.t1.p6
        public final n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
            return l3.l(w0VarArr, i2, i3);
        }
    };
    public static final p6 d = new p6() { // from class: n.a.a.n.c.t1.f
        @Override // n.a.a.n.c.t1.p6
        public final n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
            return l3.n(w0VarArr, i2, i3);
        }
    };
    public static final p6 e = new p6() { // from class: n.a.a.n.c.t1.g
        @Override // n.a.a.n.c.t1.p6
        public final n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
            return l3.m(w0VarArr, i2, i3);
        }
    };

    private boolean c(n.a.a.n.c.r1.w0[] w0VarArr) throws n.a.a.n.c.r1.p {
        boolean zO = o();
        int length = w0VarArr.length;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            n.a.a.n.c.r1.w0 w0Var = w0VarArr[i2];
            if (w0Var instanceof n.a.a.n.c.j1) {
                n.a.a.n.c.j1 j1Var = (n.a.a.n.c.j1) w0Var;
                int iA = j1Var.a();
                int width = j1Var.getWidth();
                for (int i3 = 0; i3 < iA; i3++) {
                    for (int i4 = 0; i4 < width; i4++) {
                        Boolean boolD = n.a.a.n.c.r1.z.d(j1Var.p(i3, i4), true);
                        if (boolD != null) {
                            zO = t(zO, boolD.booleanValue());
                            z = true;
                        }
                    }
                }
            } else if (w0Var instanceof n.a.a.n.c.r1.c0) {
                n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
                int iD = c0Var.d();
                for (int iG = c0Var.g(); iG <= iD; iG++) {
                    Boolean boolD2 = n.a.a.n.c.r1.z.d(c0Var.o(iG), true);
                    if (boolD2 != null) {
                        zO = t(zO, boolD2.booleanValue());
                        z = true;
                    }
                }
            } else {
                Boolean boolD3 = (w0Var == n.a.a.n.c.r1.u.a || w0Var == n.a.a.n.c.r1.l.a) ? Boolean.FALSE : n.a.a.n.c.r1.z.d(w0Var, false);
                if (boolD3 != null) {
                    zO = t(zO, boolD3.booleanValue());
                    z = true;
                }
            }
        }
        if (z) {
            return zO;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n.a.a.n.c.r1.w0 l(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        return w0VarArr.length != 0 ? n.a.a.n.c.r1.o.e : n.a.a.n.c.r1.m.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n.a.a.n.c.r1.w0 m(n.a.a.n.c.r1.w0[] w0VarArr, final int i2, final int i3) {
        if (w0VarArr.length != 1) {
            return n.a.a.n.c.r1.o.e;
        }
        return x2.f(w0VarArr[0], i2, i3, new Function() { // from class: n.a.a.n.c.t1.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return l3.s(i2, i3, (n.a.a.n.c.r1.w0) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n.a.a.n.c.r1.w0 n(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        return w0VarArr.length != 0 ? n.a.a.n.c.r1.o.e : n.a.a.n.c.r1.m.c;
    }

    static /* synthetic */ n.a.a.n.c.r1.w0 s(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            Boolean boolD = n.a.a.n.c.r1.z.d(n.a.a.n.c.r1.z.i(w0Var, i2, i3), false);
            return n.a.a.n.c.r1.m.v(boolD != null && boolD.booleanValue() ? false : true);
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    @Override // n.a.a.n.c.t1.x2
    public n.a.a.n.c.r1.w0 h(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        return k(w0VarArr, i2, i3);
    }

    @Override // n.a.a.n.c.t1.p6
    public final n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 1) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            return n.a.a.n.c.r1.m.v(c(w0VarArr));
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    protected abstract boolean o();

    protected abstract boolean t(boolean z, boolean z2);
}
