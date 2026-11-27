package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class g1 extends RecyclerView.l {
    boolean g = true;

    public abstract boolean A(RecyclerView.d0 d0Var);

    public final void B(RecyclerView.d0 d0Var) {
        J(d0Var);
        h(d0Var);
    }

    public final void C(RecyclerView.d0 d0Var) {
        K(d0Var);
    }

    public final void D(RecyclerView.d0 d0Var, boolean z) {
        L(d0Var, z);
        h(d0Var);
    }

    public final void E(RecyclerView.d0 d0Var, boolean z) {
        M(d0Var, z);
    }

    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
        h(d0Var);
    }

    public final void G(RecyclerView.d0 d0Var) {
        O(d0Var);
    }

    public final void H(RecyclerView.d0 d0Var) {
        P(d0Var);
        h(d0Var);
    }

    public final void I(RecyclerView.d0 d0Var) {
        Q(d0Var);
    }

    public void J(RecyclerView.d0 d0Var) {
    }

    public void K(RecyclerView.d0 d0Var) {
    }

    public void L(RecyclerView.d0 d0Var, boolean z) {
    }

    public void M(RecyclerView.d0 d0Var, boolean z) {
    }

    public void N(RecyclerView.d0 d0Var) {
    }

    public void O(RecyclerView.d0 d0Var) {
    }

    public void P(RecyclerView.d0 d0Var) {
    }

    public void Q(RecyclerView.d0 d0Var) {
    }

    public void R(boolean z) {
        this.g = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i2;
        int i3;
        return (bVar == null || ((i2 = bVar.a) == (i3 = bVar2.a) && bVar.b == bVar2.b)) ? x(d0Var) : z(d0Var, i2, bVar.b, i3, bVar2.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i2;
        int i3;
        int i4 = bVar.a;
        int i5 = bVar.b;
        if (d0Var2.shouldIgnore()) {
            int i6 = bVar.a;
            i3 = bVar.b;
            i2 = i6;
        } else {
            i2 = bVar2.a;
            i3 = bVar2.b;
        }
        return y(d0Var, d0Var2, i4, i5, i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i2 = bVar.a;
        int i3 = bVar.b;
        View view = d0Var.itemView;
        int left = bVar2 == null ? view.getLeft() : bVar2.a;
        int top = bVar2 == null ? view.getTop() : bVar2.b;
        if (d0Var.isRemoved() || (i2 == left && i3 == top)) {
            return A(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return z(d0Var, i2, i3, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i2 = bVar.a;
        int i3 = bVar2.a;
        if (i2 != i3 || bVar.b != bVar2.b) {
            return z(d0Var, i2, bVar.b, i3, bVar2.b);
        }
        F(d0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.d0 d0Var) {
        return !this.g || d0Var.isInvalid();
    }

    public abstract boolean x(RecyclerView.d0 d0Var);

    public abstract boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5);

    public abstract boolean z(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5);
}
