package n.a.a.n.c.t1;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class q5 implements j6 {
    public static final j6 a = new q5();

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        if (w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double D = y9.D(w0VarArr[0], t0Var.t(), t0Var.k());
            int iD = (int) y9.D(w0VarArr[1], t0Var.t(), t0Var.k());
            if (D >= 0.0d && D < 1.0d) {
                D = 1.0d;
            }
            Date dateL = n.a.a.n.d.y.l(D, false);
            Calendar calendarA = n.a.a.o.a1.a();
            calendarA.setTime(dateL);
            calendarA.clear(10);
            calendarA.set(11, 0);
            calendarA.clear(12);
            calendarA.clear(13);
            calendarA.clear(14);
            calendarA.add(2, iD + 1);
            calendarA.set(5, 1);
            calendarA.add(5, -1);
            return new n.a.a.n.c.r1.x(n.a.a.n.d.y.f(calendarA.getTime()));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
