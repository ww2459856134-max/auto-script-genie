package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class b1 extends f1 implements l2 {
    private String A;

    /* renamed from: k, reason: collision with root package name */
    private int f2429k;
    private String t;

    public b1(b1 b1Var) {
        super(b1Var);
        this.f2429k = -1;
        this.f2429k = b1Var.f2429k;
        this.t = b1Var.t;
        this.A = b1Var.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object F() {
        return super.e();
    }

    @Override // n.a.a.n.c.u1.f2
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public b1 p() {
        return new b1(this);
    }

    @Override // n.a.a.n.c.u1.l2
    public void a(String str) {
        this.A = str;
    }

    @Override // n.a.a.n.c.u1.m2
    public String c() {
        return this.t;
    }

    @Override // n.a.a.n.c.u1.m2
    public void d(String str) {
        this.t = str;
    }

    @Override // n.a.a.n.c.u1.f1, n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.f("base", new Supplier() { // from class: n.a.a.n.c.u1.i
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.F();
            }
        }, "externalWorkbookNumber", new Supplier() { // from class: n.a.a.n.c.u1.r0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.f());
            }
        }, "sheetName", new Supplier() { // from class: n.a.a.n.c.u1.i0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.c();
            }
        }, "lastSheetName", new Supplier() { // from class: n.a.a.n.c.u1.o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.g();
            }
        });
    }

    @Override // n.a.a.n.c.u1.m2
    public int f() {
        return this.f2429k;
    }

    @Override // n.a.a.n.c.u1.l2
    public String g() {
        return this.A;
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 1;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        StringBuilder sb = new StringBuilder(64);
        n.a.a.n.c.e1.b(sb, this.f2429k, this.t, this.A);
        sb.append('!');
        sb.append(q());
        return sb.toString();
    }

    public b1(int i2, n.a.a.n.c.b1 b1Var, n.a.a.n.e.k kVar) {
        super(kVar);
        this.f2429k = -1;
        this.f2429k = i2;
        this.t = b1Var.d().a();
        if (b1Var instanceof n.a.a.n.c.g1) {
            this.A = ((n.a.a.n.c.g1) b1Var).e().a();
        } else {
            this.A = null;
        }
    }

    public b1(n.a.a.n.c.b1 b1Var, n.a.a.n.e.k kVar) {
        this(-1, b1Var, kVar);
    }
}
