package com.airbnb.lottie.v0.l;

import android.graphics.Paint;

/* loaded from: classes.dex */
public enum t {
    BUTT,
    ROUND,
    UNKNOWN;

    public Paint.Cap a() {
        int i2 = s.a[ordinal()];
        return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
    }
}
