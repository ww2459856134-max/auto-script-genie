package n.a.a.n.c.s1;

import java.util.Map;

/* loaded from: classes.dex */
public final class d {
    private static d c;
    private static d d;
    private final b[] a;
    private final Map<String, b> b;

    d(b[] bVarArr, Map<String, b> map) {
        this.a = bVarArr == null ? null : (b[]) bVarArr.clone();
        this.b = map;
    }

    public static b a(int i2) {
        return g().c(i2);
    }

    public static b b(int i2) {
        return f().c(i2);
    }

    private b c(int i2) {
        return this.a[i2];
    }

    public static b d(String str) {
        b bVarE = f().e(str);
        return bVarE == null ? g().e(str) : bVarE;
    }

    private b e(String str) {
        return this.b.get(str);
    }

    private static d f() {
        if (c == null) {
            c = c.a();
        }
        return c;
    }

    private static d g() {
        if (d == null) {
            d = c.b();
        }
        return d;
    }

    public static short h(String str) {
        b bVarE = f().e(str);
        if (bVarE == null && (bVarE = g().e(str)) == null) {
            return (short) -1;
        }
        return (short) bVarE.a();
    }
}
