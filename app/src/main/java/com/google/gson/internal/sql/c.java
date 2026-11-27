package com.google.gson.internal.sql;

import com.google.gson.i0;

/* loaded from: classes.dex */
public abstract class c {
    public static final boolean a;
    public static final i0 b;
    public static final i0 c;
    public static final i0 d;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (z) {
            b = SqlDateTypeAdapter.b;
            c = SqlTimeTypeAdapter.b;
            d = SqlTimestampTypeAdapter.b;
        } else {
            b = null;
            c = null;
            d = null;
        }
    }
}
