package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends AbstractMultiSelectListPreference {
    private CharSequence[] s0;
    private CharSequence[] t0;
    private Set<String> u0;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.u0 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.B, i2, i3);
        this.s0 = androidx.core.content.c.r.q(typedArrayObtainStyledAttributes, e0.E, e0.C);
        this.t0 = androidx.core.content.c.r.q(typedArrayObtainStyledAttributes, e0.F, e0.D);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] E0() {
        return this.s0;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] F0() {
        return this.t0;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public Set<String> G0() {
        return this.u0;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public void H0(Set<String> set) {
        this.u0.clear();
        this.u0.addAll(set);
        d0(set);
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        H0(aVar.c);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.c = G0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        H0(v((Set) obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new h();
        Set<String> c;

        a(Parcel parcel) {
            super(parcel);
            int i2 = parcel.readInt();
            this.c = new HashSet();
            String[] strArr = new String[i2];
            parcel.readStringArray(strArr);
            Collections.addAll(this.c, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c.size());
            Set<String> set = this.c;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.b, R.attr.dialogPreferenceStyle));
    }
}
