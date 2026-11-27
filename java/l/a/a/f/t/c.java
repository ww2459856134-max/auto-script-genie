package l.a.a.f.t;

/* loaded from: classes.dex */
public enum c {
    NO_COMPRESSION(0),
    FASTEST(1),
    FASTER(2),
    FAST(3),
    MEDIUM_FAST(4),
    NORMAL(5),
    HIGHER(6),
    MAXIMUM(7),
    PRE_ULTRA(8),
    ULTRA(9);

    private final int c;

    c(int i2) {
        this.c = i2;
    }

    public int a() {
        return this.c;
    }
}
