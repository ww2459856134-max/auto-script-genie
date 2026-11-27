package i.b.ha.a.b.f;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* loaded from: classes.dex */
public class d extends c {
    private final SeekableByteChannel f;

    public d(long j2, long j3, SeekableByteChannel seekableByteChannel) {
        super(j2, j3);
        this.f = seekableByteChannel;
    }

    @Override // i.b.ha.a.b.f.c
    protected int a(long j2, ByteBuffer byteBuffer) throws IOException {
        int i2;
        synchronized (this.f) {
            this.f.position(j2);
            i2 = this.f.read(byteBuffer);
        }
        byteBuffer.flip();
        return i2;
    }
}
