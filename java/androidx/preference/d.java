package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.EditTextPreference;

/* loaded from: classes.dex */
final class d implements Parcelable.Creator<EditTextPreference.a> {
    d() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EditTextPreference.a createFromParcel(Parcel parcel) {
        return new EditTextPreference.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EditTextPreference.a[] newArray(int i2) {
        return new EditTextPreference.a[i2];
    }
}
