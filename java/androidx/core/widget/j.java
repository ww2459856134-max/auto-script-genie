package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
class j implements Parcelable.Creator<NestedScrollView.c> {
    j() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NestedScrollView.c createFromParcel(Parcel parcel) {
        return new NestedScrollView.c(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView.c[] newArray(int i2) {
        return new NestedScrollView.c[i2];
    }
}
