package com.bumptech.glide.load.y;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class h0 implements d0 {
    private final Map<String, List<e0>> b;
    private volatile Map<String, String> c;

    h0(Map<String, List<e0>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    private String a(List<e0> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strA = list.get(i2).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<e0>> entry : this.b.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h0) {
            return this.b.equals(((h0) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.y.d0
    public Map<String, String> getHeaders() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.c;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.b + '}';
    }
}
