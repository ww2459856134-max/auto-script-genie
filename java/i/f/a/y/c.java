package i.f.a.y;

import com.auto.exceldeps.log4j.util.Chars;
import i.f.a.r;
import java.util.Arrays;
import java.util.Map;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* loaded from: classes.dex */
public final class c extends k {
    static final int[] e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, STBorder.INT_CUSTOM, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};
    private final boolean a;
    private final boolean b;
    private final StringBuilder c;
    private final int[] d;

    public c() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String h(CharSequence charSequence) throws i.f.a.g {
        int i2;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i2 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw i.f.a.g.a();
                                }
                                c = NameUtil.COLON;
                            }
                            sb.append(c);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw i.f.a.g.a();
                            }
                            i2 = cCharAt2 + Chars.SPACE;
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i2 = cCharAt2 - '&';
                    } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                        i2 = cCharAt2 - 11;
                    } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                        i2 = cCharAt2 + 16;
                    } else if (cCharAt2 < 'P' || cCharAt2 > 'T') {
                        if (cCharAt2 != 'U') {
                            if (cCharAt2 == 'V') {
                                c = '@';
                            } else if (cCharAt2 == 'W') {
                                c = '`';
                            } else {
                                if (cCharAt2 != 'X' && cCharAt2 != 'Y' && cCharAt2 != 'Z') {
                                    throw i.f.a.g.a();
                                }
                                c = 127;
                            }
                        }
                        sb.append(c);
                    } else {
                        i2 = cCharAt2 + '+';
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw i.f.a.g.a();
                    }
                    i2 = cCharAt2 - '@';
                }
                c = (char) i2;
                sb.append(c);
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] i(i.f.a.v.a aVar, int[] iArr) throws i.f.a.k {
        int iK = aVar.k();
        int i2 = aVar.i(0);
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
                    if (k(iArr) == 148 && aVar.m(Math.max(0, i4 - ((i2 - i4) / 2)), i4, false)) {
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

    private static char j(int i2) throws i.f.a.k {
        int i3 = 0;
        while (true) {
            int[] iArr = e;
            if (i3 >= iArr.length) {
                if (i2 == 148) {
                    return '*';
                }
                throw i.f.a.k.a();
            }
            if (iArr[i3] == i2) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i3);
            }
            i3++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int i3 = aVar.i(i(aVar, iArr)[1]);
        int iK = aVar.k();
        while (true) {
            k.f(aVar, i3, iArr);
            int iK2 = k(iArr);
            if (iK2 < 0) {
                throw i.f.a.k.a();
            }
            char cJ = j(iK2);
            sb.append(cJ);
            int i4 = i3;
            for (int i5 : iArr) {
                i4 += i5;
            }
            int i6 = aVar.i(i4);
            if (cJ == '*') {
                sb.setLength(sb.length() - 1);
                int i7 = 0;
                for (int i8 : iArr) {
                    i7 += i8;
                }
                int i9 = (i6 - i3) - i7;
                if (i6 != iK && (i9 << 1) < i7) {
                    throw i.f.a.k.a();
                }
                if (this.a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i10 = 0; i10 < length; i10++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i10));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw i.f.a.d.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw i.f.a.k.a();
                }
                float f = i2;
                return new i.f.a.p(this.b ? h(sb) : sb.toString(), null, new r[]{new r((r2[1] + r2[0]) / 2.0f, f), new r(i3 + (i7 / 2.0f), f)}, i.f.a.a.CODE_39);
            }
            i3 = i6;
        }
    }

    public c(boolean z) {
        this(z, false);
    }

    public c(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = new StringBuilder(20);
        this.d = new int[9];
    }
}
