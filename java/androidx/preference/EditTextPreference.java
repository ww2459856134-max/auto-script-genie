package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    private String s0;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public String E0() {
        return this.s0;
    }

    public void F0(String str) {
        boolean zT0 = t0();
        this.s0 = str;
        c0(str);
        boolean zT02 = t0();
        if (zT02 != zT0) {
            I(zT02);
        }
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        F0(aVar.c);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.c = E0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        F0(u((String) obj));
    }

    @Override // androidx.preference.Preference
    public boolean t0() {
        return TextUtils.isEmpty(this.s0) || super.t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new d();
        String c;

        public a(Parcel parcel) {
            super(parcel);
            this.c = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.c);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.d, R.attr.editTextPreferenceStyle));
    }
}
