package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h1 extends a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final h.e.j.c1 A;
    Context a;
    private Context b;
    ActionBarOverlayLayout c;
    ActionBarContainer d;
    androidx.appcompat.widget.l0 e;
    ActionBarContextView f;
    View g;

    /* renamed from: h, reason: collision with root package name */
    ScrollingTabContainerView f16h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f17i;

    /* renamed from: j, reason: collision with root package name */
    g1 f18j;

    /* renamed from: k, reason: collision with root package name */
    h.a.o.c f19k;

    /* renamed from: l, reason: collision with root package name */
    h.a.o.b f20l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f21m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<b> f22n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f23o;
    private int p;
    boolean q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;
    h.a.o.m v;
    private boolean w;
    boolean x;
    final h.e.j.a1 y;
    final h.e.j.a1 z;

    public h1(Activity activity, boolean z) {
        new ArrayList();
        this.f22n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new d1(this);
        this.z = new e1(this);
        this.A = new f1(this);
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private androidx.appcompat.widget.l0 A(View view) {
        if (view instanceof androidx.appcompat.widget.l0) {
            return (androidx.appcompat.widget.l0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(h.a.f.q);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.e = A(view.findViewById(h.a.f.a));
        this.f = (ActionBarContextView) view.findViewById(h.a.f.f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(h.a.f.c);
        this.d = actionBarContainer;
        androidx.appcompat.widget.l0 l0Var = this.e;
        if (l0Var == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(h1.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = l0Var.r();
        boolean z = (this.e.m() & 4) != 0;
        if (z) {
            this.f17i = true;
        }
        h.a.o.a aVarB = h.a.o.a.b(this.a);
        J(aVarB.a() || z);
        H(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, h.a.j.a, h.a.a.c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(h.a.j.f1228k, false)) {
            I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.a.j.f1226i, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void H(boolean z) {
        this.f23o = z;
        if (z) {
            this.d.setTabContainer(null);
            this.e.s(this.f16h);
        } else {
            this.e.s(null);
            this.d.setTabContainer(this.f16h);
        }
        boolean z2 = B() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f16h;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    h.e.j.s0.W(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.e.j(!this.f23o && z2);
        this.c.setHasNonEmbeddedTabs(!this.f23o && z2);
    }

    private boolean K() {
        return h.e.j.s0.K(this.d);
    }

    private void L() {
        if (this.t) {
            return;
        }
        this.t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z) {
        if (w(this.r, this.s, this.t)) {
            if (this.u) {
                return;
            }
            this.u = true;
            z(z);
            return;
        }
        if (this.u) {
            this.u = false;
            y(z);
        }
    }

    static boolean w(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public int B() {
        return this.e.h();
    }

    public void E(boolean z) {
        F(z ? 4 : 0, 4);
    }

    public void F(int i2, int i3) {
        int iM = this.e.m();
        if ((i3 & 4) != 0) {
            this.f17i = true;
        }
        this.e.g((i2 & i3) | ((~i3) & iM));
    }

    public void G(float f) {
        h.e.j.s0.d0(this.d, f);
    }

    public void I(boolean z) {
        if (z && !this.c.u()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = z;
        this.c.setHideOnContentScrollEnabled(z);
    }

    public void J(boolean z) {
        this.e.q(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.s) {
            this.s = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        if (this.s) {
            return;
        }
        this.s = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        h.a.o.m mVar = this.v;
        if (mVar != null) {
            mVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(int i2) {
        this.p = i2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        androidx.appcompat.widget.l0 l0Var = this.e;
        if (l0Var == null || !l0Var.f()) {
            return false;
        }
        this.e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.f21m) {
            return;
        }
        this.f21m = z;
        int size = this.f22n.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f22n.get(i2).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.e.m();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(h.a.a.f1176h, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.b = new ContextThemeWrapper(this.a, i2);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        H(h.a.o.a.b(this.a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu menuE;
        g1 g1Var = this.f18j;
        if (g1Var == null || (menuE = g1Var.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (this.f17i) {
            return;
        }
        E(z);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        h.a.o.m mVar;
        this.w = z;
        if (z || (mVar = this.v) == null) {
            return;
        }
        mVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public h.a.o.c u(h.a.o.b bVar) {
        g1 g1Var = this.f18j;
        if (g1Var != null) {
            g1Var.c();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.k();
        g1 g1Var2 = new g1(this, this.f.getContext(), bVar);
        if (!g1Var2.t()) {
            return null;
        }
        this.f18j = g1Var2;
        g1Var2.k();
        this.f.h(g1Var2);
        v(true);
        this.f.sendAccessibilityEvent(32);
        return g1Var2;
    }

    public void v(boolean z) {
        h.e.j.z0 z0VarO;
        h.e.j.z0 z0VarF;
        if (z) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z) {
                this.e.l(4);
                this.f.setVisibility(0);
                return;
            } else {
                this.e.l(0);
                this.f.setVisibility(8);
                return;
            }
        }
        if (z) {
            z0VarF = this.e.o(4, 100L);
            z0VarO = this.f.f(0, 200L);
        } else {
            z0VarO = this.e.o(0, 200L);
            z0VarF = this.f.f(8, 100L);
        }
        h.a.o.m mVar = new h.a.o.m();
        mVar.d(z0VarF, z0VarO);
        mVar.h();
    }

    void x() {
        h.a.o.b bVar = this.f20l;
        if (bVar != null) {
            bVar.d(this.f19k);
            this.f19k = null;
            this.f20l = null;
        }
    }

    public void y(boolean z) {
        View view;
        h.a.o.m mVar = this.v;
        if (mVar != null) {
            mVar.a();
        }
        if (this.p != 0 || (!this.w && !z)) {
            this.y.b(null);
            return;
        }
        this.d.setAlpha(1.0f);
        this.d.setTransitioning(true);
        h.a.o.m mVar2 = new h.a.o.m();
        float f = -this.d.getHeight();
        if (z) {
            this.d.getLocationInWindow(new int[]{0, 0});
            f -= r5[1];
        }
        h.e.j.z0 z0VarB = h.e.j.s0.b(this.d);
        z0VarB.k(f);
        z0VarB.i(this.A);
        mVar2.c(z0VarB);
        if (this.q && (view = this.g) != null) {
            h.e.j.z0 z0VarB2 = h.e.j.s0.b(view);
            z0VarB2.k(f);
            mVar2.c(z0VarB2);
        }
        mVar2.f(B);
        mVar2.e(250L);
        mVar2.g(this.y);
        this.v = mVar2;
        mVar2.h();
    }

    public void z(boolean z) {
        View view;
        View view2;
        h.a.o.m mVar = this.v;
        if (mVar != null) {
            mVar.a();
        }
        this.d.setVisibility(0);
        if (this.p == 0 && (this.w || z)) {
            this.d.setTranslationY(0.0f);
            float f = -this.d.getHeight();
            if (z) {
                this.d.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.d.setTranslationY(f);
            h.a.o.m mVar2 = new h.a.o.m();
            h.e.j.z0 z0VarB = h.e.j.s0.b(this.d);
            z0VarB.k(0.0f);
            z0VarB.i(this.A);
            mVar2.c(z0VarB);
            if (this.q && (view2 = this.g) != null) {
                view2.setTranslationY(f);
                h.e.j.z0 z0VarB2 = h.e.j.s0.b(this.g);
                z0VarB2.k(0.0f);
                mVar2.c(z0VarB2);
            }
            mVar2.f(C);
            mVar2.e(250L);
            mVar2.g(this.z);
            this.v = mVar2;
            mVar2.h();
        } else {
            this.d.setAlpha(1.0f);
            this.d.setTranslationY(0.0f);
            if (this.q && (view = this.g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            h.e.j.s0.W(actionBarOverlayLayout);
        }
    }

    public h1(Dialog dialog) {
        new ArrayList();
        this.f22n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new d1(this);
        this.z = new e1(this);
        this.A = new f1(this);
        D(dialog.getWindow().getDecorView());
    }
}
