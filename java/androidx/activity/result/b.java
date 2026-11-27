package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    private final int c;
    private final Intent d;

    public b(int i2, Intent intent) {
        this.c = i2;
        this.d = intent;
    }

    public static String c(int i2) {
        return i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.c) + ", data=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d == null ? 0 : 1);
        Intent intent = this.d;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    b(Parcel parcel) {
        this.c = parcel.readInt();
        this.d = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
