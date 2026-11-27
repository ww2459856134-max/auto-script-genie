package h.f.a;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
class b extends DataSetObserver {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        c cVar = this.a;
        cVar.c = true;
        cVar.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        c cVar = this.a;
        cVar.c = false;
        cVar.notifyDataSetInvalidated();
    }
}
