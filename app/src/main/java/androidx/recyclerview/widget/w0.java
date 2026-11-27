package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class w0 extends x0 {
    w0(RecyclerView.o oVar) {
        super(oVar, null);
    }

    @Override // androidx.recyclerview.widget.x0
    public int d(View view) {
        return this.a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int e(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int f(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int g(View view) {
        return this.a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.x0
    public int h() {
        return this.a.W();
    }

    @Override // androidx.recyclerview.widget.x0
    public int i() {
        return this.a.W() - this.a.c0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int j() {
        return this.a.c0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int k() {
        return this.a.X();
    }

    @Override // androidx.recyclerview.widget.x0
    public int l() {
        return this.a.o0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int m() {
        return this.a.f0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int n() {
        return (this.a.W() - this.a.f0()) - this.a.c0();
    }

    @Override // androidx.recyclerview.widget.x0
    public int p(View view) {
        this.a.m0(view, true, this.c);
        return this.c.bottom;
    }

    @Override // androidx.recyclerview.widget.x0
    public int q(View view) {
        this.a.m0(view, true, this.c);
        return this.c.top;
    }

    @Override // androidx.recyclerview.widget.x0
    public void r(int i2) {
        this.a.C0(i2);
    }
}
