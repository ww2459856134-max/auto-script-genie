package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {
    final DataSetObserver A;
    private final ViewTreeObserver.OnGlobalLayoutListener C;
    private a1 D;
    PopupWindow.OnDismissListener G;
    boolean H;
    int I;
    private boolean J;
    private int K;
    final f c;
    private final g d;
    private final View e;
    private final Drawable f;
    final FrameLayout g;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f108h;

    /* renamed from: i, reason: collision with root package name */
    final FrameLayout f109i;

    /* renamed from: j, reason: collision with root package name */
    private final ImageView f110j;

    /* renamed from: k, reason: collision with root package name */
    private final int f111k;
    h.e.j.e t;

    public static class InnerLayout extends LinearLayout {
        private static final int[] c = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            t1 t1VarT = t1.t(context, attributeSet, c);
            setBackgroundDrawable(t1VarT.f(0));
            t1VarT.v();
        }
    }

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.c.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.c.notifyDataSetInvalidated();
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().g();
                h.e.j.e eVar = ActivityChooserView.this.t;
                if (eVar != null) {
                    eVar.k(true);
                }
            }
        }
    }

    class c extends View.AccessibilityDelegate {
        c(ActivityChooserView activityChooserView) {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            h.e.j.q1.e.o0(accessibilityNodeInfo).T(true);
        }
    }

    class d extends t0 {
        d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.t0
        public androidx.appcompat.view.menu.c0 b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.t0
        protected boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        @Override // androidx.appcompat.widget.t0
        protected boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    private class f extends BaseAdapter {
        private l c;
        private int d = 4;
        private boolean e;
        private boolean f;
        private boolean g;

        f() {
        }

        public int a() {
            return this.c.c();
        }

        public l b() {
            return this.c;
        }

        public ResolveInfo c() {
            return this.c.e();
        }

        public int d() {
            return this.c.f();
        }

        public boolean e() {
            return this.e;
        }

        public int f() {
            int i2 = this.d;
            this.d = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            View view = null;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.d = i2;
            return iMax;
        }

        public void g(l lVar) {
            l lVarB = ActivityChooserView.this.c.b();
            if (lVarB != null && ActivityChooserView.this.isShown()) {
                lVarB.unregisterObserver(ActivityChooserView.this.A);
            }
            if (lVar != null && ActivityChooserView.this.isShown()) {
                lVar.registerObserver(ActivityChooserView.this.A);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iC = this.c.c();
            if (!this.e && this.c.e() != null) {
                iC--;
            }
            int iMin = Math.min(iC, this.d);
            return this.g ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.e && this.c.e() != null) {
                i2++;
            }
            return this.c.b(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            return (this.g && i2 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(h.a.g.f, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(h.a.f.S)).setText(ActivityChooserView.this.getContext().getString(h.a.h.b));
                return viewInflate;
            }
            if (view == null || view.getId() != h.a.f.x) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(h.a.g.f, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(h.a.f.v);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(h.a.f.S)).setText(resolveInfo.loadLabel(packageManager));
            if (this.e && i2 == 0 && this.f) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void h(int i2) {
            if (this.d != i2) {
                this.d = i2;
                notifyDataSetChanged();
            }
        }

        public void i(boolean z, boolean z2) {
            if (this.e == z && this.f == z2) {
                return;
            }
            this.e = z;
            this.f = z2;
            notifyDataSetChanged();
        }

        public void j(boolean z) {
            if (this.g != z) {
                this.g = z;
                notifyDataSetChanged();
            }
        }
    }

    private class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        g() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.G;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f109i) {
                if (view != activityChooserView.g) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.H = false;
                activityChooserView.d(activityChooserView.I);
                return;
            }
            activityChooserView.a();
            Intent intentA = ActivityChooserView.this.c.b().a(ActivityChooserView.this.c.b().d(ActivityChooserView.this.c.c()));
            if (intentA != null) {
                intentA.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentA);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            h.e.j.e eVar = ActivityChooserView.this.t;
            if (eVar != null) {
                eVar.k(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.d(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.H) {
                if (i2 > 0) {
                    activityChooserView.c.b().g(i2);
                    return;
                }
                return;
            }
            if (!activityChooserView.c.e()) {
                i2++;
            }
            Intent intentA = ActivityChooserView.this.c.b().a(i2);
            if (intentA != null) {
                intentA.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentA);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f109i) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.c.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.H = true;
                activityChooserView2.d(activityChooserView2.I);
            }
            return true;
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.C);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().a();
    }

    public boolean c() {
        if (b() || !this.J) {
            return false;
        }
        this.H = false;
        d(this.I);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void d(int i2) {
        if (this.c.b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.C);
        ?? r0 = this.f109i.getVisibility() == 0 ? 1 : 0;
        int iA = this.c.a();
        if (i2 == Integer.MAX_VALUE || iA <= i2 + r0) {
            this.c.j(false);
            this.c.h(i2);
        } else {
            this.c.j(true);
            this.c.h(i2 - 1);
        }
        a1 listPopupWindow = getListPopupWindow();
        if (listPopupWindow.a()) {
            return;
        }
        if (this.H || r0 == 0) {
            this.c.i(true, r0);
        } else {
            this.c.i(false, false);
        }
        listPopupWindow.A(Math.min(this.c.f(), this.f111k));
        listPopupWindow.g();
        h.e.j.e eVar = this.t;
        if (eVar != null) {
            eVar.k(true);
        }
        listPopupWindow.i().setContentDescription(getContext().getString(h.a.h.c));
        listPopupWindow.i().setSelector(new ColorDrawable(0));
    }

    void e() {
        if (this.c.getCount() > 0) {
            this.g.setEnabled(true);
        } else {
            this.g.setEnabled(false);
        }
        int iA = this.c.a();
        int iD = this.c.d();
        if (iA == 1 || (iA > 1 && iD > 0)) {
            this.f109i.setVisibility(0);
            ResolveInfo resolveInfoC = this.c.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f110j.setImageDrawable(resolveInfoC.loadIcon(packageManager));
            if (this.K != 0) {
                this.f109i.setContentDescription(getContext().getString(this.K, resolveInfoC.loadLabel(packageManager)));
            }
        } else {
            this.f109i.setVisibility(8);
        }
        if (this.f109i.getVisibility() == 0) {
            this.e.setBackgroundDrawable(this.f);
        } else {
            this.e.setBackgroundDrawable(null);
        }
    }

    public l getDataModel() {
        return this.c.b();
    }

    a1 getListPopupWindow() {
        if (this.D == null) {
            a1 a1Var = new a1(getContext());
            this.D = a1Var;
            a1Var.n(this.c);
            this.D.y(this);
            this.D.E(true);
            this.D.G(this.d);
            this.D.F(this.d);
        }
        return this.D;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVarB = this.c.b();
        if (lVarB != null) {
            lVarB.registerObserver(this.A);
        }
        this.J = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVarB = this.c.b();
        if (lVarB != null) {
            lVarB.unregisterObserver(this.A);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.C);
        }
        if (b()) {
            a();
        }
        this.J = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.e.layout(0, 0, i4 - i2, i5 - i3);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        View view = this.e;
        if (this.f109i.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), WXVideoFileObject.FILE_SIZE_LIMIT);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(l lVar) {
        this.c.g(lVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.K = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f108h.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f108h.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.I = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.G = onDismissListener;
    }

    public void setProvider(h.e.j.e eVar) {
        this.t = eVar;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new a();
        this.C = new b();
        this.I = 4;
        int[] iArr = h.a.j.D;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        h.e.j.s0.X(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        this.I = typedArrayObtainStyledAttributes.getInt(h.a.j.F, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(h.a.j.E);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.a.g.e, (ViewGroup) this, true);
        g gVar = new g();
        this.d = gVar;
        View viewFindViewById = findViewById(h.a.f.f1203j);
        this.e = viewFindViewById;
        this.f = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a.f.r);
        this.f109i = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i3 = h.a.f.w;
        this.f110j = (ImageView) frameLayout.findViewById(i3);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(h.a.f.t);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c(this));
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.g = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i3);
        this.f108h = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.c = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f111k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(h.a.d.d));
    }
}
