package i.f.a.y;

import i.f.a.r;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends k {
    private static final int[] b = {6, 8, 10, 12, 14};
    private static final int[] c = {1, 1, 1, 1};
    private static final int[][] d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int a = -1;

    private static int h(int[] iArr) throws i.f.a.k {
        int length = e.length;
        float f = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fE = k.e(iArr, e[i3], 0.5f);
            if (fE < f) {
                i2 = i3;
                f = fE;
            } else if (fE == f) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw i.f.a.k.a();
    }

    private int[] i(i.f.a.v.a aVar) throws i.f.a.k {
        int[] iArrL;
        aVar.o();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, d[0]);
            } catch (i.f.a.k unused) {
                iArrL = l(aVar, iM, d[1]);
            }
            n(aVar, iArrL[0]);
            int i2 = iArrL[0];
            iArrL[0] = aVar.k() - iArrL[1];
            iArrL[1] = aVar.k() - i2;
            return iArrL;
        } finally {
            aVar.o();
        }
    }

    private static void j(i.f.a.v.a aVar, int i2, int i3, StringBuilder sb) throws i.f.a.k {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            k.f(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] k(i.f.a.v.a aVar) throws i.f.a.k {
        int[] iArrL = l(aVar, m(aVar), c);
        this.a = (iArrL[1] - iArrL[0]) / 4;
        n(aVar, iArrL[0]);
        return iArrL;
    }

    private static int[] l(i.f.a.v.a aVar, int i2, int[] iArr) throws i.f.a.k {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iK = aVar.k();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < iK) {
            if (aVar.g(i2) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (k.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw i.f.a.k.a();
    }

    private static int m(i.f.a.v.a aVar) throws i.f.a.k {
        int iK = aVar.k();
        int i2 = aVar.i(0);
        if (i2 != iK) {
            return i2;
        }
        throw i.f.a.k.a();
    }

    private void n(i.f.a.v.a aVar, int i2) throws i.f.a.k {
        int iMin = Math.min(this.a * 10, i2);
        for (int i3 = i2 - 1; iMin > 0 && i3 >= 0 && !aVar.g(i3); i3--) {
            iMin--;
        }
        if (iMin != 0) {
            throw i.f.a.k.a();
        }
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.g {
        boolean z;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(i.f.a.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z && length > i4) {
            z = true;
        }
        if (!z) {
            throw i.f.a.g.a();
        }
        float f = i2;
        return new i.f.a.p(string, null, new r[]{new r(iArrK[1], f), new r(iArrI[0], f)}, i.f.a.a.ITF);
    }
}
