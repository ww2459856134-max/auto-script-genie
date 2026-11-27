package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class n0 implements Animator.AnimatorListener {
    final float a;
    final float b;
    final float c;
    final float d;
    final RecyclerView.d0 e;
    final int f;
    private final ValueAnimator g;

    /* renamed from: h, reason: collision with root package name */
    boolean f362h;

    /* renamed from: i, reason: collision with root package name */
    float f363i;

    /* renamed from: j, reason: collision with root package name */
    float f364j;

    /* renamed from: k, reason: collision with root package name */
    boolean f365k = false;

    /* renamed from: l, reason: collision with root package name */
    boolean f366l = false;

    /* renamed from: m, reason: collision with root package name */
    private float f367m;

    n0(RecyclerView.d0 d0Var, int i2, int i3, float f, float f2, float f3, float f4) {
        this.f = i3;
        this.e = d0Var;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new m0(this));
        valueAnimatorOfFloat.setTarget(d0Var.itemView);
        valueAnimatorOfFloat.addListener(this);
        c(0.0f);
    }

    public void a() {
        this.g.cancel();
    }

    public void b(long j2) {
        this.g.setDuration(j2);
    }

    public void c(float f) {
        this.f367m = f;
    }

    public void d() {
        this.e.setIsRecyclable(false);
        this.g.start();
    }

    public void e() {
        float f = this.a;
        float f2 = this.c;
        if (f == f2) {
            this.f363i = this.e.itemView.getTranslationX();
        } else {
            this.f363i = f + (this.f367m * (f2 - f));
        }
        float f3 = this.b;
        float f4 = this.d;
        if (f3 == f4) {
            this.f364j = this.e.itemView.getTranslationY();
        } else {
            this.f364j = f3 + (this.f367m * (f4 - f3));
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        c(1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f366l) {
            this.e.setIsRecyclable(true);
        }
        this.f366l = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
