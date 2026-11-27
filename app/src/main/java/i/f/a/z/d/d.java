package i.f.a.z.d;

/* loaded from: classes.dex */
final class d {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private int e = -1;

    d(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
    }

    int a() {
        return this.c;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.e;
    }

    int d() {
        return this.a;
    }

    int e() {
        return this.d;
    }

    int f() {
        return this.b - this.a;
    }

    boolean g() {
        return h(this.e);
    }

    boolean h(int i2) {
        return i2 != -1 && this.c == (i2 % 3) * 3;
    }

    void i(int i2) {
        this.e = i2;
    }

    void j() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}
