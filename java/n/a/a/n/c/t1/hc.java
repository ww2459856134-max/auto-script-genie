package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class hc implements p6 {
    public static final p6 a = new hc();

    private hc() {
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        int iF;
        double d;
        try {
            if (w0VarArr.length >= 1 && w0VarArr.length <= 2) {
                double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[0], i2, i3));
                if (!n.a.a.n.d.y.v(dE)) {
                    return n.a.a.n.c.r1.o.f2385h;
                }
                int i4 = n.a.a.n.d.y.h(dE, false).get(7);
                if (w0VarArr.length == 2) {
                    n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0VarArr[1], i2, i3);
                    if (w0VarI != n.a.a.n.c.r1.u.a && w0VarI != n.a.a.n.c.r1.l.a) {
                        iF = n.a.a.n.c.r1.z.f(w0VarI);
                        if (iF == 2) {
                            iF = 11;
                        }
                    }
                    return n.a.a.n.c.r1.o.f2385h;
                }
                iF = 1;
                if (iF == 1) {
                    d = i4;
                } else if (iF == 3) {
                    i4 = ((i4 + 6) - 1) % 7;
                    d = i4;
                } else {
                    if (iF < 11 || iF > 17) {
                        return n.a.a.n.c.r1.o.f2385h;
                    }
                    d = (((i4 + 6) - (iF - 10)) % 7) + 1.0d;
                }
                return new n.a.a.n.c.r1.x(d);
            }
            return n.a.a.n.c.r1.o.e;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
