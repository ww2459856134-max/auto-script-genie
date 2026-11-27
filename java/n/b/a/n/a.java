package n.b.a.n;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a {
    private final int[] a;
    private final char[] b;
    private final byte[] c;
    final String d;
    final boolean e;
    final char f;

    public a(String str, String str2, boolean z, char c, int i2) {
        int[] iArr = new int[128];
        this.a = iArr;
        char[] cArr = new char[64];
        this.b = cArr;
        this.c = new byte[64];
        this.d = str;
        this.e = z;
        this.f = c;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < length; i3++) {
            char c2 = this.b[i3];
            this.c[i3] = (byte) c2;
            this.a[c2] = i3;
        }
        if (z) {
            this.a[c] = -2;
        }
    }

    public int a(char c) {
        if (c <= 127) {
            return this.a[c];
        }
        return -1;
    }

    public char b() {
        return this.f;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d(char c) {
        return c == this.f;
    }

    public String toString() {
        return this.d;
    }

    public a(a aVar, String str, int i2) {
        this(aVar, str, aVar.e, aVar.f, i2);
    }

    public a(a aVar, String str, boolean z, char c, int i2) {
        int[] iArr = new int[128];
        this.a = iArr;
        char[] cArr = new char[64];
        this.b = cArr;
        byte[] bArr = new byte[64];
        this.c = bArr;
        this.d = str;
        byte[] bArr2 = aVar.c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = aVar.b;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = aVar.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.e = z;
        this.f = c;
    }
}
