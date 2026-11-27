package n.a.a.n.e;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import n.a.a.o.v0;

/* JADX WARN: Unexpected interfaces in signature: [n.a.a.e.a.a] */
/* loaded from: classes.dex */
public abstract class o implements Iterable<l>, Object {
    private int c;
    private int d;
    private int e;
    private int f;

    protected o(int i2, int i3, int i4, int i5) {
        this.c = i2;
        this.e = i3;
        this.d = i4;
        this.f = i5;
    }

    public boolean A(n.a.a.n.d.e eVar) {
        return z(eVar.g(), eVar.i());
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.c;
    }

    public Map<String, Supplier<?>> e() {
        return v0.f("firstRow", new Supplier() { // from class: n.a.a.n.e.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.b());
            }
        }, "firstCol", new Supplier() { // from class: n.a.a.n.e.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.a());
            }
        }, "lastRow", new Supplier() { // from class: n.a.a.n.e.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.k());
            }
        }, "lastCol", new Supplier() { // from class: n.a.a.n.e.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.g());
            }
        });
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return t() == oVar.t() && p() == oVar.p() && r() == oVar.r() && l() == oVar.l();
    }

    public final int g() {
        return this.f;
    }

    public int hashCode() {
        return r() + (l() << 8) + (t() << 16) + (p() << 24);
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return new n(this);
    }

    public final int k() {
        return this.e;
    }

    protected int l() {
        return Math.max(this.d, this.f);
    }

    protected int p() {
        return Math.max(this.c, this.e);
    }

    protected int r() {
        return Math.min(this.d, this.f);
    }

    @Override // java.lang.Iterable
    public Spliterator<l> spliterator() {
        return Spliterators.spliterator(iterator(), u(), 0);
    }

    protected int t() {
        return Math.min(this.c, this.e);
    }

    public final String toString() {
        return getClass().getName() + " [" + new l(this.c, this.d).b() + ParameterizedMessage.ERROR_MSG_SEPARATOR + new l(this.e, this.f).b() + "]";
    }

    public int u() {
        return ((this.e - this.c) + 1) * ((this.f - this.d) + 1);
    }

    public final boolean v() {
        return (this.c == 0 && this.e == n.a.a.n.a.EXCEL97.c()) || (this.c == -1 && this.e == -1);
    }

    public final boolean w() {
        return (this.d == 0 && this.f == n.a.a.n.a.EXCEL97.a()) || (this.d == -1 && this.f == -1);
    }

    public boolean z(int i2, int i3) {
        return this.c <= i2 && i2 <= this.e && this.d <= i3 && i3 <= this.f;
    }
}
