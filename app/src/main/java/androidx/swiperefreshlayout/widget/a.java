package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.shapes.OvalShape;

/* loaded from: classes.dex */
class a extends OvalShape {
    private RadialGradient c;
    private Paint d = new Paint();
    final /* synthetic */ b e;

    a(b bVar, int i2) {
        this.e = bVar;
        bVar.d = i2;
        a((int) rect().width());
    }

    private void a(int i2) {
        float f = i2 / 2;
        RadialGradient radialGradient = new RadialGradient(f, f, this.e.d, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
        this.c = radialGradient;
        this.d.setShader(radialGradient);
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        float width = this.e.getWidth() / 2;
        float height = this.e.getHeight() / 2;
        canvas.drawCircle(width, height, width, this.d);
        canvas.drawCircle(width, height, r0 - this.e.d, paint);
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        a((int) f);
    }
}
