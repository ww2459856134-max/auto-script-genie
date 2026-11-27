package i.f.a.y;

import com.auto.exceldeps.log4j.util.Chars;
import i.f.a.r;
import java.util.Arrays;
import java.util.Map;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class d extends k {
    private static final char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    static final int[] d;
    static final int e;
    private final StringBuilder a = new StringBuilder(20);
    private final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        d = iArr;
        e = iArr[47];
    }

    private static void h(CharSequence charSequence) throws i.f.a.d {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    private static void i(CharSequence charSequence, int i2, int i3) throws i.f.a.d {
        int iIndexOf = 0;
        int i4 = 1;
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i2) != c[iIndexOf % 47]) {
            throw i.f.a.d.a();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String j(CharSequence charSequence) throws i.f.a.g {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt < 'a' || cCharAt > 'd') {
                sb.append(cCharAt);
            } else {
                if (i3 >= length - 1) {
                    throw i.f.a.g.a();
                }
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                            i2 = cCharAt2 - '@';
                            c2 = (char) i2;
                            sb.append(c2);
                            break;
                        } else {
                            throw i.f.a.g.a();
                        }
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i2 = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i2 = cCharAt2 - 11;
                        } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 + 16;
                        } else if (cCharAt2 < 'P' || cCharAt2 > 'T') {
                            if (cCharAt2 == 'U') {
                                c2 = 0;
                            } else if (cCharAt2 == 'V') {
                                c2 = '@';
                            } else if (cCharAt2 == 'W') {
                                c2 = '`';
                            } else {
                                if (cCharAt2 < 'X' || cCharAt2 > 'Z') {
                                    throw i.f.a.g.a();
                                }
                                c2 = 127;
                            }
                            sb.append(c2);
                            break;
                        } else {
                            i2 = cCharAt2 + '+';
                        }
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 - ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw i.f.a.g.a();
                            }
                            c2 = NameUtil.COLON;
                            sb.append(c2);
                            break;
                        }
                    case 'd':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                            i2 = cCharAt2 + Chars.SPACE;
                            c2 = (char) i2;
                            sb.append(c2);
                            break;
                        } else {
                            throw i.f.a.g.a();
                        }
                }
            }
            i3++;
        }
        return sb.toString();
    }

    private int[] k(i.f.a.v.a aVar) throws i.f.a.k {
        int iK = aVar.k();
        int i2 = aVar.i(0);
        Arrays.fill(this.b, 0);
        int[] iArr = this.b;
        int length = iArr.length;
        boolean z = false;
        int i3 = 0;
        int i4 = i2;
        while (i2 < iK) {
            if (aVar.g(i2) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (m(iArr) == e) {
                        return new int[]{i4, i2};
                    }
                    i4 += iArr[0] + iArr[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            i2++;
        }
        throw i.f.a.k.a();
    }

    private static char l(int i2) throws i.f.a.k {
        int i3 = 0;
        while (true) {
            int[] iArr = d;
            if (i3 >= iArr.length) {
                throw i.f.a.k.a();
            }
            if (iArr[i3] == i2) {
                return c[i3];
            }
            i3++;
        }
    }

    private static int m(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int iRound = Math.round((iArr[i5] * 9.0f) / i2);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                for (int i6 = 0; i6 < iRound; i6++) {
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= iRound;
            }
        }
        return i4;
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        int i3 = aVar.i(k(aVar)[1]);
        int iK = aVar.k();
        int[] iArr = this.b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.a;
        sb.setLength(0);
        while (true) {
            k.f(aVar, i3, iArr);
            int iM = m(iArr);
            if (iM < 0) {
                throw i.f.a.k.a();
            }
            char cL = l(iM);
            sb.append(cL);
            int i4 = i3;
            for (int i5 : iArr) {
                i4 += i5;
            }
            int i6 = aVar.i(i4);
            if (cL == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i7 = 0;
                for (int i8 : iArr) {
                    i7 += i8;
                }
                if (i6 == iK || !aVar.g(i6)) {
                    throw i.f.a.k.a();
                }
                if (sb.length() < 2) {
                    throw i.f.a.k.a();
                }
                h(sb);
                sb.setLength(sb.length() - 2);
                float f = i2;
                return new i.f.a.p(j(sb), null, new r[]{new r((r14[1] + r14[0]) / 2.0f, f), new r(i3 + (i7 / 2.0f), f)}, i.f.a.a.CODE_93);
            }
            i3 = i6;
        }
    }
}
