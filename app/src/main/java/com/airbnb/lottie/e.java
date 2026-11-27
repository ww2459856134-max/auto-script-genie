package com.airbnb.lottie;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {
    private Map<String, List<com.airbnb.lottie.v0.m.i>> c;
    private Map<String, f0> d;
    private Map<String, com.airbnb.lottie.v0.d> e;
    private List<com.airbnb.lottie.v0.i> f;
    private h.d.j<com.airbnb.lottie.v0.e> g;

    /* renamed from: h, reason: collision with root package name */
    private h.d.f<com.airbnb.lottie.v0.m.i> f426h;

    /* renamed from: i, reason: collision with root package name */
    private List<com.airbnb.lottie.v0.m.i> f427i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f428j;

    /* renamed from: k, reason: collision with root package name */
    private float f429k;

    /* renamed from: l, reason: collision with root package name */
    private float f430l;

    /* renamed from: m, reason: collision with root package name */
    private float f431m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f432n;
    private final o0 a = new o0();
    private final HashSet<String> b = new HashSet<>();

    /* renamed from: o, reason: collision with root package name */
    private int f433o = 0;

    public void a(String str) {
        com.airbnb.lottie.y0.d.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.f428j;
    }

    public h.d.j<com.airbnb.lottie.v0.e> c() {
        return this.g;
    }

    public float d() {
        return (long) ((e() / this.f431m) * 1000.0f);
    }

    public float e() {
        return this.f430l - this.f429k;
    }

    public float f() {
        return this.f430l;
    }

    public Map<String, com.airbnb.lottie.v0.d> g() {
        return this.e;
    }

    public float h() {
        return this.f431m;
    }

    public Map<String, f0> i() {
        return this.d;
    }

    public List<com.airbnb.lottie.v0.m.i> j() {
        return this.f427i;
    }

    public com.airbnb.lottie.v0.i k(String str) {
        this.f.size();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            com.airbnb.lottie.v0.i iVar = this.f.get(i2);
            if (iVar.a(str)) {
                return iVar;
            }
        }
        return null;
    }

    public int l() {
        return this.f433o;
    }

    public o0 m() {
        return this.a;
    }

    public List<com.airbnb.lottie.v0.m.i> n(String str) {
        return this.c.get(str);
    }

    public float o() {
        return this.f429k;
    }

    public boolean p() {
        return this.f432n;
    }

    public void q(int i2) {
        this.f433o += i2;
    }

    public void r(Rect rect, float f, float f2, float f3, List<com.airbnb.lottie.v0.m.i> list, h.d.f<com.airbnb.lottie.v0.m.i> fVar, Map<String, List<com.airbnb.lottie.v0.m.i>> map, Map<String, f0> map2, h.d.j<com.airbnb.lottie.v0.e> jVar, Map<String, com.airbnb.lottie.v0.d> map3, List<com.airbnb.lottie.v0.i> list2) {
        this.f428j = rect;
        this.f429k = f;
        this.f430l = f2;
        this.f431m = f3;
        this.f427i = list;
        this.f426h = fVar;
        this.c = map;
        this.d = map2;
        this.g = jVar;
        this.e = map3;
        this.f = list2;
    }

    public com.airbnb.lottie.v0.m.i s(long j2) {
        return this.f426h.f(j2);
    }

    public void t(boolean z) {
        this.f432n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.airbnb.lottie.v0.m.i> it = this.f427i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
