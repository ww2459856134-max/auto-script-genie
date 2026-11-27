package com.airbnb.lottie.y0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.t0.b.m;
import com.airbnb.lottie.v0.l.o;
import java.util.List;

/* loaded from: classes.dex */
public abstract class g {
    private static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int e(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    static int f(float f, float f2) {
        return g((int) f, (int) f2);
    }

    private static int g(int i2, int i3) {
        return i2 - (i3 * e(i2, i3));
    }

    public static void h(o oVar, Path path) {
        path.reset();
        PointF pointFB = oVar.b();
        path.moveTo(pointFB.x, pointFB.y);
        a.set(pointFB.x, pointFB.y);
        for (int i2 = 0; i2 < oVar.a().size(); i2++) {
            com.airbnb.lottie.v0.a aVar = oVar.a().get(i2);
            PointF pointFA = aVar.a();
            PointF pointFB2 = aVar.b();
            PointF pointFC = aVar.c();
            if (pointFA.equals(a) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            a.set(pointFC.x, pointFC.y);
        }
        if (oVar.d()) {
            path.close();
        }
    }

    public static double i(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float j(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int k(int i2, int i3, float f) {
        return (int) (i2 + (f * (i3 - i2)));
    }

    public static void l(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2, m mVar) {
        if (fVar.c(mVar.getName(), i2)) {
            list.add(fVar2.a(mVar.getName()).i(mVar));
        }
    }
}
