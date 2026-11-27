package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
class u1 implements Parcelable.ClassLoaderCreator<Toolbar.g> {
    u1() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Toolbar.g createFromParcel(Parcel parcel) {
        return new Toolbar.g(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Toolbar.g createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.g(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Toolbar.g[] newArray(int i2) {
        return new Toolbar.g[i2];
    }
}
