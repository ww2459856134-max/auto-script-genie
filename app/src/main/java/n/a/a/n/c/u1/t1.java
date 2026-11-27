package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class t1 extends s2 {
    private final int d;

    public t1(int i2) {
        if (q(i2)) {
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("value is out of range: " + i2);
    }

    public static boolean q(int i2) {
        return i2 >= 0 && i2 <= 65535;
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("value", new Supplier() { // from class: n.a.a.n.c.u1.l0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.p());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 3;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        return String.valueOf(p());
    }

    public int p() {
        return this.d;
    }
}
