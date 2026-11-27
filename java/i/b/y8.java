package i.b;

import android.view.View;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class y8 {
    private View a;
    public boolean b;

    public void a(View view, View view2, Runnable runnable) {
        this.a = view;
        view2.setOnTouchListener(new x8(this, runnable));
    }

    public void b(View view, View view2, Runnable runnable) {
        this.a = view;
        view2.setOnTouchListener(new w8(this, runnable));
    }

    public void c(int i2, int i3) {
        try {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.a.getLayoutParams();
            int i4 = i2 - layoutParams.x;
            int i5 = i3 - layoutParams.y;
            int iC = com.frame.p1.c(80.0f);
            int iC2 = com.frame.p1.c(50.0f);
            com.frame.s0.g().H(this.a, layoutParams.x, layoutParams.y, i4 < iC ? iC : i4, i5 < iC2 ? iC2 : i5);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void d(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        try {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.a.getLayoutParams();
            int i7 = (layoutParams.x + layoutParams.width) - i2;
            int i8 = (layoutParams.y + layoutParams.height) - i3;
            int iC = com.frame.p1.c(80.0f);
            int iC2 = com.frame.p1.c(50.0f);
            if (i7 < iC) {
                i2 = layoutParams.x;
                i4 = iC;
            } else {
                i4 = i7;
            }
            if (i8 < iC2) {
                i5 = layoutParams.y;
                i6 = iC2;
            } else {
                i5 = i3;
                i6 = i8;
            }
            com.frame.s0.g().H(this.a, i2, i5, i4, i6);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }
}
