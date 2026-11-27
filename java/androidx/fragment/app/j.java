package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class j implements h.e.f.b {
    final /* synthetic */ View a;
    final /* synthetic */ ViewGroup b;
    final /* synthetic */ o c;

    j(r rVar, View view, ViewGroup viewGroup, o oVar) {
        this.a = view;
        this.b = viewGroup;
        this.c = oVar;
    }

    @Override // h.e.f.b
    public void onCancel() {
        this.a.clearAnimation();
        this.b.endViewTransition(this.a);
        this.c.a();
    }
}
