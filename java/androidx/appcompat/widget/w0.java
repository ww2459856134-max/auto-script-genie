package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
class w0 extends DataSetObserver {
    final /* synthetic */ a1 a;

    w0(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        if (this.a.a()) {
            this.a.g();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.a.dismiss();
    }
}
