package h.e.i;

/* loaded from: classes.dex */
public class d<F, S> {
    public final F a;
    public final S b;

    public d(F f, S s) {
        this.a = f;
        this.b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.a, this.a) && c.a(dVar.b, this.b);
    }

    public int hashCode() {
        F f = this.a;
        int iHashCode = f == null ? 0 : f.hashCode();
        S s = this.b;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.a + " " + this.b + "}";
    }
}
