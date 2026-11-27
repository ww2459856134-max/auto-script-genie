package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentTabHost;

/* loaded from: classes.dex */
class d2 implements Parcelable.Creator<FragmentTabHost.a> {
    d2() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentTabHost.a createFromParcel(Parcel parcel) {
        return new FragmentTabHost.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FragmentTabHost.a[] newArray(int i2) {
        return new FragmentTabHost.a[i2];
    }
}
