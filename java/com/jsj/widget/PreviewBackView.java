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
import com.tencent.cursor.R;

/* loaded from: classes.dex */
public class PreviewBackView extends RelativeLayout implements Animation.AnimationListener {
    Animation c;
    Animation d;
    Animation e;
    Animation f;
    View g;

    /* renamed from: h, reason: collision with root package name */
    View f790h;

    /* renamed from: i, reason: collision with root package name */
    TextView f791i;

    /* renamed from: j, reason: collision with root package name */
    private Animation.AnimationListener f792j;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PreviewBackView.this.f791i.setText(v0.g().getString(2131558526));
            PreviewBackView previewBackView = PreviewBackView.this;
            previewBackView.f791i.startAnimation(previewBackView.e);
            PreviewBackView previewBackView2 = PreviewBackView.this;
            previewBackView2.f790h.startAnimation(previewBackView2.d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public PreviewBackView(Context context) throws Resources.NotFoundException {
        super(context);
        this.f792j = new a();
        onFinishInflate();
    }

    public void a() {
        this.f791i.setText(v0.g().getString(2131558525));
        this.f791i.startAnimation(this.e);
        this.g.startAnimation(this.f);
        this.f790h.startAnimation(this.c);
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
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), 2130772009);
        this.c = animationLoadAnimation;
        animationLoadAnimation.setAnimationListener(this.f792j);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772010);
        this.d = animationLoadAnimation2;
        animationLoadAnimation2.setAnimationListener(this);
        this.e = AnimationUtils.loadAnimation(getContext(), R.anim.push_up_in);
        Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(getContext(), 2130771999);
        this.f = animationLoadAnimation3;
        animationLoadAnimation3.setDuration(1500L);
        View.inflate(getContext(), 2131493168, this);
        this.f790h = findViewById(2131296832);
        this.g = findViewById(2131296834);
        ((TextView) findViewById(2131297245)).setText(v0.g().getString(2131558524));
        this.f791i = (TextView) findViewById(2131297218);
    }

    public PreviewBackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f792j = new a();
    }

    public PreviewBackView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f792j = new a();
    }
}
