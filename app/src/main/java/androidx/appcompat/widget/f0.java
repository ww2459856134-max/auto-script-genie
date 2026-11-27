package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* loaded from: classes.dex */
class f0 {
    private final TextView a;
    private r1 b;
    private r1 c;
    private r1 d;
    private r1 e;
    private r1 f;
    private r1 g;

    /* renamed from: h, reason: collision with root package name */
    private r1 f151h;

    /* renamed from: i, reason: collision with root package name */
    private final j0 f152i;

    /* renamed from: j, reason: collision with root package name */
    private int f153j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f154k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f155l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f156m;

    f0(TextView textView) {
        this.a = textView;
        this.f152i = new j0(textView);
    }

    private void B(int i2, float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f152i.y(i2, f);
    }

    private void C(Context context, t1 t1Var) {
        String strN;
        this.f153j = t1Var.j(h.a.j.M2, this.f153j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int iJ = t1Var.j(h.a.j.R2, -1);
            this.f154k = iJ;
            if (iJ != -1) {
                this.f153j = (this.f153j & 2) | 0;
            }
        }
        int i3 = h.a.j.Q2;
        if (!t1Var.r(i3) && !t1Var.r(h.a.j.S2)) {
            int i4 = h.a.j.L2;
            if (t1Var.r(i4)) {
                this.f156m = false;
                int iJ2 = t1Var.j(i4, 1);
                if (iJ2 == 1) {
                    this.f155l = Typeface.SANS_SERIF;
                    return;
                } else if (iJ2 == 2) {
                    this.f155l = Typeface.SERIF;
                    return;
                } else {
                    if (iJ2 != 3) {
                        return;
                    }
                    this.f155l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f155l = null;
        int i5 = h.a.j.S2;
        if (t1Var.r(i5)) {
            i3 = i5;
        }
        int i6 = this.f154k;
        int i7 = this.f153j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = t1Var.i(i3, this.f153j, new d0(this, i6, i7, new WeakReference(this.a)));
                if (typefaceI != null) {
                    if (i2 < 28 || this.f154k == -1) {
                        this.f155l = typefaceI;
                    } else {
                        this.f155l = Typeface.create(Typeface.create(typefaceI, 0), this.f154k, (this.f153j & 2) != 0);
                    }
                }
                this.f156m = this.f155l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f155l != null || (strN = t1Var.n(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f154k == -1) {
            this.f155l = Typeface.create(strN, this.f153j);
        } else {
            this.f155l = Typeface.create(Typeface.create(strN, 0), this.f154k, (this.f153j & 2) != 0);
        }
    }

    private void a(Drawable drawable, r1 r1Var) {
        if (drawable == null || r1Var == null) {
            return;
        }
        p.i(drawable, r1Var, this.a.getDrawableState());
    }

    private static r1 d(Context context, p pVar, int i2) {
        ColorStateList colorStateListF = pVar.f(context, i2);
        if (colorStateListF == null) {
            return null;
        }
        r1 r1Var = new r1();
        r1Var.d = true;
        r1Var.a = colorStateListF;
        return r1Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i2 >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView3 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        r1 r1Var = this.f151h;
        this.b = r1Var;
        this.c = r1Var;
        this.d = r1Var;
        this.e = r1Var;
        this.f = r1Var;
        this.g = r1Var;
    }

    void A(int i2, float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (androidx.core.widget.d.a || l()) {
            return;
        }
        B(i2, f);
    }

    void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    void c() {
        this.f152i.b();
    }

    int e() {
        return this.f152i.j();
    }

    int f() {
        return this.f152i.k();
    }

    int g() {
        return this.f152i.l();
    }

    int[] h() {
        return this.f152i.m();
    }

    int i() {
        return this.f152i.n();
    }

    ColorStateList j() {
        r1 r1Var = this.f151h;
        if (r1Var != null) {
            return r1Var.a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        r1 r1Var = this.f151h;
        if (r1Var != null) {
            return r1Var.b;
        }
        return null;
    }

    boolean l() {
        return this.f152i.s();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a6  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m(AttributeSet attributeSet, int i2) {
        boolean zA;
        boolean z;
        String strN;
        ColorStateList colorStateListC;
        String strN2;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        String str;
        int i3;
        String strN3;
        p pVar;
        int i4;
        Context context = this.a.getContext();
        p pVarB = p.b();
        int[] iArr = h.a.j.Y;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        TextView textView = this.a;
        h.e.j.s0.X(textView, textView.getContext(), iArr, attributeSet, t1VarU.q(), i2, 0);
        int iM = t1VarU.m(h.a.j.Z, -1);
        int i5 = h.a.j.c0;
        if (t1VarU.r(i5)) {
            this.b = d(context, pVarB, t1VarU.m(i5, 0));
        }
        int i6 = h.a.j.a0;
        if (t1VarU.r(i6)) {
            this.c = d(context, pVarB, t1VarU.m(i6, 0));
        }
        int i7 = h.a.j.d0;
        if (t1VarU.r(i7)) {
            this.d = d(context, pVarB, t1VarU.m(i7, 0));
        }
        int i8 = h.a.j.b0;
        if (t1VarU.r(i8)) {
            this.e = d(context, pVarB, t1VarU.m(i8, 0));
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 17) {
            int i10 = h.a.j.e0;
            if (t1VarU.r(i10)) {
                this.f = d(context, pVarB, t1VarU.m(i10, 0));
            }
            int i11 = h.a.j.f0;
            if (t1VarU.r(i11)) {
                this.g = d(context, pVarB, t1VarU.m(i11, 0));
            }
        }
        t1VarU.v();
        boolean z2 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iM != -1) {
            t1 t1VarS = t1.s(context, iM, h.a.j.J2);
            if (!z2) {
                int i12 = h.a.j.U2;
                if (t1VarS.r(i12)) {
                    zA = t1VarS.a(i12, false);
                    z = true;
                } else {
                    zA = false;
                    z = false;
                }
                C(context, t1VarS);
                if (i9 < 23) {
                    int i13 = h.a.j.N2;
                    colorStateListC = t1VarS.r(i13) ? t1VarS.c(i13) : null;
                    int i14 = h.a.j.O2;
                    colorStateListC2 = t1VarS.r(i14) ? t1VarS.c(i14) : null;
                    int i15 = h.a.j.P2;
                    colorStateListC3 = t1VarS.r(i15) ? t1VarS.c(i15) : null;
                    int i16 = h.a.j.V2;
                    strN2 = !t1VarS.r(i16) ? t1VarS.n(i16) : null;
                    if (i9 < 26) {
                        int i17 = h.a.j.T2;
                        strN = t1VarS.r(i17) ? t1VarS.n(i17) : null;
                        t1VarS.v();
                    }
                } else {
                    colorStateListC = null;
                    colorStateListC2 = null;
                }
                int i162 = h.a.j.V2;
                if (!t1VarS.r(i162)) {
                }
                if (i9 < 26) {
                }
            }
        } else {
            zA = false;
            z = false;
            strN = null;
            colorStateListC = null;
            strN2 = null;
            colorStateListC2 = null;
            colorStateListC3 = null;
        }
        t1 t1VarU2 = t1.u(context, attributeSet, h.a.j.J2, i2, 0);
        if (!z2) {
            int i18 = h.a.j.U2;
            if (t1VarU2.r(i18)) {
                str = strN;
                zA = t1VarU2.a(i18, false);
                i3 = 23;
                z = true;
            } else {
                str = strN;
                i3 = 23;
            }
        }
        if (i9 < i3) {
            int i19 = h.a.j.N2;
            if (t1VarU2.r(i19)) {
                colorStateListC = t1VarU2.c(i19);
            }
            int i20 = h.a.j.O2;
            if (t1VarU2.r(i20)) {
                colorStateListC2 = t1VarU2.c(i20);
            }
            int i21 = h.a.j.P2;
            if (t1VarU2.r(i21)) {
                colorStateListC3 = t1VarU2.c(i21);
            }
        }
        int i22 = h.a.j.V2;
        if (t1VarU2.r(i22)) {
            strN2 = t1VarU2.n(i22);
        }
        if (i9 >= 26) {
            int i23 = h.a.j.T2;
            strN3 = t1VarU2.r(i23) ? t1VarU2.n(i23) : str;
        }
        if (i9 >= 28) {
            int i24 = h.a.j.K2;
            if (t1VarU2.r(i24)) {
                pVar = pVarB;
                if (t1VarU2.e(i24, -1) == 0) {
                    this.a.setTextSize(0, 0.0f);
                }
            } else {
                pVar = pVarB;
            }
        }
        C(context, t1VarU2);
        t1VarU2.v();
        if (colorStateListC != null) {
            this.a.setTextColor(colorStateListC);
        }
        if (colorStateListC2 != null) {
            this.a.setHintTextColor(colorStateListC2);
        }
        if (colorStateListC3 != null) {
            this.a.setLinkTextColor(colorStateListC3);
        }
        if (!z2 && z) {
            s(zA);
        }
        Typeface typeface = this.f155l;
        if (typeface != null) {
            if (this.f154k == -1) {
                this.a.setTypeface(typeface, this.f153j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (strN3 != null) {
            this.a.setFontVariationSettings(strN3);
        }
        if (strN2 != null) {
            if (i9 >= 24) {
                this.a.setTextLocales(LocaleList.forLanguageTags(strN2));
            } else if (i9 >= 21) {
                this.a.setTextLocale(Locale.forLanguageTag(strN2.substring(0, strN2.indexOf(44))));
            }
        }
        this.f152i.t(attributeSet, i2);
        if (androidx.core.widget.d.a && this.f152i.n() != 0) {
            int[] iArrM = this.f152i.m();
            if (iArrM.length > 0) {
                if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f152i.k(), this.f152i.j(), this.f152i.l(), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM, 0);
                }
            }
        }
        t1 t1VarT = t1.t(context, attributeSet, h.a.j.g0);
        int iM2 = t1VarT.m(h.a.j.o0, -1);
        p pVar2 = pVar;
        Drawable drawableC = iM2 != -1 ? pVar2.c(context, iM2) : null;
        int iM3 = t1VarT.m(h.a.j.t0, -1);
        Drawable drawableC2 = iM3 != -1 ? pVar2.c(context, iM3) : null;
        int iM4 = t1VarT.m(h.a.j.p0, -1);
        Drawable drawableC3 = iM4 != -1 ? pVar2.c(context, iM4) : null;
        int iM5 = t1VarT.m(h.a.j.m0, -1);
        Drawable drawableC4 = iM5 != -1 ? pVar2.c(context, iM5) : null;
        int iM6 = t1VarT.m(h.a.j.q0, -1);
        Drawable drawableC5 = iM6 != -1 ? pVar2.c(context, iM6) : null;
        int iM7 = t1VarT.m(h.a.j.n0, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iM7 != -1 ? pVar2.c(context, iM7) : null);
        int i25 = h.a.j.r0;
        if (t1VarT.r(i25)) {
            androidx.core.widget.m.f(this.a, t1VarT.c(i25));
        }
        int i26 = h.a.j.s0;
        if (t1VarT.r(i26)) {
            i4 = -1;
            androidx.core.widget.m.g(this.a, m0.e(t1VarT.j(i26, -1), null));
        } else {
            i4 = -1;
        }
        int iE = t1VarT.e(h.a.j.u0, i4);
        int iE2 = t1VarT.e(h.a.j.v0, i4);
        int iE3 = t1VarT.e(h.a.j.w0, i4);
        t1VarT.v();
        if (iE != i4) {
            androidx.core.widget.m.h(this.a, iE);
        }
        if (iE2 != i4) {
            androidx.core.widget.m.i(this.a, iE2);
        }
        if (iE3 != i4) {
            androidx.core.widget.m.j(this.a, iE3);
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f156m) {
            this.f155l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (h.e.j.s0.J(textView)) {
                    textView.post(new e0(this, textView, typeface, this.f153j));
                } else {
                    textView.setTypeface(typeface, this.f153j);
                }
            }
        }
    }

    void o(boolean z, int i2, int i3, int i4, int i5) {
        if (androidx.core.widget.d.a) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i2) {
        String strN;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        t1 t1VarS = t1.s(context, i2, h.a.j.J2);
        int i3 = h.a.j.U2;
        if (t1VarS.r(i3)) {
            s(t1VarS.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = h.a.j.N2;
            if (t1VarS.r(i5) && (colorStateListC3 = t1VarS.c(i5)) != null) {
                this.a.setTextColor(colorStateListC3);
            }
            int i6 = h.a.j.P2;
            if (t1VarS.r(i6) && (colorStateListC2 = t1VarS.c(i6)) != null) {
                this.a.setLinkTextColor(colorStateListC2);
            }
            int i7 = h.a.j.O2;
            if (t1VarS.r(i7) && (colorStateListC = t1VarS.c(i7)) != null) {
                this.a.setHintTextColor(colorStateListC);
            }
        }
        int i8 = h.a.j.K2;
        if (t1VarS.r(i8) && t1VarS.e(i8, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, t1VarS);
        if (i4 >= 26) {
            int i9 = h.a.j.T2;
            if (t1VarS.r(i9) && (strN = t1VarS.n(i9)) != null) {
                this.a.setFontVariationSettings(strN);
            }
        }
        t1VarS.v();
        Typeface typeface = this.f155l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.f153j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        h.e.j.s1.b.f(editorInfo, textView.getText());
    }

    void s(boolean z) {
        this.a.setAllCaps(z);
    }

    void t(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f152i.u(i2, i3, i4, i5);
    }

    void u(int[] iArr, int i2) throws IllegalArgumentException {
        this.f152i.v(iArr, i2);
    }

    void v(int i2) throws IllegalArgumentException {
        this.f152i.w(i2);
    }

    void w(ColorStateList colorStateList) {
        if (this.f151h == null) {
            this.f151h = new r1();
        }
        r1 r1Var = this.f151h;
        r1Var.a = colorStateList;
        r1Var.d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f151h == null) {
            this.f151h = new r1();
        }
        r1 r1Var = this.f151h;
        r1Var.b = mode;
        r1Var.c = mode != null;
        z();
    }
}
