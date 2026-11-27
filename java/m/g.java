package m;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class g extends AbstractList<d> implements RandomAccess {
    final d[] c;
    final int[] d;

    private g(d[] dVarArr, int[] iArr) {
        this.c = dVarArr;
        this.d = iArr;
    }

    private static void a(long j2, a aVar, int i2, List<d> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        int i7;
        a aVar2;
        int i8 = i3;
        if (i8 >= i4) {
            throw new AssertionError();
        }
        for (int i9 = i8; i9 < i4; i9++) {
            if (list.get(i9).size() < i2) {
                throw new AssertionError();
            }
        }
        d dVar = list.get(i3);
        d dVar2 = list.get(i4 - 1);
        int iIntValue = -1;
        if (i2 == dVar.size()) {
            iIntValue = list2.get(i8).intValue();
            i8++;
            dVar = list.get(i8);
        }
        int i10 = i8;
        if (dVar.d(i2) == dVar2.d(i2)) {
            int i11 = 0;
            int iMin = Math.min(dVar.size(), dVar2.size());
            for (int i12 = i2; i12 < iMin && dVar.d(i12) == dVar2.d(i12); i12++) {
                i11++;
            }
            long jE = 1 + j2 + e(aVar) + 2 + i11;
            aVar.J(-i11);
            aVar.J(iIntValue);
            int i13 = i2;
            while (true) {
                i5 = i2 + i11;
                if (i13 >= i5) {
                    break;
                }
                aVar.J(dVar.d(i13) & 255);
                i13++;
            }
            if (i10 + 1 == i4) {
                if (i5 != list.get(i10).size()) {
                    throw new AssertionError();
                }
                aVar.J(list2.get(i10).intValue());
                return;
            } else {
                a aVar3 = new a();
                aVar.J((int) ((e(aVar3) + jE) * (-1)));
                a(jE, aVar3, i5, list, i10, i4, list2);
                aVar.H(aVar3, aVar3.size());
                return;
            }
        }
        int i14 = 1;
        for (int i15 = i10 + 1; i15 < i4; i15++) {
            if (list.get(i15 - 1).d(i2) != list.get(i15).d(i2)) {
                i14++;
            }
        }
        long jE2 = j2 + e(aVar) + 2 + (i14 * 2);
        aVar.J(i14);
        aVar.J(iIntValue);
        for (int i16 = i10; i16 < i4; i16++) {
            byte bD = list.get(i16).d(i2);
            if (i16 == i10 || bD != list.get(i16 - 1).d(i2)) {
                aVar.J(bD & 255);
            }
        }
        a aVar4 = new a();
        int i17 = i10;
        while (i17 < i4) {
            byte bD2 = list.get(i17).d(i2);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i4) {
                    i6 = i4;
                    break;
                } else {
                    if (bD2 != list.get(i19).d(i2)) {
                        i6 = i19;
                        break;
                    }
                    i19++;
                }
            }
            if (i18 == i6 && i2 + 1 == list.get(i17).size()) {
                aVar.J(list2.get(i17).intValue());
                i7 = i6;
                aVar2 = aVar4;
            } else {
                aVar.J((int) ((e(aVar4) + jE2) * (-1)));
                i7 = i6;
                aVar2 = aVar4;
                a(jE2, aVar4, i2 + 1, list, i17, i6, list2);
            }
            aVar4 = aVar2;
            i17 = i7;
        }
        a aVar5 = aVar4;
        aVar.H(aVar5, aVar5.size());
    }

    private static int e(a aVar) {
        return (int) (aVar.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static g g(d... dVarArr) {
        if (dVarArr.length == 0) {
            return new g(new d[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(dVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(-1);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, dVarArr[i3]), Integer.valueOf(i3));
        }
        if (((d) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i4 = 0;
        while (i4 < arrayList.size()) {
            d dVar = (d) arrayList.get(i4);
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < arrayList.size()) {
                d dVar2 = (d) arrayList.get(i6);
                if (!dVar2.k(dVar)) {
                    break;
                }
                if (dVar2.size() == dVar.size()) {
                    throw new IllegalArgumentException("duplicate option: " + dVar2);
                }
                if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                    arrayList.remove(i6);
                    arrayList2.remove(i6);
                } else {
                    i6++;
                }
            }
            i4 = i5;
        }
        a aVar = new a();
        a(0L, aVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iE = e(aVar);
        int[] iArr = new int[iE];
        for (int i7 = 0; i7 < iE; i7++) {
            iArr[i7] = aVar.u();
        }
        if (aVar.d()) {
            return new g((d[]) dVarArr.clone(), iArr);
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d get(int i2) {
        return this.c[i2];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.length;
    }
}
