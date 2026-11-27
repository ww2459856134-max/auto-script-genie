package androidx.appcompat.app;

import android.view.View;

/* loaded from: classes.dex */
class f1 implements h.e.j.c1 {
    final /* synthetic */ h1 a;

    f1(h1 h1Var) {
        this.a = h1Var;
    }

    @Override // h.e.j.c1
    public void a(View view) {
        ((View) this.a.d.getParent()).invalidate();
    }
}
