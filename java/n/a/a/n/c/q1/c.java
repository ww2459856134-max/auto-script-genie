package n.a.a.n.c.q1;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.Unbox;
import n.a.a.n.d.i0;

/* loaded from: classes.dex */
public final class c {
    private static final Logger b = n.a.a.i.b.a(c.class);
    private static final c c = new c(i0.NULL.d());
    private static final c d = new c(i0.DIV0.d());
    private static final c e = new c(i0.VALUE.d());
    private static final c f = new c(i0.REF.d());
    private static final c g = new c(i0.NAME.d());

    /* renamed from: h, reason: collision with root package name */
    private static final c f2382h = new c(i0.NUM.d());

    /* renamed from: i, reason: collision with root package name */
    private static final c f2383i = new c(i0.NA.d());
    private final int a;

    private c(int i2) {
        this.a = i2;
    }

    public static c c(int i2) {
        if (i0.g(i2)) {
            switch (b.a[i0.b(i2).ordinal()]) {
                case 1:
                    return c;
                case 2:
                    return d;
                case 3:
                    return e;
                case 4:
                    return f;
                case 5:
                    return g;
                case 6:
                    return f2382h;
                case 7:
                    return f2383i;
            }
        }
        b.atWarn().log("Warning - unexpected error code ({})", Unbox.box(i2));
        return new c(i2);
    }

    public int a() {
        return this.a;
    }

    public String b() {
        if (i0.g(this.a)) {
            return i0.b(this.a).f();
        }
        return "unknown error code (" + this.a + ")";
    }

    public String toString() {
        return c.class.getName() + " [" + b() + "]";
    }
}
