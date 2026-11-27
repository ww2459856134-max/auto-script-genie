package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes.dex */
final class h1 implements Parcelable.Creator<StaggeredGridLayoutManager.d.a> {
    h1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.d.a createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.d.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.d.a[] newArray(int i2) {
        return new StaggeredGridLayoutManager.d.a[i2];
    }
}
