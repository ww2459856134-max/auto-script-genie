package androidx.appcompat.app;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.m;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class g1 extends h.a.o.c implements m.a {
    private final Context e;
    private final androidx.appcompat.view.menu.m f;
    private h.a.o.b g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<View> f14h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ h1 f15i;

    public g1(h1 h1Var, Context context, h.a.o.b bVar) {
        this.f15i = h1Var;
        this.e = context;
        this.g = bVar;
        androidx.appcompat.view.menu.m mVar = new androidx.appcompat.view.menu.m(context);
        mVar.S(1);
        this.f = mVar;
        mVar.R(this);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(androidx.appcompat.view.menu.m mVar, MenuItem menuItem) {
        h.a.o.b bVar = this.g;
        if (bVar != null) {
            return bVar.b(this, menuItem);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(androidx.appcompat.view.menu.m mVar) {
        if (this.g == null) {
            return;
        }
        k();
        this.f15i.f.l();
    }

    @Override // h.a.o.c
    public void c() {
        h1 h1Var = this.f15i;
        if (h1Var.f18j != this) {
            return;
        }
        if (h1.w(h1Var.r, h1Var.s, false)) {
            this.g.d(this);
        } else {
            h1 h1Var2 = this.f15i;
            h1Var2.f19k = this;
            h1Var2.f20l = this.g;
        }
        this.g = null;
        this.f15i.v(false);
        this.f15i.f.g();
        this.f15i.e.p().sendAccessibilityEvent(32);
        h1 h1Var3 = this.f15i;
        h1Var3.c.setHideOnContentScrollEnabled(h1Var3.x);
        this.f15i.f18j = null;
    }

    @Override // h.a.o.c
    public View d() {
        WeakReference<View> weakReference = this.f14h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // h.a.o.c
    public Menu e() {
        return this.f;
    }

    @Override // h.a.o.c
    public MenuInflater f() {
        return new h.a.o.k(this.e);
    }

    @Override // h.a.o.c
    public CharSequence g() {
        return this.f15i.f.getSubtitle();
    }

    @Override // h.a.o.c
    public CharSequence i() {
        return this.f15i.f.getTitle();
    }

    @Override // h.a.o.c
    public void k() {
        if (this.f15i.f18j != this) {
            return;
        }
        this.f.d0();
        try {
            this.g.c(this, this.f);
        } finally {
            this.f.c0();
        }
    }

    @Override // h.a.o.c
    public boolean l() {
        return this.f15i.f.j();
    }

    @Override // h.a.o.c
    public void m(View view) {
        this.f15i.f.setCustomView(view);
        this.f14h = new WeakReference<>(view);
    }

    @Override // h.a.o.c
    public void n(int i2) {
        o(this.f15i.a.getResources().getString(i2));
    }

    @Override // h.a.o.c
    public void o(CharSequence charSequence) {
        this.f15i.f.setSubtitle(charSequence);
    }

    @Override // h.a.o.c
    public void q(int i2) {
        r(this.f15i.a.getResources().getString(i2));
    }

    @Override // h.a.o.c
    public void r(CharSequence charSequence) {
        this.f15i.f.setTitle(charSequence);
    }

    @Override // h.a.o.c
    public void s(boolean z) {
        super.s(z);
        this.f15i.f.setTitleOptional(z);
    }

    public boolean t() {
        this.f.d0();
        try {
            return this.g.a(this, this.f);
        } finally {
            this.f.c0();
        }
    }
}
