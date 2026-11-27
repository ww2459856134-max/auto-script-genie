package i.f.a;

/* loaded from: classes.dex */
public final class g extends o {
    private static final g e;

    static {
        g gVar = new g();
        e = gVar;
        gVar.setStackTrace(o.d);
    }

    private g() {
    }

    public static g a() {
        return o.c ? new g() : e;
    }

    public static g b(Throwable th) {
        return o.c ? new g(th) : e;
    }

    private g(Throwable th) {
        super(th);
    }
}
