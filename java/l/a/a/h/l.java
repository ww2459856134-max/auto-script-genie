package l.a.a.h;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class l<T> {
    private final l.a.a.g.d a;
    private final boolean b;
    private final ExecutorService c;

    public l(k kVar) {
        this.a = kVar.a;
        this.b = kVar.b;
        this.c = kVar.c;
    }

    private void h() {
        this.a.c();
        this.a.j(l.a.a.g.b.BUSY);
        this.a.g(g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(T t, l.a.a.g.d dVar) throws l.a.a.c.b {
        try {
            f(t, dVar);
            dVar.a();
        } catch (l.a.a.c.b e) {
            dVar.b(e);
            throw e;
        } catch (Exception e2) {
            dVar.b(e2);
            throw new l.a.a.c.b(e2);
        }
    }

    protected abstract long d(T t) throws l.a.a.c.b;

    public void e(T t) throws l.a.a.c.b {
        if (this.b && l.a.a.g.b.BUSY.equals(this.a.d())) {
            throw new l.a.a.c.b("invalid operation - Zip4j is in busy state");
        }
        h();
        if (!this.b) {
            i(t, this.a);
            return;
        }
        this.a.k(d(t));
        this.c.execute(new j(this, t));
    }

    protected abstract void f(T t, l.a.a.g.d dVar) throws IOException;

    protected abstract l.a.a.g.c g();

    protected void j() throws l.a.a.c.b {
        if (this.a.e()) {
            this.a.i(l.a.a.g.a.CANCELLED);
            this.a.j(l.a.a.g.b.READY);
            throw new l.a.a.c.b("Task cancelled", l.a.a.c.a.TASK_CANCELLED_EXCEPTION);
        }
    }
}
