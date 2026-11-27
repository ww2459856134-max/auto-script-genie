package n.a.a.l.e;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.a.a.l.c.s;

/* loaded from: classes.dex */
public final class f {
    private static final Logger d = n.a.a.i.b.a(f.class);
    private final n.a.a.l.f.d a;
    private final List<e> b = new ArrayList();
    private final n.a.a.l.a.a c;

    public f(n.a.a.l.f.d dVar) {
        this.a = dVar;
        this.c = dVar.c();
        a(new g());
    }

    public void a(e eVar) {
        this.b.add(eVar);
    }

    public int b() {
        long size = this.b.size() * 128;
        long jB = this.c.b();
        int i2 = (int) (size / jB);
        return size % jB != 0 ? i2 + 1 : i2;
    }

    public g c() {
        e eVar = this.b.get(0);
        if (eVar instanceof g) {
            return (g) eVar;
        }
        throw new IllegalStateException("Invalid format, cannot convert property " + eVar + " to RootProperty");
    }

    public int d() {
        return this.a.d();
    }

    public void e() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (e eVar : this.b) {
            if (eVar != null) {
                eVar.l(i2);
                arrayList.add(eVar);
                i2++;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).j();
        }
    }

    public void f(int i2) {
        this.a.j(i2);
    }

    public void g(s sVar) throws IOException {
        OutputStream outputStreamL = sVar.l();
        for (e eVar : this.b) {
            if (eVar != null) {
                eVar.C(outputStreamL);
            }
        }
        outputStreamL.close();
        if (d() != sVar.p()) {
            f(sVar.p());
        }
        this.a.i(b());
    }
}
