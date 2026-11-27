package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
class p2 extends Transition.EpicenterCallback {
    final /* synthetic */ Rect a;

    p2(u2 u2Var, Rect rect) {
        this.a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}
