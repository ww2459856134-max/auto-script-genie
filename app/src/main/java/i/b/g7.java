package i.b;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class g7 {
    final CountDownLatch a = new CountDownLatch(1);
    final long b;
    final t9 c;
    Bitmap d;
    String e;
    boolean f;
    int g;

    g7(long j2, t9 t9Var) {
        this.b = j2;
        this.c = t9Var;
    }

    synchronized void a() {
        this.f = true;
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.d = null;
        this.a.countDown();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    synchronized boolean b() {
        boolean z;
        if (this.f || SystemClock.uptimeMillis() >= this.b) {
            z = true;
        } else {
            t9 t9Var = this.c;
            if (t9Var != null) {
                if (!t9Var.q()) {
                }
            }
            z = false;
        }
        return z;
    }

    synchronized void c(Bitmap bitmap, String str) {
        if (this.a.getCount() != 0 && !b()) {
            this.d = bitmap;
            this.e = str;
        } else if (bitmap != null) {
            bitmap.recycle();
        }
        this.a.countDown();
    }

    synchronized Bitmap d() {
        Bitmap bitmap;
        bitmap = this.d;
        this.d = null;
        return bitmap;
    }
}
