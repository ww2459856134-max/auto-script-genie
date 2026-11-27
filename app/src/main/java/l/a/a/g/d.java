package l.a.a.g;

/* loaded from: classes.dex */
public class d {
    private b a;
    private long b;
    private long c;
    private int d;
    private boolean e;
    private boolean f;

    public d() {
        f();
    }

    private void f() {
        c cVar = c.NONE;
        this.a = b.READY;
    }

    public void a() {
        a aVar = a.SUCCESS;
        this.d = 100;
        f();
    }

    public void b(Exception exc) {
        a aVar = a.ERROR;
        f();
    }

    public void c() {
        f();
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
    }

    public b d() {
        return this.a;
    }

    public boolean e() {
        return this.e;
    }

    public void g(c cVar) {
    }

    public void h(String str) {
    }

    public void i(a aVar) {
    }

    public void j(b bVar) {
        this.a = bVar;
    }

    public void k(long j2) {
        this.b = j2;
    }

    public void l(long j2) throws InterruptedException {
        long j3 = this.c + j2;
        this.c = j3;
        long j4 = this.b;
        if (j4 > 0) {
            int i2 = (int) ((j3 * 100) / j4);
            this.d = i2;
            if (i2 > 100) {
                this.d = 100;
            }
        }
        while (this.f) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
