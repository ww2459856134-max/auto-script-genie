package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new i();
    private final IntentSender c;
    private final Intent d;
    private final int e;
    private final int f;

    k(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.c = intentSender;
        this.d = intent;
        this.e = i2;
        this.f = i3;
    }

    public Intent a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public IntentSender d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.c, i2);
        parcel.writeParcelable(this.d, i2);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }

    k(Parcel parcel) {
        this.c = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.d = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }
}
