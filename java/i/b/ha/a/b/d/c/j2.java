package i.b.ha.a.b.d.c;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class j2 implements Cloneable, Serializable {
    public static final j2 d = new j2(33639248);
    public static final j2 e = new j2(67324752);
    public static final j2 f = new j2(134695760);
    static final j2 g = new j2(4294967295L);

    /* renamed from: h, reason: collision with root package name */
    public static final j2 f1423h = new j2(808471376);

    /* renamed from: i, reason: collision with root package name */
    public static final j2 f1424i = new j2(134630224);
    private final long c;

    public j2(byte[] bArr) {
        this(bArr, 0);
    }

    public static byte[] b(long j2) {
        byte[] bArr = new byte[4];
        g(j2, bArr, 0);
        return bArr;
    }

    public static long e(byte[] bArr) {
        return f(bArr, 0);
    }

    public static long f(byte[] bArr, int i2) {
        return i.b.ha.a.b.f.e.b(bArr, i2, 4);
    }

    public static void g(long j2, byte[] bArr, int i2) {
        i.b.ha.a.b.f.e.c(bArr, j2, i2, 4);
    }

    public byte[] a() {
        return b(this.c);
    }

    public int c() {
        return (int) this.c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public long d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j2) && this.c == ((j2) obj).d();
    }

    public void h(byte[] bArr, int i2) {
        g(this.c, bArr, i2);
    }

    public int hashCode() {
        return (int) this.c;
    }

    public String toString() {
        return "ZipLong value: " + this.c;
    }

    public j2(byte[] bArr, int i2) {
        this.c = f(bArr, i2);
    }

    public j2(long j2) {
        this.c = j2;
    }
}
