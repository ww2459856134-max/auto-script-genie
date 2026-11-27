package n.a.a.n.d;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
public final class l {
    public static final l f;
    public static final l g;
    private final j a;
    private final double b;
    private final boolean c;
    private final String d;
    private final int e;

    static {
        j jVar = j.BOOLEAN;
        f = new l(jVar, 0.0d, true, null, 0);
        g = new l(jVar, 0.0d, false, null, 0);
    }

    private l(j jVar, double d, boolean z, String str, int i2) {
        this.a = jVar;
        this.b = d;
        this.c = z;
        this.d = str;
        this.e = i2;
    }

    public static l d(int i2) {
        return new l(j.ERROR, 0.0d, false, null, i2);
    }

    public static l h(boolean z) {
        return z ? f : g;
    }

    public String a() {
        int i2 = k.a[this.a.ordinal()];
        if (i2 == 1) {
            return String.valueOf(this.b);
        }
        if (i2 == 2) {
            return Chars.DQUOTE + this.d + Chars.DQUOTE;
        }
        if (i2 == 3) {
            return this.c ? "TRUE" : "FALSE";
        }
        if (i2 == 4) {
            return n.a.a.n.c.r1.o.v(this.e);
        }
        return "<error unexpected cell type " + this.a + ">";
    }

    public boolean b() {
        return this.c;
    }

    public j c() {
        return this.a;
    }

    public byte e() {
        return (byte) this.e;
    }

    public double f() {
        return this.b;
    }

    public String g() {
        return this.d;
    }

    public String toString() {
        return l.class.getName() + " [" + a() + "]";
    }

    public l(double d) {
        this(j.NUMERIC, d, false, null, 0);
    }

    public l(String str) {
        this(j.STRING, 0.0d, false, str, 0);
    }
}
