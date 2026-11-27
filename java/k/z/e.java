package k.z;

/* loaded from: classes.dex */
public class e {
    private static e[] b = new e[0];
    public static final e c = new e(32750, "unknown", 0, 0, 0);
    public static final e d = new e(32767, "black", 0, 0, 0);
    public static final e e;
    public static final e f;
    public static final e g;

    /* renamed from: h, reason: collision with root package name */
    public static final e f2180h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f2181i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f2182j;

    /* renamed from: k, reason: collision with root package name */
    public static final e f2183k;

    /* renamed from: l, reason: collision with root package name */
    public static final e f2184l;
    private int a;

    static {
        new e(9, "white", 255, 255, 255);
        e = new e(0, "default background", 255, 255, 255);
        f = new e(192, "default background", 255, 255, 255);
        g = new e(8, "black", 1, 0, 0);
        new e(10, "red", 255, 0, 0);
        new e(11, "bright green", 0, 255, 0);
        f2180h = new e(12, "blue", 0, 0, 255);
        new e(13, "yellow", 255, 255, 0);
        new e(14, "pink", 255, 0, 255);
        new e(15, "turquoise", 0, 255, 255);
        new e(16, "dark red", 128, 0, 0);
        new e(17, "green", 0, 128, 0);
        new e(18, "dark blue", 0, 0, 128);
        new e(19, "dark yellow", 128, 128, 0);
        new e(20, "violet", 128, 128, 0);
        new e(21, "teal", 0, 128, 128);
        f2181i = new e(22, "grey 25%", 192, 192, 192);
        f2182j = new e(23, "grey 50%", 128, 128, 128);
        new e(24, "periwinkle%", 153, 153, 255);
        new e(25, "plum", 153, 51, 102);
        new e(26, "ivory", 255, 255, 204);
        new e(27, "light turquoise", 204, 255, 255);
        new e(28, "dark purple", 102, 0, 102);
        new e(29, "coral", 255, 128, 128);
        new e(30, "ocean blue", 0, 102, 204);
        new e(31, "ice blue", 204, 204, 255);
        new e(32, "dark blue", 0, 0, 128);
        new e(33, "pink", 255, 0, 255);
        new e(34, "yellow", 255, 255, 0);
        new e(35, "turqoise", 0, 255, 255);
        new e(36, "violet", 128, 0, 128);
        new e(37, "dark red", 128, 0, 0);
        new e(38, "teal", 0, 128, 128);
        new e(39, "blue", 0, 0, 255);
        new e(40, "sky blue", 0, 204, 255);
        new e(41, "light turquoise", 204, 255, 255);
        new e(42, "light green", 204, 255, 204);
        new e(43, "very light yellow", 255, 255, 153);
        new e(44, "pale blue", 153, 204, 255);
        new e(45, "rose", 255, 153, 204);
        new e(46, "lavender", 204, 153, 255);
        new e(47, "tan", 255, 204, 153);
        new e(48, "light blue", 51, 102, 255);
        new e(49, "aqua", 51, 204, 204);
        new e(50, "lime", 153, 204, 0);
        new e(51, "gold", 255, 204, 0);
        new e(52, "light orange", 255, 153, 0);
        new e(53, "orange", 255, 102, 0);
        new e(54, "blue grey", 102, 102, 204);
        new e(55, "grey 40%", 150, 150, 150);
        new e(56, "dark teal", 0, 51, 102);
        new e(57, "sea green", 51, 153, 102);
        new e(58, "dark green", 0, 51, 0);
        new e(59, "olive green", 51, 51, 0);
        new e(60, "brown", 153, 51, 0);
        new e(61, "plum", 153, 51, 102);
        new e(62, "indigo", 51, 51, 153);
        f2183k = new e(63, "grey 80%", 51, 51, 51);
        f2184l = new e(64, "automatic", 255, 255, 255);
    }

    protected e(int i2, String str, int i3, int i4, int i5) {
        this.a = i2;
        e[] eVarArr = b;
        e[] eVarArr2 = new e[eVarArr.length + 1];
        b = eVarArr2;
        System.arraycopy(eVarArr, 0, eVarArr2, 0, eVarArr.length);
        b[eVarArr.length] = this;
    }

    public static e a(int i2) {
        int i3 = 0;
        while (true) {
            e[] eVarArr = b;
            if (i3 >= eVarArr.length) {
                return c;
            }
            if (eVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
