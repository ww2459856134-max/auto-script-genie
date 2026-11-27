package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
class h1 extends androidx.activity.result.l.b<androidx.activity.result.k, androidx.activity.result.b> {
    h1() {
    }

    @Override // androidx.activity.result.l.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, androidx.activity.result.k kVar) {
        Bundle bundleExtra;
        Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intentA = kVar.a();
        if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                androidx.activity.result.j jVar = new androidx.activity.result.j(kVar.d());
                jVar.b(null);
                jVar.c(kVar.c(), kVar.b());
                kVar = jVar.a();
            }
        }
        intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", kVar);
        if (p1.F0(2)) {
            Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
        }
        return intent;
    }

    @Override // androidx.activity.result.l.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.b c(int i2, Intent intent) {
        return new androidx.activity.result.b(i2, intent);
    }
}
