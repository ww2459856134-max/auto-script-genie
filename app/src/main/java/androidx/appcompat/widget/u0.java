package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes.dex */
class u0 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ a1 c;

    u0(a1 a1Var) {
        this.c = a1Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        p0 p0Var;
        if (i2 == -1 || (p0Var = this.c.e) == null) {
            return;
        }
        p0Var.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
