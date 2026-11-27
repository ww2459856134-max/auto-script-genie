package i.f.a.x;

import i.f.a.d;
import i.f.a.e;
import i.f.a.g;
import i.f.a.k;
import i.f.a.n;
import i.f.a.p;
import i.f.a.q;
import i.f.a.r;
import i.f.a.v.b;
import i.f.a.x.b.c;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements n {
    private static final r[] b = new r[0];
    private final c a = new c();

    private static b c(b bVar) throws k {
        int[] iArrF = bVar.f();
        if (iArrF == null) {
            throw k.a();
        }
        int i2 = iArrF[0];
        int i3 = iArrF[1];
        int i4 = iArrF[2];
        int i5 = iArrF[3];
        b bVar2 = new b(30, 33);
        for (int i6 = 0; i6 < 33; i6++) {
            int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
            for (int i8 = 0; i8 < 30; i8++) {
                if (bVar.d(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                    bVar2.l(i8, i6);
                }
            }
        }
        return bVar2;
    }

    @Override // i.f.a.n
    public p a(i.f.a.c cVar, Map<e, ?> map) throws k, d, g {
        i.f.a.v.e eVarB = this.a.b(c(cVar.a()), map);
        p pVar = new p(eVarB.h(), eVarB.e(), b, i.f.a.a.MAXICODE);
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
