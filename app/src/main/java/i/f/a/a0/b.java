package i.f.a.a0;

import i.f.a.a0.c.o;
import i.f.a.a0.e.d;
import i.f.a.a0.e.g;
import i.f.a.f;
import i.f.a.t;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {
    private static i.f.a.v.b b(g gVar, int i2, int i3, int i4) {
        i.f.a.a0.e.b bVarA = gVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int iE = bVarA.e();
        int iD = bVarA.d();
        int i5 = i4 << 1;
        int i6 = iE + i5;
        int i7 = i5 + iD;
        int iMax = Math.max(i2, i6);
        int iMax2 = Math.max(i3, i7);
        int iMin = Math.min(iMax / i6, iMax2 / i7);
        int i8 = (iMax - (iE * iMin)) / 2;
        int i9 = (iMax2 - (iD * iMin)) / 2;
        i.f.a.v.b bVar = new i.f.a.v.b(iMax, iMax2);
        int i10 = 0;
        while (i10 < iD) {
            int i11 = 0;
            int i12 = i8;
            while (i11 < iE) {
                if (bVarA.b(i11, i10) == 1) {
                    bVar.m(i12, i9, iMin, iMin);
                }
                i11++;
                i12 += iMin;
            }
            i10++;
            i9 += iMin;
        }
        return bVar;
    }

    public i.f.a.v.b a(String str, i.f.a.a aVar, int i2, int i3, Map<f, ?> map) throws NumberFormatException, t {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != i.f.a.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        o oVarValueOf = o.L;
        int i4 = 4;
        if (map != null) {
            f fVar = f.ERROR_CORRECTION;
            if (map.containsKey(fVar)) {
                oVarValueOf = o.valueOf(map.get(fVar).toString());
            }
            f fVar2 = f.MARGIN;
            if (map.containsKey(fVar2)) {
                i4 = Integer.parseInt(map.get(fVar2).toString());
            }
        }
        return b(d.n(str, oVarValueOf, map), i2, i3, i4);
    }
}
