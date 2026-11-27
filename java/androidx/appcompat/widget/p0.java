package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class p0 extends ListView {
    private boolean A;
    private h.e.j.z0 C;
    private androidx.core.widget.h D;
    o0 G;
    private final Rect c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f170h;

    /* renamed from: i, reason: collision with root package name */
    private Field f171i;

    /* renamed from: j, reason: collision with root package name */
    private n0 f172j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f173k;
    private boolean t;

    p0(Context context, boolean z) throws NoSuchFieldException {
        super(context, null, h.a.a.A);
        this.c = new Rect();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.t = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f171i = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        this.A = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f170h - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        h.e.j.z0 z0Var = this.C;
        if (z0Var != null) {
            z0Var.b();
            this.C = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.c.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.c);
        selector.draw(canvas);
    }

    private void f(int i2, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.c;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.d;
        rect.top -= this.e;
        rect.right += this.f;
        rect.bottom += this.g;
        try {
            boolean z = this.f171i.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f171i.set(this, Boolean.valueOf(!z));
                if (i2 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void g(int i2, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || i2 == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z) {
            Rect rect = this.c;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.j(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i2, View view, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.j(selector, f, f2);
    }

    private void i(View view, int i2, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.A = true;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.f170h;
        if (i4 != -1 && (childAt = getChildAt(i4 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f170h = i2;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (i3 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f, f2);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z) {
        n0 n0Var = this.f172j;
        if (n0Var != null) {
            n0Var.c(z);
        }
    }

    private boolean k() {
        return this.A;
    }

    private void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        View view = null;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            view.measure(i2, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, WXVideoFileObject.FILE_SIZE_LIMIT) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i5) {
                return (i6 < 0 || i7 <= i6 || i9 <= 0 || measuredHeight == i5) ? i5 : i9;
            }
            if (i6 >= 0 && i7 >= i6) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.G != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(MotionEvent motionEvent, int i2) throws IllegalAccessException, IllegalArgumentException {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z2 = false;
                    z = true;
                } else {
                    z2 = false;
                    z = false;
                }
                if (z || z2) {
                    a();
                }
                if (z) {
                    androidx.core.widget.h hVar = this.D;
                    if (hVar != null) {
                        hVar.m(false);
                    }
                } else {
                    if (this.D == null) {
                        this.D = new androidx.core.widget.h(this);
                    }
                    this.D.m(true);
                    this.D.onTouch(this, motionEvent);
                }
                return z;
            }
            z = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        if (iFindPointerIndex >= 0) {
            int x = (int) motionEvent.getX(iFindPointerIndex);
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x, y);
            if (iPointToPosition == -1) {
                z2 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                i(childAt, iPointToPosition, x, y);
                if (actionMasked == 1) {
                    b(childAt, iPointToPosition);
                }
                z2 = false;
                z = true;
            }
        }
        if (z) {
            a();
        }
        if (z) {
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.t || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.t || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.t || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.t && this.f173k) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.G = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.G == null) {
            o0 o0Var = new o0(this);
            this.G = o0Var;
            o0Var.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f170h = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        o0 o0Var = this.G;
        if (o0Var != null) {
            o0Var.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.f173k = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        n0 n0Var = drawable != null ? new n0(drawable) : null;
        this.f172j = n0Var;
        super.setSelector(n0Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.d = rect.left;
        this.e = rect.top;
        this.f = rect.right;
        this.g = rect.bottom;
    }
}
