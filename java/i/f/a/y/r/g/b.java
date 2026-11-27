package i.f.a.y.r.g;

import java.util.Objects;

/* loaded from: classes.dex */
final class b {
    private final i.f.a.y.r.b a;
    private final i.f.a.y.r.b b;
    private final i.f.a.y.r.c c;

    b(i.f.a.y.r.b bVar, i.f.a.y.r.b bVar2, i.f.a.y.r.c cVar) {
        this.a = bVar;
        this.b = bVar2;
        this.c = cVar;
    }

    i.f.a.y.r.c a() {
        return this.c;
    }

    i.f.a.y.r.b b() {
        return this.a;
    }

    i.f.a.y.r.b c() {
        return this.b;
    }

    boolean d() {
        return this.b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.a, bVar.a) && Objects.equals(this.b, bVar.b) && Objects.equals(this.c, bVar.c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.a) ^ Objects.hashCode(this.b)) ^ Objects.hashCode(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.b);
        sb.append(" : ");
        i.f.a.y.r.c cVar = this.c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
