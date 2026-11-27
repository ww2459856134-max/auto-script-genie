package n.a.a.n.c;

/* loaded from: classes.dex */
public final class i0 {
    private final int a;
    private final int b;

    public i0(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.a == i0Var.a && this.b == i0Var.b;
    }

    public int hashCode() {
        return (this.a * 17) + this.b;
    }
}
