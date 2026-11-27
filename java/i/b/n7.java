package i.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes.dex */
class n7 extends ScrollView {
    final /* synthetic */ Activity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n7(Context context, Activity activity) {
        super(context);
        this.c = activity;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMax = Math.max(o7.d(this.c, 100), this.c.getResources().getDisplayMetrics().heightPixels - o7.d(this.c, 220));
        if (View.MeasureSpec.getMode(i3) != 0) {
            iMax = Math.min(iMax, View.MeasureSpec.getSize(i3));
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE));
    }
}
