package com.jsj.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.v0;

/* loaded from: classes.dex */
public class PreviewCustomView extends RelativeLayout implements Animation.AnimationListener {
    Animation c;
    Animation d;
    View e;
    View f;

    public PreviewCustomView(Context context) throws Resources.NotFoundException {
        super(context);
        this.c = null;
        onFinishInflate();
    }

    public void a() {
        this.e.startAnimation(this.d);
        this.f.startAnimation(this.c);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        a();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.View
    protected void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), 2130772011);
        this.c = animationLoadAnimation;
        animationLoadAnimation.setAnimationListener(this);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130771999);
        this.d = animationLoadAnimation2;
        animationLoadAnimation2.setDuration(1500L);
        View.inflate(getContext(), 2131493168, this);
        this.f = findViewById(2131296832);
        this.e = findViewById(2131296834);
        ((TextView) findViewById(2131297245)).setText(v0.g().getString(2131558527));
    }

    public PreviewCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
    }

    public PreviewCustomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = null;
    }
}
