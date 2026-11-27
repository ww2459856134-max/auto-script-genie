package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public abstract class o2 {
    private static final long a = e(2162688);

    static boolean a(o1 o1Var) {
        return m(o1Var) && n(o1Var);
    }

    static void b(o1 o1Var) throws w0 {
        if (!m(o1Var)) {
            throw new w0(v0.d, o1Var);
        }
        if (n(o1Var)) {
            return;
        }
        k2 k2VarC = k2.c(o1Var.getMethod());
        if (k2VarC != null) {
            throw new w0(k2VarC, o1Var);
        }
        throw new w0(v0.e, o1Var);
    }

    static byte[] c(byte[] bArr) {
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    private static Date d(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j2 >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j2 >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j2 >> 16)) & 31);
        calendar.set(11, ((int) (j2 >> 11)) & 31);
        calendar.set(12, ((int) (j2 >> 5)) & 63);
        calendar.set(13, ((int) (j2 << 1)) & 62);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static long e(long j2) {
        return d(j2).getTime();
    }

    private static String f(v vVar, byte[] bArr) {
        if (vVar == null) {
            return null;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        if (crc32.getValue() != vVar.i()) {
            return null;
        }
        try {
            return z1.a.b(vVar.j());
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean g(long j2) {
        return j2 <= 4036608000000L && (j2 == a || i(j2) != 2162688);
    }

    private static LocalDateTime h(long j2) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(j2), ZoneId.systemDefault());
    }

    private static long i(long j2) {
        if (h(j2).getYear() < 1980) {
            return 2162688L;
        }
        return ((r2.getSecond() >> 1) | ((r2.getYear() - 1980) << 25) | (r2.getMonthValue() << 21) | (r2.getDayOfMonth() << 16) | (r2.getHour() << 11) | (r2.getMinute() << 5)) & 4294967295L;
    }

    static ZipException j(String str, Throwable th) {
        return (ZipException) new ZipException(str).initCause(th);
    }

    public static byte[] k(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            byte b = bArr[i2];
            int i3 = length - i2;
            bArr[i2] = bArr[i3];
            bArr[i3] = b;
        }
        return bArr;
    }

    static void l(o1 o1Var, byte[] bArr, byte[] bArr2) {
        a2 a2VarW = o1Var.w(q0.f);
        String strF = f(a2VarW instanceof q0 ? (q0) a2VarW : null, bArr);
        if (strF != null) {
            o1Var.a0(strF);
            o1Var.c0(n1.UNICODE_EXTRA_FIELD);
        }
        if (bArr2 == null || bArr2.length <= 0) {
            return;
        }
        a2 a2VarW2 = o1Var.w(p0.f);
        String strF2 = f(a2VarW2 instanceof p0 ? (p0) a2VarW2 : null, bArr2);
        if (strF2 != null) {
            o1Var.setComment(strF2);
            o1Var.Q(j1.UNICODE_EXTRA_FIELD);
        }
    }

    private static boolean m(o1 o1Var) {
        return !o1Var.x().j();
    }

    private static boolean n(o1 o1Var) {
        int method = o1Var.getMethod();
        return method == 0 || method == k2.UNSHRINKING.b() || method == k2.IMPLODING.b() || method == 8 || method == k2.ENHANCED_DEFLATED.b() || method == k2.BZIP2.b() || k2.d(method) || method == k2.XZ.b();
    }

    public static void o(long j2, byte[] bArr, int i2) {
        j2.g(i(j2), bArr, i2);
    }

    public static byte p(int i2) {
        if (i2 <= 255 && i2 >= 0) {
            return i2 < 128 ? (byte) i2 : (byte) (i2 - 256);
        }
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i2 + "]");
    }
}
