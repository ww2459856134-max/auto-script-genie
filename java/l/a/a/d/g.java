package l.a.a.d;

/* loaded from: classes.dex */
public enum g {
    DEFAULT(10),
    DEFLATE_COMPRESSED(20),
    ZIP_64_FORMAT(45),
    AES_ENCRYPTED(51);

    private final int c;

    g(int i2) {
        this.c = i2;
    }

    public int a() {
        return this.c;
    }
}
