package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.auto.exceldeps.log4j.util.Chars;
import java.lang.reflect.InvocationTargetException;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> o0 = new a(Float.class, "thumbPos");
    private static final int[] p0 = {R.attr.state_checked};
    private int A;
    private int C;
    private int D;
    private boolean G;
    private CharSequence H;
    private CharSequence I;
    private boolean J;
    private int K;
    private int M;
    private float O;
    private float P;
    private VelocityTracker Q;
    private int U;
    float V;
    private int W;
    private int a0;
    private int b0;
    private Drawable c;
    private int c0;
    private ColorStateList d;
    private int d0;
    private PorterDuff.Mode e;
    private int e0;
    private boolean f;
    private int f0;
    private boolean g;
    private final TextPaint g0;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f131h;
    private ColorStateList h0;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f132i;
    private Layout i0;

    /* renamed from: j, reason: collision with root package name */
    private PorterDuff.Mode f133j;
    private Layout j0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f134k;
    private TransformationMethod k0;
    ObjectAnimator l0;
    private final f0 m0;
    private final Rect n0;
    private boolean t;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.V);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private void a(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, o0, z ? 1.0f : 0.0f);
        this.l0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.l0.setAutoCancel(true);
        }
        this.l0.start();
    }

    private void b() {
        Drawable drawable = this.c;
        if (drawable != null) {
            if (this.f || this.g) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.q(drawable).mutate();
                this.c = drawableMutate;
                if (this.f) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.d);
                }
                if (this.g) {
                    androidx.core.graphics.drawable.a.o(this.c, this.e);
                }
                if (this.c.isStateful()) {
                    this.c.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f131h;
        if (drawable != null) {
            if (this.f134k || this.t) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.q(drawable).mutate();
                this.f131h = drawableMutate;
                if (this.f134k) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f132i);
                }
                if (this.t) {
                    androidx.core.graphics.drawable.a.o(this.f131h, this.f133j);
                }
                if (this.f131h.isStateful()) {
                    this.f131h.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.l0;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float f(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private boolean g(float f, float f2) {
        if (this.c == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.c.getPadding(this.n0);
        int i2 = this.d0;
        int i3 = this.M;
        int i4 = i2 - i3;
        int i5 = (this.c0 + thumbOffset) - i3;
        int i6 = this.b0 + i5;
        Rect rect = this.n0;
        return f > ((float) i5) && f < ((float) (((i6 + rect.left) + rect.right) + i3)) && f2 > ((float) i4) && f2 < ((float) (this.f0 + i3));
    }

    private boolean getTargetCheckedState() {
        return this.V > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((e2.b(this) ? 1.0f - this.V : this.V) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f131h;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.n0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.c;
        Rect rectD = drawable2 != null ? m0.d(drawable2) : m0.c;
        return ((((this.W - this.b0) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.k0;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.g0, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void i() throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.I;
            if (string == null) {
                string = getResources().getString(h.a.h.d);
            }
            h.e.j.s0.i0(this, string);
        }
    }

    private void j() throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.H;
            if (string == null) {
                string = getResources().getString(h.a.h.e);
            }
            h.e.j.s0.i0(this, string);
        }
    }

    private void k(int i2, int i3) {
        setSwitchTypeface(i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i3);
    }

    private void l(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.K = 0;
        boolean targetCheckedState = true;
        boolean z = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z) {
            this.Q.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE);
            float xVelocity = this.Q.getXVelocity();
            if (Math.abs(xVelocity) <= this.U) {
                targetCheckedState = getTargetCheckedState();
            } else if (!e2.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.n0;
        int i4 = this.c0;
        int i5 = this.d0;
        int i6 = this.e0;
        int i7 = this.f0;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.c;
        Rect rectD = drawable != null ? m0.d(drawable) : m0.c;
        Drawable drawable2 = this.f131h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (rectD != null) {
                int i9 = rectD.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rectD.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rectD.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rectD.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                }
                this.f131h.setBounds(i4, i2, i6, i3);
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f131h.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.b0 + rect.right;
            this.c.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.k(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, f, f2);
        }
        Drawable drawable2 = this.f131h;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.j(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.c;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f131h;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!e2.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.W;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.D : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (e2.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.W;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.D : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.J;
    }

    public boolean getSplitTrack() {
        return this.G;
    }

    public int getSwitchMinWidth() {
        return this.C;
    }

    public int getSwitchPadding() {
        return this.D;
    }

    public CharSequence getTextOff() {
        return this.I;
    }

    public CharSequence getTextOn() {
        return this.H;
    }

    public Drawable getThumbDrawable() {
        return this.c;
    }

    public int getThumbTextPadding() {
        return this.A;
    }

    public ColorStateList getThumbTintList() {
        return this.d;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.e;
    }

    public Drawable getTrackDrawable() {
        return this.f131h;
    }

    public ColorStateList getTrackTintList() {
        return this.f132i;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f133j;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f131h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.l0;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.l0.end();
        this.l0 = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, p0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int width;
        super.onDraw(canvas);
        Rect rect = this.n0;
        Drawable drawable = this.f131h;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.d0;
        int i3 = this.f0;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.c;
        if (drawable != null) {
            if (!this.G || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = m0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.i0 : this.j0;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.h0;
            if (colorStateList != null) {
                this.g0.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.g0.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.H : this.I;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(Chars.SPACE);
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iMax;
        int width;
        int paddingLeft;
        int i6;
        int paddingTop;
        int height;
        super.onLayout(z, i2, i3, i4, i5);
        int iMax2 = 0;
        if (this.c != null) {
            Rect rect = this.n0;
            Drawable drawable = this.f131h;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = m0.d(this.c);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (e2.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.W + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.W) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i6 = this.a0;
            paddingTop = paddingTop2 - (i6 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.a0;
                this.c0 = paddingLeft;
                this.d0 = paddingTop;
                this.f0 = height;
                this.e0 = width;
            }
            paddingTop = getPaddingTop();
            i6 = this.a0;
        }
        height = i6 + paddingTop;
        this.c0 = paddingLeft;
        this.d0 = paddingTop;
        this.f0 = height;
        this.e0 = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.J) {
            if (this.i0 == null) {
                this.i0 = h(this.H);
            }
            if (this.j0 == null) {
                this.j0 = h(this.I);
            }
        }
        Rect rect = this.n0;
        Drawable drawable = this.c;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.c.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.c.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.b0 = Math.max(this.J ? Math.max(this.i0.getWidth(), this.j0.getWidth()) + (this.A * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f131h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f131h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            Rect rectD = m0.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = Math.max(this.C, (this.b0 * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.W = iMax3;
        this.a0 = iMax4;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.H : this.I;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (isEnabled() && g(x, y)) {
                this.K = 1;
                this.O = x;
                this.P = y;
            }
        } else if (actionMasked == 1) {
            if (this.K == 2) {
                l(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.K = 0;
            this.Q.clear();
        } else if (actionMasked == 2) {
            int i2 = this.K;
            if (i2 == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (Math.abs(x2 - this.O) > this.M || Math.abs(y2 - this.P) > this.M) {
                    this.K = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.O = x2;
                    this.P = y2;
                    return true;
                }
            } else if (i2 == 2) {
                float x3 = motionEvent.getX();
                int thumbScrollRange = getThumbScrollRange();
                float f = x3 - this.O;
                float f2 = thumbScrollRange != 0 ? f / thumbScrollRange : f > 0.0f ? 1.0f : -1.0f;
                if (e2.b(this)) {
                    f2 = -f2;
                }
                float f3 = f(this.V + f2, 0.0f, 1.0f);
                if (f3 != this.V) {
                    this.O = x3;
                    setThumbPosition(f3);
                }
                return true;
            }
        } else if (actionMasked == 3) {
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) throws Resources.NotFoundException {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            j();
        } else {
            i();
        }
        if (getWindowToken() != null && h.e.j.s0.K(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.n(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.J != z) {
            this.J = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.G = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.C = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.D = i2;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i2) {
        t1 t1VarS = t1.s(context, i2, h.a.j.J2);
        ColorStateList colorStateListC = t1VarS.c(h.a.j.N2);
        if (colorStateListC != null) {
            this.h0 = colorStateListC;
        } else {
            this.h0 = getTextColors();
        }
        int iE = t1VarS.e(h.a.j.K2, 0);
        if (iE != 0) {
            float f = iE;
            if (f != this.g0.getTextSize()) {
                this.g0.setTextSize(f);
                requestLayout();
            }
        }
        k(t1VarS.j(h.a.j.L2, -1), t1VarS.j(h.a.j.M2, -1));
        if (t1VarS.a(h.a.j.U2, false)) {
            this.k0 = new h.a.n.a(getContext());
        } else {
            this.k0 = null;
        }
        t1VarS.v();
    }

    public void setSwitchTypeface(Typeface typeface, int i2) {
        if (i2 <= 0) {
            this.g0.setFakeBoldText(false);
            this.g0.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i3 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i2;
            this.g0.setFakeBoldText((i3 & 1) != 0);
            this.g0.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        this.I = charSequence;
        requestLayout();
        if (isChecked()) {
            return;
        }
        i();
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        this.H = charSequence;
        requestLayout();
        if (isChecked()) {
            j();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f) {
        this.V = f;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(h.a.k.a.b.d(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.A = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.d = colorStateList;
        this.f = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.e = mode;
        this.g = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f131h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f131h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(h.a.k.a.b.d(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f132i = colorStateList;
        this.f134k = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f133j = mode;
        this.t = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.c || drawable == this.f131h;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.L);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i2);
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.f132i = null;
        this.f133j = null;
        this.f134k = false;
        this.t = false;
        this.Q = VelocityTracker.obtain();
        this.n0 = new Rect();
        p1.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.g0 = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = h.a.j.u2;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        h.e.j.s0.X(this, context, iArr, attributeSet, t1VarU.q(), i2, 0);
        Drawable drawableF = t1VarU.f(h.a.j.x2);
        this.c = drawableF;
        if (drawableF != null) {
            drawableF.setCallback(this);
        }
        Drawable drawableF2 = t1VarU.f(h.a.j.G2);
        this.f131h = drawableF2;
        if (drawableF2 != null) {
            drawableF2.setCallback(this);
        }
        this.H = t1VarU.o(h.a.j.v2);
        this.I = t1VarU.o(h.a.j.w2);
        this.J = t1VarU.a(h.a.j.y2, true);
        this.A = t1VarU.e(h.a.j.D2, 0);
        this.C = t1VarU.e(h.a.j.A2, 0);
        this.D = t1VarU.e(h.a.j.B2, 0);
        this.G = t1VarU.a(h.a.j.z2, false);
        ColorStateList colorStateListC = t1VarU.c(h.a.j.E2);
        if (colorStateListC != null) {
            this.d = colorStateListC;
            this.f = true;
        }
        PorterDuff.Mode modeE = m0.e(t1VarU.j(h.a.j.F2, -1), null);
        if (this.e != modeE) {
            this.e = modeE;
            this.g = true;
        }
        if (this.f || this.g) {
            b();
        }
        ColorStateList colorStateListC2 = t1VarU.c(h.a.j.H2);
        if (colorStateListC2 != null) {
            this.f132i = colorStateListC2;
            this.f134k = true;
        }
        PorterDuff.Mode modeE2 = m0.e(t1VarU.j(h.a.j.I2, -1), null);
        if (this.f133j != modeE2) {
            this.f133j = modeE2;
            this.t = true;
        }
        if (this.f134k || this.t) {
            c();
        }
        int iM = t1VarU.m(h.a.j.C2, 0);
        if (iM != 0) {
            setSwitchTextAppearance(context, iM);
        }
        f0 f0Var = new f0(this);
        this.m0 = f0Var;
        f0Var.m(attributeSet, i2);
        t1VarU.v();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.M = viewConfiguration.getScaledTouchSlop();
        this.U = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.g0.getTypeface() == null || this.g0.getTypeface().equals(typeface)) && (this.g0.getTypeface() != null || typeface == null)) {
            return;
        }
        this.g0.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
