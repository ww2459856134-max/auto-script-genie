package l.a.a.f.t;

/* loaded from: classes.dex */
public enum b {
    ONE(1),
    TWO(2);

    private int c;

    b(int i2) {
        this.c = i2;
    }

    public static b a(int i2) throws l.a.a.c.b {
        for (b bVar : values()) {
            if (bVar.c == i2) {
                return bVar;
            }
        }
        throw new l.a.a.c.b("Unsupported Aes version");
    }

    public int b() {
        return this.c;
    }
}
