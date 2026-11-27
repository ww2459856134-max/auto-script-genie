package i.b.ha.a.b.f;

/* loaded from: classes.dex */
public abstract class e {
    public static final byte[] a = new byte[0];

    private static void a(int i2) {
        if (i2 > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }

    public static long b(byte[] bArr, int i2, int i3) {
        a(i3);
        long j2 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j2 |= (bArr[i2 + i4] & 255) << (i4 * 8);
        }
        return j2;
    }

    public static void c(byte[] bArr, long j2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i2 + i4] = (byte) (255 & j2);
            j2 >>= 8;
        }
    }
}
