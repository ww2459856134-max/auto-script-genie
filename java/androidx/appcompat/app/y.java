package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.q0;

/* loaded from: classes.dex */
class y implements q0.a {
    final /* synthetic */ t0 a;

    y(t0 t0Var) {
        this.a = t0Var;
    }

    @Override // androidx.appcompat.widget.q0.a
    public void a(Rect rect) {
        rect.top = this.a.L0(null, rect);
    }
}
