package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
class m1 implements Parcelable.ClassLoaderCreator<SearchView.o> {
    m1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SearchView.o createFromParcel(Parcel parcel) {
        return new SearchView.o(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SearchView.o createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.o(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SearchView.o[] newArray(int i2) {
        return new SearchView.o[i2];
    }
}
