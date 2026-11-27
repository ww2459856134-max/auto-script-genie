package androidx.appcompat.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
class q implements SavedStateRegistry.b {
    final /* synthetic */ s a;

    q(s sVar) {
        this.a = sVar;
    }

    @Override // androidx.savedstate.SavedStateRegistry.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        this.a.F().u(bundle);
        return bundle;
    }
}
