package i.e.a.j;

/* loaded from: classes.dex */
final class y {
    e a;
    e b;
    e c;
    i d;

    y() {
    }

    public synchronized e a() {
        if (this.c == null) {
            this.c = new e(64);
        }
        return new e(this.c);
    }

    public synchronized e b() {
        if (this.b == null) {
            this.b = new e(64);
        }
        return new e(this.b);
    }

    public synchronized i c() {
        if (this.d == null) {
            this.d = new i(64);
        }
        return new i(this.d);
    }

    public synchronized e d() {
        if (this.a == null) {
            this.a = new e(64);
        }
        return new e(this.a);
    }

    public synchronized void e(e eVar) {
        this.c.l(eVar);
    }

    public synchronized void f(e eVar) {
        this.b.l(eVar);
    }

    public synchronized void g(i iVar) {
        this.d.e(iVar);
    }

    public synchronized void h(e eVar) {
        this.a.l(eVar);
    }
}
