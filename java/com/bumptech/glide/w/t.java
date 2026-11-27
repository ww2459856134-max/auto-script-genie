package com.bumptech.glide.w;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class t implements k {
    private final Set<com.bumptech.glide.z.l.h<?>> c = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.w.k
    public void a() {
        Iterator it = com.bumptech.glide.b0.p.i(this.c).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.z.l.h) it.next()).a();
        }
    }

    @Override // com.bumptech.glide.w.k
    public void b() {
        Iterator it = com.bumptech.glide.b0.p.i(this.c).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.z.l.h) it.next()).b();
        }
    }

    @Override // com.bumptech.glide.w.k
    public void d() {
        Iterator it = com.bumptech.glide.b0.p.i(this.c).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.z.l.h) it.next()).d();
        }
    }

    public void l() {
        this.c.clear();
    }

    public List<com.bumptech.glide.z.l.h<?>> m() {
        return com.bumptech.glide.b0.p.i(this.c);
    }

    public void n(com.bumptech.glide.z.l.h<?> hVar) {
        this.c.add(hVar);
    }

    public void o(com.bumptech.glide.z.l.h<?> hVar) {
        this.c.remove(hVar);
    }
}
