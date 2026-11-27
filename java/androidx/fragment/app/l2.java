package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class l2 implements Runnable {
    final /* synthetic */ Object A;
    final /* synthetic */ Rect C;
    final /* synthetic */ y2 c;
    final /* synthetic */ h.d.b d;
    final /* synthetic */ Object e;
    final /* synthetic */ n2 f;
    final /* synthetic */ ArrayList g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ View f264h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Fragment f265i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Fragment f266j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f267k;
    final /* synthetic */ ArrayList t;

    l2(y2 y2Var, h.d.b bVar, Object obj, n2 n2Var, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.c = y2Var;
        this.d = bVar;
        this.e = obj;
        this.f = n2Var;
        this.g = arrayList;
        this.f264h = view;
        this.f265i = fragment;
        this.f266j = fragment2;
        this.f267k = z;
        this.t = arrayList2;
        this.A = obj2;
        this.C = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        h.d.b<String, View> bVarH = o2.h(this.c, this.d, this.e, this.f);
        if (bVarH != null) {
            this.g.addAll(bVarH.values());
            this.g.add(this.f264h);
        }
        o2.f(this.f265i, this.f266j, this.f267k, bVarH, false);
        Object obj = this.e;
        if (obj != null) {
            this.c.A(obj, this.t, this.g);
            View viewT = o2.t(bVarH, this.f, this.A, this.f267k);
            if (viewT != null) {
                this.c.k(viewT, this.C);
            }
        }
    }
}
