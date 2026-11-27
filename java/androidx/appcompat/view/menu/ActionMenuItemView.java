package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.a0;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.y1;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements a0.a, View.OnClickListener, ActionMenuView.a {
    b A;
    private boolean C;
    private boolean D;
    private int G;
    private int H;
    private int I;

    /* renamed from: h, reason: collision with root package name */
    p f46h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f47i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f48j;

    /* renamed from: k, reason: collision with root package name */
    m.b f49k;
    private t0 t;

    private class a extends t0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.t0
        public c0 b() {
            b bVar = ActionMenuItemView.this.A;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.t0
        protected boolean c() {
            c0 c0VarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            m.b bVar = actionMenuItemView.f49k;
            return bVar != null && bVar.d(actionMenuItemView.f46h) && (c0VarB = b()) != null && c0VarB.a();
        }
    }

    public static abstract class b {
        public abstract c0 a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f47i);
        if (this.f48j != null && (!this.f46h.B() || (!this.C && !this.D))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f47i : null);
        CharSequence contentDescription = this.f46h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f46h.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f46h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            y1.a(this, z3 ? null : this.f46h.getTitle());
        } else {
            y1.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f46h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.a0.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.a0.a
    public void d(p pVar, int i2) {
        this.f46h = pVar;
        setIcon(pVar.getIcon());
        setTitle(pVar.i(this));
        setId(pVar.getItemId());
        setVisibility(pVar.isVisible() ? 0 : 8);
        setEnabled(pVar.isEnabled());
        if (pVar.hasSubMenu() && this.t == null) {
            this.t = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.a0.a
    public p getItemData() {
        return this.f46h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m.b bVar = this.f49k;
        if (bVar != null) {
            bVar.d(this.f46h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.C = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        boolean zF = f();
        if (zF && (i4 = this.H) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.G) : this.G;
        if (mode != 1073741824 && this.G > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, WXVideoFileObject.FILE_SIZE_LIMIT), i3);
        }
        if (zF || this.f48j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f48j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        t0 t0Var;
        if (this.f46h.hasSubMenu() && (t0Var = this.t) != null && t0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.D != z) {
            this.D = z;
            p pVar = this.f46h;
            if (pVar != null) {
                pVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f48j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.I;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(m.b bVar) {
        this.f49k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.H = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.A = bVar;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f47i = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.C = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a.j.v, i2, 0);
        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.a.j.w, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.I = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.H = -1;
        setSaveEnabled(false);
    }
}
