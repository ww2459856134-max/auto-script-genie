package com.airbnb.lottie.x0.l0;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
abstract class f {
    static String a(int i2, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(iArr2[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(NameUtil.PERIOD);
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }
}
