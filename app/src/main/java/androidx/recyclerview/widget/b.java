package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class b implements s0 {
    private final RecyclerView.g a;

    public b(RecyclerView.g gVar) {
        this.a = gVar;
    }

    @Override // androidx.recyclerview.widget.s0
    public void onChanged(int i2, int i3, Object obj) {
        this.a.notifyItemRangeChanged(i2, i3, obj);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onInserted(int i2, int i3) {
        this.a.notifyItemRangeInserted(i2, i3);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onMoved(int i2, int i3) {
        this.a.notifyItemMoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onRemoved(int i2, int i3) {
        this.a.notifyItemRangeRemoved(i2, i3);
    }
}
