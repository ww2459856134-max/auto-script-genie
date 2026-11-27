package n.a.a.n.c.t1;

import java.util.function.Supplier;

/* loaded from: classes.dex */
public enum x4 {
    DGET(new Supplier() { // from class: n.a.a.n.c.t1.r1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new s4();
        }
    }),
    DMIN(new Supplier() { // from class: n.a.a.n.c.t1.d1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new u4();
        }
    }),
    DMAX(new Supplier() { // from class: n.a.a.n.c.t1.o
        @Override // java.util.function.Supplier
        public final Object get() {
            return new t4();
        }
    }),
    DSUM(new Supplier() { // from class: n.a.a.n.c.t1.q1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new c5();
        }
    }),
    DCOUNT(new Supplier() { // from class: n.a.a.n.c.t1.d
        @Override // java.util.function.Supplier
        public final Object get() {
            return new q4();
        }
    }),
    DCOUNTA(new Supplier() { // from class: n.a.a.n.c.t1.z0
        @Override // java.util.function.Supplier
        public final Object get() {
            return new r4();
        }
    }),
    DAVERAGE(new Supplier() { // from class: n.a.a.n.c.t1.b1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new p4();
        }
    }),
    DSTDEV(new Supplier() { // from class: n.a.a.n.c.t1.x0
        @Override // java.util.function.Supplier
        public final Object get() {
            return new a5();
        }
    }),
    DSTDEVP(new Supplier() { // from class: n.a.a.n.c.t1.g1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new b5();
        }
    }),
    DVAR(new Supplier() { // from class: n.a.a.n.c.t1.u1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new d5();
        }
    }),
    DVARP(new Supplier() { // from class: n.a.a.n.c.t1.i1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new e5();
        }
    }),
    DPRODUCT(new Supplier() { // from class: n.a.a.n.c.t1.c1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new v4();
        }
    });

    private final Supplier<u6> c;

    x4(Supplier supplier) {
        this.c = supplier;
    }

    public u6 a() {
        return this.c.get();
    }
}
