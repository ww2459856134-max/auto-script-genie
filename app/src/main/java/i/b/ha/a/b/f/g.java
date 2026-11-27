package i.b.ha.a.b.f;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class g {
    public static int a(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (i3 < 0 || i2 < 0 || (i4 = i3 + i2) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        return i.b.ha.a.c.e.n(inputStream, bArr, i2, i3);
    }

    public static void b(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        if (i.b.ha.a.c.e.o(readableByteChannel, byteBuffer) < byteBuffer.remaining()) {
            throw new EOFException();
        }
    }

    public static byte[] c(InputStream inputStream, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i.b.ha.a.c.e.j(inputStream, byteArrayOutputStream, 0L, i2);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] d(ReadableByteChannel readableByteChannel, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.min(i2, XMLEvent.ENTITY_REFERENCE));
        int i3 = 0;
        while (i3 < i2) {
            byteBufferAllocate.limit(Math.min(i2 - i3, byteBufferAllocate.capacity()));
            int i4 = readableByteChannel.read(byteBufferAllocate);
            if (i4 <= 0) {
                break;
            }
            byteArrayOutputStream.write(byteBufferAllocate.array(), 0, i4);
            byteBufferAllocate.rewind();
            i3 += i4;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
