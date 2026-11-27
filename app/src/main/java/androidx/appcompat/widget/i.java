package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
class i extends androidx.appcompat.view.menu.y {

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ k f157m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, Context context, androidx.appcompat.view.menu.m mVar, View view, boolean z) {
        super(context, mVar, view, z, h.a.a.f1181m);
        this.f157m = kVar;
        h(8388613);
        j(kVar.a0);
    }

    @Override // androidx.appcompat.view.menu.y
    protected void e() {
        if (((androidx.appcompat.view.menu.b) this.f157m).e != null) {
            ((androidx.appcompat.view.menu.b) this.f157m).e.close();
        }
        this.f157m.U = null;
        super.e();
    }
}
