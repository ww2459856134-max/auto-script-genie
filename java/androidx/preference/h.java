package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.MultiSelectListPreference;

/* loaded from: classes.dex */
final class h implements Parcelable.Creator<MultiSelectListPreference.a> {
    h() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MultiSelectListPreference.a createFromParcel(Parcel parcel) {
        return new MultiSelectListPreference.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MultiSelectListPreference.a[] newArray(int i2) {
        return new MultiSelectListPreference.a[i2];
    }
}
