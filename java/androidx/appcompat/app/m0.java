package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
class m0 extends BroadcastReceiver {
    final /* synthetic */ n0 a;

    m0(n0 n0Var) {
        this.a = n0Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.d();
    }
}
