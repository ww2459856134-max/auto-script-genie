package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = aVar.p(iconCompat.a, 1);
        iconCompat.c = aVar.j(iconCompat.c, 2);
        iconCompat.d = aVar.r(iconCompat.d, 3);
        iconCompat.e = aVar.p(iconCompat.e, 4);
        iconCompat.f = aVar.p(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.r(iconCompat.g, 6);
        iconCompat.f206i = aVar.t(iconCompat.f206i, 7);
        iconCompat.f207j = aVar.t(iconCompat.f207j, 8);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.d(aVar.f());
        int i2 = iconCompat.a;
        if (-1 != i2) {
            aVar.F(i2, 1);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i3 = iconCompat.e;
        if (i3 != 0) {
            aVar.F(i3, 4);
        }
        int i4 = iconCompat.f;
        if (i4 != 0) {
            aVar.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f206i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f207j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
