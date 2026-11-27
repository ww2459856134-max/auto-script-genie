package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ y2 c;
    final /* synthetic */ View d;
    final /* synthetic */ Rect e;

    l(r rVar, y2 y2Var, View view, Rect rect) {
        this.c = y2Var;
        this.d = view;
        this.e = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.k(this.d, this.e);
    }
}
