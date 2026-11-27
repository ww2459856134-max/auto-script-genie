package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class s1 implements Parcelable {
    public static final Parcelable.Creator<s1> CREATOR = new r1();
    ArrayList<y1> c;
    ArrayList<String> d;
    c[] e;
    int f;
    String g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<String> f276h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<Bundle> f277i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<k1> f278j;

    public s1() {
        this.g = null;
        this.f276h = new ArrayList<>();
        this.f277i = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.c);
        parcel.writeStringList(this.d);
        parcel.writeTypedArray(this.e, i2);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeStringList(this.f276h);
        parcel.writeTypedList(this.f277i);
        parcel.writeTypedList(this.f278j);
    }

    public s1(Parcel parcel) {
        this.g = null;
        this.f276h = new ArrayList<>();
        this.f277i = new ArrayList<>();
        this.c = parcel.createTypedArrayList(y1.CREATOR);
        this.d = parcel.createStringArrayList();
        this.e = (c[]) parcel.createTypedArray(c.CREATOR);
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.f276h = parcel.createStringArrayList();
        this.f277i = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f278j = parcel.createTypedArrayList(k1.CREATOR);
    }
}
