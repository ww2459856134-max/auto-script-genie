package com.airbnb.lottie.v0.l;

/* loaded from: classes.dex */
public enum w {
    SIMULTANEOUSLY,
    INDIVIDUALLY;

    public static w a(int i2) {
        if (i2 == 1) {
            return SIMULTANEOUSLY;
        }
        if (i2 == 2) {
            return INDIVIDUALLY;
        }
        throw new IllegalArgumentException("Unknown trim path type " + i2);
    }
}
