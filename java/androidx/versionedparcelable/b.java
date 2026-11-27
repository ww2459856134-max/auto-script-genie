package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends a {
    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final String f402h;

    /* renamed from: i, reason: collision with root package name */
    private int f403i;

    /* renamed from: j, reason: collision with root package name */
    private int f404j;

    /* renamed from: k, reason: collision with root package name */
    private int f405k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new h.d.b(), new h.d.b(), new h.d.b());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.e.writeInt(-1);
        } else {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i2) {
        this.e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i2 = this.f403i;
        if (i2 >= 0) {
            int i3 = this.d.get(i2);
            int iDataPosition = this.e.dataPosition();
            this.e.setDataPosition(i3);
            this.e.writeInt(iDataPosition - i3);
            this.e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f404j;
        if (i2 == this.f) {
            i2 = this.g;
        }
        return new b(parcel, iDataPosition, i2, this.f402h + "  ", this.a, this.b, this.c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i2 = this.e.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i2) {
        while (this.f404j < this.g) {
            int i3 = this.f405k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.f404j);
            int i4 = this.e.readInt();
            this.f405k = this.e.readInt();
            this.f404j += i4;
        }
        return this.f405k == i2;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i2) {
        a();
        this.f403i = i2;
        this.d.put(i2, this.e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z) {
        this.e.writeInt(z ? 1 : 0);
    }

    private b(Parcel parcel, int i2, int i3, String str, h.d.b<String, Method> bVar, h.d.b<String, Method> bVar2, h.d.b<String, Class> bVar3) {
        super(bVar, bVar2, bVar3);
        this.d = new SparseIntArray();
        this.f403i = -1;
        this.f404j = 0;
        this.f405k = -1;
        this.e = parcel;
        this.f = i2;
        this.g = i3;
        this.f404j = i2;
        this.f402h = str;
    }
}
