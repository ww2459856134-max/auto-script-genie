package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class ba {
    private final int a;
    private final int b;

    public ba(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalStateException("length may not be zero");
        }
        this.a = i2;
        this.b = i3;
    }

    public short a() {
        return (short) this.a;
    }

    public short b() {
        return (short) ((this.a + this.b) - 1);
    }

    public boolean c(int i2, int i3) {
        return this.a < i2 || b() > i3;
    }

    public ba d(int i2) {
        int i3 = this.b;
        return i3 > 0 ? i2 == 0 ? this : new ba(i2 + this.a, i3) : new ba(i2 + this.a + i3 + 1, -i3);
    }

    public String toString() {
        return ba.class.getName() + " [" + this.a + "..." + ((int) b()) + "]";
    }
}
