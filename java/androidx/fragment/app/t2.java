package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
class t2 extends Transition.EpicenterCallback {
    final /* synthetic */ Rect a;

    t2(u2 u2Var, Rect rect) {
        this.a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.a;
    }
}
