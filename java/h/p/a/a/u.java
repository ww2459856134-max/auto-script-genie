package h.p.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* loaded from: classes.dex */
class u extends Drawable.ConstantState {
    private final Drawable.ConstantState a;

    public u(Drawable.ConstantState constantState) {
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
        v vVar = new v();
        vVar.c = (VectorDrawable) this.a.newDrawable();
        return vVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        v vVar = new v();
        vVar.c = (VectorDrawable) this.a.newDrawable(resources);
        return vVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        v vVar = new v();
        vVar.c = (VectorDrawable) this.a.newDrawable(resources, theme);
        return vVar;
    }
}
