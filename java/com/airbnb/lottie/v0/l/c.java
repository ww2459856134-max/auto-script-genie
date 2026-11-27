package com.airbnb.lottie.v0.l;

/* loaded from: classes.dex */
public class c {
    private final float[] a;
    private final int[] b;

    public c(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(c cVar, c cVar2, float f) {
        if (cVar.b.length == cVar2.b.length) {
            for (int i2 = 0; i2 < cVar.b.length; i2++) {
                this.a[i2] = com.airbnb.lottie.y0.g.j(cVar.a[i2], cVar2.a[i2], f);
                this.b[i2] = com.airbnb.lottie.y0.b.c(f, cVar.b[i2], cVar2.b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.b.length + " vs " + cVar2.b.length + ")");
    }
}
