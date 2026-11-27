package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
class a implements Parcelable.Creator<b> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b createFromParcel(Parcel parcel) {
        return new b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b[] newArray(int i2) {
        return new b[i2];
    }
}
