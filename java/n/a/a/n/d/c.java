package n.a.a.n.d;

/* loaded from: classes.dex */
public enum c {
    NONE(0),
    THIN(1),
    MEDIUM(2),
    DASHED(3),
    DOTTED(4),
    THICK(5),
    DOUBLE(6),
    HAIR(7),
    MEDIUM_DASHED(8),
    DASH_DOT(9),
    MEDIUM_DASH_DOT(10),
    DASH_DOT_DOT(11),
    MEDIUM_DASH_DOT_DOT(12),
    SLANTED_DASH_DOT(13);

    private static final c[] I = new c[14];
    private final short c;

    static {
        for (c cVar : values()) {
            I[cVar.a()] = cVar;
        }
    }

    c(int i2) {
        this.c = (short) i2;
    }

    public short a() {
        return this.c;
    }
}
