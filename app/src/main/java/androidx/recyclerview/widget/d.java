package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class d {
    long a = 0;
    d b;

    d() {
    }

    private void c() {
        if (this.b == null) {
            this.b = new d();
        }
    }

    void a(int i2) {
        if (i2 < 64) {
            this.a &= ~(1 << i2);
            return;
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(i2 - 64);
        }
    }

    int b(int i2) {
        d dVar = this.b;
        return dVar == null ? i2 >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i2) - 1)) : i2 < 64 ? Long.bitCount(this.a & ((1 << i2) - 1)) : dVar.b(i2 - 64) + Long.bitCount(this.a);
    }

    boolean d(int i2) {
        if (i2 < 64) {
            return (this.a & (1 << i2)) != 0;
        }
        c();
        return this.b.d(i2 - 64);
    }

    void e(int i2, boolean z) {
        if (i2 >= 64) {
            c();
            this.b.e(i2 - 64, z);
            return;
        }
        long j2 = this.a;
        boolean z2 = (Long.MIN_VALUE & j2) != 0;
        long j3 = (1 << i2) - 1;
        this.a = ((j2 & (~j3)) << 1) | (j2 & j3);
        if (z) {
            h(i2);
        } else {
            a(i2);
        }
        if (z2 || this.b != null) {
            c();
            this.b.e(0, z2);
        }
    }

    boolean f(int i2) {
        if (i2 >= 64) {
            c();
            return this.b.f(i2 - 64);
        }
        long j2 = 1 << i2;
        long j3 = this.a;
        boolean z = (j3 & j2) != 0;
        long j4 = j3 & (~j2);
        this.a = j4;
        long j5 = j2 - 1;
        this.a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
        d dVar = this.b;
        if (dVar != null) {
            if (dVar.d(0)) {
                h(63);
            }
            this.b.f(0);
        }
        return z;
    }

    void g() {
        this.a = 0L;
        d dVar = this.b;
        if (dVar != null) {
            dVar.g();
        }
    }

    void h(int i2) {
        if (i2 < 64) {
            this.a |= 1 << i2;
        } else {
            c();
            this.b.h(i2 - 64);
        }
    }

    public String toString() {
        if (this.b == null) {
            return Long.toBinaryString(this.a);
        }
        return this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
}
