package i.b.ha.a.b;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class b<T extends OutputStream> extends FilterOutputStream {
    private final AtomicBoolean c;

    public b() {
        super(null);
        this.c = new AtomicBoolean();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c.compareAndSet(false, true)) {
            super.close();
        }
    }
}
