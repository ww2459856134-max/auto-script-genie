package androidx.core.app;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ Object c;
    final /* synthetic */ Object d;

    j(Object obj, Object obj2) {
        this.c = obj;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Method method = l.d;
            if (method != null) {
                method.invoke(this.c, this.d, Boolean.FALSE, "AppCompat recreation");
            } else {
                l.e.invoke(this.c, this.d, Boolean.FALSE);
            }
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
