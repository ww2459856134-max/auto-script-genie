package i.e.a.j;

/* loaded from: classes.dex */
public final class k {
    k a;
    v b;

    public k(v vVar, k kVar) {
        this.a = kVar;
        this.b = vVar;
    }

    public v a() {
        return this.b;
    }

    public k b() {
        return this.a;
    }

    public String toString() {
        if (this.a == null) {
            return this.b.toString();
        }
        return this.a.toString() + "/" + this.b;
    }
}
