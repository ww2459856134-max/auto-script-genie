package i.f.a.y.r.g;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class c {
    private final List<b> a;
    private final int b;
    private final boolean c;

    c(List<b> list, int i2, boolean z) {
        this.a = new ArrayList(list);
        this.b = i2;
        this.c = z;
    }

    List<b> a() {
        return this.a;
    }

    int b() {
        return this.b;
    }

    boolean c(List<b> list) {
        return this.a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a) && this.c == cVar.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
