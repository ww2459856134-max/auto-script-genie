package com.user;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: classes.dex */
class t extends BroadcastReceiver {
    final /* synthetic */ Runnable a;
    final /* synthetic */ w b;

    t(w wVar, Runnable runnable) {
        this.b = wVar;
        this.a = runnable;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Runnable runnable;
        if (intent == null || !ConstantsAPI.ACTION_REFRESH_WXAPP.equals(intent.getAction())) {
            return;
        }
        if (this.b.a.registerApp(k0.e) && (runnable = this.a) != null) {
            l1.g(runnable);
        }
        try {
            abortBroadcast();
            v0.g().unregisterReceiver(this);
        } catch (Exception e) {
            k0.r(e);
        }
    }
}
