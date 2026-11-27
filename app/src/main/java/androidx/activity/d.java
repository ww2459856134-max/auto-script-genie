package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;

/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ int c;
    final /* synthetic */ IntentSender.SendIntentException d;
    final /* synthetic */ e e;

    d(e eVar, int i2, IntentSender.SendIntentException sendIntentException) {
        this.e = eVar;
        this.c = i2;
        this.d = sendIntentException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.b(this.c, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.d));
    }
}
