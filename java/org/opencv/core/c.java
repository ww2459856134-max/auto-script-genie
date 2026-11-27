package org.opencv.core;

/* loaded from: classes2.dex */
public class c {
    public double a;
    public double b;

    public c(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        return new c(this.a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.a);
        int i2 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i2 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }

    public c() {
        this(0.0d, 0.0d);
    }
}
