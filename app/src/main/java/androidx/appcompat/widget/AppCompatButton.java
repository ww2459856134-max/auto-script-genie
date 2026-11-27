package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AppCompatButton extends Button implements h.e.j.e0, androidx.core.widget.d, androidx.core.widget.r {
    private final m c;
    private final f0 d;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.c;
        if (mVar != null) {
            mVar.b();
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeMaxTextSize();
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            return f0Var.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeMinTextSize();
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            return f0Var.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeStepGranularity();
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            return f0Var.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        f0 f0Var = this.d;
        return f0Var != null ? f0Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            return f0Var.i();
        }
        return 0;
    }

    @Override // h.e.j.e0
    public ColorStateList getSupportBackgroundTintList() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    @Override // h.e.j.e0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.d.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.d.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.o(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        f0 f0Var = this.d;
        if (f0Var == null || androidx.core.widget.d.a || !f0Var.l()) {
            return;
        }
        this.d.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.t(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.u(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) throws IllegalArgumentException {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.v(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m mVar = this.c;
        if (mVar != null) {
            mVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        m mVar = this.c;
        if (mVar != null) {
            mVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.n(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.s(z);
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.i(colorStateList);
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.j(mode);
        }
    }

    @Override // androidx.core.widget.r
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.d.w(colorStateList);
        this.d.b();
    }

    @Override // androidx.core.widget.r
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.d.x(mode);
        this.d.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (androidx.core.widget.d.a) {
            super.setTextSize(i2, f);
            return;
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.A(i2, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.r);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(q1.b(context), attributeSet, i2);
        p1.a(this, getContext());
        m mVar = new m(this);
        this.c = mVar;
        mVar.e(attributeSet, i2);
        f0 f0Var = new f0(this);
        this.d = f0Var;
        f0Var.m(attributeSet, i2);
        f0Var.b();
    }
}
