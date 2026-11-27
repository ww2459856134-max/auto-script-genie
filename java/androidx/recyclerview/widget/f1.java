package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class f1 {
    static int a(RecyclerView.a0 a0Var, x0 x0Var, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.g0(view) - oVar.g0(view2)) + 1;
        }
        return Math.min(x0Var.n(), x0Var.d(view2) - x0Var.g(view));
    }

    static int b(RecyclerView.a0 a0Var, x0 x0Var, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (a0Var.b() - Math.max(oVar.g0(view), oVar.g0(view2))) - 1) : Math.max(0, Math.min(oVar.g0(view), oVar.g0(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(x0Var.d(view2) - x0Var.g(view)) / (Math.abs(oVar.g0(view) - oVar.g0(view2)) + 1))) + (x0Var.m() - x0Var.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.a0 a0Var, x0 x0Var, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.b();
        }
        return (int) (((x0Var.d(view2) - x0Var.g(view)) / (Math.abs(oVar.g0(view) - oVar.g0(view2)) + 1)) * a0Var.b());
    }
}
