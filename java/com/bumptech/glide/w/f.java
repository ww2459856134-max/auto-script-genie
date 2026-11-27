package com.bumptech.glide.w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
class f extends BroadcastReceiver {
    final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        g gVar = this.a;
        boolean z = gVar.e;
        gVar.e = gVar.l(context);
        if (z != this.a.e) {
            if (Log.isLoggable("ConnectivityMonitor", 3)) {
                Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.a.e);
            }
            g gVar2 = this.a;
            gVar2.d.a(gVar2.e);
        }
    }
}
