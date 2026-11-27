package i.f.a.y.r.g.e;

/* loaded from: classes.dex */
final class n {
    private int a = 0;
    private m b = m.NUMERIC;

    n() {
    }

    int a() {
        return this.a;
    }

    void b(int i2) {
        this.a += i2;
    }

    boolean c() {
        return this.b == m.ALPHA;
    }

    boolean d() {
        return this.b == m.ISO_IEC_646;
    }

    void e() {
        this.b = m.ALPHA;
    }

    void f() {
        this.b = m.ISO_IEC_646;
    }

    void g() {
        this.b = m.NUMERIC;
    }

    void h(int i2) {
        this.a = i2;
    }
}
