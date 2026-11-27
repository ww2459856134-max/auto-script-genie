package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class r extends j3 {
    r(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<o> list, List<i3> list2, boolean z, Map<i3, Boolean> map) {
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (o oVar : list) {
            if (oVar.d()) {
                oVar.a();
            } else {
                m0 m0VarE = oVar.e(context);
                if (m0VarE == null) {
                    oVar.a();
                } else {
                    Animator animator = m0VarE.b;
                    if (animator == null) {
                        arrayList.add(oVar);
                    } else {
                        i3 i3VarB = oVar.b();
                        Fragment fragmentF = i3VarB.f();
                        if (Boolean.TRUE.equals(map.get(i3VarB))) {
                            if (p1.F0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            oVar.a();
                        } else {
                            boolean z3 = i3VarB.e() == h3.GONE;
                            if (z3) {
                                list2.remove(i3VarB);
                            }
                            View view = fragmentF.h0;
                            viewGroupM.startViewTransition(view);
                            animator.addListener(new f(this, viewGroupM, view, z3, i3VarB, oVar));
                            animator.setTarget(view);
                            animator.start();
                            oVar.c().c(new g(this, animator));
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o oVar2 = (o) it.next();
            i3 i3VarB2 = oVar2.b();
            Fragment fragmentF2 = i3VarB2.f();
            if (z) {
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                oVar2.a();
            } else if (z2) {
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                oVar2.a();
            } else {
                View view2 = fragmentF2.h0;
                m0 m0VarE2 = oVar2.e(context);
                h.e.i.h.d(m0VarE2);
                Animation animation = m0VarE2.a;
                h.e.i.h.d(animation);
                Animation animation2 = animation;
                if (i3VarB2.e() != h3.REMOVED) {
                    view2.startAnimation(animation2);
                    oVar2.a();
                } else {
                    viewGroupM.startViewTransition(view2);
                    n0 n0Var = new n0(animation2, viewGroupM, view2);
                    n0Var.setAnimationListener(new i(this, viewGroupM, view2, oVar2));
                    view2.startAnimation(n0Var);
                }
                oVar2.c().c(new j(this, view2, viewGroupM, oVar2));
            }
        }
    }

    private Map<i3, Boolean> x(List<q> list, List<i3> list2, boolean z, i3 i3Var, i3 i3Var2) {
        Iterator<q> it;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        i3 i3Var3;
        i3 i3Var4;
        View view2;
        Object objN;
        h.d.b bVar;
        ArrayList<View> arrayList3;
        r rVar;
        i3 i3Var5;
        ArrayList<View> arrayList4;
        Rect rect;
        y2 y2Var;
        i3 i3Var6;
        View view3;
        androidx.core.app.q qVarA;
        androidx.core.app.q qVarD;
        ArrayList<String> arrayList5;
        View view4;
        View view5;
        String strQ;
        ArrayList<String> arrayList6;
        r rVar2 = this;
        boolean z2 = z;
        i3 i3Var7 = i3Var;
        i3 i3Var8 = i3Var2;
        HashMap map = new HashMap();
        y2 y2Var2 = null;
        for (q qVar : list) {
            if (!qVar.d()) {
                y2 y2VarE = qVar.e();
                if (y2Var2 == null) {
                    y2Var2 = y2VarE;
                } else if (y2VarE != null && y2Var2 != y2VarE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + qVar.b().f() + " returned Transition " + qVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (y2Var2 == null) {
            for (q qVar2 : list) {
                map.put(qVar2.b(), Boolean.FALSE);
                qVar2.a();
            }
            return map;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        h.d.b bVar2 = new h.d.b();
        Object obj3 = null;
        View view7 = null;
        boolean z3 = false;
        for (q qVar3 : list) {
            if (!qVar3.i() || i3Var7 == null || i3Var8 == null) {
                bVar = bVar2;
                arrayList3 = arrayList8;
                rVar = rVar2;
                i3Var5 = i3Var7;
                arrayList4 = arrayList7;
                rect = rect2;
                y2Var = y2Var2;
                i3Var6 = i3Var8;
                view3 = view6;
                view7 = view7;
            } else {
                Object objB = y2Var2.B(y2Var2.g(qVar3.g()));
                ArrayList<String> arrayListV = i3Var2.f().V();
                ArrayList<String> arrayListV2 = i3Var.f().V();
                ArrayList<String> arrayListW = i3Var.f().W();
                View view8 = view7;
                int i2 = 0;
                while (i2 < arrayListW.size()) {
                    int iIndexOf = arrayListV.indexOf(arrayListW.get(i2));
                    ArrayList<String> arrayList9 = arrayListW;
                    if (iIndexOf != -1) {
                        arrayListV.set(iIndexOf, arrayListV2.get(i2));
                    }
                    i2++;
                    arrayListW = arrayList9;
                }
                ArrayList<String> arrayListW2 = i3Var2.f().W();
                if (z2) {
                    qVarA = i3Var.f().A();
                    qVarD = i3Var2.f().D();
                } else {
                    qVarA = i3Var.f().D();
                    qVarD = i3Var2.f().A();
                }
                int i3 = 0;
                for (int size = arrayListV.size(); i3 < size; size = size) {
                    bVar2.put(arrayListV.get(i3), arrayListW2.get(i3));
                    i3++;
                }
                h.d.b<String, View> bVar3 = new h.d.b<>();
                rVar2.u(bVar3, i3Var.f().h0);
                bVar3.o(arrayListV);
                if (qVarA != null) {
                    qVarA.a(arrayListV, bVar3);
                    int size2 = arrayListV.size() - 1;
                    while (size2 >= 0) {
                        String str = arrayListV.get(size2);
                        View view9 = bVar3.get(str);
                        if (view9 == null) {
                            bVar2.remove(str);
                            arrayList6 = arrayListV;
                        } else {
                            arrayList6 = arrayListV;
                            if (!str.equals(h.e.j.s0.E(view9))) {
                                bVar2.put(h.e.j.s0.E(view9), (String) bVar2.remove(str));
                            }
                        }
                        size2--;
                        arrayListV = arrayList6;
                    }
                    arrayList5 = arrayListV;
                } else {
                    arrayList5 = arrayListV;
                    bVar2.o(bVar3.keySet());
                }
                h.d.b<String, View> bVar4 = new h.d.b<>();
                rVar2.u(bVar4, i3Var2.f().h0);
                bVar4.o(arrayListW2);
                bVar4.o(bVar2.values());
                if (qVarD != null) {
                    qVarD.a(arrayListW2, bVar4);
                    for (int size3 = arrayListW2.size() - 1; size3 >= 0; size3--) {
                        String str2 = arrayListW2.get(size3);
                        View view10 = bVar4.get(str2);
                        if (view10 == null) {
                            String strQ2 = o2.q(bVar2, str2);
                            if (strQ2 != null) {
                                bVar2.remove(strQ2);
                            }
                        } else if (!str2.equals(h.e.j.s0.E(view10)) && (strQ = o2.q(bVar2, str2)) != null) {
                            bVar2.put(strQ, h.e.j.s0.E(view10));
                        }
                    }
                } else {
                    o2.y(bVar2, bVar4);
                }
                rVar2.v(bVar3, bVar2.keySet());
                rVar2.v(bVar4, bVar2.values());
                if (bVar2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    i3Var5 = i3Var;
                    bVar = bVar2;
                    arrayList3 = arrayList8;
                    rVar = rVar2;
                    arrayList4 = arrayList7;
                    rect = rect2;
                    view3 = view6;
                    y2Var = y2Var2;
                    view7 = view8;
                    obj3 = null;
                    i3Var6 = i3Var2;
                } else {
                    o2.f(i3Var2.f(), i3Var.f(), z2, bVar3, true);
                    ArrayList<String> arrayList10 = arrayList5;
                    HashMap map2 = map;
                    View view11 = view6;
                    bVar = bVar2;
                    ArrayList<View> arrayList11 = arrayList8;
                    h.e.j.d0.a(m(), new k(this, i3Var2, i3Var, z, bVar4));
                    arrayList7.addAll(bVar3.values());
                    if (arrayList10.isEmpty()) {
                        view7 = view8;
                    } else {
                        View view12 = bVar3.get(arrayList10.get(0));
                        y2Var2.v(objB, view12);
                        view7 = view12;
                    }
                    arrayList3 = arrayList11;
                    arrayList3.addAll(bVar4.values());
                    if (arrayListW2.isEmpty() || (view5 = bVar4.get(arrayListW2.get(0))) == null) {
                        rVar = this;
                        view4 = view11;
                    } else {
                        rVar = this;
                        h.e.j.d0.a(m(), new l(rVar, y2Var2, view5, rect2));
                        view4 = view11;
                        z3 = true;
                    }
                    y2Var2.z(objB, view4, arrayList7);
                    arrayList4 = arrayList7;
                    rect = rect2;
                    view3 = view4;
                    y2Var = y2Var2;
                    y2Var2.t(objB, null, null, null, null, objB, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    i3Var5 = i3Var;
                    map = map2;
                    map.put(i3Var5, bool);
                    i3Var6 = i3Var2;
                    map.put(i3Var6, bool);
                    obj3 = objB;
                }
            }
            z2 = z;
            arrayList7 = arrayList4;
            rVar2 = rVar;
            rect2 = rect;
            view6 = view3;
            i3Var8 = i3Var6;
            bVar2 = bVar;
            arrayList8 = arrayList3;
            i3Var7 = i3Var5;
            y2Var2 = y2Var;
        }
        View view13 = view7;
        h.d.b bVar5 = bVar2;
        ArrayList<View> arrayList12 = arrayList8;
        r rVar3 = rVar2;
        i3 i3Var9 = i3Var7;
        ArrayList<View> arrayList13 = arrayList7;
        Rect rect3 = rect2;
        y2 y2Var3 = y2Var2;
        i3 i3Var10 = i3Var8;
        View view14 = view6;
        ArrayList arrayList14 = new ArrayList();
        Iterator<q> it2 = list.iterator();
        Object obj4 = null;
        Object objN2 = null;
        while (it2.hasNext()) {
            q next = it2.next();
            if (next.d()) {
                map.put(next.b(), Boolean.FALSE);
                next.a();
            } else {
                Object objG = y2Var3.g(next.h());
                i3 i3VarB = next.b();
                boolean z4 = obj3 != null && (i3VarB == i3Var9 || i3VarB == i3Var10);
                if (objG == null) {
                    if (!z4) {
                        map.put(i3VarB, Boolean.FALSE);
                        next.a();
                    }
                    arrayList2 = arrayList12;
                    arrayList = arrayList13;
                    it = it2;
                    view = view14;
                    objN = obj4;
                    i3Var3 = i3Var10;
                    view2 = view13;
                } else {
                    it = it2;
                    ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj5 = obj4;
                    rVar3.t(arrayList15, i3VarB.f().h0);
                    if (z4) {
                        if (i3VarB == i3Var9) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        y2Var3.a(objG, view14);
                        arrayList2 = arrayList12;
                        arrayList = arrayList13;
                        view = view14;
                        i3Var4 = i3VarB;
                        obj2 = objN2;
                        i3Var3 = i3Var10;
                        obj = obj5;
                    } else {
                        y2Var3.b(objG, arrayList15);
                        view = view14;
                        obj = obj5;
                        arrayList = arrayList13;
                        obj2 = objN2;
                        arrayList2 = arrayList12;
                        i3Var3 = i3Var10;
                        y2Var3.t(objG, objG, arrayList15, null, null, null, null);
                        if (i3VarB.e() == h3.GONE) {
                            i3Var4 = i3VarB;
                            list2.remove(i3Var4);
                            ArrayList<View> arrayList16 = new ArrayList<>(arrayList15);
                            arrayList16.remove(i3Var4.f().h0);
                            y2Var3.r(objG, i3Var4.f().h0, arrayList16);
                            h.e.j.d0.a(m(), new m(rVar3, arrayList15));
                        } else {
                            i3Var4 = i3VarB;
                        }
                    }
                    if (i3Var4.e() == h3.VISIBLE) {
                        arrayList14.addAll(arrayList15);
                        if (z3) {
                            y2Var3.u(objG, rect3);
                        }
                        view2 = view13;
                    } else {
                        view2 = view13;
                        y2Var3.v(objG, view2);
                    }
                    map.put(i3Var4, Boolean.TRUE);
                    if (next.j()) {
                        objN2 = y2Var3.n(obj2, objG, null);
                        objN = obj;
                    } else {
                        objN = y2Var3.n(obj, objG, null);
                        objN2 = obj2;
                    }
                }
                i3Var10 = i3Var3;
                obj4 = objN;
                view13 = view2;
                view14 = view;
                arrayList13 = arrayList;
                arrayList12 = arrayList2;
                it2 = it;
            }
        }
        ArrayList<View> arrayList17 = arrayList12;
        ArrayList<View> arrayList18 = arrayList13;
        i3 i3Var11 = i3Var10;
        Object objM = y2Var3.m(objN2, obj4, obj3);
        for (q qVar4 : list) {
            if (!qVar4.d()) {
                Object objH = qVar4.h();
                i3 i3VarB2 = qVar4.b();
                boolean z5 = obj3 != null && (i3VarB2 == i3Var9 || i3VarB2 == i3Var11);
                if (objH != null || z5) {
                    if (h.e.j.s0.K(m())) {
                        y2Var3.w(qVar4.b().f(), objM, qVar4.c(), new n(rVar3, qVar4));
                    } else {
                        if (p1.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + i3VarB2);
                        }
                        qVar4.a();
                    }
                }
            }
        }
        if (!h.e.j.s0.K(m())) {
            return map;
        }
        o2.B(arrayList14, 4);
        ArrayList<String> arrayListO = y2Var3.o(arrayList17);
        y2Var3.c(m(), objM);
        y2Var3.y(m(), arrayList18, arrayList17, arrayListO, bVar5);
        o2.B(arrayList14, 0);
        y2Var3.A(obj3, arrayList18, arrayList17);
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    @Override // androidx.fragment.app.j3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(List<i3> list, boolean z) {
        i3 i3Var = null;
        i3 i3Var2 = null;
        for (i3 i3Var3 : list) {
            h3 h3VarC = h3.c(i3Var3.f().h0);
            int i2 = d.a[i3Var3.e().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (h3VarC == h3.VISIBLE && i3Var == null) {
                    i3Var = i3Var3;
                }
            } else if (i2 == 4 && h3VarC != h3.VISIBLE) {
                i3Var2 = i3Var3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (i3 i3Var4 : list) {
            h.e.f.c cVar = new h.e.f.c();
            i3Var4.j(cVar);
            arrayList.add(new o(i3Var4, cVar, z));
            h.e.f.c cVar2 = new h.e.f.c();
            i3Var4.j(cVar2);
            boolean z2 = false;
            if (z) {
                if (i3Var4 == i3Var) {
                    z2 = true;
                }
            } else if (i3Var4 == i3Var2) {
            }
            arrayList2.add(new q(i3Var4, cVar2, z, z2));
            i3Var4.a(new e(this, arrayList3, i3Var4));
        }
        Map<i3, Boolean> mapX = x(arrayList2, arrayList3, z, i3Var, i3Var2);
        w(arrayList, arrayList3, mapX.containsValue(Boolean.TRUE), mapX);
        Iterator<i3> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
    }

    void s(i3 i3Var) {
        i3Var.e().a(i3Var.f().h0);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (h.e.j.u0.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, View view) {
        String strE = h.e.j.s0.E(view);
        if (strE != null) {
            map.put(strE, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(h.d.b<String, View> bVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = bVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(h.e.j.s0.E(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
