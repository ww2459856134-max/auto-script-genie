package n.a.a.k.c;

import i.b.ha.a.b.d.c.o1;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* loaded from: classes.dex */
public interface c extends Closeable {
    Enumeration<? extends o1> A();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    o1 k(String str);

    boolean l();

    InputStream v(o1 o1Var) throws IOException;
}
