package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
class i implements Parcelable.Creator<k> {
    i() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k createFromParcel(Parcel parcel) {
        return new k(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k[] newArray(int i2) {
        return new k[i2];
    }
}
