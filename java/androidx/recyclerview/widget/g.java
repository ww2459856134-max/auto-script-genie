package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ ArrayList c;
    final /* synthetic */ p d;

    g(p pVar, ArrayList arrayList) {
        this.d = pVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            this.d.T((n) it.next());
        }
        this.c.clear();
        this.d.f374n.remove(this.c);
    }
}
