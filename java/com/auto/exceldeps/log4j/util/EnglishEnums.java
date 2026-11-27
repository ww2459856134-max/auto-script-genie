package com.auto.exceldeps.log4j.util;

@InternalApi
/* loaded from: classes.dex */
public final class EnglishEnums {
    private EnglishEnums() {
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        return (T) valueOf(cls, str, null);
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str, T t) {
        return str == null ? t : (T) Enum.valueOf(cls, Strings.toRootUpperCase(str));
    }
}
