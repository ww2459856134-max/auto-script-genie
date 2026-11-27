package n.a.a.o;

/* loaded from: classes.dex */
public abstract class y0 {
    public static int a(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = bArr[i2] & 255;
        int i5 = i3 + 1;
        int i6 = bArr[i3] & 255;
        return ((bArr[i5 + 1] & 255) << 24) + ((bArr[i5] & 255) << 16) + (i6 << 8) + i4;
    }

    public static void b(byte[] bArr, int i2, int i3) {
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i3 >>> 8) & 255);
        bArr[i5] = (byte) ((i3 >>> 16) & 255);
        bArr[i5 + 1] = (byte) ((i3 >>> 24) & 255);
    }

    public static void c(byte[] bArr, int i2, long j2) {
        bArr[i2] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >>> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >>> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >>> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >>> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >>> 56) & 255);
    }

    public static void d(byte[] bArr, int i2, short s) {
        bArr[i2] = (byte) (s & 255);
        bArr[i2 + 1] = (byte) ((s >>> 8) & 255);
    }
}
