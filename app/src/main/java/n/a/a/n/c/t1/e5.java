package n.a.a.n.c.t1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e5 implements u6 {
    private final ArrayList<n.a.a.n.c.r1.y> a = new ArrayList<>();

    @Override // n.a.a.n.c.t1.u6
    public n.a.a.n.c.r1.w0 a() {
        double[] dArr = new double[this.a.size()];
        Iterator<n.a.a.n.c.r1.y> it = this.a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            dArr[i2] = it.next().r();
            i2++;
        }
        return new n.a.a.n.c.r1.x(new BigDecimal(n.a.a.n.e.c0.h(ta.i(dArr))).doubleValue());
    }

    @Override // n.a.a.n.c.t1.u6
    public boolean b(n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
            return true;
        }
        this.a.add((n.a.a.n.c.r1.y) w0Var);
        return true;
    }
}
