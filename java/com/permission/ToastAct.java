package com.permission;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.frame.l1;
import com.tencent.open.SocialConstants;

/* loaded from: classes.dex */
public class ToastAct extends androidx.appcompat.app.s {
    private LottieAnimationView J;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ToastAct.this.finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(Throwable th) {
        this.J.setVisibility(8);
    }

    static /* synthetic */ void T(int i2) {
        try {
            if (com.frame.v0.g().d() != null) {
                com.frame.v0.g().d().overridePendingTransition(0, 0);
            }
            Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ToastAct.class);
            intent.putExtra("layoutId", i2);
            intent.addFlags(268435456);
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void U(String str, String str2) {
        try {
            if (com.frame.v0.g().d() != null) {
                com.frame.v0.g().d().overridePendingTransition(0, 0);
            }
            Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ToastAct.class);
            intent.putExtra("lottie", str);
            intent.putExtra(SocialConstants.PARAM_TYPE, str2);
            intent.addFlags(268435456);
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public static void V(int i2) {
        W(i2, 500L);
    }

    public static void W(final int i2, long j2) {
        l1.f(new Runnable() { // from class: com.permission.c0
            @Override // java.lang.Runnable
            public final void run() {
                ToastAct.T(i2);
            }
        }, j2);
    }

    public static void X(final String str, final String str2) {
        l1.f(new Runnable() { // from class: com.permission.d0
            @Override // java.lang.Runnable
            public final void run() {
                ToastAct.U(str, str2);
            }
        }, 500L);
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.J;
        if (lottieAnimationView != null) {
            lottieAnimationView.g();
        }
    }

    @Override // androidx.appcompat.app.s, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        String stringExtra = getIntent().getStringExtra("lottie");
        String stringExtra2 = getIntent().getStringExtra(SocialConstants.PARAM_TYPE);
        int intExtra = getIntent().getIntExtra("layoutId", 0);
        View viewInflate = View.inflate(getApplicationContext(), j.e.d.f1769h, null);
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(11);
        relativeLayout.addView(viewInflate, layoutParams);
        setContentView(relativeLayout);
        if (intExtra == 0 && stringExtra != null) {
            findViewById(j.e.c.e).setVisibility(0);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(j.e.c.a);
            this.J = lottieAnimationView;
            lottieAnimationView.setVisibility(0);
            this.J.setFailureListener(new com.airbnb.lottie.g0() { // from class: com.permission.e0
                @Override // com.airbnb.lottie.g0
                public final void a(Object obj) {
                    this.a.S((Throwable) obj);
                }
            });
            this.J.setAnimation(stringExtra);
            if ("accessibility".equals(stringExtra2) && !(a1.g().h() instanceof b1) && !(a1.g().h() instanceof i0) && !a1.g().l()) {
                this.J.setMinProgress(0.25f);
                this.J.setMaxProgress(1.0f);
            }
            this.J.o();
        } else {
            if (intExtra == 0) {
                finish();
                return;
            }
            ViewGroup viewGroup = (ViewGroup) findViewById(j.e.c.c);
            viewGroup.setVisibility(0);
            View viewInflate2 = View.inflate(com.frame.v0.g(), intExtra, null);
            viewGroup.addView(viewInflate2, -1, -2);
            viewGroup.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.e.a.a));
            if (j.e.d.a == intExtra) {
                z0 z0VarH = a1.g().h();
                if (!(z0VarH instanceof g0) && !(z0VarH instanceof i0)) {
                    viewInflate2.findViewById(j.e.c.d).setVisibility(8);
                    viewInflate2.findViewById(j.e.c.b).setVisibility(8);
                }
            }
        }
        getWindow().getDecorView().setOnTouchListener(new a());
    }
}
