package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
class h2 implements Runnable {
    final /* synthetic */ ArrayList c;

    h2(ArrayList arrayList) {
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        o2.B(this.c, 4);
    }
}
