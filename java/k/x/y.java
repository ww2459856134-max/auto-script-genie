package k.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class y {

    /* renamed from: h, reason: collision with root package name */
    private static k.y.c f2171h = k.y.c.b(y.class);
    private z a;
    private ArrayList b;
    private a1 c;
    private k.x.j1.t d;
    private k.w e;
    private int f;
    private boolean g;

    public y(z zVar) {
        this.a = zVar;
        this.b = new ArrayList(this.a.C());
        this.g = false;
    }

    public void a(a0 a0Var) {
        this.b.add(a0Var);
        a0Var.G(this);
        if (this.g) {
            k.y.a.a(this.a != null);
            this.a.A();
        }
    }

    public int b() {
        return this.f;
    }

    public z c() {
        return this.a;
    }

    public a0[] d() {
        return (a0[]) this.b.toArray(new a0[0]);
    }

    public void e(int i2, int i3) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a0 a0Var = (a0) it.next();
            if (a0Var.B() == i2 && a0Var.D() == i2 && a0Var.C() == i3 && a0Var.E() == i3) {
                it.remove();
                this.a.B();
                return;
            }
        }
    }

    public void f(k.b0.v.l0 l0Var) throws IOException {
        if (this.b.size() > 65533) {
            f2171h.f("Maximum number of data validations exceeded - truncating...");
            ArrayList arrayList = new ArrayList(this.b.subList(0, 65532));
            this.b = arrayList;
            k.y.a.a(arrayList.size() <= 65533);
        }
        if (this.a == null) {
            this.a = new z(new x(this.f, this.b.size()));
        }
        if (this.a.E()) {
            l0Var.e(this.a);
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                l0Var.e((a0) it.next());
            }
        }
    }

    public y(int i2, k.x.j1.t tVar, a1 a1Var, k.w wVar) {
        this.c = a1Var;
        this.d = tVar;
        this.e = wVar;
        this.b = new ArrayList();
        this.f = i2;
        this.g = false;
    }

    public y(y yVar, k.x.j1.t tVar, a1 a1Var, k.w wVar) {
        this.c = a1Var;
        this.d = tVar;
        this.e = wVar;
        this.g = true;
        this.a = new z(yVar.c());
        this.b = new ArrayList();
        for (a0 a0Var : yVar.d()) {
            this.b.add(new a0(a0Var, this.d, this.c, this.e));
        }
    }
}
