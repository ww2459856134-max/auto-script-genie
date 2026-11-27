package n.a.a.n.c.t1;

import java.util.regex.Matcher;

/* loaded from: classes.dex */
public class x6 extends b6 implements j6 {
    public static final j6 a = new x6();

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : m(t0Var.t(), t0Var.k(), w0VarArr[0]);
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            Matcher matcher = y6.b.matcher(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
            if (!matcher.matches()) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            if (matcher.group(2).isEmpty()) {
                return new n.a.a.n.c.r1.m0("0");
            }
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if ("+".equals(strGroup)) {
                strGroup = "";
            }
            if (strGroup2.isEmpty()) {
                strGroup2 = "1";
            }
            return new n.a.a.n.c.r1.m0(strGroup + strGroup2);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
