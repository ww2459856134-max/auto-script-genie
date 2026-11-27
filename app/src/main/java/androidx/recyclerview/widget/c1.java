package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class c1 implements Parcelable.ClassLoaderCreator<RecyclerView.y> {
    c1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecyclerView.y createFromParcel(Parcel parcel) {
        return new RecyclerView.y(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView.y createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.y(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public RecyclerView.y[] newArray(int i2) {
        return new RecyclerView.y[i2];
    }
}
