package i.f.a.y.r.g;

import androidx.recyclerview.widget.k0;
import i.f.a.e;
import i.f.a.g;
import i.f.a.k;
import i.f.a.p;
import i.f.a.r;
import i.f.a.y.r.f;
import i.f.a.y.r.g.e.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* loaded from: classes.dex */
public final class d extends i.f.a.y.r.a {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f1714k = {7, 5, 4, 3, 1};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f1715l = {4, 20, 52, 104, 204};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f1716m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n, reason: collision with root package name */
    private static final int[][] f1717n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: o, reason: collision with root package name */
    private static final int[][] f1718o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{STBorder.INT_CUSTOM, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, k0.a.DEFAULT_DRAG_ANIMATION_DURATION, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, STBorder.INT_ZIG_ZAG, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<b> g = new ArrayList(11);

    /* renamed from: h, reason: collision with root package name */
    private final List<c> f1719h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final int[] f1720i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    private boolean f1721j;

    private static boolean A(i.f.a.y.r.c cVar, boolean z, boolean z2) {
        return (cVar.c() == 0 && z && z2) ? false : true;
    }

    private static boolean B(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<c> it = iterable2.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            c next = it.next();
            Iterator<b> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                b next2 = it2.next();
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    private static boolean C(List<b> list) {
        boolean z;
        for (int[] iArr : p) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    }
                    if (list.get(i2).a().c() != iArr[i2]) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private i.f.a.y.r.c D(i.f.a.v.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.f1720i[0] - 1;
            while (i6 >= 0 && !aVar.g(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.f1720i;
            i5 = iArr[0] - i7;
            i3 = iArr[1];
            i4 = i7;
        } else {
            int[] iArr2 = this.f1720i;
            int i8 = iArr2[0];
            int iJ = aVar.j(iArr2[1] + 1);
            i3 = iJ;
            i4 = i8;
            i5 = iJ - this.f1720i[1];
        }
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i5;
        try {
            return new i.f.a.y.r.c(i.f.a.y.r.a.q(iArrJ, f1717n), new int[]{i4, i3}, i4, i3, i2);
        } catch (k unused) {
            return null;
        }
    }

    private static void E(Collection<b> collection, Collection<c> collection2) {
        Iterator<c> it = collection2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != collection.size()) {
                boolean z = true;
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!collection.contains(it2.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static void G(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private void H(int i2) {
        boolean zC;
        int i3 = 0;
        boolean zC2 = false;
        while (true) {
            if (i3 >= this.f1719h.size()) {
                zC = false;
                break;
            }
            c cVar = this.f1719h.get(i3);
            if (cVar.b() > i2) {
                zC = cVar.c(this.g);
                break;
            } else {
                zC2 = cVar.c(this.g);
                i3++;
            }
        }
        if (zC || zC2 || B(this.g, this.f1719h)) {
            return;
        }
        this.f1719h.add(i3, new c(this.g, i2, false));
        E(this.g, this.f1719h);
    }

    private void r(int i2) throws k {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int iD = i.f.a.v.m.a.d(m());
        int iD2 = i.f.a.v.m.a.d(k());
        boolean z5 = true;
        if (iD > 13) {
            z = false;
            z2 = true;
        } else if (iD < 4) {
            z2 = false;
            z = true;
        } else {
            z = false;
            z2 = false;
        }
        if (iD2 > 13) {
            z3 = false;
            z4 = true;
        } else if (iD2 < 4) {
            z4 = false;
            z3 = true;
        } else {
            z3 = false;
            z4 = false;
        }
        int i3 = (iD + iD2) - i2;
        boolean z6 = (iD & 1) == 1;
        boolean z7 = (iD2 & 1) == 0;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    throw k.a();
                }
                if (z6) {
                    if (z7) {
                        throw k.a();
                    }
                    z2 = true;
                } else {
                    if (!z7) {
                        throw k.a();
                    }
                    z4 = true;
                }
            } else if (z6) {
                if (!z7) {
                    throw k.a();
                }
                if (iD < iD2) {
                    z4 = true;
                } else {
                    z3 = true;
                    z2 = true;
                }
            } else if (z7) {
                throw k.a();
            }
            z5 = z;
        } else if (z6) {
            if (z7) {
                throw k.a();
            }
        } else {
            if (!z7) {
                throw k.a();
            }
            z3 = true;
            z5 = z;
        }
        if (z5) {
            if (z2) {
                throw k.a();
            }
            i.f.a.y.r.a.o(m(), n());
        }
        if (z2) {
            i.f.a.y.r.a.h(m(), n());
        }
        if (z3) {
            if (z4) {
                throw k.a();
            }
            i.f.a.y.r.a.o(k(), n());
        }
        if (z4) {
            i.f.a.y.r.a.h(k(), l());
        }
    }

    private boolean s() {
        b bVar = this.g.get(0);
        i.f.a.y.r.b bVarB = bVar.b();
        i.f.a.y.r.b bVarC = bVar.c();
        if (bVarC == null) {
            return false;
        }
        int iA = bVarC.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.g.size(); i3++) {
            b bVar2 = this.g.get(i3);
            iA += bVar2.b().a();
            i2++;
            i.f.a.y.r.b bVarC2 = bVar2.c();
            if (bVarC2 != null) {
                iA += bVarC2.a();
                i2++;
            }
        }
        return ((i2 + (-4)) * 211) + (iA % 211) == bVarB.b();
    }

    private List<b> t(List<c> list, int i2) throws k {
        while (i2 < this.f1719h.size()) {
            c cVar = this.f1719h.get(i2);
            this.g.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.g.addAll(it.next().a());
            }
            this.g.addAll(cVar.a());
            if (C(this.g)) {
                if (s()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i2 + 1);
                } catch (k unused) {
                    continue;
                }
            }
            i2++;
        }
        throw k.a();
    }

    private List<b> u(boolean z) {
        List<b> listT = null;
        if (this.f1719h.size() > 25) {
            this.f1719h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.f1719h);
        }
        try {
            listT = t(new ArrayList(), 0);
        } catch (k unused) {
        }
        if (z) {
            Collections.reverse(this.f1719h);
        }
        return listT;
    }

    static p v(List<b> list) throws k, g {
        String strD = j.a(a.a(list)).d();
        r[] rVarArrA = list.get(0).a().a();
        r[] rVarArrA2 = list.get(list.size() - 1).a().a();
        return new p(strD, null, new r[]{rVarArrA[0], rVarArrA[1], rVarArrA2[0], rVarArrA2[1]}, i.f.a.a.RSS_EXPANDED);
    }

    private void y(i.f.a.v.a aVar, List<b> list, int i2) throws k {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iK = aVar.k();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.f1721j) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < iK) {
            z2 = !aVar.g(i2);
            if (!z2) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = 0;
        boolean z3 = z2;
        int i4 = i2;
        while (i2 < iK) {
            if (aVar.g(i2) != z3) {
                iArrJ[i3] = iArrJ[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        G(iArrJ);
                    }
                    if (i.f.a.y.r.a.p(iArrJ)) {
                        int[] iArr = this.f1720i;
                        iArr[0] = i4;
                        iArr[1] = i2;
                        return;
                    }
                    if (z) {
                        G(iArrJ);
                    }
                    i4 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArrJ[i3] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw k.a();
    }

    private static int z(i.f.a.v.a aVar, int i2) {
        return aVar.g(i2) ? aVar.i(aVar.j(i2)) : aVar.j(aVar.i(i2));
    }

    b F(i.f.a.v.a aVar, List<b> list, int i2) throws k {
        i.f.a.y.r.c cVarD;
        i.f.a.y.r.b bVarW;
        boolean z = list.size() % 2 == 0;
        if (this.f1721j) {
            z = !z;
        }
        int iZ = -1;
        boolean z2 = true;
        do {
            y(aVar, list, iZ);
            cVarD = D(aVar, i2, z);
            if (cVarD == null) {
                iZ = z(aVar, this.f1720i[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        i.f.a.y.r.b bVarW2 = w(aVar, cVarD, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw k.a();
        }
        try {
            bVarW = w(aVar, cVarD, z, false);
        } catch (k unused) {
            bVarW = null;
        }
        return new b(bVarW2, bVarW, cVarD);
    }

    @Override // i.f.a.y.k, i.f.a.n
    public void b() {
        this.g.clear();
        this.f1719h.clear();
    }

    @Override // i.f.a.y.k
    public p c(int i2, i.f.a.v.a aVar, Map<e, ?> map) throws k, g {
        this.g.clear();
        this.f1721j = false;
        try {
            return v(x(i2, aVar));
        } catch (k unused) {
            this.g.clear();
            this.f1721j = true;
            return v(x(i2, aVar));
        }
    }

    i.f.a.y.r.b w(i.f.a.v.a aVar, i.f.a.y.r.c cVar, boolean z, boolean z2) throws k {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z2) {
            i.f.a.y.k.g(aVar, cVar.b()[0], iArrI);
        } else {
            i.f.a.y.k.f(aVar, cVar.b()[1], iArrI);
            int i2 = 0;
            for (int length = iArrI.length - 1; i2 < length; length--) {
                int i3 = iArrI[i2];
                iArrI[i2] = iArrI[length];
                iArrI[length] = i3;
                i2++;
            }
        }
        float fD = i.f.a.v.m.a.d(iArrI) / 17.0f;
        float f = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f) / f > 0.3f) {
            throw k.a();
        }
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i4 = 0; i4 < iArrI.length; i4++) {
            float f2 = (iArrI[i4] * 1.0f) / fD;
            int i5 = (int) (0.5f + f2);
            if (i5 <= 0) {
                if (f2 < 0.3f) {
                    throw k.a();
                }
                i5 = 1;
            } else if (i5 > 8) {
                if (f2 > 8.7f) {
                    throw k.a();
                }
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArrM[i6] = i5;
                fArrN[i6] = f2 - i5;
            } else {
                iArrK[i6] = i5;
                fArrL[i6] = f2 - i5;
            }
        }
        r(17);
        int iC = (((cVar.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i7 = 0;
        int i8 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z, z2)) {
                i7 += iArrM[length2] * f1718o[iC][length2 * 2];
            }
            i8 += iArrM[length2];
        }
        int i9 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z, z2)) {
                i9 += iArrK[length3] * f1718o[iC][(length3 * 2) + 1];
            }
        }
        int i10 = i7 + i9;
        if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
            throw k.a();
        }
        int i11 = (13 - i8) / 2;
        int i12 = f1714k[i11];
        return new i.f.a.y.r.b((f.b(iArrM, i12, true) * f1715l[i11]) + f.b(iArrK, 9 - i12, false) + f1716m[i11], i10);
    }

    List<b> x(int i2, i.f.a.v.a aVar) throws k {
        boolean z = false;
        while (!z) {
            try {
                List<b> list = this.g;
                list.add(F(aVar, list, i2));
            } catch (k e) {
                if (this.g.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (s()) {
            return this.g;
        }
        boolean z2 = !this.f1719h.isEmpty();
        H(i2);
        if (z2) {
            List<b> listU = u(false);
            if (listU != null) {
                return listU;
            }
            List<b> listU2 = u(true);
            if (listU2 != null) {
                return listU2;
            }
        }
        throw k.a();
    }
}
