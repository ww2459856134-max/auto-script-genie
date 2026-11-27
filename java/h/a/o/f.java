package h.a.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class f extends c implements m.a {
    private Context e;
    private ActionBarContextView f;
    private b g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<View> f1253h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1254i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.appcompat.view.menu.m f1255j;

    public f(Context context, ActionBarContextView actionBarContextView, b bVar, boolean z) {
        this.e = context;
        this.f = actionBarContextView;
        this.g = bVar;
        androidx.appcompat.view.menu.m mVar = new androidx.appcompat.view.menu.m(actionBarContextView.getContext());
        mVar.S(1);
        this.f1255j = mVar;
        mVar.R(this);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(androidx.appcompat.view.menu.m mVar, MenuItem menuItem) {
        return this.g.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(androidx.appcompat.view.menu.m mVar) {
        k();
        this.f.l();
    }

    @Override // h.a.o.c
    public void c() {
        if (this.f1254i) {
            return;
        }
        this.f1254i = true;
        this.f.sendAccessibilityEvent(32);
        this.g.d(this);
    }

    @Override // h.a.o.c
    public View d() {
        WeakReference<View> weakReference = this.f1253h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // h.a.o.c
    public Menu e() {
        return this.f1255j;
    }

    @Override // h.a.o.c
    public MenuInflater f() {
        return new k(this.f.getContext());
    }

    @Override // h.a.o.c
    public CharSequence g() {
        return this.f.getSubtitle();
    }

    @Override // h.a.o.c
    public CharSequence i() {
        return this.f.getTitle();
    }

    @Override // h.a.o.c
    public void k() {
        this.g.c(this, this.f1255j);
    }

    @Override // h.a.o.c
    public boolean l() {
        return this.f.j();
    }

    @Override // h.a.o.c
    public void m(View view) {
        this.f.setCustomView(view);
        this.f1253h = view != null ? new WeakReference<>(view) : null;
    }

    @Override // h.a.o.c
    public void n(int i2) {
        o(this.e.getString(i2));
    }

    @Override // h.a.o.c
    public void o(CharSequence charSequence) {
        this.f.setSubtitle(charSequence);
    }

    @Override // h.a.o.c
    public void q(int i2) {
        r(this.e.getString(i2));
    }

    @Override // h.a.o.c
    public void r(CharSequence charSequence) {
        this.f.setTitle(charSequence);
    }

    @Override // h.a.o.c
    public void s(boolean z) {
        super.s(z);
        this.f.setTitleOptional(z);
    }
}
