package n.b.a.m.o;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class e extends n.b.a.n.d {
    static final BigInteger b = BigInteger.valueOf(Long.MIN_VALUE);
    static final BigInteger c = BigInteger.valueOf(Long.MAX_VALUE);
    protected int a;

    protected e() {
    }

    protected static final int j(int i2, String str, int i3, int i4) {
        int iCharAt = (i2 * 10) + (str.charAt(i3) - '0');
        int i5 = i3 + 1;
        if (i5 >= i4) {
            return iCharAt;
        }
        int iCharAt2 = (iCharAt * 10) + (str.charAt(i5) - '0');
        int i6 = i5 + 1;
        if (i6 >= i4) {
            return iCharAt2;
        }
        int iCharAt3 = (iCharAt2 * 10) + (str.charAt(i6) - '0');
        int i7 = i6 + 1;
        if (i7 >= i4) {
            return iCharAt3;
        }
        int iCharAt4 = (iCharAt3 * 10) + (str.charAt(i7) - '0');
        int i8 = i7 + 1;
        if (i8 >= i4) {
            return iCharAt4;
        }
        int iCharAt5 = (iCharAt4 * 10) + (str.charAt(i8) - '0');
        int i9 = i8 + 1;
        if (i9 >= i4) {
            return iCharAt5;
        }
        int iCharAt6 = (iCharAt5 * 10) + (str.charAt(i9) - '0');
        int i10 = i9 + 1;
        if (i10 >= i4) {
            return iCharAt6;
        }
        int iCharAt7 = (iCharAt6 * 10) + (str.charAt(i10) - '0');
        return i10 + 1 < i4 ? (iCharAt7 * 10) + (str.charAt(r3) - '0') : iCharAt7;
    }

    protected static final int k(int i2, char[] cArr, int i3, int i4) {
        int i5 = (i2 * 10) + (cArr[i3] - '0');
        int i6 = i3 + 1;
        if (i6 >= i4) {
            return i5;
        }
        int i7 = (i5 * 10) + (cArr[i6] - '0');
        int i8 = i6 + 1;
        if (i8 >= i4) {
            return i7;
        }
        int i9 = (i7 * 10) + (cArr[i8] - '0');
        int i10 = i8 + 1;
        if (i10 >= i4) {
            return i9;
        }
        int i11 = (i9 * 10) + (cArr[i10] - '0');
        int i12 = i10 + 1;
        if (i12 >= i4) {
            return i11;
        }
        int i13 = (i11 * 10) + (cArr[i12] - '0');
        int i14 = i12 + 1;
        if (i14 >= i4) {
            return i13;
        }
        int i15 = (i13 * 10) + (cArr[i14] - '0');
        int i16 = i14 + 1;
        if (i16 >= i4) {
            return i15;
        }
        int i17 = (i15 * 10) + (cArr[i16] - '0');
        return i16 + 1 < i4 ? (i17 * 10) + (cArr[r3] - '0') : i17;
    }

    protected static final int l(String str, int i2, int i3) {
        int iCharAt = str.charAt(i2) - '0';
        int i4 = i2 + 1;
        if (i4 >= i3) {
            return iCharAt;
        }
        int iCharAt2 = (iCharAt * 10) + (str.charAt(i4) - '0');
        int i5 = i4 + 1;
        if (i5 >= i3) {
            return iCharAt2;
        }
        int iCharAt3 = (iCharAt2 * 10) + (str.charAt(i5) - '0');
        int i6 = i5 + 1;
        if (i6 >= i3) {
            return iCharAt3;
        }
        int iCharAt4 = (iCharAt3 * 10) + (str.charAt(i6) - '0');
        int i7 = i6 + 1;
        if (i7 >= i3) {
            return iCharAt4;
        }
        int iCharAt5 = (iCharAt4 * 10) + (str.charAt(i7) - '0');
        int i8 = i7 + 1;
        if (i8 >= i3) {
            return iCharAt5;
        }
        int iCharAt6 = (iCharAt5 * 10) + (str.charAt(i8) - '0');
        int i9 = i8 + 1;
        if (i9 >= i3) {
            return iCharAt6;
        }
        int iCharAt7 = (iCharAt6 * 10) + (str.charAt(i9) - '0');
        int i10 = i9 + 1;
        if (i10 >= i3) {
            return iCharAt7;
        }
        int iCharAt8 = (iCharAt7 * 10) + (str.charAt(i10) - '0');
        return i10 + 1 < i3 ? (iCharAt8 * 10) + (str.charAt(r3) - '0') : iCharAt8;
    }

    protected static final int m(char[] cArr, int i2, int i3) {
        int i4 = cArr[i2] - '0';
        int i5 = i2 + 1;
        if (i5 >= i3) {
            return i4;
        }
        int i6 = (i4 * 10) + (cArr[i5] - '0');
        int i7 = i5 + 1;
        if (i7 >= i3) {
            return i6;
        }
        int i8 = (i6 * 10) + (cArr[i7] - '0');
        int i9 = i7 + 1;
        if (i9 >= i3) {
            return i8;
        }
        int i10 = (i8 * 10) + (cArr[i9] - '0');
        int i11 = i9 + 1;
        if (i11 >= i3) {
            return i10;
        }
        int i12 = (i10 * 10) + (cArr[i11] - '0');
        int i13 = i11 + 1;
        if (i13 >= i3) {
            return i12;
        }
        int i14 = (i12 * 10) + (cArr[i13] - '0');
        int i15 = i13 + 1;
        if (i15 >= i3) {
            return i14;
        }
        int i16 = (i14 * 10) + (cArr[i15] - '0');
        int i17 = i15 + 1;
        if (i17 >= i3) {
            return i16;
        }
        int i18 = (i16 * 10) + (cArr[i17] - '0');
        return i17 + 1 < i3 ? (i18 * 10) + (cArr[r3] - '0') : i18;
    }

    protected static final long n(String str, int i2, int i3) {
        int i4 = i3 - 9;
        return (l(str, i2, i4) * 1000000000) + l(str, i4, i3);
    }

    protected static final long o(char[] cArr, int i2, int i3) {
        int i4 = i3 - 9;
        return (m(cArr, i2, i4) * 1000000000) + m(cArr, i4, i3);
    }

    @Override // n.b.a.n.d
    public void c() {
        throw new IllegalArgumentException("Empty value (all white space) not a valid lexical representation of " + g());
    }

    protected String d(String str) {
        return str.trim();
    }

    protected IllegalArgumentException e(String str) {
        return new IllegalArgumentException("Value \"" + str + "\" not a valid lexical representation of " + g());
    }

    protected IllegalArgumentException f(char[] cArr, int i2, int i3) {
        return new IllegalArgumentException("Value \"" + i(cArr, i2, i3) + "\" not a valid lexical representation of " + g());
    }

    public abstract String g();

    protected String h(String str) {
        return d(str);
    }

    protected String i(char[] cArr, int i2, int i3) {
        return d(new String(cArr, i2, i3 - i2));
    }

    protected int p(String str, char c2, boolean z, int i2) {
        int i3 = 1;
        if (z) {
            if (1 >= i2) {
                throw e(str);
            }
            i3 = 2;
            c2 = str.charAt(1);
        }
        int i4 = c2 - '0';
        if (i4 < 0 || i4 > 9) {
            throw e(str);
        }
        while (i4 == 0 && i3 < i2) {
            int iCharAt = str.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                break;
            }
            i3++;
            i4 = iCharAt;
        }
        this.a = i3;
        return i4;
    }

    protected int q(char[] cArr, char c2, boolean z, int i2, int i3) {
        int i4 = i2 + 1;
        if (z) {
            if (i4 >= i3) {
                throw f(cArr, i2, i3);
            }
            char c3 = cArr[i4];
            i4++;
            c2 = c3;
        }
        int i5 = c2 - '0';
        if (i5 < 0 || i5 > 9) {
            throw f(cArr, i2, i3);
        }
        while (i5 == 0 && i4 < i3) {
            int i6 = cArr[i4] - '0';
            if (i6 < 0 || i6 > 9) {
                break;
            }
            i4++;
            i5 = i6;
        }
        this.a = i4;
        return i5;
    }

    protected void r(String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt > '9' || cCharAt < '0') {
                throw e(str);
            }
            i2++;
        }
    }

    protected void s(char[] cArr, int i2, int i3, int i4) {
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 > '9' || c2 < '0') {
                throw f(cArr, i2, i3);
            }
            i4++;
        }
    }
}
