package n.a.a.o;

import com.auto.exceldeps.log4j.Logger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Locale;
import java.util.zip.CRC32;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class w0 {
    private static final Logger a = n.a.a.i.b.a(w0.class);
    private static int b = -1;
    private static int c = -1;

    static int a(boolean z, int i2, int i3) {
        int iMin = Math.min(i2, i3);
        if (!z) {
            iMin = Math.min(XMLEvent.CHANGE_PREFIX_MAPPING, iMin);
        }
        int i4 = c;
        return (i4 <= 0 || iMin <= i4) ? iMin : i4;
    }

    public static long b(InputStream inputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return crc32.getValue();
            }
            if (i2 > 0) {
                crc32.update(bArr, 0, i2);
            }
        }
    }

    private static void c(int i2) {
        int i3 = b;
        if (i3 == -1 || i2 <= i3) {
            return;
        }
        o(i2, i3);
        throw null;
    }

    private static void d(long j2) {
        int i2 = b;
        if (i2 == -1 || j2 <= i2) {
            return;
        }
        o(j2, i2);
        throw null;
    }

    private static void e(long j2, int i2) {
        int i3 = b;
        if (i3 > 0) {
            if (j2 <= i3) {
                return;
            }
            o(j2, i3);
            throw null;
        }
        if (j2 <= i2) {
            return;
        }
        o(j2, i2);
        throw null;
    }

    public static void f(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            a.atError().withThrowable(e).log("Unable to close resource");
        }
    }

    public static long g(InputStream inputStream, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IllegalStateException("Can't create destination directory: " + parentFile);
        }
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        try {
            long jH = h(inputStream, outputStreamNewOutputStream);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
            return jH;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static long h(InputStream inputStream, OutputStream outputStream) throws IOException {
        return i(inputStream, outputStream, -1L);
    }

    public static long i(InputStream inputStream, OutputStream outputStream, long j2) throws IOException {
        byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
        int i2 = -1;
        long j3 = 0;
        while (true) {
            long jMin = ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF;
            if (j2 >= 0) {
                jMin = Math.min(j2 - j3, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
            }
            int i3 = (int) jMin;
            if (i3 > 0) {
                int i4 = inputStream.read(bArr, 0, i3);
                if (i4 > 0) {
                    outputStream.write(bArr, 0, i4);
                    j3 += i4;
                }
                i2 = i4;
            }
            if (i2 < 0 || (j2 != -1 && j3 >= j2)) {
                break;
            }
        }
        return j3;
    }

    public static int j() {
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] k(InputStream inputStream, int i2) throws IOException, n.a.a.a {
        c(i2);
        inputStream.mark(i2);
        i.b.ha.a.c.k.j jVarR = i.b.ha.a.c.k.j.p().p(i2).get();
        try {
            h(((i.b.ha.a.c.j.d) i.b.ha.a.c.j.e.j().h(inputStream)).w(i2).get(), jVarR);
            int iW = jVarR.w();
            if (iW == 0) {
                throw new n.a.a.a();
            }
            if (iW < i2) {
                jVarR.write(new byte[i2 - iW]);
            }
            byte[] bArrD = jVarR.d();
            if (inputStream instanceof PushbackInputStream) {
                ((PushbackInputStream) inputStream).unread(bArrD, 0, iW);
            } else {
                inputStream.reset();
            }
            if (jVarR != null) {
                jVarR.close();
            }
            return bArrD;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (jVarR != null) {
                    try {
                        jVarR.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static byte[] l(long j2, int i2) {
        m(j2, i2);
        d(j2);
        return new byte[(int) j2];
    }

    public static void m(long j2, int i2) {
        if (j2 >= 0) {
            if (j2 > 2147483647L) {
                throw new d1("Can't allocate an array > 2147483647");
            }
            e(j2, i2);
        } else {
            throw new d1("Can't allocate an array of length < 0, but had " + j2 + " and " + i2);
        }
    }

    public static long n(InputStream inputStream, long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j2);
        }
        if (j2 == 0) {
            return 0L;
        }
        byte[] bArr = new byte[2048];
        long j3 = j2;
        while (j3 > 0) {
            long j4 = inputStream.read(bArr, 0, (int) Math.min(j3, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX));
            if (j4 < 0) {
                break;
            }
            j3 -= j4;
        }
        if (j2 == j3) {
            return -1L;
        }
        return j2 - j3;
    }

    private static void o(long j2, int i2) {
        throw new d1(String.format(Locale.ROOT, "Tried to allocate an array of length %,d, but the maximum length for this record type is %,d.%nIf the file is not corrupt and not large, please open an issue on bugzilla to request %nincreasing the maximum allowable size for this record type.%nYou can set a higher override value with IOUtils.setByteArrayMaxOverride()", Long.valueOf(j2), Integer.valueOf(i2)));
    }

    private static void p(int i2) {
        throw new d1(String.format(Locale.ROOT, "Tried to read data but the maximum length for this record type is %,d.%nIf the file is not corrupt and not large, please open an issue on bugzilla to request %nincreasing the maximum allowable size for this record type.%nYou can set a higher override value with IOUtils.setByteArrayMaxOverride()", Integer.valueOf(i2)));
    }

    private static byte[] q(InputStream inputStream, int i2, int i3, boolean z, boolean z2) throws IOException {
        int i4;
        int iMax = Math.max(i3, b);
        if (i2 != Integer.MAX_VALUE || iMax != Integer.MAX_VALUE) {
            e(i2, iMax);
        }
        int iMin = (!z2 || i2 < 0) ? iMax : Math.min(i2, iMax);
        i.b.ha.a.c.k.j jVarR = i.b.ha.a.c.k.j.p().p(a(z2, i2, iMax)).get();
        try {
            byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
            int iMax2 = 0;
            do {
                i4 = inputStream.read(bArr, 0, Math.min(XMLEvent.CHANGE_PREFIX_MAPPING, iMin - iMax2));
                iMax2 += Math.max(i4, 0);
                if (i4 > 0) {
                    jVarR.write(bArr, 0, i4);
                }
                c(iMax2);
                if (iMax2 >= iMin) {
                    break;
                }
            } while (i4 > -1);
            if (b < 0 && i4 > -1 && !z2 && inputStream.read() >= 0) {
                p(iMax);
                throw null;
            }
            if (!z || i2 < 0 || iMin == Integer.MAX_VALUE || iMax2 >= iMin) {
                byte[] bArrD = jVarR.d();
                if (jVarR != null) {
                    jVarR.close();
                }
                return bArrD;
            }
            throw new EOFException("unexpected EOF - expected len: " + iMin + " - actual len: " + iMax2);
        } finally {
        }
    }

    public static byte[] r(InputStream inputStream, long j2, int i2) throws IOException {
        return q(inputStream, j2 > 2147483647L ? Integer.MAX_VALUE : (int) j2, i2, true, j2 != 2147483647L);
    }

    public static byte[] s(InputStream inputStream, int i2) throws IOException {
        return q(inputStream, i2, i2, false, false);
    }
}
