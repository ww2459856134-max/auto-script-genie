package com.bumptech.glide.load.w;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class j {
    private static final f<?> b = new h();
    private final Map<Class<?>, f<?>> a = new HashMap();

    public synchronized <T> g<T> a(T t) {
        f<?> fVar;
        com.bumptech.glide.b0.n.d(t);
        fVar = this.a.get(t.getClass());
        if (fVar == null) {
            Iterator<f<?>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    fVar = next;
                    break;
                }
            }
        }
        if (fVar == null) {
            fVar = b;
        }
        return (g<T>) fVar.b(t);
    }

    public synchronized void b(f<?> fVar) {
        this.a.put(fVar.a(), fVar);
    }
}
