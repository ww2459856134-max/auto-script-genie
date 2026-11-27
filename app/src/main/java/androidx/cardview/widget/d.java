package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes.dex */
class d implements i {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    @Override // androidx.cardview.widget.i
    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        float f2 = 2.0f * f;
        float fWidth = (rectF.width() - f2) - 1.0f;
        float fHeight = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.a.a.set(f4, f4, f3, f3);
            int iSave = canvas.save();
            canvas.translate(rectF.left + f3, rectF.top + f3);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.translate(fHeight, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(iSave);
            float f5 = (rectF.left + f3) - 1.0f;
            float f6 = rectF.top;
            canvas.drawRect(f5, f6, (rectF.right - f3) + 1.0f, f6 + f3, paint);
            float f7 = (rectF.left + f3) - 1.0f;
            float f8 = rectF.bottom;
            canvas.drawRect(f7, f8 - f3, (rectF.right - f3) + 1.0f, f8, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
    }
}
