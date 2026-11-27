package k.x;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class n0 {
    private static k.y.c g = k.y.c.b(n0.class);
    private j0 e;
    private v0 f;
    private ArrayList c = new ArrayList(10);
    private HashMap a = new HashMap(10);
    private ArrayList b = new ArrayList(10);
    private int d = 164;

    public n0(j0 j0Var) {
        this.e = j0Var;
    }

    public final void a(b0 b0Var) throws u0 {
        if (b0Var.isInitialized() && b0Var.m() >= 441) {
            g.f("Format index exceeds Excel maximum - assigning custom number");
            b0Var.f(this.d);
            this.d++;
        }
        if (!b0Var.isInitialized()) {
            b0Var.f(this.d);
            this.d++;
        }
        if (this.d > 441) {
            this.d = 441;
            throw new u0();
        }
        if (b0Var.m() >= this.d) {
            this.d = b0Var.m() + 1;
        }
        if (b0Var.r()) {
            return;
        }
        this.b.add(b0Var);
        this.a.put(new Integer(b0Var.m()), b0Var);
    }

    public final void b(h1 h1Var) throws u0 {
        if (!h1Var.isInitialized()) {
            h1Var.K(this.c.size(), this, this.e);
            this.c.add(h1Var);
        } else if (h1Var.I() >= this.c.size()) {
            this.c.add(h1Var);
        }
    }

    public final DateFormat c(int i2) {
        h1 h1Var = (h1) this.c.get(i2);
        if (h1Var.M()) {
            return h1Var.C();
        }
        m0 m0Var = (m0) this.a.get(new Integer(h1Var.E()));
        if (m0Var != null && m0Var.C()) {
            return m0Var.A();
        }
        return null;
    }

    protected final j0 d() {
        return this.e;
    }

    m0 e(int i2) {
        return (m0) this.a.get(new Integer(i2));
    }

    public final NumberFormat f(int i2) {
        h1 h1Var = (h1) this.c.get(i2);
        if (h1Var.N()) {
            return h1Var.H();
        }
        m0 m0Var = (m0) this.a.get(new Integer(h1Var.E()));
        if (m0Var != null && m0Var.D()) {
            return m0Var.B();
        }
        return null;
    }

    public v0 g() {
        return this.f;
    }

    public final h1 h(int i2) {
        return (h1) this.c.get(i2);
    }

    public final boolean i(int i2) {
        h1 h1Var = (h1) this.c.get(i2);
        if (h1Var.M()) {
            return true;
        }
        m0 m0Var = (m0) this.a.get(new Integer(h1Var.E()));
        if (m0Var == null) {
            return false;
        }
        return m0Var.C();
    }

    public r0 j(r0 r0Var, r0 r0Var2) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            h1 h1Var = (h1) it.next();
            if (h1Var.E() >= 164) {
                h1Var.S(r0Var2.a(h1Var.E()));
            }
            h1Var.R(r0Var.a(h1Var.D()));
        }
        ArrayList arrayList = new ArrayList(21);
        r0 r0Var3 = new r0(this.c.size());
        int iMin = Math.min(21, this.c.size());
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(this.c.get(i2));
            r0Var3.b(i2, i2);
        }
        if (iMin < 21) {
            g.f("There are less than the expected minimum number of XF records");
            return r0Var3;
        }
        int i3 = 0;
        for (int i4 = 21; i4 < this.c.size(); i4++) {
            h1 h1Var2 = (h1) this.c.get(i4);
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext() && !z) {
                h1 h1Var3 = (h1) it2.next();
                if (h1Var3.equals(h1Var2)) {
                    r0Var3.b(i4, r0Var3.a(h1Var3.I()));
                    i3++;
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(h1Var2);
                r0Var3.b(i4, i4 - i3);
            }
        }
        Iterator it3 = this.c.iterator();
        while (it3.hasNext()) {
            ((h1) it3.next()).P(r0Var3);
        }
        this.c = arrayList;
        return r0Var3;
    }

    public r0 k() {
        ArrayList arrayList = new ArrayList();
        r0 r0Var = new r0(this.d);
        Iterator it = this.b.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            b0 b0Var = (b0) it.next();
            k.y.a.a(!b0Var.r());
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext() && !z) {
                b0 b0Var2 = (b0) it2.next();
                if (b0Var2.equals(b0Var)) {
                    r0Var.b(b0Var.m(), r0Var.a(b0Var2.m()));
                    i2++;
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(b0Var);
                if (b0Var.m() - i2 > 441) {
                    g.f("Too many number formats - using default format.");
                }
                r0Var.b(b0Var.m(), b0Var.m() - i2);
            }
        }
        this.b = arrayList;
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            b0 b0Var3 = (b0) it3.next();
            b0Var3.f(r0Var.a(b0Var3.m()));
        }
        return r0Var;
    }

    public r0 l() {
        return this.e.c();
    }

    public void m(v0 v0Var) {
        this.f = v0Var;
    }

    public void n(k.b0.v.l0 l0Var) throws IOException {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            l0Var.e((m0) it.next());
        }
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            l0Var.e((h1) it2.next());
        }
        l0Var.e(new j(16, 3));
        l0Var.e(new j(17, 6));
        l0Var.e(new j(18, 4));
        l0Var.e(new j(19, 7));
        l0Var.e(new j(0, 0));
        l0Var.e(new j(20, 5));
    }
}
