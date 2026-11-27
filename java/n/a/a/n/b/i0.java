package n.a.a.n.b;

/* loaded from: classes.dex */
public class i0 implements Comparable<i0> {
    private final f0 c;
    private final int d;
    private CharSequence e;
    private f0 f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2346h;

    public i0(f0 f0Var, CharSequence charSequence, int i2) {
        this.c = f0Var;
        this.e = charSequence;
        this.d = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i0 i0Var) {
        int i2 = this.c.b - i0Var.c.b;
        return i2 != 0 ? i2 : this.d - i0Var.d;
    }

    public f0 b() {
        return this.f;
    }

    public int c() {
        return this.d;
    }

    public f0 d() {
        return this.c;
    }

    public CharSequence e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i0) && compareTo((i0) obj) == 0;
    }

    public boolean f() {
        return this.f2346h;
    }

    public boolean g() {
        return this.g;
    }

    public int hashCode() {
        return this.c.hashCode() + this.d;
    }

    public i0(f0 f0Var, boolean z, f0 f0Var2, boolean z2, char c) {
        this(f0Var, z, f0Var2, z2);
        this.e = c + "";
    }

    public i0(f0 f0Var, boolean z, f0 f0Var2, boolean z2) {
        this.c = f0Var;
        this.g = z;
        this.f = f0Var2;
        this.f2346h = z2;
        this.d = 3;
        this.e = "";
    }
}
