package com.jsj.autojs.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import i.b.da;

/* loaded from: classes.dex */
public class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.SCREEN_OFF") && da.B().U()) {
            da.B().h2();
        }
    }
}
