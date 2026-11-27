package i.f.a.a0;

import i.f.a.c;
import i.f.a.d;
import i.f.a.e;
import i.f.a.g;
import i.f.a.k;
import i.f.a.n;
import i.f.a.p;
import i.f.a.q;
import i.f.a.r;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements n {
    private static final r[] b = new r[0];
    private final i.f.a.a0.c.n a = new i.f.a.a0.c.n();

    private static i.f.a.v.b c(i.f.a.v.b bVar) throws k {
        int[] iArrI = bVar.i();
        int[] iArrE = bVar.e();
        if (iArrI == null || iArrE == null) {
            throw k.a();
        }
        float fD = d(iArrI, bVar);
        int i2 = iArrI[1];
        int i3 = iArrE[1];
        int i4 = iArrI[0];
        int i5 = iArrE[0];
        if (i4 >= i5 || i2 >= i3) {
            throw k.a();
        }
        int i6 = i3 - i2;
        if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.j()) {
            throw k.a();
        }
        int iRound = Math.round(((i5 - i4) + 1) / fD);
        int iRound2 = Math.round((i6 + 1) / fD);
        if (iRound <= 0 || iRound2 <= 0) {
            throw k.a();
        }
        if (iRound2 != iRound) {
            throw k.a();
        }
        int i7 = (int) (fD / 2.0f);
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        int i10 = (((int) ((iRound - 1) * fD)) + i9) - i5;
        if (i10 > 0) {
            if (i10 > i7) {
                throw k.a();
            }
            i9 -= i10;
        }
        int i11 = (((int) ((iRound2 - 1) * fD)) + i8) - i3;
        if (i11 > 0) {
            if (i11 > i7) {
                throw k.a();
            }
            i8 -= i11;
        }
        i.f.a.v.b bVar2 = new i.f.a.v.b(iRound, iRound2);
        for (int i12 = 0; i12 < iRound2; i12++) {
            int i13 = ((int) (i12 * fD)) + i8;
            for (int i14 = 0; i14 < iRound; i14++) {
                if (bVar.d(((int) (i14 * fD)) + i9, i13)) {
                    bVar2.l(i14, i12);
                }
            }
        }
        return bVar2;
    }

    private static float d(int[] iArr, i.f.a.v.b bVar) throws k {
        int iG = bVar.g();
        int iJ = bVar.j();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < iJ && i3 < iG) {
            if (z != bVar.d(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 == iJ || i3 == iG) {
            throw k.a();
        }
        return (i2 - iArr[0]) / 7.0f;
    }

    @Override // i.f.a.n
    public final p a(c cVar, Map<e, ?> map) throws k, d, g {
        r[] rVarArrB;
        i.f.a.v.e eVarB;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            i.f.a.v.g gVarE = new i.f.a.a0.d.c(cVar.a()).e(map);
            i.f.a.v.e eVarB2 = this.a.b(gVarE.a(), map);
            rVarArrB = gVarE.b();
            eVarB = eVarB2;
        } else {
            eVarB = this.a.b(c(cVar.a()), map);
            rVarArrB = b;
        }
        if (eVarB.d() instanceof i.f.a.a0.c.r) {
            ((i.f.a.a0.c.r) eVarB.d()).a(rVarArrB);
        }
        p pVar = new p(eVarB.h(), eVarB.e(), rVarArrB, i.f.a.a.QR_CODE);
        List<byte[]> listA = eVarB.a();
        if (listA != null) {
            pVar.h(q.BYTE_SEGMENTS, listA);
        }
        String strB = eVarB.b();
        if (strB != null) {
            pVar.h(q.ERROR_CORRECTION_LEVEL, strB);
        }
        if (eVarB.i()) {
            pVar.h(q.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarB.g()));
            pVar.h(q.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarB.f()));
        }
        return pVar;
    }

    @Override // i.f.a.n
    public void b() {
    }
}
