package androidx.recyclerview.widget;

import java.util.Comparator;

/* loaded from: classes.dex */
final class a0 implements Comparator<c0> {
    a0() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(c0 c0Var, c0 c0Var2) {
        RecyclerView recyclerView = c0Var.d;
        if ((recyclerView == null) != (c0Var2.d == null)) {
            return recyclerView == null ? 1 : -1;
        }
        boolean z = c0Var.a;
        if (z != c0Var2.a) {
            return z ? -1 : 1;
        }
        int i2 = c0Var2.b - c0Var.b;
        if (i2 != 0) {
            return i2;
        }
        int i3 = c0Var.c - c0Var2.c;
        if (i3 != 0) {
            return i3;
        }
        return 0;
    }
}
