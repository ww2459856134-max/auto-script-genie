package i.b.ia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Path;
import android.graphics.RectF;
import com.frame.p1;

/* loaded from: classes.dex */
public class d extends b {
    @Override // i.b.ia.b
    public void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(((RectF) this).right, ((RectF) this).top);
        path.lineTo(((RectF) this).right, ((RectF) this).bottom);
        path.lineTo(((RectF) this).left, ((RectF) this).bottom);
        path.lineTo(((RectF) this).left, ((RectF) this).top);
        path.lineTo(((RectF) this).right, ((RectF) this).top);
        path.close();
        CornerPathEffect cornerPathEffect = new CornerPathEffect(p1.c(5.0f));
        b.A.setPathEffect(cornerPathEffect);
        b.f1505k.setColor(-16777216);
        b.t.setPathEffect(cornerPathEffect);
        int i2 = this.f;
        if (i2 == 1) {
            b.A.setColor(Color.parseColor("#9992D5FD"));
            b.t.setColor(Color.parseColor("#40A4FD"));
        } else if (i2 == 2) {
            b.A.setColor(Color.parseColor("#22E7F6FE"));
            b.t.setColor(Color.parseColor("#2267B3EC"));
            b.f1505k.setColor(Color.parseColor("#44B0B0B0"));
        } else if (i2 != 3) {
            b.A.setColor(Color.parseColor("#99E7F6FE"));
            b.t.setColor(Color.parseColor("#67B3EC"));
        } else {
            b.t.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{10.0f, 4.0f}, 0.0f), cornerPathEffect));
            b.A.setColor(Color.parseColor("#99FCD593"));
            b.t.setColor(Color.parseColor("#FBA847"));
        }
        canvas.drawPath(path, b.A);
        canvas.drawPath(path, b.t);
        a(canvas);
    }
}
