package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.TwoStatePreference;

/* loaded from: classes.dex */
final class g0 implements Parcelable.Creator<TwoStatePreference.a> {
    g0() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TwoStatePreference.a createFromParcel(Parcel parcel) {
        return new TwoStatePreference.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TwoStatePreference.a[] newArray(int i2) {
        return new TwoStatePreference.a[i2];
    }
}
