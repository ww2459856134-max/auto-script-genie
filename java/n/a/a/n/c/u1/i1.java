package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class i1 extends s2 {
    private static final i1 e = new i1(false);
    private static final i1 f = new i1(true);
    private final boolean d;

    private i1(boolean z) {
        this.d = z;
    }

    public static i1 q(boolean z) {
        return z ? f : e;
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("value", new Supplier() { // from class: n.a.a.n.c.u1.t0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.p());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 2;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        return this.d ? "TRUE" : "FALSE";
    }

    public boolean p() {
        return this.d;
    }
}
