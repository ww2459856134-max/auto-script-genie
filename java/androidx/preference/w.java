package androidx.preference;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e1;

/* loaded from: classes.dex */
public class w extends e1 {
    final RecyclerView f;
    final h.e.j.b g;

    /* renamed from: h, reason: collision with root package name */
    final h.e.j.b f310h;

    public w(RecyclerView recyclerView) {
        super(recyclerView);
        this.g = super.n();
        this.f310h = new v(this);
        this.f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.e1
    public h.e.j.b n() {
        return this.f310h;
    }
}
