package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class z0 implements k1 {
    final /* synthetic */ RecyclerView.o a;

    z0(RecyclerView.o oVar) {
        this.a = oVar;
    }

    @Override // androidx.recyclerview.widget.k1
    public View a(int i2) {
        return this.a.I(i2);
    }

    @Override // androidx.recyclerview.widget.k1
    public int b() {
        return this.a.d0();
    }

    @Override // androidx.recyclerview.widget.k1
    public int c() {
        return this.a.n0() - this.a.e0();
    }

    @Override // androidx.recyclerview.widget.k1
    public int d(View view) {
        return this.a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.k1
    public int e(View view) {
        return this.a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }
}
