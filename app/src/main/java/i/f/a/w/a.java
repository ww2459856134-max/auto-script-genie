package i.f.a.w;

import i.f.a.c;
import i.f.a.d;
import i.f.a.e;
import i.f.a.g;
import i.f.a.k;
import i.f.a.n;
import i.f.a.p;
import i.f.a.q;
import i.f.a.r;
import i.f.a.v.b;
import i.f.a.w.b.f;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements n {
    private static final r[] b = new r[0];
    private final f a = new f();

    private static b c(b bVar) throws k {
        int[] iArrI = bVar.i();
        int[] iArrE = bVar.e();
        if (iArrI == null || iArrE == null) {
            throw k.a();
        }
        int iD = d(iArrI, bVar);
        int i2 = iArrI[1];
        int i3 = iArrE[1];
        int i4 = iArrI[0];
        int i5 = ((iArrE[0] - i4) + 1) / iD;
        int i6 = ((i3 - i2) + 1) / iD;
        if (i5 <= 0 || i6 <= 0) {
            throw k.a();
        }
        int i7 = iD / 2;
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        b bVar2 = new b(i5, i6);
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = (i10 * iD) + i8;
            for (int i12 = 0; i12 < i5; i12++) {
                if (bVar.d((i12 * iD) + i9, i11)) {
                    bVar2.l(i12, i10);
                }
            }
        }
        return bVar2;
    }

    private static int d(int[] iArr, b bVar) throws k {
        int iJ = bVar.j();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < iJ && bVar.d(i2, i3)) {
            i2++;
        }
        if (i2 == iJ) {
            throw k.a();
        }
        int i4 = i2 - iArr[0];
        if (i4 != 0) {
            return i4;
        }
        throw k.a();
    }

    @Override // i.f.a.n
    public p a(c cVar, Map<e, ?> map) throws k, d, g {
        r[] rVarArrB;
        i.f.a.v.e eVarB;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            i.f.a.v.g gVarB = new i.f.a.w.c.a(cVar.a()).b();
            i.f.a.v.e eVarB2 = this.a.b(gVarB.a());
            rVarArrB = gVarB.b();
            eVarB = eVarB2;
        } else {
            eVarB = this.a.b(c(cVar.a()));
            rVarArrB = b;
        }
        p pVar = new p(eVarB.h(), eVarB.e(), rVarArrB, i.f.a.a.DATA_MATRIX);
        List<byte[]> listA = eVarB.a();
        if (listA != null) {
            pVar.h(q.BYTE_SEGMENTS, listA);
        }
        String strB = eVarB.b();
        if (strB != null) {
            pVar.h(q.ERROR_CORRECTION_LEVEL, strB);
        }
        return pVar;
    }

    @Override // i.f.a.n
    public void b() {
    }
}
