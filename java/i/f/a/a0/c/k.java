package i.f.a.a0.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
abstract class k {
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f1654h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f1655i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f1656j;

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ k[] f1657k;

    static {
        c cVar = new c("DATA_MASK_000", 0);
        c = cVar;
        final String str = "DATA_MASK_001";
        final int i2 = 1;
        k kVar = new k(str, i2) { // from class: i.f.a.a0.c.d
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i3, int i4) {
                return (i3 & 1) == 0;
            }
        };
        d = kVar;
        final String str2 = "DATA_MASK_010";
        final int i3 = 2;
        k kVar2 = new k(str2, i3) { // from class: i.f.a.a0.c.e
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i4, int i5) {
                return i5 % 3 == 0;
            }
        };
        e = kVar2;
        final String str3 = "DATA_MASK_011";
        final int i4 = 3;
        k kVar3 = new k(str3, i4) { // from class: i.f.a.a0.c.f
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i5, int i6) {
                return (i5 + i6) % 3 == 0;
            }
        };
        f = kVar3;
        final String str4 = "DATA_MASK_100";
        final int i5 = 4;
        k kVar4 = new k(str4, i5) { // from class: i.f.a.a0.c.g
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i6, int i7) {
                return (((i6 / 2) + (i7 / 3)) & 1) == 0;
            }
        };
        g = kVar4;
        final String str5 = "DATA_MASK_101";
        final int i6 = 5;
        k kVar5 = new k(str5, i6) { // from class: i.f.a.a0.c.h
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i7, int i8) {
                return (i7 * i8) % 6 == 0;
            }
        };
        f1654h = kVar5;
        final String str6 = "DATA_MASK_110";
        final int i7 = 6;
        k kVar6 = new k(str6, i7) { // from class: i.f.a.a0.c.i
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i8, int i9) {
                return (i8 * i9) % 6 < 3;
            }
        };
        f1655i = kVar6;
        final String str7 = "DATA_MASK_111";
        final int i8 = 7;
        k kVar7 = new k(str7, i8) { // from class: i.f.a.a0.c.j
            {
                c cVar2 = null;
            }

            @Override // i.f.a.a0.c.k
            boolean a(int i9, int i10) {
                return (((i9 + i10) + ((i9 * i10) % 3)) & 1) == 0;
            }
        };
        f1656j = kVar7;
        f1657k = new k[]{cVar, kVar, kVar2, kVar3, kVar4, kVar5, kVar6, kVar7};
    }

    private k(String str, int i2) {
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f1657k.clone();
    }

    abstract boolean a(int i2, int i3);

    final void b(i.f.a.v.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bVar.c(i4, i3);
                }
            }
        }
    }

    /* synthetic */ k(String str, int i2, c cVar) {
        this(str, i2);
    }
}
