package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
class d implements NestedScrollView.b {
    final /* synthetic */ View a;
    final /* synthetic */ View b;

    d(AlertController alertController, View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        AlertController.f(nestedScrollView, this.a, this.b);
    }
}
