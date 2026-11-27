package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.PreferenceGroup;

/* loaded from: classes.dex */
final class n implements Parcelable.Creator<PreferenceGroup.b> {
    n() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PreferenceGroup.b createFromParcel(Parcel parcel) {
        return new PreferenceGroup.b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PreferenceGroup.b[] newArray(int i2) {
        return new PreferenceGroup.b[i2];
    }
}
