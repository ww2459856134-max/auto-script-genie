package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ AlertController.RecycleListView c;
    final /* synthetic */ AlertController d;
    final /* synthetic */ m e;

    k(m mVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.e = mVar;
        this.c = recycleListView;
        this.d = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean[] zArr = this.e.F;
        if (zArr != null) {
            zArr[i2] = this.c.isItemChecked(i2);
        }
        this.e.J.onClick(this.d.b, i2, this.c.isItemChecked(i2));
    }
}
