package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class q1 extends y0 {

    /* renamed from: i, reason: collision with root package name */
    private static final n.a.a.o.k0 f2446i = n.a.a.o.l0.a(61440);

    /* renamed from: j, reason: collision with root package name */
    public static final g2 f2447j = C("SUM", 1);

    /* renamed from: h, reason: collision with root package name */
    private final boolean f2448h;

    private q1(int i2, int i3, byte[] bArr, int i4, boolean z) {
        super(i2, i3, bArr, i4);
        this.f2448h = z;
    }

    private static q1 B(int i2, int i3) {
        n.a.a.n.c.s1.b bVarB;
        n.a.a.o.k0 k0Var = f2446i;
        boolean zE = k0Var.e(i3);
        if (zE) {
            i3 = k0Var.a(i3);
            bVarB = n.a.a.n.c.s1.d.a(i3);
        } else {
            bVarB = n.a.a.n.c.s1.d.b(i3);
        }
        int i4 = i3;
        return bVarB == null ? new q1(i4, 32, new byte[]{32}, i2, zE) : new q1(i4, bVarB.f(), bVarB.e(), i2, zE);
    }

    public static q1 C(String str, int i2) {
        return B(i2, y0.y(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object E() {
        return super.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object G() {
        return Boolean.valueOf(this.f2448h);
    }

    @Override // n.a.a.n.c.u1.y0, n.a.a.n.c.u1.g2, n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.d("base", new Supplier() { // from class: n.a.a.n.c.u1.v
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.E();
            }
        }, "cetab", new Supplier() { // from class: n.a.a.n.c.u1.w
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.G();
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public byte k() {
        return (byte) 34;
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 4;
    }

    @Override // n.a.a.n.c.u1.y0
    protected String z(short s) {
        return A(s, this.f2448h);
    }
}
