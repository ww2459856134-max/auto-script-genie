package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
final class a implements Parcelable.ClassLoaderCreator<DrawerLayout.f> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawerLayout.f createFromParcel(Parcel parcel) {
        return new DrawerLayout.f(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DrawerLayout.f createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.f(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DrawerLayout.f[] newArray(int i2) {
        return new DrawerLayout.f[i2];
    }
}
