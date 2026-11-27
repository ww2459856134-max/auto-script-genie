package com.airbnb.lottie.v0.m;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.t0.c.v;

/* loaded from: classes.dex */
public class f extends c {
    private com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> A;
    private final Paint x;
    private final Rect y;
    private final Rect z;

    f(e0 e0Var, i iVar) {
        super(e0Var, iVar);
        this.x = new com.airbnb.lottie.t0.a(3);
        this.y = new Rect();
        this.z = new Rect();
    }

    private Bitmap J() {
        return this.f540n.q(this.f541o.k());
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (J() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * com.airbnb.lottie.y0.h.e(), r3.getHeight() * com.airbnb.lottie.y0.h.e());
            this.f539m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        super.f(t, cVar);
        if (t == j0.C) {
            if (cVar == null) {
                this.A = null;
            } else {
                this.A = new v(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.v0.m.c
    public void t(Canvas canvas, Matrix matrix, int i2) {
        Bitmap bitmapJ = J();
        if (bitmapJ == null || bitmapJ.isRecycled()) {
            return;
        }
        float fE = com.airbnb.lottie.y0.h.e();
        this.x.setAlpha(i2);
        com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.A;
        if (gVar != null) {
            this.x.setColorFilter(gVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.y.set(0, 0, bitmapJ.getWidth(), bitmapJ.getHeight());
        this.z.set(0, 0, (int) (bitmapJ.getWidth() * fE), (int) (bitmapJ.getHeight() * fE));
        canvas.drawBitmap(bitmapJ, this.y, this.z, this.x);
        canvas.restore();
    }
}
