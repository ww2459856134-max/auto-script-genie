package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ ArrayList c;

    m(r rVar, ArrayList arrayList) {
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        o2.B(this.c, 4);
    }
}
