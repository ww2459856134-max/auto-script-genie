package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.p;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements h.e.j.e0 {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f113k = {R.attr.spinnerMode};
    private final m c;
    private final Context d;
    private t0 e;
    private SpinnerAdapter f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private g f114h;

    /* renamed from: i, reason: collision with root package name */
    int f115i;

    /* renamed from: j, reason: collision with root package name */
    final Rect f116j;

    class a extends t0 {
        final /* synthetic */ e t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.t = eVar;
        }

        @Override // androidx.appcompat.widget.t0
        public androidx.appcompat.view.menu.c0 b() {
            return this.t;
        }

        @Override // androidx.appcompat.widget.t0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().a()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().a()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    class c implements g, DialogInterface.OnClickListener {
        androidx.appcompat.app.p c;
        private ListAdapter d;
        private CharSequence e;

        c() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public boolean a() {
            androidx.appcompat.app.p pVar = this.c;
            if (pVar != null) {
                return pVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void c(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void d(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void dismiss() {
            androidx.appcompat.app.p pVar = this.c;
            if (pVar != null) {
                pVar.dismiss();
                this.c = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void e(int i2, int i3) {
            if (this.d == null) {
                return;
            }
            p.a aVar = new p.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.e;
            if (charSequence != null) {
                aVar.m(charSequence);
            }
            aVar.k(this.d, AppCompatSpinner.this.getSelectedItemPosition(), this);
            androidx.appcompat.app.p pVarA = aVar.a();
            this.c = pVarA;
            ListView listViewG = pVarA.g();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewG.setTextDirection(i2);
                listViewG.setTextAlignment(i3);
            }
            this.c.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int j() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void k(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence l() {
            return this.e;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void m(CharSequence charSequence) {
            this.e = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void n(ListAdapter listAdapter) {
            this.d = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void o(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i2, this.d.getItemId(i2));
            }
            dismiss();
        }
    }

    private static class d implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter c;
        private ListAdapter d;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.c = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.d = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !(spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                return;
            }
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.d;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.c;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.d;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class e extends a1 implements g {
        private CharSequence i0;
        ListAdapter j0;
        private final Rect k0;
        private int l0;

        public e(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.k0 = new Rect();
            y(AppCompatSpinner.this);
            E(true);
            J(0);
            G(new y(this, AppCompatSpinner.this));
        }

        void N() {
            Drawable background = getBackground();
            int i2 = 0;
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.f116j);
                i2 = e2.b(AppCompatSpinner.this) ? AppCompatSpinner.this.f116j.right : -AppCompatSpinner.this.f116j.left;
            } else {
                Rect rect = AppCompatSpinner.this.f116j;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i3 = appCompatSpinner.f115i;
            if (i3 == -2) {
                int iA = appCompatSpinner.a((SpinnerAdapter) this.j0, getBackground());
                int i4 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f116j;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (iA > i5) {
                    iA = i5;
                }
                A(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                A((width - paddingLeft) - paddingRight);
            } else {
                A(i3);
            }
            k(e2.b(AppCompatSpinner.this) ? i2 + (((width - paddingRight) - u()) - O()) : i2 + paddingLeft + O());
        }

        public int O() {
            return this.l0;
        }

        boolean P(View view) {
            return h.e.j.s0.J(view) && view.getGlobalVisibleRect(this.k0);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void d(int i2) {
            this.l0 = i2;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void e(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean zA = a();
            N();
            D(2);
            super.g();
            ListView listViewI = i();
            listViewI.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewI.setTextDirection(i2);
                listViewI.setTextAlignment(i3);
            }
            K(AppCompatSpinner.this.getSelectedItemPosition());
            if (zA || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            z zVar = new z(this);
            viewTreeObserver.addOnGlobalLayoutListener(zVar);
            F(new a0(this, zVar));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence l() {
            return this.i0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void m(CharSequence charSequence) {
            this.i0 = charSequence;
        }

        @Override // androidx.appcompat.widget.a1, androidx.appcompat.widget.AppCompatSpinner.g
        public void n(ListAdapter listAdapter) {
            super.n(listAdapter);
            this.j0 = listAdapter;
        }
    }

    static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new b0();
        boolean c;

        f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        }

        f(Parcel parcel) {
            super(parcel);
            this.c = parcel.readByte() != 0;
        }
    }

    interface g {
        boolean a();

        void c(int i2);

        void d(int i2);

        void dismiss();

        void e(int i2, int i3);

        int f();

        Drawable getBackground();

        int j();

        void k(int i2);

        CharSequence l();

        void m(CharSequence charSequence);

        void n(ListAdapter listAdapter);

        void o(Drawable drawable);
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f116j);
        Rect rect = this.f116j;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f114h.e(getTextDirection(), getTextAlignment());
        } else {
            this.f114h.e(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.c;
        if (mVar != null) {
            mVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f114h;
        if (gVar != null) {
            return gVar.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f114h;
        if (gVar != null) {
            return gVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f114h != null) {
            return this.f115i;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final g getInternalPopup() {
        return this.f114h;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f114h;
        if (gVar != null) {
            return gVar.getBackground();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.d;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f114h;
        return gVar != null ? gVar.l() : super.getPrompt();
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

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f114h;
        if (gVar == null || !gVar.a()) {
            return;
        }
        this.f114h.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f114h == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.c || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f114h;
        fVar.c = gVar != null && gVar.a();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        t0 t0Var = this.e;
        if (t0Var == null || !t0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f114h;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.a()) {
            return true;
        }
        b();
        return true;
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

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        g gVar = this.f114h;
        if (gVar != null) {
            gVar.d(i2);
            this.f114h.k(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        g gVar = this.f114h;
        if (gVar != null) {
            gVar.c(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f114h != null) {
            this.f115i = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f114h;
        if (gVar != null) {
            gVar.o(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(h.a.k.a.b.d(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f114h;
        if (gVar != null) {
            gVar.m(charSequence);
        } else {
            super.setPrompt(charSequence);
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

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.K);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.g) {
            this.f = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f114h != null) {
            Context context = this.d;
            if (context == null) {
                context = getContext();
            }
            this.f114h.n(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[PHI: r10 r11
      0x0051: PHI (r10v2 int) = (r10v0 int), (r10v4 int) binds: [B:24:0x0062, B:15:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r11v6 android.content.res.TypedArray) = (r11v5 android.content.res.TypedArray), (r11v8 android.content.res.TypedArray) binds: [B:24:0x0062, B:15:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3, Resources.Theme theme) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] charSequenceArrP;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i2);
        this.f116j = new Rect();
        p1.a(this, getContext());
        t1 t1VarU = t1.u(context, attributeSet, h.a.j.o2, i2, 0);
        this.c = new m(this);
        if (theme != null) {
            this.d = new h.a.o.e(context, theme);
        } else {
            int iM = t1VarU.m(h.a.j.t2, 0);
            if (iM != 0) {
                this.d = new h.a.o.e(context, iM);
            } else {
                this.d = context;
            }
        }
        TypedArray typedArray = null;
        try {
            if (i3 == -1) {
                try {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f113k, i2, 0);
                    try {
                        i3 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i3;
                    } catch (Exception e2) {
                        e = e2;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (typedArrayObtainStyledAttributes != null) {
                        }
                        if (i3 != 0) {
                        }
                        charSequenceArrP = t1VarU.p(h.a.j.p2);
                        if (charSequenceArrP != null) {
                        }
                        t1VarU.v();
                        this.g = true;
                        spinnerAdapter = this.f;
                        if (spinnerAdapter != null) {
                        }
                        this.c.e(attributeSet, i2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    typedArrayObtainStyledAttributes = null;
                } catch (Throwable th) {
                    th = th;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
            if (i3 != 0) {
                c cVar = new c();
                this.f114h = cVar;
                cVar.m(t1VarU.n(h.a.j.r2));
            } else if (i3 == 1) {
                e eVar = new e(this.d, attributeSet, i2);
                t1 t1VarU2 = t1.u(this.d, attributeSet, h.a.j.o2, i2, 0);
                this.f115i = t1VarU2.l(h.a.j.s2, -2);
                eVar.o(t1VarU2.f(h.a.j.q2));
                eVar.m(t1VarU.n(h.a.j.r2));
                t1VarU2.v();
                this.f114h = eVar;
                this.e = new a(this, eVar);
            }
            charSequenceArrP = t1VarU.p(h.a.j.p2);
            if (charSequenceArrP != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrP);
                arrayAdapter.setDropDownViewResource(h.a.g.v);
                setAdapter((SpinnerAdapter) arrayAdapter);
            }
            t1VarU.v();
            this.g = true;
            spinnerAdapter = this.f;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f = null;
            }
            this.c.e(attributeSet, i2);
        } catch (Throwable th2) {
            th = th2;
            typedArray = -1;
        }
    }
}
