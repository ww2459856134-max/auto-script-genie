package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, c, b {

    /* renamed from: i, reason: collision with root package name */
    static final PorterDuff.Mode f208i = PorterDuff.Mode.SRC_IN;
    private int c;
    private PorterDuff.Mode d;
    private boolean e;
    f f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    Drawable f209h;

    d(f fVar, Resources resources) {
        this.f = fVar;
        e(resources);
    }

    private f d() {
        return new f(this.f);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f;
        if (fVar == null || (constantState = fVar.b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f;
        ColorStateList colorStateList = fVar.c;
        PorterDuff.Mode mode = fVar.d;
        if (colorStateList == null || mode == null) {
            this.e = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.e || colorForState != this.c || mode != this.d) {
                setColorFilter(colorForState, mode);
                this.c = colorForState;
                this.d = mode;
                this.e = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f209h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f209h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f;
            if (fVar != null) {
                fVar.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable b() {
        return this.f209h;
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f209h.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f209h.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f.a = getChangingConfigurations();
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f209h.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f209h.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f209h.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.e(this.f209h);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f209h.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f209h.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f209h.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f209h.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f209h.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f209h.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.g(this.f209h);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f) == null) ? null : fVar.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f209h.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f209h.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.f = d();
            Drawable drawable = this.f209h;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f;
            if (fVar != null) {
                Drawable drawable2 = this.f209h;
                fVar.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f209h;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return a.l(this.f209h, i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        return this.f209h.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f209h.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        a.i(this.f209h, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f209h.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f209h.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f209h.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f209h.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f209h.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f.c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f.d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f209h.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(Drawable drawable) {
        this.f = d();
        a(drawable);
    }
}
