package i.f.a.y;

import i.f.a.r;
import java.util.EnumMap;
import java.util.Map;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class n {
    private static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    n() {
    }

    private int a(i.f.a.v.a aVar, int[] iArr, StringBuilder sb) throws i.f.a.k {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int iJ = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && iJ < iK; i3++) {
            int iJ2 = p.j(aVar, iArr2, iJ, p.g);
            sb.append((char) ((iJ2 % 10) + 48));
            for (int i4 : iArr2) {
                iJ += i4;
            }
            if (iJ2 >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                iJ = aVar.j(aVar.i(iJ));
            }
        }
        if (sb.length() != 5) {
            throw i.f.a.k.a();
        }
        if (d(sb.toString()) == c(i2)) {
            return iJ;
        }
        throw i.f.a.k.a();
    }

    private static int c(int i2) throws i.f.a.k {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == c[i3]) {
                return i3;
            }
        }
        throw i.f.a.k.a();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            iCharAt += charSequence.charAt(i2) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            iCharAt2 += charSequence.charAt(i3) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String e(String str) throws NumberFormatException {
        char c2 = 0;
        char cCharAt = str.charAt(0);
        String str2 = "";
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt == '5') {
            str2 = "$";
        } else if (cCharAt == '9') {
            str.hashCode();
            switch (str.hashCode()) {
                case 54118329:
                    if (!str.equals("90000")) {
                        c2 = 65535;
                        break;
                    }
                    break;
                case 54395376:
                    if (str.equals("99990")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 54395377:
                    if (str.equals("99991")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return null;
                case 1:
                    return "Used";
                case 2:
                    return "0.00";
            }
        }
        int i2 = Integer.parseInt(str.substring(1));
        String strValueOf = String.valueOf(i2 / 100);
        int i3 = i2 % 100;
        return str2 + strValueOf + NameUtil.PERIOD + (i3 < 10 ? "0".concat(String.valueOf(i3)) : String.valueOf(i3));
    }

    private static Map<i.f.a.q, Object> f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(i.f.a.q.class);
        enumMap.put((EnumMap) i.f.a.q.SUGGESTED_PRICE, (i.f.a.q) strE);
        return enumMap;
    }

    i.f.a.p b(int i2, i.f.a.v.a aVar, int[] iArr) throws i.f.a.k {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<i.f.a.q, Object> mapF = f(string);
        float f = i2;
        i.f.a.p pVar = new i.f.a.p(string, null, new r[]{new r((iArr[0] + iArr[1]) / 2.0f, f), new r(iA, f)}, i.f.a.a.UPC_EAN_EXTENSION);
        if (mapF != null) {
            pVar.g(mapF);
        }
        return pVar;
    }
}
