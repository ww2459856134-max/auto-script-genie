package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    private List<Preference> m0;
    private boolean n0;
    private int o0;
    private boolean p0;
    private int q0;
    private a r0;
    final h.d.i<String, Long> s0;

    public interface a {
        void a();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.n0 = true;
        this.o0 = 0;
        this.p0 = false;
        this.q0 = Integer.MAX_VALUE;
        this.r0 = null;
        this.s0 = new h.d.i<>();
        new Handler();
        this.m0 = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.v0, i2, i3);
        int i4 = e0.x0;
        this.n0 = androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, i4, i4, true);
        int i5 = e0.w0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            H0(androidx.core.content.c.r.d(typedArrayObtainStyledAttributes, i5, i5, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference A0(CharSequence charSequence) {
        Preference preferenceA0;
        if (TextUtils.equals(o(), charSequence)) {
            return this;
        }
        int iE0 = E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            Preference preferenceD0 = D0(i2);
            String strO = preferenceD0.o();
            if (strO != null && strO.equals(charSequence)) {
                return preferenceD0;
            }
            if ((preferenceD0 instanceof PreferenceGroup) && (preferenceA0 = ((PreferenceGroup) preferenceD0).A0(charSequence)) != null) {
                return preferenceA0;
            }
        }
        return null;
    }

    public int B0() {
        return this.q0;
    }

    public a C0() {
        return this.r0;
    }

    public Preference D0(int i2) {
        return this.m0.get(i2);
    }

    public int E0() {
        return this.m0.size();
    }

    protected boolean F0() {
        return true;
    }

    protected boolean G0(Preference preference) {
        preference.T(this, t0());
        return true;
    }

    public void H0(int i2) {
        if (i2 != Integer.MAX_VALUE && !C()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.q0 = i2;
    }

    @Override // androidx.preference.Preference
    public void I(boolean z) {
        super.I(z);
        int iE0 = E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            D0(i2).T(this, z);
        }
    }

    public void I0(boolean z) {
        this.n0 = z;
    }

    void J0() {
        synchronized (this) {
            Collections.sort(this.m0);
        }
    }

    @Override // androidx.preference.Preference
    public void K() {
        super.K();
        this.p0 = true;
        int iE0 = E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            D0(i2).K();
        }
    }

    @Override // androidx.preference.Preference
    public void Q() {
        super.Q();
        this.p0 = false;
        int iE0 = E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            D0(i2).Q();
        }
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(b.class)) {
            super.U(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        this.q0 = bVar.c;
        super.U(bVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        return new b(super.V(), this.q0);
    }

    @Override // androidx.preference.Preference
    protected void e(Bundle bundle) {
        super.e(bundle);
        int iE0 = E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            D0(i2).e(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void f(Bundle bundle) {
        super.f(bundle);
        int iE0 = E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            D0(i2).f(bundle);
        }
    }

    public void y0(Preference preference) {
        z0(preference);
    }

    public boolean z0(Preference preference) {
        long jF;
        if (this.m0.contains(preference)) {
            return true;
        }
        if (preference.o() != null) {
            PreferenceGroup preferenceGroupR = this;
            while (preferenceGroupR.r() != null) {
                preferenceGroupR = preferenceGroupR.r();
            }
            String strO = preference.o();
            if (preferenceGroupR.A0(strO) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + strO + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.q() == Integer.MAX_VALUE) {
            if (this.n0) {
                int i2 = this.o0;
                this.o0 = i2 + 1;
                preference.p0(i2);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).I0(this.n0);
            }
        }
        int iBinarySearch = Collections.binarySearch(this.m0, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        if (!G0(preference)) {
            return false;
        }
        synchronized (this) {
            this.m0.add(iBinarySearch, preference);
        }
        t tVarX = x();
        String strO2 = preference.o();
        if (strO2 == null || !this.s0.containsKey(strO2)) {
            jF = tVarX.f();
        } else {
            jF = this.s0.get(strO2).longValue();
            this.s0.remove(strO2);
        }
        preference.M(tVarX, jF);
        preference.a(this);
        if (this.p0) {
            preference.K();
        }
        J();
        return true;
    }

    static class b extends Preference.b {
        public static final Parcelable.Creator<b> CREATOR = new n();
        int c;

        b(Parcel parcel) {
            super(parcel);
            this.c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
        }

        b(Parcelable parcelable, int i2) {
            super(parcelable);
            this.c = i2;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
