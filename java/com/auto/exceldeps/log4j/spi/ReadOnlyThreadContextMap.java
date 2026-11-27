package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.util.StringMap;
import java.util.Map;

/* loaded from: classes.dex */
public interface ReadOnlyThreadContextMap {
    void clear();

    boolean containsKey(String str);

    String get(String str);

    Map<String, String> getCopy();

    Map<String, String> getImmutableMapOrNull();

    StringMap getReadOnlyContextData();

    boolean isEmpty();
}
