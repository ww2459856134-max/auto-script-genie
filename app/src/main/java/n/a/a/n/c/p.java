package n.a.a.n.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
final class p {
    private final List<g> a = new ArrayList();
    private final Set<v> b = new HashSet();
    private final k c;

    public p(k kVar) {
        this.c = kVar;
    }

    public void a(f fVar) {
        int size = this.a.size() - 1;
        if (size < 0) {
            return;
        }
        this.a.get(size).a(fVar);
    }

    public void b(t tVar, int i2, int i3, int i4, int i5, n.a.a.n.c.r1.w0 w0Var) {
        int size = this.a.size() - 1;
        if (size < 0) {
            return;
        }
        g gVar = this.a.get(size);
        if (w0Var == n.a.a.n.c.r1.l.a) {
            gVar.b(tVar, i2, i3, i4, i5);
        } else {
            gVar.a(this.c.c(i2, i3, i4, i5, w0Var));
        }
    }

    public void c(f fVar) {
        int size = this.a.size();
        if (size < 1) {
            throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
        }
        int i2 = size - 1;
        if (fVar != this.a.get(i2).c()) {
            throw new IllegalStateException("Wrong cell specified. ");
        }
        this.a.remove(i2);
        this.b.remove(fVar);
    }

    public boolean d(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("cellLoc must not be null");
        }
        if (this.b.contains(vVar)) {
            return false;
        }
        this.b.add(vVar);
        this.a.add(new g(vVar));
        return true;
    }

    public void e(n.a.a.n.c.r1.w0 w0Var) {
        int size = this.a.size();
        if (size < 1) {
            throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
        }
        g gVar = this.a.get(size - 1);
        if (w0Var != n.a.a.n.c.r1.o.f2387j || size <= 1) {
            gVar.e(w0Var);
        }
    }
}
