package i.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.frame.k0;

/* loaded from: classes.dex */
class h extends Handler {
    final /* synthetic */ j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h(j jVar, Looper looper) {
        super(looper);
        this.a = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.a.o();
                } else if (i2 == 2) {
                    int i3 = message.arg1;
                    if (i3 > 0) {
                        this.a.p(i3);
                        this.a.f.sendMessageDelayed(this.a.f.obtainMessage(2, message.arg1 - 1000, 0), 1000L);
                    } else {
                        this.a.p(i3);
                        this.a.o();
                    }
                }
            } else if (!this.a.c) {
                this.a.k();
            }
        } catch (Exception e) {
            k0.r(e);
            this.a.o();
        }
    }
}
