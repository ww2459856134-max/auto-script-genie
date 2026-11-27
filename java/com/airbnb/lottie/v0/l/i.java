package com.airbnb.lottie.v0.l;

/* loaded from: classes.dex */
public enum i {
    MERGE,
    ADD,
    SUBTRACT,
    INTERSECT,
    EXCLUDE_INTERSECTIONS;

    public static i a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
    }
}
