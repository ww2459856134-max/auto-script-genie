package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
class d extends androidx.appcompat.view.menu.y {

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ k f150m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(k kVar, Context context, androidx.appcompat.view.menu.g0 g0Var, View view) {
        super(context, g0Var, view, false, h.a.a.f1181m);
        this.f150m = kVar;
        if (!((androidx.appcompat.view.menu.p) g0Var.getItem()).l()) {
            View view2 = kVar.f168k;
            f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) kVar).f64j : view2);
        }
        j(kVar.a0);
    }

    @Override // androidx.appcompat.view.menu.y
    protected void e() {
        k kVar = this.f150m;
        kVar.V = null;
        kVar.b0 = 0;
        super.e();
    }
}
