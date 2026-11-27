package n.a.a.l.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterator;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Iterable<n.a.a.l.c.i>] */
/* loaded from: classes.dex */
public class f extends j implements Object, Object {
    private final Map<String, i> d;
    private final Map<String, i> e;
    private final ArrayList<i> f;
    private final q g;

    /* renamed from: h, reason: collision with root package name */
    private final p f2306h;

    f(n.a.a.l.e.c cVar, q qVar, f fVar) {
        super(cVar, fVar);
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new ArrayList<>();
        this.g = qVar;
        if (fVar == null) {
            this.f2306h = new p();
        } else {
            this.f2306h = new p(fVar.f2306h, new String[]{cVar.b()});
        }
        Iterator<n.a.a.l.e.e> itE = cVar.E();
        while (itE.hasNext()) {
            n.a.a.l.e.e next = itE.next();
            i fVar2 = next.h() ? new f((n.a.a.l.e.c) next, this.g, this) : new h((n.a.a.l.e.d) next, this);
            this.f.add(fVar2);
            this.d.put(fVar2.getName(), fVar2);
            this.e.put(fVar2.getName().toUpperCase(Locale.ROOT), fVar2);
        }
    }

    public g b(String str, InputStream inputStream) throws IOException {
        return e(new o(str, this.g, inputStream));
    }

    g e(o oVar) throws IOException {
        n.a.a.l.e.d dVarB = oVar.b();
        h hVar = new h(dVarB, this);
        ((n.a.a.l.e.c) a()).D(dVarB);
        this.g.p(oVar);
        this.f.add(hVar);
        this.d.put(dVarB.b(), hVar);
        this.e.put(dVarB.b().toUpperCase(Locale.ROOT), hVar);
        return hVar;
    }

    public Iterator<i> g() {
        return this.f.iterator();
    }

    public void h(n.a.a.f.b bVar) throws ArrayStoreException {
        a().A(bVar);
    }

    public Iterator<i> iterator() {
        return g();
    }

    public Spliterator<i> spliterator() {
        return this.f.spliterator();
    }
}
