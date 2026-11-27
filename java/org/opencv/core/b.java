package org.opencv.core;

/* loaded from: classes2.dex */
public abstract class b {
    public static final int a = g(1);
    public static final int b = g(2);
    public static final int c;

    static {
        g(3);
        g(4);
        f(1);
        f(2);
        f(3);
        f(4);
        b(1);
        b(2);
        b(3);
        b(4);
        a(1);
        a(2);
        a(3);
        a(4);
        d(1);
        d(2);
        d(3);
        d(4);
        c = c(1);
        c(2);
        c(3);
        c(4);
        e(1);
        e(2);
        e(3);
        e(4);
    }

    public static final int a(int i2) {
        return j(3, i2);
    }

    public static final int b(int i2) {
        return j(2, i2);
    }

    public static final int c(int i2) {
        return j(5, i2);
    }

    public static final int d(int i2) {
        return j(4, i2);
    }

    public static final int e(int i2) {
        return j(6, i2);
    }

    public static final int f(int i2) {
        return j(1, i2);
    }

    public static final int g(int i2) {
        return j(0, i2);
    }

    public static final int h(int i2) {
        return (i2 >> 3) + 1;
    }

    public static final int i(int i2) {
        return i2 & 7;
    }

    public static final int j(int i2, int i3) {
        if (i3 <= 0 || i3 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        }
        if (i2 < 0 || i2 >= 8) {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
        return (i2 & 7) + ((i3 - 1) << 3);
    }

    public static final String k(int i2) {
        String str;
        switch (i(i2)) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_USRTYPE1";
                break;
            default:
                throw new UnsupportedOperationException("Unsupported CvType value: " + i2);
        }
        int iH = h(i2);
        if (iH <= 4) {
            return str + "C" + iH;
        }
        return str + "C(" + iH + ")";
    }
}
