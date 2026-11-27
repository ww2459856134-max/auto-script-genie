package h.e.g;

import java.util.ArrayList;

/* loaded from: classes.dex */
class k implements h.e.i.a<l> {
    final /* synthetic */ String a;

    k(String str) {
        this.a = str;
    }

    @Override // h.e.i.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(l lVar) {
        synchronized (m.c) {
            h.d.i<String, ArrayList<h.e.i.a<l>>> iVar = m.d;
            ArrayList<h.e.i.a<l>> arrayList = iVar.get(this.a);
            if (arrayList == null) {
                return;
            }
            iVar.remove(this.a);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList.get(i2).accept(lVar);
            }
        }
    }
}
