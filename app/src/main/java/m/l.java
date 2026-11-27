package m;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface l extends Closeable {
    long C(a aVar, long j2) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close() throws IOException;
}
