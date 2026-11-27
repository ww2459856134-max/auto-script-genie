package org.apache.poi.xssf.usermodel.u2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import n.a.a.q.c.d;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* loaded from: classes.dex */
public class a {
    private CTWorksheet a;

    public a(CTWorksheet cTWorksheet) {
        this.a = cTWorksheet;
        b();
    }

    private void a(CTCols cTCols, CTCol cTCol, TreeSet<CTCol> treeSet) {
        List<CTCol> listJ = j(cTCol, treeSet);
        if (listJ.isEmpty()) {
            treeSet.add(c(cTCols, cTCol));
            return;
        }
        treeSet.removeAll(listJ);
        for (CTCol cTCol2 : listJ) {
            long[] jArrI = i(cTCol, cTCol2);
            CTCol cTColD = d(cTCols, cTCol2, jArrI);
            o(cTCol, cTColD);
            treeSet.add(cTColD);
            CTCol cTCol3 = cTCol2.getMin() < cTCol.getMin() ? cTCol2 : cTCol;
            long[] jArr = {Math.min(cTCol2.getMin(), cTCol.getMin()), jArrI[0] - 1};
            if (jArr[0] <= jArr[1]) {
                treeSet.add(d(cTCols, cTCol3, jArr));
            }
            CTCol cTCol4 = cTCol2.getMax() > cTCol.getMax() ? cTCol2 : cTCol;
            long[] jArr2 = {jArrI[1] + 1, Math.max(cTCol2.getMax(), cTCol.getMax())};
            if (jArr2[0] <= jArr2[1]) {
                treeSet.add(d(cTCols, cTCol4, jArr2));
            }
        }
    }

    private CTCol d(CTCols cTCols, CTCol cTCol, long[] jArr) {
        CTCol cTColC = c(cTCols, cTCol);
        cTColC.setMin(jArr[0]);
        cTColC.setMax(jArr[1]);
        return cTColC;
    }

    private boolean e(CTCols cTCols, long j2, long j3) {
        for (CTCol cTCol : cTCols.getColList()) {
            if (cTCol.getMin() == j2 && cTCol.getMax() == j3) {
                return true;
            }
        }
        return false;
    }

    private long[] i(CTCol cTCol, CTCol cTCol2) {
        return k(cTCol, cTCol2);
    }

    private List<CTCol> j(CTCol cTCol, TreeSet<CTCol> treeSet) {
        CTCol cTColLower = treeSet.lower(cTCol);
        NavigableSet<CTCol> navigableSetTailSet = treeSet;
        if (cTColLower != null) {
            navigableSetTailSet = treeSet.tailSet(cTColLower, n(cTColLower, cTCol));
        }
        ArrayList arrayList = new ArrayList();
        for (CTCol cTCol2 : navigableSetTailSet) {
            if (!n(cTCol, cTCol2)) {
                break;
            }
            arrayList.add(cTCol2);
        }
        return arrayList;
    }

    private long[] k(CTCol cTCol, CTCol cTCol2) {
        return d.a(p(cTCol), p(cTCol2));
    }

    private CTCol l(CTCols cTCols, long j2, long j3, CTCol[] cTColArr) {
        return m(cTCols, j2, j3, cTColArr, false, null);
    }

    private CTCol m(CTCols cTCols, long j2, long j3, CTCol[] cTColArr, boolean z, CTCol cTCol) {
        if (!z && e(cTCols, j2, j3)) {
            return null;
        }
        CTCol cTColInsertNewCol = cTCols.insertNewCol(0);
        cTColInsertNewCol.setMin(j2);
        cTColInsertNewCol.setMax(j3);
        for (CTCol cTCol2 : cTColArr) {
            o(cTCol2, cTColInsertNewCol);
        }
        if (cTCol != null) {
            o(cTCol, cTColInsertNewCol);
        }
        return cTColInsertNewCol;
    }

    private boolean n(CTCol cTCol, CTCol cTCol2) {
        return d.b(p(cTCol), p(cTCol2)) != -1;
    }

    private long[] p(CTCol cTCol) {
        return new long[]{cTCol.getMin(), cTCol.getMax()};
    }

    public void b() {
        TreeSet<CTCol> treeSet = new TreeSet<>(n.a.a.q.c.c.b);
        CTCols cTColsNewInstance = CTCols.Factory.newInstance();
        CTCols[] colsArray = this.a.getColsArray();
        int i2 = 0;
        while (i2 < colsArray.length) {
            Iterator<CTCol> it = colsArray[i2].getColList().iterator();
            while (it.hasNext()) {
                a(cTColsNewInstance, it.next(), treeSet);
            }
            i2++;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            this.a.removeCols(i3);
        }
        cTColsNewInstance.setColArray((CTCol[]) treeSet.toArray(new CTCol[0]));
        this.a.addNewCols();
        this.a.setColsArray(0, cTColsNewInstance);
    }

    public CTCol c(CTCols cTCols, CTCol cTCol) {
        CTCol cTColAddNewCol = cTCols.addNewCol();
        cTColAddNewCol.setMin(cTCol.getMin());
        cTColAddNewCol.setMax(cTCol.getMax());
        o(cTCol, cTColAddNewCol);
        return cTColAddNewCol;
    }

    public int f(long j2) {
        if (g(j2, false) != null) {
            return (int) g(j2, false).getStyle();
        }
        return -1;
    }

    public CTCol g(long j2, boolean z) {
        return h(j2 + 1, z);
    }

    public CTCol h(long j2, boolean z) {
        int i2;
        if (this.a.sizeOfColsArray() == 0) {
            return null;
        }
        char c = 0;
        CTCols colsArray = this.a.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        int i3 = 0;
        while (i3 < length) {
            CTCol cTCol = colArray[i3];
            long min = cTCol.getMin();
            long max = cTCol.getMax();
            if (min <= j2 && max >= j2) {
                if (z) {
                    if (min < j2) {
                        CTCol[] cTColArr = new CTCol[1];
                        cTColArr[c] = cTCol;
                        i2 = 1;
                        l(colsArray, min, j2 - 1, cTColArr);
                    } else {
                        i2 = 1;
                    }
                    if (max > j2) {
                        CTCol[] cTColArr2 = new CTCol[i2];
                        cTColArr2[0] = cTCol;
                        l(colsArray, j2 + 1, max, cTColArr2);
                    }
                    cTCol.setMin(j2);
                    cTCol.setMax(j2);
                }
                return cTCol;
            }
            i3++;
            c = c;
        }
        return null;
    }

    public void o(CTCol cTCol, CTCol cTCol2) {
        if (cTCol.isSetBestFit()) {
            cTCol2.setBestFit(cTCol.getBestFit());
        }
        if (cTCol.isSetCustomWidth()) {
            cTCol2.setCustomWidth(cTCol.getCustomWidth());
        }
        if (cTCol.isSetHidden()) {
            cTCol2.setHidden(cTCol.getHidden());
        }
        if (cTCol.isSetStyle()) {
            cTCol2.setStyle(cTCol.getStyle());
        }
        if (cTCol.isSetWidth()) {
            cTCol2.setWidth(cTCol.getWidth());
        }
        if (cTCol.isSetCollapsed()) {
            cTCol2.setCollapsed(cTCol.getCollapsed());
        }
        if (cTCol.isSetPhonetic()) {
            cTCol2.setPhonetic(cTCol.getPhonetic());
        }
        if (cTCol.isSetOutlineLevel()) {
            cTCol2.setOutlineLevel(cTCol.getOutlineLevel());
        }
    }
}
