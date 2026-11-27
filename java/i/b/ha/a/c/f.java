package i.b.ha.a.c;

import java.util.Objects;

/* loaded from: classes.dex */
public enum f {
    CR("\r"),
    CRLF("\r\n"),
    LF("\n");

    private final String c;

    f(String str) {
        Objects.requireNonNull(str, "lineSeparator");
        this.c = str;
    }

    public String b() {
        return this.c;
    }
}
