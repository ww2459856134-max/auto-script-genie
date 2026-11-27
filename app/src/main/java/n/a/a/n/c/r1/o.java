package n.a.a.n.c.r1;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class o implements w0 {
    private static final Map<n.a.a.n.d.i0, o> b = new HashMap();
    public static final o c = new o(n.a.a.n.d.i0.NULL);
    public static final o d = new o(n.a.a.n.d.i0.DIV0);
    public static final o e = new o(n.a.a.n.d.i0.VALUE);
    public static final o f = new o(n.a.a.n.d.i0.REF);
    public static final o g = new o(n.a.a.n.d.i0.NAME);

    /* renamed from: h, reason: collision with root package name */
    public static final o f2385h = new o(n.a.a.n.d.i0.NUM);

    /* renamed from: i, reason: collision with root package name */
    public static final o f2386i = new o(n.a.a.n.d.i0.NA);

    /* renamed from: j, reason: collision with root package name */
    public static final o f2387j;
    private final n.a.a.n.d.i0 a;

    static {
        new o(n.a.a.n.d.i0.FUNCTION_NOT_IMPLEMENTED);
        f2387j = new o(n.a.a.n.d.i0.CIRCULAR_REF);
    }

    private o(n.a.a.n.d.i0 i0Var) {
        this.a = i0Var;
        b.put(i0Var, this);
    }

    public static String v(int i2) {
        if (n.a.a.n.d.i0.g(i2)) {
            return n.a.a.n.d.i0.b(i2).f();
        }
        return "~non~std~err(" + i2 + ")~";
    }

    public static o w(int i2) throws IllegalArgumentException {
        o oVar = b.get(n.a.a.n.d.i0.b(i2));
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("Unhandled error type for code " + i2);
    }

    public String toString() {
        return o.class.getName() + " [" + this.a.f() + "]";
    }

    public int u() {
        return this.a.e();
    }
}
