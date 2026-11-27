package n.a.a.n.c.u1;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public abstract class f1 extends f2 implements d1 {

    /* renamed from: h, reason: collision with root package name */
    private static final n.a.a.o.k0 f2430h = n.a.a.o.l0.a(32768);

    /* renamed from: i, reason: collision with root package name */
    private static final n.a.a.o.k0 f2431i = n.a.a.o.l0.a(16384);

    /* renamed from: j, reason: collision with root package name */
    private static final n.a.a.o.k0 f2432j = n.a.a.o.l0.a(16383);
    private int d;
    private int e;
    private int f;
    private int g;

    protected f1(f1 f1Var) {
        super(f1Var);
        this.d = f1Var.d;
        this.e = f1Var.e;
        this.f = f1Var.f;
        this.g = f1Var.g;
    }

    public final void A(int i2) {
        this.g = f2432j.h(this.g, i2);
    }

    public final void B(int i2) {
        this.e = i2;
    }

    public final void C(boolean z) {
        this.g = f2430h.g(this.g, z);
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.i("firstRow", new Supplier() { // from class: n.a.a.n.c.u1.u0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.getFirstRow());
            }
        }, "firstRowRelative", new Supplier() { // from class: n.a.a.n.c.u1.q
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.s());
            }
        }, "firstColumn", new Supplier() { // from class: n.a.a.n.c.u1.f0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.getFirstColumn());
            }
        }, "firstColRelative", new Supplier() { // from class: n.a.a.n.c.u1.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.r());
            }
        }, "lastRow", new Supplier() { // from class: n.a.a.n.c.u1.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.getLastRow());
            }
        }, "lastRowRelative", new Supplier() { // from class: n.a.a.n.c.u1.b0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.u());
            }
        }, "lastColumn", new Supplier() { // from class: n.a.a.n.c.u1.a0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.getLastColumn());
            }
        }, "lastColRelative", new Supplier() { // from class: n.a.a.n.c.u1.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.t());
            }
        }, "formatReference", new Supplier() { // from class: n.a.a.n.c.u1.n0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.q();
            }
        });
    }

    @Override // n.a.a.n.c.u1.d1
    public final int getFirstColumn() {
        return f2432j.d(this.f);
    }

    @Override // n.a.a.n.c.u1.d1
    public final int getFirstRow() {
        return this.d;
    }

    @Override // n.a.a.n.c.u1.d1
    public final int getLastColumn() {
        return f2432j.d(this.g);
    }

    @Override // n.a.a.n.c.u1.d1
    public final int getLastRow() {
        return this.e;
    }

    protected final String q() {
        n.a.a.n.e.s sVar = new n.a.a.n.e.s(getFirstRow(), getFirstColumn(), !s(), !r());
        n.a.a.n.e.s sVar2 = new n.a.a.n.e.s(getLastRow(), getLastColumn(), !u(), !t());
        n.a.a.n.a aVar = n.a.a.n.a.EXCEL97;
        if (n.a.a.n.e.k.i(aVar, sVar, sVar2)) {
            return new n.a.a.n.e.k(sVar, sVar2, aVar).a();
        }
        n.a.a.n.a aVar2 = n.a.a.n.a.EXCEL2007;
        if (n.a.a.n.e.k.i(aVar2, sVar, sVar2)) {
            return new n.a.a.n.e.k(sVar, sVar2, aVar2).a();
        }
        return sVar.g() + ParameterizedMessage.ERROR_MSG_SEPARATOR + sVar2.g();
    }

    public final boolean r() {
        return f2431i.e(this.f);
    }

    public final boolean s() {
        return f2430h.e(this.f);
    }

    public final boolean t() {
        return f2431i.e(this.g);
    }

    public final boolean u() {
        return f2430h.e(this.g);
    }

    public final void v(boolean z) {
        this.f = f2431i.g(this.f, z);
    }

    public final void w(int i2) {
        this.f = f2432j.h(this.f, i2);
    }

    public final void x(int i2) {
        this.d = i2;
    }

    public final void y(boolean z) {
        this.f = f2430h.g(this.f, z);
    }

    public final void z(boolean z) {
        this.g = f2431i.g(this.g, z);
    }

    protected f1(n.a.a.n.e.k kVar) {
        n.a.a.n.e.s sVarB = kVar.b();
        n.a.a.n.e.s sVarC = kVar.c();
        x(sVarB.m());
        w(sVarB.l() == -1 ? (short) 0 : sVarB.l());
        B(sVarC.m());
        A(sVarC.l() == -1 ? (short) 255 : sVarC.l());
        v(!sVarB.o());
        z(!sVarC.o());
        y(!sVarB.r());
        C(!sVarC.r());
    }

    protected f1(int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4) {
        if (i3 >= i2) {
            x(i2);
            B(i3);
            y(z);
            C(z2);
        } else {
            x(i3);
            B(i2);
            y(z2);
            C(z);
        }
        if (i5 >= i4) {
            w(i4);
            A(i5);
            v(z3);
            z(z4);
            return;
        }
        w(i5);
        A(i4);
        v(z4);
        z(z3);
    }
}
