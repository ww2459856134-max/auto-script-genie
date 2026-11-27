package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
class w2 implements Runnable {
    final /* synthetic */ ArrayList c;
    final /* synthetic */ Map d;

    w2(y2 y2Var, ArrayList arrayList, Map map) {
        this.c = arrayList;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.c.get(i2);
            String strE = h.e.j.s0.E(view);
            if (strE != null) {
                h.e.j.s0.j0(view, y2.i(this.d, strE));
            }
        }
    }
}
