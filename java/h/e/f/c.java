package h.e.f;

import android.os.Build;
import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class c {
    private boolean a;
    private b b;
    private Object c;
    private boolean d;

    private void d() throws InterruptedException {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            b bVar = this.b;
            Object obj = this.c;
            if (bVar != null) {
                try {
                    bVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void c(b bVar) {
        synchronized (this) {
            d();
            if (this.b == bVar) {
                return;
            }
            this.b = bVar;
            if (this.a && bVar != null) {
                bVar.onCancel();
            }
        }
    }
}
