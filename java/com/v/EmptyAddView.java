package com.v;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class EmptyAddView extends RelativeLayout {
    public EmptyAddView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        try {
            View viewFindViewById = findViewById(j.b.e.E3);
            com.frame.v0 v0VarG = com.frame.v0.g();
            int i2 = j.b.a.e;
            viewFindViewById.startAnimation(AnimationUtils.loadAnimation(v0VarG, i2));
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(com.frame.v0.g(), i2);
            animationLoadAnimation.setStartOffset(800L);
            findViewById(j.b.e.F3).startAnimation(animationLoadAnimation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(com.frame.v0.g(), j.b.f.n1, this);
    }

    public EmptyAddView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyAddView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
