package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes.dex */
class a implements i {
    a(b bVar) {
    }

    @Override // androidx.cardview.widget.i
    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
