package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.SeekBarPreference;

/* loaded from: classes.dex */
final class f0 implements Parcelable.Creator<SeekBarPreference.c> {
    f0() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SeekBarPreference.c createFromParcel(Parcel parcel) {
        return new SeekBarPreference.c(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SeekBarPreference.c[] newArray(int i2) {
        return new SeekBarPreference.c[i2];
    }
}
