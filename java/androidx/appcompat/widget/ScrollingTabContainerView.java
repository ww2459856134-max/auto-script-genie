package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    Runnable c;
    private c d;
    LinearLayoutCompat e;
    private Spinner f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    int f124h;

    /* renamed from: i, reason: collision with root package name */
    int f125i;

    /* renamed from: j, reason: collision with root package name */
    private int f126j;

    /* renamed from: k, reason: collision with root package name */
    private int f127k;
    protected ViewPropertyAnimator t;

    class a implements Runnable {
        final /* synthetic */ View c;

        a(View view) {
            this.c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.c.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.c.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.c = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.e.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((d) ScrollingTabContainerView.this.e.getChildAt(i2)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.d((a.b) getItem(i2), true);
            }
            ((d) view).a((a.b) getItem(i2));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = ScrollingTabContainerView.this.e.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ScrollingTabContainerView.this.e.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {
        private final int[] c;
        private a.b d;
        private TextView e;
        private ImageView f;
        private View g;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(Context context, a.b bVar, boolean z) {
            int i2 = h.a.a.e;
            super(context, null, i2);
            int[] iArr = {R.attr.background};
            this.c = iArr;
            t1 t1VarU = t1.u(context, null, iArr, i2, 0);
            if (t1VarU.r(0)) {
                setBackgroundDrawable(t1VarU.f(0));
            }
            t1VarU.v();
            if (z) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.b bVar) {
            c();
        }

        public a.b b() {
            return this.d;
        }

        public void c() {
            a.b bVar = this.d;
            View viewB = bVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.g = viewB;
                TextView textView = this.e;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.g;
            if (view != null) {
                removeView(view);
                this.g = null;
            }
            Drawable drawableC = bVar.c();
            CharSequence charSequenceD = bVar.d();
            if (drawableC != null) {
                if (this.f == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f = appCompatImageView;
                }
                this.f.setImageDrawable(drawableC);
                this.f.setVisibility(0);
            } else {
                ImageView imageView2 = this.f;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceD);
            if (z) {
                if (this.e == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, h.a.a.f);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.e = appCompatTextView;
                }
                this.e.setText(charSequenceD);
                this.e.setVisibility(0);
            } else {
                TextView textView2 = this.e;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.e.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            y1.a(this, z ? null : bVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.f124h > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = ScrollingTabContainerView.this.f124h;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, WXVideoFileObject.FILE_SIZE_LIMIT), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    protected class e extends AnimatorListenerAdapter {
        private boolean a = false;
        private int b;

        protected e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.t = null;
            scrollingTabContainerView.setVisibility(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.a = false;
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        new e();
        setHorizontalScrollBarEnabled(false);
        h.a.o.a aVarB = h.a.o.a.b(context);
        setContentHeight(aVarB.f());
        this.f125i = aVarB.e();
        LinearLayoutCompat linearLayoutCompatC = c();
        this.e = linearLayoutCompatC;
        addView(linearLayoutCompatC, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, h.a.a.f1177i);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat c() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, h.a.a.d);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        return linearLayoutCompat;
    }

    private boolean e() {
        Spinner spinner = this.f;
        return spinner != null && spinner.getParent() == this;
    }

    private void f() {
        if (e()) {
            return;
        }
        if (this.f == null) {
            this.f = b();
        }
        removeView(this.e);
        addView(this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.c;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.c = null;
        }
        this.f.setSelection(this.f127k);
    }

    private boolean g() {
        if (!e()) {
            return false;
        }
        removeView(this.f);
        addView(this.e, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f.getSelectedItemPosition());
        return false;
    }

    public void a(int i2) {
        View childAt = this.e.getChildAt(i2);
        Runnable runnable = this.c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.c = aVar;
        post(aVar);
    }

    d d(a.b bVar, boolean z) {
        d dVar = new d(getContext(), bVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f126j));
        } else {
            dVar.setFocusable(true);
            if (this.d == null) {
                this.d = new c();
            }
            dVar.setOnClickListener(this.d);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.c;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h.a.o.a aVarB = h.a.o.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f125i = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f124h = -1;
        } else {
            if (childCount > 2) {
                this.f124h = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f124h = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f124h = Math.min(this.f124h, this.f125i);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f126j, WXVideoFileObject.FILE_SIZE_LIMIT);
        if (!z && this.g) {
            this.e.measure(0, iMakeMeasureSpec);
            if (this.e.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                f();
            } else {
                g();
            }
        } else {
            g();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f127k);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i2) {
        this.f126j = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f127k = i2;
        int childCount = this.e.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.e.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }
}
