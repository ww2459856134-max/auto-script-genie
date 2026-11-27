package n.a.a.n.e;

/* loaded from: classes.dex */
public class l implements Comparable<l> {
    private final int c;
    private final int d;

    public l(int i2, int i3) {
        this.c = i2;
        this.d = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        int i2 = this.c - lVar.c;
        return i2 != 0 ? i2 : this.d - lVar.d;
    }

    public String b() {
        return s.f(this.d) + (this.c + 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.c == lVar.c && this.d == lVar.d;
    }

    public int hashCode() {
        return (this.c + this.d) << 16;
    }

    public String toString() {
        return b();
    }

    public l(n.a.a.n.d.e eVar) {
        this(eVar.g(), eVar.i());
    }
}
