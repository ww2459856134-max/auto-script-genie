package n.a.a.n.c.t1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class n8 {
    private static final Map<Integer, d8> a;
    private static final Map<Integer, g8> b;

    static {
        HashMap map = new HashMap();
        for (d8 d8Var : d8.values()) {
            map.put(Integer.valueOf(d8Var.a()), d8Var);
        }
        a = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        for (g8 g8Var : g8.values()) {
            map2.put(Integer.valueOf(g8Var.a()), g8Var);
        }
        b = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(b8 b8Var, m8 m8Var, d8 d8Var, boolean z) {
        HashSet hashSet = new HashSet();
        x7 x7Var = new x7(m8Var.getSize());
        int i2 = -1;
        n.a.a.n.c.r1.w0 w0Var = null;
        while (true) {
            int iC = x7Var.c();
            if (iC < 0 || hashSet.contains(Integer.valueOf(iC))) {
                break;
            }
            hashSet.add(Integer.valueOf(iC));
            n.a.a.n.c.r1.w0 item = m8Var.getItem(iC);
            a8 a8VarA = b8Var.a(item);
            if (a8VarA.b()) {
                return iC;
            }
            int i3 = w7.a[d8Var.ordinal()];
            if (i3 == 1 ? !(!a8VarA.d() || (w0Var != null && !e(item, true, true).a(w0Var).d())) : !(i3 != 2 || !a8VarA.c() || (w0Var != null && !e(item, true, true).a(w0Var).c()))) {
                i2 = iC;
                w0Var = item;
            }
            if (a8VarA.e()) {
                int i4 = i(b8Var, m8Var, x7Var, iC, z);
                if (i4 >= 0) {
                    return i4;
                }
            } else if (z) {
                x7Var.d(iC, a8VarA.c());
            } else {
                x7Var.d(iC, a8VarA.d());
            }
        }
    }

    public static m8 b(n.a.a.n.c.j1 j1Var, int i2) {
        return new z7(j1Var, i2);
    }

    static b8 c(n.a.a.n.c.r1.w0 w0Var, boolean z, boolean z2) {
        if (w0Var == n.a.a.n.c.r1.l.a) {
            return new e8(n.a.a.n.c.r1.x.c);
        }
        if (w0Var instanceof n.a.a.n.c.r1.m0) {
            return new i8((n.a.a.n.c.r1.m0) w0Var, z, z2);
        }
        if (w0Var instanceof n.a.a.n.c.r1.x) {
            return new e8((n.a.a.n.c.r1.x) w0Var);
        }
        if (w0Var instanceof n.a.a.n.c.r1.m) {
            return new y7((n.a.a.n.c.r1.m) w0Var);
        }
        throw new IllegalArgumentException("Bad lookup value type (" + w0Var.getClass().getName() + ")");
    }

    public static m8 d(n.a.a.n.c.j1 j1Var, int i2) {
        return new f8(j1Var, i2);
    }

    private static b8 e(n.a.a.n.c.r1.w0 w0Var, boolean z, boolean z2) {
        return w0Var == n.a.a.n.c.r1.l.a ? new j8(new n.a.a.n.c.r1.m0(""), z, z2) : w0Var instanceof n.a.a.n.c.r1.m ? new y7((n.a.a.n.c.r1.m) w0Var) : (z && (w0Var instanceof n.a.a.n.c.r1.x)) ? new e8((n.a.a.n.c.r1.x) w0Var) : new j8(w0Var, z, z2);
    }

    public static m8 f(n.a.a.n.c.j1 j1Var) {
        if (j1Var.s()) {
            return b(j1Var, 0);
        }
        if (j1Var.q()) {
            return d(j1Var, 0);
        }
        return null;
    }

    public static m8 g(n.a.a.n.c.r1.c0 c0Var) {
        return new h8(c0Var);
    }

    private static int h(b8 b8Var, m8 m8Var, int i2, int i3) {
        do {
            i2++;
            if (i2 >= i3) {
                return i3 - 1;
            }
        } while (b8Var.a(m8Var.getItem(i2)).b());
        return i2 - 1;
    }

    private static int i(b8 b8Var, m8 m8Var, x7 x7Var, int i2, boolean z) {
        a8 a8VarA;
        int iA = x7Var.a();
        int i3 = i2;
        do {
            i3++;
            if (i3 == iA) {
                x7Var.d(i2, true);
                return -1;
            }
            a8VarA = b8Var.a(m8Var.getItem(i3));
            if (a8VarA.d() && !z && i3 == iA - 1) {
                x7Var.d(i2, true);
                return -1;
            }
            if (a8VarA.c() && z && i3 == iA - 1) {
                x7Var.d(i2, true);
                return -1;
            }
        } while (a8VarA.e());
        if (a8VarA.b()) {
            return i3;
        }
        if (z) {
            x7Var.d(i3, a8VarA.c());
        } else {
            x7Var.d(i3, a8VarA.d());
        }
        return -1;
    }

    public static int j(n.a.a.n.c.r1.w0 w0Var, m8 m8Var, boolean z) throws n.a.a.n.c.r1.p {
        b8 b8VarC = c(w0Var, z, false);
        int iO = z ? o(m8Var, b8VarC) : k(b8VarC, m8Var, d8.ExactMatch);
        if (iO >= 0) {
            return iO;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
    }

    private static int k(b8 b8Var, m8 m8Var, d8 d8Var) {
        return l(b8Var, m8Var, d8Var, false);
    }

    private static int l(b8 b8Var, m8 m8Var, d8 d8Var, boolean z) {
        Iterator<Integer> itB = z ? m8Var.b() : m8Var.a();
        int i2 = -1;
        n.a.a.n.c.r1.w0 w0Var = null;
        while (itB.hasNext()) {
            int iIntValue = itB.next().intValue();
            n.a.a.n.c.r1.w0 item = m8Var.getItem(iIntValue);
            a8 a8VarA = b8Var.a(item);
            if (a8VarA.b()) {
                return iIntValue;
            }
            int i3 = w7.a[d8Var.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && a8VarA.c() && (w0Var == null || e(item, true, true).a(w0Var).c())) {
                    i2 = iIntValue;
                    w0Var = item;
                }
            } else if (a8VarA.d() && (w0Var == null || e(item, true, true).a(w0Var).d())) {
                i2 = iIntValue;
                w0Var = item;
            }
        }
        return i2;
    }

    private static int m(b8 b8Var, m8 m8Var, d8 d8Var) {
        return l(b8Var, m8Var, d8Var, true);
    }

    public static d8 n(int i2) {
        d8 d8Var = a.get(Integer.valueOf(i2));
        if (d8Var != null) {
            return d8Var;
        }
        throw new IllegalArgumentException("unknown match mode " + i2);
    }

    private static int o(m8 m8Var, b8 b8Var) {
        x7 x7Var = new x7(m8Var.getSize());
        while (true) {
            int iC = x7Var.c();
            if (iC < 0) {
                return x7Var.b();
            }
            a8 a8VarA = b8Var.a(m8Var.getItem(iC));
            if (a8VarA.e()) {
                iC = i(b8Var, m8Var, x7Var, iC, false);
                if (iC < 0) {
                    continue;
                } else {
                    a8VarA = b8Var.a(m8Var.getItem(iC));
                }
            }
            if (a8VarA.b()) {
                return h(b8Var, m8Var, iC, x7Var.a());
            }
            x7Var.d(iC, a8VarA.d());
        }
    }

    public static boolean p(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
        if (w0VarI == n.a.a.n.c.r1.u.a || (w0VarI instanceof n.a.a.n.c.r1.l)) {
            return false;
        }
        if (w0VarI instanceof n.a.a.n.c.r1.m) {
            return ((n.a.a.n.c.r1.m) w0VarI).u();
        }
        if (w0VarI instanceof n.a.a.n.c.r1.m0) {
            String stringValue = ((n.a.a.n.c.r1.m0) w0VarI).getStringValue();
            if (stringValue.isEmpty()) {
                throw n.a.a.n.c.r1.p.c();
            }
            Boolean boolP = l4.p(stringValue);
            if (boolP != null) {
                return boolP.booleanValue();
            }
            throw n.a.a.n.c.r1.p.c();
        }
        if (w0VarI instanceof n.a.a.n.c.r1.y) {
            return 0.0d != ((n.a.a.n.c.r1.y) w0VarI).r();
        }
        throw new IllegalStateException("Unexpected eval type (" + w0VarI + ")");
    }

    public static int q(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (w0Var == null) {
            throw new IllegalArgumentException("argument must not be null");
        }
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, (short) i3);
            if ((w0VarI instanceof n.a.a.n.c.r1.m0) && n.a.a.n.c.r1.z.k(((n.a.a.n.c.r1.m0) w0VarI).getStringValue()) == null) {
                throw n.a.a.n.c.r1.p.b();
            }
            int iF = n.a.a.n.c.r1.z.f(w0VarI);
            if (iF >= 1) {
                return iF - 1;
            }
            throw n.a.a.n.c.r1.p.c();
        } catch (n.a.a.n.c.r1.p unused) {
            throw n.a.a.n.c.r1.p.b();
        }
    }

    public static n.a.a.n.c.j1 r(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.j1) {
            return (n.a.a.n.c.j1) w0Var;
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return ((n.a.a.n.c.r1.c0) w0Var).c(0, 0, 0, 0);
        }
        throw n.a.a.n.c.r1.p.c();
    }

    public static g8 s(int i2) {
        g8 g8Var = b.get(Integer.valueOf(i2));
        if (g8Var != null) {
            return g8Var;
        }
        throw new IllegalArgumentException("unknown search mode " + i2);
    }

    public static int t(n.a.a.n.c.r1.w0 w0Var, m8 m8Var, d8 d8Var, g8 g8Var) throws n.a.a.n.c.r1.p {
        if ((w0Var instanceof n.a.a.n.c.r1.m0) && (d8Var == d8.ExactMatchFallbackToLargerValue || d8Var == d8.ExactMatchFallbackToSmallerValue)) {
            String stringValue = ((n.a.a.n.c.r1.m0) w0Var).getStringValue();
            StringBuilder sb = new StringBuilder(stringValue.length());
            boolean z = false;
            for (char c : stringValue.toCharArray()) {
                if (c == '*' || c == '?' || c == '~') {
                    z = true;
                } else {
                    sb.append(c);
                }
                if (z) {
                    break;
                }
            }
            if (z) {
                w0Var = new n.a.a.n.c.r1.m0(sb.toString());
            }
        }
        b8 b8VarE = e(w0Var, d8Var != d8.WildcardMatch, true);
        int iA = g8Var == g8.BinarySearchForward ? a(b8VarE, m8Var, d8Var, false) : g8Var == g8.BinarySearchBackward ? a(b8VarE, m8Var, d8Var, true) : g8Var == g8.IterateBackward ? m(b8VarE, m8Var, d8Var) : k(b8VarE, m8Var, d8Var);
        if (iA >= 0) {
            return iA;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
    }
}
