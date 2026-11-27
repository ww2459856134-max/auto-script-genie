package com.airbnb.lottie.v0.m;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.t0.c.v;

/* loaded from: classes.dex */
public class l extends c {
    private final Path A;
    private final i B;
    private com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> C;
    private final RectF x;
    private final Paint y;
    private final float[] z;

    l(e0 e0Var, i iVar) {
        super(e0Var, iVar);
        this.x = new RectF();
        com.airbnb.lottie.t0.a aVar = new com.airbnb.lottie.t0.a();
        this.y = aVar;
        this.z = new float[8];
        this.A = new Path();
        this.B = iVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(iVar.m());
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.x.set(0.0f, 0.0f, this.B.o(), this.B.n());
        this.f539m.mapRect(this.x);
        rectF.set(this.x);
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        super.f(t, cVar);
        if (t == j0.C) {
            if (cVar == null) {
                this.C = null;
            } else {
                this.C = new v(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.v0.m.c
    public void t(Canvas canvas, Matrix matrix, int i2) {
        int iAlpha = Color.alpha(this.B.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i2 / 255.0f) * (((iAlpha / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        this.y.setAlpha(iIntValue);
        com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.C;
        if (gVar != null) {
            this.y.setColorFilter(gVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.B.o();
            float[] fArr2 = this.z;
            fArr2[3] = 0.0f;
            fArr2[4] = this.B.o();
            this.z[5] = this.B.n();
            float[] fArr3 = this.z;
            fArr3[6] = 0.0f;
            fArr3[7] = this.B.n();
            matrix.mapPoints(this.z);
            this.A.reset();
            Path path = this.A;
            float[] fArr4 = this.z;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.A;
            float[] fArr5 = this.z;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.A;
            float[] fArr6 = this.z;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.A;
            float[] fArr7 = this.z;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.A;
            float[] fArr8 = this.z;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.A.close();
            canvas.drawPath(this.A, this.y);
        }
    }
}
