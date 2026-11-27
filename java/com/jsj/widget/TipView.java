package com.jsj.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.p1;

/* loaded from: classes.dex */
public class TipView extends RelativeLayout {
    private TextView c;
    private View d;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            TipView.this.a();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ViewGroup.LayoutParams a;

        b(ViewGroup.LayoutParams layoutParams) {
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.width = ((Integer) valueAnimator.getAnimatedValue("v")).intValue();
            TipView.this.setLayoutParams(this.a);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            TipView.this.setVisibility(4);
        }
    }

    public TipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void a() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), 2130772002);
        animationLoadAnimation.setFillAfter(true);
        this.c.startAnimation(animationLoadAnimation);
        this.d.startAnimation(animationLoadAnimation);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "v", p1.c(130.0f), 0);
        objectAnimatorOfInt.setDuration(800L);
        objectAnimatorOfInt.addUpdateListener(new b(layoutParams));
        objectAnimatorOfInt.addListener(new c());
        objectAnimatorOfInt.start();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), 2131493186, this);
        setVisibility(4);
        this.d = findViewById(2131296529);
        this.c = (TextView) findViewById(2131297286);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setOnClickListener(new a());
    }

    public TipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TipView(Context context) {
        super(context);
    }
}
