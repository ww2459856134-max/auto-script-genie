package n.a.a.n.c.t1;

import java.math.BigInteger;
import java.util.HashMap;

/* loaded from: classes.dex */
public class t5 extends b6 implements j6 {
    public static final j6 a = new t5();
    static HashMap<Integer, BigInteger> b = new HashMap<>();

    public static BigInteger l(int i2) {
        if (i2 == 0 || i2 < 0) {
            return BigInteger.ONE;
        }
        if (b.containsKey(Integer.valueOf(i2))) {
            return b.get(Integer.valueOf(i2));
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(i2).multiply(l(i2 - 2));
        b.put(Integer.valueOf(i2), bigIntegerMultiply);
        return bigIntegerMultiply;
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : m(t0Var.t(), t0Var.k(), w0VarArr[0]);
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            return n.a.a.n.c.r1.z.f(w0Var) < 0 ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(l(r3).longValue());
        } catch (n.a.a.n.c.r1.p unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
