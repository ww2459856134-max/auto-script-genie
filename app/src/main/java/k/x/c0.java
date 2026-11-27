package k.x;

/* loaded from: classes.dex */
public abstract class c0 {
    public static void a(double d, byte[] bArr, int i2) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        bArr[i2] = (byte) (255 & jDoubleToLongBits);
        bArr[i2 + 1] = (byte) ((65280 & jDoubleToLongBits) >> 8);
        bArr[i2 + 2] = (byte) ((16711680 & jDoubleToLongBits) >> 16);
        bArr[i2 + 3] = (byte) (((-16777216) & jDoubleToLongBits) >> 24);
        bArr[i2 + 4] = (byte) ((1095216660480L & jDoubleToLongBits) >> 32);
        bArr[i2 + 5] = (byte) ((280375465082880L & jDoubleToLongBits) >> 40);
        bArr[i2 + 6] = (byte) ((71776119061217280L & jDoubleToLongBits) >> 48);
        bArr[i2 + 7] = (byte) ((jDoubleToLongBits & (-72057594037927936L)) >> 56);
    }

    public static double b(byte[] bArr, int i2) {
        int iD = s0.d(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]);
        boolean z = (Integer.MIN_VALUE & s0.d(bArr[i2 + 4], bArr[i2 + 5], bArr[i2 + 6], bArr[i2 + 7])) != 0;
        long j2 = (r7 & Integer.MAX_VALUE) * 4294967296L;
        long j3 = iD;
        if (iD < 0) {
            j3 += 4294967296L;
        }
        double dLongBitsToDouble = Double.longBitsToDouble(j2 + j3);
        return z ? -dLongBitsToDouble : dLongBitsToDouble;
    }
}
