package h.b.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class b implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(0);

    b(c cVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.a.getAndIncrement())));
        return thread;
    }
}
