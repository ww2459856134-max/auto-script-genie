package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private final ArrayList<b> c;
    private FrameLayout d;
    private Context e;
    private p1 f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private TabHost.OnTabChangeListener f234h;

    /* renamed from: i, reason: collision with root package name */
    private b f235i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f236j;

    static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new d2();
        String c;

        a(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.c + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.c);
        }

        a(Parcel parcel) {
            super(parcel);
            this.c = parcel.readString();
        }
    }

    static final class b {
        final String a;
        final Class<?> b;
        final Bundle c;
        Fragment d;
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.c = new ArrayList<>();
        e(context, null);
    }

    private f2 a(String str, f2 f2Var) {
        Fragment fragment;
        b bVarD = d(str);
        if (this.f235i != bVarD) {
            if (f2Var == null) {
                f2Var = this.f.l();
            }
            b bVar = this.f235i;
            if (bVar != null && (fragment = bVar.d) != null) {
                f2Var.k(fragment);
            }
            if (bVarD != null) {
                Fragment fragment2 = bVarD.d;
                if (fragment2 == null) {
                    Fragment fragmentA = this.f.q0().a(this.e.getClassLoader(), bVarD.b.getName());
                    bVarD.d = fragmentA;
                    fragmentA.G1(bVarD.c);
                    f2Var.b(this.g, bVarD.d, bVarD.a);
                } else {
                    f2Var.f(fragment2);
                }
            }
        }
        return f2Var;
    }

    private void b() {
        if (this.d == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.g);
            this.d = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.g);
        }
    }

    private void c(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.d = frameLayout2;
            frameLayout2.setId(this.g);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private b d(String str) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            if (bVar.a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.g = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.c.size();
        f2 f2VarL = null;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            Fragment fragmentI0 = this.f.i0(bVar.a);
            bVar.d = fragmentI0;
            if (fragmentI0 != null && !fragmentI0.e0() && !bVar.a.equals(currentTabTag)) {
                if (f2VarL == null) {
                    f2VarL = this.f.l();
                }
                f2VarL.k(bVar.d);
            }
        }
        this.f236j = true;
        f2 f2VarA = a(currentTabTag, f2VarL);
        if (f2VarA != null) {
            f2VarA.g();
            this.f.e0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f236j = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setCurrentTabByTag(aVar.c);
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.c = getCurrentTabTag();
        return aVar;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        f2 f2VarA;
        if (this.f236j && (f2VarA = a(str, null)) != null) {
            f2VarA.g();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f234h;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f234h = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, p1 p1Var) {
        c(context);
        super.setup();
        this.e = context;
        this.f = p1Var;
        b();
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList<>();
        e(context, attributeSet);
    }

    @Deprecated
    public void setup(Context context, p1 p1Var, int i2) {
        c(context);
        super.setup();
        this.e = context;
        this.f = p1Var;
        this.g = i2;
        b();
        this.d.setId(i2);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
