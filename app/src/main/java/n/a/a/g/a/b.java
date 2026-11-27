package n.a.a.g.a;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class b {
    private static Map<Integer, b> d;
    private static Map<a, b> e;
    private final int a;
    private final int b;
    private final int c;

    public b(int i2, int i3, int i4) {
        this.b = i2;
        this.c = i3;
        this.a = (-16777216) | i4;
    }

    private static void b(a aVar) {
        e.put(aVar, aVar.a());
    }

    private static Map<Integer, b> c() {
        Map<a, b> mapK = k();
        HashMap map = new HashMap((mapK.size() * 3) / 2);
        for (Map.Entry<a, b> entry : mapK.entrySet()) {
            Integer numValueOf = Integer.valueOf(entry.getKey().b());
            if (!map.containsKey(numValueOf)) {
                map.put(numValueOf, entry.getValue());
            }
            Integer numValueOf2 = Integer.valueOf(entry.getKey().c());
            if (numValueOf2.intValue() != -1 && !map.containsKey(numValueOf2)) {
                map.put(numValueOf2, entry.getValue());
            }
        }
        return map;
    }

    private short d() {
        return (short) (this.a & 255);
    }

    private short e() {
        return (short) ((this.a >> 8) & 255);
    }

    public static synchronized Map<Integer, b> h() {
        if (d == null) {
            d = Collections.unmodifiableMap(c());
        }
        return d;
    }

    private short i() {
        return (short) ((this.a >> 16) & 255);
    }

    private static synchronized Map<a, b> k() {
        if (e == null) {
            e = new EnumMap(a.class);
            b(a.d);
            b(a.e);
            b(a.f);
            b(a.g);
            b(a.f2268h);
            b(a.f2269i);
            b(a.f2270j);
            b(a.f2271k);
            b(a.t);
            b(a.A);
            b(a.C);
            b(a.D);
            b(a.G);
            b(a.H);
            b(a.I);
            b(a.J);
            b(a.K);
            b(a.M);
            b(a.O);
            b(a.P);
            b(a.Q);
            b(a.U);
            b(a.V);
            b(a.W);
            b(a.Z);
            b(a.a0);
            b(a.b0);
            b(a.c0);
            b(a.d0);
            b(a.e0);
            b(a.f0);
            b(a.g0);
            b(a.h0);
            b(a.i0);
            b(a.j0);
            b(a.k0);
            b(a.l0);
            b(a.m0);
            b(a.n0);
            b(a.o0);
            b(a.p0);
            b(a.q0);
            b(a.r0);
            b(a.s0);
            b(a.t0);
            b(a.u0);
            b(a.v0);
        }
        return e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b == bVar.b && this.c == bVar.c) {
            return Objects.equals(Integer.valueOf(this.a), Integer.valueOf(bVar.a));
        }
        return false;
    }

    public short f() {
        return (short) this.b;
    }

    public short g() {
        return (short) this.c;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public short[] j() {
        return new short[]{i(), e(), d()};
    }
}
