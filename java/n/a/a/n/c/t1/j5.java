package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class j5 extends cc implements j6 {
    public static final j6 a = new j5();

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 1 ? m(t0Var.t(), t0Var.k(), w0VarArr[0]) : w0VarArr.length == 2 ? i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        return i(i2, i3, w0Var, null);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        int iIntValue;
        try {
            Double dK = n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
            if (dK == null) {
                return n.a.a.n.c.r1.o.e;
            }
            if (dK.longValue() < -512 || dK.longValue() > 511) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            if (dK.doubleValue() < 0.0d || w0Var2 == null) {
                iIntValue = 10;
            } else {
                try {
                    Double dK2 = n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var2, i2, i3)));
                    if (dK2 == null) {
                        return n.a.a.n.c.r1.o.e;
                    }
                    iIntValue = dK2.intValue();
                    if (iIntValue < 0 || iIntValue == 0) {
                        return n.a.a.n.c.r1.o.f2385h;
                    }
                } catch (n.a.a.n.c.r1.p e) {
                    return e.a();
                }
            }
            String binaryString = Integer.toBinaryString(dK.intValue());
            if (binaryString.length() > 10) {
                binaryString = binaryString.substring(binaryString.length() - 10);
            }
            return binaryString.length() > iIntValue ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.m0(binaryString);
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }
}
