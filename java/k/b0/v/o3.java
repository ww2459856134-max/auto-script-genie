package k.b0.v;

import java.util.Comparator;

/* loaded from: classes.dex */
class o3 implements Comparator {
    private o3() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        k.y.a.a(obj instanceof r);
        k.y.a.a(obj2 instanceof r);
        return ((r) obj).b() - ((r) obj2).b();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj == this;
    }
}
