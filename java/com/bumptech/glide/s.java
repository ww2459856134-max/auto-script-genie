package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.x.b0;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.bumptech.glide.q<android.graphics.drawable.Drawable>>] */
/* loaded from: classes.dex */
public class s implements ComponentCallbacks2, com.bumptech.glide.w.k {
    private static final com.bumptech.glide.z.g D;
    private com.bumptech.glide.z.g A;
    private boolean C;
    protected final c c;
    protected final Context d;
    final com.bumptech.glide.w.j e;
    private final com.bumptech.glide.w.r f;
    private final com.bumptech.glide.w.q g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.w.t f672h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f673i;

    /* renamed from: j, reason: collision with root package name */
    private final Handler f674j;

    /* renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.w.d f675k;
    private final CopyOnWriteArrayList<com.bumptech.glide.z.f<Object>> t;

    private class a implements com.bumptech.glide.w.c {
        private final com.bumptech.glide.w.r a;

        a(com.bumptech.glide.w.r rVar) {
            this.a = rVar;
        }

        @Override // com.bumptech.glide.w.c
        public void a(boolean z) {
            if (z) {
                synchronized (s.this) {
                    this.a.e();
                }
            }
        }
    }

    static {
        com.bumptech.glide.z.g gVarF0 = com.bumptech.glide.z.g.f0(Bitmap.class);
        gVarF0.K();
        D = gVarF0;
        com.bumptech.glide.z.g.f0(com.bumptech.glide.load.z.j.f.class).K();
        com.bumptech.glide.z.g.g0(b0.c).S(h.LOW).Z(true);
    }

    public s(c cVar, com.bumptech.glide.w.j jVar, com.bumptech.glide.w.q qVar, Context context) {
        this(cVar, jVar, qVar, new com.bumptech.glide.w.r(), cVar.g(), context);
    }

    private void E(com.bumptech.glide.z.l.h<?> hVar) {
        boolean zD = D(hVar);
        com.bumptech.glide.z.c cVarE = hVar.e();
        if (zD || this.c.p(hVar) || cVarE == null) {
            return;
        }
        hVar.i(null);
        cVarE.clear();
    }

    public synchronized void A() {
        this.f.f();
    }

    protected synchronized void B(com.bumptech.glide.z.g gVar) {
        com.bumptech.glide.z.g gVarClone = gVar.clone();
        gVarClone.b();
        this.A = gVarClone;
    }

    synchronized void C(com.bumptech.glide.z.l.h<?> hVar, com.bumptech.glide.z.c cVar) {
        this.f672h.n(hVar);
        this.f.g(cVar);
    }

    synchronized boolean D(com.bumptech.glide.z.l.h<?> hVar) {
        com.bumptech.glide.z.c cVarE = hVar.e();
        if (cVarE == null) {
            return true;
        }
        if (!this.f.a(cVarE)) {
            return false;
        }
        this.f672h.o(hVar);
        hVar.i(null);
        return true;
    }

    @Override // com.bumptech.glide.w.k
    public synchronized void a() {
        A();
        this.f672h.a();
    }

    @Override // com.bumptech.glide.w.k
    public synchronized void b() {
        z();
        this.f672h.b();
    }

    @Override // com.bumptech.glide.w.k
    public synchronized void d() {
        this.f672h.d();
        Iterator<com.bumptech.glide.z.l.h<?>> it = this.f672h.m().iterator();
        while (it.hasNext()) {
            o(it.next());
        }
        this.f672h.l();
        this.f.b();
        this.e.a(this);
        this.e.a(this.f675k);
        this.f674j.removeCallbacks(this.f673i);
        this.c.s(this);
    }

    public <ResourceType> q<ResourceType> l(Class<ResourceType> cls) {
        return new q<>(this.c, this, cls, this.d);
    }

    public q<Bitmap> m() {
        return l(Bitmap.class).a(D);
    }

    public q<Drawable> n() {
        return l(Drawable.class);
    }

    public void o(com.bumptech.glide.z.l.h<?> hVar) {
        if (hVar == null) {
            return;
        }
        E(hVar);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.C) {
            y();
        }
    }

    List<com.bumptech.glide.z.f<Object>> p() {
        return this.t;
    }

    synchronized com.bumptech.glide.z.g q() {
        return this.A;
    }

    <T> t<?, T> r(Class<T> cls) {
        return this.c.i().e(cls);
    }

    public q<Drawable> s(Drawable drawable) {
        return n().s0(drawable);
    }

    public q<Drawable> t(Uri uri) {
        q<Drawable> qVarN = n();
        qVarN.t0(uri);
        return qVarN;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f + ", treeNode=" + this.g + "}";
    }

    public q<Drawable> u(File file) {
        q<Drawable> qVarN = n();
        qVarN.u0(file);
        return qVarN;
    }

    public q<Drawable> v(Integer num) {
        return n().v0(num);
    }

    public q<Drawable> w(String str) {
        q<Drawable> qVarN = n();
        qVarN.x0(str);
        return qVarN;
    }

    public synchronized void x() {
        this.f.c();
    }

    public synchronized void y() {
        x();
        Iterator<s> it = this.g.a().iterator();
        while (it.hasNext()) {
            it.next().x();
        }
    }

    public synchronized void z() {
        this.f.d();
    }

    s(c cVar, com.bumptech.glide.w.j jVar, com.bumptech.glide.w.q qVar, com.bumptech.glide.w.r rVar, com.bumptech.glide.w.e eVar, Context context) {
        this.f672h = new com.bumptech.glide.w.t();
        r rVar2 = new r(this);
        this.f673i = rVar2;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f674j = handler;
        this.c = cVar;
        this.e = jVar;
        this.g = qVar;
        this.f = rVar;
        this.d = context;
        com.bumptech.glide.w.d dVarA = eVar.a(context.getApplicationContext(), new a(rVar));
        this.f675k = dVarA;
        if (com.bumptech.glide.b0.p.o()) {
            handler.post(rVar2);
        } else {
            jVar.b(this);
        }
        jVar.b(dVarA);
        this.t = new CopyOnWriteArrayList<>(cVar.i().c());
        B(cVar.i().d());
        cVar.o(this);
    }
}
