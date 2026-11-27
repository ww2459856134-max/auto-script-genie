package n.a.a.n.c.t1;

import java.time.DateTimeException;
import java.util.function.Function;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class bc extends b6 implements x2 {
    private static final Double a = Double.valueOf(0.0d);

    /* JADX WARN: Removed duplicated region for block: B:72:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Double l(String str) throws NumberFormatException {
        int length = str.length();
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (Character.isDigit(cCharAt) || cCharAt == '.') {
                break;
            }
            if (cCharAt != ' ') {
                if (cCharAt != '$') {
                    if (cCharAt != '+') {
                        if (cCharAt != '-' || z3 || z4) {
                            return null;
                        }
                        z3 = true;
                    } else {
                        if (z3 || z4) {
                            return null;
                        }
                        z4 = true;
                    }
                } else {
                    if (z2) {
                        return null;
                    }
                    z2 = true;
                }
            }
            i2++;
        }
        if (i2 >= length) {
            if (z2 || z3 || z4) {
                return null;
            }
            return a;
        }
        StringBuilder sb = new StringBuilder(length);
        int i3 = -32768;
        int i4 = i2;
        boolean z5 = false;
        while (i4 < length) {
            char cCharAt2 = str.charAt(i4);
            if (Character.isDigit(cCharAt2)) {
                sb.append(cCharAt2);
            } else if (cCharAt2 == ' ') {
                String strTrim = str.substring(i4).trim();
                if (!strTrim.equals("%")) {
                    if (!strTrim.isEmpty()) {
                        return null;
                    }
                }
            } else if (cCharAt2 == '%') {
                z5 = true;
            } else if (cCharAt2 != ',') {
                if (cCharAt2 != '.') {
                    if ((cCharAt2 != 'E' && cCharAt2 != 'e') || i4 - i3 < 4) {
                        return null;
                    }
                    sb.append(str.substring(i4));
                    i4 = length;
                } else {
                    if (z || i4 - i3 < 4) {
                        return null;
                    }
                    sb.append(NameUtil.PERIOD);
                    z = true;
                }
            } else {
                if (z || i4 - i3 < 4) {
                    return null;
                }
                i3 = i4;
            }
            i4++;
        }
        if (!z && i4 - i3 < 4) {
            return null;
        }
        try {
            double d = Double.parseDouble(sb.toString());
            if (z3) {
                d = -d;
            }
            if (z5) {
                d /= 100.0d;
            }
            return Double.valueOf(d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Double o(String str) {
        try {
            return n.a.a.n.d.y.y(str);
        } catch (DateTimeException unused) {
            return null;
        }
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public n.a.a.n.c.r1.w0 n(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) throws NumberFormatException {
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            String strG = n.a.a.n.c.r1.z.g(w0VarI);
            if (w0VarI == n.a.a.n.c.r1.l.a) {
                return new n.a.a.n.c.r1.x(0.0d);
            }
            if (n.a.a.o.j1.f(strG)) {
                return n.a.a.n.c.r1.o.e;
            }
            Double dL = l(strG);
            if (dL == null) {
                dL = o(strG);
            }
            return dL == null ? n.a.a.n.c.r1.o.e : new n.a.a.n.c.r1.x(dL.doubleValue());
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.x2
    public n.a.a.n.c.r1.w0 h(n.a.a.n.c.r1.w0[] w0VarArr, final int i2, final int i3) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : a(w0VarArr[0], i2, i3, new Function() { // from class: n.a.a.n.c.t1.t0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.n(i2, i3, (n.a.a.n.c.r1.w0) obj);
            }
        });
    }
}
