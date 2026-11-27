package i.f.a.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class j extends k {
    private static final p[] b = new p[0];
    private final p[] a;

    public j(Map<i.f.a.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(i.f.a.e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(i.f.a.a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(i.f.a.a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(i.f.a.a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(i.f.a.a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.a = (p[]) arrayList.toArray(b);
    }

    @Override // i.f.a.y.k, i.f.a.n
    public void b() {
        for (p pVar : this.a) {
            pVar.b();
        }
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k {
        int[] iArrP = p.p(aVar);
        for (p pVar : this.a) {
            try {
                i.f.a.p pVarM = pVar.m(i2, aVar, iArrP, map);
                boolean z = pVarM.b() == i.f.a.a.EAN_13 && pVarM.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(i.f.a.e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(i.f.a.a.UPC_A);
                if (!z || !z2) {
                    return pVarM;
                }
                i.f.a.p pVar2 = new i.f.a.p(pVarM.f().substring(1), pVarM.c(), pVarM.e(), i.f.a.a.UPC_A);
                pVar2.g(pVarM.d());
                return pVar2;
            } catch (i.f.a.o unused) {
            }
        }
        throw i.f.a.k.a();
    }
}
