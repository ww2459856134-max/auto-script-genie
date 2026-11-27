package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class p0 implements o0 {
    static final o0 a = new p0();

    p0() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != view) {
                float fQ = h.e.j.s0.q(childAt);
                if (fQ > f) {
                    f = fQ;
                }
            }
        }
        return f;
    }

    @Override // androidx.recyclerview.widget.o0
    public void a(View view) {
    }

    @Override // androidx.recyclerview.widget.o0
    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z) {
            int i3 = h.n.c.a;
            if (view.getTag(i3) == null) {
                Float fValueOf = Float.valueOf(h.e.j.s0.q(view));
                h.e.j.s0.d0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i3, fValueOf);
            }
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    @Override // androidx.recyclerview.widget.o0
    public void c(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i2 = h.n.c.a;
            Object tag = view.getTag(i2);
            if (tag instanceof Float) {
                h.e.j.s0.d0(view, ((Float) tag).floatValue());
            }
            view.setTag(i2, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.o0
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i2, boolean z) {
    }
}
