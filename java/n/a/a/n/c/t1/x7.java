package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class x7 {
    private int a = -1;
    private int b;

    public x7(int i2) {
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        int i2 = this.b;
        int i3 = this.a;
        int i4 = i2 - i3;
        if (i4 < 2) {
            return -1;
        }
        return i3 + (i4 / 2);
    }

    public void d(int i2, boolean z) {
        if (z) {
            this.b = i2;
        } else {
            this.a = i2;
        }
    }
}
