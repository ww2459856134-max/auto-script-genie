package i.b.ha.a.c.j;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f extends i {
    @Deprecated
    public f(InputStream inputStream) {
        super(inputStream);
    }

    public static f j(InputStream inputStream) {
        return new f(inputStream);
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in = g.c;
    }
}
