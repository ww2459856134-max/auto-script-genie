package i.e.a.l;

/* loaded from: classes.dex */
public class o {
    public static final int[] f = new int[256];
    public final int[] a;
    public final int[] b;
    public final int[] c;
    public final int[] d;
    public final int[] e;

    static {
        for (int i2 = 0; i2 <= 25; i2++) {
            int[] iArr = f;
            iArr[i2 + 65] = 1;
            iArr[i2 + 97] = 1;
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            f[i3] = 1;
        }
        int[] iArr2 = f;
        iArr2[10] = 1;
        iArr2[13] = 1;
        iArr2[32] = 1;
        iArr2[45] = 1;
        iArr2[39] = 1;
        iArr2[40] = 1;
        iArr2[41] = 1;
        iArr2[43] = 1;
        iArr2[44] = 1;
        iArr2[46] = 1;
        iArr2[47] = 1;
        iArr2[58] = 1;
        iArr2[61] = 1;
        iArr2[63] = 1;
        iArr2[59] = 1;
        iArr2[33] = 1;
        iArr2[42] = 1;
        iArr2[35] = 1;
        iArr2[64] = 1;
        iArr2[36] = 1;
        iArr2[95] = 1;
        iArr2[37] = 1;
    }

    public o() {
        this(256);
    }

    protected static void a(int[] iArr) {
        e(iArr);
        iArr[9] = 8;
        iArr[60] = 9;
        iArr[38] = 10;
        iArr[39] = 14;
        iArr[34] = 14;
    }

    protected static void b(int[] iArr) {
        e(iArr);
        iArr[39] = 8;
        iArr[34] = 8;
        iArr[60] = 9;
        iArr[62] = 10;
        iArr[93] = 11;
        iArr[37] = 12;
    }

    public static void c(int[] iArr) {
        for (int i2 = 97; i2 <= 122; i2++) {
            iArr[i2] = 3;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            iArr[i3] = 3;
        }
        iArr[95] = 3;
        iArr[58] = 1;
        iArr[45] = 2;
        iArr[46] = 2;
        for (int i4 = 48; i4 <= 57; i4++) {
            iArr[i4] = 2;
        }
    }

    protected static void d(int[] iArr) {
        e(iArr);
        iArr[60] = 9;
        iArr[38] = 10;
        iArr[93] = 11;
    }

    private static void e(int[] iArr) {
        for (int i2 = 0; i2 < 32; i2++) {
            iArr[i2] = 1;
        }
        iArr[13] = 2;
        iArr[10] = 3;
        iArr[9] = 0;
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        d(iArr);
        a(iArr2);
        c(iArr3);
        for (int i2 = 192; i2 <= 255; i2++) {
            if (i2 != 215 && i2 != 247) {
                iArr3[i2] = 3;
            }
        }
        iArr3[183] = 2;
        b(iArr4);
        d(iArr5);
        iArr5[38] = 0;
        iArr5[60] = 0;
        iArr5[93] = 11;
        iArr5[63] = 12;
        iArr5[45] = 13;
    }

    public o(int i2) {
        this.a = new int[i2];
        this.b = new int[i2];
        this.c = new int[i2];
        this.d = new int[i2];
        this.e = new int[i2];
    }
}
