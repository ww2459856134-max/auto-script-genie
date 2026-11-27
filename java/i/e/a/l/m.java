package i.e.a.l;

/* loaded from: classes.dex */
final class m {
    final char[] a;
    final int b;
    final int c;

    public m(char[] cArr, int i2) {
        this.a = cArr;
        this.b = i2;
        this.c = a(cArr, i2);
    }

    public static int a(char[] cArr, int i2) {
        int i3 = 1;
        if (i2 <= 8) {
            int i4 = cArr[0];
            while (i3 < i2) {
                int i5 = (i4 * 31) + cArr[i3];
                i3++;
                i4 = i5;
            }
            return i4;
        }
        int i6 = cArr[0] ^ i2;
        int i7 = i2 - 4;
        int i8 = 2;
        int i9 = 2;
        while (i8 < i7) {
            i6 = (i6 * 31) + cArr[i8];
            i8 += i9;
            i9++;
        }
        return cArr[i7 + 3] ^ ((((i6 * 31) ^ ((cArr[i7] << 2) + cArr[i7 + 1])) * 31) + (cArr[i7 + 2] << 2));
    }

    public m b() {
        int i2 = this.b;
        char[] cArr = new char[i2];
        System.arraycopy(this.a, 0, cArr, 0, i2);
        return new m(cArr, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != m.class) {
            return false;
        }
        m mVar = (m) obj;
        int i2 = mVar.b;
        int i3 = this.b;
        if (i2 != i3) {
            return false;
        }
        char[] cArr = this.a;
        char[] cArr2 = mVar.a;
        for (int i4 = 0; i4 < i3; i4++) {
            if (cArr[i4] != cArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return "{URI, hash: 0x" + Integer.toHexString(this.c) + "}";
    }

    public m(char[] cArr, int i2, int i3) {
        this.a = cArr;
        this.b = i2;
        this.c = i3;
    }
}
