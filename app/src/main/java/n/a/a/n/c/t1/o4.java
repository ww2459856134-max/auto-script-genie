package n.a.a.n.c.t1;

import java.util.List;

/* loaded from: classes.dex */
public class o4 extends c6 implements j6 {
    public static final o4 b = new o4(false);
    public static final o4 c = new o4(true);
    private final boolean a;

    private o4(boolean z) {
        this.a = z;
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 2 ? n.a.a.n.c.r1.o.e : i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            List<o5> listC = y2.c(w0Var, w0Var2);
            return new n.a.a.n.c.r1.x(new i.b.ha.a.e.f.a.a().a(listC.get(0).c(), listC.get(1).c(), this.a));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        } catch (Exception unused) {
            return n.a.a.n.c.r1.o.f2386i;
        }
    }
}
