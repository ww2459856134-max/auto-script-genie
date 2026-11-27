package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes.dex */
class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ AlertController c;
    final /* synthetic */ m d;

    j(m mVar, AlertController alertController) {
        this.d = mVar;
        this.c = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.d.x.onClick(this.c.b, i2);
        if (this.d.H) {
            return;
        }
        this.c.b.dismiss();
    }
}
