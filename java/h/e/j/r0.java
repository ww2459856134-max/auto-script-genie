package h.e.j;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class r0 {
    private static final ArrayList<WeakReference<View>> d = new ArrayList<>();
    private WeakHashMap<View, Boolean> a = null;
    private SparseArray<WeakReference<View>> b = null;
    private WeakReference<KeyEvent> c = null;

    r0() {
    }

    static r0 a(View view) {
        int i2 = h.e.b.f1283l;
        r0 r0Var = (r0) view.getTag(i2);
        if (r0Var != null) {
            return r0Var;
        }
        r0 r0Var2 = new r0();
        view.setTag(i2, r0Var2);
        return r0Var2;
    }

    private View c(View view, KeyEvent keyEvent) {
        WeakHashMap<View, Boolean> weakHashMap = this.a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                    if (viewC != null) {
                        return viewC;
                    }
                }
            }
            if (e(view, keyEvent)) {
                return view;
            }
        }
        return null;
    }

    private SparseArray<WeakReference<View>> d() {
        if (this.b == null) {
            this.b = new SparseArray<>();
        }
        return this.b;
    }

    private boolean e(View view, KeyEvent keyEvent) {
        ArrayList arrayList = (ArrayList) view.getTag(h.e.b.f1284m);
        if (arrayList == null) {
            return false;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((q0) arrayList.get(size)).a(view, keyEvent)) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        WeakHashMap<View, Boolean> weakHashMap = this.a;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        ArrayList<WeakReference<View>> arrayList = d;
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (arrayList) {
            if (this.a == null) {
                this.a = new WeakHashMap<>();
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<View>> arrayList2 = d;
                View view = arrayList2.get(size).get();
                if (view == null) {
                    arrayList2.remove(size);
                } else {
                    this.a.put(view, Boolean.TRUE);
                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                        this.a.put((View) parent, Boolean.TRUE);
                    }
                }
            }
        }
    }

    boolean b(View view, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            g();
        }
        View viewC = c(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                d().put(keyCode, new WeakReference<>(viewC));
            }
        }
        return viewC != null;
    }

    boolean f(KeyEvent keyEvent) {
        int iIndexOfKey;
        WeakReference<KeyEvent> weakReference = this.c;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        this.c = new WeakReference<>(keyEvent);
        WeakReference<View> weakReferenceValueAt = null;
        SparseArray<WeakReference<View>> sparseArrayD = d();
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
            sparseArrayD.removeAt(iIndexOfKey);
        }
        if (weakReferenceValueAt == null) {
            weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
        }
        if (weakReferenceValueAt == null) {
            return false;
        }
        View view = weakReferenceValueAt.get();
        if (view != null && s0.J(view)) {
            e(view, keyEvent);
        }
        return true;
    }
}
