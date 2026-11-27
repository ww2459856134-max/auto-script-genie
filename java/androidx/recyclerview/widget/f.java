package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ ArrayList c;
    final /* synthetic */ p d;

    f(p pVar, ArrayList arrayList) {
        this.d = pVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            this.d.U(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
        }
        this.c.clear();
        this.d.f373m.remove(this.c);
    }
}
