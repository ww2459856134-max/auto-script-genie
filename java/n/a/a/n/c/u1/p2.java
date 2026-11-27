package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class p2 extends r2 implements l2 {

    /* renamed from: i, reason: collision with root package name */
    private int f2443i;

    /* renamed from: j, reason: collision with root package name */
    private String f2444j;

    /* renamed from: k, reason: collision with root package name */
    private String f2445k;

    public p2(p2 p2Var) {
        super(p2Var);
        this.f2443i = -1;
        this.f2443i = p2Var.f2443i;
        this.f2444j = p2Var.f2444j;
        this.f2445k = p2Var.f2445k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object B() {
        return super.e();
    }

    @Override // n.a.a.n.c.u1.l2
    public void a(String str) {
        this.f2445k = str;
    }

    @Override // n.a.a.n.c.u1.m2
    public String c() {
        return this.f2444j;
    }

    @Override // n.a.a.n.c.u1.m2
    public void d(String str) {
        this.f2444j = str;
    }

    @Override // n.a.a.n.c.u1.r2, n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.f("base", new Supplier() { // from class: n.a.a.n.c.u1.e0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.B();
            }
        }, "externalWorkbookNumber", new Supplier() { // from class: n.a.a.n.c.u1.f
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.f());
            }
        }, "firstSheetName", new Supplier() { // from class: n.a.a.n.c.u1.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.c();
            }
        }, "lastSheetName", new Supplier() { // from class: n.a.a.n.c.u1.q0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.g();
            }
        });
    }

    @Override // n.a.a.n.c.u1.m2
    public int f() {
        return this.f2443i;
    }

    @Override // n.a.a.n.c.u1.l2
    public String g() {
        return this.f2445k;
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 1;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        StringBuilder sb = new StringBuilder(64);
        n.a.a.n.c.e1.b(sb, this.f2443i, this.f2444j, this.f2445k);
        sb.append('!');
        sb.append(q());
        return sb.toString();
    }

    @Override // n.a.a.n.c.u1.f2
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public p2 p() {
        return new p2(this);
    }

    public p2(int i2, n.a.a.n.c.b1 b1Var, n.a.a.n.e.s sVar) {
        super(sVar);
        this.f2443i = -1;
        this.f2443i = i2;
        this.f2444j = b1Var.d().a();
        if (b1Var instanceof n.a.a.n.c.g1) {
            this.f2445k = ((n.a.a.n.c.g1) b1Var).e().a();
        } else {
            this.f2445k = null;
        }
    }

    public p2(n.a.a.n.c.b1 b1Var, n.a.a.n.e.s sVar) {
        this(-1, b1Var, sVar);
    }
}
