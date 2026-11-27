package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

/* loaded from: classes.dex */
class z implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ AppCompatSpinner.e c;

    z(AppCompatSpinner.e eVar) {
        this.c = eVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        AppCompatSpinner.e eVar = this.c;
        if (!eVar.P(AppCompatSpinner.this)) {
            this.c.dismiss();
        } else {
            this.c.N();
            super/*androidx.appcompat.widget.a1*/.g();
        }
    }
}
