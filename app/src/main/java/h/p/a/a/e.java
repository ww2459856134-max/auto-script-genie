package h.p.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class e extends Drawable.ConstantState {
    private final Drawable.ConstantState a;

    public e(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        f fVar = new f();
        Drawable drawableNewDrawable = this.a.newDrawable();
        fVar.c = drawableNewDrawable;
        drawableNewDrawable.setCallback(fVar.g);
        return fVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        f fVar = new f();
        Drawable drawableNewDrawable = this.a.newDrawable(resources);
        fVar.c = drawableNewDrawable;
        drawableNewDrawable.setCallback(fVar.g);
        return fVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        f fVar = new f();
        Drawable drawableNewDrawable = this.a.newDrawable(resources, theme);
        fVar.c = drawableNewDrawable;
        drawableNewDrawable.setCallback(fVar.g);
        return fVar;
    }
}
