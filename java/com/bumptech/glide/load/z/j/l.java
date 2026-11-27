package com.bumptech.glide.load.z.j;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
class l implements Handler.Callback {
    final /* synthetic */ n a;

    l(n nVar) {
        this.a = nVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.a.m((j) message.obj);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        this.a.d.o((j) message.obj);
        return false;
    }
}
