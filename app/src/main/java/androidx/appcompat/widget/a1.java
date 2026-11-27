package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a1 implements androidx.appcompat.view.menu.c0 {
    private static Method f0;
    private static Method g0;
    private static Method h0;
    private boolean A;
    private int C;
    private boolean D;
    private boolean G;
    int H;
    private View I;
    private int J;
    private DataSetObserver K;
    private View M;
    private Drawable O;
    private AdapterView.OnItemClickListener P;
    private AdapterView.OnItemSelectedListener Q;
    final z0 U;
    private final y0 V;
    private final x0 W;
    private final v0 Z;
    final Handler a0;
    private final Rect b0;
    private Context c;
    private Rect c0;
    private ListAdapter d;
    private boolean d0;
    p0 e;
    PopupWindow e0;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f139h;

    /* renamed from: i, reason: collision with root package name */
    private int f140i;

    /* renamed from: j, reason: collision with root package name */
    private int f141j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f142k;
    private boolean t;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f0 = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                h0 = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                g0 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public a1(Context context) {
        this(context, null, h.a.a.E);
    }

    private void I(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            this.e0.setIsClippedToScreen(z);
            return;
        }
        Method method = f0;
        if (method != null) {
            try {
                method.invoke(this.e0, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int p() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        int i3;
        if (this.e == null) {
            Context context = this.c;
            p0 p0VarR = r(context, !this.d0);
            this.e = p0VarR;
            Drawable drawable = this.O;
            if (drawable != null) {
                p0VarR.setSelector(drawable);
            }
            this.e.setAdapter(this.d);
            this.e.setOnItemClickListener(this.P);
            this.e.setFocusable(true);
            this.e.setFocusableInTouchMode(true);
            this.e.setOnItemSelectedListener(new u0(this));
            this.e.setOnScrollListener(this.W);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.Q;
            if (onItemSelectedListener != null) {
                this.e.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.e;
            View view2 = this.I;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.J;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.J);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.g;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.e0.setContentView(view);
        } else {
            View view3 = this.I;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.e0.getBackground();
        if (background != null) {
            background.getPadding(this.b0);
            Rect rect = this.b0;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.f142k) {
                this.f140i = -i6;
            }
        } else {
            this.b0.setEmpty();
            i2 = 0;
        }
        int iT = t(s(), this.f140i, this.e0.getInputMethodMode() == 2);
        if (this.D || this.f == -1) {
            return iT + i2;
        }
        int i7 = this.g;
        if (i7 == -2) {
            int i8 = this.c.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.b0;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, WXVideoFileObject.FILE_SIZE_LIMIT);
        } else {
            int i9 = this.c.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.b0;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), WXVideoFileObject.FILE_SIZE_LIMIT);
        }
        int iD = this.e.d(iMakeMeasureSpec, 0, -1, iT - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.e.getPaddingTop() + this.e.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int t(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.e0.getMaxAvailableHeight(view, i2, z);
        }
        Method method = g0;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.e0, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.e0.getMaxAvailableHeight(view, i2);
    }

    private void x() {
        View view = this.I;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.I);
            }
        }
    }

    public void A(int i2) {
        Drawable background = this.e0.getBackground();
        if (background == null) {
            L(i2);
            return;
        }
        background.getPadding(this.b0);
        Rect rect = this.b0;
        this.g = rect.left + rect.right + i2;
    }

    public void B(int i2) {
        this.C = i2;
    }

    public void C(Rect rect) {
        this.c0 = rect != null ? new Rect(rect) : null;
    }

    public void D(int i2) {
        this.e0.setInputMethodMode(i2);
    }

    public void E(boolean z) {
        this.d0 = z;
        this.e0.setFocusable(z);
    }

    public void F(PopupWindow.OnDismissListener onDismissListener) {
        this.e0.setOnDismissListener(onDismissListener);
    }

    public void G(AdapterView.OnItemClickListener onItemClickListener) {
        this.P = onItemClickListener;
    }

    public void H(boolean z) {
        this.A = true;
        this.t = z;
    }

    public void J(int i2) {
        this.J = i2;
    }

    public void K(int i2) {
        p0 p0Var = this.e;
        if (!a() || p0Var == null) {
            return;
        }
        p0Var.setListSelectionHidden(false);
        p0Var.setSelection(i2);
        if (p0Var.getChoiceMode() != 0) {
            p0Var.setItemChecked(i2, true);
        }
    }

    public void L(int i2) {
        this.g = i2;
    }

    @Override // androidx.appcompat.view.menu.c0
    public boolean a() {
        return this.e0.isShowing();
    }

    public void c(int i2) {
        this.f140i = i2;
        this.f142k = true;
    }

    @Override // androidx.appcompat.view.menu.c0
    public void dismiss() {
        this.e0.dismiss();
        x();
        this.e0.setContentView(null);
        this.e = null;
        this.a0.removeCallbacks(this.U);
    }

    public int f() {
        if (this.f142k) {
            return this.f140i;
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.c0
    public void g() {
        int iP = p();
        boolean zV = v();
        androidx.core.widget.k.b(this.e0, this.f141j);
        if (this.e0.isShowing()) {
            if (h.e.j.s0.J(s())) {
                int width = this.g;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = s().getWidth();
                }
                int i2 = this.f;
                if (i2 == -1) {
                    if (!zV) {
                        iP = -1;
                    }
                    if (zV) {
                        this.e0.setWidth(this.g == -1 ? -1 : 0);
                        this.e0.setHeight(0);
                    } else {
                        this.e0.setWidth(this.g == -1 ? -1 : 0);
                        this.e0.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iP = i2;
                }
                this.e0.setOutsideTouchable((this.G || this.D) ? false : true);
                this.e0.update(s(), this.f139h, this.f140i, width < 0 ? -1 : width, iP < 0 ? -1 : iP);
                return;
            }
            return;
        }
        int width2 = this.g;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = s().getWidth();
        }
        int i3 = this.f;
        if (i3 == -1) {
            iP = -1;
        } else if (i3 != -2) {
            iP = i3;
        }
        this.e0.setWidth(width2);
        this.e0.setHeight(iP);
        I(true);
        this.e0.setOutsideTouchable((this.G || this.D) ? false : true);
        this.e0.setTouchInterceptor(this.V);
        if (this.A) {
            androidx.core.widget.k.a(this.e0, this.t);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = h0;
            if (method != null) {
                try {
                    method.invoke(this.e0, this.c0);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            this.e0.setEpicenterBounds(this.c0);
        }
        androidx.core.widget.k.c(this.e0, s(), this.f139h, this.f140i, this.C);
        this.e.setSelection(-1);
        if (!this.d0 || this.e.isInTouchMode()) {
            q();
        }
        if (this.d0) {
            return;
        }
        this.a0.post(this.Z);
    }

    public Drawable getBackground() {
        return this.e0.getBackground();
    }

    @Override // androidx.appcompat.view.menu.c0
    public ListView i() {
        return this.e;
    }

    public int j() {
        return this.f139h;
    }

    public void k(int i2) {
        this.f139h = i2;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.K;
        if (dataSetObserver == null) {
            this.K = new w0(this);
        } else {
            ListAdapter listAdapter2 = this.d;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.d = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.K);
        }
        p0 p0Var = this.e;
        if (p0Var != null) {
            p0Var.setAdapter(this.d);
        }
    }

    public void o(Drawable drawable) {
        this.e0.setBackgroundDrawable(drawable);
    }

    public void q() {
        p0 p0Var = this.e;
        if (p0Var != null) {
            p0Var.setListSelectionHidden(true);
            p0Var.requestLayout();
        }
    }

    p0 r(Context context, boolean z) {
        return new p0(context, z);
    }

    public View s() {
        return this.M;
    }

    public int u() {
        return this.g;
    }

    public boolean v() {
        return this.e0.getInputMethodMode() == 2;
    }

    public boolean w() {
        return this.d0;
    }

    public void y(View view) {
        this.M = view;
    }

    public void z(int i2) {
        this.e0.setAnimationStyle(i2);
    }

    public a1(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public a1(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f = -2;
        this.g = -2;
        this.f141j = 1002;
        this.C = 0;
        this.D = false;
        this.G = false;
        this.H = Integer.MAX_VALUE;
        this.J = 0;
        this.U = new z0(this);
        this.V = new y0(this);
        this.W = new x0(this);
        this.Z = new v0(this);
        this.b0 = new Rect();
        this.c = context;
        this.a0 = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a.j.d1, i2, i3);
        this.f139h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(h.a.j.e1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(h.a.j.f1, 0);
        this.f140i = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f142k = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i2, i3);
        this.e0 = sVar;
        sVar.setInputMethodMode(1);
    }
}
