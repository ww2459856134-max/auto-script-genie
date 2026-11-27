package n.a.a.n.c.t1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/* loaded from: classes.dex */
public class i5 implements j6 {
    public static final i5 a = new i5();

    private i5() {
    }

    private static double a(LocalDate localDate, LocalDate localDate2) {
        return ChronoUnit.DAYS.between(localDate2, localDate);
    }

    private n.a.a.n.c.r1.w0 b(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            return new n.a.a.n.c.r1.x(a(e(w0Var, i2, i3), e(w0Var2, i2, i3)));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private static LocalDate d(double d) {
        return n.a.a.n.d.y.l(d, false).toInstant().atZone(n.a.a.o.a1.f().toZoneId()).toLocalDate();
    }

    static LocalDate e(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
        try {
            return d(y9.D(w0VarI, i2, i3));
        } catch (Exception unused) {
            return n.a.a.n.e.u.a(n.a.a.n.c.r1.z.g(w0VarI));
        }
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 2 ? n.a.a.n.c.r1.o.e : b(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]);
    }
}
