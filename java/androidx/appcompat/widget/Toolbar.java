package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.z;
import androidx.appcompat.widget.ActionMenuView;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private int C;
    private int D;
    int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int M;
    private l1 O;
    private int P;
    private int Q;
    private int U;
    private CharSequence V;
    private CharSequence W;
    private ColorStateList a0;
    private ColorStateList b0;
    private ActionMenuView c;
    private boolean c0;
    private TextView d;
    private boolean d0;
    private TextView e;
    private final ArrayList<View> e0;
    private ImageButton f;
    private final ArrayList<View> f0;
    private ImageView g;
    private final int[] g0;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f135h;
    f h0;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f136i;
    private final ActionMenuView.e i0;

    /* renamed from: j, reason: collision with root package name */
    ImageButton f137j;
    private x1 j0;

    /* renamed from: k, reason: collision with root package name */
    View f138k;
    private k k0;
    private d l0;
    private z.a m0;
    private m.a n0;
    private boolean o0;
    private final Runnable p0;
    private Context t;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.h0;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.J();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements androidx.appcompat.view.menu.z {
        androidx.appcompat.view.menu.m c;
        androidx.appcompat.view.menu.p d;

        d() {
        }

        @Override // androidx.appcompat.view.menu.z
        public void b(androidx.appcompat.view.menu.m mVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.z
        public boolean c(androidx.appcompat.view.menu.m mVar, androidx.appcompat.view.menu.p pVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f137j.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f137j);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f137j);
            }
            Toolbar.this.f138k = pVar.getActionView();
            this.d = pVar;
            ViewParent parent2 = Toolbar.this.f138k.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f138k);
                }
                e eVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                eVarGenerateDefaultLayoutParams.a = 8388611 | (toolbar4.G & 112);
                eVarGenerateDefaultLayoutParams.b = 2;
                toolbar4.f138k.setLayoutParams(eVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f138k);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            pVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f138k;
            if (callback instanceof h.a.o.d) {
                ((h.a.o.d) callback).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.z
        public void d(boolean z) {
            if (this.d != null) {
                androidx.appcompat.view.menu.m mVar = this.c;
                boolean z2 = false;
                if (mVar != null) {
                    int size = mVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        if (this.c.getItem(i2) == this.d) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z2) {
                    return;
                }
                f(this.c, this.d);
            }
        }

        @Override // androidx.appcompat.view.menu.z
        public boolean e() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.z
        public boolean f(androidx.appcompat.view.menu.m mVar, androidx.appcompat.view.menu.p pVar) {
            KeyEvent.Callback callback = Toolbar.this.f138k;
            if (callback instanceof h.a.o.d) {
                ((h.a.o.d) callback).b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f138k);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f137j);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f138k = null;
            toolbar3.a();
            this.d = null;
            Toolbar.this.requestLayout();
            pVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.z
        public void h(Context context, androidx.appcompat.view.menu.m mVar) {
            androidx.appcompat.view.menu.p pVar;
            androidx.appcompat.view.menu.m mVar2 = this.c;
            if (mVar2 != null && (pVar = this.d) != null) {
                mVar2.f(pVar);
            }
            this.c = mVar;
        }

        @Override // androidx.appcompat.view.menu.z
        public boolean k(androidx.appcompat.view.menu.g0 g0Var) {
            return false;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private int B(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void E(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, WXVideoFileObject.FILE_SIZE_LIMIT);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.p0);
        post(this.p0);
    }

    private boolean H() {
        if (!this.o0) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (I(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean I(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z = h.e.j.s0.w(this) == 1;
        int childCount = getChildCount();
        int iA = h.e.j.n.a(i2, h.e.j.s0.w(this));
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b == 0 && I(childAt) && p(eVar.a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.b == 0 && I(childAt2) && p(eVar2.a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e eVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        eVarGenerateDefaultLayoutParams.b = 1;
        if (!z || this.f138k == null) {
            addView(view, eVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f0.add(view);
        }
    }

    private MenuInflater getMenuInflater() {
        return new h.a.o.k(getContext());
    }

    private void h() {
        if (this.O == null) {
            this.O = new l1();
        }
    }

    private void i() {
        if (this.g == null) {
            this.g = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.c.L() == null) {
            androidx.appcompat.view.menu.m mVar = (androidx.appcompat.view.menu.m) this.c.getMenu();
            if (this.l0 == null) {
                this.l0 = new d();
            }
            this.c.setExpandedActionViewsExclusive(true);
            mVar.c(this.l0, this.t);
        }
    }

    private void k() {
        if (this.c == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.c = actionMenuView;
            actionMenuView.setPopupTheme(this.A);
            this.c.setOnMenuItemClickListener(this.i0);
            this.c.setMenuCallbacks(this.m0, this.n0);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.a = 8388613 | (this.G & 112);
            this.c.setLayoutParams(eVarGenerateDefaultLayoutParams);
            c(this.c, false);
        }
    }

    private void l() {
        if (this.f == null) {
            this.f = new AppCompatImageButton(getContext(), null, h.a.a.N);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.a = 8388611 | (this.G & 112);
            this.f.setLayoutParams(eVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i2) {
        int iW = h.e.j.s0.w(this);
        int iA = h.e.j.n.a(i2, iW) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : iW == 1 ? 5 : 3;
    }

    private int q(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int iR = r(eVar.a);
        if (iR == 48) {
            return getPaddingTop() - i3;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.U & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return h.e.j.r.b(marginLayoutParams) + h.e.j.r.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = list.get(i4);
            e eVar = (e) view.getLayoutParams();
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i2;
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i2 = iMax3;
        }
        return measuredWidth;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.f0.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.c;
        return actionMenuView != null && actionMenuView.H();
    }

    void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).b != 2 && childAt != this.c) {
                removeViewAt(childCount);
                this.f0.add(childAt);
            }
        }
    }

    public boolean J() {
        ActionMenuView actionMenuView = this.c;
        return actionMenuView != null && actionMenuView.M();
    }

    void a() {
        for (int size = this.f0.size() - 1; size >= 0; size--) {
            addView(this.f0.get(size));
        }
        this.f0.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.c) != null && actionMenuView.I();
    }

    public void e() {
        d dVar = this.l0;
        androidx.appcompat.view.menu.p pVar = dVar == null ? null : dVar.d;
        if (pVar != null) {
            pVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null) {
            actionMenuView.z();
        }
    }

    void g() {
        if (this.f137j == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, h.a.a.N);
            this.f137j = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f135h);
            this.f137j.setContentDescription(this.f136i);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.a = 8388611 | (this.G & 112);
            eVarGenerateDefaultLayoutParams.b = 2;
            this.f137j.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f137j.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f137j;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f137j;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        l1 l1Var = this.O;
        if (l1Var != null) {
            return l1Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.Q;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        l1 l1Var = this.O;
        if (l1Var != null) {
            return l1Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        l1 l1Var = this.O;
        if (l1Var != null) {
            return l1Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        l1 l1Var = this.O;
        if (l1Var != null) {
            return l1Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.P;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.m mVarL;
        ActionMenuView actionMenuView = this.c;
        return actionMenuView != null && (mVarL = actionMenuView.L()) != null && mVarL.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.Q, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return h.e.j.s0.w(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return h.e.j.s0.w(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.P, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.g;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.g;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.c.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    k getOuterActionMenuPresenter() {
        return this.k0;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.c.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.t;
    }

    public int getPopupTheme() {
        return this.A;
    }

    public CharSequence getSubtitle() {
        return this.W;
    }

    final TextView getSubtitleTextView() {
        return this.e;
    }

    public CharSequence getTitle() {
        return this.V;
    }

    public int getTitleMarginBottom() {
        return this.M;
    }

    public int getTitleMarginEnd() {
        return this.J;
    }

    public int getTitleMarginStart() {
        return this.I;
    }

    public int getTitleMarginTop() {
        return this.K;
    }

    final TextView getTitleTextView() {
        return this.d;
    }

    public l0 getWrapper() {
        if (this.j0 == null) {
            this.j0 = new x1(this, true);
        }
        return this.j0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0000a ? new e((a.C0000a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.p0);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.d0 = false;
        }
        if (!this.d0) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.d0 = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.d0 = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02a3 A[LOOP:0: B:104:0x02a1->B:105:0x02a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c5 A[LOOP:1: B:107:0x02c3->B:108:0x02c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fe A[LOOP:2: B:116:0x02fc->B:117:0x02fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0229  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) throws NoSuchFieldException {
        int iB;
        int iC;
        int iMax;
        boolean zI;
        boolean zI2;
        int i6;
        int measuredHeight;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int paddingTop;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int size;
        int i18;
        int size2;
        int i19;
        int i20;
        int size3;
        boolean z2 = h.e.j.s0.w(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i21 = width - paddingRight;
        int[] iArr = this.g0;
        iArr[1] = 0;
        iArr[0] = 0;
        int iX = h.e.j.s0.x(this);
        int iMin = iX >= 0 ? Math.min(iX, i5 - i3) : 0;
        if (!I(this.f)) {
            iB = paddingLeft;
        } else {
            if (z2) {
                iC = C(this.f, i21, iArr, iMin);
                iB = paddingLeft;
                if (I(this.f137j)) {
                    if (z2) {
                        iC = C(this.f137j, iC, iArr, iMin);
                    } else {
                        iB = B(this.f137j, iB, iArr, iMin);
                    }
                }
                if (I(this.c)) {
                    if (z2) {
                        iB = B(this.c, iB, iArr, iMin);
                    } else {
                        iC = C(this.c, iC, iArr, iMin);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - iB);
                iArr[1] = Math.max(0, currentContentInsetRight - (i21 - iC));
                iMax = Math.max(iB, currentContentInsetLeft);
                int iMin2 = Math.min(iC, i21 - currentContentInsetRight);
                if (I(this.f138k)) {
                    if (z2) {
                        iMin2 = C(this.f138k, iMin2, iArr, iMin);
                    } else {
                        iMax = B(this.f138k, iMax, iArr, iMin);
                    }
                }
                if (I(this.g)) {
                    if (z2) {
                        iMin2 = C(this.g, iMin2, iArr, iMin);
                    } else {
                        iMax = B(this.g, iMax, iArr, iMin);
                    }
                }
                zI = I(this.d);
                zI2 = I(this.e);
                if (zI) {
                    i6 = paddingRight;
                    measuredHeight = 0;
                } else {
                    e eVar = (e) this.d.getLayoutParams();
                    i6 = paddingRight;
                    measuredHeight = ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + 0;
                }
                if (zI2) {
                    i7 = width;
                } else {
                    e eVar2 = (e) this.e.getLayoutParams();
                    i7 = width;
                    measuredHeight += ((ViewGroup.MarginLayoutParams) eVar2).topMargin + this.e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin;
                }
                if (!zI || zI2) {
                    TextView textView = !zI ? this.d : this.e;
                    TextView textView2 = !zI2 ? this.e : this.d;
                    e eVar3 = (e) textView.getLayoutParams();
                    e eVar4 = (e) textView2.getLayoutParams();
                    boolean z3 = (zI && this.d.getMeasuredWidth() > 0) || (zI2 && this.e.getMeasuredWidth() > 0);
                    i8 = this.U & 112;
                    i9 = paddingLeft;
                    if (i8 == 48) {
                        i10 = iMax;
                        i11 = iMin;
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.K;
                    } else if (i8 != 80) {
                        int iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                        int i22 = ((ViewGroup.MarginLayoutParams) eVar3).topMargin;
                        i11 = iMin;
                        int i23 = this.K;
                        i10 = iMax;
                        if (iMax2 < i22 + i23) {
                            iMax2 = i22 + i23;
                        } else {
                            int i24 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                            int i25 = ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin;
                            int i26 = this.M;
                            if (i24 < i25 + i26) {
                                iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar4).bottomMargin + i26) - i24));
                            }
                        }
                        paddingTop = paddingTop2 + iMax2;
                    } else {
                        i10 = iMax;
                        i11 = iMin;
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin) - this.M) - measuredHeight;
                    }
                    if (!z2) {
                        if (z3) {
                            i13 = this.I;
                            i12 = 0;
                        } else {
                            i12 = 0;
                            i13 = 0;
                        }
                        int i27 = i13 - iArr[i12];
                        iMax = i10 + Math.max(i12, i27);
                        iArr[i12] = Math.max(i12, -i27);
                        if (zI) {
                            e eVar5 = (e) this.d.getLayoutParams();
                            int measuredWidth = this.d.getMeasuredWidth() + iMax;
                            int measuredHeight2 = this.d.getMeasuredHeight() + paddingTop;
                            this.d.layout(iMax, paddingTop, measuredWidth, measuredHeight2);
                            i14 = measuredWidth + this.J;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin;
                        } else {
                            i14 = iMax;
                        }
                        if (zI2) {
                            e eVar6 = (e) this.e.getLayoutParams();
                            int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) eVar6).topMargin;
                            int measuredWidth2 = this.e.getMeasuredWidth() + iMax;
                            this.e.layout(iMax, i28, measuredWidth2, this.e.getMeasuredHeight() + i28);
                            i15 = measuredWidth2 + this.J;
                            int i29 = ((ViewGroup.MarginLayoutParams) eVar6).bottomMargin;
                        } else {
                            i15 = iMax;
                        }
                        if (z3) {
                            iMax = Math.max(i14, i15);
                        }
                        b(this.e0, 3);
                        size = this.e0.size();
                        for (i18 = i12; i18 < size; i18++) {
                            iMax = B(this.e0.get(i18), iMax, iArr, i11);
                        }
                        int i30 = i11;
                        b(this.e0, 5);
                        size2 = this.e0.size();
                        for (i19 = i12; i19 < size2; i19++) {
                            iMin2 = C(this.e0.get(i19), iMin2, iArr, i30);
                        }
                        b(this.e0, 1);
                        int iU = u(this.e0, iArr);
                        i20 = (i9 + (((i7 - i9) - i6) / 2)) - (iU / 2);
                        int i31 = iU + i20;
                        if (i20 >= iMax) {
                            iMax = i31 > iMin2 ? i20 - (i31 - iMin2) : i20;
                        }
                        size3 = this.e0.size();
                        while (i12 < size3) {
                            iMax = B(this.e0.get(i12), iMax, iArr, i30);
                            i12++;
                        }
                        this.e0.clear();
                    }
                    int i32 = (z3 ? this.I : 0) - iArr[1];
                    iMin2 -= Math.max(0, i32);
                    iArr[1] = Math.max(0, -i32);
                    if (zI) {
                        e eVar7 = (e) this.d.getLayoutParams();
                        int measuredWidth3 = iMin2 - this.d.getMeasuredWidth();
                        int measuredHeight3 = this.d.getMeasuredHeight() + paddingTop;
                        this.d.layout(measuredWidth3, paddingTop, iMin2, measuredHeight3);
                        i16 = measuredWidth3 - this.J;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) eVar7).bottomMargin;
                    } else {
                        i16 = iMin2;
                    }
                    if (zI2) {
                        e eVar8 = (e) this.e.getLayoutParams();
                        int i33 = paddingTop + ((ViewGroup.MarginLayoutParams) eVar8).topMargin;
                        this.e.layout(iMin2 - this.e.getMeasuredWidth(), i33, iMin2, this.e.getMeasuredHeight() + i33);
                        i17 = iMin2 - this.J;
                        int i34 = ((ViewGroup.MarginLayoutParams) eVar8).bottomMargin;
                    } else {
                        i17 = iMin2;
                    }
                    if (z3) {
                        iMin2 = Math.min(i16, i17);
                    }
                    iMax = i10;
                } else {
                    i9 = paddingLeft;
                    i11 = iMin;
                }
                i12 = 0;
                b(this.e0, 3);
                size = this.e0.size();
                while (i18 < size) {
                }
                int i302 = i11;
                b(this.e0, 5);
                size2 = this.e0.size();
                while (i19 < size2) {
                }
                b(this.e0, 1);
                int iU2 = u(this.e0, iArr);
                i20 = (i9 + (((i7 - i9) - i6) / 2)) - (iU2 / 2);
                int i312 = iU2 + i20;
                if (i20 >= iMax) {
                }
                size3 = this.e0.size();
                while (i12 < size3) {
                }
                this.e0.clear();
            }
            iB = B(this.f, paddingLeft, iArr, iMin);
        }
        iC = i21;
        if (I(this.f137j)) {
        }
        if (I(this.c)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iB);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i21 - iC));
        iMax = Math.max(iB, currentContentInsetLeft2);
        int iMin22 = Math.min(iC, i21 - currentContentInsetRight2);
        if (I(this.f138k)) {
        }
        if (I(this.g)) {
        }
        zI = I(this.d);
        zI2 = I(this.e);
        if (zI) {
        }
        if (zI2) {
        }
        if (zI) {
            if (!zI) {
            }
            if (!zI2) {
            }
            e eVar32 = (e) textView.getLayoutParams();
            e eVar42 = (e) textView2.getLayoutParams();
            if (zI) {
                i8 = this.U & 112;
                i9 = paddingLeft;
                if (i8 == 48) {
                }
                if (!z2) {
                }
            } else {
                i8 = this.U & 112;
                i9 = paddingLeft;
                if (i8 == 48) {
                }
                if (!z2) {
                }
            }
        }
        b(this.e0, 3);
        size = this.e0.size();
        while (i18 < size) {
        }
        int i3022 = i11;
        b(this.e0, 5);
        size2 = this.e0.size();
        while (i19 < size2) {
        }
        b(this.e0, 1);
        int iU22 = u(this.e0, iArr);
        i20 = (i9 + (((i7 - i9) - i6) / 2)) - (iU22 / 2);
        int i3122 = iU22 + i20;
        if (i20 >= iMax) {
        }
        size3 = this.e0.size();
        while (i12 < size3) {
        }
        this.e0.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.g0;
        if (e2.b(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (I(this.f)) {
            E(this.f, i2, 0, i3, 0, this.H);
            measuredWidth = this.f.getMeasuredWidth() + s(this.f);
            iMax = Math.max(0, this.f.getMeasuredHeight() + t(this.f));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (I(this.f137j)) {
            E(this.f137j, i2, 0, i3, 0, this.H);
            measuredWidth = this.f137j.getMeasuredWidth() + s(this.f137j);
            iMax = Math.max(iMax, this.f137j.getMeasuredHeight() + t(this.f137j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f137j.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[c3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (I(this.c)) {
            E(this.c, i2, iMax3, i3, 0, this.H);
            measuredWidth2 = this.c.getMeasuredWidth() + s(this.c);
            iMax = Math.max(iMax, this.c.getMeasuredHeight() + t(this.c));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.c.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (I(this.f138k)) {
            iMax4 += D(this.f138k, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f138k.getMeasuredHeight() + t(this.f138k));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f138k.getMeasuredState());
        }
        if (I(this.g)) {
            iMax4 += D(this.g, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.g.getMeasuredHeight() + t(this.g));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.g.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((e) childAt.getLayoutParams()).b == 0 && I(childAt)) {
                iMax4 += D(childAt, i2, iMax4, i3, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i5 = this.K + this.M;
        int i6 = this.I + this.J;
        if (I(this.d)) {
            D(this.d, i2, iMax4 + i6, i3, i5, iArr);
            int measuredWidth3 = this.d.getMeasuredWidth() + s(this.d);
            measuredHeight = this.d.getMeasuredHeight() + t(this.d);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.d.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (I(this.e)) {
            iMax2 = Math.max(iMax2, D(this.e, i2, iMax4 + i6, i3, measuredHeight + i5, iArr));
            measuredHeight += this.e.getMeasuredHeight() + t(this.e);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.e.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2), H() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.c;
        androidx.appcompat.view.menu.m mVarL = actionMenuView != null ? actionMenuView.L() : null;
        int i2 = gVar.e;
        if (i2 != 0 && this.l0 != null && mVarL != null && (menuItemFindItem = mVarL.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (gVar.f) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        h();
        this.O.f(i2 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.p pVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.l0;
        if (dVar != null && (pVar = dVar.d) != null) {
            gVar.e = pVar.getItemId();
        }
        gVar.f = A();
        return gVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c0 = false;
        }
        if (!this.c0) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.c0 = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.c0 = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(h.a.k.a.b.d(getContext(), i2));
    }

    public void setCollapsible(boolean z) {
        this.o0 = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.Q) {
            this.Q = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.P) {
            this.P = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i2, int i3) {
        h();
        this.O.e(i2, i3);
    }

    public void setContentInsetsRelative(int i2, int i3) {
        h();
        this.O.g(i2, i3);
    }

    public void setLogo(int i2) {
        setLogo(h.a.k.a.b.d(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setMenu(androidx.appcompat.view.menu.m mVar, k kVar) {
        if (mVar == null && this.c == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.m mVarL = this.c.L();
        if (mVarL == mVar) {
            return;
        }
        if (mVarL != null) {
            mVarL.O(this.k0);
            mVarL.O(this.l0);
        }
        if (this.l0 == null) {
            this.l0 = new d();
        }
        kVar.H(true);
        if (mVar != null) {
            mVar.c(kVar, this.t);
            mVar.c(this.l0, this.t);
        } else {
            kVar.h(this.t, null);
            this.l0.h(this.t, null);
            kVar.d(true);
            this.l0.d(true);
        }
        this.c.setPopupTheme(this.A);
        this.c.setPresenter(kVar);
        this.k0 = kVar;
    }

    public void setMenuCallbacks(z.a aVar, m.a aVar2) {
        this.m0 = aVar;
        this.n0 = aVar2;
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(h.a.k.a.b.d(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.h0 = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.c.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.A != i2) {
            this.A = i2;
            if (i2 == 0) {
                this.t = getContext();
            } else {
                this.t = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextAppearance(Context context, int i2) {
        this.D = i2;
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMargin(int i2, int i3, int i4, int i5) {
        this.I = i2;
        this.K = i3;
        this.J = i4;
        this.M = i5;
        requestLayout();
    }

    public void setTitleMarginBottom(int i2) {
        this.M = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.J = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.I = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.K = i2;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i2) {
        this.C = i2;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean v() {
        d dVar = this.l0;
        return (dVar == null || dVar.d == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.c;
        return actionMenuView != null && actionMenuView.F();
    }

    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.c;
        return actionMenuView != null && actionMenuView.G();
    }

    public static class e extends a.C0000a {
        int b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.b = 0;
            this.a = 8388627;
        }

        public e(e eVar) {
            super((a.C0000a) eVar);
            this.b = 0;
            this.b = eVar.b;
        }

        public e(a.C0000a c0000a) {
            super(c0000a);
            this.b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.O);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f137j;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f137j.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f137j;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f135h);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.g)) {
                c(this.g, true);
            }
        } else {
            ImageView imageView = this.g;
            if (imageView != null && y(imageView)) {
                removeView(this.g);
                this.f0.remove(this.g);
            }
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f)) {
                c(this.f, true);
            }
        } else {
            ImageButton imageButton = this.f;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f);
                this.f0.remove(this.f);
            }
        }
        ImageButton imageButton2 = this.f;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.e;
            if (textView != null && y(textView)) {
                removeView(this.e);
                this.f0.remove(this.e);
            }
        } else {
            if (this.e == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.e = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.e.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.D;
                if (i2 != 0) {
                    this.e.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.b0;
                if (colorStateList != null) {
                    this.e.setTextColor(colorStateList);
                }
            }
            if (!y(this.e)) {
                c(this.e, true);
            }
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.W = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.b0 = colorStateList;
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.d;
            if (textView != null && y(textView)) {
                removeView(this.d);
                this.f0.remove(this.d);
            }
        } else {
            if (this.d == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.d = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.C;
                if (i2 != 0) {
                    this.d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.a0;
                if (colorStateList != null) {
                    this.d.setTextColor(colorStateList);
                }
            }
            if (!y(this.d)) {
                c(this.d, true);
            }
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.V = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.a0 = colorStateList;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class g extends h.g.a.c {
        public static final Parcelable.Creator<g> CREATOR = new u1();
        int e;
        boolean f;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.e = parcel.readInt();
            this.f = parcel.readInt() != 0;
        }

        @Override // h.g.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.U = 8388627;
        this.e0 = new ArrayList<>();
        this.f0 = new ArrayList<>();
        this.g0 = new int[2];
        this.i0 = new a();
        this.p0 = new b();
        Context context2 = getContext();
        int[] iArr = h.a.j.W2;
        t1 t1VarU = t1.u(context2, attributeSet, iArr, i2, 0);
        h.e.j.s0.X(this, context, iArr, attributeSet, t1VarU.q(), i2, 0);
        this.C = t1VarU.m(h.a.j.y3, 0);
        this.D = t1VarU.m(h.a.j.p3, 0);
        this.U = t1VarU.k(h.a.j.X2, this.U);
        this.G = t1VarU.k(h.a.j.Y2, 48);
        int iD = t1VarU.d(h.a.j.s3, 0);
        int i3 = h.a.j.x3;
        iD = t1VarU.r(i3) ? t1VarU.d(i3, iD) : iD;
        this.M = iD;
        this.K = iD;
        this.J = iD;
        this.I = iD;
        int iD2 = t1VarU.d(h.a.j.v3, -1);
        if (iD2 >= 0) {
            this.I = iD2;
        }
        int iD3 = t1VarU.d(h.a.j.u3, -1);
        if (iD3 >= 0) {
            this.J = iD3;
        }
        int iD4 = t1VarU.d(h.a.j.w3, -1);
        if (iD4 >= 0) {
            this.K = iD4;
        }
        int iD5 = t1VarU.d(h.a.j.t3, -1);
        if (iD5 >= 0) {
            this.M = iD5;
        }
        this.H = t1VarU.e(h.a.j.j3, -1);
        int iD6 = t1VarU.d(h.a.j.f3, Integer.MIN_VALUE);
        int iD7 = t1VarU.d(h.a.j.b3, Integer.MIN_VALUE);
        int iE = t1VarU.e(h.a.j.d3, 0);
        int iE2 = t1VarU.e(h.a.j.e3, 0);
        h();
        this.O.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.O.g(iD6, iD7);
        }
        this.P = t1VarU.d(h.a.j.g3, Integer.MIN_VALUE);
        this.Q = t1VarU.d(h.a.j.c3, Integer.MIN_VALUE);
        this.f135h = t1VarU.f(h.a.j.a3);
        this.f136i = t1VarU.o(h.a.j.Z2);
        CharSequence charSequenceO = t1VarU.o(h.a.j.r3);
        if (!TextUtils.isEmpty(charSequenceO)) {
            setTitle(charSequenceO);
        }
        CharSequence charSequenceO2 = t1VarU.o(h.a.j.o3);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            setSubtitle(charSequenceO2);
        }
        this.t = getContext();
        setPopupTheme(t1VarU.m(h.a.j.n3, 0));
        Drawable drawableF = t1VarU.f(h.a.j.m3);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceO3 = t1VarU.o(h.a.j.l3);
        if (!TextUtils.isEmpty(charSequenceO3)) {
            setNavigationContentDescription(charSequenceO3);
        }
        Drawable drawableF2 = t1VarU.f(h.a.j.h3);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceO4 = t1VarU.o(h.a.j.i3);
        if (!TextUtils.isEmpty(charSequenceO4)) {
            setLogoDescription(charSequenceO4);
        }
        int i4 = h.a.j.z3;
        if (t1VarU.r(i4)) {
            setTitleTextColor(t1VarU.c(i4));
        }
        int i5 = h.a.j.q3;
        if (t1VarU.r(i5)) {
            setSubtitleTextColor(t1VarU.c(i5));
        }
        int i6 = h.a.j.k3;
        if (t1VarU.r(i6)) {
            x(t1VarU.m(i6, 0));
        }
        t1VarU.v();
    }
}
