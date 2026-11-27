package com.yl.widget.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class SWheelView extends WheelView {
    public SWheelView(Context context) {
        this(context, null);
    }

    @Override // com.yl.widget.wheel.WheelView, android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 1 && action != 2) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public SWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
