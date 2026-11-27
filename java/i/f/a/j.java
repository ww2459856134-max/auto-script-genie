package i.f.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements n {
    private static final n[] c = new n[0];
    private Map<e, ?> a;
    private n[] b;

    private p c(c cVar) throws k {
        n[] nVarArr = this.b;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                try {
                    return nVar.a(cVar, this.a);
                } catch (o unused) {
                }
            }
        }
        throw k.a();
    }

    @Override // i.f.a.n
    public p a(c cVar, Map<e, ?> map) throws k {
        e(map);
        return c(cVar);
    }

    @Override // i.f.a.n
    public void b() {
        n[] nVarArr = this.b;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                nVar.b();
            }
        }
    }

    public p d(c cVar) throws k {
        if (this.b == null) {
            e(null);
        }
        return c(cVar);
    }

    public void e(Map<e, ?> map) {
        this.a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new i.f.a.y.i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new i.f.a.a0.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new i.f.a.w.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new i.f.a.u.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new i.f.a.z.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new i.f.a.x.a());
            }
            if (z && z2) {
                arrayList.add(new i.f.a.y.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new i.f.a.y.i(map));
            }
            arrayList.add(new i.f.a.a0.a());
            arrayList.add(new i.f.a.w.a());
            arrayList.add(new i.f.a.u.b());
            arrayList.add(new i.f.a.z.b());
            arrayList.add(new i.f.a.x.a());
            if (z2) {
                arrayList.add(new i.f.a.y.i(map));
            }
        }
        this.b = (n[]) arrayList.toArray(c);
    }
}
