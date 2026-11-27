package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes.dex */
final class i1 implements Parcelable.Creator<StaggeredGridLayoutManager.e> {
    i1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.e createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.e(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.e[] newArray(int i2) {
        return new StaggeredGridLayoutManager.e[i2];
    }
}
