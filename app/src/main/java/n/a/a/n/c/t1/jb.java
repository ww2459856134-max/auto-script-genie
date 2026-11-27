package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class jb extends b6 {
    jb() {
    }

    @Override // n.a.a.n.c.t1.l6
    public n.a.a.n.c.r1.w0 g(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        try {
            int iA = vb.a(w0Var, i2, i3);
            if (iA < 0 || iA >= 256) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            return new n.a.a.n.c.r1.m0(String.valueOf((char) iA));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
