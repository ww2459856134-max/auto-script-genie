package i.e.a.l;

/* loaded from: classes.dex */
public abstract class q {
    public static int a(String str, boolean z) {
        int i2 = 0;
        char cCharAt = str.charAt(0);
        int length = str.length();
        if (cCharAt < 55296 || cCharAt >= 57344) {
            if (z) {
                if (!p.g(cCharAt)) {
                    return 0;
                }
            } else if (!p.e(cCharAt)) {
                return 0;
            }
        } else {
            if (length < 2) {
                return 0;
            }
            if (!b(cCharAt, str.charAt(1))) {
                return 1;
            }
            i2 = 1;
        }
        int i3 = i2 + 1;
        if (z) {
            while (i3 < length) {
                char cCharAt2 = str.charAt(i3);
                if (cCharAt2 >= 55296 && cCharAt2 < 57344) {
                    int i4 = i3 + 1;
                    if (i4 >= length || !b(cCharAt2, str.charAt(i4))) {
                        return i3;
                    }
                    i3 = i4;
                } else if (!p.f(cCharAt2)) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        while (i3 < length) {
            char cCharAt3 = str.charAt(i3);
            if (cCharAt3 >= 55296 && cCharAt3 < 57344) {
                int i5 = i3 + 1;
                if (i5 >= length || !b(cCharAt3, str.charAt(i5))) {
                    return i3;
                }
                i3 = i5;
            } else if (!p.d(cCharAt3)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private static boolean b(char c, char c2) {
        if (c < 56320 && c2 >= 56320 && c2 >= 57344) {
        }
        return false;
    }
}
