package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class o1 extends s2 {
    public static final o1 e = new o1(n.a.a.n.d.i0.NULL.d());
    public static final o1 f = new o1(n.a.a.n.d.i0.DIV0.d());
    public static final o1 g = new o1(n.a.a.n.d.i0.VALUE.d());

    /* renamed from: h, reason: collision with root package name */
    public static final o1 f2439h = new o1(n.a.a.n.d.i0.REF.d());

    /* renamed from: i, reason: collision with root package name */
    public static final o1 f2440i = new o1(n.a.a.n.d.i0.NAME.d());

    /* renamed from: j, reason: collision with root package name */
    public static final o1 f2441j = new o1(n.a.a.n.d.i0.NUM.d());

    /* renamed from: k, reason: collision with root package name */
    public static final o1 f2442k = new o1(n.a.a.n.d.i0.NA.d());
    private final int d;

    private o1(int i2) {
        if (n.a.a.n.d.i0.g(i2)) {
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid error code (" + i2 + ")");
    }

    public static o1 q(int i2) {
        switch (n1.a[n.a.a.n.d.i0.b(i2).ordinal()]) {
            case 1:
                return f;
            case 2:
                return f2442k;
            case 3:
                return f2440i;
            case 4:
                return e;
            case 5:
                return f2441j;
            case 6:
                return f2439h;
            case 7:
                return g;
            default:
                throw new IllegalStateException("Unexpected error code (" + i2 + ")");
        }
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("errorCode", new Supplier() { // from class: n.a.a.n.c.u1.y
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.p());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 2;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        return n.a.a.n.d.i0.b(this.d).f();
    }

    public int p() {
        return this.d;
    }
}
