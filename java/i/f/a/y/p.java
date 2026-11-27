package i.f.a.y;

import i.f.a.r;
import i.f.a.s;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class p extends k {
    static final int[] d = {1, 1, 1};
    static final int[] e = {1, 1, 1, 1, 1};
    static final int[][] f;
    static final int[][] g;
    private final StringBuilder a = new StringBuilder(20);
    private final o b = new o();
    private final g c = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f = iArr;
        int[][] iArr2 = new int[20][];
        g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            g[i2] = iArr4;
        }
    }

    protected p() {
    }

    static boolean i(CharSequence charSequence) throws i.f.a.g {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return r(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    static int j(i.f.a.v.a aVar, int[] iArr, int i2, int[][] iArr2) throws i.f.a.k {
        k.f(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float fE = k.e(iArr, iArr2[i4], 0.7f);
            if (fE < f2) {
                i3 = i4;
                f2 = fE;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw i.f.a.k.a();
    }

    static int[] n(i.f.a.v.a aVar, int i2, boolean z, int[] iArr) throws i.f.a.k {
        return o(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] o(i.f.a.v.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws i.f.a.k {
        int iK = aVar.k();
        int iJ = z ? aVar.j(i2) : aVar.i(i2);
        int length = iArr.length;
        boolean z2 = z;
        int i3 = 0;
        int i4 = iJ;
        while (iJ < iK) {
            if (aVar.g(iJ) != z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (k.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, iJ};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            iJ++;
        }
        throw i.f.a.k.a();
    }

    static int[] p(i.f.a.v.a aVar) throws i.f.a.k {
        int[] iArr = new int[d.length];
        int[] iArrO = null;
        boolean zM = false;
        int i2 = 0;
        while (!zM) {
            int[] iArr2 = d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i2, false, iArr2, iArr);
            int i3 = iArrO[0];
            int i4 = iArrO[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                zM = aVar.m(i5, i3, false);
            }
            i2 = i4;
        }
        return iArrO;
    }

    static int r(CharSequence charSequence) throws i.f.a.g {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw i.f.a.g.a();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int iCharAt2 = charSequence.charAt(i5) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw i.f.a.g.a();
            }
            i4 += iCharAt2;
        }
        return (1000 - i4) % 10;
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        return m(i2, aVar, p(aVar), map);
    }

    boolean h(String str) throws i.f.a.g {
        return i(str);
    }

    int[] k(i.f.a.v.a aVar, int i2) throws i.f.a.k {
        return n(aVar, i2, false, d);
    }

    protected abstract int l(i.f.a.v.a aVar, int[] iArr, StringBuilder sb) throws i.f.a.k;

    public i.f.a.p m(int i2, i.f.a.v.a aVar, int[] iArr, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        int length;
        String strC;
        s sVar = map == null ? null : (s) map.get(i.f.a.e.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (sVar != null) {
            sVar.a(new r((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int iL = l(aVar, iArr, sb);
        if (sVar != null) {
            sVar.a(new r(iL, i2));
        }
        int[] iArrK = k(aVar, iL);
        if (sVar != null) {
            sVar.a(new r((iArrK[0] + iArrK[1]) / 2.0f, i2));
        }
        int i3 = iArrK[1];
        int i4 = (i3 - iArrK[0]) + i3;
        if (i4 >= aVar.k() || !aVar.m(i3, i4, false)) {
            throw i.f.a.k.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw i.f.a.g.a();
        }
        if (!h(string)) {
            throw i.f.a.d.a();
        }
        i.f.a.a aVarQ = q();
        float f2 = i2;
        i.f.a.p pVar = new i.f.a.p(string, null, new r[]{new r((iArr[1] + iArr[0]) / 2.0f, f2), new r((iArrK[1] + iArrK[0]) / 2.0f, f2)}, aVarQ);
        try {
            i.f.a.p pVarA = this.b.a(i2, aVar, iArrK[1]);
            pVar.h(i.f.a.q.UPC_EAN_EXTENSION, pVarA.f());
            pVar.g(pVarA.d());
            pVar.a(pVarA.e());
            length = pVarA.f().length();
        } catch (i.f.a.o unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(i.f.a.e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    z = false;
                    break;
                }
                if (length == iArr2[i5]) {
                    break;
                }
                i5++;
            }
            if (!z) {
                throw i.f.a.k.a();
            }
        }
        if ((aVarQ == i.f.a.a.EAN_13 || aVarQ == i.f.a.a.UPC_A) && (strC = this.c.c(string)) != null) {
            pVar.h(i.f.a.q.POSSIBLE_COUNTRY, strC);
        }
        return pVar;
    }

    abstract i.f.a.a q();
}
