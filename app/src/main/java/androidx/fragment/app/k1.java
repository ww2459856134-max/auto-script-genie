package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class k1 implements Parcelable {
    public static final Parcelable.Creator<k1> CREATOR = new j1();
    String c;
    int d;

    k1(String str, int i2) {
        this.c = str;
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
    }

    k1(Parcel parcel) {
        this.c = parcel.readString();
        this.d = parcel.readInt();
    }
}
