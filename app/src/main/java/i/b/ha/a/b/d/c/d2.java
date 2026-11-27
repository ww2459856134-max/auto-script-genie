package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
final class d2 extends i.b.ha.a.b.f.c {
    private final FileChannel f;

    d2(long j2, long j3, FileChannel fileChannel) {
        super(j2, j3);
        this.f = fileChannel;
    }

    @Override // i.b.ha.a.b.f.c
    protected int a(long j2, ByteBuffer byteBuffer) throws IOException {
        int i2 = this.f.read(byteBuffer, j2);
        byteBuffer.flip();
        return i2;
    }
}
