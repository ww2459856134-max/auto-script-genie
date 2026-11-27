package n.a.a.n.c.u1;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public abstract class y0 extends g2 {
    private final byte d;
    private final byte[] e;
    private final int f;
    private final short g;

    protected y0(int i2, int i3, byte[] bArr, int i4) {
        this.f = i4;
        if (i2 < -32768 || i2 > 32767) {
            throw new IllegalStateException("functionIndex " + i2 + " cannot be cast to short");
        }
        this.g = (short) i2;
        if (i3 >= -128 && i3 <= 127) {
            this.d = (byte) i3;
            this.e = bArr;
        } else {
            throw new IllegalStateException("pReturnClass " + i3 + " cannot be cast to byte");
        }
    }

    private static void r(StringBuilder sb, int i2, String[] strArr) {
        sb.append('(');
        for (int i3 = i2; i3 < strArr.length; i3++) {
            if (i3 > i2) {
                sb.append(',');
            }
            sb.append(strArr[i3]);
        }
        sb.append(")");
    }

    public static boolean w(String str) {
        return n.a.a.n.c.s1.d.h(str.toUpperCase(Locale.ROOT)) >= 0;
    }

    protected static short y(String str) {
        short sH = n.a.a.n.c.s1.d.h(str.toUpperCase(Locale.ROOT));
        if (sH < 0) {
            return (short) 255;
        }
        return sH;
    }

    protected final String A(short s, boolean z) {
        if (s == 255) {
            return "#external#";
        }
        n.a.a.n.c.s1.b bVarA = z ? n.a.a.n.c.s1.d.a(s) : n.a.a.n.c.s1.d.b(s);
        if (bVarA != null) {
            return bVarA.d();
        }
        throw new IllegalStateException("bad function index (" + ((int) s) + ", " + z + ")");
    }

    @Override // n.a.a.n.c.u1.g2, n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.g("functionIndex", new Supplier() { // from class: n.a.a.n.c.u1.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Short.valueOf(this.a.t());
            }
        }, "functionName", new Supplier() { // from class: n.a.a.n.c.u1.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.u();
            }
        }, "numberOfOperands", new Supplier() { // from class: n.a.a.n.c.u1.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.p());
            }
        }, "externalFunction", new Supplier() { // from class: n.a.a.n.c.u1.x0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.x());
            }
        }, "defaultOperandClass", new Supplier() { // from class: n.a.a.n.c.u1.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Byte.valueOf(this.a.s());
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public final boolean m() {
        return false;
    }

    @Override // n.a.a.n.c.u1.k2
    public final String o() {
        return u();
    }

    @Override // n.a.a.n.c.u1.g2
    public final int p() {
        return this.f;
    }

    @Override // n.a.a.n.c.u1.g2
    public String q(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (x()) {
            sb.append(strArr[0]);
            r(sb, 1, strArr);
        } else {
            sb.append(u());
            r(sb, 0, strArr);
        }
        return sb.toString();
    }

    public byte s() {
        return this.d;
    }

    public final short t() {
        return this.g;
    }

    public final String u() {
        return z(this.g);
    }

    public final byte v(int i2) {
        byte[] bArr = this.e;
        return i2 >= bArr.length ? bArr[bArr.length - 1] : bArr[i2];
    }

    public final boolean x() {
        return this.g == 255;
    }

    protected String z(short s) {
        return A(s, false);
    }
}
