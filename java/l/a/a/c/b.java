package l.a.a.c;

import java.io.IOException;

/* loaded from: classes.dex */
public class b extends IOException {
    public b(String str) {
        super(str);
        a aVar = a.UNKNOWN;
    }

    public b(Exception exc) {
        super(exc);
        a aVar = a.UNKNOWN;
    }

    public b(String str, Exception exc) {
        super(str, exc);
        a aVar = a.UNKNOWN;
    }

    public b(String str, a aVar) {
        super(str);
        a aVar2 = a.UNKNOWN;
    }

    public b(String str, Throwable th, a aVar) {
        super(str, th);
        a aVar2 = a.UNKNOWN;
    }
}
