package com.bumptech.glide.load.z.j;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.load.v;
import com.bumptech.glide.load.x.b0;
import com.bumptech.glide.s;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class n {
    private final com.bumptech.glide.v.b a;
    private final Handler b;
    private final List<k> c;
    final s d;
    private final com.bumptech.glide.load.x.g1.g e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f661h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.q<Bitmap> f662i;

    /* renamed from: j, reason: collision with root package name */
    private j f663j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f664k;

    /* renamed from: l, reason: collision with root package name */
    private j f665l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f666m;

    /* renamed from: n, reason: collision with root package name */
    private j f667n;

    /* renamed from: o, reason: collision with root package name */
    private m f668o;
    private int p;
    private int q;
    private int r;

    n(com.bumptech.glide.c cVar, com.bumptech.glide.v.b bVar, int i2, int i3, v<Bitmap> vVar, Bitmap bitmap) {
        this(cVar.f(), com.bumptech.glide.c.t(cVar.h()), bVar, null, i(com.bumptech.glide.c.t(cVar.h()), i2, i3), vVar, bitmap);
    }

    private static com.bumptech.glide.load.n g() {
        return new com.bumptech.glide.a0.d(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.q<Bitmap> i(s sVar, int i2, int i3) {
        return sVar.m().a(com.bumptech.glide.z.g.g0(b0.b).e0(true).Z(true).Q(i2, i3));
    }

    private void l() {
        if (!this.f || this.g) {
            return;
        }
        if (this.f661h) {
            com.bumptech.glide.b0.n.a(this.f667n == null, "Pending target must be null when starting from the first frame");
            this.a.b();
            this.f661h = false;
        }
        j jVar = this.f667n;
        if (jVar != null) {
            this.f667n = null;
            m(jVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.a.h();
        this.a.f();
        this.f665l = new j(this.b, this.a.c(), jUptimeMillis);
        com.bumptech.glide.q<Bitmap> qVarG0 = this.f662i.a(com.bumptech.glide.z.g.h0(g()));
        qVarG0.w0(this.a);
        qVarG0.n0(this.f665l);
    }

    private void n() {
        Bitmap bitmap = this.f666m;
        if (bitmap != null) {
            this.e.c(bitmap);
            this.f666m = null;
        }
    }

    private void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.f664k = false;
        l();
    }

    private void q() {
        this.f = false;
    }

    void a() {
        this.c.clear();
        n();
        q();
        j jVar = this.f663j;
        if (jVar != null) {
            this.d.o(jVar);
            this.f663j = null;
        }
        j jVar2 = this.f665l;
        if (jVar2 != null) {
            this.d.o(jVar2);
            this.f665l = null;
        }
        j jVar3 = this.f667n;
        if (jVar3 != null) {
            this.d.o(jVar3);
            this.f667n = null;
        }
        this.a.clear();
        this.f664k = true;
    }

    ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        j jVar = this.f663j;
        return jVar != null ? jVar.l() : this.f666m;
    }

    int d() {
        j jVar = this.f663j;
        if (jVar != null) {
            return jVar.g;
        }
        return -1;
    }

    Bitmap e() {
        return this.f666m;
    }

    int f() {
        return this.a.g();
    }

    int h() {
        return this.r;
    }

    int j() {
        return this.a.d() + this.p;
    }

    int k() {
        return this.q;
    }

    void m(j jVar) {
        m mVar = this.f668o;
        if (mVar != null) {
            mVar.a();
        }
        this.g = false;
        if (this.f664k) {
            this.b.obtainMessage(2, jVar).sendToTarget();
            return;
        }
        if (!this.f) {
            this.f667n = jVar;
            return;
        }
        if (jVar.l() != null) {
            n();
            j jVar2 = this.f663j;
            this.f663j = jVar;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                this.c.get(size).a();
            }
            if (jVar2 != null) {
                this.b.obtainMessage(2, jVar2).sendToTarget();
            }
        }
        l();
    }

    void o(v<Bitmap> vVar, Bitmap bitmap) {
        com.bumptech.glide.b0.n.d(vVar);
        com.bumptech.glide.b0.n.d(bitmap);
        this.f666m = bitmap;
        this.f662i = this.f662i.a(new com.bumptech.glide.z.g().a0(vVar));
        this.p = com.bumptech.glide.b0.p.g(bitmap);
        this.q = bitmap.getWidth();
        this.r = bitmap.getHeight();
    }

    void r(k kVar) {
        if (this.f664k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.c.contains(kVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.c.isEmpty();
        this.c.add(kVar);
        if (zIsEmpty) {
            p();
        }
    }

    void s(k kVar) {
        this.c.remove(kVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    n(com.bumptech.glide.load.x.g1.g gVar, s sVar, com.bumptech.glide.v.b bVar, Handler handler, com.bumptech.glide.q<Bitmap> qVar, v<Bitmap> vVar, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = sVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new l(this)) : handler;
        this.e = gVar;
        this.b = handler;
        this.f662i = qVar;
        this.a = bVar;
        o(vVar, bitmap);
    }
}
