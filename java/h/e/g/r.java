package h.e.g;

import android.os.Process;

/* loaded from: classes.dex */
class r extends Thread {
    private final int c;

    r(Runnable runnable, String str, int i2) {
        super(runnable, str);
        this.c = i2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.c);
        super.run();
    }
}
