package i.b.ha.a.b.e.c;

/* loaded from: classes.dex */
final class c {
    private final int a;
    int b;
    c c;
    c d;

    void a(int i2) {
        this.b = i2;
        this.c = null;
        this.d = null;
    }

    c b() {
        if (this.c == null && this.b == -1) {
            this.c = new c(this.a + 1);
        }
        return this.c;
    }

    c c() {
        if (this.d == null && this.b == -1) {
            this.d = new c(this.a + 1);
        }
        return this.d;
    }

    private c(int i2) {
        this.b = -1;
        this.a = i2;
    }
}
