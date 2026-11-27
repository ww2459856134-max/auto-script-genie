package com.frame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import java.util.Timer;

/* loaded from: classes.dex */
public abstract class p1 {
    public static void a(View view, int i2) {
        InputMethodManager inputMethodManager = (InputMethodManager) v0.g().getSystemService("input_method");
        view.setFocusable(true);
        view.requestFocus();
        view.setFocusableInTouchMode(true);
        new Timer().schedule(new o1(inputMethodManager), i2);
    }

    public static void b(IBinder iBinder) {
        ((InputMethodManager) v0.g().getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 0);
    }

    public static int c(float f) {
        return (int) ((f * v0.g().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void d(Canvas canvas, Paint paint, String str, int i2, int i3) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(str, i2, ((-(fontMetrics.top + fontMetrics.bottom)) / 2.0f) + i3, paint);
    }

    public static CharSequence e(String str) {
        try {
            v0 v0VarG = v0.g();
            return v0VarG.getPackageManager().getPackageInfo(str, 0).applicationInfo.loadLabel(v0VarG.getPackageManager());
        } catch (Exception e) {
            k0.r(e);
            return null;
        }
    }

    public static boolean f() {
        return v0.g().getResources().getConfiguration().orientation == 2;
    }

    public static void g(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) v0.g().getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        inputMethodManager.showSoftInput(view, 2);
    }

    public static int h(float f) {
        return (int) ((f / v0.g().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int i(float f) {
        return (int) ((f / v0.g().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void j(String str) {
        Toast.makeText(v0.g(), str, 0).show();
    }

    public static int k(float f) {
        return (int) ((f * v0.g().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void l(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static void m(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
