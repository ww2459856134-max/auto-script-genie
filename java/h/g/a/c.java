package h.g.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class c implements Parcelable {
    private final Parcelable c;
    public static final c d = new a();
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* synthetic */ c(a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.c, i2);
    }

    private c() {
        this.c = null;
    }

    protected c(Parcelable parcelable) {
        if (parcelable != null) {
            this.c = parcelable == d ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.c = parcelable == null ? d : parcelable;
    }
}
