package h.e.g;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
class s implements ThreadFactory {
    private String a;
    private int b;

    s(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new r(runnable, this.a, this.b);
    }
}
