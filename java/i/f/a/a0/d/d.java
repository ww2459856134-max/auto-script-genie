package i.f.a.a0.d;

import i.f.a.r;

/* loaded from: classes.dex */
public final class d extends r {
    private final float c;
    private final int d;

    d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.c);
        return fAbs <= 1.0f || fAbs <= this.c;
    }

    d g(float f, float f2, float f3) {
        int i2 = this.d;
        int i3 = i2 + 1;
        float fC = (i2 * c()) + f2;
        float f4 = i3;
        return new d(fC / f4, ((this.d * d()) + f) / f4, ((this.d * this.c) + f3) / f4, i3);
    }

    int h() {
        return this.d;
    }

    public float i() {
        return this.c;
    }

    private d(float f, float f2, float f3, int i2) {
        super(f, f2);
        this.c = f3;
        this.d = i2;
    }
}
