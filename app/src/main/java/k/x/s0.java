package k.x;

/* loaded from: classes.dex */
public abstract class s0 {
    public static void a(int i2, byte[] bArr, int i3) {
        byte[] bArrB = b(i2);
        bArr[i3] = bArrB[0];
        bArr[i3 + 1] = bArrB[1];
        bArr[i3 + 2] = bArrB[2];
        bArr[i3 + 3] = bArrB[3];
    }

    public static byte[] b(int i2) {
        byte[] bArr = new byte[4];
        f(65535 & i2, bArr, 0);
        f((i2 & (-65536)) >> 16, bArr, 2);
        return bArr;
    }

    public static int c(byte b, byte b2) {
        return (b & 255) | ((b2 & 255) << 8);
    }

    public static int d(byte b, byte b2, byte b3, byte b4) {
        return c(b, b2) | (c(b3, b4) << 16);
    }

    public static short e(byte b, byte b2) {
        return (short) (((short) (b & 255)) | (((short) (b2 & 255)) << 8));
    }

    public static void f(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 & 65280) >> 8);
    }
}
