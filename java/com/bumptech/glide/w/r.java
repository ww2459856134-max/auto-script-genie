package com.bumptech.glide.w;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class r {
    private final Set<com.bumptech.glide.z.c> a = Collections.newSetFromMap(new WeakHashMap());
    private final List<com.bumptech.glide.z.c> b = new ArrayList();
    private boolean c;

    public boolean a(com.bumptech.glide.z.c cVar) {
        boolean z = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(cVar);
        if (!this.b.remove(cVar) && !zRemove) {
            z = false;
        }
        if (z) {
            cVar.clear();
        }
        return z;
    }

    public void b() {
        Iterator it = com.bumptech.glide.b0.p.i(this.a).iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.z.c) it.next());
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        for (com.bumptech.glide.z.c cVar : com.bumptech.glide.b0.p.i(this.a)) {
            if (cVar.isRunning() || cVar.g()) {
                cVar.clear();
                this.b.add(cVar);
            }
        }
    }

    public void d() {
        this.c = true;
        for (com.bumptech.glide.z.c cVar : com.bumptech.glide.b0.p.i(this.a)) {
            if (cVar.isRunning()) {
                cVar.d();
                this.b.add(cVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.z.c cVar : com.bumptech.glide.b0.p.i(this.a)) {
            if (!cVar.g() && !cVar.f()) {
                cVar.clear();
                if (this.c) {
                    this.b.add(cVar);
                } else {
                    cVar.k();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (com.bumptech.glide.z.c cVar : com.bumptech.glide.b0.p.i(this.a)) {
            if (!cVar.g() && !cVar.isRunning()) {
                cVar.k();
            }
        }
        this.b.clear();
    }

    public void g(com.bumptech.glide.z.c cVar) {
        this.a.add(cVar);
        if (!this.c) {
            cVar.k();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
