package h.e.g;

import android.os.Handler;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class u<T> implements Runnable {
    private Callable<T> c;
    private h.e.i.a<T> d;
    private Handler e;

    u(Handler handler, Callable<T> callable, h.e.i.a<T> aVar) {
        this.c = callable;
        this.d = aVar;
        this.e = handler;
    }

    @Override // java.lang.Runnable
    public void run() throws Exception {
        T tCall;
        try {
            tCall = this.c.call();
        } catch (Exception unused) {
            tCall = null;
        }
        this.e.post(new t(this, this.d, tCall));
    }
}
