package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
class g implements androidx.activity.l.b {
    final /* synthetic */ ComponentActivity a;

    g(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    @Override // androidx.activity.l.b
    @SuppressLint({"SyntheticAccessor"})
    public void a(Context context) {
        Bundle bundleA = this.a.b().a("android:support:activity-result");
        if (bundleA != null) {
            this.a.f3k.g(bundleA);
        }
    }
}
