package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class v extends h.e.j.b {
    final /* synthetic */ w d;

    v(w wVar) {
        this.d = wVar;
    }

    @Override // h.e.j.b
    public void g(View view, h.e.j.q1.e eVar) {
        Preference preferenceF;
        this.d.g.g(view, eVar);
        int iF0 = this.d.f.f0(view);
        RecyclerView.g adapter = this.d.f.getAdapter();
        if ((adapter instanceof r) && (preferenceF = ((r) adapter).f(iF0)) != null) {
            preferenceF.S(eVar);
        }
    }

    @Override // h.e.j.b
    public boolean j(View view, int i2, Bundle bundle) {
        return this.d.g.j(view, i2, bundle);
    }
}
