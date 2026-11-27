package androidx.recyclerview.widget;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class f0 extends n0 {

    /* renamed from: n, reason: collision with root package name */
    final /* synthetic */ int f352n;

    /* renamed from: o, reason: collision with root package name */
    final /* synthetic */ RecyclerView.d0 f353o;
    final /* synthetic */ k0 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f0(k0 k0Var, RecyclerView.d0 d0Var, int i2, int i3, float f, float f2, float f3, float f4, int i4, RecyclerView.d0 d0Var2) {
        super(d0Var, i2, i3, f, f2, f3, f4);
        this.p = k0Var;
        this.f352n = i4;
        this.f353o = d0Var2;
    }

    @Override // androidx.recyclerview.widget.n0, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.f365k) {
            return;
        }
        if (this.f352n <= 0) {
            k0 k0Var = this.p;
            k0Var.f359m.clearView(k0Var.r, this.f353o);
        } else {
            this.p.a.add(this.f353o.itemView);
            this.f362h = true;
            int i2 = this.f352n;
            if (i2 > 0) {
                this.p.y(this, i2);
            }
        }
        k0 k0Var2 = this.p;
        View view = k0Var2.x;
        View view2 = this.f353o.itemView;
        if (view == view2) {
            k0Var2.A(view2);
        }
    }
}
