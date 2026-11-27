package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class e2 extends s2 {
    private final double d;

    public e2(String str) {
        this(Double.parseDouble(str));
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("value", new Supplier() { // from class: n.a.a.n.c.u1.r
            @Override // java.util.function.Supplier
            public final Object get() {
                return Double.valueOf(this.a.p());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 9;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        return n.a.a.n.e.c0.h(this.d);
    }

    public double p() {
        return this.d;
    }

    public e2(double d) {
        this.d = d;
    }
}
