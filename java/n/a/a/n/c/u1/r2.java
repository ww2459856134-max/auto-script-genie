package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public abstract class r2 extends f2 {
    private static final n.a.a.o.k0 f = n.a.a.o.l0.a(16383);
    private static final n.a.a.o.k0 g = n.a.a.o.l0.a(32768);

    /* renamed from: h, reason: collision with root package name */
    private static final n.a.a.o.k0 f2449h = n.a.a.o.l0.a(16384);
    private int d;
    private int e;

    protected r2() {
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.g("row", new Supplier() { // from class: n.a.a.n.c.u1.h0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.s());
            }
        }, "rowRelative", new Supplier() { // from class: n.a.a.n.c.u1.w0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.u());
            }
        }, "column", new Supplier() { // from class: n.a.a.n.c.u1.s0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.r());
            }
        }, "colRelative", new Supplier() { // from class: n.a.a.n.c.u1.z
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.t());
            }
        }, "formatReference", new Supplier() { // from class: n.a.a.n.c.u1.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.q();
            }
        });
    }

    protected String q() {
        return new n.a.a.n.e.s(s(), r(), !u(), !t()).g();
    }

    public final int r() {
        return f.d(this.e);
    }

    public final int s() {
        return this.d;
    }

    public final boolean t() {
        return f2449h.e(this.e);
    }

    public final boolean u() {
        return g.e(this.e);
    }

    public final void v(boolean z) {
        this.e = f2449h.g(this.e, z);
    }

    public final void w(int i2) {
        this.e = f.h(this.e, i2);
    }

    public final void x(int i2) {
        this.d = i2;
    }

    public final void y(boolean z) {
        this.e = g.g(this.e, z);
    }

    protected r2(r2 r2Var) {
        super(r2Var);
        this.d = r2Var.d;
        this.e = r2Var.e;
    }

    protected r2(n.a.a.n.e.s sVar) {
        x(sVar.m());
        w(sVar.l());
        v(!sVar.o());
        y(!sVar.r());
    }
}
