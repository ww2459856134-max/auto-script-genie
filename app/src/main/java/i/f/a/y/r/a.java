package i.f.a.y.r;

import i.f.a.y.k;

/* loaded from: classes.dex */
public abstract class a extends k {
    private final int[] b;
    private final int[] e;
    private final int[] f;
    private final int[] a = new int[4];
    private final float[] c = new float[4];
    private final float[] d = new float[4];

    protected a() {
        int[] iArr = new int[8];
        this.b = iArr;
        this.e = new int[iArr.length / 2];
        this.f = new int[iArr.length / 2];
    }

    protected static void h(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f) {
                f = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static void o(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f) {
                f = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static boolean p(int[] iArr) {
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int q(int[] iArr, int[][] iArr2) throws i.f.a.k {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (k.e(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw i.f.a.k.a();
    }

    protected final int[] i() {
        return this.b;
    }

    protected final int[] j() {
        return this.a;
    }

    protected final int[] k() {
        return this.f;
    }

    protected final float[] l() {
        return this.d;
    }

    protected final int[] m() {
        return this.e;
    }

    protected final float[] n() {
        return this.c;
    }
}
