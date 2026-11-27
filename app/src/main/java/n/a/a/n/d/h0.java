package n.a.a.n.d;

/* loaded from: classes.dex */
public enum h0 {
    SINGLE(1),
    DOUBLE(2),
    SINGLE_ACCOUNTING(3),
    DOUBLE_ACCOUNTING(4),
    NONE(5);


    /* renamed from: i, reason: collision with root package name */
    private static h0[] f2460i = new h0[6];
    private int c;

    static {
        for (h0 h0Var : values()) {
            f2460i[h0Var.b()] = h0Var;
        }
    }

    h0(int i2) {
        this.c = i2;
    }

    public static h0 c(int i2) {
        return f2460i[i2];
    }

    public byte a() {
        int i2 = g0.a[ordinal()];
        if (i2 == 1) {
            return (byte) 2;
        }
        if (i2 == 2) {
            return (byte) 34;
        }
        if (i2 != 3) {
            return i2 != 4 ? (byte) 1 : (byte) 0;
        }
        return (byte) 33;
    }

    public int b() {
        return this.c;
    }
}
