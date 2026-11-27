package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public enum d8 {
    ExactMatch(0),
    ExactMatchFallbackToSmallerValue(-1),
    ExactMatchFallbackToLargerValue(1),
    WildcardMatch(2);

    private final int c;

    d8(int i2) {
        this.c = i2;
    }

    public int a() {
        return this.c;
    }
}
