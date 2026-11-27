package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;

/* loaded from: classes.dex */
class e extends ActivityResultRegistry {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f4i;

    e(ComponentActivity componentActivity) {
        this.f4i = componentActivity;
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public <I, O> void f(int i2, androidx.activity.result.l.b<I, O> bVar, I i3, androidx.core.app.g gVar) {
        ComponentActivity componentActivity = this.f4i;
        androidx.activity.result.l.a<O> aVarB = bVar.b(componentActivity, i3);
        if (aVarB != null) {
            new Handler(Looper.getMainLooper()).post(new c(this, i2, aVarB));
            return;
        }
        Intent intentA = bVar.a(componentActivity, i3);
        Bundle bundleA = null;
        if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
            intentA.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleA = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else if (gVar != null) {
            bundleA = gVar.a();
        }
        Bundle bundle = bundleA;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            androidx.core.app.f.l(componentActivity, stringArrayExtra, i2);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
            androidx.core.app.f.m(componentActivity, intentA, i2, bundle);
            return;
        }
        androidx.activity.result.k kVar = (androidx.activity.result.k) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            androidx.core.app.f.n(componentActivity, kVar.d(), i2, kVar.a(), kVar.b(), kVar.c(), 0, bundle);
        } catch (IntentSender.SendIntentException e) {
            new Handler(Looper.getMainLooper()).post(new d(this, i2, e));
        }
    }
}
