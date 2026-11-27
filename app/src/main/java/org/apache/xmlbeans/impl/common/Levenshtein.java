package org.apache.xmlbeans.impl.common;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class Levenshtein {
    public static int distance(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, length + 1, length2 + 1);
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[i2][0] = i2;
        }
        for (int i3 = 0; i3 <= length2; i3++) {
            iArr[0][i3] = i3;
        }
        for (int i4 = 1; i4 <= length; i4++) {
            int i5 = i4 - 1;
            char cCharAt = str.charAt(i5);
            for (int i6 = 1; i6 <= length2; i6++) {
                int i7 = i6 - 1;
                iArr[i4][i6] = minimum(iArr[i5][i6] + 1, iArr[i4][i7] + 1, iArr[i5][i7] + (cCharAt == str2.charAt(i7) ? 0 : 1));
            }
        }
        return iArr[length][length2];
    }

    private static int minimum(int i2, int i3, int i4) {
        if (i3 < i2) {
            i2 = i3;
        }
        return i4 < i2 ? i4 : i2;
    }
}
