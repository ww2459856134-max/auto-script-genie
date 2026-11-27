package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b extends ViewGroup {
    protected final a c;
    protected final Context d;
    protected ActionMenuView e;
    protected k f;
    protected int g;

    /* renamed from: h, reason: collision with root package name */
    protected h.e.j.z0 f143h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f144i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f145j;

    b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(h.a.a.a, typedValue, true) || typedValue.resourceId == 0) {
            this.d = context;
        } else {
            this.d = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    protected int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    protected int e(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public h.e.j.z0 f(int i2, long j2) {
        h.e.j.z0 z0Var = this.f143h;
        if (z0Var != null) {
            z0Var.b();
        }
        if (i2 != 0) {
            h.e.j.z0 z0VarB = h.e.j.s0.b(this);
            z0VarB.a(0.0f);
            z0VarB.d(j2);
            a aVar = this.c;
            aVar.d(z0VarB, i2);
            z0VarB.f(aVar);
            return z0VarB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        h.e.j.z0 z0VarB2 = h.e.j.s0.b(this);
        z0VarB2.a(1.0f);
        z0VarB2.d(j2);
        a aVar2 = this.c;
        aVar2.d(z0VarB2, i2);
        z0VarB2.f(aVar2);
        return z0VarB2;
    }

    public int getAnimatedVisibility() {
        return this.f143h != null ? this.c.b : getVisibility();
    }

    public int getContentHeight() {
        return this.g;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, h.a.j.a, h.a.a.c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(h.a.j.f1227j, 0));
        typedArrayObtainStyledAttributes.recycle();
        k kVar = this.f;
        if (kVar != null) {
            kVar.G(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f145j = false;
        }
        if (!this.f145j) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f145j = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f145j = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f144i = false;
        }
        if (!this.f144i) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f144i = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f144i = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            h.e.j.z0 z0Var = this.f143h;
            if (z0Var != null) {
                z0Var.b();
            }
            super.setVisibility(i2);
        }
    }
}
