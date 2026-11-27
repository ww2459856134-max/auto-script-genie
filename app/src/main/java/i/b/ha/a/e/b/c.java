package i.b.ha.a.e.b;

/* loaded from: classes.dex */
public class c extends ArithmeticException {
    private final i.b.ha.a.e.b.p.b c;

    public c() {
        i.b.ha.a.e.b.p.b bVar = new i.b.ha.a.e.b.p.b(this);
        this.c = bVar;
        bVar.a(i.b.ha.a.e.b.p.d.ARITHMETIC_EXCEPTION, new Object[0]);
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.c.c();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.c.d();
    }

    public c(i.b.ha.a.e.b.p.c cVar, Object... objArr) {
        i.b.ha.a.e.b.p.b bVar = new i.b.ha.a.e.b.p.b(this);
        this.c = bVar;
        bVar.a(cVar, objArr);
    }
}
