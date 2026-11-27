package n.a.a.n.c.u1;

import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class c2 extends f2 implements m2 {
    private int d;
    private String e;
    private String f;

    public c2(int i2, String str, String str2) {
        this.d = -1;
        this.d = i2;
        this.e = str;
        this.f = str2;
    }

    @Override // n.a.a.n.c.u1.m2
    public String c() {
        return this.e;
    }

    @Override // n.a.a.n.c.u1.m2
    public void d(String str) {
        this.e = str;
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.e("externalWorkbookNumber", new Supplier() { // from class: n.a.a.n.c.u1.x
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.f());
            }
        }, "sheetName", new Supplier() { // from class: n.a.a.n.c.u1.v0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.c();
            }
        }, "nameName", new Supplier() { // from class: n.a.a.n.c.u1.j0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.r();
            }
        });
    }

    @Override // n.a.a.n.c.u1.m2
    public int f() {
        return this.d;
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 1;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        boolean z;
        StringBuilder sb = new StringBuilder(64);
        boolean z2 = true;
        if (this.d >= 0) {
            sb.append('[');
            sb.append(this.d);
            sb.append(']');
            z = true;
        } else {
            z = false;
        }
        String str = this.e;
        if (str != null) {
            n.a.a.n.c.c1.b(sb, str);
        } else {
            z2 = z;
        }
        if (z2) {
            sb.append('!');
        }
        sb.append(this.f);
        return sb.toString();
    }

    @Override // n.a.a.n.c.u1.f2
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public c2 p() {
        return new c2(this);
    }

    public String r() {
        return this.f;
    }

    public c2(c2 c2Var) {
        super(c2Var);
        this.d = -1;
        this.d = c2Var.d;
        this.e = c2Var.e;
        this.f = c2Var.f;
    }

    public c2(String str, String str2) {
        this(-1, str, str2);
    }

    public c2(String str) {
        this(-1, null, str);
    }
}
