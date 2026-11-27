package h.e.h;

import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import h.e.h.b;

/* loaded from: classes.dex */
public class a {
    private final TextPaint a;
    private TextDirectionHeuristic b;
    private int c;
    private int d;

    public a(TextPaint textPaint) {
        this.a = textPaint;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            this.c = 1;
            this.d = 1;
        } else {
            this.d = 0;
            this.c = 0;
        }
        if (i2 >= 18) {
            this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        } else {
            this.b = null;
        }
    }

    public b.a a() {
        return new b.a(this.a, this.b, this.c, this.d);
    }

    public a b(int i2) {
        this.c = i2;
        return this;
    }

    public a c(int i2) {
        this.d = i2;
        return this;
    }

    public a d(TextDirectionHeuristic textDirectionHeuristic) {
        this.b = textDirectionHeuristic;
        return this;
    }
}
