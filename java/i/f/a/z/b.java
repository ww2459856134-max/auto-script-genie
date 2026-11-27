package i.f.a.z;

import i.f.a.d;
import i.f.a.e;
import i.f.a.g;
import i.f.a.k;
import i.f.a.n;
import i.f.a.p;
import i.f.a.q;
import i.f.a.r;
import i.f.a.z.d.l;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements n {
    private static final p[] a = new p[0];

    private static p[] c(i.f.a.c cVar, Map<e, ?> map, boolean z) throws k, d, g {
        ArrayList arrayList = new ArrayList();
        i.f.a.z.e.b bVarB = i.f.a.z.e.a.b(cVar, map, z);
        for (r[] rVarArr : bVarB.b()) {
            i.f.a.v.e eVarI = l.i(bVarB.a(), rVarArr[4], rVarArr[5], rVarArr[6], rVarArr[7], f(rVarArr), d(rVarArr));
            p pVar = new p(eVarI.h(), eVarI.e(), rVarArr, i.f.a.a.PDF_417);
            pVar.h(q.ERROR_CORRECTION_LEVEL, eVarI.b());
            c cVar2 = (c) eVarI.d();
            if (cVar2 != null) {
                pVar.h(q.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(pVar);
        }
        return (p[]) arrayList.toArray(a);
    }

    private static int d(r[] rVarArr) {
        return Math.max(Math.max(e(rVarArr[0], rVarArr[4]), (e(rVarArr[6], rVarArr[2]) * 17) / 18), Math.max(e(rVarArr[1], rVarArr[5]), (e(rVarArr[7], rVarArr[3]) * 17) / 18));
    }

    private static int e(r rVar, r rVar2) {
        if (rVar == null || rVar2 == null) {
            return 0;
        }
        return (int) Math.abs(rVar.c() - rVar2.c());
    }

    private static int f(r[] rVarArr) {
        return Math.min(Math.min(g(rVarArr[0], rVarArr[4]), (g(rVarArr[6], rVarArr[2]) * 17) / 18), Math.min(g(rVarArr[1], rVarArr[5]), (g(rVarArr[7], rVarArr[3]) * 17) / 18));
    }

    private static int g(r rVar, r rVar2) {
        if (rVar == null || rVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(rVar.c() - rVar2.c());
    }

    @Override // i.f.a.n
    public p a(i.f.a.c cVar, Map<e, ?> map) throws k, d, g {
        p[] pVarArrC = c(cVar, map, false);
        if (pVarArrC.length == 0 || pVarArrC[0] == null) {
            throw k.a();
        }
        return pVarArrC[0];
    }

    @Override // i.f.a.n
    public void b() {
    }
}
