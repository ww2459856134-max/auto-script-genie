package com.airbnb.lottie.t0.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.j0;
import java.util.Collections;

/* loaded from: classes.dex */
public class u {
    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    private g<PointF, PointF> f;
    private g<?, PointF> g;

    /* renamed from: h, reason: collision with root package name */
    private g<com.airbnb.lottie.z0.d, com.airbnb.lottie.z0.d> f506h;

    /* renamed from: i, reason: collision with root package name */
    private g<Float, Float> f507i;

    /* renamed from: j, reason: collision with root package name */
    private g<Integer, Integer> f508j;

    /* renamed from: k, reason: collision with root package name */
    private i f509k;

    /* renamed from: l, reason: collision with root package name */
    private i f510l;

    /* renamed from: m, reason: collision with root package name */
    private g<?, Float> f511m;

    /* renamed from: n, reason: collision with root package name */
    private g<?, Float> f512n;

    public u(com.airbnb.lottie.v0.k.l lVar) {
        this.f = lVar.c() == null ? null : lVar.c().a();
        this.g = lVar.f() == null ? null : lVar.f().a();
        this.f506h = lVar.h() == null ? null : lVar.h().a();
        this.f507i = lVar.g() == null ? null : lVar.g().a();
        i iVar = lVar.i() == null ? null : (i) lVar.i().a();
        this.f509k = iVar;
        if (iVar != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.f510l = lVar.j() == null ? null : (i) lVar.j().a();
        if (lVar.e() != null) {
            this.f508j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f511m = lVar.k().a();
        } else {
            this.f511m = null;
        }
        if (lVar.d() != null) {
            this.f512n = lVar.d().a();
        } else {
            this.f512n = null;
        }
    }

    private void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.e[i2] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.v0.m.c cVar) {
        cVar.i(this.f508j);
        cVar.i(this.f511m);
        cVar.i(this.f512n);
        cVar.i(this.f);
        cVar.i(this.g);
        cVar.i(this.f506h);
        cVar.i(this.f507i);
        cVar.i(this.f509k);
        cVar.i(this.f510l);
    }

    public void b(b bVar) {
        g<Integer, Integer> gVar = this.f508j;
        if (gVar != null) {
            gVar.a(bVar);
        }
        g<?, Float> gVar2 = this.f511m;
        if (gVar2 != null) {
            gVar2.a(bVar);
        }
        g<?, Float> gVar3 = this.f512n;
        if (gVar3 != null) {
            gVar3.a(bVar);
        }
        g<PointF, PointF> gVar4 = this.f;
        if (gVar4 != null) {
            gVar4.a(bVar);
        }
        g<?, PointF> gVar5 = this.g;
        if (gVar5 != null) {
            gVar5.a(bVar);
        }
        g<com.airbnb.lottie.z0.d, com.airbnb.lottie.z0.d> gVar6 = this.f506h;
        if (gVar6 != null) {
            gVar6.a(bVar);
        }
        g<Float, Float> gVar7 = this.f507i;
        if (gVar7 != null) {
            gVar7.a(bVar);
        }
        i iVar = this.f509k;
        if (iVar != null) {
            iVar.a(bVar);
        }
        i iVar2 = this.f510l;
        if (iVar2 != null) {
            iVar2.a(bVar);
        }
    }

    public <T> boolean c(T t, com.airbnb.lottie.z0.c<T> cVar) {
        i iVar;
        i iVar2;
        g<?, Float> gVar;
        g<?, Float> gVar2;
        if (t == j0.e) {
            g<PointF, PointF> gVar3 = this.f;
            if (gVar3 == null) {
                this.f = new v(cVar, new PointF());
                return true;
            }
            gVar3.m(cVar);
            return true;
        }
        if (t == j0.f) {
            g<?, PointF> gVar4 = this.g;
            if (gVar4 == null) {
                this.g = new v(cVar, new PointF());
                return true;
            }
            gVar4.m(cVar);
            return true;
        }
        if (t == j0.f441k) {
            g<com.airbnb.lottie.z0.d, com.airbnb.lottie.z0.d> gVar5 = this.f506h;
            if (gVar5 == null) {
                this.f506h = new v(cVar, new com.airbnb.lottie.z0.d());
                return true;
            }
            gVar5.m(cVar);
            return true;
        }
        if (t == j0.f442l) {
            g<Float, Float> gVar6 = this.f507i;
            if (gVar6 == null) {
                this.f507i = new v(cVar, Float.valueOf(0.0f));
                return true;
            }
            gVar6.m(cVar);
            return true;
        }
        if (t == j0.c) {
            g<Integer, Integer> gVar7 = this.f508j;
            if (gVar7 == null) {
                this.f508j = new v(cVar, 100);
                return true;
            }
            gVar7.m(cVar);
            return true;
        }
        if (t == j0.y && (gVar2 = this.f511m) != null) {
            if (gVar2 == null) {
                this.f511m = new v(cVar, 100);
                return true;
            }
            gVar2.m(cVar);
            return true;
        }
        if (t == j0.z && (gVar = this.f512n) != null) {
            if (gVar == null) {
                this.f512n = new v(cVar, 100);
                return true;
            }
            gVar.m(cVar);
            return true;
        }
        if (t == j0.f443m && (iVar2 = this.f509k) != null) {
            if (iVar2 == null) {
                this.f509k = new i(Collections.singletonList(new com.airbnb.lottie.z0.a(Float.valueOf(0.0f))));
            }
            this.f509k.m(cVar);
            return true;
        }
        if (t != j0.f444n || (iVar = this.f510l) == null) {
            return false;
        }
        if (iVar == null) {
            this.f510l = new i(Collections.singletonList(new com.airbnb.lottie.z0.a(Float.valueOf(0.0f))));
        }
        this.f510l.m(cVar);
        return true;
    }

    public g<?, Float> e() {
        return this.f512n;
    }

    public Matrix f() {
        this.a.reset();
        g<?, PointF> gVar = this.g;
        if (gVar != null) {
            PointF pointFH = gVar.h();
            float f = pointFH.x;
            if (f != 0.0f || pointFH.y != 0.0f) {
                this.a.preTranslate(f, pointFH.y);
            }
        }
        g<Float, Float> gVar2 = this.f507i;
        if (gVar2 != null) {
            float fFloatValue = gVar2 instanceof v ? gVar2.h().floatValue() : ((i) gVar2).o();
            if (fFloatValue != 0.0f) {
                this.a.preRotate(fFloatValue);
            }
        }
        if (this.f509k != null) {
            float fCos = this.f510l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.o()) + 90.0f));
            float fSin = this.f510l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.o()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f509k.o()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        g<com.airbnb.lottie.z0.d, com.airbnb.lottie.z0.d> gVar3 = this.f506h;
        if (gVar3 != null) {
            com.airbnb.lottie.z0.d dVarH = gVar3.h();
            if (dVarH.b() != 1.0f || dVarH.c() != 1.0f) {
                this.a.preScale(dVarH.b(), dVarH.c());
            }
        }
        g<PointF, PointF> gVar4 = this.f;
        if (gVar4 != null) {
            PointF pointFH2 = gVar4.h();
            float f3 = pointFH2.x;
            if (f3 != 0.0f || pointFH2.y != 0.0f) {
                this.a.preTranslate(-f3, -pointFH2.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f) {
        g<?, PointF> gVar = this.g;
        PointF pointFH = gVar == null ? null : gVar.h();
        g<com.airbnb.lottie.z0.d, com.airbnb.lottie.z0.d> gVar2 = this.f506h;
        com.airbnb.lottie.z0.d dVarH = gVar2 == null ? null : gVar2.h();
        this.a.reset();
        if (pointFH != null) {
            this.a.preTranslate(pointFH.x * f, pointFH.y * f);
        }
        if (dVarH != null) {
            double d = f;
            this.a.preScale((float) Math.pow(dVarH.b(), d), (float) Math.pow(dVarH.c(), d));
        }
        g<Float, Float> gVar3 = this.f507i;
        if (gVar3 != null) {
            float fFloatValue = gVar3.h().floatValue();
            g<PointF, PointF> gVar4 = this.f;
            PointF pointFH2 = gVar4 != null ? gVar4.h() : null;
            this.a.preRotate(fFloatValue * f, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.a;
    }

    public g<?, Integer> h() {
        return this.f508j;
    }

    public g<?, Float> i() {
        return this.f511m;
    }

    public void j(float f) {
        g<Integer, Integer> gVar = this.f508j;
        if (gVar != null) {
            gVar.l(f);
        }
        g<?, Float> gVar2 = this.f511m;
        if (gVar2 != null) {
            gVar2.l(f);
        }
        g<?, Float> gVar3 = this.f512n;
        if (gVar3 != null) {
            gVar3.l(f);
        }
        g<PointF, PointF> gVar4 = this.f;
        if (gVar4 != null) {
            gVar4.l(f);
        }
        g<?, PointF> gVar5 = this.g;
        if (gVar5 != null) {
            gVar5.l(f);
        }
        g<com.airbnb.lottie.z0.d, com.airbnb.lottie.z0.d> gVar6 = this.f506h;
        if (gVar6 != null) {
            gVar6.l(f);
        }
        g<Float, Float> gVar7 = this.f507i;
        if (gVar7 != null) {
            gVar7.l(f);
        }
        i iVar = this.f509k;
        if (iVar != null) {
            iVar.l(f);
        }
        i iVar2 = this.f510l;
        if (iVar2 != null) {
            iVar2.l(f);
        }
    }
}
