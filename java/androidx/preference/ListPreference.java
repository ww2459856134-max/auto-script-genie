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
public class ListPreference extends DialogPreference {
    private CharSequence[] s0;
    private CharSequence[] t0;
    private String u0;
    private String v0;
    private boolean w0;

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.w, i2, i3);
        this.s0 = androidx.core.content.c.r.q(typedArrayObtainStyledAttributes, e0.z, e0.x);
        this.t0 = androidx.core.content.c.r.q(typedArrayObtainStyledAttributes, e0.A, e0.y);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e0.G, i2, i3);
        this.v0 = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes2, e0.n0, e0.O);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int J0() {
        return E0(this.u0);
    }

    public int E0(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.t0) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.t0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] F0() {
        return this.s0;
    }

    public CharSequence G0() {
        CharSequence[] charSequenceArr;
        int iJ0 = J0();
        if (iJ0 < 0 || (charSequenceArr = this.s0) == null) {
            return null;
        }
        return charSequenceArr[iJ0];
    }

    public CharSequence[] H0() {
        return this.t0;
    }

    public String I0() {
        return this.u0;
    }

    public void K0(String str) {
        boolean z = !TextUtils.equals(this.u0, str);
        if (z || !this.w0) {
            this.u0 = str;
            this.w0 = true;
            c0(str);
            if (z) {
                H();
            }
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
        K0(aVar.c);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.c = I0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        K0(u((String) obj));
    }

    @Override // androidx.preference.Preference
    public CharSequence z() {
        CharSequence charSequenceG0 = G0();
        String str = this.v0;
        if (str == null) {
            return super.z();
        }
        Object[] objArr = new Object[1];
        if (charSequenceG0 == null) {
            charSequenceG0 = "";
        }
        objArr[0] = charSequenceG0;
        return String.format(str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new f();
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

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.b, R.attr.dialogPreferenceStyle));
    }
}
