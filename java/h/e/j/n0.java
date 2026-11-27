package h.e.j;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
abstract class n0 {
    static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(h.e.b.f1285n);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    static e1 b(View view, e1 e1Var, Rect rect) {
        WindowInsets windowInsetsQ = e1Var.q();
        if (windowInsetsQ != null) {
            return e1.s(view.computeSystemWindowInsets(windowInsetsQ, rect), view);
        }
        rect.setEmpty();
        return e1Var;
    }

    public static e1 c(View view) {
        return d1.a(view);
    }

    static void d(View view, a0 a0Var) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(h.e.b.f, a0Var);
        }
        if (a0Var == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(h.e.b.f1285n));
        } else {
            view.setOnApplyWindowInsetsListener(new m0(view, a0Var));
        }
    }
}
