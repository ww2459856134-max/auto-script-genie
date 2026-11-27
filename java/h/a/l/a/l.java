package h.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
abstract class l extends Drawable.ConstantState {
    int A;
    int B;
    boolean C;
    ColorFilter D;
    boolean E;
    ColorStateList F;
    PorterDuff.Mode G;
    boolean H;
    boolean I;
    final m a;
    Resources b;
    int c;
    int d;
    int e;
    SparseArray<Drawable.ConstantState> f;
    Drawable[] g;

    /* renamed from: h, reason: collision with root package name */
    int f1233h;

    /* renamed from: i, reason: collision with root package name */
    boolean f1234i;

    /* renamed from: j, reason: collision with root package name */
    boolean f1235j;

    /* renamed from: k, reason: collision with root package name */
    Rect f1236k;

    /* renamed from: l, reason: collision with root package name */
    boolean f1237l;

    /* renamed from: m, reason: collision with root package name */
    boolean f1238m;

    /* renamed from: n, reason: collision with root package name */
    int f1239n;

    /* renamed from: o, reason: collision with root package name */
    int f1240o;
    int p;
    int q;
    boolean r;
    int s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    int z;

    l(l lVar, m mVar, Resources resources) {
        this.f1234i = false;
        this.f1237l = false;
        this.x = true;
        this.A = 0;
        this.B = 0;
        this.a = mVar;
        this.b = resources != null ? resources : lVar != null ? lVar.b : null;
        int iF = m.f(resources, lVar != null ? lVar.c : 0);
        this.c = iF;
        if (lVar == null) {
            this.g = new Drawable[10];
            this.f1233h = 0;
            return;
        }
        this.d = lVar.d;
        this.e = lVar.e;
        this.v = true;
        this.w = true;
        this.f1234i = lVar.f1234i;
        this.f1237l = lVar.f1237l;
        this.x = lVar.x;
        this.y = lVar.y;
        this.z = lVar.z;
        this.A = lVar.A;
        this.B = lVar.B;
        this.C = lVar.C;
        this.D = lVar.D;
        this.E = lVar.E;
        this.F = lVar.F;
        this.G = lVar.G;
        this.H = lVar.H;
        this.I = lVar.I;
        if (lVar.c == iF) {
            if (lVar.f1235j) {
                this.f1236k = lVar.f1236k != null ? new Rect(lVar.f1236k) : null;
                this.f1235j = true;
            }
            if (lVar.f1238m) {
                this.f1239n = lVar.f1239n;
                this.f1240o = lVar.f1240o;
                this.p = lVar.p;
                this.q = lVar.q;
                this.f1238m = true;
            }
        }
        if (lVar.r) {
            this.s = lVar.s;
            this.r = true;
        }
        if (lVar.t) {
            this.u = lVar.u;
            this.t = true;
        }
        Drawable[] drawableArr = lVar.g;
        this.g = new Drawable[drawableArr.length];
        this.f1233h = lVar.f1233h;
        SparseArray<Drawable.ConstantState> sparseArray = lVar.f;
        if (sparseArray != null) {
            this.f = sparseArray.clone();
        } else {
            this.f = new SparseArray<>(this.f1233h);
        }
        int i2 = this.f1233h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (drawableArr[i3] != null) {
                Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                if (constantState != null) {
                    this.f.put(i3, constantState);
                } else {
                    this.g[i3] = drawableArr[i3];
                }
            }
        }
    }

    private void e() {
        SparseArray<Drawable.ConstantState> sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.g[this.f.keyAt(i2)] = s(this.f.valueAt(i2).newDrawable(this.b));
            }
            this.f = null;
        }
    }

    private Drawable s(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.core.graphics.drawable.a.l(drawable, this.z);
        }
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setCallback(this.a);
        return drawableMutate;
    }

    public final int a(Drawable drawable) {
        int i2 = this.f1233h;
        if (i2 >= this.g.length) {
            o(i2, i2 + 10);
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.a);
        this.g[i2] = drawable;
        this.f1233h++;
        this.e = drawable.getChangingConfigurations() | this.e;
        p();
        this.f1236k = null;
        this.f1235j = false;
        this.f1238m = false;
        this.v = false;
        return i2;
    }

    final void b(Resources.Theme theme) {
        if (theme != null) {
            e();
            int i2 = this.f1233h;
            Drawable[] drawableArr = this.g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && androidx.core.graphics.drawable.a.b(drawableArr[i3])) {
                    androidx.core.graphics.drawable.a.a(drawableArr[i3], theme);
                    this.e |= drawableArr[i3].getChangingConfigurations();
                }
            }
            y(j.c(theme));
        }
    }

    public boolean c() {
        if (this.v) {
            return this.w;
        }
        e();
        this.v = true;
        int i2 = this.f1233h;
        Drawable[] drawableArr = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            if (drawableArr[i3].getConstantState() == null) {
                this.w = false;
                return false;
            }
        }
        this.w = true;
        return true;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        int i2 = this.f1233h;
        Drawable[] drawableArr = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            Drawable drawable = drawableArr[i3];
            if (drawable == null) {
                Drawable.ConstantState constantState = this.f.get(i3);
                if (constantState != null && j.a(constantState)) {
                    return true;
                }
            } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                return true;
            }
        }
        return false;
    }

    protected void d() {
        this.f1238m = true;
        e();
        int i2 = this.f1233h;
        Drawable[] drawableArr = this.g;
        this.f1240o = -1;
        this.f1239n = -1;
        this.q = 0;
        this.p = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            Drawable drawable = drawableArr[i3];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f1239n) {
                this.f1239n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f1240o) {
                this.f1240o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.p) {
                this.p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.q) {
                this.q = minimumHeight;
            }
        }
    }

    final int f() {
        return this.g.length;
    }

    public final Drawable g(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iIndexOfKey;
        Drawable drawable = this.g[i2];
        if (drawable != null) {
            return drawable;
        }
        SparseArray<Drawable.ConstantState> sparseArray = this.f;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i2)) < 0) {
            return null;
        }
        Drawable drawableS = s(this.f.valueAt(iIndexOfKey).newDrawable(this.b));
        this.g[i2] = drawableS;
        this.f.removeAt(iIndexOfKey);
        if (this.f.size() == 0) {
            this.f = null;
        }
        return drawableS;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.d | this.e;
    }

    public final int h() {
        return this.f1233h;
    }

    public final int i() {
        if (!this.f1238m) {
            d();
        }
        return this.f1240o;
    }

    public final int j() {
        if (!this.f1238m) {
            d();
        }
        return this.q;
    }

    public final int k() {
        if (!this.f1238m) {
            d();
        }
        return this.p;
    }

    public final Rect l() {
        Rect rect = null;
        if (this.f1234i) {
            return null;
        }
        Rect rect2 = this.f1236k;
        if (rect2 != null || this.f1235j) {
            return rect2;
        }
        e();
        Rect rect3 = new Rect();
        int i2 = this.f1233h;
        Drawable[] drawableArr = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            if (drawableArr[i3].getPadding(rect3)) {
                if (rect == null) {
                    rect = new Rect(0, 0, 0, 0);
                }
                int i4 = rect3.left;
                if (i4 > rect.left) {
                    rect.left = i4;
                }
                int i5 = rect3.top;
                if (i5 > rect.top) {
                    rect.top = i5;
                }
                int i6 = rect3.right;
                if (i6 > rect.right) {
                    rect.right = i6;
                }
                int i7 = rect3.bottom;
                if (i7 > rect.bottom) {
                    rect.bottom = i7;
                }
            }
        }
        this.f1235j = true;
        this.f1236k = rect;
        return rect;
    }

    public final int m() {
        if (!this.f1238m) {
            d();
        }
        return this.f1239n;
    }

    public final int n() {
        if (this.r) {
            return this.s;
        }
        e();
        int i2 = this.f1233h;
        Drawable[] drawableArr = this.g;
        int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
        for (int i3 = 1; i3 < i2; i3++) {
            opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
        }
        this.s = opacity;
        this.r = true;
        return opacity;
    }

    public void o(int i2, int i3) {
        Drawable[] drawableArr = new Drawable[i3];
        Drawable[] drawableArr2 = this.g;
        if (drawableArr2 != null) {
            System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
        }
        this.g = drawableArr;
    }

    void p() {
        this.r = false;
        this.t = false;
    }

    public final boolean q() {
        return this.f1237l;
    }

    abstract void r();

    public final void t(boolean z) {
        this.f1237l = z;
    }

    public final void u(int i2) {
        this.A = i2;
    }

    public final void v(int i2) {
        this.B = i2;
    }

    final boolean w(int i2, int i3) {
        int i4 = this.f1233h;
        Drawable[] drawableArr = this.g;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            if (drawableArr[i5] != null) {
                boolean zL = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.l(drawableArr[i5], i2) : false;
                if (i5 == i3) {
                    z = zL;
                }
            }
        }
        this.z = i2;
        return z;
    }

    public final void x(boolean z) {
        this.f1234i = z;
    }

    final void y(Resources resources) {
        if (resources != null) {
            this.b = resources;
            int iF = m.f(resources, this.c);
            int i2 = this.c;
            this.c = iF;
            if (i2 != iF) {
                this.f1238m = false;
                this.f1235j = false;
            }
        }
    }
}
