package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
class h extends ArrayAdapter<CharSequence> {
    final /* synthetic */ AlertController.RecycleListView c;
    final /* synthetic */ m d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h(m mVar, Context context, int i2, int i3, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i2, i3, charSequenceArr);
        this.d = mVar;
        this.c = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i2, view, viewGroup);
        boolean[] zArr = this.d.F;
        if (zArr != null && zArr[i2]) {
            this.c.setItemChecked(i2, true);
        }
        return view2;
    }
}
