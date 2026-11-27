package h.e.j;

/* loaded from: classes.dex */
public final class h {
    private final Object a;

    private h(Object obj) {
        this.a = obj;
    }

    static h a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new h(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return h.e.i.c.a(this.a, ((h) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }
}
