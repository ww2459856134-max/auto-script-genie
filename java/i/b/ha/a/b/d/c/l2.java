package i.b.ha.a.b.d.c;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class l2 implements Cloneable, Serializable {
    private final int c;

    public l2(byte[] bArr, int i2) {
        this.c = e(bArr, i2);
    }

    public static byte[] b(int i2) {
        byte[] bArr = new byte[2];
        g(i2, bArr, 0);
        return bArr;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0);
    }

    public static int e(byte[] bArr, int i2) {
        return (int) i.b.ha.a.b.f.e.b(bArr, i2, 2);
    }

    static l2 f(byte[] bArr) {
        return new l2(i.b.ha.a.d.b.a(bArr));
    }

    public static void g(int i2, byte[] bArr, int i3) {
        i.b.ha.a.b.f.e.c(bArr, i2, i3, 2);
    }

    public byte[] a() {
        byte[] bArr = new byte[2];
        i.b.ha.a.b.f.e.c(bArr, this.c, 0, 2);
        return bArr;
    }

    public int c() {
        return this.c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof l2) && this.c == ((l2) obj).c();
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return "ZipShort value: " + this.c;
    }

    public l2(int i2) {
        this.c = i2;
    }
}
