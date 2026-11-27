package i.f.a.a0.e;

import i.f.a.a0.c.o;
import i.f.a.a0.c.u;
import i.f.a.t;

/* loaded from: classes.dex */
abstract class f {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(i.f.a.v.a aVar, o oVar, u uVar, int i2, b bVar) throws t {
        c(bVar);
        d(uVar, bVar);
        l(oVar, i2, bVar);
        s(uVar, bVar);
        f(aVar, i2, bVar);
    }

    static int b(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i3);
        int iN2 = i2 << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i3 << (n(iN2) - iN);
        }
        return iN2;
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(u uVar, b bVar) throws t {
        j(bVar);
        e(bVar);
        r(uVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws t {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new t();
        }
        bVar.f(8, bVar.d() - 8, 1);
    }

    static void f(i.f.a.v.a aVar, int i2, b bVar) throws t {
        boolean zG;
        int iE = bVar.e() - 1;
        int iD = bVar.d() - 1;
        int i3 = -1;
        int i4 = 0;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < bVar.d()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = iE - i5;
                    if (o(bVar.b(i6, iD))) {
                        if (i4 < aVar.k()) {
                            zG = aVar.g(i4);
                            i4++;
                        } else {
                            zG = false;
                        }
                        if (i2 != -1 && e.f(i2, i6, iD)) {
                            zG = !zG;
                        }
                        bVar.g(i6, iD, zG);
                    }
                }
                iD += i3;
            }
            i3 = -i3;
            iD += i3;
            iE -= 2;
        }
        if (i4 == aVar.k()) {
            return;
        }
        throw new t("Not all bits consumed: " + i4 + '/' + aVar.k());
    }

    private static void g(int i2, int i3, b bVar) throws t {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!o(bVar.b(i5, i3))) {
                throw new t();
            }
            bVar.f(i5, i3, 0);
        }
    }

    private static void h(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = b[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.f(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void i(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.f(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void j(b bVar) throws t {
        int length = a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i2 = 8;
        while (i2 < bVar.e() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (o(bVar.b(i2, 6))) {
                bVar.f(i2, 6, i4);
            }
            if (o(bVar.b(6, i2))) {
                bVar.f(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void l(o oVar, int i2, b bVar) throws t {
        int iD;
        i.f.a.v.a aVar = new i.f.a.v.a();
        p(oVar, i2, aVar);
        for (int i3 = 0; i3 < aVar.k(); i3++) {
            boolean zG = aVar.g((aVar.k() - 1) - i3);
            int[] iArr = d[i3];
            bVar.g(iArr[0], iArr[1], zG);
            int iE = 8;
            if (i3 < 8) {
                iD = 8;
                iE = (bVar.e() - i3) - 1;
            } else {
                iD = (bVar.d() - 7) + (i3 - 8);
            }
            bVar.g(iE, iD, zG);
        }
    }

    private static void m(int i2, int i3, b bVar) throws t {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!o(bVar.b(i2, i5))) {
                throw new t();
            }
            bVar.f(i2, i5, 0);
        }
    }

    static int n(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    private static boolean o(int i2) {
        return i2 == -1;
    }

    static void p(o oVar, int i2, i.f.a.v.a aVar) throws t {
        if (!g.b(i2)) {
            throw new t("Invalid mask pattern");
        }
        int iB = (oVar.b() << 3) | i2;
        aVar.c(iB, 5);
        aVar.c(b(iB, 1335), 10);
        i.f.a.v.a aVar2 = new i.f.a.v.a();
        aVar2.c(21522, 15);
        aVar.s(aVar2);
        if (aVar.k() == 15) {
            return;
        }
        throw new t("should not happen but we got: " + aVar.k());
    }

    static void q(u uVar, i.f.a.v.a aVar) throws t {
        aVar.c(uVar.j(), 6);
        aVar.c(b(uVar.j(), 7973), 12);
        if (aVar.k() == 18) {
            return;
        }
        throw new t("should not happen but we got: " + aVar.k());
    }

    private static void r(u uVar, b bVar) {
        if (uVar.j() < 2) {
            return;
        }
        int[] iArr = c[uVar.j() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && o(bVar.b(i3, i2))) {
                        h(i3 - 2, i2 - 2, bVar);
                    }
                }
            }
        }
    }

    static void s(u uVar, b bVar) throws t {
        if (uVar.j() < 7) {
            return;
        }
        i.f.a.v.a aVar = new i.f.a.v.a();
        q(uVar, aVar);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean zG = aVar.g(i2);
                i2--;
                bVar.g(i3, (bVar.d() - 11) + i4, zG);
                bVar.g((bVar.d() - 11) + i4, i3, zG);
            }
        }
    }
}
