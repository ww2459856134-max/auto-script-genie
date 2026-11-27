package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AppCompatSpinner;

/* loaded from: classes.dex */
class b0 implements Parcelable.Creator<AppCompatSpinner.f> {
    b0() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppCompatSpinner.f createFromParcel(Parcel parcel) {
        return new AppCompatSpinner.f(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppCompatSpinner.f[] newArray(int i2) {
        return new AppCompatSpinner.f[i2];
    }
}
