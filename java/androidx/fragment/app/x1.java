package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
class x1 implements Parcelable.Creator<y1> {
    x1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public y1 createFromParcel(Parcel parcel) {
        return new y1(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y1[] newArray(int i2) {
        return new y1[i2];
    }
}
