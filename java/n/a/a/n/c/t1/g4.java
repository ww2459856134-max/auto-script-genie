package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class g4 {
    public static final g4 c = g("", 0);
    public static final g4 d = g("=", 1);
    public static final g4 e = g("<>", 2);
    public static final g4 f = g("<=", 3);
    public static final g4 g = g("<", 4);

    /* renamed from: h, reason: collision with root package name */
    public static final g4 f2391h = g(">", 5);

    /* renamed from: i, reason: collision with root package name */
    public static final g4 f2392i = g(">=", 6);
    private final String a;
    private final int b;

    private g4(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public static g4 e(String str) {
        int length = str.length();
        if (length < 1) {
            return c;
        }
        switch (str.charAt(0)) {
            case '<':
                if (length > 1) {
                    char cCharAt = str.charAt(1);
                    if (cCharAt == '=') {
                        break;
                    } else if (cCharAt == '>') {
                        break;
                    }
                }
                break;
            case '>':
                if (length > 1 && str.charAt(1) == '=') {
                    break;
                } else {
                    break;
                }
                break;
        }
        return c;
    }

    private static g4 g(String str, int i2) {
        return new g4(str, i2);
    }

    public boolean a(int i2) {
        switch (this.b) {
            case 0:
            case 1:
                return i2 == 0;
            case 2:
                return i2 != 0;
            case 3:
                return i2 <= 0;
            case 4:
                return i2 < 0;
            case 5:
                return i2 > 0;
            case 6:
                return i2 >= 0;
            default:
                throw new IllegalStateException("Cannot call boolean evaluate on non-equality operator '" + this.a + "'");
        }
    }

    public boolean b(boolean z) {
        int i2 = this.b;
        if (i2 == 0 || i2 == 1) {
            return z;
        }
        if (i2 == 2) {
            return !z;
        }
        throw new IllegalStateException("Cannot call boolean evaluate on non-equality operator '" + this.a + "'");
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a.length();
    }

    public String f() {
        return this.a;
    }

    public String toString() {
        return g4.class.getName() + " [" + this.a + "]";
    }
}
