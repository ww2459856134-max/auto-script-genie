package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;

/* loaded from: classes.dex */
public class k extends c {

    /* renamed from: o, reason: collision with root package name */
    private final String f477o;
    private final boolean p;
    private final h.d.f<LinearGradient> q;
    private final h.d.f<RadialGradient> r;
    private final RectF s;
    private final com.airbnb.lottie.v0.l.f t;
    private final int u;
    private final com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.c, com.airbnb.lottie.v0.l.c> v;
    private final com.airbnb.lottie.t0.c.g<PointF, PointF> w;
    private final com.airbnb.lottie.t0.c.g<PointF, PointF> x;
    private com.airbnb.lottie.t0.c.v y;

    public k(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.e eVar) {
        super(e0Var, cVar, eVar.b().a(), eVar.g().a(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.q = new h.d.f<>();
        this.r = new h.d.f<>();
        this.s = new RectF();
        this.f477o = eVar.j();
        this.t = eVar.f();
        this.p = eVar.n();
        this.u = (int) (e0Var.m().d() / 32.0f);
        com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.c, com.airbnb.lottie.v0.l.c> gVarA = eVar.e().a();
        this.v = gVarA;
        gVarA.a(this);
        cVar.i(gVarA);
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA2 = eVar.l().a();
        this.w = gVarA2;
        gVarA2.a(this);
        cVar.i(gVarA2);
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA3 = eVar.d().a();
        this.x = gVarA3;
        gVarA3.a(this);
        cVar.i(gVarA3);
    }

    private int[] i(int[] iArr) {
        com.airbnb.lottie.t0.c.v vVar = this.y;
        if (vVar != null) {
            Integer[] numArr = (Integer[]) vVar.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int iRound = Math.round(this.w.f() * this.u);
        int iRound2 = Math.round(this.x.f() * this.u);
        int iRound3 = Math.round(this.v.f() * this.u);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient k() {
        long j2 = j();
        LinearGradient linearGradientF = this.q.f(j2);
        if (linearGradientF != null) {
            return linearGradientF;
        }
        PointF pointFH = this.w.h();
        PointF pointFH2 = this.x.h();
        com.airbnb.lottie.v0.l.c cVarH = this.v.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, i(cVarH.a()), cVarH.b(), Shader.TileMode.CLAMP);
        this.q.j(j2, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        long j2 = j();
        RadialGradient radialGradientF = this.r.f(j2);
        if (radialGradientF != null) {
            return radialGradientF;
        }
        PointF pointFH = this.w.h();
        PointF pointFH2 = this.x.h();
        com.airbnb.lottie.v0.l.c cVarH = this.v.h();
        int[] iArrI = i(cVarH.a());
        float[] fArrB = cVarH.b();
        RadialGradient radialGradient = new RadialGradient(pointFH.x, pointFH.y, (float) Math.hypot(pointFH2.x - r7, pointFH2.y - r8), iArrI, fArrB, Shader.TileMode.CLAMP);
        this.r.j(j2, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.t0.b.c, com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        if (this.p) {
            return;
        }
        a(this.s, matrix, false);
        Shader shaderK = this.t == com.airbnb.lottie.v0.l.f.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.f455i.setShader(shaderK);
        super.c(canvas, matrix, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.t0.b.c, com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        super.f(t, cVar);
        if (t == j0.D) {
            com.airbnb.lottie.t0.c.v vVar = this.y;
            if (vVar != null) {
                this.f.C(vVar);
            }
            if (cVar == null) {
                this.y = null;
                return;
            }
            com.airbnb.lottie.t0.c.v vVar2 = new com.airbnb.lottie.t0.c.v(cVar);
            this.y = vVar2;
            vVar2.a(this);
            this.f.i(this.y);
        }
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.f477o;
    }
}
