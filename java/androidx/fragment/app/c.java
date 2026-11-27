package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.f;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();
    final CharSequence A;
    final ArrayList<String> C;
    final ArrayList<String> D;
    final boolean G;
    final int[] c;
    final ArrayList<String> d;
    final int[] e;
    final int[] f;
    final int g;

    /* renamed from: h, reason: collision with root package name */
    final String f245h;

    /* renamed from: i, reason: collision with root package name */
    final int f246i;

    /* renamed from: j, reason: collision with root package name */
    final int f247j;

    /* renamed from: k, reason: collision with root package name */
    final CharSequence f248k;
    final int t;

    public c(a aVar) {
        int size = aVar.a.size();
        this.c = new int[size * 5];
        if (!aVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.d = new ArrayList<>(size);
        this.e = new int[size];
        this.f = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            e2 e2Var = aVar.a.get(i2);
            int i4 = i3 + 1;
            this.c[i3] = e2Var.a;
            ArrayList<String> arrayList = this.d;
            Fragment fragment = e2Var.b;
            arrayList.add(fragment != null ? fragment.f230h : null);
            int[] iArr = this.c;
            int i5 = i4 + 1;
            iArr[i4] = e2Var.c;
            int i6 = i5 + 1;
            iArr[i5] = e2Var.d;
            int i7 = i6 + 1;
            iArr[i6] = e2Var.e;
            iArr[i7] = e2Var.f;
            this.e[i2] = e2Var.g.ordinal();
            this.f[i2] = e2Var.f249h.ordinal();
            i2++;
            i3 = i7 + 1;
        }
        this.g = aVar.f;
        this.f245h = aVar.f251h;
        this.f246i = aVar.s;
        this.f247j = aVar.f252i;
        this.f248k = aVar.f253j;
        this.t = aVar.f254k;
        this.A = aVar.f255l;
        this.C = aVar.f256m;
        this.D = aVar.f257n;
        this.G = aVar.f258o;
    }

    public a a(p1 p1Var) {
        a aVar = new a(p1Var);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.c;
            if (i2 >= iArr.length) {
                aVar.f = this.g;
                aVar.f251h = this.f245h;
                aVar.s = this.f246i;
                aVar.g = true;
                aVar.f252i = this.f247j;
                aVar.f253j = this.f248k;
                aVar.f254k = this.t;
                aVar.f255l = this.A;
                aVar.f256m = this.C;
                aVar.f257n = this.D;
                aVar.f258o = this.G;
                aVar.r(1);
                return aVar;
            }
            e2 e2Var = new e2();
            int i4 = i2 + 1;
            e2Var.a = iArr[i2];
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.c[i4]);
            }
            String str = this.d.get(i3);
            if (str != null) {
                e2Var.b = p1Var.g0(str);
            } else {
                e2Var.b = null;
            }
            e2Var.g = f.b.values()[this.e[i3]];
            e2Var.f249h = f.b.values()[this.f[i3]];
            int[] iArr2 = this.c;
            int i5 = i4 + 1;
            int i6 = iArr2[i4];
            e2Var.c = i6;
            int i7 = i5 + 1;
            int i8 = iArr2[i5];
            e2Var.d = i8;
            int i9 = i7 + 1;
            int i10 = iArr2[i7];
            e2Var.e = i10;
            int i11 = iArr2[i9];
            e2Var.f = i11;
            aVar.b = i6;
            aVar.c = i8;
            aVar.d = i10;
            aVar.e = i11;
            aVar.e(e2Var);
            i3++;
            i2 = i9 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.c);
        parcel.writeStringList(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeIntArray(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.f245h);
        parcel.writeInt(this.f246i);
        parcel.writeInt(this.f247j);
        TextUtils.writeToParcel(this.f248k, parcel, 0);
        parcel.writeInt(this.t);
        TextUtils.writeToParcel(this.A, parcel, 0);
        parcel.writeStringList(this.C);
        parcel.writeStringList(this.D);
        parcel.writeInt(this.G ? 1 : 0);
    }

    public c(Parcel parcel) {
        this.c = parcel.createIntArray();
        this.d = parcel.createStringArrayList();
        this.e = parcel.createIntArray();
        this.f = parcel.createIntArray();
        this.g = parcel.readInt();
        this.f245h = parcel.readString();
        this.f246i = parcel.readInt();
        this.f247j = parcel.readInt();
        this.f248k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.t = parcel.readInt();
        this.A = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.C = parcel.createStringArrayList();
        this.D = parcel.createStringArrayList();
        this.G = parcel.readInt() != 0;
    }
}
