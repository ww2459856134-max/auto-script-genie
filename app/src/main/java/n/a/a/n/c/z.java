package n.a.a.n.c;

/* loaded from: classes.dex */
enum z {
    CELL,
    ROW,
    COLUMN;

    public static z a(boolean z, boolean z2) {
        if (z) {
            return z2 ? CELL : COLUMN;
        }
        if (z2) {
            return ROW;
        }
        throw new IllegalArgumentException("must have either letters or numbers");
    }
}
