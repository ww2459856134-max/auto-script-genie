package com.auto.exceldeps.log4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface Marker extends Serializable {
    Marker addParents(Marker... markerArr);

    boolean equals(Object obj);

    String getName();

    Marker[] getParents();

    boolean hasParents();

    int hashCode();

    boolean isInstanceOf(Marker marker);

    boolean isInstanceOf(String str);

    boolean remove(Marker marker);

    Marker setParents(Marker... markerArr);
}
