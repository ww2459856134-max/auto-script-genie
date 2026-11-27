package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements androidx.core.widget.q, h.e.j.e0 {
    private final n c;
    private final m d;
    private final f0 e;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.d;
        if (mVar != null) {
            mVar.b();
        }
        f0 f0Var = this.e;
        if (f0Var != null) {
            f0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        n nVar = this.c;
        return nVar != null ? nVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // h.e.j.e0
    public ColorStateList getSupportBackgroundTintList() {
        m mVar = this.d;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    @Override // h.e.j.e0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m mVar = this.d;
        if (mVar != null) {
            return mVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m mVar = this.d;
        if (mVar != null) {
            mVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        m mVar = this.d;
        if (mVar != null) {
            mVar.g(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) throws NoSuchFieldException {
        super.setButtonDrawable(drawable);
        n nVar = this.c;
        if (nVar != null) {
            nVar.f();
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m mVar = this.d;
        if (mVar != null) {
            mVar.i(colorStateList);
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m mVar = this.d;
        if (mVar != null) {
            mVar.j(mode);
        }
    }

    @Override // androidx.core.widget.q
    public void setSupportButtonTintList(ColorStateList colorStateList) throws NoSuchFieldException {
        n nVar = this.c;
        if (nVar != null) {
            nVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.q
    public void setSupportButtonTintMode(PorterDuff.Mode mode) throws NoSuchFieldException {
        n nVar = this.c;
        if (nVar != null) {
            nVar.h(mode);
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.s);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(q1.b(context), attributeSet, i2);
        p1.a(this, getContext());
        n nVar = new n(this);
        this.c = nVar;
        nVar.e(attributeSet, i2);
        m mVar = new m(this);
        this.d = mVar;
        mVar.e(attributeSet, i2);
        f0 f0Var = new f0(this);
        this.e = f0Var;
        f0Var.m(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) throws NoSuchFieldException {
        setButtonDrawable(h.a.k.a.b.d(getContext(), i2));
    }
}
