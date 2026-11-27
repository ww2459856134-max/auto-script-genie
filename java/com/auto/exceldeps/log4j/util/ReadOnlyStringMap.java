package com.auto.exceldeps.log4j.util;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public interface ReadOnlyStringMap extends Serializable {
    boolean containsKey(String str);

    <V> void forEach(BiConsumer<String, ? super V> biConsumer);

    <V, S> void forEach(TriConsumer<String, ? super V, S> triConsumer, S s);

    <V> V getValue(String str);

    boolean isEmpty();

    int size();

    Map<String, String> toMap();
}
