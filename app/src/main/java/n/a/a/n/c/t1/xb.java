package n.a.a.n.c.t1;

import com.auto.exceldeps.log4j.Logger;
import java.time.DateTimeException;

/* loaded from: classes.dex */
public class xb extends b6 {
    private static final Logger a = n.a.a.i.b.a(xb.class);

    private n.a.a.n.c.r1.x l(String str) throws n.a.a.n.c.r1.p {
        return new n.a.a.n.c.r1.x(n.a.a.n.d.y.y(str).doubleValue() - n.a.a.n.d.y.d(n.a.a.n.e.u.a(str)));
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            String strG = n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            if (strG == null || strG.isEmpty()) {
                return n.a.a.n.c.r1.l.a;
            }
            try {
                try {
                    return l(strG);
                } catch (Exception unused) {
                    n.a.a.n.e.u.a(strG);
                    return new n.a.a.n.c.r1.x(0.0d);
                }
            } catch (Exception unused2) {
                return l("1/01/2000 " + strG);
            }
        } catch (DateTimeException e) {
            a.atInfo().log("Failed to parse date/time", e);
            return n.a.a.n.c.r1.o.e;
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }
}
