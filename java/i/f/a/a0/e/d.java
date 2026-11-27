package i.f.a.a0.e;

import i.f.a.a0.c.o;
import i.f.a.a0.c.q;
import i.f.a.a0.c.u;
import i.f.a.t;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    static void a(String str, i.f.a.v.a aVar, String str2) throws t, UnsupportedEncodingException {
        try {
            for (byte b : str.getBytes(str2)) {
                aVar.c(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new t(e);
        }
    }

    static void b(CharSequence charSequence, i.f.a.v.a aVar) throws t {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iP = p(charSequence.charAt(i2));
            if (iP == -1) {
                throw new t();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int iP2 = p(charSequence.charAt(i3));
                if (iP2 == -1) {
                    throw new t();
                }
                aVar.c((iP * 45) + iP2, 11);
                i2 += 2;
            } else {
                aVar.c(iP, 6);
                i2 = i3;
            }
        }
    }

    static void c(String str, q qVar, i.f.a.v.a aVar, String str2) throws t, UnsupportedEncodingException {
        int i2 = c.a[qVar.ordinal()];
        if (i2 == 1) {
            h(str, aVar);
            return;
        }
        if (i2 == 2) {
            b(str, aVar);
        } else if (i2 == 3) {
            a(str, aVar, str2);
        } else {
            if (i2 != 4) {
                throw new t("Invalid mode: ".concat(String.valueOf(qVar)));
            }
            e(str, aVar);
        }
    }

    private static void d(i.f.a.v.d dVar, i.f.a.v.a aVar) {
        aVar.c(q.ECI.b(), 4);
        aVar.c(dVar.c(), 8);
    }

    static void e(String str, i.f.a.v.a aVar) throws t, UnsupportedEncodingException {
        int i2;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            if (bytes.length % 2 != 0) {
                throw new t("Kanji byte size not even");
            }
            int length = bytes.length - 1;
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i4 = ((bytes[i3] & 255) << 8) | (bytes[i3 + 1] & 255);
                int i5 = 33088;
                if (i4 >= 33088 && i4 <= 40956) {
                    i2 = i4 - i5;
                } else if (i4 < 57408 || i4 > 60351) {
                    i2 = -1;
                } else {
                    i5 = 49472;
                    i2 = i4 - i5;
                }
                if (i2 == -1) {
                    throw new t("Invalid byte sequence");
                }
                aVar.c(((i2 >> 8) * 192) + (i2 & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new t(e);
        }
    }

    static void f(int i2, u uVar, q qVar, i.f.a.v.a aVar) throws t {
        int iC = qVar.c(uVar);
        int i3 = 1 << iC;
        if (i2 < i3) {
            aVar.c(i2, iC);
            return;
        }
        throw new t(i2 + " is bigger than " + (i3 - 1));
    }

    static void g(q qVar, i.f.a.v.a aVar) {
        aVar.c(qVar.b(), 4);
    }

    static void h(CharSequence charSequence, i.f.a.v.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iCharAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.c((iCharAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.c((iCharAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.c(iCharAt, 4);
                }
            }
        }
    }

    private static int i(q qVar, i.f.a.v.a aVar, i.f.a.v.a aVar2, u uVar) {
        return aVar.k() + qVar.c(uVar) + aVar2.k();
    }

    private static int j(b bVar) {
        return e.a(bVar) + e.c(bVar) + e.d(bVar) + e.e(bVar);
    }

    private static int k(i.f.a.v.a aVar, o oVar, u uVar, b bVar) throws t {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            f.a(aVar, oVar, uVar, i4, bVar);
            int iJ = j(bVar);
            if (iJ < i2) {
                i3 = i4;
                i2 = iJ;
            }
        }
        return i3;
    }

    private static q l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return q.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return q.BYTE;
                }
                z = true;
            }
        }
        return z ? q.ALPHANUMERIC : z2 ? q.NUMERIC : q.BYTE;
    }

    private static u m(int i2, o oVar) throws t {
        for (int i3 = 1; i3 <= 40; i3++) {
            u uVarI = u.i(i3);
            if (v(i2, uVarI, oVar)) {
                return uVarI;
            }
        }
        throw new t("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static g n(String str, o oVar, Map<i.f.a.f, ?> map) throws t, NumberFormatException, UnsupportedEncodingException {
        u uVarT;
        int iK;
        i.f.a.v.d dVarA;
        boolean z = map != null && map.containsKey(i.f.a.f.CHARACTER_SET);
        String string = z ? map.get(i.f.a.f.CHARACTER_SET).toString() : "ISO-8859-1";
        q qVarL = l(str, string);
        i.f.a.v.a aVar = new i.f.a.v.a();
        q qVar = q.BYTE;
        if (qVarL == qVar && z && (dVarA = i.f.a.v.d.a(string)) != null) {
            d(dVarA, aVar);
        }
        if ((map != null && map.containsKey(i.f.a.f.GS1_FORMAT)) && Boolean.parseBoolean(map.get(i.f.a.f.GS1_FORMAT).toString())) {
            g(q.FNC1_FIRST_POSITION, aVar);
        }
        g(qVarL, aVar);
        i.f.a.v.a aVar2 = new i.f.a.v.a();
        c(str, qVarL, aVar2, string);
        if (map != null) {
            i.f.a.f fVar = i.f.a.f.QR_VERSION;
            if (map.containsKey(fVar)) {
                uVarT = u.i(Integer.parseInt(map.get(fVar).toString()));
                if (!v(i(qVarL, aVar, aVar2, uVarT), uVarT, oVar)) {
                    throw new t("Data too big for requested version");
                }
            } else {
                uVarT = t(oVar, qVarL, aVar, aVar2);
            }
        }
        i.f.a.v.a aVar3 = new i.f.a.v.a();
        aVar3.b(aVar);
        f(qVarL == qVar ? aVar2.l() : str.length(), uVarT, qVarL, aVar3);
        aVar3.b(aVar2);
        i.f.a.a0.c.t tVarF = uVarT.f(oVar);
        int iH = uVarT.h() - tVarF.d();
        u(iH, aVar3);
        i.f.a.v.a aVarR = r(aVar3, uVarT.h(), iH, tVarF.c());
        g gVar = new g();
        gVar.c(oVar);
        gVar.f(qVarL);
        gVar.g(uVarT);
        int iE = uVarT.e();
        b bVar = new b(iE, iE);
        if (map != null) {
            i.f.a.f fVar2 = i.f.a.f.QR_MASK_PATTERN;
            if (map.containsKey(fVar2)) {
                iK = Integer.parseInt(map.get(fVar2).toString());
                if (!g.b(iK)) {
                    iK = -1;
                }
            }
        }
        if (iK == -1) {
            iK = k(aVarR, oVar, uVarT, bVar);
        }
        gVar.d(iK);
        f.a(aVarR, oVar, uVarT, iK, bVar);
        gVar.e(bVar);
        return gVar;
    }

    static byte[] o(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new i.f.a.v.n.d(i.f.a.v.n.a.f1691l).b(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static int p(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    static void q(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws t {
        if (i5 >= i4) {
            throw new t("Block ID too large");
        }
        int i6 = i2 % i4;
        int i7 = i4 - i6;
        int i8 = i2 / i4;
        int i9 = i8 + 1;
        int i10 = i3 / i4;
        int i11 = i10 + 1;
        int i12 = i8 - i10;
        int i13 = i9 - i11;
        if (i12 != i13) {
            throw new t("EC bytes mismatch");
        }
        if (i4 != i7 + i6) {
            throw new t("RS blocks mismatch");
        }
        if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
            throw new t("Total bytes mismatch");
        }
        if (i5 < i7) {
            iArr[0] = i10;
            iArr2[0] = i12;
        } else {
            iArr[0] = i11;
            iArr2[0] = i13;
        }
    }

    static i.f.a.v.a r(i.f.a.v.a aVar, int i2, int i3, int i4) throws t {
        if (aVar.l() != i3) {
            throw new t("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i4);
        int i5 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            q(i2, i3, i4, i6, iArr, iArr2);
            int i7 = iArr[0];
            byte[] bArr = new byte[i7];
            aVar.r(i5 << 3, bArr, 0, i7);
            byte[] bArrO = o(bArr, iArr2[0]);
            arrayList.add(new a(bArr, bArrO));
            iMax = Math.max(iMax, i7);
            iMax2 = Math.max(iMax2, bArrO.length);
            i5 += iArr[0];
        }
        if (i3 != i5) {
            throw new t("Data bytes does not match offset");
        }
        i.f.a.v.a aVar2 = new i.f.a.v.a();
        for (int i8 = 0; i8 < iMax; i8++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((a) it.next()).a();
                if (i8 < bArrA.length) {
                    aVar2.c(bArrA[i8], 8);
                }
            }
        }
        for (int i9 = 0; i9 < iMax2; i9++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((a) it2.next()).b();
                if (i9 < bArrB.length) {
                    aVar2.c(bArrB[i9], 8);
                }
            }
        }
        if (i2 == aVar2.l()) {
            return aVar2;
        }
        throw new t("Interleaving error: " + i2 + " and " + aVar2.l() + " differ.");
    }

    private static boolean s(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static u t(o oVar, q qVar, i.f.a.v.a aVar, i.f.a.v.a aVar2) throws t {
        return m(i(qVar, aVar, aVar2, m(i(qVar, aVar, aVar2, u.i(1)), oVar)), oVar);
    }

    static void u(int i2, i.f.a.v.a aVar) throws t {
        int i3 = i2 << 3;
        if (aVar.k() > i3) {
            throw new t("data bits cannot fit in the QR Code" + aVar.k() + " > " + i3);
        }
        for (int i4 = 0; i4 < 4 && aVar.k() < i3; i4++) {
            aVar.a(false);
        }
        int iK = aVar.k() & 7;
        if (iK > 0) {
            while (iK < 8) {
                aVar.a(false);
                iK++;
            }
        }
        int iL = i2 - aVar.l();
        for (int i5 = 0; i5 < iL; i5++) {
            aVar.c((i5 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.k() != i3) {
            throw new t("Bits size does not equal capacity");
        }
    }

    private static boolean v(int i2, u uVar, o oVar) {
        return uVar.h() - uVar.f(oVar).d() >= (i2 + 7) / 8;
    }
}
