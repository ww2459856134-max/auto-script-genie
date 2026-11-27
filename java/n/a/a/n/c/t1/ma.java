package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class ma {
    public static n.a.a.n.c.r1.w0 a(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length > 1) {
            return n.a.a.n.c.r1.o.e;
        }
        if (w0VarArr.length != 0) {
            if (w0VarArr[0] instanceof n.a.a.n.c.r1.j) {
                i2 = ((n.a.a.n.c.r1.j) w0VarArr[0]).getFirstRow();
            } else {
                if (!(w0VarArr[0] instanceof n.a.a.n.c.r1.c0)) {
                    return n.a.a.n.c.r1.o.e;
                }
                i2 = ((n.a.a.n.c.r1.c0) w0VarArr[0]).getRow();
            }
        }
        return new n.a.a.n.c.r1.x(i2 + 1.0d);
    }
}
