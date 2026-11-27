package i.f.a.y.r.g.e;

/* loaded from: classes.dex */
final class p extends r {
    private final String b;
    private final int c;
    private final boolean d;

    p(int i2, String str) {
        super(i2);
        this.b = str;
        this.d = false;
        this.c = 0;
    }

    String b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    boolean d() {
        return this.d;
    }

    p(int i2, String str, int i3) {
        super(i2);
        this.d = true;
        this.c = i3;
        this.b = str;
    }
}
