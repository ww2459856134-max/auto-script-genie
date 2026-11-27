package i.e.a.j;

/* loaded from: classes.dex */
public final class c {
    private static final c a = new c();

    private c() {
    }

    public static c b() {
        return a;
    }

    public b a(int i2, String str, int i3, int[] iArr, int i4) {
        if (i4 < 4) {
            if (i3 < 0) {
                String strIntern = str.intern();
                return i4 == 3 ? new u(strIntern, null, strIntern, i2, iArr) : i4 == 2 ? new t(strIntern, null, strIntern, i2, iArr[0], iArr[1]) : new s(strIntern, null, strIntern, i2, iArr[0]);
            }
            String strSubstring = str.substring(0, i3);
            String strIntern2 = str.substring(i3 + 1).intern();
            String strIntern3 = strSubstring.intern();
            return i4 == 3 ? new u(str, strIntern3, strIntern2, i2, iArr) : i4 == 2 ? new t(str, strIntern3, strIntern2, i2, iArr[0], iArr[1]) : new s(str, strIntern3, strIntern2, i2, iArr[0]);
        }
        int[] iArr2 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr2[i5] = iArr[i5];
        }
        if (i3 >= 0) {
            return new x(str, str.substring(0, i3).intern(), str.substring(i3 + 1).intern(), i2, iArr2, i4);
        }
        String strIntern4 = str.intern();
        return new x(strIntern4, null, strIntern4, i2, iArr2, i4);
    }
}
