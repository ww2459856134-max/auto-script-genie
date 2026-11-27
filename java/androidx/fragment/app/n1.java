package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
class n1 implements m1 {
    final String a;
    final int b;
    final int c;
    final /* synthetic */ p1 d;

    n1(p1 p1Var, String str, int i2, int i3) {
        this.d = p1Var;
        this.a = str;
        this.b = i2;
        this.c = i3;
    }

    @Override // androidx.fragment.app.m1
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        Fragment fragment = this.d.u;
        if (fragment == null || this.b >= 0 || this.a != null || !fragment.w().V0()) {
            return this.d.X0(arrayList, arrayList2, this.a, this.b, this.c);
        }
        return false;
    }
}
