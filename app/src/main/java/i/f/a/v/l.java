package i.f.a.v;

import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class l {
    private static final String a;
    private static final boolean b;

    static {
        String strName = Charset.defaultCharset().name();
        a = strName;
        b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007e A[PHI: r10
      0x007e: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:32:0x0061, B:40:0x0079, B:27:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(byte[] bArr, Map<i.f.a.e, ?> map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            i.f.a.e eVar = i.f.a.e.CHARACTER_SET;
            if (map.containsKey(eVar)) {
                return map.get(eVar).toString();
            }
        }
        int length = bArr2.length;
        boolean z = true;
        int i2 = 0;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z3 = true;
        boolean z4 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z || z3 || z4)) {
            int i14 = bArr2[i4] & 255;
            if (z4) {
                if (i5 > 0) {
                    if ((i14 & 128) != 0) {
                        i5--;
                    } else {
                        z4 = false;
                    }
                } else if ((i14 & 128) != 0) {
                    if ((i14 & 64) != 0) {
                        i5++;
                        if ((i14 & 32) == 0) {
                            i7++;
                        } else {
                            i5++;
                            if ((i14 & 16) == 0) {
                                i8++;
                            } else {
                                i5++;
                                if ((i14 & 8) == 0) {
                                    i9++;
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                if (i14 > 127 && i14 < 160) {
                    z = false;
                } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                    i11++;
                }
            }
            if (z3) {
                if (i6 > 0) {
                    if (i14 < 64 || i14 == 127 || i14 > 252) {
                        z3 = false;
                    } else {
                        i6--;
                    }
                } else if (i14 != 128 && i14 != 160 && i14 <= 239) {
                    if (i14 <= 160 || i14 >= 224) {
                        if (i14 > 127) {
                            i6++;
                            int i15 = i12 + 1;
                            if (i15 > i2) {
                                i2 = i15;
                                i12 = i2;
                            } else {
                                i12 = i15;
                            }
                        } else {
                            i12 = 0;
                        }
                        i13 = 0;
                    } else {
                        i3++;
                        int i16 = i13 + 1;
                        if (i16 > i10) {
                            i10 = i16;
                            i13 = i10;
                        } else {
                            i13 = i16;
                        }
                        i12 = 0;
                    }
                }
            }
            i4++;
            bArr2 = bArr;
        }
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        return (!z4 || (!z2 && (i7 + i8) + i9 <= 0)) ? (!z3 || (!b && i10 < 3 && i2 < 3)) ? (z && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < length) ? "ISO8859_1" : "SJIS" : z ? "ISO8859_1" : z3 ? "SJIS" : z4 ? "UTF8" : a : "SJIS" : "UTF8";
    }
}
