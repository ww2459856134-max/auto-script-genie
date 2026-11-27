package com.airbnb.lottie.v0.l;

import android.graphics.Paint;

/* loaded from: classes.dex */
public enum u {
    MITER,
    ROUND,
    BEVEL;

    public Paint.Join a() {
        int i2 = s.b[ordinal()];
        if (i2 == 1) {
            return Paint.Join.BEVEL;
        }
        if (i2 == 2) {
            return Paint.Join.MITER;
        }
        if (i2 != 3) {
            return null;
        }
        return Paint.Join.ROUND;
    }
}
