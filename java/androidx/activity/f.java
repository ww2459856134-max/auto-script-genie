package androidx.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
class f implements SavedStateRegistry.b {
    final /* synthetic */ ComponentActivity a;

    f(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry.b
    @SuppressLint({"SyntheticAccessor"})
    public Bundle a() {
        Bundle bundle = new Bundle();
        this.a.f3k.h(bundle);
        return bundle;
    }
}
