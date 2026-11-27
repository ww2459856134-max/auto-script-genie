package i.f.a.w.b;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: h, reason: collision with root package name */
    private static final j[] f1698h = a();
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final i f;
    private final int g;

    private j(int i2, int i3, int i4, int i5, int i6, i iVar) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f = iVar;
        int iB = iVar.b();
        int iA = 0;
        for (h hVar : iVar.a()) {
            iA += hVar.a() * (hVar.b() + iB);
        }
        this.g = iA;
    }

    private static j[] a() {
        return new j[]{new j(1, 10, 10, 8, 8, new i(5, new h(1, 3))), new j(2, 12, 12, 10, 10, new i(7, new h(1, 5))), new j(3, 14, 14, 12, 12, new i(10, new h(1, 8))), new j(4, 16, 16, 14, 14, new i(12, new h(1, 12))), new j(5, 18, 18, 16, 16, new i(14, new h(1, 18))), new j(6, 20, 20, 18, 18, new i(18, new h(1, 22))), new j(7, 22, 22, 20, 20, new i(20, new h(1, 30))), new j(8, 24, 24, 22, 22, new i(24, new h(1, 36))), new j(9, 26, 26, 24, 24, new i(28, new h(1, 44))), new j(10, 32, 32, 14, 14, new i(36, new h(1, 62))), new j(11, 36, 36, 16, 16, new i(42, new h(1, 86))), new j(12, 40, 40, 18, 18, new i(48, new h(1, 114))), new j(13, 44, 44, 20, 20, new i(56, new h(1, 144))), new j(14, 48, 48, 22, 22, new i(68, new h(1, 174))), new j(15, 52, 52, 24, 24, new i(42, new h(2, 102))), new j(16, 64, 64, 14, 14, new i(56, new h(2, 140))), new j(17, 72, 72, 16, 16, new i(36, new h(4, 92))), new j(18, 80, 80, 18, 18, new i(48, new h(4, 114))), new j(19, 88, 88, 20, 20, new i(56, new h(4, 144))), new j(20, 96, 96, 22, 22, new i(68, new h(4, 174))), new j(21, 104, 104, 24, 24, new i(56, new h(6, 136))), new j(22, 120, 120, 18, 18, new i(68, new h(6, 175))), new j(23, 132, 132, 20, 20, new i(62, new h(8, 163))), new j(24, 144, 144, 22, 22, new i(62, new h(8, 156), new h(2, 155))), new j(25, 8, 18, 6, 16, new i(7, new h(1, 5))), new j(26, 8, 32, 6, 14, new i(11, new h(1, 10))), new j(27, 12, 26, 10, 24, new i(14, new h(1, 16))), new j(28, 12, 36, 10, 16, new i(18, new h(1, 22))), new j(29, 16, 36, 14, 16, new i(24, new h(1, 32))), new j(30, 16, 48, 14, 22, new i(28, new h(1, 49)))};
    }

    public static j h(int i2, int i3) throws i.f.a.g {
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw i.f.a.g.a();
        }
        for (j jVar : f1698h) {
            if (jVar.b == i2 && jVar.c == i3) {
                return jVar;
            }
        }
        throw i.f.a.g.a();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    i d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.g;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
