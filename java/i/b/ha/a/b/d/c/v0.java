package i.b.ha.a.b.d.c;

import java.io.Serializable;

/* loaded from: classes.dex */
public class v0 implements Serializable {
    public static final v0 d = new v0("encryption");
    public static final v0 e = new v0("compression method");
    public static final v0 f = new v0("data descriptor");
    public static final v0 g = new v0("splitting");

    /* renamed from: h, reason: collision with root package name */
    public static final v0 f1442h = new v0("unknown compressed size");
    private final String c;

    private v0(String str) {
        this.c = str;
    }

    public String toString() {
        return this.c;
    }
}
