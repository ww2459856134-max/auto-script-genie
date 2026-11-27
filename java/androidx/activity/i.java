package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class i {
    private boolean a;
    private CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    public i(boolean z) {
        this.a = z;
    }

    void a(a aVar) {
        this.b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.a;
    }

    public final void d() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void e(a aVar) {
        this.b.remove(aVar);
    }

    public final void f(boolean z) {
        this.a = z;
    }
}
