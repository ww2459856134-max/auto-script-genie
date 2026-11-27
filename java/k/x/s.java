package k.x;

/* loaded from: classes.dex */
public class s {
    private static k.y.c c = k.y.c.b(s.class);
    private static s[] d = new s[0];
    public static final s e = new s(1, "US", "USA");
    public static final s f;
    public static final s g;
    private int a;
    private String b;

    static {
        new s(2, "CA", "Canada");
        new s(30, "GR", "Greece");
        new s(31, "NE", "Netherlands");
        new s(32, "BE", "Belgium");
        new s(33, "FR", "France");
        new s(34, "ES", "Spain");
        new s(39, "IT", "Italy");
        new s(41, "CH", "Switzerland");
        f = new s(44, "UK", "United Kingdowm");
        new s(45, "DK", "Denmark");
        new s(46, "SE", "Sweden");
        new s(47, "NO", "Norway");
        new s(49, "DE", "Germany");
        new s(63, "PH", "Philippines");
        new s(86, "CN", "China");
        new s(91, "IN", "India");
        g = new s(65535, "??", "Unknown");
    }

    private s(int i2, String str, String str2) {
        this.a = i2;
        this.b = str;
        s[] sVarArr = d;
        s[] sVarArr2 = new s[sVarArr.length + 1];
        System.arraycopy(sVarArr, 0, sVarArr2, 0, sVarArr.length);
        sVarArr2[d.length] = this;
        d = sVarArr2;
    }

    public static s b(String str) {
        if (str == null || str.length() != 2) {
            c.f("Please specify two character ISO 3166 country code");
            return e;
        }
        s sVar = g;
        int i2 = 0;
        while (true) {
            s[] sVarArr = d;
            if (i2 >= sVarArr.length || sVar != g) {
                break;
            }
            if (sVarArr[i2].b.equals(str)) {
                sVar = d[i2];
            }
            i2++;
        }
        return sVar;
    }

    public String a() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}
