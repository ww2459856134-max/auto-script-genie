package com.bumptech.glide.w;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class a implements j {
    private final Set<k> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    a() {
    }

    @Override // com.bumptech.glide.w.j
    public void a(k kVar) {
        this.a.remove(kVar);
    }

    @Override // com.bumptech.glide.w.j
    public void b(k kVar) {
        this.a.add(kVar);
        if (this.c) {
            kVar.d();
        } else if (this.b) {
            kVar.a();
        } else {
            kVar.b();
        }
    }

    void c() {
        this.c = true;
        Iterator it = com.bumptech.glide.b0.p.i(this.a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).d();
        }
    }

    void d() {
        this.b = true;
        Iterator it = com.bumptech.glide.b0.p.i(this.a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
    }

    void e() {
        this.b = false;
        Iterator it = com.bumptech.glide.b0.p.i(this.a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).b();
        }
    }
}
