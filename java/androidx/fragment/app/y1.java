package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class y1 implements Parcelable {
    public static final Parcelable.Creator<y1> CREATOR = new x1();
    final boolean A;
    final int C;
    Bundle D;
    final String c;
    final String d;
    final boolean e;
    final int f;
    final int g;

    /* renamed from: h, reason: collision with root package name */
    final String f281h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f282i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f283j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f284k;
    final Bundle t;

    y1(Fragment fragment) {
        this.c = fragment.getClass().getName();
        this.d = fragment.f230h;
        this.e = fragment.G;
        this.f = fragment.U;
        this.g = fragment.V;
        this.f281h = fragment.W;
        this.f282i = fragment.b0;
        this.f283j = fragment.D;
        this.f284k = fragment.a0;
        this.t = fragment.f231i;
        this.A = fragment.Z;
        this.C = fragment.q0.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.c);
        sb.append(" (");
        sb.append(this.d);
        sb.append(")}:");
        if (this.e) {
            sb.append(" fromLayout");
        }
        if (this.g != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.g));
        }
        String str = this.f281h;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f281h);
        }
        if (this.f282i) {
            sb.append(" retainInstance");
        }
        if (this.f283j) {
            sb.append(" removing");
        }
        if (this.f284k) {
            sb.append(" detached");
        }
        if (this.A) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.f281h);
        parcel.writeInt(this.f282i ? 1 : 0);
        parcel.writeInt(this.f283j ? 1 : 0);
        parcel.writeInt(this.f284k ? 1 : 0);
        parcel.writeBundle(this.t);
        parcel.writeInt(this.A ? 1 : 0);
        parcel.writeBundle(this.D);
        parcel.writeInt(this.C);
    }

    y1(Parcel parcel) {
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt() != 0;
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.f281h = parcel.readString();
        this.f282i = parcel.readInt() != 0;
        this.f283j = parcel.readInt() != 0;
        this.f284k = parcel.readInt() != 0;
        this.t = parcel.readBundle();
        this.A = parcel.readInt() != 0;
        this.D = parcel.readBundle();
        this.C = parcel.readInt();
    }
}
