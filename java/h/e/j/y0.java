package h.e.j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class y0 implements a1 {
    z0 a;
    boolean b;

    y0(z0 z0Var) {
        this.a = z0Var;
    }

    @Override // h.e.j.a1
    public void a(View view) {
        Object tag = view.getTag(2113929216);
        a1 a1Var = tag instanceof a1 ? (a1) tag : null;
        if (a1Var != null) {
            a1Var.a(view);
        }
    }

    @Override // h.e.j.a1
    @SuppressLint({"WrongConstant"})
    public void b(View view) {
        int i2 = this.a.d;
        if (i2 > -1) {
            view.setLayerType(i2, null);
            this.a.d = -1;
        }
        if (Build.VERSION.SDK_INT >= 16 || !this.b) {
            z0 z0Var = this.a;
            Runnable runnable = z0Var.c;
            if (runnable != null) {
                z0Var.c = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            a1 a1Var = tag instanceof a1 ? (a1) tag : null;
            if (a1Var != null) {
                a1Var.b(view);
            }
            this.b = true;
        }
    }

    @Override // h.e.j.a1
    public void c(View view) {
        this.b = false;
        if (this.a.d > -1) {
            view.setLayerType(2, null);
        }
        z0 z0Var = this.a;
        Runnable runnable = z0Var.b;
        if (runnable != null) {
            z0Var.b = null;
            runnable.run();
        }
        Object tag = view.getTag(2113929216);
        a1 a1Var = tag instanceof a1 ? (a1) tag : null;
        if (a1Var != null) {
            a1Var.c(view);
        }
    }
}
