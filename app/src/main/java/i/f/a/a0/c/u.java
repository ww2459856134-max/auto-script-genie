package i.f.a.a0.c;

/* loaded from: classes.dex */
public final class u {
    private static final int[] e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final u[] f = b();
    private final int a;
    private final int[] b;
    private final t[] c;
    private final int d;

    private u(int i2, int[] iArr, t... tVarArr) {
        this.a = i2;
        this.b = iArr;
        this.c = tVarArr;
        int iB = tVarArr[0].b();
        int iA = 0;
        for (s sVar : tVarArr[0].a()) {
            iA += sVar.a() * (sVar.b() + iB);
        }
        this.d = iA;
    }

    private static u[] b() {
        return new u[]{new u(1, new int[0], new t(7, new s(1, 19)), new t(10, new s(1, 16)), new t(13, new s(1, 13)), new t(17, new s(1, 9))), new u(2, new int[]{6, 18}, new t(10, new s(1, 34)), new t(16, new s(1, 28)), new t(22, new s(1, 22)), new t(28, new s(1, 16))), new u(3, new int[]{6, 22}, new t(15, new s(1, 55)), new t(26, new s(1, 44)), new t(18, new s(2, 17)), new t(22, new s(2, 13))), new u(4, new int[]{6, 26}, new t(20, new s(1, 80)), new t(18, new s(2, 32)), new t(26, new s(2, 24)), new t(16, new s(4, 9))), new u(5, new int[]{6, 30}, new t(26, new s(1, 108)), new t(24, new s(2, 43)), new t(18, new s(2, 15), new s(2, 16)), new t(22, new s(2, 11), new s(2, 12))), new u(6, new int[]{6, 34}, new t(18, new s(2, 68)), new t(16, new s(4, 27)), new t(24, new s(4, 19)), new t(28, new s(4, 15))), new u(7, new int[]{6, 22, 38}, new t(20, new s(2, 78)), new t(18, new s(4, 31)), new t(18, new s(2, 14), new s(4, 15)), new t(26, new s(4, 13), new s(1, 14))), new u(8, new int[]{6, 24, 42}, new t(24, new s(2, 97)), new t(22, new s(2, 38), new s(2, 39)), new t(22, new s(4, 18), new s(2, 19)), new t(26, new s(4, 14), new s(2, 15))), new u(9, new int[]{6, 26, 46}, new t(30, new s(2, 116)), new t(22, new s(3, 36), new s(2, 37)), new t(20, new s(4, 16), new s(4, 17)), new t(24, new s(4, 12), new s(4, 13))), new u(10, new int[]{6, 28, 50}, new t(18, new s(2, 68), new s(2, 69)), new t(26, new s(4, 43), new s(1, 44)), new t(24, new s(6, 19), new s(2, 20)), new t(28, new s(6, 15), new s(2, 16))), new u(11, new int[]{6, 30, 54}, new t(20, new s(4, 81)), new t(30, new s(1, 50), new s(4, 51)), new t(28, new s(4, 22), new s(4, 23)), new t(24, new s(3, 12), new s(8, 13))), new u(12, new int[]{6, 32, 58}, new t(24, new s(2, 92), new s(2, 93)), new t(22, new s(6, 36), new s(2, 37)), new t(26, new s(4, 20), new s(6, 21)), new t(28, new s(7, 14), new s(4, 15))), new u(13, new int[]{6, 34, 62}, new t(26, new s(4, 107)), new t(22, new s(8, 37), new s(1, 38)), new t(24, new s(8, 20), new s(4, 21)), new t(22, new s(12, 11), new s(4, 12))), new u(14, new int[]{6, 26, 46, 66}, new t(30, new s(3, 115), new s(1, 116)), new t(24, new s(4, 40), new s(5, 41)), new t(20, new s(11, 16), new s(5, 17)), new t(24, new s(11, 12), new s(5, 13))), new u(15, new int[]{6, 26, 48, 70}, new t(22, new s(5, 87), new s(1, 88)), new t(24, new s(5, 41), new s(5, 42)), new t(30, new s(5, 24), new s(7, 25)), new t(24, new s(11, 12), new s(7, 13))), new u(16, new int[]{6, 26, 50, 74}, new t(24, new s(5, 98), new s(1, 99)), new t(28, new s(7, 45), new s(3, 46)), new t(24, new s(15, 19), new s(2, 20)), new t(30, new s(3, 15), new s(13, 16))), new u(17, new int[]{6, 30, 54, 78}, new t(28, new s(1, 107), new s(5, 108)), new t(28, new s(10, 46), new s(1, 47)), new t(28, new s(1, 22), new s(15, 23)), new t(28, new s(2, 14), new s(17, 15))), new u(18, new int[]{6, 30, 56, 82}, new t(30, new s(5, 120), new s(1, 121)), new t(26, new s(9, 43), new s(4, 44)), new t(28, new s(17, 22), new s(1, 23)), new t(28, new s(2, 14), new s(19, 15))), new u(19, new int[]{6, 30, 58, 86}, new t(28, new s(3, 113), new s(4, 114)), new t(26, new s(3, 44), new s(11, 45)), new t(26, new s(17, 21), new s(4, 22)), new t(26, new s(9, 13), new s(16, 14))), new u(20, new int[]{6, 34, 62, 90}, new t(28, new s(3, 107), new s(5, 108)), new t(26, new s(3, 41), new s(13, 42)), new t(30, new s(15, 24), new s(5, 25)), new t(28, new s(15, 15), new s(10, 16))), new u(21, new int[]{6, 28, 50, 72, 94}, new t(28, new s(4, 116), new s(4, 117)), new t(26, new s(17, 42)), new t(28, new s(17, 22), new s(6, 23)), new t(30, new s(19, 16), new s(6, 17))), new u(22, new int[]{6, 26, 50, 74, 98}, new t(28, new s(2, 111), new s(7, 112)), new t(28, new s(17, 46)), new t(30, new s(7, 24), new s(16, 25)), new t(24, new s(34, 13))), new u(23, new int[]{6, 30, 54, 78, 102}, new t(30, new s(4, 121), new s(5, 122)), new t(28, new s(4, 47), new s(14, 48)), new t(30, new s(11, 24), new s(14, 25)), new t(30, new s(16, 15), new s(14, 16))), new u(24, new int[]{6, 28, 54, 80, 106}, new t(30, new s(6, 117), new s(4, 118)), new t(28, new s(6, 45), new s(14, 46)), new t(30, new s(11, 24), new s(16, 25)), new t(30, new s(30, 16), new s(2, 17))), new u(25, new int[]{6, 32, 58, 84, 110}, new t(26, new s(8, 106), new s(4, 107)), new t(28, new s(8, 47), new s(13, 48)), new t(30, new s(7, 24), new s(22, 25)), new t(30, new s(22, 15), new s(13, 16))), new u(26, new int[]{6, 30, 58, 86, 114}, new t(28, new s(10, 114), new s(2, 115)), new t(28, new s(19, 46), new s(4, 47)), new t(28, new s(28, 22), new s(6, 23)), new t(30, new s(33, 16), new s(4, 17))), new u(27, new int[]{6, 34, 62, 90, 118}, new t(30, new s(8, 122), new s(4, 123)), new t(28, new s(22, 45), new s(3, 46)), new t(30, new s(8, 23), new s(26, 24)), new t(30, new s(12, 15), new s(28, 16))), new u(28, new int[]{6, 26, 50, 74, 98, 122}, new t(30, new s(3, 117), new s(10, 118)), new t(28, new s(3, 45), new s(23, 46)), new t(30, new s(4, 24), new s(31, 25)), new t(30, new s(11, 15), new s(31, 16))), new u(29, new int[]{6, 30, 54, 78, 102, 126}, new t(30, new s(7, 116), new s(7, 117)), new t(28, new s(21, 45), new s(7, 46)), new t(30, new s(1, 23), new s(37, 24)), new t(30, new s(19, 15), new s(26, 16))), new u(30, new int[]{6, 26, 52, 78, 104, 130}, new t(30, new s(5, 115), new s(10, 116)), new t(28, new s(19, 47), new s(10, 48)), new t(30, new s(15, 24), new s(25, 25)), new t(30, new s(23, 15), new s(25, 16))), new u(31, new int[]{6, 30, 56, 82, 108, 134}, new t(30, new s(13, 115), new s(3, 116)), new t(28, new s(2, 46), new s(29, 47)), new t(30, new s(42, 24), new s(1, 25)), new t(30, new s(23, 15), new s(28, 16))), new u(32, new int[]{6, 34, 60, 86, 112, 138}, new t(30, new s(17, 115)), new t(28, new s(10, 46), new s(23, 47)), new t(30, new s(10, 24), new s(35, 25)), new t(30, new s(19, 15), new s(35, 16))), new u(33, new int[]{6, 30, 58, 86, 114, 142}, new t(30, new s(17, 115), new s(1, 116)), new t(28, new s(14, 46), new s(21, 47)), new t(30, new s(29, 24), new s(19, 25)), new t(30, new s(11, 15), new s(46, 16))), new u(34, new int[]{6, 34, 62, 90, 118, 146}, new t(30, new s(13, 115), new s(6, 116)), new t(28, new s(14, 46), new s(23, 47)), new t(30, new s(44, 24), new s(7, 25)), new t(30, new s(59, 16), new s(1, 17))), new u(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new t(30, new s(12, 121), new s(7, 122)), new t(28, new s(12, 47), new s(26, 48)), new t(30, new s(39, 24), new s(14, 25)), new t(30, new s(22, 15), new s(41, 16))), new u(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new t(30, new s(6, 121), new s(14, 122)), new t(28, new s(6, 47), new s(34, 48)), new t(30, new s(46, 24), new s(10, 25)), new t(30, new s(2, 15), new s(64, 16))), new u(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new t(30, new s(17, 122), new s(4, 123)), new t(28, new s(29, 46), new s(14, 47)), new t(30, new s(49, 24), new s(10, 25)), new t(30, new s(24, 15), new s(46, 16))), new u(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new t(30, new s(4, 122), new s(18, 123)), new t(28, new s(13, 46), new s(32, 47)), new t(30, new s(48, 24), new s(14, 25)), new t(30, new s(42, 15), new s(32, 16))), new u(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new t(30, new s(20, 117), new s(4, 118)), new t(28, new s(40, 47), new s(7, 48)), new t(30, new s(43, 24), new s(22, 25)), new t(30, new s(10, 15), new s(67, 16))), new u(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new t(30, new s(19, 118), new s(6, 119)), new t(28, new s(18, 47), new s(31, 48)), new t(30, new s(34, 24), new s(34, 25)), new t(30, new s(20, 15), new s(61, 16)))};
    }

    static u c(int i2) {
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        while (true) {
            int[] iArr = e;
            if (i3 >= iArr.length) {
                if (i4 <= 3) {
                    return i(i5);
                }
                return null;
            }
            int i6 = iArr[i3];
            if (i6 == i2) {
                return i(i3 + 7);
            }
            int iE = p.e(i2, i6);
            if (iE < i4) {
                i5 = i3 + 7;
                i4 = iE;
            }
            i3++;
        }
    }

    public static u g(int i2) throws i.f.a.g {
        if (i2 % 4 != 1) {
            throw i.f.a.g.a();
        }
        try {
            return i((i2 - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw i.f.a.g.a();
        }
    }

    public static u i(int i2) {
        if (i2 <= 0 || i2 > 40) {
            throw new IllegalArgumentException();
        }
        return f[i2 - 1];
    }

    i.f.a.v.b a() {
        int iE = e();
        i.f.a.v.b bVar = new i.f.a.v.b(iE);
        bVar.m(0, 0, 9, 9);
        int i2 = iE - 8;
        bVar.m(i2, 0, 8, 9);
        bVar.m(0, i2, 9, 8);
        int length = this.b.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = this.b[i3] - 2;
            for (int i5 = 0; i5 < length; i5++) {
                if ((i3 != 0 || (i5 != 0 && i5 != length - 1)) && (i3 != length - 1 || i5 != 0)) {
                    bVar.m(this.b[i5] - 2, i4, 5, 5);
                }
            }
        }
        int i6 = iE - 17;
        bVar.m(6, 9, 1, i6);
        bVar.m(9, 6, i6, 1);
        if (this.a > 6) {
            int i7 = iE - 11;
            bVar.m(i7, 0, 3, 6);
            bVar.m(0, i7, 6, 3);
        }
        return bVar;
    }

    public int[] d() {
        return this.b;
    }

    public int e() {
        return (this.a * 4) + 17;
    }

    public t f(o oVar) {
        return this.c[oVar.ordinal()];
    }

    public int h() {
        return this.d;
    }

    public int j() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
