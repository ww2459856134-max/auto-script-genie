package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
final class b implements Parcelable.ClassLoaderCreator<ViewPager.m> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewPager.m createFromParcel(Parcel parcel) {
        return new ViewPager.m(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ViewPager.m createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.m(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ViewPager.m[] newArray(int i2) {
        return new ViewPager.m[i2];
    }
}
