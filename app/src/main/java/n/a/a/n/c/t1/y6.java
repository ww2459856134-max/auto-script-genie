package n.a.a.n.c.t1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class y6 extends b6 implements j6 {
    public static final j6 a = new y6();
    public static final Pattern b = Pattern.compile("([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([ij]?)");

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : m(t0Var.t(), t0Var.k(), w0VarArr[0]);
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            Matcher matcher = b.matcher(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
            if (!matcher.matches()) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            String strGroup = matcher.group(5);
            boolean z = strGroup.equals("i") || strGroup.equals("j");
            if (strGroup.isEmpty()) {
                return new n.a.a.n.c.r1.m0(String.valueOf(0));
            }
            String str = "";
            if (z) {
                String strGroup2 = matcher.group(3);
                if (strGroup2.length() != 0 && !strGroup2.equals("+")) {
                    str = strGroup2;
                }
                String strGroup3 = matcher.group(4);
                if (strGroup3.length() != 0) {
                    str = str + strGroup3;
                } else {
                    str = str + "1";
                }
            }
            return new n.a.a.n.c.r1.m0(str);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
