package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ ArrayList c;
    final /* synthetic */ p d;

    h(p pVar, ArrayList arrayList) {
        this.d = pVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            this.d.S((RecyclerView.d0) it.next());
        }
        this.c.clear();
        this.d.f372l.remove(this.c);
    }
}
