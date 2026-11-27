package com.bumptech.glide.load.y;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f0 {
    private static final String b;
    private static final Map<String, List<e0>> c;
    private Map<String, List<e0>> a = c;

    static {
        String strB = b();
        b = strB;
        HashMap map = new HashMap(2);
        if (!TextUtils.isEmpty(strB)) {
            map.put("User-Agent", Collections.singletonList(new g0(strB)));
        }
        c = Collections.unmodifiableMap(map);
    }

    static String b() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return property;
        }
        int length = property.length();
        StringBuilder sb = new StringBuilder(property.length());
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = property.charAt(i2);
            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                sb.append(cCharAt);
            } else {
                sb.append('?');
            }
        }
        return sb.toString();
    }

    public h0 a() {
        return new h0(this.a);
    }
}
