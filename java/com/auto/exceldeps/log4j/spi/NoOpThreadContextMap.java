package com.auto.exceldeps.log4j.spi;

import java.util.HashMap;
import java.util.Map;
import org.jspecify.annotations.NullMarked;

@NullMarked
/* loaded from: classes.dex */
public class NoOpThreadContextMap implements ThreadContextMap {
    public static final ThreadContextMap INSTANCE = new NoOpThreadContextMap();

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public void clear() {
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap, com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String str) {
        return false;
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public String get(String str) {
        return null;
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public Map<String, String> getCopy() {
        return new HashMap();
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public Map<String, String> getImmutableMapOrNull() {
        return null;
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap, com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean isEmpty() {
        return true;
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public void put(String str, String str2) {
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public void remove(String str) {
    }
}
