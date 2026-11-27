package com.yl.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.airbnb.lottie.LottieAnimationView;
import com.frame.k0;
import com.frame.l1;
import com.frame.s0;
import com.frame.v0;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class i0 {
    static /* synthetic */ void b(PopupWindow popupWindow, Runnable runnable) {
        try {
            popupWindow.dismiss();
        } catch (Exception e) {
            k0.r(e);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void c(Activity activity, String str, String str2, final Runnable runnable, Long l2) {
        if (activity == null) {
            return;
        }
        try {
            WeakReference weakReference = new WeakReference(activity);
            View viewInflate = View.inflate(activity, b0.f1139i, null);
            final PopupWindow popupWindow = new PopupWindow(viewInflate, -1, -1, true);
            popupWindow.setOutsideTouchable(true);
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate.findViewById(a0.a);
            lottieAnimationView.setFailureListener(new com.airbnb.lottie.g0() { // from class: com.yl.ui.j
                @Override // com.airbnb.lottie.g0
                public final void a(Object obj) {
                    lottieAnimationView.setVisibility(8);
                }
            });
            if (!TextUtils.isEmpty(str)) {
                lottieAnimationView.setAnimation(str);
            }
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor(str2)));
            l1.f(new Runnable() { // from class: com.yl.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    i0.b(popupWindow, runnable);
                }
            }, l2.longValue());
            if (weakReference.get() != null) {
                try {
                    popupWindow.showAtLocation(((Activity) weakReference.get()).getWindow().getDecorView(), 17, 0, 0);
                } catch (Exception e) {
                    k0.r(e);
                }
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    static /* synthetic */ void e(View view, Runnable runnable) {
        s0.g().n(view);
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void f(String str, final Runnable runnable, Long l2) {
        try {
            final View viewInflate = View.inflate(v0.g(), b0.f1139i, null);
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate.findViewById(a0.a);
            lottieAnimationView.setFailureListener(new com.airbnb.lottie.g0() { // from class: com.yl.ui.m
                @Override // com.airbnb.lottie.g0
                public final void a(Object obj) {
                    lottieAnimationView.setVisibility(8);
                }
            });
            if (!TextUtils.isEmpty(str)) {
                lottieAnimationView.setAnimation(str);
            }
            viewInflate.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#aa000000")));
            s0.g().D(viewInflate);
            l1.f(new Runnable() { // from class: com.yl.ui.k
                @Override // java.lang.Runnable
                public final void run() {
                    i0.e(viewInflate, runnable);
                }
            }, l2.longValue());
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public static void g(Activity activity, String str, Long l2, Runnable runnable) {
        h(activity, str, "#aa000000", l2, runnable);
    }

    public static void h(Activity activity, final String str, final String str2, final Long l2, final Runnable runnable) {
        if (activity == null) {
            activity = v0.g().d();
        }
        final Activity activity2 = activity;
        l1.e(new Runnable() { // from class: com.yl.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                i0.c(activity2, str, str2, runnable, l2);
            }
        });
    }

    public static void i(final String str, final Long l2, final Runnable runnable) {
        l1.e(new Runnable() { // from class: com.yl.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                i0.f(str, runnable, l2);
            }
        });
    }

    public static void j() {
        g(v0.g().d(), null, 1400L, null);
    }

    public static void k(Activity activity, Runnable runnable) {
        g(activity, null, 1400L, runnable);
    }

    public static void l(Runnable runnable) {
        i(null, 900L, runnable);
    }
}
