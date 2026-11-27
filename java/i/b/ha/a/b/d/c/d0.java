package i.b.ha.a.b.d.c;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public abstract class d0 {
    private static final ConcurrentMap<l2, Supplier<a2>> a;
    static final a2[] b;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        a = concurrentHashMap;
        concurrentHashMap.put(w.f1443i, new Supplier() { // from class: i.b.ha.a.b.d.c.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return new w();
            }
        });
        concurrentHashMap.put(d1.f1404j, new Supplier() { // from class: i.b.ha.a.b.d.c.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return new d1();
            }
        });
        concurrentHashMap.put(e1.f, new Supplier() { // from class: i.b.ha.a.b.d.c.k
            @Override // java.util.function.Supplier
            public final Object get() {
                return new e1();
            }
        });
        concurrentHashMap.put(g0.c, new Supplier() { // from class: i.b.ha.a.b.d.c.p
            @Override // java.util.function.Supplier
            public final Object get() {
                return new g0();
            }
        });
        concurrentHashMap.put(q0.f, new Supplier() { // from class: i.b.ha.a.b.d.c.r
            @Override // java.util.function.Supplier
            public final Object get() {
                return new q0();
            }
        });
        concurrentHashMap.put(p0.f, new Supplier() { // from class: i.b.ha.a.b.d.c.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return new p0();
            }
        });
        concurrentHashMap.put(f1.f1410h, new Supplier() { // from class: i.b.ha.a.b.d.c.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return new f1();
            }
        });
        concurrentHashMap.put(x0.f, new Supplier() { // from class: i.b.ha.a.b.d.c.u
            @Override // java.util.function.Supplier
            public final Object get() {
                return new x0();
            }
        });
        concurrentHashMap.put(y0.f, new Supplier() { // from class: i.b.ha.a.b.d.c.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return new y0();
            }
        });
        concurrentHashMap.put(z0.f, new Supplier() { // from class: i.b.ha.a.b.d.c.s
            @Override // java.util.function.Supplier
            public final Object get() {
                return new z0();
            }
        });
        concurrentHashMap.put(a1.f, new Supplier() { // from class: i.b.ha.a.b.d.c.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return new a1();
            }
        });
        concurrentHashMap.put(b1.f1403h, new Supplier() { // from class: i.b.ha.a.b.d.c.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return new b1();
            }
        });
        concurrentHashMap.put(c1.f, new Supplier() { // from class: i.b.ha.a.b.d.c.t
            @Override // java.util.function.Supplier
            public final Object get() {
                return new c1();
            }
        });
        concurrentHashMap.put(m0.f, new Supplier() { // from class: i.b.ha.a.b.d.c.o
            @Override // java.util.function.Supplier
            public final Object get() {
                return new m0();
            }
        });
        b = new a2[0];
    }

    public static a2 a(l2 l2Var) {
        a2 a2VarB = b(l2Var);
        if (a2VarB != null) {
            return a2VarB;
        }
        t0 t0Var = new t0();
        t0Var.i(l2Var);
        return t0Var;
    }

    public static a2 b(l2 l2Var) {
        Supplier<a2> supplier = a.get(l2Var);
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public static a2 c(a2 a2Var, byte[] bArr, int i2, int i3, boolean z) throws ZipException {
        try {
            if (z) {
                a2Var.g(bArr, i2, i3);
            } else {
                a2Var.b(bArr, i2, i3);
            }
            return a2Var;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw o2.j("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(a2Var.d().c()), e);
        }
    }

    public static byte[] d(a2[] a2VarArr) {
        byte[] bArrA;
        int length = a2VarArr.length;
        boolean z = length > 0 && (a2VarArr[length + (-1)] instanceof s0);
        int i2 = z ? length - 1 : length;
        int iC = i2 * 4;
        for (a2 a2Var : a2VarArr) {
            iC += a2Var.f().c();
        }
        byte[] bArr = new byte[iC];
        int length2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            System.arraycopy(a2VarArr[i3].d().a(), 0, bArr, length2, 2);
            System.arraycopy(a2VarArr[i3].f().a(), 0, bArr, length2 + 2, 2);
            length2 += 4;
            byte[] bArrA2 = a2VarArr[i3].a();
            if (bArrA2 != null) {
                System.arraycopy(bArrA2, 0, bArr, length2, bArrA2.length);
                length2 += bArrA2.length;
            }
        }
        if (z && (bArrA = a2VarArr[length - 1].a()) != null) {
            System.arraycopy(bArrA, 0, bArr, length2, bArrA.length);
        }
        return bArr;
    }

    public static byte[] e(a2[] a2VarArr) {
        byte[] bArrE;
        int length = a2VarArr.length;
        boolean z = length > 0 && (a2VarArr[length + (-1)] instanceof s0);
        int i2 = z ? length - 1 : length;
        int iC = i2 * 4;
        for (a2 a2Var : a2VarArr) {
            iC += a2Var.c().c();
        }
        byte[] bArr = new byte[iC];
        int length2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            System.arraycopy(a2VarArr[i3].d().a(), 0, bArr, length2, 2);
            System.arraycopy(a2VarArr[i3].c().a(), 0, bArr, length2 + 2, 2);
            length2 += 4;
            byte[] bArrE2 = a2VarArr[i3].e();
            if (bArrE2 != null) {
                System.arraycopy(bArrE2, 0, bArr, length2, bArrE2.length);
                length2 += bArrE2.length;
            }
        }
        if (z && (bArrE = a2VarArr[length - 1].e()) != null) {
            System.arraycopy(bArrE, 0, bArr, length2, bArrE.length);
        }
        return bArr;
    }

    public static a2[] f(byte[] bArr, boolean z, b0 b0Var) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 > length - 4) {
                break;
            }
            l2 l2Var = new l2(bArr, i2);
            int iC = new l2(bArr, i2 + 2).c();
            int i3 = i2 + 4;
            if (i3 + iC > length) {
                a2 a2VarA = b0Var.a(bArr, i2, length - i2, z, iC);
                if (a2VarA != null) {
                    arrayList.add(a2VarA);
                }
            } else {
                try {
                    a2 a2VarC = b0Var.c(l2Var);
                    Objects.requireNonNull(a2VarC, "createExtraField must not return null");
                    a2 a2VarB = b0Var.b(a2VarC, bArr, i3, iC, z);
                    Objects.requireNonNull(a2VarB, "fill must not return null");
                    arrayList.add(a2VarB);
                    i2 += iC + 4;
                } catch (IllegalAccessException | InstantiationException e) {
                    throw o2.j(e.getMessage(), e);
                }
            }
        }
        return (a2[]) arrayList.toArray(b);
    }
}
