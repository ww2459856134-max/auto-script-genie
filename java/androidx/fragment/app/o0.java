package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* loaded from: classes.dex */
abstract class o0 {
    static void a(Fragment fragment, m0 m0Var, m2 m2Var) {
        View view = fragment.h0;
        ViewGroup viewGroup = fragment.g0;
        viewGroup.startViewTransition(view);
        h.e.f.c cVar = new h.e.f.c();
        cVar.c(new i0(fragment));
        m2Var.b(fragment, cVar);
        if (m0Var.a != null) {
            n0 n0Var = new n0(m0Var.a, viewGroup, view);
            fragment.D1(fragment.h0);
            n0Var.setAnimationListener(new k0(viewGroup, fragment, m2Var, cVar));
            fragment.h0.startAnimation(n0Var);
            return;
        }
        Animator animator = m0Var.b;
        fragment.F1(animator);
        animator.addListener(new l0(viewGroup, view, fragment, m2Var, cVar));
        animator.setTarget(fragment.h0);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.N() : fragment.O() : z ? fragment.y() : fragment.B();
    }

    static m0 c(Context context, Fragment fragment, boolean z, boolean z2) {
        int iJ = fragment.J();
        int iB = b(fragment, z, z2);
        boolean z3 = false;
        fragment.E1(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.g0;
        if (viewGroup != null) {
            int i2 = h.j.b.c;
            if (viewGroup.getTag(i2) != null) {
                fragment.g0.setTag(i2, null);
            }
        }
        ViewGroup viewGroup2 = fragment.g0;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationW0 = fragment.w0(iJ, z, iB);
        if (animationW0 != null) {
            return new m0(animationW0);
        }
        Animator animatorX0 = fragment.x0(iJ, z, iB);
        if (animatorX0 != null) {
            return new m0(animatorX0);
        }
        if (iB == 0 && iJ != 0) {
            iB = d(iJ, z);
        }
        if (iB != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iB));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation != null) {
                        return new m0(animationLoadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iB);
                    if (animatorLoadAnimator != null) {
                        return new m0(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation2 != null) {
                        return new m0(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int d(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? h.j.a.e : h.j.a.f;
        }
        if (i2 == 4099) {
            return z ? h.j.a.c : h.j.a.d;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z ? h.j.a.a : h.j.a.b;
    }
}
