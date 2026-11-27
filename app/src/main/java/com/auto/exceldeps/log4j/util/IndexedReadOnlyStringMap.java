package com.auto.exceldeps.log4j.util;

/* loaded from: classes.dex */
public interface IndexedReadOnlyStringMap extends ReadOnlyStringMap {
    String getKeyAt(int i2);

    <V> V getValueAt(int i2);

    int indexOfKey(String str);
}
