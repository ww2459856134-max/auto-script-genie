package i.e.a.l;

/* loaded from: classes.dex */
public abstract class j {
    public static boolean a(String str, boolean z) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt > ' ' && (!z || cCharAt != 133)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(char[] cArr, int i2, int i3, boolean z) {
        int i4 = i3 + i2;
        while (i2 < i4) {
            char c = cArr[i2];
            if (c > ' ' && (!z || c != 133)) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
