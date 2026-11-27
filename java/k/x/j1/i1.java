package k.x.j1;

import java.util.HashMap;

/* loaded from: classes.dex */
class i1 {
    public static final i1 I;
    public static final i1 J;
    public static final i1 K;
    public static final i1 L;
    public static final i1 M;
    public static final i1 N;
    public final int[] a;
    private static HashMap b = new HashMap(20);
    public static final i1 c = new i1(68, 36, 100);
    public static final i1 d = new i1(90, 58, 122);
    public static final i1 e = new i1(22);
    public static final i1 f = new i1(23);
    public static final i1 g = new i1(28);

    /* renamed from: h, reason: collision with root package name */
    public static final i1 f2125h = new i1(29);

    /* renamed from: i, reason: collision with root package name */
    public static final i1 f2126i = new i1(30);

    /* renamed from: j, reason: collision with root package name */
    public static final i1 f2127j = new i1(31);

    /* renamed from: k, reason: collision with root package name */
    public static final i1 f2128k = new i1(42, 74, 106);

    /* renamed from: l, reason: collision with root package name */
    public static final i1 f2129l = new i1(44, 76, 108);

    /* renamed from: m, reason: collision with root package name */
    public static final i1 f2130m = new i1(45, 77, 109);

    /* renamed from: n, reason: collision with root package name */
    public static final i1 f2131n = new i1(38, 70, 102);

    /* renamed from: o, reason: collision with root package name */
    public static final i1 f2132o = new i1(37, 101, 69);
    public static final i1 p = new i1(35, 67, 99);
    public static final i1 q = new i1(57, 89);
    public static final i1 r = new i1(59, 91);
    public static final i1 s = new i1(18);
    public static final i1 t = new i1(19);
    public static final i1 u = new i1(20);
    public static final i1 v = new i1(21);
    public static final i1 w = new i1(3);
    public static final i1 x = new i1(4);
    public static final i1 y = new i1(5);
    public static final i1 z = new i1(6);
    public static final i1 A = new i1(7);
    public static final i1 B = new i1(8);
    public static final i1 C = new i1(9);
    public static final i1 D = new i1(10);
    public static final i1 E = new i1(11);
    public static final i1 F = new i1(12);
    public static final i1 G = new i1(13);
    public static final i1 H = new i1(14);

    static {
        new i1(16);
        I = new i1(17);
        J = new i1(65, 33, 97);
        K = new i1(66, 34, 98);
        L = new i1(25);
        M = new i1(41, 73, 105);
        N = new i1(65535);
    }

    private i1(int i2) {
        this.a = new int[]{i2};
        b.put(new Integer(i2), this);
    }

    public static i1 d(int i2) {
        i1 i1Var = (i1) b.get(new Integer(i2));
        return i1Var != null ? i1Var : N;
    }

    public byte a() {
        return (byte) this.a[0];
    }

    public byte b() {
        int[] iArr = this.a;
        return (byte) (iArr.length > 0 ? iArr[1] : iArr[0]);
    }

    public byte c() {
        return (byte) this.a[0];
    }

    public byte e() {
        int[] iArr = this.a;
        return (byte) (iArr.length > 0 ? iArr[1] : iArr[0]);
    }

    private i1(int i2, int i3) {
        this.a = new int[]{i2, i3};
        b.put(new Integer(i2), this);
        b.put(new Integer(i3), this);
    }

    private i1(int i2, int i3, int i4) {
        this.a = new int[]{i2, i3, i4};
        b.put(new Integer(i2), this);
        b.put(new Integer(i3), this);
        b.put(new Integer(i4), this);
    }
}
