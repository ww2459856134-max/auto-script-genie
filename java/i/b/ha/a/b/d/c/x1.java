package i.b.ha.a.b.d.c;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class x1 implements Serializable {
    public static final x1 d = new x1(0);
    private static final BigInteger e = BigInteger.ONE.shiftLeft(63);
    private final long c;

    public x1(byte[] bArr, int i2) {
        this.c = e(bArr, i2);
    }

    public static byte[] b(long j2) {
        return ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j2).array();
    }

    public static long d(byte[] bArr) {
        return e(bArr, 0);
    }

    public static long e(byte[] bArr, int i2) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong(i2);
    }

    public static BigInteger f(byte[] bArr) {
        return g(bArr, 0);
    }

    public static BigInteger g(byte[] bArr, int i2) {
        return h(e(bArr, i2));
    }

    static BigInteger h(long j2) {
        return j2 >= 0 ? BigInteger.valueOf(j2) : BigInteger.valueOf(j2 & Long.MAX_VALUE).add(e);
    }

    public byte[] a() {
        return b(this.c);
    }

    public long c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof x1) && this.c == ((x1) obj).c;
    }

    public int hashCode() {
        return Long.hashCode(this.c);
    }

    public String toString() {
        return defpackage.d.a(this.c, 10);
    }

    public x1(long j2) {
        this.c = j2;
    }
}
