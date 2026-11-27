package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
class r1 implements Parcelable.Creator<s1> {
    r1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public s1 createFromParcel(Parcel parcel) {
        return new s1(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s1[] newArray(int i2) {
        return new s1[i2];
    }
}
