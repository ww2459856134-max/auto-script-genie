package h.g.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class b implements Parcelable.ClassLoaderCreator<c> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return c.d;
        }
        throw new IllegalStateException("superState must be null");
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c[] newArray(int i2) {
        return new c[i2];
    }
}
