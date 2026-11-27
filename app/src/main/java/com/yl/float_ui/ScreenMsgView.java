package com.yl.float_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.frame.p1;
import com.frame.v0;

/* loaded from: classes.dex */
public class ScreenMsgView extends LinearLayout {
    LinearLayout c;

    public ScreenMsgView(Context context) {
        super(context);
        p1.c(10.0f);
    }

    public ScreenMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p1.c(10.0f);
    }

    public ScreenMsgView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p1.c(10.0f);
    }

    public ScreenMsgView() {
        super(v0.g());
        p1.c(10.0f);
        this.c = this;
        setOrientation(1);
        this.c.setGravity(83);
    }
}
