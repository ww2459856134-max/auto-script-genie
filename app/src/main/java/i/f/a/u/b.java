package i.f.a.u;

import i.f.a.c;
import i.f.a.e;
import i.f.a.g;
import i.f.a.k;
import i.f.a.n;
import i.f.a.p;
import i.f.a.q;
import i.f.a.r;
import i.f.a.s;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements n {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e A[LOOP:0: B:33:0x005c->B:34:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    @Override // i.f.a.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p a(c cVar, Map<e, ?> map) throws k, g {
        r[] rVarArrB;
        r[] rVarArrB2;
        g gVar;
        r[] rVarArr;
        List<byte[]> listA;
        String strB;
        s sVar;
        a aVarA;
        i.f.a.u.d.b bVar = new i.f.a.u.d.b(cVar.a());
        i.f.a.v.e eVarC = null;
        try {
            aVarA = bVar.a(false);
            rVarArrB = aVarA.b();
        } catch (g e) {
            e = e;
            rVarArrB = null;
        } catch (k e2) {
            e = e2;
            rVarArrB = null;
        }
        try {
            rVarArrB2 = rVarArrB;
            gVar = null;
            eVarC = new i.f.a.u.c.c().c(aVarA);
            e = null;
        } catch (g e3) {
            e = e3;
            rVarArrB2 = rVarArrB;
            gVar = e;
            e = null;
            if (eVarC == null) {
            }
            rVarArr = rVarArrB2;
            if (map != null) {
                while (i < r0) {
                }
            }
            p pVar = new p(eVarC.h(), eVarC.e(), eVarC.c(), rVarArr, i.f.a.a.AZTEC, System.currentTimeMillis());
            listA = eVarC.a();
            if (listA != null) {
            }
            strB = eVarC.b();
            if (strB != null) {
            }
            return pVar;
        } catch (k e4) {
            e = e4;
            rVarArrB2 = rVarArrB;
            gVar = null;
            if (eVarC == null) {
            }
            rVarArr = rVarArrB2;
            if (map != null) {
            }
            p pVar2 = new p(eVarC.h(), eVarC.e(), eVarC.c(), rVarArr, i.f.a.a.AZTEC, System.currentTimeMillis());
            listA = eVarC.a();
            if (listA != null) {
            }
            strB = eVarC.b();
            if (strB != null) {
            }
            return pVar2;
        }
        if (eVarC == null) {
            try {
                a aVarA2 = bVar.a(true);
                rVarArrB2 = aVarA2.b();
                eVarC = new i.f.a.u.c.c().c(aVarA2);
            } catch (g | k e5) {
                if (e != null) {
                    throw e;
                }
                if (gVar != null) {
                    throw gVar;
                }
                throw e5;
            }
        }
        rVarArr = rVarArrB2;
        if (map != null && (sVar = (s) map.get(e.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (r rVar : rVarArr) {
                sVar.a(rVar);
            }
        }
        p pVar22 = new p(eVarC.h(), eVarC.e(), eVarC.c(), rVarArr, i.f.a.a.AZTEC, System.currentTimeMillis());
        listA = eVarC.a();
        if (listA != null) {
            pVar22.h(q.BYTE_SEGMENTS, listA);
        }
        strB = eVarC.b();
        if (strB != null) {
            pVar22.h(q.ERROR_CORRECTION_LEVEL, strB);
        }
        return pVar22;
    }

    @Override // i.f.a.n
    public void b() {
    }
}
