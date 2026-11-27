package org.apache.xmlbeans.impl.util;

/* loaded from: classes.dex */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static boolean isFatal(Throwable th) {
        return (th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof InterruptedException) || (th instanceof LinkageError);
    }

    public static void rethrow(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw new RuntimeException(th);
        }
        throw ((RuntimeException) th);
    }
}
