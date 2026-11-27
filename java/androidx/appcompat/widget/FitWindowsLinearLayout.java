package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.q0;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements q0 {
    private q0.a c;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        q0.a aVar = this.c;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.q0
    public void setOnFitSystemWindowsListener(q0.a aVar) {
        this.c = aVar;
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
