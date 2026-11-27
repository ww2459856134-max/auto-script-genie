package com.bumptech.glide.w;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public class h implements e {
    @Override // com.bumptech.glide.w.e
    public d a(Context context, c cVar) {
        boolean z = androidx.core.content.a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new g(context, cVar) : new l();
    }
}
