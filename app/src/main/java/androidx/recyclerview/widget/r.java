package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class r {
    private static final Comparator<u> a = new q();

    public static abstract class a {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class b {
        private final List<u> a;
        private final int[] b;
        private final int[] c;
        private final a d;
        private final int e;
        private final int f;
        private final boolean g;

        b(a aVar, List<u> list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.b = iArr;
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = aVar;
            this.e = aVar.getOldListSize();
            this.f = aVar.getNewListSize();
            this.g = z;
            a();
            h();
        }

        private void a() {
            u uVar = this.a.isEmpty() ? null : this.a.get(0);
            if (uVar != null && uVar.a == 0 && uVar.b == 0) {
                return;
            }
            u uVar2 = new u();
            uVar2.a = 0;
            uVar2.b = 0;
            uVar2.d = false;
            uVar2.c = 0;
            uVar2.e = false;
            this.a.add(0, uVar2);
        }

        private void b(List<s> list, s0 s0Var, int i2, int i3, int i4) {
            if (!this.g) {
                s0Var.onInserted(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.c;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    s0Var.onInserted(i2, 1);
                    Iterator<s> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    s0Var.onMoved(j(list, i8, true).b, i2);
                    if (i7 == 4) {
                        s0Var.onChanged(i2, 1, this.d.getChangePayload(i8, i6));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                    }
                    list.add(new s(i6, i2, false));
                }
            }
        }

        private void c(List<s> list, s0 s0Var, int i2, int i3, int i4) {
            if (!this.g) {
                s0Var.onRemoved(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.b;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    s0Var.onRemoved(i2 + i5, 1);
                    Iterator<s> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    s sVarJ = j(list, i8, false);
                    s0Var.onMoved(i2 + i5, sVarJ.b - 1);
                    if (i7 == 4) {
                        s0Var.onChanged(sVarJ.b - 1, 1, this.d.getChangePayload(i6, i8));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                    }
                    list.add(new s(i6, i2 + i5, true));
                }
            }
        }

        private void f(int i2, int i3, int i4) {
            if (this.b[i2 - 1] != 0) {
                return;
            }
            g(i2, i3, i4, false);
        }

        private boolean g(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                u uVar = this.a.get(i4);
                int i8 = uVar.a;
                int i9 = uVar.c;
                int i10 = i8 + i9;
                int i11 = uVar.b + i9;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.d.areItemsTheSame(i12, i5)) {
                            i7 = this.d.areContentsTheSame(i12, i5) ? 8 : 4;
                            this.c[i5] = (i12 << 5) | 16;
                            this.b[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.d.areItemsTheSame(i5, i13)) {
                            i7 = this.d.areContentsTheSame(i5, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.b[i14] = (i13 << 5) | 16;
                            this.c[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                }
                i6 = uVar.a;
                i3 = uVar.b;
                i4--;
            }
            return false;
        }

        private void h() {
            int i2 = this.e;
            int i3 = this.f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                u uVar = this.a.get(size);
                int i4 = uVar.a;
                int i5 = uVar.c;
                int i6 = i4 + i5;
                int i7 = uVar.b + i5;
                if (this.g) {
                    while (i2 > i6) {
                        f(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        i(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < uVar.c; i8++) {
                    int i9 = uVar.a + i8;
                    int i10 = uVar.b + i8;
                    int i11 = this.d.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.b[i9] = (i10 << 5) | i11;
                    this.c[i10] = (i9 << 5) | i11;
                }
                i2 = uVar.a;
                i3 = uVar.b;
            }
        }

        private void i(int i2, int i3, int i4) {
            if (this.c[i3 - 1] != 0) {
                return;
            }
            g(i2, i3, i4, true);
        }

        private static s j(List<s> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                s sVar = list.get(size);
                if (sVar.a == i2 && sVar.c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).b += z ? 1 : -1;
                        size++;
                    }
                    return sVar;
                }
                size--;
            }
            return null;
        }

        public void d(s0 s0Var) {
            c cVar = s0Var instanceof c ? (c) s0Var : new c(s0Var);
            ArrayList arrayList = new ArrayList();
            int i2 = this.e;
            int i3 = this.f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                u uVar = this.a.get(size);
                int i4 = uVar.c;
                int i5 = uVar.a + i4;
                int i6 = uVar.b + i4;
                if (i5 < i2) {
                    c(arrayList, cVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    b(arrayList, cVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.b;
                    int i8 = uVar.a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        cVar.onChanged(i8 + i7, 1, this.d.getChangePayload(i8 + i7, uVar.b + i7));
                    }
                }
                i2 = uVar.a;
                i3 = uVar.b;
            }
            cVar.a();
        }

        public void e(RecyclerView.g gVar) {
            d(new androidx.recyclerview.widget.b(gVar));
        }
    }

    public static b a(a aVar) {
        return b(aVar, true);
    }

    public static b b(a aVar, boolean z) {
        int oldListSize = aVar.getOldListSize();
        int newListSize = aVar.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new t(0, oldListSize, 0, newListSize));
        int iAbs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i2 = iAbs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            t tVar = (t) arrayList2.remove(arrayList2.size() - 1);
            u uVarC = c(aVar, tVar.a, tVar.b, tVar.c, tVar.d, iArr, iArr2, iAbs);
            if (uVarC != null) {
                if (uVarC.c > 0) {
                    arrayList.add(uVarC);
                }
                uVarC.a += tVar.a;
                uVarC.b += tVar.c;
                t tVar2 = arrayList3.isEmpty() ? new t() : (t) arrayList3.remove(arrayList3.size() - 1);
                tVar2.a = tVar.a;
                tVar2.c = tVar.c;
                if (uVarC.e) {
                    tVar2.b = uVarC.a;
                    tVar2.d = uVarC.b;
                } else if (uVarC.d) {
                    tVar2.b = uVarC.a - 1;
                    tVar2.d = uVarC.b;
                } else {
                    tVar2.b = uVarC.a;
                    tVar2.d = uVarC.b - 1;
                }
                arrayList2.add(tVar2);
                if (!uVarC.e) {
                    int i3 = uVarC.a;
                    int i4 = uVarC.c;
                    tVar.a = i3 + i4;
                    tVar.c = uVarC.b + i4;
                } else if (uVarC.d) {
                    int i5 = uVarC.a;
                    int i6 = uVarC.c;
                    tVar.a = i5 + i6 + 1;
                    tVar.c = uVarC.b + i6;
                } else {
                    int i7 = uVarC.a;
                    int i8 = uVarC.c;
                    tVar.a = i7 + i8;
                    tVar.c = uVarC.b + i8 + 1;
                }
                arrayList2.add(tVar);
            } else {
                arrayList3.add(tVar);
            }
        }
        Collections.sort(arrayList, a);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x00cd
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static androidx.recyclerview.widget.u c(androidx.recyclerview.widget.r.a r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r.c(androidx.recyclerview.widget.r$a, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.u");
    }
}
