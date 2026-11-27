package m;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface b extends Closeable, Flushable, WritableByteChannel {
    b g(String str, int i2, int i3) throws IOException;

    b t(String str) throws IOException;

    b writeByte(int i2) throws IOException;
}
