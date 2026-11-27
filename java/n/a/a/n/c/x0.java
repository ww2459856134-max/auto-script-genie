package n.a.a.n.c;

/* loaded from: classes.dex */
public final class x0 {
    private final long a;
    private final int b;

    public x0(int i2, int i3, int i4, int i5) {
        this.a = a(i2, i3, i5);
        this.b = i4;
    }

    public static long a(int i2, int i3, int i4) {
        return ((i2 & 65535) << 48) + ((i3 & 65535) << 32) + ((i4 & 65535) << 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.a == x0Var.a && this.b == x0Var.b;
    }

    public int hashCode() {
        long j2 = this.a;
        return ((int) (j2 ^ (j2 >>> 32))) + (this.b * 17);
    }
}
