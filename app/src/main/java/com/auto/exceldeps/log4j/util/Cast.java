package com.auto.exceldeps.log4j.util;

@InternalApi
/* loaded from: classes.dex */
public final class Cast {
    private Cast() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj) {
        if (obj == 0) {
            return null;
        }
        return obj;
    }
}
