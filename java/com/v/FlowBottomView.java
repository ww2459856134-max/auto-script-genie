package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class FlowBottomView extends LinearLayout {
    public FlowBottomView(Context context) {
        super(context);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        TextView textView = new TextView(com.frame.v0.g());
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        int iC = com.frame.p1.c(10.0f);
        int iC2 = com.frame.p1.c(12.0f);
        textView.setTextSize(12.0f);
        textView.setPadding(iC, iC2, iC, iC2);
        addView(textView);
    }

    public void b() {
        startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.b));
        setVisibility(8);
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    public void d() {
        setVisibility(0);
        startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.f));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public FlowBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlowBottomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
