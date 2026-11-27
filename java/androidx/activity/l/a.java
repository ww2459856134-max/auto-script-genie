package androidx.activity.l;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a {
    private final Set<b> a = new CopyOnWriteArraySet();
    private volatile Context b;

    public void a(b bVar) {
        if (this.b != null) {
            bVar.a(this.b);
        }
        this.a.add(bVar);
    }

    public void b() {
        this.b = null;
    }

    public void c(Context context) {
        this.b = context;
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }
}
