package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
class e0 implements SavedStateRegistry.b {
    final /* synthetic */ h0 a;

    e0(h0 h0Var) {
        this.a = h0Var;
    }

    @Override // androidx.savedstate.SavedStateRegistry.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        this.a.z();
        this.a.A.h(f.a.ON_STOP);
        Parcelable parcelableX = this.a.t.x();
        if (parcelableX != null) {
            bundle.putParcelable("android:support:fragments", parcelableX);
        }
        return bundle;
    }
}
