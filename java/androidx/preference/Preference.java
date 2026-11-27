package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.t;
import com.auto.exceldeps.log4j.util.Chars;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private CharSequence A;
    private int C;
    private Drawable D;
    private String G;
    private Intent H;
    private String I;
    private Bundle J;
    private boolean K;
    private boolean M;
    private boolean O;
    private String P;
    private Object Q;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean Z;
    private boolean a0;
    private boolean b0;
    private Context c;
    private boolean c0;
    private t d;
    private boolean d0;
    private k e;
    private boolean e0;
    private long f;
    private int f0;
    private boolean g;
    private int g0;

    /* renamed from: h, reason: collision with root package name */
    private d f290h;
    private c h0;

    /* renamed from: i, reason: collision with root package name */
    private e f291i;
    private List<Preference> i0;

    /* renamed from: j, reason: collision with root package name */
    private int f292j;
    private PreferenceGroup j0;

    /* renamed from: k, reason: collision with root package name */
    private int f293k;
    private boolean k0;
    private final View.OnClickListener l0;
    private CharSequence t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.Z(view);
        }
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new j();

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface c {
        void a(Preference preference);

        void b(Preference preference);
    }

    public interface d {
        boolean a(Preference preference, Object obj);
    }

    public interface e {
        boolean a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f292j = Integer.MAX_VALUE;
        this.f293k = 0;
        this.K = true;
        this.M = true;
        this.O = true;
        this.U = true;
        this.V = true;
        this.W = true;
        this.Z = true;
        this.a0 = true;
        this.c0 = true;
        this.e0 = true;
        int i4 = b0.b;
        this.f0 = i4;
        this.l0 = new a();
        this.c = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.G, i2, i3);
        this.C = androidx.core.content.c.r.n(typedArrayObtainStyledAttributes, e0.d0, e0.H, 0);
        this.G = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.g0, e0.N);
        this.t = androidx.core.content.c.r.p(typedArrayObtainStyledAttributes, e0.o0, e0.L);
        this.A = androidx.core.content.c.r.p(typedArrayObtainStyledAttributes, e0.n0, e0.O);
        this.f292j = androidx.core.content.c.r.d(typedArrayObtainStyledAttributes, e0.i0, e0.P, Integer.MAX_VALUE);
        this.I = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.c0, e0.U);
        this.f0 = androidx.core.content.c.r.n(typedArrayObtainStyledAttributes, e0.h0, e0.K, i4);
        this.g0 = androidx.core.content.c.r.n(typedArrayObtainStyledAttributes, e0.p0, e0.Q, 0);
        this.K = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.b0, e0.J, true);
        this.M = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.k0, e0.M, true);
        this.O = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.j0, e0.I, true);
        this.P = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.a0, e0.R);
        int i5 = e0.X;
        this.Z = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, i5, i5, this.M);
        int i6 = e0.Y;
        this.a0 = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, i6, i6, this.M);
        int i7 = e0.Z;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            this.Q = R(typedArrayObtainStyledAttributes, i7);
        } else {
            int i8 = e0.S;
            if (typedArrayObtainStyledAttributes.hasValue(i8)) {
                this.Q = R(typedArrayObtainStyledAttributes, i8);
            }
        }
        this.e0 = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.l0, e0.T, true);
        int i9 = e0.m0;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
        this.b0 = zHasValue;
        if (zHasValue) {
            this.c0 = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, i9, e0.V, true);
        }
        this.d0 = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.e0, e0.W, false);
        int i10 = e0.f0;
        this.W = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, i10, i10, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void e0() {
        if (TextUtils.isEmpty(this.P)) {
            return;
        }
        Preference preferenceH = h(this.P);
        if (preferenceH != null) {
            preferenceH.f0(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.P + "\" not found for preference \"" + this.G + "\" (title: \"" + ((Object) this.t) + "\"");
    }

    private void f0(Preference preference) {
        if (this.i0 == null) {
            this.i0 = new ArrayList();
        }
        this.i0.add(preference);
        preference.P(this, t0());
    }

    private void g() {
        if (w() != null) {
            X(true, this.Q);
            return;
        }
        if (u0() && y().contains(this.G)) {
            X(true, null);
            return;
        }
        Object obj = this.Q;
        if (obj != null) {
            X(false, obj);
        }
    }

    private void i0(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                i0(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    private void v0(SharedPreferences.Editor editor) {
        if (this.d.t()) {
            editor.apply();
        }
    }

    private void w0() {
        Preference preferenceH;
        String str = this.P;
        if (str == null || (preferenceH = h(str)) == null) {
            return;
        }
        preferenceH.x0(this);
    }

    private void x0(Preference preference) {
        List<Preference> list = this.i0;
        if (list != null) {
            list.remove(preference);
        }
    }

    public CharSequence A() {
        return this.t;
    }

    public final int B() {
        return this.g0;
    }

    public boolean C() {
        return !TextUtils.isEmpty(this.G);
    }

    public boolean D() {
        return this.K && this.U && this.V;
    }

    public boolean E() {
        return this.O;
    }

    public boolean F() {
        return this.M;
    }

    public final boolean G() {
        return this.W;
    }

    protected void H() {
        c cVar = this.h0;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public void I(boolean z) {
        List<Preference> list = this.i0;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).P(this, z);
        }
    }

    protected void J() {
        c cVar = this.h0;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public void K() {
        e0();
    }

    protected void L(t tVar) {
        this.d = tVar;
        if (!this.g) {
            this.f = tVar.f();
        }
        g();
    }

    protected void M(t tVar, long j2) {
        this.f = j2;
        this.g = true;
        try {
            L(tVar);
        } finally {
            this.g = false;
        }
    }

    public void N(x xVar) {
        xVar.itemView.setOnClickListener(this.l0);
        xVar.itemView.setId(this.f293k);
        TextView textView = (TextView) xVar.b(R.id.title);
        if (textView != null) {
            CharSequence charSequenceA = A();
            if (TextUtils.isEmpty(charSequenceA)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequenceA);
                textView.setVisibility(0);
                if (this.b0) {
                    textView.setSingleLine(this.c0);
                }
            }
        }
        TextView textView2 = (TextView) xVar.b(R.id.summary);
        if (textView2 != null) {
            CharSequence charSequenceZ = z();
            if (TextUtils.isEmpty(charSequenceZ)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequenceZ);
                textView2.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) xVar.b(R.id.icon);
        if (imageView != null) {
            if (this.C != 0 || this.D != null) {
                if (this.D == null) {
                    this.D = androidx.core.content.a.e(i(), this.C);
                }
                Drawable drawable = this.D;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.D != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.d0 ? 4 : 8);
            }
        }
        View viewB = xVar.b(a0.a);
        if (viewB == null) {
            viewB = xVar.b(R.id.icon_frame);
        }
        if (viewB != null) {
            if (this.D != null) {
                viewB.setVisibility(0);
            } else {
                viewB.setVisibility(this.d0 ? 4 : 8);
            }
        }
        if (this.e0) {
            i0(xVar.itemView, D());
        } else {
            i0(xVar.itemView, true);
        }
        boolean zF = F();
        xVar.itemView.setFocusable(zF);
        xVar.itemView.setClickable(zF);
        xVar.e(this.Z);
        xVar.f(this.a0);
    }

    protected void O() {
    }

    public void P(Preference preference, boolean z) {
        if (this.U == z) {
            this.U = !z;
            I(t0());
            H();
        }
    }

    public void Q() {
        w0();
    }

    protected Object R(TypedArray typedArray, int i2) {
        return null;
    }

    public void S(h.e.j.q1.e eVar) {
    }

    public void T(Preference preference, boolean z) {
        if (this.V == z) {
            this.V = !z;
            I(t0());
            H();
        }
    }

    protected void U(Parcelable parcelable) {
        this.k0 = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable V() {
        this.k0 = true;
        return AbsSavedState.EMPTY_STATE;
    }

    protected void W(Object obj) {
    }

    @Deprecated
    protected void X(boolean z, Object obj) {
        W(obj);
    }

    public void Y() {
        t.c cVarH;
        if (D()) {
            O();
            e eVar = this.f291i;
            if (eVar == null || !eVar.a(this)) {
                t tVarX = x();
                if ((tVarX == null || (cVarH = tVarX.h()) == null || !cVarH.d(this)) && this.H != null) {
                    i().startActivity(this.H);
                }
            }
        }
    }

    protected void Z(View view) {
        Y();
    }

    void a(PreferenceGroup preferenceGroup) {
        this.j0 = preferenceGroup;
    }

    protected boolean a0(boolean z) {
        if (!u0()) {
            return false;
        }
        if (z == s(!z)) {
            return true;
        }
        k kVarW = w();
        if (kVarW != null) {
            kVarW.e(this.G, z);
        } else {
            SharedPreferences.Editor editorE = this.d.e();
            editorE.putBoolean(this.G, z);
            v0(editorE);
        }
        return true;
    }

    public boolean b(Object obj) {
        d dVar = this.f290h;
        return dVar == null || dVar.a(this, obj);
    }

    protected boolean b0(int i2) {
        if (!u0()) {
            return false;
        }
        if (i2 == t(~i2)) {
            return true;
        }
        k kVarW = w();
        if (kVarW != null) {
            kVarW.f(this.G, i2);
        } else {
            SharedPreferences.Editor editorE = this.d.e();
            editorE.putInt(this.G, i2);
            v0(editorE);
        }
        return true;
    }

    public final void c() {
    }

    protected boolean c0(String str) {
        if (!u0()) {
            return false;
        }
        if (TextUtils.equals(str, u(null))) {
            return true;
        }
        k kVarW = w();
        if (kVarW != null) {
            kVarW.g(this.G, str);
        } else {
            SharedPreferences.Editor editorE = this.d.e();
            editorE.putString(this.G, str);
            v0(editorE);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i2 = this.f292j;
        int i3 = preference.f292j;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.t;
        CharSequence charSequence2 = preference.t;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.t.toString());
    }

    public boolean d0(Set<String> set) {
        if (!u0()) {
            return false;
        }
        if (set.equals(v(null))) {
            return true;
        }
        k kVarW = w();
        if (kVarW != null) {
            kVarW.h(this.G, set);
        } else {
            SharedPreferences.Editor editorE = this.d.e();
            editorE.putStringSet(this.G, set);
            v0(editorE);
        }
        return true;
    }

    void e(Bundle bundle) {
        Parcelable parcelable;
        if (!C() || (parcelable = bundle.getParcelable(this.G)) == null) {
            return;
        }
        this.k0 = false;
        U(parcelable);
        if (!this.k0) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    void f(Bundle bundle) {
        if (C()) {
            this.k0 = false;
            Parcelable parcelableV = V();
            if (!this.k0) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableV != null) {
                bundle.putParcelable(this.G, parcelableV);
            }
        }
    }

    public void g0(Bundle bundle) {
        e(bundle);
    }

    protected Preference h(String str) {
        t tVar;
        if (TextUtils.isEmpty(str) || (tVar = this.d) == null) {
            return null;
        }
        return tVar.a(str);
    }

    public void h0(Bundle bundle) {
        f(bundle);
    }

    public Context i() {
        return this.c;
    }

    public Bundle j() {
        if (this.J == null) {
            this.J = new Bundle();
        }
        return this.J;
    }

    public void j0(int i2) {
        k0(androidx.core.content.a.e(this.c, i2));
        this.C = i2;
    }

    StringBuilder k() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceA = A();
        if (!TextUtils.isEmpty(charSequenceA)) {
            sb.append(charSequenceA);
            sb.append(Chars.SPACE);
        }
        CharSequence charSequenceZ = z();
        if (!TextUtils.isEmpty(charSequenceZ)) {
            sb.append(charSequenceZ);
            sb.append(Chars.SPACE);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void k0(Drawable drawable) {
        if ((drawable != null || this.D == null) && (drawable == null || this.D == drawable)) {
            return;
        }
        this.D = drawable;
        this.C = 0;
        H();
    }

    public String l() {
        return this.I;
    }

    public void l0(Intent intent) {
        this.H = intent;
    }

    long m() {
        return this.f;
    }

    public void m0(int i2) {
        this.f0 = i2;
    }

    public Intent n() {
        return this.H;
    }

    final void n0(c cVar) {
        this.h0 = cVar;
    }

    public String o() {
        return this.G;
    }

    public void o0(e eVar) {
        this.f291i = eVar;
    }

    public final int p() {
        return this.f0;
    }

    public void p0(int i2) {
        if (i2 != this.f292j) {
            this.f292j = i2;
            J();
        }
    }

    public int q() {
        return this.f292j;
    }

    public void q0(CharSequence charSequence) {
        if ((charSequence != null || this.A == null) && (charSequence == null || charSequence.equals(this.A))) {
            return;
        }
        this.A = charSequence;
        H();
    }

    public PreferenceGroup r() {
        return this.j0;
    }

    public void r0(int i2) {
        s0(this.c.getString(i2));
    }

    protected boolean s(boolean z) {
        if (!u0()) {
            return z;
        }
        k kVarW = w();
        return kVarW != null ? kVarW.a(this.G, z) : this.d.l().getBoolean(this.G, z);
    }

    public void s0(CharSequence charSequence) {
        if ((charSequence != null || this.t == null) && (charSequence == null || charSequence.equals(this.t))) {
            return;
        }
        this.t = charSequence;
        H();
    }

    protected int t(int i2) {
        if (!u0()) {
            return i2;
        }
        k kVarW = w();
        return kVarW != null ? kVarW.b(this.G, i2) : this.d.l().getInt(this.G, i2);
    }

    public boolean t0() {
        return !D();
    }

    public String toString() {
        return k().toString();
    }

    protected String u(String str) {
        if (!u0()) {
            return str;
        }
        k kVarW = w();
        return kVarW != null ? kVarW.c(this.G, str) : this.d.l().getString(this.G, str);
    }

    protected boolean u0() {
        return this.d != null && E() && C();
    }

    public Set<String> v(Set<String> set) {
        if (!u0()) {
            return set;
        }
        k kVarW = w();
        return kVarW != null ? kVarW.d(this.G, set) : this.d.l().getStringSet(this.G, set);
    }

    public k w() {
        k kVar = this.e;
        if (kVar != null) {
            return kVar;
        }
        t tVar = this.d;
        if (tVar != null) {
            return tVar.j();
        }
        return null;
    }

    public t x() {
        return this.d;
    }

    public SharedPreferences y() {
        if (this.d == null || w() != null) {
            return null;
        }
        return this.d.l();
    }

    public CharSequence z() {
        return this.A;
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.f311h, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
