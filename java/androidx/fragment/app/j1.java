package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
class j1 implements Parcelable.Creator<k1> {
    j1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k1 createFromParcel(Parcel parcel) {
        return new k1(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k1[] newArray(int i2) {
        return new k1[i2];
    }
}
