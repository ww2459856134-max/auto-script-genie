package i.b.ha.a.e.a;

import i.b.ha.a.e.b.k;
import i.b.ha.a.e.g.j;
import i.b.ha.a.e.g.p;

/* loaded from: classes.dex */
public class c extends b {
    static {
        double dK = j.k(2.0d);
        p pVar = new p(20);
        double dU = 0.0d;
        int i2 = 1;
        while (dU < 1.0d) {
            dU += j.u(dK, i2) / i.b.ha.a.e.g.b.a(i2);
            pVar.a(dU);
            i2++;
        }
        pVar.e();
    }

    public c(i.b.ha.a.e.d.c cVar, double d, double d2) throws k {
        super(cVar);
        if (d <= 0.0d) {
            throw new k(i.b.ha.a.e.b.p.d.MEAN, Double.valueOf(d));
        }
        j.k(d);
    }
}
