package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.z;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class x1 implements l0 {
    Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f180h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f181i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f182j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f183k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f184l;

    /* renamed from: m, reason: collision with root package name */
    boolean f185m;

    /* renamed from: n, reason: collision with root package name */
    private k f186n;

    /* renamed from: o, reason: collision with root package name */
    private int f187o;
    private int p;
    private Drawable q;

    public x1(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.a.h.a, h.a.e.f1199n);
    }

    private void D(CharSequence charSequence) {
        this.f181i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void E() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.f183k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.f183k);
            }
        }
    }

    private void F() {
        if ((this.b & 4) == 0) {
            this.a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.a;
        Drawable drawable = this.g;
        if (drawable == null) {
            drawable = this.q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void G() {
        Drawable drawable;
        int i2 = this.b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }

    private int u() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.g = drawable;
        F();
    }

    public void B(CharSequence charSequence) {
        this.f182j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void C(CharSequence charSequence) {
        this.f180h = true;
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.l0
    public boolean a() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.l0
    public boolean b() {
        return this.a.J();
    }

    @Override // androidx.appcompat.widget.l0
    public boolean c() {
        return this.a.A();
    }

    @Override // androidx.appcompat.widget.l0
    public void collapseActionView() {
        this.a.e();
    }

    @Override // androidx.appcompat.widget.l0
    public boolean d() {
        return this.a.w();
    }

    @Override // androidx.appcompat.widget.l0
    public boolean e() {
        return this.a.z();
    }

    @Override // androidx.appcompat.widget.l0
    public boolean f() {
        return this.a.v();
    }

    @Override // androidx.appcompat.widget.l0
    public void g(int i2) {
        View view;
        int i3 = this.b ^ i2;
        this.b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    E();
                }
                F();
            }
            if ((i3 & 3) != 0) {
                G();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.a.setTitle(this.f181i);
                    this.a.setSubtitle(this.f182j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.l0
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.l0
    public int h() {
        return this.f187o;
    }

    @Override // androidx.appcompat.widget.l0
    public void i() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.l0
    public void j(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.l0
    public void k() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.l0
    public void l(int i2) {
        this.a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.l0
    public int m() {
        return this.b;
    }

    @Override // androidx.appcompat.widget.l0
    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.l0
    public h.e.j.z0 o(int i2, long j2) {
        h.e.j.z0 z0VarB = h.e.j.s0.b(this.a);
        z0VarB.a(i2 == 0 ? 1.0f : 0.0f);
        z0VarB.d(j2);
        z0VarB.f(new w1(this, i2));
        return z0VarB;
    }

    @Override // androidx.appcompat.widget.l0
    public ViewGroup p() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.l0
    public void q(boolean z) {
    }

    @Override // androidx.appcompat.widget.l0
    public Context r() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.l0
    public void s(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f187o != 2) {
            return;
        }
        this.a.addView(scrollingTabContainerView, 0);
        Toolbar.e eVar = (Toolbar.e) this.c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.l0
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? h.a.k.a.b.d(r(), i2) : null);
    }

    @Override // androidx.appcompat.widget.l0
    public void setMenu(Menu menu, z.a aVar) {
        if (this.f186n == null) {
            k kVar = new k(this.a.getContext());
            this.f186n = kVar;
            kVar.q(h.a.f.g);
        }
        this.f186n.j(aVar);
        this.a.setMenu((androidx.appcompat.view.menu.m) menu, this.f186n);
    }

    @Override // androidx.appcompat.widget.l0
    public void setMenuPrepared() {
        this.f185m = true;
    }

    @Override // androidx.appcompat.widget.l0
    public void setWindowCallback(Window.Callback callback) {
        this.f184l = callback;
    }

    @Override // androidx.appcompat.widget.l0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f180h) {
            return;
        }
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.l0
    public void t(int i2) {
        x(i2 != 0 ? h.a.k.a.b.d(r(), i2) : null);
    }

    public void v(View view) {
        View view2 = this.d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.d = view;
        if (view == null || (this.b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void w(int i2) {
        if (i2 == this.p) {
            return;
        }
        this.p = i2;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            y(this.p);
        }
    }

    public void x(Drawable drawable) {
        this.f = drawable;
        G();
    }

    public void y(int i2) {
        z(i2 == 0 ? null : r().getString(i2));
    }

    public void z(CharSequence charSequence) {
        this.f183k = charSequence;
        E();
    }

    public x1(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.f187o = 0;
        this.p = 0;
        this.a = toolbar;
        this.f181i = toolbar.getTitle();
        this.f182j = toolbar.getSubtitle();
        this.f180h = this.f181i != null;
        this.g = toolbar.getNavigationIcon();
        t1 t1VarU = t1.u(toolbar.getContext(), null, h.a.j.a, h.a.a.c, 0);
        this.q = t1VarU.f(h.a.j.f1229l);
        if (z) {
            CharSequence charSequenceO = t1VarU.o(h.a.j.r);
            if (!TextUtils.isEmpty(charSequenceO)) {
                C(charSequenceO);
            }
            CharSequence charSequenceO2 = t1VarU.o(h.a.j.p);
            if (!TextUtils.isEmpty(charSequenceO2)) {
                B(charSequenceO2);
            }
            Drawable drawableF = t1VarU.f(h.a.j.f1231n);
            if (drawableF != null) {
                x(drawableF);
            }
            Drawable drawableF2 = t1VarU.f(h.a.j.f1230m);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                A(drawable);
            }
            g(t1VarU.j(h.a.j.f1225h, 0));
            int iM = t1VarU.m(h.a.j.g, 0);
            if (iM != 0) {
                v(LayoutInflater.from(this.a.getContext()).inflate(iM, (ViewGroup) this.a, false));
                g(this.b | 16);
            }
            int iL = t1VarU.l(h.a.j.f1227j, 0);
            if (iL > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iL;
                this.a.setLayoutParams(layoutParams);
            }
            int iD = t1VarU.d(h.a.j.f, -1);
            int iD2 = t1VarU.d(h.a.j.e, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.a.setContentInsetsRelative(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iM2 = t1VarU.m(h.a.j.s, 0);
            if (iM2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iM2);
            }
            int iM3 = t1VarU.m(h.a.j.q, 0);
            if (iM3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iM3);
            }
            int iM4 = t1VarU.m(h.a.j.f1232o, 0);
            if (iM4 != 0) {
                this.a.setPopupTheme(iM4);
            }
        } else {
            this.b = u();
        }
        t1VarU.v();
        w(i2);
        this.f183k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new v1(this));
    }

    @Override // androidx.appcompat.widget.l0
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        G();
    }
}
