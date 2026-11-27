package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class a8 {
    public static final a8 e = new a8(true, 0);
    public static final a8 f = new a8(false, -1);
    public static final a8 g = new a8(false, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final a8 f2389h = new a8(false, 1);
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    private a8(boolean z, int i2) {
        if (z) {
            this.a = true;
            this.b = false;
            this.c = false;
            this.d = false;
            return;
        }
        this.a = false;
        this.b = i2 < 0;
        this.c = i2 == 0;
        this.d = i2 > 0;
    }

    private String a() {
        return this.a ? "TYPE_MISMATCH" : this.b ? "LESS_THAN" : this.c ? "EQUAL" : this.d ? "GREATER_THAN" : "??error??";
    }

    public static a8 f(int i2) {
        return i2 < 0 ? f : i2 > 0 ? f2389h : g;
    }

    public static a8 g(boolean z) {
        return z ? g : f;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public String toString() {
        return a8.class.getName() + " [" + a() + "]";
    }
}
