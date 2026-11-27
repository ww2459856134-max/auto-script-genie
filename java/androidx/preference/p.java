package androidx.preference;

import androidx.recyclerview.widget.r;
import java.util.List;

/* loaded from: classes.dex */
class p extends r.a {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ u c;

    p(r rVar, List list, List list2, u uVar) {
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.r.a
    public boolean areContentsTheSame(int i2, int i3) {
        return this.c.a((Preference) this.a.get(i2), (Preference) this.b.get(i3));
    }

    @Override // androidx.recyclerview.widget.r.a
    public boolean areItemsTheSame(int i2, int i3) {
        return this.c.b((Preference) this.a.get(i2), (Preference) this.b.get(i3));
    }

    @Override // androidx.recyclerview.widget.r.a
    public int getNewListSize() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.r.a
    public int getOldListSize() {
        return this.a.size();
    }
}
