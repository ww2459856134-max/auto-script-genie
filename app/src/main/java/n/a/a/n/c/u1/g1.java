package n.a.a.n.c.u1;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class g1 extends k2 {
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2433h;

    /* renamed from: i, reason: collision with root package name */
    private final Object[] f2434i;

    public g1(Object[][] objArr) {
        int length = objArr[0].length;
        int length2 = objArr.length;
        short s = (short) length;
        this.g = s;
        short s2 = (short) length2;
        this.f2433h = s2;
        Object[] objArr2 = new Object[s * s2];
        for (int i2 = 0; i2 < length2; i2++) {
            Object[] objArr3 = objArr[i2];
            for (int i3 = 0; i3 < length; i3++) {
                objArr2[t(i3, i2)] = objArr3[i3];
            }
        }
        this.f2434i = objArr2;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object B() {
        return this.f2434i == null ? "#values#uninitialised#" : o();
    }

    private static String q(Object obj) {
        if (obj == null) {
            throw new IllegalStateException("Array item cannot be null");
        }
        if (obj instanceof String) {
            return "\"" + obj + "\"";
        }
        if (obj instanceof Double) {
            return n.a.a.n.e.c0.h(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "TRUE" : "FALSE";
        }
        if (obj instanceof n.a.a.n.c.q1.c) {
            return ((n.a.a.n.c.q1.c) obj).b();
        }
        throw new IllegalArgumentException("Unexpected constant class (" + obj.getClass().getName() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object v() {
        return Integer.valueOf(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object x() {
        return Integer.valueOf(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object z() {
        return Integer.valueOf(this.f);
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.h("reserved0", new Supplier() { // from class: n.a.a.n.c.u1.m
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.v();
            }
        }, "reserved1", new Supplier() { // from class: n.a.a.n.c.u1.k
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.x();
            }
        }, "reserved2", new Supplier() { // from class: n.a.a.n.c.u1.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.z();
            }
        }, "columnCount", new Supplier() { // from class: n.a.a.n.c.u1.t
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.p());
            }
        }, "rowCount", new Supplier() { // from class: n.a.a.n.c.u1.s
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.r());
            }
        }, "arrayValues", new Supplier() { // from class: n.a.a.n.c.u1.l
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.B();
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return n.a.a.n.c.q1.a.b(this.f2434i) + 11;
    }

    @Override // n.a.a.n.c.u1.k2
    public boolean m() {
        return false;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i2 = 0; i2 < this.f2433h; i2++) {
            if (i2 > 0) {
                sb.append(";");
            }
            for (int i3 = 0; i3 < this.g; i3++) {
                if (i3 > 0) {
                    sb.append(",");
                }
                sb.append(q(this.f2434i[t(i3, i2)]));
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public int p() {
        return this.g;
    }

    public int r() {
        return this.f2433h;
    }

    public Object[][] s() {
        if (this.f2434i == null) {
            throw new IllegalStateException("array values not read yet");
        }
        Object[][] objArr = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f2433h, this.g);
        for (int i2 = 0; i2 < this.f2433h; i2++) {
            Object[] objArr2 = objArr[i2];
            for (int i3 = 0; i3 < this.g; i3++) {
                objArr2[i3] = this.f2434i[t(i3, i2)];
            }
        }
        return objArr;
    }

    int t(int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 >= (i4 = this.g)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Specified colIx (");
            sb.append(i2);
            sb.append(") is outside the allowed range (0..");
            sb.append(this.g - 1);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 >= 0 && i3 < this.f2433h) {
            return (i3 * i4) + i2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Specified rowIx (");
        sb2.append(i3);
        sb2.append(") is outside the allowed range (0..");
        sb2.append(this.f2433h - 1);
        sb2.append(")");
        throw new IllegalArgumentException(sb2.toString());
    }
}
