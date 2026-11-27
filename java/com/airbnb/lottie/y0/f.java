package com.airbnb.lottie.y0;

/* loaded from: classes.dex */
public class f {
    private float a;
    private int b;

    public void a(float f) {
        float f2 = this.a + f;
        this.a = f2;
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.a = f2 / 2.0f;
            this.b = i2 / 2;
        }
    }
}
