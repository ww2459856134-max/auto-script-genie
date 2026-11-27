package i.f.a;

/* loaded from: classes.dex */
public abstract class o extends Exception {
    protected static final boolean c;
    protected static final StackTraceElement[] d;

    static {
        c = System.getProperty("surefire.test.class.path") != null;
        d = new StackTraceElement[0];
    }

    o() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    o(Throwable th) {
        super(th);
    }
}
