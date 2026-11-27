package org.opencv.core;

/* loaded from: classes2.dex */
public class d {
    public double a;
    public double b;

    public d(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return new d(this.a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.b);
        int i2 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.a);
        return (i2 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public String toString() {
        return ((int) this.a) + "x" + ((int) this.b);
    }
}
