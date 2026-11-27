package com.jsj.autojs.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import i.b.da;

/* loaded from: classes.dex */
public class ZiqidongReceiver234234423243 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PendingIntent.CanceledException {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            da.B().i();
            Log.d("lololo", "onReceive() returned: 开机");
        }
    }
}
