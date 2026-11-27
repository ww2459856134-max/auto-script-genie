package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class ka extends c6 {
    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            String strG = n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            try {
                int iE = (int) n.a.a.n.c.r1.z.e(w0Var2);
                StringBuilder sb = new StringBuilder(strG.length() * iE);
                for (int i4 = 0; i4 < iE; i4++) {
                    sb.append(strG);
                }
                return sb.length() > 32767 ? n.a.a.n.c.r1.o.e : new n.a.a.n.c.r1.m0(sb.toString());
            } catch (n.a.a.n.c.r1.p unused) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
