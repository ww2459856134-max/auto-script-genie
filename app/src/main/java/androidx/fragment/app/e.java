package androidx.fragment.app;

import java.util.List;

/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ List c;
    final /* synthetic */ i3 d;
    final /* synthetic */ r e;

    e(r rVar, List list, i3 i3Var) {
        this.e = rVar;
        this.c = list;
        this.d = i3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.contains(this.d)) {
            this.c.remove(this.d);
            this.e.s(this.d);
        }
    }
}
