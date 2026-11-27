package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
class f0 implements androidx.activity.l.b {
    final /* synthetic */ h0 a;

    f0(h0 h0Var) {
        this.a = h0Var;
    }

    @Override // androidx.activity.l.b
    public void a(Context context) {
        this.a.t.a(null);
        Bundle bundleA = this.a.b().a("android:support:fragments");
        if (bundleA != null) {
            this.a.t.w(bundleA.getParcelable("android:support:fragments"));
        }
    }
}
