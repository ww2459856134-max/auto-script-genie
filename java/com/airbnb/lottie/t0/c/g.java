package com.airbnb.lottie.t0.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class g<K, A> {
    private final d<K> c;
    protected com.airbnb.lottie.z0.c<A> e;
    final List<b> a = new ArrayList(1);
    private boolean b = false;
    protected float d = 0.0f;
    private A f = null;
    private float g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f492h = -1.0f;

    g(List<? extends com.airbnb.lottie.z0.a<K>> list) {
        this.c = n(list);
    }

    private float g() {
        if (this.g == -1.0f) {
            this.g = this.c.b();
        }
        return this.g;
    }

    private static <T> d<T> n(List<? extends com.airbnb.lottie.z0.a<T>> list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.a.add(bVar);
    }

    protected com.airbnb.lottie.z0.a<K> b() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.z0.a<K> aVarA = this.c.a();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarA;
    }

    float c() {
        if (this.f492h == -1.0f) {
            this.f492h = this.c.e();
        }
        return this.f492h;
    }

    protected float d() {
        com.airbnb.lottie.z0.a<K> aVarB = b();
        if (aVarB.h()) {
            return 0.0f;
        }
        return aVarB.d.getInterpolation(e());
    }

    float e() {
        if (this.b) {
            return 0.0f;
        }
        com.airbnb.lottie.z0.a<K> aVarB = b();
        if (aVarB.h()) {
            return 0.0f;
        }
        return (this.d - aVarB.e()) / (aVarB.b() - aVarB.e());
    }

    public float f() {
        return this.d;
    }

    public A h() {
        float fD = d();
        if (this.e == null && this.c.c(fD)) {
            return this.f;
        }
        A aI = i(b(), fD);
        this.f = aI;
        return aI;
    }

    abstract A i(com.airbnb.lottie.z0.a<K> aVar, float f);

    public void j() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).d();
        }
    }

    public void k() {
        this.b = true;
    }

    public void l(float f) {
        if (this.c.isEmpty()) {
            return;
        }
        if (f < g()) {
            f = g();
        } else if (f > c()) {
            f = c();
        }
        if (f == this.d) {
            return;
        }
        this.d = f;
        if (this.c.d(f)) {
            j();
        }
    }

    public void m(com.airbnb.lottie.z0.c<A> cVar) {
        com.airbnb.lottie.z0.c<A> cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
