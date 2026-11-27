package n.a.a.n.c.t1;

import com.auto.exceldeps.log4j.Logger;
import java.time.DateTimeException;

/* loaded from: classes.dex */
public class g5 extends b6 {
    private static final Logger a = n.a.a.i.b.a(g5.class);

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            String strG = n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            if (strG != null && !strG.isEmpty()) {
                return new n.a.a.n.c.r1.x(n.a.a.n.d.y.d(n.a.a.n.e.u.a(strG)));
            }
            return n.a.a.n.c.r1.o.e;
        } catch (DateTimeException e) {
            a.atInfo().log("Failed to parse date", e);
            return n.a.a.n.c.r1.o.e;
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }
}
