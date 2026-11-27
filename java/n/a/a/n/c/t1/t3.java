package n.a.a.n.c.t1;

import java.util.Locale;

/* loaded from: classes.dex */
public class t3 extends dc implements j6 {
    public static final j6 a = new t3();

    private boolean l(double d) {
        return d == Math.floor(d) && !Double.isInfinite(d);
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 2 ? i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]) : w0VarArr.length == 3 ? e(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1], w0VarArr[2]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            try {
                double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
                try {
                    try {
                        double dE2 = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var2, i2, i3));
                        String strG = n.a.a.n.c.r1.z.g(w0Var3);
                        if (strG.isEmpty()) {
                            strG = "i";
                        }
                        Locale locale = Locale.ROOT;
                        if (strG.equals("i".toUpperCase(locale)) || strG.equals("j".toUpperCase(locale))) {
                            return n.a.a.n.c.r1.o.e;
                        }
                        if (!strG.equals("i") && !strG.equals("j")) {
                            return n.a.a.n.c.r1.o.e;
                        }
                        StringBuilder sb = new StringBuilder();
                        if (dE != 0.0d) {
                            if (l(dE)) {
                                sb.append((int) dE);
                            } else {
                                sb.append(dE);
                            }
                        }
                        if (dE2 != 0.0d) {
                            if (sb.length() != 0 && dE2 > 0.0d) {
                                sb.append("+");
                            }
                            if (dE2 != 1.0d && dE2 != -1.0d) {
                                if (l(dE2)) {
                                    sb.append((int) dE2);
                                } else {
                                    sb.append(dE2);
                                }
                            }
                            sb.append(strG);
                        }
                        return new n.a.a.n.c.r1.m0(sb.toString());
                    } catch (n.a.a.n.c.r1.p unused) {
                        return n.a.a.n.c.r1.o.e;
                    }
                } catch (n.a.a.n.c.r1.p e) {
                    return e.a();
                }
            } catch (n.a.a.n.c.r1.p unused2) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        return e(i2, i3, w0Var, w0Var2, new n.a.a.n.c.r1.m0("i"));
    }
}
