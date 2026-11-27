package n.a.a.n.c.t1;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class p5 implements j6 {
    public static final j6 a = new p5();

    private double a(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.x) {
            return ((n.a.a.n.c.r1.x) w0Var).r();
        }
        if (w0Var instanceof n.a.a.n.c.r1.l) {
            return 0.0d;
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            if (c0Var.t() > 1) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            n.a.a.n.c.r1.w0 w0VarO = c0Var.o(c0Var.g());
            if (w0VarO instanceof n.a.a.n.c.r1.x) {
                return ((n.a.a.n.c.r1.x) w0VarO).r();
            }
            if (w0VarO instanceof n.a.a.n.c.r1.l) {
                return 0.0d;
            }
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        if (w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dA = a(w0VarArr[0]);
            int iA = (int) a(w0VarArr[1]);
            Date dateK = n.a.a.n.d.y.k(dA);
            if (dateK == null) {
                return n.a.a.n.c.r1.o.e;
            }
            Calendar calendarA = n.a.a.o.a1.a();
            calendarA.setTime(dateK);
            calendarA.add(2, iA);
            return new n.a.a.n.c.r1.x(n.a.a.n.d.y.f(calendarA.getTime()));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
