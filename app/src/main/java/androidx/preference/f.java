package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.ListPreference;

/* loaded from: classes.dex */
final class f implements Parcelable.Creator<ListPreference.a> {
    f() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListPreference.a createFromParcel(Parcel parcel) {
        return new ListPreference.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ListPreference.a[] newArray(int i2) {
        return new ListPreference.a[i2];
    }
}
