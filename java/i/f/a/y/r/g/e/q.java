package i.f.a.y.r.g.e;

/* loaded from: classes.dex */
final class q extends r {
    private final int b;
    private final int c;

    q(int i2, int i3, int i4) throws i.f.a.g {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw i.f.a.g.a();
        }
        this.b = i3;
        this.c = i4;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    boolean d() {
        return this.b == 10;
    }

    boolean e() {
        return this.c == 10;
    }
}
