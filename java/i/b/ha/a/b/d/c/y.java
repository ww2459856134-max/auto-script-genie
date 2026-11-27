package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
final class y extends i.b.ha.a.b.f.b {
    y(InputStream inputStream) {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
    }

    long q(int i2) throws IOException {
        if (i2 >= 0 && i2 <= 8) {
            return o(i2);
        }
        throw new IOException("Trying to read " + i2 + " bits, at most 8 are allowed");
    }

    int s() throws IOException {
        return (int) o(8);
    }
}
