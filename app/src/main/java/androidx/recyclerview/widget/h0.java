package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class h0 implements RecyclerView.j {
    final /* synthetic */ k0 a;

    h0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public int a(int i2, int i3) {
        k0 k0Var = this.a;
        View view = k0Var.x;
        if (view == null) {
            return i3;
        }
        int iIndexOfChild = k0Var.y;
        if (iIndexOfChild == -1) {
            iIndexOfChild = k0Var.r.indexOfChild(view);
            this.a.y = iIndexOfChild;
        }
        return i3 == i2 + (-1) ? iIndexOfChild : i3 < iIndexOfChild ? i3 : i3 + 1;
    }
}
