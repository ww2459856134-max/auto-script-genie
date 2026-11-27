package androidx.appcompat.app;

import android.content.res.Resources;
import java.lang.Thread;

/* loaded from: classes.dex */
class v implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ Thread.UncaughtExceptionHandler a;

    v(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    private boolean a(Throwable th) {
        String message;
        if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
            return false;
        }
        return message.contains("drawable") || message.contains("Drawable");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!a(th)) {
            this.a.uncaughtException(thread, th);
            return;
        }
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
        notFoundException.initCause(th.getCause());
        notFoundException.setStackTrace(th.getStackTrace());
        this.a.uncaughtException(thread, notFoundException);
    }
}
