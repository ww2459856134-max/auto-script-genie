package i.b.ia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.frame.p1;
import com.yl.model.Node;

/* loaded from: classes.dex */
public abstract class b extends RectF {
    protected static Paint A;
    protected static PathEffect C;

    /* renamed from: k, reason: collision with root package name */
    protected static Paint f1505k;
    protected static Paint t;
    public long c;
    public String d;
    public Node e;
    protected int f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1506h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1507i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1508j;

    public b() {
        if (f1505k == null) {
            Paint paint = new Paint();
            f1505k = paint;
            paint.setColor(Color.parseColor("#AAB7C4"));
            f1505k.setTextAlign(Paint.Align.CENTER);
            f1505k.setAntiAlias(true);
            f1505k.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            t = paint2;
            paint2.setColor(Color.parseColor("#67B3EC"));
            t.setStrokeWidth(p1.c(2.0f));
            t.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            A = paint3;
            paint3.setColor(Color.parseColor("#99ffffff"));
            A.setStrokeWidth(p1.c(2.0f));
            A.setStyle(Paint.Style.FILL_AND_STROKE);
            C = new CornerPathEffect(p1.c(5.0f));
        }
    }

    public void a(Canvas canvas) {
        f1505k.setTextSize(22.0f);
        Paint.FontMetrics fontMetrics = f1505k.getFontMetrics();
        canvas.drawText(this.d, (int) centerX(), (int) ((centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), f1505k);
    }

    public long b() {
        return this.c;
    }

    public abstract void c(Canvas canvas);

    public void d(int i2) {
        this.f = i2;
    }
}
