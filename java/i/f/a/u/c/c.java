package i.f.a.u.c;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.connect.common.Constants;
import i.f.a.g;
import i.f.a.v.n.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {
    private static final String[] b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", ProcessIdUtil.DEFAULT_PROCESSID, ".", "/", ParameterizedMessage.ERROR_MSG_SEPARATOR, ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, ",", ".", "CTRL_UL", "CTRL_US"};
    private i.f.a.u.a a;

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = h(zArr, i2 << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws g {
        i.f.a.v.n.a aVar;
        int i2 = 8;
        if (this.a.d() <= 2) {
            i2 = 6;
            aVar = i.f.a.v.n.a.f1689j;
        } else if (this.a.d() <= 8) {
            aVar = i.f.a.v.n.a.f1693n;
        } else if (this.a.d() <= 22) {
            i2 = 10;
            aVar = i.f.a.v.n.a.f1688i;
        } else {
            i2 = 12;
            aVar = i.f.a.v.n.a.f1687h;
        }
        int iC = this.a.c();
        int length = zArr.length / i2;
        if (length < iC) {
            throw g.a();
        }
        int length2 = zArr.length % i2;
        int[] iArr = new int[length];
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = i(zArr, length2, i2);
            i3++;
            length2 += i2;
        }
        try {
            new i.f.a.v.n.c(aVar).a(iArr, length - iC);
            int i4 = (1 << i2) - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < iC; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw g.a();
                }
                if (i7 == 1 || i7 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i2) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < iC; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i4 - 1) {
                    Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                    i8 += i2 - 1;
                } else {
                    int i11 = i2 - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (e e2) {
            throw g.b(e2);
        }
    }

    private boolean[] d(i.f.a.v.b bVar) {
        boolean zE = this.a.e();
        int iD = this.a.d();
        int i2 = (zE ? 11 : 14) + (iD << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[j(iD, zE)];
        int i3 = 2;
        if (zE) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                iArr[(i5 - i7) - 1] = (i6 - r12) - 1;
                iArr[i5 + i7] = (i7 / 15) + i7 + i6 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iD) {
            int i10 = ((iD - i8) << i3) + (zE ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i2 - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                while (i15 < i3) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = bVar.d(iArr[i16], iArr[i17]);
                    int i18 = iArr[i17];
                    int i19 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = bVar.d(i18, iArr[i19]);
                    int i20 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = bVar.d(iArr[i19], iArr[i20]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = bVar.d(iArr[i20], iArr[i16]);
                    i15++;
                    iD = iD;
                    zE = zE;
                    i3 = 2;
                }
                i13++;
                i3 = 2;
            }
            i9 += i10 << 3;
            i8++;
            i3 = 2;
        }
        return zArr;
    }

    private static String e(b bVar, int i2) {
        int i3 = a.a[bVar.ordinal()];
        if (i3 == 1) {
            return b[i2];
        }
        if (i3 == 2) {
            return c[i2];
        }
        if (i3 == 3) {
            return d[i2];
        }
        if (i3 == 4) {
            return e[i2];
        }
        if (i3 == 5) {
            return f[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVarG = bVar;
        int i2 = 0;
        while (i2 < length) {
            if (bVar != b.BINARY) {
                int i3 = bVar == b.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int i4 = i(zArr, i2, i3);
                i2 += i3;
                String strE = e(bVar, i4);
                if (strE.startsWith("CTRL_")) {
                    bVarG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        bVarG = bVar;
                        bVar = bVarG;
                    }
                } else {
                    sb.append(strE);
                }
                bVar = bVarG;
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int i5 = i(zArr, i2, 5);
                i2 += 5;
                if (i5 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    i5 = i(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        break;
                    }
                    if (length - i2 < 8) {
                        i2 = length;
                        break;
                    }
                    sb.append((char) i(zArr, i2, 8));
                    i2 += 8;
                    i6++;
                }
                bVar = bVarG;
            }
        }
        return sb.toString();
    }

    private static b g(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? b.UPPER : b.MIXED : b.LOWER : b.PUNCT : b.DIGIT : b.BINARY;
    }

    private static byte h(boolean[] zArr, int i2) {
        int length = zArr.length - i2;
        return (byte) (length >= 8 ? i(zArr, i2, 8) : i(zArr, i2, length) << (8 - length));
    }

    private static int i(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    private static int j(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public i.f.a.v.e c(i.f.a.u.a aVar) throws g {
        this.a = aVar;
        boolean[] zArrB = b(d(aVar.a()));
        i.f.a.v.e eVar = new i.f.a.v.e(a(zArrB), f(zArrB), null, null);
        eVar.l(zArrB.length);
        return eVar;
    }
}
