package n.a.a.o;

/* loaded from: classes.dex */
public abstract class q0 {
    public static boolean a(Throwable th) {
        return (th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof InterruptedException) || (th instanceof LinkageError);
    }

    public static void b(Throwable th) throws Error, RuntimeException {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw new RuntimeException(th);
        }
        throw ((RuntimeException) th);
    }
}
