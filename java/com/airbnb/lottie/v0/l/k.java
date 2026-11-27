package com.airbnb.lottie.v0.l;

/* loaded from: classes.dex */
public enum k {
    STAR(1),
    POLYGON(2);

    private final int c;

    k(int i2) {
        this.c = i2;
    }

    public static k a(int i2) {
        for (k kVar : values()) {
            if (kVar.c == i2) {
                return kVar;
            }
        }
        return null;
    }
}
