package h.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
abstract class m extends Drawable implements Drawable.Callback {
    private long A;
    private k C;
    private l c;
    private Rect d;
    private Drawable e;
    private Drawable f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1241h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1243j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f1244k;
    private long t;
    private int g = 255;

    /* renamed from: i, reason: collision with root package name */
    private int f1242i = -1;

    m() {
    }

    private void d(Drawable drawable) {
        if (this.C == null) {
            this.C = new k();
        }
        k kVar = this.C;
        kVar.b(drawable.getCallback());
        drawable.setCallback(kVar);
        try {
            if (this.c.A <= 0 && this.f1241h) {
                drawable.setAlpha(this.g);
            }
            l lVar = this.c;
            if (lVar.E) {
                drawable.setColorFilter(lVar.D);
            } else {
                if (lVar.H) {
                    androidx.core.graphics.drawable.a.n(drawable, lVar.F);
                }
                l lVar2 = this.c;
                if (lVar2.I) {
                    androidx.core.graphics.drawable.a.o(drawable, lVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.c.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, androidx.core.graphics.drawable.a.e(this));
            }
            if (i2 >= 19) {
                androidx.core.graphics.drawable.a.i(drawable, this.c.C);
            }
            Rect rect = this.d;
            if (i2 >= 21 && rect != null) {
                androidx.core.graphics.drawable.a.k(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.C.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.f1241h = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            long j2 = this.t;
            if (j2 != 0) {
                if (j2 <= jUptimeMillis) {
                    drawable2.setAlpha(this.g);
                    this.t = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j2 - jUptimeMillis) * 255)) / this.c.A)) * this.g) / 255);
                    z2 = true;
                }
            }
            drawable = this.f;
            if (drawable == null) {
                long j3 = this.A;
                if (j3 != 0) {
                    if (j3 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f = null;
                        this.A = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j3 - jUptimeMillis) * 255)) / this.c.B) * this.g) / 255);
                    }
                }
                if (z && z3) {
                    scheduleSelf(this.f1244k, jUptimeMillis + 16);
                    return;
                }
                return;
            }
            this.A = 0L;
            z3 = z2;
            if (z) {
                return;
            } else {
                return;
            }
        }
        this.t = 0L;
        z2 = false;
        drawable = this.f;
        if (drawable == null) {
        }
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.c.b(theme);
    }

    abstract l b();

    int c() {
        return this.f1242i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.c.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean g(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i2 == this.f1242i) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.c.B > 0) {
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.e;
            if (drawable2 != null) {
                this.f = drawable2;
                this.A = this.c.B + jUptimeMillis;
            } else {
                this.f = null;
                this.A = 0L;
            }
        } else {
            Drawable drawable3 = this.e;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 >= 0) {
            l lVar = this.c;
            if (i2 < lVar.f1233h) {
                Drawable drawableG = lVar.g(i2);
                this.e = drawableG;
                this.f1242i = i2;
                if (drawableG != null) {
                    int i3 = this.c.A;
                    if (i3 > 0) {
                        this.t = jUptimeMillis + i3;
                    }
                    d(drawableG);
                }
            } else {
                this.e = null;
                this.f1242i = -1;
            }
        }
        if (this.t != 0 || this.A != 0) {
            Runnable runnable = this.f1244k;
            if (runnable == null) {
                this.f1244k = new i(this);
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.c.c()) {
            return null;
        }
        this.c.d = getChangingConfigurations();
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.d;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.c.q()) {
            return this.c.i();
        }
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.c.q()) {
            return this.c.m();
        }
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.c.q()) {
            return this.c.j();
        }
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.c.q()) {
            return this.c.k();
        }
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.e;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.c.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.e;
        if (drawable != null) {
            j.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.c.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.e;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    void h(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.c = lVar;
        int i2 = this.f1242i;
        if (i2 >= 0) {
            Drawable drawableG = lVar.g(i2);
            this.e = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f = null;
    }

    final void i(Resources resources) {
        this.c.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        l lVar = this.c;
        if (lVar != null) {
            lVar.p();
        }
        if (drawable != this.e || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.c.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1241h) {
                this.e.setAlpha(this.g);
            }
        }
        if (this.A != 0) {
            this.A = 0L;
            z = true;
        }
        if (this.t != 0) {
            this.t = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.f1243j && super.mutate() == this) {
            l lVarB = b();
            lVarB.r();
            h(lVarB);
            this.f1243j = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.c.w(i2, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable != this.e || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f1241h && this.g == i2) {
            return;
        }
        this.f1241h = true;
        this.g = i2;
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.t == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        l lVar = this.c;
        if (lVar.C != z) {
            lVar.C = z;
            Drawable drawable = this.e;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.i(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        l lVar = this.c;
        lVar.E = true;
        if (lVar.D != colorFilter) {
            lVar.D = colorFilter;
            Drawable drawable = this.e;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        l lVar = this.c;
        if (lVar.x != z) {
            lVar.x = z;
            Drawable drawable = this.e;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.d;
        if (rect == null) {
            this.d = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        l lVar = this.c;
        lVar.H = true;
        if (lVar.F != colorStateList) {
            lVar.F = colorStateList;
            androidx.core.graphics.drawable.a.n(this.e, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        l lVar = this.c;
        lVar.I = true;
        if (lVar.G != mode) {
            lVar.G = mode;
            androidx.core.graphics.drawable.a.o(this.e, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.e || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
