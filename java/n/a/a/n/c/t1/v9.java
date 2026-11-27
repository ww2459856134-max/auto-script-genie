package n.a.a.n.c.t1;

import java.text.DecimalFormatSymbols;

/* loaded from: classes.dex */
public final class v9 implements j6 {
    public static final j6 a = new v9();

    private v9() {
    }

    private static void a(double d) throws n.a.a.n.c.r1.p {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
        }
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        String strG;
        String strG2;
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(n.a.a.o.a1.e());
        String strValueOf = String.valueOf(decimalFormatSymbols.getDecimalSeparator());
        String strValueOf2 = String.valueOf(decimalFormatSymbols.getGroupingSeparator());
        try {
            if (w0VarArr.length == 1) {
                strG = n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k()));
            } else {
                if (w0VarArr.length == 2) {
                    n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k());
                    n.a.a.n.c.r1.w0 w0VarI2 = n.a.a.n.c.r1.z.i(w0VarArr[1], t0Var.t(), t0Var.k());
                    strG2 = n.a.a.n.c.r1.z.g(w0VarI);
                    strValueOf = n.a.a.n.c.r1.z.g(w0VarI2).substring(0, 1);
                } else if (w0VarArr.length == 3) {
                    n.a.a.n.c.r1.w0 w0VarI3 = n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k());
                    n.a.a.n.c.r1.w0 w0VarI4 = n.a.a.n.c.r1.z.i(w0VarArr[1], t0Var.t(), t0Var.k());
                    n.a.a.n.c.r1.w0 w0VarI5 = n.a.a.n.c.r1.z.i(w0VarArr[2], t0Var.t(), t0Var.k());
                    strG2 = n.a.a.n.c.r1.z.g(w0VarI3);
                    strValueOf = n.a.a.n.c.r1.z.g(w0VarI4).substring(0, 1);
                    strValueOf2 = n.a.a.n.c.r1.z.g(w0VarI5).substring(0, 1);
                } else {
                    strG = null;
                }
                strG = strG2;
            }
            if ("".equals(strG) || strG == null) {
                strG = "0";
            }
            String strReplace = strG.replace(" ", "");
            String[] strArrSplit = strReplace.split("[" + strValueOf + "]");
            if (strArrSplit.length > 2) {
                return n.a.a.n.c.r1.o.e;
            }
            if (strArrSplit.length > 1) {
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                if (str2.contains(strValueOf2)) {
                    return n.a.a.n.c.r1.o.e;
                }
                strReplace = str.replace(strValueOf2, "") + "." + str2;
            } else if (strArrSplit.length > 0) {
                strReplace = strArrSplit[0].replace(strValueOf2, "");
            }
            int i2 = 0;
            while (strReplace.endsWith("%")) {
                i2++;
                strReplace = strReplace.substring(0, strReplace.length() - 1);
            }
            try {
                double d = Double.parseDouble(strReplace) / Math.pow(100.0d, i2);
                a(d);
                return new n.a.a.n.c.r1.x(d);
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            } catch (Exception unused) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }
}
