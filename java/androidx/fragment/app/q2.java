package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class q2 implements Transition.TransitionListener {
    final /* synthetic */ View a;
    final /* synthetic */ ArrayList b;

    q2(u2 u2Var, View view, ArrayList arrayList) {
        this.a = view;
        this.b = arrayList;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.a.setVisibility(8);
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((View) this.b.get(i2)).setVisibility(0);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        transition.removeListener(this);
        transition.addListener(this);
    }
}
