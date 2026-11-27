package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.Preference;

/* loaded from: classes.dex */
final class j implements Parcelable.Creator<Preference.b> {
    j() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Preference.b createFromParcel(Parcel parcel) {
        return new Preference.b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Preference.b[] newArray(int i2) {
        return new Preference.b[i2];
    }
}
