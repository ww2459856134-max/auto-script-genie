package com.frame;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
class k1 extends Handler {
    k1() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            ((Runnable) message.obj).run();
        } catch (Exception e) {
            k0.r(e);
        }
    }
}
