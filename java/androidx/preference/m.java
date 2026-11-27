package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import androidx.preference.t;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class m extends Fragment implements t.c, t.a, t.b, DialogPreference.a {
    RecyclerView A0;
    private boolean B0;
    private boolean C0;
    private Context D0;
    private int E0 = b0.c;
    private final c F0 = new c();
    private Handler G0 = new a();
    private final Runnable H0 = new b();
    private Runnable I0;
    private t z0;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            m.this.U1();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = m.this.A0;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    private class c extends RecyclerView.n {
        private Drawable a;
        private int b;
        private boolean c = true;

        c() {
        }

        private boolean l(View view, RecyclerView recyclerView) {
            RecyclerView.d0 d0VarG0 = recyclerView.g0(view);
            boolean z = false;
            if (!((d0VarG0 instanceof x) && ((x) d0VarG0).d())) {
                return false;
            }
            boolean z2 = this.c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z2;
            }
            RecyclerView.d0 d0VarG02 = recyclerView.g0(recyclerView.getChildAt(iIndexOfChild + 1));
            if ((d0VarG02 instanceof x) && ((x) d0VarG02).c()) {
                z = true;
            }
            return z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (l(view, recyclerView)) {
                rect.bottom = this.b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (this.a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (l(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.a.setBounds(0, y, width, this.b + y);
                    this.a.draw(canvas);
                }
            }
        }

        public void i(boolean z) {
            this.c = z;
        }

        public void j(Drawable drawable) {
            if (drawable != null) {
                this.b = drawable.getIntrinsicHeight();
            } else {
                this.b = 0;
            }
            this.a = drawable;
            m.this.A0.u0();
        }

        public void k(int i2) {
            this.b = i2;
            m.this.A0.u0();
        }
    }

    private void e2() {
        if (this.G0.hasMessages(1)) {
            return;
        }
        this.G0.obtainMessage(1).sendToTarget();
    }

    private void f2() {
        if (this.z0 == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void k2() {
        PreferenceScreen preferenceScreenX1 = X1();
        if (preferenceScreenX1 != null) {
            preferenceScreenX1.Q();
        }
        d2();
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        this.G0.removeCallbacks(this.H0);
        this.G0.removeMessages(1);
        if (this.B0) {
            k2();
        }
        this.A0 = null;
        super.C0();
    }

    @Override // androidx.fragment.app.Fragment
    public void R0(Bundle bundle) {
        super.R0(bundle);
        PreferenceScreen preferenceScreenX1 = X1();
        if (preferenceScreenX1 != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenX1.h0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        this.z0.q(this);
        this.z0.o(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void T0() {
        super.T0();
        this.z0.q(null);
        this.z0.o(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void U0(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenX1;
        super.U0(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenX1 = X1()) != null) {
            preferenceScreenX1.g0(bundle2);
        }
        if (this.B0) {
            U1();
            Runnable runnable = this.I0;
            if (runnable != null) {
                runnable.run();
                this.I0 = null;
            }
        }
        this.C0 = true;
    }

    void U1() {
        PreferenceScreen preferenceScreenX1 = X1();
        if (preferenceScreenX1 != null) {
            W1().setAdapter(Z1(preferenceScreenX1));
            preferenceScreenX1.K();
        }
        Y1();
    }

    public Fragment V1() {
        return null;
    }

    public final RecyclerView W1() {
        return this.A0;
    }

    public PreferenceScreen X1() {
        return this.z0.k();
    }

    protected void Y1() {
    }

    protected RecyclerView.g Z1(PreferenceScreen preferenceScreen) {
        return new r(preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.a
    public Preference a(CharSequence charSequence) {
        t tVar = this.z0;
        if (tVar == null) {
            return null;
        }
        return tVar.a(charSequence);
    }

    public RecyclerView.o a2() {
        return new LinearLayoutManager(q());
    }

    public abstract void b2(Bundle bundle, String str);

    @Override // androidx.preference.t.a
    public void c(Preference preference) {
        androidx.fragment.app.s sVarT2;
        V1();
        q();
        if (F().i0("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            sVarT2 = e.t2(preference.o());
        } else if (preference instanceof ListPreference) {
            sVarT2 = g.t2(preference.o());
        } else {
            if (!(preference instanceof AbstractMultiSelectListPreference)) {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            sVarT2 = i.t2(preference.o());
        }
        sVarT2.O1(this, 0);
        sVarT2.j2(F(), "androidx.preference.PreferenceFragment.DIALOG");
    }

    public RecyclerView c2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.D0.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(a0.b)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(b0.d, viewGroup, false);
        recyclerView2.setLayoutManager(a2());
        recyclerView2.setAccessibilityDelegateCompat(new w(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.preference.t.c
    public boolean d(Preference preference) {
        if (preference.l() != null) {
            V1();
            q();
        }
        return false;
    }

    protected void d2() {
    }

    @Override // androidx.preference.t.b
    public void e(PreferenceScreen preferenceScreen) {
        V1();
        q();
    }

    public void g2(Drawable drawable) {
        this.F0.j(drawable);
    }

    public void h2(int i2) {
        this.F0.k(i2);
    }

    public void i2(PreferenceScreen preferenceScreen) {
        if (!this.z0.r(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        d2();
        this.B0 = true;
        if (this.C0) {
            e2();
        }
    }

    public void j2(int i2, String str) {
        f2();
        PreferenceScreen preferenceScreenM = this.z0.m(this.D0, i2, null);
        PreferenceScreen preferenceScreen = preferenceScreenM;
        if (str != null) {
            Preference preferenceA0 = preferenceScreenM.A0(str);
            boolean z = preferenceA0 instanceof PreferenceScreen;
            preferenceScreen = preferenceA0;
            if (!z) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        i2(preferenceScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        TypedValue typedValue = new TypedValue();
        q().getTheme().resolveAttribute(y.f312i, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = d0.a;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(q(), i2);
        this.D0 = contextThemeWrapper;
        t tVar = new t(contextThemeWrapper);
        this.z0 = tVar;
        tVar.p(this);
        b2(bundle, v() != null ? v().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = this.D0.obtainStyledAttributes(null, e0.q0, y.f, 0);
        this.E0 = typedArrayObtainStyledAttributes.getResourceId(e0.r0, this.E0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(e0.s0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(e0.t0, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(e0.u0, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(this.D0);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.E0, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewC2 = c2(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewC2 == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.A0 = recyclerViewC2;
        recyclerViewC2.g(this.F0);
        g2(drawable);
        if (dimensionPixelSize != -1) {
            h2(dimensionPixelSize);
        }
        this.F0.i(z);
        if (this.A0.getParent() == null) {
            viewGroup2.addView(this.A0);
        }
        this.G0.post(this.H0);
        return viewInflate;
    }
}
