package k.x.i1;

/* loaded from: classes.dex */
final class b0 {
    private static b0[] b = new b0[0];
    public static final b0 c = new b0(0);
    public static final b0 d = new b0(61440);
    public static final b0 e = new b0(61441);
    public static final b0 f = new b0(61442);
    public static final b0 g = new b0(61443);

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f2039h = new b0(61444);

    /* renamed from: i, reason: collision with root package name */
    public static final b0 f2040i = new b0(61446);

    /* renamed from: j, reason: collision with root package name */
    public static final b0 f2041j = new b0(61447);

    /* renamed from: k, reason: collision with root package name */
    public static final b0 f2042k = new b0(61448);

    /* renamed from: l, reason: collision with root package name */
    public static final b0 f2043l = new b0(61449);

    /* renamed from: m, reason: collision with root package name */
    public static final b0 f2044m = new b0(61450);

    /* renamed from: n, reason: collision with root package name */
    public static final b0 f2045n = new b0(61451);

    /* renamed from: o, reason: collision with root package name */
    public static final b0 f2046o = new b0(61456);
    public static final b0 p = new b0(61457);
    public static final b0 q = new b0(61453);
    public static final b0 r = new b0(61726);
    private int a;

    private b0(int i2) {
        this.a = i2;
        b0[] b0VarArr = b;
        b0[] b0VarArr2 = new b0[b0VarArr.length + 1];
        System.arraycopy(b0VarArr, 0, b0VarArr2, 0, b0VarArr.length);
        b0VarArr2[b.length] = this;
        b = b0VarArr2;
    }

    public static b0 a(int i2) {
        b0 b0Var = c;
        int i3 = 0;
        while (true) {
            b0[] b0VarArr = b;
            if (i3 >= b0VarArr.length) {
                return b0Var;
            }
            if (i2 == b0VarArr[i3].a) {
                return b0VarArr[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
