package i.f.a;

/* loaded from: classes.dex */
public final class c {
    private final b a;
    private i.f.a.v.b b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = bVar;
    }

    public i.f.a.v.b a() throws k {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public i.f.a.v.a b(int i2, i.f.a.v.a aVar) throws k {
        return this.a.c(i2, aVar);
    }

    public int c() {
        return this.a.d();
    }

    public int d() {
        return this.a.f();
    }

    public boolean e() {
        return this.a.e().f();
    }

    public c f() {
        return new c(this.a.a(this.a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (k unused) {
            return "";
        }
    }
}
