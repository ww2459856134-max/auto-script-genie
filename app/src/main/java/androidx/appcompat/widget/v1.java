package androidx.appcompat.widget;

import android.R;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
class v1 implements View.OnClickListener {
    final androidx.appcompat.view.menu.a c;
    final /* synthetic */ x1 d;

    v1(x1 x1Var) {
        this.d = x1Var;
        this.c = new androidx.appcompat.view.menu.a(x1Var.a.getContext(), 0, R.id.home, 0, 0, x1Var.f181i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x1 x1Var = this.d;
        Window.Callback callback = x1Var.f184l;
        if (callback == null || !x1Var.f185m) {
            return;
        }
        callback.onMenuItemSelected(0, this.c);
    }
}
