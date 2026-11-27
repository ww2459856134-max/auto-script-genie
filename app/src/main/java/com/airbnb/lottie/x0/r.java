package com.airbnb.lottie.x0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class r {
    private static h.d.j<WeakReference<Interpolator>> b;
    private static final Interpolator a = new LinearInterpolator();
    static com.airbnb.lottie.x0.l0.c c = com.airbnb.lottie.x0.l0.c.a("t", "s", "e", "o", "i", "h", "to", "ti");

    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReferenceE;
        synchronized (r.class) {
            weakReferenceE = e().e(i2);
        }
        return weakReferenceE;
    }

    static <T> com.airbnb.lottie.z0.a<T> b(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, float f, k0<T> k0Var, boolean z) throws IOException {
        return z ? c(eVar2, eVar, f, k0Var) : d(eVar, f, k0Var);
    }

    private static <T> com.airbnb.lottie.z0.a<T> c(com.airbnb.lottie.e eVar, com.airbnb.lottie.x0.l0.e eVar2, float f, k0<T> k0Var) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator interpolatorA;
        eVar2.d();
        boolean z = false;
        float fO = 0.0f;
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        while (eVar2.m()) {
            switch (eVar2.y(c)) {
                case 0:
                    fO = (float) eVar2.o();
                    break;
                case 1:
                    tA2 = k0Var.a(eVar2, f);
                    break;
                case 2:
                    tA = k0Var.a(eVar2, f);
                    break;
                case 3:
                    pointFE = q.e(eVar2, f);
                    break;
                case 4:
                    pointFE2 = q.e(eVar2, f);
                    break;
                case 5:
                    if (eVar2.p() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointFE4 = q.e(eVar2, f);
                    break;
                case 7:
                    pointFE3 = q.e(eVar2, f);
                    break;
                default:
                    eVar2.B();
                    break;
            }
        }
        eVar2.i();
        if (z) {
            interpolator = a;
            t = tA2;
        } else {
            if (pointFE == null || pointFE2 == null) {
                interpolator = a;
            } else {
                float f2 = -f;
                pointFE.x = com.airbnb.lottie.y0.g.b(pointFE.x, f2, f);
                pointFE.y = com.airbnb.lottie.y0.g.b(pointFE.y, -100.0f, 100.0f);
                pointFE2.x = com.airbnb.lottie.y0.g.b(pointFE2.x, f2, f);
                float fB = com.airbnb.lottie.y0.g.b(pointFE2.y, -100.0f, 100.0f);
                pointFE2.y = fB;
                int i2 = com.airbnb.lottie.y0.h.i(pointFE.x, pointFE.y, pointFE2.x, fB);
                WeakReference<Interpolator> weakReferenceA = a(i2);
                Interpolator interpolator2 = weakReferenceA != null ? weakReferenceA.get() : null;
                if (weakReferenceA == null || interpolator2 == null) {
                    pointFE.x /= f;
                    pointFE.y /= f;
                    float f3 = pointFE2.x / f;
                    pointFE2.x = f3;
                    float f4 = pointFE2.y / f;
                    pointFE2.y = f4;
                    try {
                        interpolatorA = h.e.j.r1.b.a(pointFE.x, pointFE.y, f3, f4);
                    } catch (IllegalArgumentException e) {
                        interpolatorA = e.getMessage().equals("The Path cannot loop back on itself.") ? h.e.j.r1.b.a(Math.min(pointFE.x, 1.0f), pointFE.y, Math.max(pointFE2.x, 0.0f), pointFE2.y) : new LinearInterpolator();
                    }
                    interpolator2 = interpolatorA;
                    try {
                        f(i2, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            }
            t = tA;
        }
        com.airbnb.lottie.z0.a<T> aVar = new com.airbnb.lottie.z0.a<>(eVar, tA2, t, interpolator, fO, null);
        aVar.f570m = pointFE4;
        aVar.f571n = pointFE3;
        return aVar;
    }

    private static <T> com.airbnb.lottie.z0.a<T> d(com.airbnb.lottie.x0.l0.e eVar, float f, k0<T> k0Var) throws IOException {
        return new com.airbnb.lottie.z0.a<>(k0Var.a(eVar, f));
    }

    private static h.d.j<WeakReference<Interpolator>> e() {
        if (b == null) {
            b = new h.d.j<>();
        }
        return b;
    }

    private static void f(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (r.class) {
            b.h(i2, weakReference);
        }
    }
}
