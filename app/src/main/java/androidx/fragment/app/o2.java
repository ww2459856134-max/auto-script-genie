package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
abstract class o2 {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    static final y2 b;
    static final y2 c;

    static {
        b = Build.VERSION.SDK_INT >= 21 ? new u2() : null;
        c = x();
    }

    private static void A(y2 y2Var, Object obj, Object obj2, h.d.b<String, View> bVar, boolean z, a aVar) {
        ArrayList<String> arrayList = aVar.f256m;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = bVar.get(z ? aVar.f257n.get(0) : aVar.f256m.get(0));
        y2Var.v(obj, view);
        if (obj2 != null) {
            y2Var.v(obj2, view);
        }
    }

    static void B(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    static void C(Context context, p0 p0Var, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, m2 m2Var) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = sparseArray.keyAt(i5);
                h.d.b<String, String> bVarD = d(iKeyAt, arrayList, arrayList2, i2, i3);
                n2 n2Var = (n2) sparseArray.valueAt(i5);
                if (p0Var.g() && (viewGroup = (ViewGroup) p0Var.d(iKeyAt)) != null) {
                    if (z) {
                        o(viewGroup, n2Var, view, bVarD, m2Var);
                    } else {
                        n(viewGroup, n2Var, view, bVarD, m2Var);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, h.d.b<String, View> bVar, Collection<String> collection) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View viewM = bVar.m(size);
            if (collection.contains(h.e.j.s0.E(viewM))) {
                arrayList.add(viewM);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(a aVar, e2 e2Var, SparseArray<n2> sparseArray, boolean z, boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        View view;
        Fragment fragment = e2Var.b;
        if (fragment == null || (i2 = fragment.V) == 0) {
            return;
        }
        int i3 = z ? a[e2Var.a] : e2Var.a;
        boolean z6 = false;
        boolean z7 = true;
        if (i3 == 1) {
            if (z2) {
                z3 = (fragment.C || fragment.Z) ? false : true;
                z4 = false;
                z6 = z3;
                z5 = false;
            } else {
                z3 = fragment.l0;
                z4 = false;
                z6 = z3;
                z5 = false;
            }
        } else if (i3 == 3) {
            boolean z8 = z2 ? !(!fragment.C || fragment.Z) : !(fragment.C || (view = fragment.h0) == null || view.getVisibility() != 0 || fragment.n0 < 0.0f);
            z4 = z8;
            z5 = true;
            z7 = false;
        } else if (i3 == 4) {
            if (!z2 ? !fragment.C || fragment.Z : !fragment.m0 || !fragment.C || !fragment.Z) {
            }
            z4 = z8;
            z5 = true;
            z7 = false;
        } else if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    z5 = false;
                    z7 = false;
                    z4 = false;
                }
                if (z2) {
                }
            }
            if (z2) {
            }
            z4 = z8;
            z5 = true;
            z7 = false;
        } else if (z2) {
            if (!fragment.m0 || fragment.Z || !fragment.C) {
            }
            z4 = false;
            z6 = z3;
            z5 = false;
        } else {
            z3 = fragment.Z;
            z4 = false;
            z6 = z3;
            z5 = false;
        }
        n2 n2VarP = sparseArray.get(i2);
        if (z6) {
            n2VarP = p(n2VarP, sparseArray, i2);
            n2VarP.a = fragment;
            n2VarP.b = z;
            n2VarP.c = aVar;
        }
        if (!z2 && z7) {
            if (n2VarP != null && n2VarP.d == fragment) {
                n2VarP.d = null;
            }
            if (!aVar.f258o) {
                p1 p1Var = aVar.q;
                p1Var.r0().p(p1Var.v(fragment));
                p1Var.P0(fragment);
            }
        }
        if (z4 && (n2VarP == null || n2VarP.d == null)) {
            n2VarP = p(n2VarP, sparseArray, i2);
            n2VarP.d = fragment;
            n2VarP.e = z;
            n2VarP.f = aVar;
        }
        if (z2 || !z5 || n2VarP == null || n2VarP.a != fragment) {
            return;
        }
        n2VarP.a = null;
    }

    public static void c(a aVar, SparseArray<n2> sparseArray, boolean z) {
        int size = aVar.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(aVar, aVar.a.get(i2), sparseArray, false, z);
        }
    }

    private static h.d.b<String, String> d(int i2, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        h.d.b<String, String> bVar = new h.d.b<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            a aVar = arrayList.get(i5);
            if (aVar.z(i2)) {
                boolean zBooleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar.f256m;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar.f256m;
                        arrayList4 = aVar.f257n;
                    } else {
                        ArrayList<String> arrayList6 = aVar.f256m;
                        arrayList3 = aVar.f257n;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String strRemove = bVar.remove(str2);
                        if (strRemove != null) {
                            bVar.put(str, strRemove);
                        } else {
                            bVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public static void e(a aVar, SparseArray<n2> sparseArray, boolean z) {
        if (aVar.q.o0().g()) {
            for (int size = aVar.a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.a.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, h.d.b<String, View> bVar, boolean z2) {
        androidx.core.app.q qVarA = z ? fragment2.A() : fragment.A();
        if (qVarA != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = bVar == null ? 0 : bVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(bVar.i(i2));
                arrayList.add(bVar.m(i2));
            }
            if (z2) {
                qVarA.c(arrayList2, arrayList, null);
            } else {
                qVarA.b(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean g(y2 y2Var, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!y2Var.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static h.d.b<String, View> h(y2 y2Var, h.d.b<String, String> bVar, Object obj, n2 n2Var) {
        androidx.core.app.q qVarA;
        ArrayList<String> arrayList;
        String strQ;
        Fragment fragment = n2Var.a;
        View viewY = fragment.Y();
        if (bVar.isEmpty() || obj == null || viewY == null) {
            bVar.clear();
            return null;
        }
        h.d.b<String, View> bVar2 = new h.d.b<>();
        y2Var.j(bVar2, viewY);
        a aVar = n2Var.c;
        if (n2Var.b) {
            qVarA = fragment.D();
            arrayList = aVar.f256m;
        } else {
            qVarA = fragment.A();
            arrayList = aVar.f257n;
        }
        if (arrayList != null) {
            bVar2.o(arrayList);
            bVar2.o(bVar.values());
        }
        if (qVarA != null) {
            qVarA.a(arrayList, bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = bVar2.get(str);
                if (view == null) {
                    String strQ2 = q(bVar, str);
                    if (strQ2 != null) {
                        bVar.remove(strQ2);
                    }
                } else if (!str.equals(h.e.j.s0.E(view)) && (strQ = q(bVar, str)) != null) {
                    bVar.put(strQ, h.e.j.s0.E(view));
                }
            }
        } else {
            y(bVar, bVar2);
        }
        return bVar2;
    }

    private static h.d.b<String, View> i(y2 y2Var, h.d.b<String, String> bVar, Object obj, n2 n2Var) {
        androidx.core.app.q qVarD;
        ArrayList<String> arrayList;
        if (bVar.isEmpty() || obj == null) {
            bVar.clear();
            return null;
        }
        Fragment fragment = n2Var.d;
        h.d.b<String, View> bVar2 = new h.d.b<>();
        y2Var.j(bVar2, fragment.z1());
        a aVar = n2Var.f;
        if (n2Var.e) {
            qVarD = fragment.A();
            arrayList = aVar.f257n;
        } else {
            qVarD = fragment.D();
            arrayList = aVar.f256m;
        }
        if (arrayList != null) {
            bVar2.o(arrayList);
        }
        if (qVarD != null) {
            qVarD.a(arrayList, bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = bVar2.get(str);
                if (view == null) {
                    bVar.remove(str);
                } else if (!str.equals(h.e.j.s0.E(view))) {
                    bVar.put(h.e.j.s0.E(view), bVar.remove(str));
                }
            }
        } else {
            bVar.o(bVar2.keySet());
        }
        return bVar2;
    }

    private static y2 j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object objC = fragment.C();
            if (objC != null) {
                arrayList.add(objC);
            }
            Object objS = fragment.S();
            if (objS != null) {
                arrayList.add(objS);
            }
            Object objU = fragment.U();
            if (objU != null) {
                arrayList.add(objU);
            }
        }
        if (fragment2 != null) {
            Object objZ = fragment2.z();
            if (objZ != null) {
                arrayList.add(objZ);
            }
            Object objQ = fragment2.Q();
            if (objQ != null) {
                arrayList.add(objQ);
            }
            Object objT = fragment2.T();
            if (objT != null) {
                arrayList.add(objT);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        y2 y2Var = b;
        if (y2Var != null && g(y2Var, arrayList)) {
            return y2Var;
        }
        y2 y2Var2 = c;
        if (y2Var2 != null && g(y2Var2, arrayList)) {
            return y2Var2;
        }
        if (y2Var == null && y2Var2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(y2 y2Var, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewY = fragment.Y();
        if (viewY != null) {
            y2Var.f(arrayList2, viewY);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        y2Var.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(y2 y2Var, ViewGroup viewGroup, View view, h.d.b<String, String> bVar, n2 n2Var, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object objU;
        h.d.b<String, String> bVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = n2Var.a;
        Fragment fragment2 = n2Var.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = n2Var.b;
        if (bVar.isEmpty()) {
            bVar2 = bVar;
            objU = null;
        } else {
            objU = u(y2Var, fragment, fragment2, z);
            bVar2 = bVar;
        }
        h.d.b<String, View> bVarI = i(y2Var, bVar2, objU, n2Var);
        if (bVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(bVarI.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, bVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            y2Var.z(obj3, view, arrayList);
            A(y2Var, obj3, obj2, bVarI, n2Var.e, n2Var.f);
            if (obj != null) {
                y2Var.u(obj, rect);
            }
        } else {
            rect = null;
        }
        h.e.j.d0.a(viewGroup, new l2(y2Var, bVar, obj3, n2Var, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(y2 y2Var, ViewGroup viewGroup, View view, h.d.b<String, String> bVar, n2 n2Var, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = n2Var.a;
        Fragment fragment2 = n2Var.d;
        if (fragment != null) {
            fragment.z1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = n2Var.b;
        Object objU = bVar.isEmpty() ? null : u(y2Var, fragment, fragment2, z);
        h.d.b<String, View> bVarI = i(y2Var, bVar, objU, n2Var);
        h.d.b<String, View> bVarH = h(y2Var, bVar, objU, n2Var);
        if (bVar.isEmpty()) {
            if (bVarI != null) {
                bVarI.clear();
            }
            if (bVarH != null) {
                bVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, bVarI, bVar.keySet());
            a(arrayList2, bVarH, bVar.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, bVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            y2Var.z(obj3, view, arrayList);
            A(y2Var, obj3, obj2, bVarI, n2Var.e, n2Var.f);
            Rect rect2 = new Rect();
            View viewT = t(bVarH, n2Var, obj, z);
            if (viewT != null) {
                y2Var.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewT;
        } else {
            view2 = null;
            rect = null;
        }
        h.e.j.d0.a(viewGroup, new k2(fragment, fragment2, z, bVarH, view2, y2Var, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, n2 n2Var, View view, h.d.b<String, String> bVar, m2 m2Var) {
        Object obj;
        Fragment fragment = n2Var.a;
        Fragment fragment2 = n2Var.d;
        y2 y2VarJ = j(fragment2, fragment);
        if (y2VarJ == null) {
            return;
        }
        boolean z = n2Var.b;
        boolean z2 = n2Var.e;
        Object objR = r(y2VarJ, fragment, z);
        Object objS = s(y2VarJ, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(y2VarJ, viewGroup, view, bVar, n2Var, arrayList, arrayList2, objR, objS);
        if (objR == null && objL == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(y2VarJ, obj, fragment2, arrayList, view);
        if (arrayListK == null || arrayListK.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        y2VarJ.a(objR, view);
        Object objV = v(y2VarJ, objR, obj2, objL, fragment, n2Var.b);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            h.e.f.c cVar = new h.e.f.c();
            m2Var.b(fragment2, cVar);
            y2VarJ.w(fragment2, objV, cVar, new i2(m2Var, fragment2, cVar));
        }
        if (objV != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            y2VarJ.t(objV, objR, arrayList3, obj2, arrayListK, objL, arrayList2);
            z(y2VarJ, viewGroup, fragment, view, arrayList2, objR, arrayList3, obj2, arrayListK);
            y2VarJ.x(viewGroup, arrayList2, bVar);
            y2VarJ.c(viewGroup, objV);
            y2VarJ.s(viewGroup, arrayList2, bVar);
        }
    }

    private static void o(ViewGroup viewGroup, n2 n2Var, View view, h.d.b<String, String> bVar, m2 m2Var) {
        Object obj;
        Fragment fragment = n2Var.a;
        Fragment fragment2 = n2Var.d;
        y2 y2VarJ = j(fragment2, fragment);
        if (y2VarJ == null) {
            return;
        }
        boolean z = n2Var.b;
        boolean z2 = n2Var.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objR = r(y2VarJ, fragment, z);
        Object objS = s(y2VarJ, fragment2, z2);
        Object objM = m(y2VarJ, viewGroup, view, bVar, n2Var, arrayList2, arrayList, objR, objS);
        if (objR == null && objM == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(y2VarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(y2VarJ, objR, fragment, arrayList, view);
        B(arrayListK2, 4);
        Object objV = v(y2VarJ, objR, obj, objM, fragment, z);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            h.e.f.c cVar = new h.e.f.c();
            m2Var.b(fragment2, cVar);
            y2VarJ.w(fragment2, objV, cVar, new g2(m2Var, fragment2, cVar));
        }
        if (objV != null) {
            w(y2VarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = y2VarJ.o(arrayList);
            y2VarJ.t(objV, objR, arrayListK2, obj, arrayListK, objM, arrayList);
            y2VarJ.c(viewGroup, objV);
            y2VarJ.y(viewGroup, arrayList2, arrayList, arrayListO, bVar);
            B(arrayListK2, 0);
            y2VarJ.A(objM, arrayList2, arrayList);
        }
    }

    private static n2 p(n2 n2Var, SparseArray<n2> sparseArray, int i2) {
        if (n2Var != null) {
            return n2Var;
        }
        n2 n2Var2 = new n2();
        sparseArray.put(i2, n2Var2);
        return n2Var2;
    }

    static String q(h.d.b<String, String> bVar, String str) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(bVar.m(i2))) {
                return bVar.i(i2);
            }
        }
        return null;
    }

    private static Object r(y2 y2Var, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return y2Var.g(z ? fragment.Q() : fragment.z());
    }

    private static Object s(y2 y2Var, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return y2Var.g(z ? fragment.S() : fragment.C());
    }

    static View t(h.d.b<String, View> bVar, n2 n2Var, Object obj, boolean z) {
        ArrayList<String> arrayList;
        a aVar = n2Var.c;
        if (obj == null || bVar == null || (arrayList = aVar.f256m) == null || arrayList.isEmpty()) {
            return null;
        }
        return bVar.get(z ? aVar.f256m.get(0) : aVar.f257n.get(0));
    }

    private static Object u(y2 y2Var, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return y2Var.B(y2Var.g(z ? fragment2.U() : fragment.T()));
    }

    private static Object v(y2 y2Var, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.s() : fragment.r() ? y2Var.n(obj2, obj, obj3) : y2Var.m(obj2, obj, obj3);
    }

    private static void w(y2 y2Var, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.C && fragment.Z && fragment.m0) {
            fragment.I1(true);
            y2Var.r(obj, fragment.Y(), arrayList);
            h.e.j.d0.a(fragment.g0, new h2(arrayList));
        }
    }

    private static y2 x() {
        try {
            return (y2) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void y(h.d.b<String, String> bVar, h.d.b<String, View> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            if (!bVar2.containsKey(bVar.m(size))) {
                bVar.k(size);
            }
        }
    }

    private static void z(y2 y2Var, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        h.e.j.d0.a(viewGroup, new j2(obj, y2Var, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
