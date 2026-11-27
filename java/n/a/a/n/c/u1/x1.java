package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class x1 extends f2 {
    private final int d;

    public x1(int i2) {
        this.d = i2;
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("lenRefSubexpression", new Supplier() { // from class: n.a.a.n.c.u1.u
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.r());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 7;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        return "";
    }

    @Override // n.a.a.n.c.u1.f2
    public /* bridge */ /* synthetic */ f2 p() {
        q();
        return this;
    }

    public x1 q() {
        return this;
    }

    public int r() {
        return this.d;
    }
}
