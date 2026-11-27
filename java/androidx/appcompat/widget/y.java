package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

/* loaded from: classes.dex */
class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ AppCompatSpinner.e c;

    y(AppCompatSpinner.e eVar, AppCompatSpinner appCompatSpinner) {
        this.c = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppCompatSpinner.this.setSelection(i2);
        if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.e eVar = this.c;
            AppCompatSpinner.this.performItemClick(view, i2, eVar.j0.getItemId(i2));
        }
        this.c.dismiss();
    }
}
