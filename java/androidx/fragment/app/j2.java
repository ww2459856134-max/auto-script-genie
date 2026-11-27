package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class j2 implements Runnable {
    final /* synthetic */ Object c;
    final /* synthetic */ y2 d;
    final /* synthetic */ View e;
    final /* synthetic */ Fragment f;
    final /* synthetic */ ArrayList g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ ArrayList f259h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ArrayList f260i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Object f261j;

    j2(Object obj, y2 y2Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.c = obj;
        this.d = y2Var;
        this.e = view;
        this.f = fragment;
        this.g = arrayList;
        this.f259h = arrayList2;
        this.f260i = arrayList3;
        this.f261j = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.c;
        if (obj != null) {
            this.d.p(obj, this.e);
            this.f259h.addAll(o2.k(this.d, this.c, this.f, this.g, this.e));
        }
        if (this.f260i != null) {
            if (this.f261j != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.e);
                this.d.q(this.f261j, this.f260i, arrayList);
            }
            this.f260i.clear();
            this.f260i.add(this.e);
        }
    }
}
