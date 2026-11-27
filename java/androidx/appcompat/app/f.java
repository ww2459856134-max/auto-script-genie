package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;

/* loaded from: classes.dex */
class f implements AbsListView.OnScrollListener {
    final /* synthetic */ View a;
    final /* synthetic */ View b;

    f(AlertController alertController, View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AlertController.f(absListView, this.a, this.b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
