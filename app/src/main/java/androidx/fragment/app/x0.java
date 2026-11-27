package androidx.fragment.app;

import android.util.Log;

/* loaded from: classes.dex */
class x0 implements androidx.activity.result.c<androidx.activity.result.b> {
    final /* synthetic */ p1 a;

    x0(p1 p1Var) {
        this.a = p1Var;
    }

    @Override // androidx.activity.result.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(androidx.activity.result.b bVar) {
        k1 k1VarPollFirst = this.a.C.pollFirst();
        if (k1VarPollFirst == null) {
            Log.w("FragmentManager", "No IntentSenders were started for " + this);
            return;
        }
        String str = k1VarPollFirst.c;
        int i2 = k1VarPollFirst.d;
        Fragment fragmentI = this.a.c.i(str);
        if (fragmentI != null) {
            fragmentI.q0(i2, bVar.b(), bVar.a());
            return;
        }
        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
    }
}
