package l.a.a.f.t;

/* loaded from: classes.dex */
public enum a {
    KEY_STRENGTH_128(1, 8, 16, 16),
    KEY_STRENGTH_192(2, 12, 24, 24),
    KEY_STRENGTH_256(3, 16, 32, 32);

    private int c;
    private int d;
    private int e;
    private int f;

    a(int i2, int i3, int i4, int i5) {
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    public static a a(int i2) {
        for (a aVar : values()) {
            if (aVar.d() == i2) {
                return aVar;
            }
        }
        return null;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }
}
