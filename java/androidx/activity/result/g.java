package androidx.activity.result;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class g {
    final androidx.lifecycle.f a;
    private final ArrayList<androidx.lifecycle.g> b = new ArrayList<>();

    g(androidx.lifecycle.f fVar) {
        this.a = fVar;
    }

    void a(androidx.lifecycle.g gVar) {
        this.a.a(gVar);
        this.b.add(gVar);
    }

    void b() {
        Iterator<androidx.lifecycle.g> it = this.b.iterator();
        while (it.hasNext()) {
            this.a.c(it.next());
        }
        this.b.clear();
    }
}
