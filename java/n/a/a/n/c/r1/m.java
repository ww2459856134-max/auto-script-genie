package n.a.a.n.c.r1;

/* loaded from: classes.dex */
public final class m implements y, n0 {
    public static final m b = new m(false);
    public static final m c = new m(true);
    private final boolean a;

    private m(boolean z) {
        this.a = z;
    }

    public static m v(boolean z) {
        return z ? c : b;
    }

    @Override // n.a.a.n.c.r1.n0
    public String getStringValue() {
        return this.a ? "TRUE" : "FALSE";
    }

    @Override // n.a.a.n.c.r1.y
    public double r() {
        return this.a ? 1.0d : 0.0d;
    }

    public String toString() {
        return m.class.getName() + " [" + getStringValue() + "]";
    }

    public boolean u() {
        return this.a;
    }
}
