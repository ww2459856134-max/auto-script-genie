package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class b2 extends f2 implements n.a.a.n.c.l1 {
    private int d;
    private short e;

    public b2(int i2) {
        this.d = i2 + 1;
    }

    @Override // n.a.a.n.c.l1
    public String b(n.a.a.n.c.e0 e0Var) {
        return e0Var.d(this);
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("index", new Supplier() { // from class: n.a.a.n.c.u1.m0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.r());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 5;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        throw new IllegalStateException("3D references need a workbook to determine formula text");
    }

    @Override // n.a.a.n.c.u1.f2
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b2 p() {
        return new b2(this);
    }

    public int r() {
        return this.d - 1;
    }

    public b2(b2 b2Var) {
        super(b2Var);
        this.d = b2Var.d;
        this.e = b2Var.e;
    }
}
