package com.airbnb.lottie.t0.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.List;

/* loaded from: classes.dex */
public class r implements p, com.airbnb.lottie.t0.c.b, m {
    private final String b;
    private final e0 c;
    private final com.airbnb.lottie.v0.l.k d;
    private final boolean e;
    private final com.airbnb.lottie.t0.c.g<?, Float> f;
    private final com.airbnb.lottie.t0.c.g<?, PointF> g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f478h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f479i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f480j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f481k;

    /* renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f482l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f484n;
    private final Path a = new Path();

    /* renamed from: m, reason: collision with root package name */
    private d f483m = new d();

    public r(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.l lVar) {
        this.c = e0Var;
        this.b = lVar.d();
        com.airbnb.lottie.v0.l.k kVarJ = lVar.j();
        this.d = kVarJ;
        this.e = lVar.k();
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA = lVar.g().a();
        this.f = gVarA;
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA2 = lVar.h().a();
        this.g = gVarA2;
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA3 = lVar.i().a();
        this.f478h = gVarA3;
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA4 = lVar.e().a();
        this.f480j = gVarA4;
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA5 = lVar.f().a();
        this.f482l = gVarA5;
        com.airbnb.lottie.v0.l.k kVar = com.airbnb.lottie.v0.l.k.STAR;
        if (kVarJ == kVar) {
            this.f479i = lVar.b().a();
            this.f481k = lVar.c().a();
        } else {
            this.f479i = null;
            this.f481k = null;
        }
        cVar.i(gVarA);
        cVar.i(gVarA2);
        cVar.i(gVarA3);
        cVar.i(gVarA4);
        cVar.i(gVarA5);
        if (kVarJ == kVar) {
            cVar.i(this.f479i);
            cVar.i(this.f481k);
        }
        gVarA.a(this);
        gVarA2.a(this);
        gVarA3.a(this);
        gVarA4.a(this);
        gVarA5.a(this);
        if (kVarJ == kVar) {
            this.f479i.a(this);
            this.f481k.a(this);
        }
    }

    private void b() {
        double d;
        double d2;
        double d3;
        int i2;
        int iFloor = (int) Math.floor(this.f.h().floatValue());
        double radians = Math.toRadians((this.f478h == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.f482l.h().floatValue() / 100.0f;
        float fFloatValue2 = this.f480j.h().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.a.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i3 = 0;
        while (i3 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i2 = i3;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.a.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i2 = i3;
                this.a.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i3 = i2 + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFH = this.g.h();
        this.a.offset(pointFH.x, pointFH.y);
        this.a.close();
    }

    private void h() {
        double d;
        int i2;
        double d2;
        float fCos;
        float fSin;
        float f;
        float f2;
        float f3;
        float f4;
        double d3;
        float f5;
        float f6;
        float f7;
        float fFloatValue = this.f.h().floatValue();
        double radians = Math.toRadians((this.f478h == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f8 = (float) (6.283185307179586d / d4);
        float f9 = f8 / 2.0f;
        float f10 = fFloatValue - ((int) fFloatValue);
        int i3 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f10) * f9;
        }
        float fFloatValue2 = this.f480j.h().floatValue();
        float fFloatValue3 = this.f479i.h().floatValue();
        com.airbnb.lottie.t0.c.g<?, Float> gVar = this.f481k;
        float fFloatValue4 = gVar != null ? gVar.h().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.t0.c.g<?, Float> gVar2 = this.f482l;
        float fFloatValue5 = gVar2 != null ? gVar2.h().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f = ((fFloatValue2 - fFloatValue3) * f10) + fFloatValue3;
            i2 = i3;
            double d5 = f;
            d = d4;
            fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.a.moveTo(fCos, fSin);
            d2 = radians + ((f8 * f10) / 2.0f);
        } else {
            d = d4;
            i2 = i3;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.a.moveTo(fCos2, fSin2);
            d2 = radians + f9;
            fCos = fCos2;
            fSin = fSin2;
            f = 0.0f;
        }
        double dCeil = Math.ceil(d) * 2.0d;
        int i4 = 0;
        boolean z = false;
        while (true) {
            double d7 = i4;
            if (d7 >= dCeil) {
                PointF pointFH = this.g.h();
                this.a.offset(pointFH.x, pointFH.y);
                this.a.close();
                return;
            }
            float f11 = z ? fFloatValue2 : fFloatValue3;
            if (f == 0.0f || d7 != dCeil - 2.0d) {
                f2 = f8;
                f3 = f9;
            } else {
                f2 = f8;
                f3 = (f8 * f10) / 2.0f;
            }
            if (f == 0.0f || d7 != dCeil - 1.0d) {
                f4 = f9;
                d3 = d7;
                f5 = f11;
            } else {
                f4 = f9;
                d3 = d7;
                f5 = f;
            }
            double d8 = f5;
            double d9 = dCeil;
            float fCos3 = (float) (d8 * Math.cos(d2));
            float fSin3 = (float) (d8 * Math.sin(d2));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.a.lineTo(fCos3, fSin3);
                f6 = fFloatValue4;
                f7 = f;
            } else {
                f6 = fFloatValue4;
                f7 = f;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f12 = z ? f6 : fFloatValue5;
                float f13 = z ? fFloatValue5 : f6;
                float f14 = (z ? fFloatValue3 : fFloatValue2) * f12 * 0.47829f;
                float f15 = fCos4 * f14;
                float f16 = f14 * fSin4;
                float f17 = (z ? fFloatValue2 : fFloatValue3) * f13 * 0.47829f;
                float f18 = fCos5 * f17;
                float f19 = f17 * fSin5;
                if (i2 != 0) {
                    if (i4 == 0) {
                        f15 *= f10;
                        f16 *= f10;
                    } else if (d3 == d9 - 1.0d) {
                        f18 *= f10;
                        f19 *= f10;
                    }
                }
                this.a.cubicTo(fCos - f15, fSin - f16, fCos3 + f18, fSin3 + f19, fCos3, fSin3);
            }
            d2 += f3;
            z = !z;
            i4++;
            fCos = fCos3;
            fSin = fSin3;
            fFloatValue4 = f6;
            f = f7;
            f9 = f4;
            f8 = f2;
            dCeil = d9;
        }
    }

    private void i() {
        this.f484n = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        i();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVar = list.get(i2);
            if (eVar instanceof w) {
                w wVar = (w) eVar;
                if (wVar.i() == com.airbnb.lottie.v0.l.w.SIMULTANEOUSLY) {
                    this.f483m.a(wVar);
                    wVar.b(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        com.airbnb.lottie.t0.c.g<?, Float> gVar;
        com.airbnb.lottie.t0.c.g<?, Float> gVar2;
        if (t == j0.s) {
            this.f.m(cVar);
            return;
        }
        if (t == j0.t) {
            this.f478h.m(cVar);
            return;
        }
        if (t == j0.f440j) {
            this.g.m(cVar);
            return;
        }
        if (t == j0.u && (gVar2 = this.f479i) != null) {
            gVar2.m(cVar);
            return;
        }
        if (t == j0.v) {
            this.f480j.m(cVar);
            return;
        }
        if (t == j0.w && (gVar = this.f481k) != null) {
            gVar.m(cVar);
        } else if (t == j0.x) {
            this.f482l.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        if (this.f484n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.f484n = true;
            return this.a;
        }
        int i2 = q.a[this.d.ordinal()];
        if (i2 == 1) {
            h();
        } else if (i2 == 2) {
            b();
        }
        this.a.close();
        this.f483m.b(this.a);
        this.f484n = true;
        return this.a;
    }
}
