package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class v0 extends x0 {
    v0(RecyclerView.o oVar) {
        super(oVar, null);
    }

    @Override // androidx.recyclerview.widget.x0
    public int d(View view) {
        return this.a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int e(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int f(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int g(View view) {
        return this.a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int h() {
        return this.a.n0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int i() {
        return this.a.n0() - this.a.e0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int j() {
        return this.a.e0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int k() {
        return this.a.o0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int l() {
        return this.a.X();
    }

    @Override // androidx.recyclerview.widget.x0
    public int m() {
        return this.a.d0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int n() {
        return (this.a.n0() - this.a.d0()) - this.a.e0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int p(View view) {
        this.a.m0(view, true, this.c);
        return this.c.right;
    }

    @Override // androidx.recyclerview.widget.x0
    public int q(View view) {
        this.a.m0(view, true, this.c);
        return this.c.left;
    }

    @Override // androidx.recyclerview.widget.x0
    public void r(int i2) {
        this.a.B0(i2);
    }
}
