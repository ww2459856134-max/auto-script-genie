package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class ib extends c6 {
    ib() {
    }

    private String l(n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.m) && (w0Var instanceof n.a.a.n.c.r1.n0)) {
            return ((n.a.a.n.c.r1.n0) w0Var).getStringValue();
        }
        if (w0Var == n.a.a.n.c.r1.l.a) {
            return "";
        }
        throw new IllegalArgumentException("Unexpected eval class (" + w0Var.getClass().getName() + ")");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[Catch: Exception -> 0x005e, TRY_ENTER, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0008, B:5:0x000d, B:21:0x0049, B:22:0x0058, B:7:0x0017, B:9:0x001b, B:10:0x0022, B:12:0x0026, B:13:0x0031, B:15:0x0035), top: B:30:0x0008, outer: #2 }] */
    @Override // n.a.a.n.c.t1.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        String stringValue;
        Double dK;
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            n.a.a.n.c.r1.w0 w0VarI2 = n.a.a.n.c.r1.z.i(w0Var2, i2, i3);
            try {
                Double d = null;
                stringValue = null;
                d = null;
                String stringValue2 = null;
                if (w0VarI != n.a.a.n.c.r1.l.a) {
                    if (w0VarI instanceof n.a.a.n.c.r1.m) {
                        stringValue = ((n.a.a.n.c.r1.m) w0VarI).getStringValue();
                    } else if (w0VarI instanceof n.a.a.n.c.r1.y) {
                        dK = Double.valueOf(((n.a.a.n.c.r1.y) w0VarI).r());
                    } else if (w0VarI instanceof n.a.a.n.c.r1.m0) {
                        stringValue2 = ((n.a.a.n.c.r1.m0) w0VarI).getStringValue();
                        dK = n.a.a.n.c.r1.z.k(stringValue2);
                        if (dK == null) {
                            try {
                                dK = n.a.a.n.d.y.y(stringValue2);
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        stringValue = null;
                    }
                    if (d != null) {
                        stringValue = vb.a.o(d.doubleValue(), -1, l(w0VarI2));
                    }
                    return new n.a.a.n.c.r1.m0(stringValue);
                }
                dK = Double.valueOf(0.0d);
                String str = stringValue2;
                d = dK;
                stringValue = str;
                if (d != null) {
                }
                return new n.a.a.n.c.r1.m0(stringValue);
            } catch (Exception unused2) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
