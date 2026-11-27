package h.e.j;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;

/* loaded from: classes.dex */
class j extends Handler {
    final /* synthetic */ k a;

    j(k kVar) {
        this.a = kVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            k kVar = this.a;
            kVar.f.onShowPress(kVar.f1311m);
            return;
        }
        if (i2 == 2) {
            this.a.d();
            return;
        }
        if (i2 != 3) {
            throw new RuntimeException("Unknown message " + message);
        }
        k kVar2 = this.a;
        GestureDetector.OnDoubleTapListener onDoubleTapListener = kVar2.g;
        if (onDoubleTapListener != null) {
            if (kVar2.f1306h) {
                kVar2.f1307i = true;
            } else {
                onDoubleTapListener.onSingleTapConfirmed(kVar2.f1311m);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(k kVar, Handler handler) {
        super(handler.getLooper());
        this.a = kVar;
    }
}
