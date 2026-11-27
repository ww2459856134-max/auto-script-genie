package androidx.appcompat.view.menu;

import android.widget.PopupWindow;

/* loaded from: classes.dex */
class x implements PopupWindow.OnDismissListener {
    final /* synthetic */ y c;

    x(y yVar) {
        this.c = yVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.c.e();
    }
}
