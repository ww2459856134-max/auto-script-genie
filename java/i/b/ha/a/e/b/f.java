package i.b.ha.a.e.b;

/* loaded from: classes.dex */
public class f extends IllegalStateException {
    private final i.b.ha.a.e.b.p.b c;

    public f(i.b.ha.a.e.b.p.c cVar, Object... objArr) {
        i.b.ha.a.e.b.p.b bVar = new i.b.ha.a.e.b.p.b(this);
        this.c = bVar;
        bVar.a(cVar, objArr);
    }

    public i.b.ha.a.e.b.p.b a() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.c.c();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.c.d();
    }

    public f() {
        this(i.b.ha.a.e.b.p.d.ILLEGAL_STATE, new Object[0]);
    }
}
