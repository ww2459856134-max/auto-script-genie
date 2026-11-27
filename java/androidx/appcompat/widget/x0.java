package androidx.appcompat.widget;

import android.widget.AbsListView;

/* loaded from: classes.dex */
class x0 implements AbsListView.OnScrollListener {
    final /* synthetic */ a1 a;

    x0(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 1 || this.a.v() || this.a.e0.getContentView() == null) {
            return;
        }
        a1 a1Var = this.a;
        a1Var.a0.removeCallbacks(a1Var.U);
        this.a.U.run();
    }
}
