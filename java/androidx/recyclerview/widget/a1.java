package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class a1 implements k1 {
    final /* synthetic */ RecyclerView.o a;

    a1(RecyclerView.o oVar) {
        this.a = oVar;
    }

    @Override // androidx.recyclerview.widget.k1
    public View a(int i2) {
        return this.a.I(i2);
    }

    @Override // androidx.recyclerview.widget.k1
    public int b() {
        return this.a.f0();
    }

    @Override // androidx.recyclerview.widget.k1
    public int c() {
        return this.a.W() - this.a.c0();
    }

    @Override // androidx.recyclerview.widget.k1
    public int d(View view) {
        return this.a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.k1
    public int e(View view) {
        return this.a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }
}
