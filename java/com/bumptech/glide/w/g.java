package com.bumptech.glide.w;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* loaded from: classes.dex */
final class g implements d {
    private final Context c;
    final c d;
    boolean e;
    private boolean f;
    private final BroadcastReceiver g = new f(this);

    g(Context context, c cVar) {
        this.c = context.getApplicationContext();
        this.d = cVar;
    }

    private void m() {
        if (this.f) {
            return;
        }
        this.e = l(this.c);
        try {
            this.c.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    private void n() {
        if (this.f) {
            this.c.unregisterReceiver(this.g);
            this.f = false;
        }
    }

    @Override // com.bumptech.glide.w.k
    public void a() {
        m();
    }

    @Override // com.bumptech.glide.w.k
    public void b() {
        n();
    }

    @Override // com.bumptech.glide.w.k
    public void d() {
    }

    @SuppressLint({"MissingPermission"})
    boolean l(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        com.bumptech.glide.b0.n.d(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }
}
