package n.a.a.l.b;

/* loaded from: classes.dex */
public enum a {
    ecb("ECB", 1, null),
    cbc("CBC", 2, "ChainingModeCBC"),
    cfb("CFB8", 3, "ChainingModeCFB");

    public final String c;

    a(String str, int i2, String str2) {
        this.c = str;
    }
}
