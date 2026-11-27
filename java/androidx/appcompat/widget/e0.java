package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* loaded from: classes.dex */
class e0 implements Runnable {
    final /* synthetic */ TextView c;
    final /* synthetic */ Typeface d;
    final /* synthetic */ int e;

    e0(f0 f0Var, TextView textView, Typeface typeface, int i2) {
        this.c = textView;
        this.d = typeface;
        this.e = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.setTypeface(this.d, this.e);
    }
}
