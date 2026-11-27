package l.a.a.f.t;

/* loaded from: classes.dex */
public enum d {
    STORE(0),
    DEFLATE(8),
    AES_INTERNAL_ONLY(99);

    private int c;

    d(int i2) {
        this.c = i2;
    }

    public static d b(int i2) throws l.a.a.c.b {
        for (d dVar : values()) {
            if (dVar.a() == i2) {
                return dVar;
            }
        }
        throw new l.a.a.c.b("Unknown compression method", l.a.a.c.a.UNKNOWN_COMPRESSION_METHOD);
    }

    public int a() {
        return this.c;
    }
}
