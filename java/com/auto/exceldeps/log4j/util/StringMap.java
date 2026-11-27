package com.auto.exceldeps.log4j.util;

/* loaded from: classes.dex */
public interface StringMap extends ReadOnlyStringMap {
    void clear();

    boolean equals(Object obj);

    void freeze();

    int hashCode();

    boolean isFrozen();

    void putAll(ReadOnlyStringMap readOnlyStringMap);

    void putValue(String str, Object obj);

    void remove(String str);
}
