package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class qb extends d6 {
    qb() {
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            String strB = vb.b(w0Var, i2, i3);
            int iA = vb.a(w0Var2, i2, i3);
            int iA2 = vb.a(w0Var3, i2, i3);
            int i4 = iA - 1;
            if (i4 < 0) {
                return n.a.a.n.c.r1.o.e;
            }
            if (iA2 < 0) {
                return n.a.a.n.c.r1.o.e;
            }
            int length = strB.length();
            return i4 > length ? new n.a.a.n.c.r1.m0("") : new n.a.a.n.c.r1.m0(strB.substring(i4, Math.min(iA2 + i4, length)));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
