package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class v2 implements Runnable {
    final /* synthetic */ int c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ ArrayList g;

    v2(y2 y2Var, int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.c = i2;
        this.d = arrayList;
        this.e = arrayList2;
        this.f = arrayList3;
        this.g = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i2 = 0; i2 < this.c; i2++) {
            h.e.j.s0.j0((View) this.d.get(i2), (String) this.e.get(i2));
            h.e.j.s0.j0((View) this.f.get(i2), (String) this.g.get(i2));
        }
    }
}
