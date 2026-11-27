package h.p.a.a;

import android.graphics.Path;

/* loaded from: classes.dex */
abstract class r extends q {
    protected h.e.d.d[] a;
    String b;
    int c;
    int d;

    public r() {
        super();
        this.a = null;
        this.c = 0;
    }

    public boolean c() {
        return false;
    }

    public void d(Path path) {
        path.reset();
        h.e.d.d[] dVarArr = this.a;
        if (dVarArr != null) {
            h.e.d.d.e(dVarArr, path);
        }
    }

    public h.e.d.d[] getPathData() {
        return this.a;
    }

    public String getPathName() {
        return this.b;
    }

    public void setPathData(h.e.d.d[] dVarArr) {
        if (h.e.d.e.b(this.a, dVarArr)) {
            h.e.d.e.j(this.a, dVarArr);
        } else {
            this.a = h.e.d.e.f(dVarArr);
        }
    }

    public r(r rVar) {
        super();
        this.a = null;
        this.c = 0;
        this.b = rVar.b;
        this.d = rVar.d;
        this.a = h.e.d.e.f(rVar.a);
    }
}
