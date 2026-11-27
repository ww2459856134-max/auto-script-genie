package com.airbnb.lottie.v0;

/* loaded from: classes.dex */
public class j<T> {
    T a;
    T b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h.e.i.d)) {
            return false;
        }
        h.e.i.d dVar = (h.e.i.d) obj;
        return a(dVar.a, this.a) && a(dVar.b, this.b);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}
