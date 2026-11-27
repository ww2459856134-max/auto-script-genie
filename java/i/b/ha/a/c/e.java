package i.b.ha.a.c;

import i.b.ha.a.c.i.m;
import i.b.ha.a.c.k.j;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class e {
    public static final byte[] a;

    static {
        char c = File.separatorChar;
        a = new byte[0];
        System.lineSeparator();
        f.LF.b();
        f.CRLF.b();
    }

    public static byte[] a() {
        return b(XMLEvent.ENTITY_REFERENCE);
    }

    public static byte[] b(int i2) {
        return new byte[i2];
    }

    static void c(int i2, int i3, int i4) {
        if ((i2 | i3 | i4) < 0 || i4 - i3 < i2) {
            throw new IndexOutOfBoundsException(String.format("Range [%s, %<s + %s) out of bounds for length %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void d(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "byte array");
        c(i2, i3, bArr.length);
    }

    public static void e(char[] cArr, int i2, int i3) {
        Objects.requireNonNull(cArr, "char array");
        c(i2, i3, cArr.length);
    }

    public static void f(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void g(Closeable closeable, m<IOException> mVar) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (mVar != null) {
                    mVar.accept(e);
                }
            } catch (Exception e2) {
                if (mVar != null) {
                    mVar.accept(new IOException(e2));
                }
            }
        }
    }

    public static void h(Closeable closeable) {
        i(closeable, null);
    }

    public static void i(Closeable closeable, Consumer<Exception> consumer) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (consumer != null) {
                    consumer.accept(e);
                }
            }
        }
    }

    public static long j(InputStream inputStream, OutputStream outputStream, long j2, long j3) throws IOException {
        d dVarC = d.c();
        try {
            long jK = k(inputStream, outputStream, j2, j3, dVarC.a());
            if (dVarC != null) {
                dVarC.close();
            }
            return jK;
        } catch (Throwable th) {
            if (dVarC != null) {
                try {
                    dVarC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static long k(InputStream inputStream, OutputStream outputStream, long j2, long j3, byte[] bArr) throws IOException {
        long j4 = 0;
        if (j2 > 0) {
            r(inputStream, j2);
        }
        if (j3 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int iMin = (j3 <= 0 || j3 >= ((long) length)) ? length : (int) j3;
        while (iMin > 0) {
            int i2 = inputStream.read(bArr, 0, iMin);
            if (-1 == i2) {
                break;
            }
            outputStream.write(bArr, 0, i2);
            j4 += i2;
            if (j3 > 0) {
                iMin = (int) Math.min(j3 - j4, length);
            }
        }
        return j4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static j l(InputStream inputStream, long j2, int i2) throws IOException {
        j jVarR = j.p().p(i2).get();
        try {
            i.b.ha.a.c.j.e eVarY = ((i.b.ha.a.c.j.d) i.b.ha.a.c.j.e.j().w(j2).x(false).h(inputStream)).get();
            try {
                jVarR.y(eVarY);
                if (eVarY != null) {
                    eVarY.close();
                }
                if (jVarR != null) {
                    jVarR.close();
                }
                return jVarR;
            } finally {
            }
        } catch (Throwable th) {
            if (jVarR != null) {
                try {
                    jVarR.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static int m(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static int n(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        d(bArr, i2, i3);
        int i4 = i3;
        while (i4 > 0) {
            int i5 = inputStream.read(bArr, (i3 - i4) + i2, i4);
            if (-1 == i5) {
                break;
            }
            i4 -= i5;
        }
        return i3 - i4;
    }

    public static int o(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        while (byteBuffer.remaining() > 0 && -1 != readableByteChannel.read(byteBuffer)) {
        }
        return iRemaining - byteBuffer.remaining();
    }

    public static long p(InputStream inputStream, long j2) throws IOException {
        final d dVarC = d.c();
        try {
            Objects.requireNonNull(dVarC);
            long jQ = q(inputStream, j2, new Supplier() { // from class: i.b.ha.a.c.a
                @Override // java.util.function.Supplier
                public final Object get() {
                    return dVarC.a();
                }
            });
            if (dVarC != null) {
                dVarC.close();
            }
            return jQ;
        } catch (Throwable th) {
            if (dVarC != null) {
                try {
                    dVarC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static long q(InputStream inputStream, long j2, Supplier<byte[]> supplier) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j2);
        }
        long j3 = j2;
        while (j3 > 0) {
            long j4 = inputStream.read(supplier.get(), 0, (int) Math.min(j3, r4.length));
            if (j4 < 0) {
                break;
            }
            j3 -= j4;
        }
        return j2 - j3;
    }

    public static void r(InputStream inputStream, long j2) throws IOException {
        long jP = p(inputStream, j2);
        if (jP == j2) {
            return;
        }
        throw new EOFException("Bytes to skip: " + j2 + " actual: " + jP);
    }

    public static byte[] s(InputStream inputStream) throws IOException {
        j jVarL = l(inputStream, 2147483640L, XMLEvent.ENTITY_REFERENCE);
        if (jVarL.w() <= 2147483639) {
            return jVarL.d();
        }
        throw new IOException(String.format("Cannot read more than %,d into a byte array", 2147483639));
    }
}
