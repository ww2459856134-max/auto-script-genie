package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class n1 implements n.a.a.n.c.o {
    private final i2 a;
    private Map<m1, n.a.a.n.c.l> b;

    public n1(i2 i2Var) {
        this.a = i2Var;
    }

    @Override // n.a.a.n.c.o
    public n.a.a.n.c.l a(int i2, int i3) {
        z0 z0VarX;
        if (i2 > d()) {
            return null;
        }
        if (this.b == null) {
            this.b = new HashMap(this.a.d() * 3);
            for (n.a.a.n.d.o0 o0Var : this.a) {
                int iQ = o0Var.q();
                for (n.a.a.n.d.e eVar : o0Var) {
                    this.b.put(new m1(iQ, eVar.i()), new l1((z0) eVar, this));
                }
            }
        }
        m1 m1Var = new m1(i2, i3);
        n.a.a.n.c.l lVar = this.b.get(m1Var);
        if (lVar != null) {
            return lVar;
        }
        f2 f2VarF = this.a.f(i2);
        if (f2VarF == null || (z0VarX = f2VarF.x(i3)) == null) {
            return null;
        }
        l1 l1Var = new l1(z0VarX, this);
        this.b.put(m1Var, l1Var);
        return l1Var;
    }

    public i2 b() {
        return this.a;
    }

    @Override // n.a.a.n.c.o
    public int d() {
        return this.a.d();
    }

    @Override // n.a.a.n.c.o
    public boolean e(int i2) {
        f2 f2VarF = this.a.f(i2);
        if (f2VarF == null) {
            return false;
        }
        return f2VarF.t();
    }
}
