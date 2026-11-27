package n.a.a.n.c.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class va implements p6 {
    private static p6 a(int i2) throws n.a.a.n.c.r1.p {
        switch (i2) {
            case 1:
                return v2.p(v2.g, true);
            case 2:
                return x3.c(true);
            case 3:
                return d4.c(true);
            case 4:
                return v2.p(v2.f2402k, true);
            case 5:
                return v2.p(v2.f2404m, true);
            case 6:
                return v2.p(v2.f2406o, true);
            case 7:
                return v2.p(v2.q, true);
            case 8:
                return v2.p(v2.r, true);
            case 9:
                return v2.p(v2.u, true);
            case 10:
                return v2.p(v2.w, true);
            case 11:
                return v2.p(v2.x, true);
            default:
                switch (i2) {
                    case 101:
                        return v2.p(v2.g, false);
                    case 102:
                        return x3.c(false);
                    case 103:
                        return d4.c(false);
                    case 104:
                        return v2.p(v2.f2402k, false);
                    case 105:
                        return v2.p(v2.f2404m, false);
                    case 106:
                        return v2.p(v2.f2406o, false);
                    case 107:
                        return v2.p(v2.q, false);
                    case 108:
                        return v2.p(v2.r, false);
                    case 109:
                        return v2.p(v2.u, false);
                    case 110:
                        return v2.p(v2.w, false);
                    case 111:
                        return v2.p(v2.x, false);
                    default:
                        throw n.a.a.n.c.r1.p.c();
                }
        }
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length - 1 < 1) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            int iF = n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0VarArr[0], i2, i3));
            p6 p6VarA = a(iF);
            ArrayList arrayList = new ArrayList(Arrays.asList(w0VarArr).subList(1, w0VarArr.length));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                n.a.a.n.c.r1.w0 w0Var = (n.a.a.n.c.r1.w0) it.next();
                if (w0Var instanceof n.a.a.n.c.o0) {
                    n.a.a.n.c.o0 o0Var = (n.a.a.n.c.o0) w0Var;
                    if (o0Var.w()) {
                        it.remove();
                    }
                    if (iF > 100 && o0Var.v()) {
                        it.remove();
                    }
                }
            }
            return p6VarA.k((n.a.a.n.c.r1.w0[]) arrayList.toArray(new n.a.a.n.c.r1.w0[0]), i2, i3);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
