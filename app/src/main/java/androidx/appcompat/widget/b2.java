package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class b2 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static b2 A;
    private static b2 t;
    private final View c;
    private final CharSequence d;
    private final int e;
    private final Runnable f = new z1(this);
    private final Runnable g = new a2(this);

    /* renamed from: h, reason: collision with root package name */
    private int f146h;

    /* renamed from: i, reason: collision with root package name */
    private int f147i;

    /* renamed from: j, reason: collision with root package name */
    private c2 f148j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f149k;

    private b2(View view, CharSequence charSequence) {
        this.c = view;
        this.d = charSequence;
        this.e = h.e.j.t0.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.c.removeCallbacks(this.f);
    }

    private void b() {
        this.f146h = Integer.MAX_VALUE;
        this.f147i = Integer.MAX_VALUE;
    }

    private void d() {
        this.c.postDelayed(this.f, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(b2 b2Var) {
        b2 b2Var2 = t;
        if (b2Var2 != null) {
            b2Var2.a();
        }
        t = b2Var;
        if (b2Var != null) {
            b2Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        b2 b2Var = t;
        if (b2Var != null && b2Var.c == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new b2(view, charSequence);
            return;
        }
        b2 b2Var2 = A;
        if (b2Var2 != null && b2Var2.c == view) {
            b2Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f146h) <= this.e && Math.abs(y - this.f147i) <= this.e) {
            return false;
        }
        this.f146h = x;
        this.f147i = y;
        return true;
    }

    void c() {
        if (A == this) {
            A = null;
            c2 c2Var = this.f148j;
            if (c2Var != null) {
                c2Var.c();
                this.f148j = null;
                b();
                this.c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (t == this) {
            e(null);
        }
        this.c.removeCallbacks(this.g);
    }

    void g(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (h.e.j.s0.J(this.c)) {
            e(null);
            b2 b2Var = A;
            if (b2Var != null) {
                b2Var.c();
            }
            A = this;
            this.f149k = z;
            c2 c2Var = new c2(this.c.getContext());
            this.f148j = c2Var;
            c2Var.e(this.c, this.f146h, this.f147i, this.f149k, this.d);
            this.c.addOnAttachStateChangeListener(this);
            if (this.f149k) {
                j3 = 2500;
            } else {
                if ((h.e.j.s0.F(this.c) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.c.removeCallbacks(this.g);
            this.c.postDelayed(this.g, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f148j != null && this.f149k) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.c.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.c.isEnabled() && this.f148j == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f146h = view.getWidth() / 2;
        this.f147i = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
