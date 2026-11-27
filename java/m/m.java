package m;

import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public class m {
    private boolean a;
    private long b;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
