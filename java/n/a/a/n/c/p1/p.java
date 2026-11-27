package n.a.a.n.c.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n.a.a.n.c.r1.m0;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class p implements j6 {
    public static final j6 a = new p(c.a);

    private p(c cVar) {
    }

    private List<w0> a(w0 w0Var, int i2, int i3, boolean z) throws n.a.a.n.c.r1.p {
        if (!(w0Var instanceof n.a.a.n.c.r1.j)) {
            return Collections.singletonList(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
        }
        n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
        ArrayList arrayList = new ArrayList();
        for (int lastRow = z ? jVar.getLastRow() : jVar.getFirstRow(); lastRow <= jVar.getLastRow(); lastRow++) {
            for (int firstColumn = jVar.getFirstColumn(); firstColumn <= jVar.getLastColumn(); firstColumn++) {
                arrayList.add(n.a.a.n.c.r1.z.i(jVar.m(lastRow, firstColumn), lastRow, firstColumn));
            }
        }
        return arrayList;
    }

    private String b(w0 w0Var) {
        return w0Var instanceof n.a.a.n.c.r1.u ? "" : n.a.a.n.c.r1.z.g(w0Var);
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length < 3 || w0VarArr.length > 254) {
            return n.a.a.n.c.r1.o.e;
        }
        int iT = t0Var.t();
        int iK = t0Var.k();
        try {
            List<w0> listA = a(w0VarArr[0], iT, iK, true);
            boolean zBooleanValue = n.a.a.n.c.r1.z.d(n.a.a.n.c.r1.z.i(w0VarArr[1], iT, iK), false).booleanValue();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 2; i2 < w0VarArr.length; i2++) {
                Iterator<w0> it = a(w0VarArr[i2], iT, iK, false).iterator();
                while (it.hasNext()) {
                    String strG = n.a.a.n.c.r1.z.g(it.next());
                    if (!zBooleanValue || (strG != null && !strG.isEmpty())) {
                        arrayList.add(strG);
                    }
                }
            }
            if (listA.isEmpty()) {
                return new m0(defpackage.g.a("", arrayList));
            }
            if (listA.size() == 1) {
                return new m0(defpackage.g.a(b(listA.get(0)), arrayList));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<w0> it2 = listA.iterator();
            while (it2.hasNext()) {
                arrayList2.add(b(it2.next()));
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 > 0) {
                    sb.append((String) arrayList2.get((i3 - 1) % arrayList2.size()));
                }
                sb.append((String) arrayList.get(i3));
            }
            return new m0(sb.toString());
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
