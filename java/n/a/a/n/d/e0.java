package n.a.a.n.d;

/* loaded from: classes.dex */
public enum e0 {
    NOT_APPLICABLE(0),
    ROMAN(1),
    SWISS(2),
    MODERN(3),
    SCRIPT(4),
    DECORATIVE(5);


    /* renamed from: j, reason: collision with root package name */
    private static e0[] f2456j = new e0[6];
    private int c;

    static {
        for (e0 e0Var : values()) {
            f2456j[e0Var.a()] = e0Var;
        }
    }

    e0(int i2) {
        this.c = i2;
    }

    public static e0 b(int i2) {
        return f2456j[i2];
    }

    public int a() {
        return this.c;
    }
}
