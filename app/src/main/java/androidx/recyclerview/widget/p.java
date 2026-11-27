package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class p extends g1 {
    private static TimeInterpolator s;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f368h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f369i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<o> f370j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<n> f371k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.d0>> f372l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    ArrayList<ArrayList<o>> f373m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    ArrayList<ArrayList<n>> f374n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f375o = new ArrayList<>();
    ArrayList<RecyclerView.d0> p = new ArrayList<>();
    ArrayList<RecyclerView.d0> q = new ArrayList<>();
    ArrayList<RecyclerView.d0> r = new ArrayList<>();

    private void V(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.q.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new i(this, d0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    private void Y(List<n> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            n nVar = list.get(size);
            if (a0(nVar, d0Var) && nVar.a == null && nVar.b == null) {
                list.remove(nVar);
            }
        }
    }

    private void Z(n nVar) {
        RecyclerView.d0 d0Var = nVar.a;
        if (d0Var != null) {
            a0(nVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = nVar.b;
        if (d0Var2 != null) {
            a0(nVar, d0Var2);
        }
    }

    private boolean a0(n nVar, RecyclerView.d0 d0Var) {
        boolean z = false;
        if (nVar.b == d0Var) {
            nVar.b = null;
        } else {
            if (nVar.a != d0Var) {
                return false;
            }
            nVar.a = null;
            z = true;
        }
        d0Var.itemView.setAlpha(1.0f);
        d0Var.itemView.setTranslationX(0.0f);
        d0Var.itemView.setTranslationY(0.0f);
        D(d0Var, z);
        return true;
    }

    private void b0(RecyclerView.d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.itemView.animate().setInterpolator(s);
        j(d0Var);
    }

    @Override // androidx.recyclerview.widget.g1
    public boolean A(RecyclerView.d0 d0Var) {
        b0(d0Var);
        this.f368h.add(d0Var);
        return true;
    }

    void S(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f375o.add(d0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new j(this, d0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    void T(n nVar) {
        RecyclerView.d0 d0Var = nVar.a;
        View view = d0Var == null ? null : d0Var.itemView;
        RecyclerView.d0 d0Var2 = nVar.b;
        View view2 = d0Var2 != null ? d0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.r.add(nVar.a);
            duration.translationX(nVar.e - nVar.c);
            duration.translationY(nVar.f - nVar.d);
            duration.alpha(0.0f).setListener(new l(this, nVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.r.add(nVar.b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new m(this, nVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    void U(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.p.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new k(this, d0Var, i6, view, i7, viewPropertyAnimatorAnimate)).start();
    }

    void W(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void X() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        view.animate().cancel();
        int size = this.f370j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f370j.get(size).a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(d0Var);
                this.f370j.remove(size);
            }
        }
        Y(this.f371k, d0Var);
        if (this.f368h.remove(d0Var)) {
            view.setAlpha(1.0f);
            H(d0Var);
        }
        if (this.f369i.remove(d0Var)) {
            view.setAlpha(1.0f);
            B(d0Var);
        }
        for (int size2 = this.f374n.size() - 1; size2 >= 0; size2--) {
            ArrayList<n> arrayList = this.f374n.get(size2);
            Y(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f374n.remove(size2);
            }
        }
        for (int size3 = this.f373m.size() - 1; size3 >= 0; size3--) {
            ArrayList<o> arrayList2 = this.f373m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f373m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f372l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.f372l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                B(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f372l.remove(size5);
                }
            }
        }
        this.q.remove(d0Var);
        this.f375o.remove(d0Var);
        this.r.remove(d0Var);
        this.p.remove(d0Var);
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f370j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            o oVar = this.f370j.get(size);
            View view = oVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(oVar.a);
            this.f370j.remove(size);
        }
        for (int size2 = this.f368h.size() - 1; size2 >= 0; size2--) {
            H(this.f368h.get(size2));
            this.f368h.remove(size2);
        }
        int size3 = this.f369i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f369i.get(size3);
            d0Var.itemView.setAlpha(1.0f);
            B(d0Var);
            this.f369i.remove(size3);
        }
        for (int size4 = this.f371k.size() - 1; size4 >= 0; size4--) {
            Z(this.f371k.get(size4));
        }
        this.f371k.clear();
        if (p()) {
            for (int size5 = this.f373m.size() - 1; size5 >= 0; size5--) {
                ArrayList<o> arrayList = this.f373m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    o oVar2 = arrayList.get(size6);
                    View view2 = oVar2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(oVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f373m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f372l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.f372l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.itemView.setAlpha(1.0f);
                    B(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f372l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f374n.size() - 1; size9 >= 0; size9--) {
                ArrayList<n> arrayList3 = this.f374n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Z(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f374n.remove(arrayList3);
                    }
                }
            }
            W(this.q);
            W(this.p);
            W(this.f375o);
            W(this.r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f369i.isEmpty() && this.f371k.isEmpty() && this.f370j.isEmpty() && this.f368h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.f375o.isEmpty() && this.r.isEmpty() && this.f373m.isEmpty() && this.f372l.isEmpty() && this.f374n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean z = !this.f368h.isEmpty();
        boolean z2 = !this.f370j.isEmpty();
        boolean z3 = !this.f371k.isEmpty();
        boolean z4 = !this.f369i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.d0> it = this.f368h.iterator();
            while (it.hasNext()) {
                V(it.next());
            }
            this.f368h.clear();
            if (z2) {
                ArrayList<o> arrayList = new ArrayList<>();
                arrayList.addAll(this.f370j);
                this.f373m.add(arrayList);
                this.f370j.clear();
                f fVar = new f(this, arrayList);
                if (z) {
                    h.e.j.s0.V(arrayList.get(0).a.itemView, fVar, o());
                } else {
                    fVar.run();
                }
            }
            if (z3) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f371k);
                this.f374n.add(arrayList2);
                this.f371k.clear();
                g gVar = new g(this, arrayList2);
                if (z) {
                    h.e.j.s0.V(arrayList2.get(0).a.itemView, gVar, o());
                } else {
                    gVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f369i);
                this.f372l.add(arrayList3);
                this.f369i.clear();
                h hVar = new h(this, arrayList3);
                if (z || z2 || z3) {
                    h.e.j.s0.V(arrayList3.get(0).itemView, hVar, (z ? o() : 0L) + Math.max(z2 ? n() : 0L, z3 ? m() : 0L));
                } else {
                    hVar.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.g1
    public boolean x(RecyclerView.d0 d0Var) {
        b0(d0Var);
        d0Var.itemView.setAlpha(0.0f);
        this.f369i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.g1
    public boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
        if (d0Var == d0Var2) {
            return z(d0Var, i2, i3, i4, i5);
        }
        float translationX = d0Var.itemView.getTranslationX();
        float translationY = d0Var.itemView.getTranslationY();
        float alpha = d0Var.itemView.getAlpha();
        b0(d0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        d0Var.itemView.setTranslationX(translationX);
        d0Var.itemView.setTranslationY(translationY);
        d0Var.itemView.setAlpha(alpha);
        if (d0Var2 != null) {
            b0(d0Var2);
            d0Var2.itemView.setTranslationX(-i6);
            d0Var2.itemView.setTranslationY(-i7);
            d0Var2.itemView.setAlpha(0.0f);
        }
        this.f371k.add(new n(d0Var, d0Var2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.g1
    public boolean z(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) d0Var.itemView.getTranslationY());
        b0(d0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            F(d0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.f370j.add(new o(d0Var, translationX, translationY, i4, i5));
        return true;
    }
}
