package n.a.a.n.c;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
final class g {
    private final v a;
    private final Set<f> b = new HashSet();
    private j0 c;

    public g(v vVar) {
        this.a = vVar;
    }

    private f[] d() {
        int size = this.b.size();
        if (size < 1) {
            return f.c;
        }
        f[] fVarArr = new f[size];
        this.b.toArray(fVarArr);
        return fVarArr;
    }

    public void a(f fVar) {
        this.b.add(fVar);
    }

    public void b(t tVar, int i2, int i3, int i4, int i5) {
        if (this.c == null) {
            this.c = new j0();
        }
        this.c.a(tVar, i2, i3, i4, i5);
    }

    public f c() {
        return this.a;
    }

    public void e(n.a.a.n.c.r1.w0 w0Var) {
        this.a.i(w0Var, d(), this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(g.class.getName());
        sb.append(" [");
        sb.append(']');
        return sb.toString();
    }
}
