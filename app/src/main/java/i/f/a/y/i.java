package i.f.a.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class i extends k {
    private static final k[] b = new k[0];
    private final k[] a;

    public i(Map<i.f.a.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(i.f.a.e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(i.f.a.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(i.f.a.a.EAN_13) || collection.contains(i.f.a.a.UPC_A) || collection.contains(i.f.a.a.EAN_8) || collection.contains(i.f.a.a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(i.f.a.a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(i.f.a.a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(i.f.a.a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(i.f.a.a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(i.f.a.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(i.f.a.a.RSS_14)) {
                arrayList.add(new i.f.a.y.r.e());
            }
            if (collection.contains(i.f.a.a.RSS_EXPANDED)) {
                arrayList.add(new i.f.a.y.r.g.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new i.f.a.y.r.e());
            arrayList.add(new i.f.a.y.r.g.d());
        }
        this.a = (k[]) arrayList.toArray(b);
    }

    @Override // i.f.a.y.k, i.f.a.n
    public void b() {
        for (k kVar : this.a) {
            kVar.b();
        }
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k {
        for (k kVar : this.a) {
            try {
                return kVar.c(i2, aVar, map);
            } catch (i.f.a.o unused) {
            }
        }
        throw i.f.a.k.a();
    }
}
