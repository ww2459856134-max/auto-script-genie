package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.z;

/* loaded from: classes.dex */
public final class r0 {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;

    /* renamed from: h, reason: collision with root package name */
    View f33h;

    /* renamed from: i, reason: collision with root package name */
    View f34i;

    /* renamed from: j, reason: collision with root package name */
    androidx.appcompat.view.menu.m f35j;

    /* renamed from: k, reason: collision with root package name */
    androidx.appcompat.view.menu.k f36k;

    /* renamed from: l, reason: collision with root package name */
    Context f37l;

    /* renamed from: m, reason: collision with root package name */
    boolean f38m;

    /* renamed from: n, reason: collision with root package name */
    boolean f39n;

    /* renamed from: o, reason: collision with root package name */
    boolean f40o;
    public boolean p;
    boolean q = false;
    boolean r;
    Bundle s;

    r0(int i2) {
        this.a = i2;
    }

    androidx.appcompat.view.menu.a0 a(z.a aVar) {
        if (this.f35j == null) {
            return null;
        }
        if (this.f36k == null) {
            androidx.appcompat.view.menu.k kVar = new androidx.appcompat.view.menu.k(this.f37l, h.a.g.f1213l);
            this.f36k = kVar;
            kVar.j(aVar);
            this.f35j.b(this.f36k);
        }
        return this.f36k.g(this.g);
    }

    public boolean b() {
        if (this.f33h == null) {
            return false;
        }
        return this.f34i != null || this.f36k.a().getCount() > 0;
    }

    void c(androidx.appcompat.view.menu.m mVar) {
        androidx.appcompat.view.menu.k kVar;
        androidx.appcompat.view.menu.m mVar2 = this.f35j;
        if (mVar == mVar2) {
            return;
        }
        if (mVar2 != null) {
            mVar2.O(this.f36k);
        }
        this.f35j = mVar;
        if (mVar == null || (kVar = this.f36k) == null) {
            return;
        }
        mVar.b(kVar);
    }

    void d(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme themeNewTheme = context.getResources().newTheme();
        themeNewTheme.setTo(context.getTheme());
        themeNewTheme.resolveAttribute(h.a.a.a, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 != 0) {
            themeNewTheme.applyStyle(i2, true);
        }
        themeNewTheme.resolveAttribute(h.a.a.F, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 != 0) {
            themeNewTheme.applyStyle(i3, true);
        } else {
            themeNewTheme.applyStyle(h.a.i.b, true);
        }
        h.a.o.e eVar = new h.a.o.e(context, 0);
        eVar.getTheme().setTo(themeNewTheme);
        this.f37l = eVar;
        TypedArray typedArrayObtainStyledAttributes = eVar.obtainStyledAttributes(h.a.j.x0);
        this.b = typedArrayObtainStyledAttributes.getResourceId(h.a.j.A0, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(h.a.j.z0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
