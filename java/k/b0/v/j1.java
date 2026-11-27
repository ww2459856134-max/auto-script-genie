package k.b0.v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class j1 {
    private static k.y.c c = k.y.c.b(j1.class);
    private ArrayList a = new ArrayList();
    private k.b0.s b;

    public j1(k.b0.s sVar) {
        this.b = sVar;
    }

    private void b() {
        ArrayList arrayList = new ArrayList(this.a.size());
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            k.x.x0 x0Var = (k.x.x0) it.next();
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext() && !z) {
                if (((k.x.x0) it2.next()).a(x0Var)) {
                    c.f("Could not merge cells " + x0Var + " as they clash with an existing set of merged cells.");
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(x0Var);
            }
        }
        this.a = arrayList;
    }

    private void c() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            try {
                k.x.x0 x0Var = (k.x.x0) this.a.get(i2);
                k.c topLeft = x0Var.getTopLeft();
                k.c bottomRight = x0Var.getBottomRight();
                boolean z = false;
                for (int iB = topLeft.b(); iB <= bottomRight.b(); iB++) {
                    for (int row = topLeft.getRow(); row <= bottomRight.getRow(); row++) {
                        if (this.b.a(iB, row).getType() != k.f.b) {
                            if (z) {
                                c.f("Range " + x0Var + " contains more than one data cell.  Setting the other cells to blank.");
                                this.b.c(new k.b0.a(iB, row));
                            } else {
                                z = true;
                            }
                        }
                    }
                }
            } catch (k.b0.u unused) {
                k.y.a.a(false);
                return;
            }
        }
    }

    void a(k.r rVar) {
        this.a.add(rVar);
    }

    k.r[] d() {
        int size = this.a.size();
        k.r[] rVarArr = new k.r[size];
        for (int i2 = 0; i2 < size; i2++) {
            rVarArr[i2] = (k.r) this.a.get(i2);
        }
        return rVarArr;
    }

    void e(l0 l0Var) throws IOException {
        if (this.a.size() == 0) {
            return;
        }
        if (!((p3) this.b).p().o()) {
            b();
            c();
        }
        if (this.a.size() < 1020) {
            l0Var.e(new k1(this.a));
            return;
        }
        int size = (this.a.size() / 1020) + 1;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int iMin = Math.min(1020, this.a.size() - i2);
            ArrayList arrayList = new ArrayList(iMin);
            for (int i4 = 0; i4 < iMin; i4++) {
                arrayList.add(this.a.get(i2 + i4));
            }
            l0Var.e(new k1(arrayList));
            i2 += iMin;
        }
    }
}
