package i.e.a.k;

/* loaded from: classes.dex */
final class v {
    u a;
    u b;
    u c;
    u d;

    v() {
    }

    public synchronized u a(s sVar) {
        if (this.c == null) {
            this.c = new u(64);
        }
        return this.c.b(sVar);
    }

    public synchronized u b(s sVar) {
        if (this.d == null) {
            this.d = new u(64);
        }
        return this.d.b(sVar);
    }

    public synchronized u c(s sVar) {
        if (this.b == null) {
            this.b = new u(64);
        }
        return this.b.b(sVar);
    }

    public synchronized u d(s sVar) {
        if (this.a == null) {
            this.a = new u(64);
        }
        return this.a.b(sVar);
    }
}
