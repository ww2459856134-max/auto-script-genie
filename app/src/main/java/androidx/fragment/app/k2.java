package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
class k2 implements Runnable {
    final /* synthetic */ Fragment c;
    final /* synthetic */ Fragment d;
    final /* synthetic */ boolean e;
    final /* synthetic */ h.d.b f;
    final /* synthetic */ View g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ y2 f262h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Rect f263i;

    k2(Fragment fragment, Fragment fragment2, boolean z, h.d.b bVar, View view, y2 y2Var, Rect rect) {
        this.c = fragment;
        this.d = fragment2;
        this.e = z;
        this.f = bVar;
        this.g = view;
        this.f262h = y2Var;
        this.f263i = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        o2.f(this.c, this.d, this.e, this.f, false);
        View view = this.g;
        if (view != null) {
            this.f262h.k(view, this.f263i);
        }
    }
}
