package n.a.a.n.c;

/* loaded from: classes.dex */
final class a0 {
    private final z a;
    private final String b;

    public a0(String str, boolean z, boolean z2) {
        this.b = str;
        this.a = z.a(z, z2);
    }

    public n.a.a.n.e.s a() {
        if (this.a == z.CELL) {
            return new n.a.a.n.e.s(this.b);
        }
        throw new IllegalStateException("Not applicable to this reference-type, expected CELL, but had " + this.a);
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.a == z.CELL;
    }

    public boolean d() {
        return this.a == z.COLUMN;
    }

    public boolean e(a0 a0Var) {
        return this.a == a0Var.a;
    }

    public boolean f() {
        return this.a == z.ROW;
    }

    public boolean g() {
        return this.a != z.CELL;
    }

    public String toString() {
        return a0.class.getName() + " [" + this.b + "]";
    }
}
