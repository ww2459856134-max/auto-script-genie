package n.a.a.n.c.t1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class gc extends c6 implements j6 {

    /* renamed from: h, reason: collision with root package name */
    public static final j6 f2394h = new gc();

    /* renamed from: i, reason: collision with root package name */
    private static final n.a.a.n.c.r1.x f2395i = new n.a.a.n.c.r1.x(1.0d);

    /* renamed from: j, reason: collision with root package name */
    private static final HashSet<Integer> f2396j = new HashSet<>(Arrays.asList(1, 2, 11, 12, 13, 14, 15, 16, 17, 21));
    private WeekFields a = WeekFields.of(DayOfWeek.SUNDAY, 1);
    private WeekFields b = WeekFields.of(DayOfWeek.MONDAY, 1);
    private WeekFields c = WeekFields.of(DayOfWeek.TUESDAY, 1);
    private WeekFields d = WeekFields.of(DayOfWeek.WEDNESDAY, 1);
    private WeekFields e = WeekFields.of(DayOfWeek.THURSDAY, 1);
    private WeekFields f = WeekFields.of(DayOfWeek.FRIDAY, 1);
    private WeekFields g = WeekFields.of(DayOfWeek.SATURDAY, 1);

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 1 ? i(t0Var.t(), t0Var.k(), w0VarArr[0], f2395i) : w0VarArr.length == 2 ? i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            try {
                LocalDate localDate = n.a.a.n.d.y.l(y9.D(w0Var, i2, i3), false).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                try {
                    n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var2, i2, i3);
                    return !f2396j.contains(Integer.valueOf(w0VarI instanceof n.a.a.n.c.r1.u ? (int) f2395i.r() : n.a.a.n.c.r1.z.f(w0VarI))) ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(l(localDate, r3));
                } catch (n.a.a.n.c.r1.p unused) {
                    return n.a.a.n.c.r1.o.f2385h;
                }
            } catch (Exception unused2) {
                return n.a.a.n.c.r1.o.f2385h;
            }
        } catch (n.a.a.n.c.r1.p unused3) {
            return n.a.a.n.c.r1.o.e;
        }
    }

    public int l(LocalDate localDate, int i2) {
        return (i2 == 1 || i2 == 17) ? localDate.get(this.a.weekOfYear()) : (i2 == 2 || i2 == 11) ? localDate.get(this.b.weekOfYear()) : i2 == 12 ? localDate.get(this.c.weekOfYear()) : i2 == 13 ? localDate.get(this.d.weekOfYear()) : i2 == 14 ? localDate.get(this.e.weekOfYear()) : i2 == 15 ? localDate.get(this.f.weekOfYear()) : i2 == 16 ? localDate.get(this.g.weekOfYear()) : localDate.get(WeekFields.ISO.weekOfYear());
    }
}
