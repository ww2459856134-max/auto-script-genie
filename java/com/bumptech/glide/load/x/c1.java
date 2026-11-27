package com.bumptech.glide.load.x;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
final class c1 implements Handler.Callback {
    c1() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((z0) message.obj).a();
        return true;
    }
}
