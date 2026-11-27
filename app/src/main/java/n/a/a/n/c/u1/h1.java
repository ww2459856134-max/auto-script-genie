package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class h1 extends k1 {
    private final byte d;
    private final short e;
    private final int[] f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private static final n.a.a.o.k0 f2435h = n.a.a.o.l0.a(1);

    /* renamed from: i, reason: collision with root package name */
    private static final n.a.a.o.k0 f2436i = n.a.a.o.l0.a(2);

    /* renamed from: j, reason: collision with root package name */
    private static final n.a.a.o.k0 f2437j = n.a.a.o.l0.a(4);

    /* renamed from: k, reason: collision with root package name */
    private static final n.a.a.o.k0 f2438k = n.a.a.o.l0.a(8);
    private static final n.a.a.o.k0 t = n.a.a.o.l0.a(16);
    private static final n.a.a.o.k0 A = n.a.a.o.l0.a(32);
    private static final n.a.a.o.k0 C = n.a.a.o.l0.a(64);

    static {
        new h1(16, 0, null, -1);
    }

    private h1(int i2, int i3, int[] iArr, int i4) {
        this.d = (byte) i2;
        this.e = (short) i3;
        this.f = iArr;
        this.g = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Number D() {
        return Byte.valueOf(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object F() {
        return Integer.valueOf((this.e >> 8) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Number H() {
        return Integer.valueOf(this.e & 255);
    }

    public static h1 p(int i2) {
        return new h1(f2436i.f(0), i2, null, -1);
    }

    public static h1 q(int i2) {
        return new h1(f2438k.f(0), i2, null, -1);
    }

    public static h1 v() {
        return new h1(t.f(0), 0, null, -1);
    }

    public boolean A() {
        return C.e(this.d);
    }

    public boolean B() {
        return t.e(this.d);
    }

    public String I(String[] strArr) {
        if (C.e(this.d)) {
            return strArr[0];
        }
        if (f2436i.e(this.d)) {
            return o() + "(" + strArr[0] + ")";
        }
        if (f2438k.e(this.d)) {
            return o() + strArr[0];
        }
        return o() + "(" + strArr[0] + ")";
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.f("volatile", new Supplier() { // from class: n.a.a.n.c.u1.p0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.y());
            }
        }, "options", n.a.a.o.v0.a(new Supplier() { // from class: n.a.a.n.c.u1.o
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.D();
            }
        }, new n.a.a.o.k0[]{f2435h, f2436i, f2437j, f2438k, t, A, C}, new String[]{"SEMI_VOLATILE", "OPTI_IF", "OPTI_CHOOSE", "OPTI_SKIP", "OPTI_SUM", "BAXCEL", "SPACE"}), "space_count", new Supplier() { // from class: n.a.a.n.c.u1.n
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.F();
            }
        }, "space_type", n.a.a.o.v0.b(new Supplier() { // from class: n.a.a.n.c.u1.p
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.H();
            }
        }, new int[]{0, 1, 2, 3, 4, 5, 6}, new String[]{"SPACE_BEFORE", "CR_BEFORE", "SPACE_BEFORE_OPEN_PAREN", "CR_BEFORE_OPEN_PAREN", "SPACE_BEFORE_CLOSE_PAREN", "CR_BEFORE_CLOSE_PAREN", "SPACE_AFTER_EQUALITY"}));
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        int[] iArr = this.f;
        if (iArr != null) {
            return ((iArr.length + 1) * 2) + 4;
        }
        return 4;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        return f2435h.e(this.d) ? "ATTR(semiVolatile)" : f2436i.e(this.d) ? "IF" : f2437j.e(this.d) ? "CHOOSE" : f2438k.e(this.d) ? "" : t.e(this.d) ? "SUM" : A.e(this.d) ? "ATTR(baxcel)" : C.e(this.d) ? "" : "UNKNOWN ATTRIBUTE";
    }

    public int r() {
        if (this.f != null) {
            return this.g;
        }
        throw new IllegalStateException("Not tAttrChoose");
    }

    public short s() {
        return this.e;
    }

    public int[] t() {
        return (int[]) this.f.clone();
    }

    public int u() {
        return 1;
    }

    public boolean w() {
        return f2437j.e(this.d);
    }

    public boolean x() {
        return f2436i.e(this.d);
    }

    public boolean y() {
        return f2435h.e(this.d);
    }

    public boolean z() {
        return f2438k.e(this.d);
    }
}
