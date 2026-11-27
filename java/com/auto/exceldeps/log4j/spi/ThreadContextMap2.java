package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.util.StringMap;
import java.util.Map;

/* loaded from: classes.dex */
public interface ThreadContextMap2 extends ThreadContextMap {
    StringMap getReadOnlyContextData();

    void putAll(Map<String, String> map);
}
