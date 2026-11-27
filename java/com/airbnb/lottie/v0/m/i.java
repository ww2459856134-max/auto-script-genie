package com.airbnb.lottie.v0.m;

import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class i {
    private final List<com.airbnb.lottie.v0.l.b> a;
    private final com.airbnb.lottie.e b;
    private final String c;
    private final long d;
    private final g e;
    private final long f;
    private final String g;

    /* renamed from: h, reason: collision with root package name */
    private final List<com.airbnb.lottie.v0.l.h> f545h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.v0.k.l f546i;

    /* renamed from: j, reason: collision with root package name */
    private final int f547j;

    /* renamed from: k, reason: collision with root package name */
    private final int f548k;

    /* renamed from: l, reason: collision with root package name */
    private final int f549l;

    /* renamed from: m, reason: collision with root package name */
    private final float f550m;

    /* renamed from: n, reason: collision with root package name */
    private final float f551n;

    /* renamed from: o, reason: collision with root package name */
    private final int f552o;
    private final int p;
    private final com.airbnb.lottie.v0.k.j q;
    private final com.airbnb.lottie.v0.k.k r;
    private final com.airbnb.lottie.v0.k.b s;
    private final List<com.airbnb.lottie.z0.a<Float>> t;
    private final h u;
    private final boolean v;

    public i(List<com.airbnb.lottie.v0.l.b> list, com.airbnb.lottie.e eVar, String str, long j2, g gVar, long j3, String str2, List<com.airbnb.lottie.v0.l.h> list2, com.airbnb.lottie.v0.k.l lVar, int i2, int i3, int i4, float f, float f2, int i5, int i6, com.airbnb.lottie.v0.k.j jVar, com.airbnb.lottie.v0.k.k kVar, List<com.airbnb.lottie.z0.a<Float>> list3, h hVar, com.airbnb.lottie.v0.k.b bVar, boolean z) {
        this.a = list;
        this.b = eVar;
        this.c = str;
        this.d = j2;
        this.e = gVar;
        this.f = j3;
        this.g = str2;
        this.f545h = list2;
        this.f546i = lVar;
        this.f547j = i2;
        this.f548k = i3;
        this.f549l = i4;
        this.f550m = f;
        this.f551n = f2;
        this.f552o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = hVar;
        this.s = bVar;
        this.v = z;
    }

    com.airbnb.lottie.e a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    List<com.airbnb.lottie.z0.a<Float>> c() {
        return this.t;
    }

    public g d() {
        return this.e;
    }

    List<com.airbnb.lottie.v0.l.h> e() {
        return this.f545h;
    }

    h f() {
        return this.u;
    }

    String g() {
        return this.c;
    }

    long h() {
        return this.f;
    }

    int i() {
        return this.p;
    }

    int j() {
        return this.f552o;
    }

    String k() {
        return this.g;
    }

    List<com.airbnb.lottie.v0.l.b> l() {
        return this.a;
    }

    int m() {
        return this.f549l;
    }

    int n() {
        return this.f548k;
    }

    int o() {
        return this.f547j;
    }

    float p() {
        return this.f551n / this.b.e();
    }

    com.airbnb.lottie.v0.k.j q() {
        return this.q;
    }

    com.airbnb.lottie.v0.k.k r() {
        return this.r;
    }

    com.airbnb.lottie.v0.k.b s() {
        return this.s;
    }

    float t() {
        return this.f550m;
    }

    public String toString() {
        return w("");
    }

    com.airbnb.lottie.v0.k.l u() {
        return this.f546i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        i iVarS = this.b.s(h());
        if (iVarS != null) {
            sb.append("\t\tParents: ");
            sb.append(iVarS.g());
            i iVarS2 = this.b.s(iVarS.h());
            while (iVarS2 != null) {
                sb.append("->");
                sb.append(iVarS2.g());
                iVarS2 = this.b.s(iVarS2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.v0.l.b bVar : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
