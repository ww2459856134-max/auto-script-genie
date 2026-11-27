package com.permission;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.g0;
import com.frame.l1;
import com.frame.p1;
import com.frame.q1;
import com.frame.w0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
public class ClickView extends RelativeLayout {

    /* renamed from: i, reason: collision with root package name */
    private static ClickView f830i;
    protected WindowManager c;
    protected WindowManager.LayoutParams d;
    private Rect e;
    private TextView f;
    private ImageView g;

    /* renamed from: h, reason: collision with root package name */
    Intent f831h;

    class a implements w0.a {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c() {
            com.frame.w0.b().i(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e() {
            com.frame.w0.b().i(this);
        }

        @Override // com.frame.w0.a
        public void a(AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32 && accessibilityEvent.getEventType() != 8) {
                if (accessibilityEvent.getEventType() == 1) {
                    ClickView.p();
                    l1.e(new Runnable() { // from class: com.permission.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.e();
                        }
                    });
                    return;
                }
                return;
            }
            try {
                if ((!ClickView.this.e(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString()) || TextUtils.isEmpty(this.a) || accessibilityEvent.getPackageName().toString().equals(this.a)) && !accessibilityEvent.getPackageName().toString().equals(com.frame.i0.d())) {
                    return;
                }
                l1.e(new Runnable() { // from class: com.permission.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.c();
                    }
                });
                ClickView.p();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    class b implements w0.a {
        final /* synthetic */ Runnable a;
        final /* synthetic */ String b;
        final /* synthetic */ View.OnClickListener c;

        b(Runnable runnable, String str, View.OnClickListener onClickListener) {
            this.a = runnable;
            this.b = str;
            this.c = onClickListener;
        }

        @Override // com.frame.w0.a
        public void a(AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 4096) {
                l1.g(this.a);
                return;
            }
            if (accessibilityEvent.getEventType() == 32) {
                if (ClickView.this.e(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString()) || accessibilityEvent.getPackageName().toString().equals(com.frame.i0.d())) {
                    com.frame.w0.b().i(this);
                    ClickView.p();
                    return;
                }
                return;
            }
            if (this.b == null || accessibilityEvent.getPackageName() == null || !this.b.equals(accessibilityEvent.getPackageName()) || accessibilityEvent.getEventType() != 1) {
                return;
            }
            ClickView.p();
            com.frame.w0.b().i(this);
            final View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                l1.d(new Runnable() { // from class: com.permission.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        onClickListener.onClick(null);
                    }
                }, 300L);
            }
        }
    }

    public ClickView(Context context) {
        super(context);
        this.f831h = null;
    }

    public static void c() {
        ClickView clickView = f830i;
        if (clickView != null) {
            try {
                try {
                    WindowManager windowManager = clickView.c;
                    if (windowManager != null) {
                        windowManager.removeView(clickView);
                    }
                    f830i.d = null;
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            } finally {
                f830i = null;
            }
        }
    }

    public static void d(ClickView clickView) {
        if (f830i == clickView) {
            c();
        }
    }

    static /* synthetic */ void g(final String str, AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            final AccessibilityNodeInfo accessibilityNodeInfoF = com.frame.g0.v().f(accessibilityNodeInfo, 3);
            l1.e(new Runnable() { // from class: com.permission.k
                @Override // java.lang.Runnable
                public final void run() {
                    ClickView.getInstance().a(accessibilityNodeInfoF, str);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public static ClickView getInstance() {
        ClickView clickView = f830i;
        if (clickView != null) {
            return clickView;
        }
        ClickView clickView2 = new ClickView(com.frame.v0.g());
        f830i = clickView2;
        return clickView2;
    }

    static /* synthetic */ void j(final String str, Runnable runnable, AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            final AccessibilityNodeInfo accessibilityNodeInfoF = com.frame.g0.v().f(accessibilityNodeInfo, 3);
            l1.e(new Runnable() { // from class: com.permission.e
                @Override // java.lang.Runnable
                public final void run() {
                    ClickView.getInstance().a(accessibilityNodeInfoF, str);
                }
            });
            SystemClock.sleep(100L);
            runnable.run();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void l(String str, String str2, final String str3, final Runnable runnable, final w0.a aVar) {
        SystemClock.sleep(300L);
        com.frame.g0.v().p(str, com.frame.g0.v().d(str2), new g0.a() { // from class: com.permission.i
            @Override // com.frame.g0.a
            public final void a(AccessibilityNodeInfo accessibilityNodeInfo) {
                ClickView.j(str3, runnable, accessibilityNodeInfo);
            }
        });
        l1.d(new Runnable() { // from class: com.permission.j
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.w0.b().a(aVar);
            }
        }, 300L);
    }

    static /* synthetic */ void m() {
        try {
            f830i.removeAllViews();
            ClickView clickView = f830i;
            clickView.c.removeView(clickView);
            f830i.d = null;
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        f830i = null;
    }

    public static void p() {
        try {
            ClickView clickView = f830i;
            if (clickView == null || clickView.c == null) {
                return;
            }
            l1.e(new Runnable() { // from class: com.permission.a
                @Override // java.lang.Runnable
                public final void run() {
                    ClickView.m();
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        try {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            this.e = rect;
            if (getParent() != null) {
                TextView textView = this.f;
                if (textView != null && this.g != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.topMargin = rect.top - p1.c(40.0f);
                        layoutParams.rightMargin = (q1.e() - rect.right) + p1.c(20.0f);
                        this.f.setLayoutParams(layoutParams);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.leftMargin = (int) (rect.right - ((r9 - rect.left) * 0.2f));
                        int i2 = rect.top;
                        layoutParams2.topMargin = i2 + ((rect.bottom - i2) / 2);
                        this.g.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                try {
                    this.c.removeView(this);
                } catch (Exception unused) {
                }
            }
            WindowManager.LayoutParams layoutParams3 = getLayoutParams();
            this.d = layoutParams3;
            layoutParams3.gravity = 51;
            layoutParams3.height = q1.i();
            this.d.width = -1;
            WindowManager windowManager = (WindowManager) com.frame.w0.b().getSystemService("window");
            this.c = windowManager;
            windowManager.addView(this, this.d);
            if (str != null) {
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(com.frame.v0.g());
                this.f = textView2;
                textView2.setBackgroundResource(j.e.b.c);
                this.f.setTextColor(-1);
                this.f.setText(str);
                layoutParams4.topMargin = rect.top - p1.c(40.0f);
                layoutParams4.rightMargin = (q1.e() - rect.right) + p1.c(20.0f);
                layoutParams4.addRule(11);
                addView(this.f, layoutParams4);
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(p1.c(40.0f), p1.c(40.0f));
            this.g = new ImageView(com.frame.v0.g());
            com.bumptech.glide.c.t(com.frame.v0.g()).v(Integer.valueOf(j.e.b.b)).q0(this.g);
            layoutParams5.leftMargin = (int) (rect.right - ((r9 - rect.left) * 0.2f));
            int i3 = rect.top;
            layoutParams5.topMargin = i3 + ((rect.bottom - i3) / 2);
            addView(this.g, layoutParams5);
            this.g.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.e.a.b));
            l1.c(10978, new Runnable() { // from class: com.permission.f0
                @Override // java.lang.Runnable
                public final void run() {
                    ClickView.p();
                }
            }, 10000L);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        a(accessibilityNodeInfo, str);
        if (com.frame.w0.d()) {
            String string = accessibilityNodeInfo.getPackageName().toString();
            com.frame.w0.b().k();
            com.frame.w0.b().a(new a(string));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#99000000"));
        if (this.e != null) {
            Paint paint = new Paint();
            paint.setAlpha(0);
            paint.setDither(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(this.e, paint);
        }
        super.dispatchDraw(canvas);
    }

    public boolean e(String str, String str2) {
        try {
            if (this.f831h == null) {
                this.f831h = new Intent();
            }
            this.f831h.setClassName(str, str2);
            boolean z = com.frame.v0.g().getPackageManager().queryIntentActivities(this.f831h, WXMediaMessage.THUMB_LENGTH_LIMIT).size() > 0;
            if (!z) {
                if (str2.contains("Dialog")) {
                    return true;
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public void n(String str, String str2) {
        o(null, str, str2, null);
    }

    public void o(final String str, final String str2, final String str3, View.OnClickListener onClickListener) {
        final Runnable runnable = new Runnable() { // from class: com.permission.h
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.g0.v().p(str, com.frame.g0.v().b(str2), new g0.a() { // from class: com.permission.b
                    @Override // com.frame.g0.a
                    public final void a(AccessibilityNodeInfo accessibilityNodeInfo) {
                        ClickView.g(str, accessibilityNodeInfo);
                    }
                });
            }
        };
        final b bVar = new b(runnable, str, onClickListener);
        l1.g(new Runnable() { // from class: com.permission.g
            @Override // java.lang.Runnable
            public final void run() {
                ClickView.l(str, str2, str3, runnable, bVar);
            }
        });
    }

    @Override // android.view.View
    public WindowManager.LayoutParams getLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2032;
        layoutParams.flags = 16778008;
        layoutParams.alpha = 0.8f;
        layoutParams.format = 1;
        return layoutParams;
    }
}
