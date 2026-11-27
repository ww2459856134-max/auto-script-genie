package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class ja extends e6 {
    @Override // n.a.a.n.c.t1.o6
    public n.a.a.n.c.r1.w0 j(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, n.a.a.n.c.r1.w0 w0Var4) {
        try {
            String strB = vb.b(w0Var, i2, i3);
            int iA = vb.a(w0Var2, i2, i3);
            int iA2 = vb.a(w0Var3, i2, i3);
            String strB2 = vb.b(w0Var4, i2, i3);
            if (iA < 1 || iA2 < 0) {
                return n.a.a.n.c.r1.o.e;
            }
            StringBuilder sb = new StringBuilder(strB);
            if (iA <= strB.length() && iA2 != 0) {
                int i4 = iA - 1;
                sb.delete(i4, iA2 + i4);
            }
            if (iA > sb.length()) {
                sb.append(strB2);
            } else {
                sb.insert(iA - 1, strB2);
            }
            return new n.a.a.n.c.r1.m0(sb.toString());
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
