package i.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.a.ScreenshotAct;

/* loaded from: classes.dex */
class b9 extends Handler {
    final /* synthetic */ i9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b9(i9 i9Var, Looper looper) {
        super(looper);
        this.a = i9Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            if (com.frame.v0.g().d() == null || !com.frame.v0.g().d().getClass().equals(ScreenshotAct.class)) {
                this.a.k0();
            }
        } catch (Exception unused) {
            this.a.k0();
        }
    }
}
