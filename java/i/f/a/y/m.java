package i.f.a.y;

import i.f.a.r;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
final class m {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    m() {
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
        for (int i3 = 0; i3 < 2 && iJ < iK; i3++) {
            int iJ2 = p.j(aVar, iArr2, iJ, p.g);
            sb.append((char) ((iJ2 % 10) + 48));
            for (int i4 : iArr2) {
                iJ += i4;
            }
            if (iJ2 >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                iJ = aVar.j(aVar.i(iJ));
            }
        }
        if (sb.length() != 2) {
            throw i.f.a.k.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i2) {
            return iJ;
        }
        throw i.f.a.k.a();
    }

    private static Map<i.f.a.q, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(i.f.a.q.class);
        enumMap.put((EnumMap) i.f.a.q.ISSUE_NUMBER, (i.f.a.q) Integer.valueOf(str));
        return enumMap;
    }

    i.f.a.p b(int i2, i.f.a.v.a aVar, int[] iArr) throws i.f.a.k {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<i.f.a.q, Object> mapC = c(string);
        float f = i2;
        i.f.a.p pVar = new i.f.a.p(string, null, new r[]{new r((iArr[0] + iArr[1]) / 2.0f, f), new r(iA, f)}, i.f.a.a.UPC_EAN_EXTENSION);
        if (mapC != null) {
            pVar.g(mapC);
        }
        return pVar;
    }
}
