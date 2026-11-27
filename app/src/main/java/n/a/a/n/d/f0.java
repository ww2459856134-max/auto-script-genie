package n.a.a.n.d;

/* loaded from: classes.dex */
public enum f0 {
    NONE(1),
    MAJOR(2),
    MINOR(3);

    private static final f0[] g = {null, NONE, MAJOR, MINOR};
    private final int c;

    f0(int i2) {
        this.c = i2;
    }

    public static f0 b(int i2) {
        return g[i2];
    }

    public int a() {
        return this.c;
    }
}
