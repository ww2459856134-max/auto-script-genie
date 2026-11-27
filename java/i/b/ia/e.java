package i.b.ia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class e extends b {
    @Override // i.b.ia.b
    public void c(Canvas canvas) {
        float f = ((RectF) this).right - ((RectF) this).left;
        float f2 = ((RectF) this).bottom - ((RectF) this).top;
        Path path = new Path();
        float f3 = f / 2.0f;
        path.moveTo(((RectF) this).left + f3, ((RectF) this).top);
        float f4 = f2 / 2.0f;
        path.lineTo(((RectF) this).left + f, ((RectF) this).top + f4);
        path.lineTo(((RectF) this).left + f3, ((RectF) this).top + f2);
        path.lineTo(((RectF) this).left, ((RectF) this).top + f4);
        path.lineTo(((RectF) this).left + f3, ((RectF) this).top);
        path.close();
        b.f1505k.setColor(-16777216);
        b.A.setPathEffect(b.C);
        b.t.setPathEffect(b.C);
        int i2 = this.f;
        if (i2 == 1) {
            b.A.setColor(Color.parseColor("#998AE6DD"));
            b.t.setColor(Color.parseColor("#48D2CF"));
        } else if (i2 == 2) {
            b.A.setColor(Color.parseColor("#118AE6DD"));
            b.t.setColor(Color.parseColor("#1148D2CF"));
            b.f1505k.setColor(Color.parseColor("#44B0B0B0"));
        } else if (i2 != 3) {
            b.A.setColor(Color.parseColor("#99E7FEFA"));
            b.t.setColor(Color.parseColor("#8FE5E0"));
        } else {
            b.t.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{10.0f, 4.0f}, 0.0f), b.C));
            b.A.setColor(Color.parseColor("#99FCD593"));
            b.t.setColor(Color.parseColor("#FBA847"));
        }
        canvas.drawPath(path, b.A);
        canvas.drawPath(path, b.t);
        a(canvas);
    }
}
