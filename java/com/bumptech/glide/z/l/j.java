package com.bumptech.glide.z.l;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.b0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class j {
    static Integer e;
    private final View a;
    private final List<g> b = new ArrayList();
    boolean c;
    private i d;

    j(View view) {
        this.a = view;
    }

    private static int c(Context context) {
        if (e == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            n.d(windowManager);
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            e = Integer.valueOf(Math.max(point.x, point.y));
        }
        return e.intValue();
    }

    private int e(int i2, int i3, int i4) {
        int i5 = i3 - i4;
        if (i5 > 0) {
            return i5;
        }
        if (this.c && this.a.isLayoutRequested()) {
            return 0;
        }
        int i6 = i2 - i4;
        if (i6 > 0) {
            return i6;
        }
        if (this.a.isLayoutRequested() || i3 != -2) {
            return 0;
        }
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        return c(this.a.getContext());
    }

    private int f() {
        int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        return e(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
    }

    private int g() {
        int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        return e(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
    }

    private boolean h(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    private boolean i(int i2, int i3) {
        return h(i2) && h(i3);
    }

    private void j(int i2, int i3) {
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((g) it.next()).e(i2, i3);
        }
    }

    void a() {
        if (this.b.isEmpty()) {
            return;
        }
        int iG = g();
        int iF = f();
        if (i(iG, iF)) {
            j(iG, iF);
            b();
        }
    }

    void b() {
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.d);
        }
        this.d = null;
        this.b.clear();
    }

    void d(g gVar) {
        int iG = g();
        int iF = f();
        if (i(iG, iF)) {
            gVar.e(iG, iF);
            return;
        }
        if (!this.b.contains(gVar)) {
            this.b.add(gVar);
        }
        if (this.d == null) {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            i iVar = new i(this);
            this.d = iVar;
            viewTreeObserver.addOnPreDrawListener(iVar);
        }
    }

    void k(g gVar) {
        this.b.remove(gVar);
    }
}
