package h.i.a;

/* loaded from: classes.dex */
class d {
    public final long a;
    public final long b;

    d(long j2, long j3) {
        if (j3 == 0) {
            this.a = 0L;
            this.b = 1L;
        } else {
            this.a = j2;
            this.b = j3;
        }
    }

    public double a() {
        return this.a / this.b;
    }

    public String toString() {
        return this.a + "/" + this.b;
    }
}
