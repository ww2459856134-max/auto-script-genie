package h.b.a.a;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class c extends d {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool(4, new b(this));

    @Override // h.b.a.a.d
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
