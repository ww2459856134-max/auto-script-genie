package l.a.a.i;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Calendar;

/* loaded from: classes.dex */
public abstract class i {
    public static byte[] a(char[] cArr, boolean z) {
        return z ? c(cArr) : b(cArr);
    }

    private static byte[] b(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            bArr[i2] = (byte) cArr[i2];
        }
        return bArr;
    }

    private static byte[] c(char[] cArr) {
        try {
            ByteBuffer byteBufferEncode = e.b.encode(CharBuffer.wrap(cArr));
            byte[] bArr = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr);
            return bArr;
        } catch (Exception unused) {
            return b(cArr);
        }
    }

    public static boolean d(File file) throws l.a.a.c.b {
        if (file == null) {
            throw new l.a.a.c.b("output path is null");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            throw new l.a.a.c.b("output directory is not valid");
        }
        if (file.mkdirs()) {
            return true;
        }
        throw new l.a.a.c.b("Cannot create output directories");
    }

    private static long e(long j2) {
        int i2 = (int) ((j2 << 1) & 62);
        int i3 = (int) ((j2 >> 5) & 63);
        int i4 = (int) ((j2 >> 11) & 31);
        int i5 = (int) ((j2 >> 16) & 31);
        int i6 = (int) (((j2 >> 21) & 15) - 1);
        int i7 = (int) (((j2 >> 25) & 127) + 1980);
        Calendar calendar = Calendar.getInstance();
        calendar.set(i7, i6, i5, i4, i3, i2);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static long f(long j2) {
        return e(j2) + (j2 >> 32);
    }

    private static long g(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        if (calendar.get(1) < 1980) {
            return 2162688L;
        }
        return (calendar.get(13) >> 1) | ((r5 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
    }

    public static long h(long j2) {
        if (j2 < 0) {
            return 2162688L;
        }
        long jG = g(j2);
        if (jG != 2162688) {
            return jG + ((j2 % 2000) << 32);
        }
        return 2162688L;
    }

    public static l.a.a.f.t.d i(l.a.a.f.b bVar) throws l.a.a.c.b {
        if (bVar.e() != l.a.a.f.t.d.AES_INTERNAL_ONLY) {
            return bVar.e();
        }
        if (bVar.c() != null) {
            return bVar.c().e();
        }
        throw new l.a.a.c.b("AesExtraDataRecord not present in local header for aes encrypted data");
    }

    public static boolean j(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean k(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int l(InputStream inputStream, byte[] bArr) throws IOException {
        int iN = inputStream.read(bArr);
        if (iN == -1) {
            throw new IOException("Unexpected EOF reached when trying to read stream");
        }
        if (iN == bArr.length || (iN = n(inputStream, bArr, iN)) == bArr.length) {
            return iN;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    public static int m(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative offset");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (i2 + i3 > bArr.length) {
            throw new IllegalArgumentException("Length greater than buffer size");
        }
        while (i4 != i3) {
            int i5 = inputStream.read(bArr, i2 + i4, i3 - i4);
            if (i5 == -1) {
                if (i4 == 0) {
                    return -1;
                }
                return i4;
            }
            i4 += i5;
        }
        return i4;
    }

    private static int n(InputStream inputStream, byte[] bArr, int i2) throws IOException {
        if (i2 < 0) {
            throw new IOException("Invalid readLength");
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        int length = bArr.length - i2;
        for (int i4 = 1; i2 < bArr.length && i3 != -1 && i4 < 15; i4++) {
            i3 = inputStream.read(bArr, i2, length);
            if (i3 > 0) {
                i2 += i3;
                length -= i3;
            }
        }
        return i2;
    }
}
