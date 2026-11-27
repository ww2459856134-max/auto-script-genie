package org.apache.poi.xssf.usermodel;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import n.a.a.j.c;
import n.a.a.n.d.o0;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

/* loaded from: classes.dex */
public class i2 extends n.a.a.j.c implements n.a.a.n.d.p0 {
    private static final Logger A = n.a.a.i.b.a(i2.class);
    protected CTSheet c;
    protected CTWorksheet d;
    private final SortedMap<Integer, f2> e;
    private List<s1> f;
    private org.apache.poi.xssf.usermodel.u2.a g;

    /* renamed from: h, reason: collision with root package name */
    private n.a.a.q.b.b f2557h;

    /* renamed from: i, reason: collision with root package name */
    private Map<Integer, CTCellFormula> f2558i;

    /* renamed from: j, reason: collision with root package name */
    private SortedMap<String, k2> f2559j;

    /* renamed from: k, reason: collision with root package name */
    private List<n.a.a.n.e.m> f2560k;
    private n.a.a.n.e.m t;

    protected i2() {
        this.e = new TreeMap();
        onDocumentCreate();
    }

    static void I(i2 i2Var) {
        String strZ;
        for (k2 k2Var : i2Var.a0()) {
            k2 k2VarL = k2Var.b0(k2Var.J()) ? i2Var.L(k2Var.J()) : null;
            if (k2VarL != null) {
                k2VarL.c0();
                k2VarL.a0(k2Var.Q());
                n2 n2Var = (n2) k2Var.P();
                n2 n2Var2 = (n2) k2VarL.P();
                if (n2Var != null && n2Var2 != null) {
                    n2Var2.g(n2Var.a());
                    n2Var2.h(n2Var.d());
                    n2Var2.e(n2Var.b());
                    n2Var2.f(n2Var.c());
                }
                k2VarL.K().setAutoFilter(k2Var.K().getAutoFilter());
                int totalsRowCount = k2Var.getTotalsRowCount();
                if (totalsRowCount == 1) {
                    f2 f2VarF = i2Var.f(k2VarL.N().m());
                    if (k2VarL.K().getTableColumns() != null && !k2VarL.K().getTableColumns().getTableColumnList().isEmpty()) {
                        k2VarL.K().setTotalsRowCount(totalsRowCount);
                        for (int i2 = 0; i2 < k2VarL.K().getTableColumns().getTableColumnList().size(); i2++) {
                            CTTableColumn cTTableColumn = k2Var.K().getTableColumns().getTableColumnList().get(i2);
                            CTTableColumn cTTableColumn2 = k2VarL.K().getTableColumns().getTableColumnList().get(i2);
                            cTTableColumn2.setTotalsRowFunction(cTTableColumn.getTotalsRowFunction());
                            int iIntValue = cTTableColumn2.getTotalsRowFunction().intValue();
                            i2Var.getWorkbook().setCellFormulaValidation(false);
                            if (iIntValue == 10) {
                                CTTableFormula totalsRowFormula = cTTableColumn.getTotalsRowFormula();
                                cTTableColumn2.setTotalsRowFormula(totalsRowFormula);
                                f2VarF.x(k2VarL.O().l() + i2).r(totalsRowFormula.getStringValue());
                            } else if (iIntValue != 1 && (strZ = Z(iIntValue)) != null) {
                                f2VarF.x(k2VarL.O().l() + i2).r(strZ + "," + k2VarL.getName() + "[" + cTTableColumn2.getName() + "])");
                            }
                        }
                    }
                }
                if (k2VarL.K().getTableColumns() != null && !k2VarL.K().getTableColumns().getTableColumnList().isEmpty()) {
                    k2VarL.K().setTotalsRowCount(totalsRowCount);
                    for (int i3 = 0; i3 < k2VarL.K().getTableColumns().getTableColumnList().size(); i3++) {
                        CTTableColumn cTTableColumn3 = k2Var.K().getTableColumns().getTableColumnList().get(i3);
                        CTTableColumn cTTableColumn4 = k2VarL.K().getTableColumns().getTableColumnList().get(i3);
                        if (cTTableColumn3.getCalculatedColumnFormula() != null) {
                            cTTableColumn4.setCalculatedColumnFormula(cTTableColumn3.getCalculatedColumnFormula());
                            CTTableFormula calculatedColumnFormula = cTTableColumn4.getCalculatedColumnFormula();
                            String strReplace = cTTableColumn3.getCalculatedColumnFormula().getStringValue().replace(k2Var.getName(), k2VarL.getName());
                            calculatedColumnFormula.setStringValue(strReplace);
                            int iM = k2VarL.N().m() - k2VarL.getTotalsRowCount();
                            int iL = k2VarL.O().l() + i3;
                            i2Var.getWorkbook().setCellFormulaValidation(false);
                            for (int iM2 = k2VarL.O().m() + k2VarL.getHeaderRowCount(); iM2 <= iM; iM2++) {
                                f2 f2VarF2 = i2Var.f(iM2);
                                if (f2VarF2 == null) {
                                    f2VarF2 = i2Var.B(iM2);
                                }
                                f2VarF2.k(iL, o0.a.CREATE_NULL_AS_BLANK).r(strReplace);
                            }
                        }
                    }
                }
            }
            i2Var.k0(k2Var);
        }
    }

    private n.a.a.n.d.g<z0> O(n.a.a.n.e.m mVar) throws IllegalStateException, n.a.a.n.c.x {
        int iB = mVar.b();
        int iA = mVar.a();
        int iK = mVar.k();
        int iG = mVar.g();
        int i2 = (iK - iB) + 1;
        int i3 = (iG - iA) + 1;
        ArrayList arrayList = new ArrayList(i2 * i3);
        for (int i4 = iB; i4 <= iK; i4++) {
            for (int i5 = iA; i5 <= iG; i5++) {
                f2 f2VarF = f(i4);
                if (f2VarF == null) {
                    f2VarF = B(i4);
                }
                z0 z0VarX = f2VarF.x(i5);
                if (z0VarX == null) {
                    z0VarX = f2VarF.i(i5);
                }
                arrayList.add(z0VarX);
            }
        }
        return n.a.a.n.e.d0.a(iB, iA, i2, i3, arrayList, z0.class);
    }

    private static String Z(int i2) {
        switch (i2) {
            case 1:
            case 10:
            default:
                return null;
            case 2:
                return "SUBTOTAL(109";
            case 3:
                return "SUBTOTAL(105";
            case 4:
                return "SUBTOTAL(104";
            case 5:
                return "SUBTOTAL(101";
            case 6:
                return "SUBTOTAL(103";
            case 7:
                return "SUBTOTAL(102";
            case 8:
                return "SUBTOTAL(107";
            case 9:
                return "SUBTOTAL(110";
        }
    }

    private void c0() {
        this.f = new ArrayList();
        if (this.d.isSetHyperlinks()) {
            try {
                n.a.a.k.b.r rVarV = getPackagePart().v(c2.C.h());
                for (CTHyperlink cTHyperlink : this.d.getHyperlinks().getHyperlinkArray()) {
                    this.f.add(new s1(cTHyperlink, cTHyperlink.getId() != null ? rVarV.h(cTHyperlink.getId()) : null));
                }
            } catch (n.a.a.k.a.a e) {
                throw new n.a.a.j.d(e);
            }
        }
    }

    private void d0(CTWorksheet cTWorksheet) {
        if (cTWorksheet.getSheetData() == null || cTWorksheet.getSheetData().getRowArray() == null) {
            throw new IllegalArgumentException("Had empty sheet data when initializing the sheet");
        }
        this.e.clear();
        this.f2559j = new TreeMap();
        this.f2558i = new HashMap();
        this.f2560k = new ArrayList();
        for (CTRow cTRow : cTWorksheet.getSheetData().getRowArray()) {
            f2 f2Var = new f2(cTRow, this);
            this.e.put(Integer.valueOf(f2Var.q()), f2Var);
        }
    }

    private static CTWorksheet f0() {
        CTWorksheet cTWorksheetNewInstance = CTWorksheet.Factory.newInstance();
        cTWorksheetNewInstance.addNewSheetFormatPr().setDefaultRowHeight(15.0d);
        cTWorksheetNewInstance.addNewSheetViews().addNewSheetView().setWorkbookViewId(0L);
        cTWorksheetNewInstance.addNewDimension().setRef("A1");
        cTWorksheetNewInstance.addNewSheetData();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTWorksheetNewInstance.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setBottom(0.75d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setLeft(0.7d);
        cTPageMarginsAddNewPageMargins.setRight(0.7d);
        cTPageMarginsAddNewPageMargins.setTop(0.75d);
        return cTWorksheetNewInstance;
    }

    private void l0(CTCols cTCols) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (!cTCol.isSetWidth()) {
                cTCol.setWidth(R());
                cTCol.setCustomWidth(false);
            }
        }
    }

    public j1 J() {
        j1 j1VarT = T();
        if (j1VarT != null) {
            return j1VarT;
        }
        n.a.a.k.b.k kVarQ = getPackagePart().q();
        c2 c2Var = c2.f2556o;
        c.a aVarCreateRelationship = createRelationship(c2Var, getWorkbook().getXssfFactory(), getNextPartNumber(c2Var, kVarQ.G(c2Var.a()).size() + 1), false);
        j1 j1Var = (j1) aVarCreateRelationship.a();
        this.d.addNewDrawing().setId(aVarCreateRelationship.b().a());
        return j1Var;
    }

    @Override // n.a.a.n.d.p0
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public f2 B(int i2) throws IllegalStateException, n.a.a.n.c.x {
        CTRow cTRowAddNewRow;
        Integer numValueOf = Integer.valueOf(i2);
        f2 f2Var = this.e.get(numValueOf);
        if (f2Var != null) {
            while (f2Var.l() != -1) {
                f2Var.v(f2Var.x(f2Var.l()));
            }
            cTRowAddNewRow = f2Var.h();
            cTRowAddNewRow.set(CTRow.Factory.newInstance());
        } else if (this.e.isEmpty() || i2 > this.e.lastKey().intValue()) {
            cTRowAddNewRow = this.d.getSheetData().addNewRow();
        } else {
            cTRowAddNewRow = this.d.getSheetData().insertNewRow(this.e.headMap(numValueOf).size());
        }
        f2 f2Var2 = new f2(cTRowAddNewRow, this);
        f2Var2.z(i2);
        this.e.put(numValueOf, f2Var2);
        return f2Var2;
    }

    public k2 L(n.a.a.n.e.k kVar) {
        if (!this.d.isSetTableParts()) {
            this.d.addNewTableParts();
        }
        CTTablePart cTTablePartAddNewTablePart = this.d.getTableParts().addNewTablePart();
        int size = getPackagePart().q().G(c2.q.a()).size() + 1;
        boolean z = true;
        while (true) {
            boolean z2 = false;
            if (!z) {
                break;
            }
            Iterator<n.a.a.k.b.m> it = getPackagePart().q().G(c2.q.a()).iterator();
            while (it.hasNext()) {
                if (c2.q.d(size).equals(it.next().r().f())) {
                    size++;
                    z2 = true;
                }
            }
            z = z2;
        }
        c.a aVarCreateRelationship = createRelationship(c2.q, getWorkbook().getXssfFactory(), size, false);
        k2 k2Var = (k2) aVarCreateRelationship.a();
        cTTablePartAddNewTablePart.setId(aVarCreateRelationship.b().a());
        k2Var.K().setId(size);
        this.f2559j.put(cTTablePartAddNewTablePart.getId(), k2Var);
        if (kVar != null && k2Var.b0(kVar)) {
            k2Var.V(kVar);
        }
        while (true) {
            if (size >= Integer.MAX_VALUE) {
                break;
            }
            String str = "Table" + size;
            if (getWorkbook().getTable(str) == null && getWorkbook().getName(str) == null) {
                k2Var.Y(str);
                k2Var.Z(str);
                break;
            }
            size++;
        }
        return k2Var;
    }

    protected CTDrawing M() {
        return this.d.getDrawing();
    }

    public CTWorksheet N() {
        return this.d;
    }

    public n.a.a.n.d.i P(int i2) {
        int iF = this.g.f(i2);
        XSSFWorkbook workbook = getWorkbook();
        if (iF == -1) {
            iF = 0;
        }
        return workbook.getCellStyleAt(iF);
    }

    public int Q(int i2) {
        CTCol cTColG = this.g.g(i2, false);
        return Math.toIntExact(Math.round(((cTColG == null || !cTColG.isSetWidth()) ? R() : cTColG.getWidth()) * 256.0d));
    }

    public int R() {
        CTSheetFormatPr sheetFormatPr = this.d.getSheetFormatPr();
        if (sheetFormatPr == null) {
            return 8;
        }
        return Math.toIntExact(sheetFormatPr.getBaseColWidth());
    }

    public float S() {
        CTSheetFormatPr sheetFormatPr = this.d.getSheetFormatPr();
        return (float) (sheetFormatPr == null ? 0.0d : sheetFormatPr.getDefaultRowHeight());
    }

    public j1 T() {
        CTDrawing cTDrawingM = M();
        if (cTDrawingM == null) {
            return null;
        }
        for (c.a aVar : getRelationParts()) {
            n.a.a.j.c cVarA = aVar.a();
            if (cVarA instanceof j1) {
                j1 j1Var = (j1) cVarA;
                if (aVar.b().a().equals(cTDrawingM.getId())) {
                    return j1Var;
                }
            }
        }
        A.atError().log("Can't find drawing with id={} in the list of the sheet's relationships", cTDrawingM.getId());
        return null;
    }

    z0 U(z0 z0Var) {
        int iG = z0Var.g();
        int i2 = z0Var.i();
        for (n.a.a.n.e.m mVar : this.f2560k) {
            if (mVar.z(iG, i2)) {
                return f(mVar.b()).x(mVar.a());
            }
        }
        return null;
    }

    public int V() {
        if (this.e.isEmpty()) {
            return -1;
        }
        return this.e.firstKey().intValue();
    }

    @Override // n.a.a.n.d.p0
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public f2 f(int i2) {
        return this.e.get(Integer.valueOf(i2));
    }

    public CTCellFormula X(int i2) {
        return this.f2558i.get(Integer.valueOf(i2));
    }

    protected CTSheetViews Y(boolean z) {
        CTSheetViews sheetViews = (this.d.isSetSheetViews() || !z) ? this.d.getSheetViews() : this.d.addNewSheetViews();
        if (sheetViews == null) {
            return null;
        }
        if (sheetViews.sizeOfSheetViewArray() == 0 && z) {
            sheetViews.addNewSheetView();
        }
        return sheetViews;
    }

    public List<k2> a0() {
        return new ArrayList(this.f2559j.values());
    }

    @Override // n.a.a.n.d.p0
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public XSSFWorkbook getWorkbook() {
        return (XSSFWorkbook) getParent();
    }

    @Override // n.a.a.n.d.p0
    public String c() {
        return this.c.getName();
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            write(outputStreamO);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // n.a.a.n.d.p0
    public int d() {
        if (this.e.isEmpty()) {
            return -1;
        }
        return this.e.lastKey().intValue();
    }

    boolean e0(z0 z0Var) {
        int iG = z0Var.g();
        int i2 = z0Var.i();
        Iterator<n.a.a.n.e.m> it = this.f2560k.iterator();
        while (it.hasNext()) {
            if (it.next().z(iG, i2)) {
                return true;
            }
        }
        return false;
    }

    protected void g0(z0 z0Var, q0 q0Var) {
        int i2 = z0Var.i();
        CTCellFormula f = z0Var.O().getF();
        if (f == null || f.getT() != STCellFormulaType.SHARED || !f.isSetRef() || f.getStringValue() == null) {
            return;
        }
        n.a.a.n.e.m mVarF = n.a.a.n.e.m.F(f.getRef());
        if (mVarF.u() > 1) {
            for (int iG = z0Var.g(); iG <= mVarF.k(); iG++) {
                f2 f2VarF = f(iG);
                if (f2VarF != null) {
                    for (int i3 = i2; i3 <= mVarF.g(); i3++) {
                        z0 z0VarX = f2VarF.x(i3);
                        if (z0VarX != null && z0VarX != z0Var && z0VarX.b() == n.a.a.n.d.j.FORMULA) {
                            CTCellFormula f2 = z0VarX.O().getF();
                            if (f2.getT() == STCellFormulaType.SHARED && f2.getSi() == f.getSi()) {
                                f2.setStringValue(z0VarX.P(q0Var));
                                f2.setRef(new n.a.a.n.e.m(z0VarX.g(), mVarF.k(), z0VarX.i(), mVarF.g()).D());
                                this.f2558i.put(Integer.valueOf(Math.toIntExact(f2.getSi())), f2);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    void h0(z0 z0Var) {
        CTCellFormula f = z0Var.O().getF();
        if (f != null && f.getT() == STCellFormulaType.SHARED && f.isSetRef() && f.getStringValue() != null) {
            CTCellFormula cTCellFormula = (CTCellFormula) f.copy();
            n.a.a.n.e.m mVarF = n.a.a.n.e.m.F(cTCellFormula.getRef());
            n.a.a.n.e.s sVar = new n.a.a.n.e.s(z0Var);
            if (sVar.l() > mVarF.a() || sVar.m() > mVarF.b()) {
                cTCellFormula.setRef(new n.a.a.n.e.m(Math.max(sVar.m(), mVarF.b()), Math.max(sVar.m(), mVarF.k()), Math.max((int) sVar.l(), mVarF.a()), Math.max((int) sVar.l(), mVarF.g())).D());
            }
            this.f2558i.put(Integer.valueOf(Math.toIntExact(f.getSi())), cTCellFormula);
        }
        if (f == null || f.getT() != STCellFormulaType.ARRAY || f.getRef() == null) {
            return;
        }
        this.f2560k.add(n.a.a.n.e.m.F(f.getRef()));
    }

    protected void i0() {
        for (c.a aVar : getRelationParts()) {
            if (aVar.a() instanceof k2) {
                k0((k2) aVar.a());
            } else {
                removeRelation(aVar.a(), true);
            }
        }
    }

    protected void j0(InputStream inputStream) throws IOException {
        try {
            CTWorksheet worksheet = WorksheetDocument.Factory.parse(inputStream, n.a.a.j.m.a).getWorksheet();
            this.d = worksheet;
            this.g = new org.apache.poi.xssf.usermodel.u2.a(worksheet);
            d0(this.d);
            for (c.a aVar : getRelationParts()) {
                Object objA = aVar.a();
                if (objA instanceof n.a.a.q.b.b) {
                    n.a.a.q.b.b bVar = (n.a.a.q.b.b) objA;
                    this.f2557h = bVar;
                    bVar.p(this);
                }
                if (objA instanceof k2) {
                    this.f2559j.put(aVar.b().a(), (k2) objA);
                }
                if (objA instanceof b2) {
                    getWorkbook().addPivotTable((b2) objA);
                }
            }
            c0();
        } catch (XmlException e) {
            throw new n.a.a.j.d(e);
        }
    }

    public void k0(k2 k2Var) {
        int i2;
        String relationId = getRelationId(k2Var);
        long id = k2Var.K().getId();
        Map.Entry<String, k2> entry = null;
        for (Map.Entry<String, k2> entry2 : this.f2559j.entrySet()) {
            if (entry2.getValue().K().getId() == id) {
                entry = entry2;
            }
        }
        if (entry != null) {
            removeRelation(getRelationById(entry.getKey()), true);
            this.f2559j.remove(entry.getKey());
            entry.getValue().S();
            CTTableParts tableParts = this.d.getTableParts();
            if (relationId != null) {
                i2 = 0;
                while (i2 < tableParts.sizeOfTablePartArray()) {
                    if (relationId.equals(tableParts.getTablePartArray(i2).getId())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                i2 = -1;
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                tableParts.removeTablePart(i2);
            }
        }
    }

    @Override // n.a.a.n.d.p0
    public int m() {
        return this.e.size();
    }

    public void m0(boolean z) {
        for (CTSheetView cTSheetView : Y(true).getSheetViewArray()) {
            cTSheetView.setTabSelected(z);
        }
    }

    @Override // n.a.a.n.d.p0
    public Iterator<n.a.a.n.d.o0> o() {
        return this.e.values().iterator();
    }

    @Override // n.a.a.j.c
    protected void onDocumentCreate() {
        CTWorksheet cTWorksheetF0 = f0();
        this.d = cTWorksheetF0;
        d0(cTWorksheetF0);
        this.g = new org.apache.poi.xssf.usermodel.u2.a(this.d);
        this.f = new ArrayList();
    }

    @Override // n.a.a.j.c
    protected void onDocumentRead() {
        try {
            InputStream inputStreamM = getPackagePart().m();
            try {
                j0(inputStreamM);
                if (inputStreamM != null) {
                    inputStreamM.close();
                }
            } finally {
            }
        } catch (IOException | ArithmeticException e) {
            throw new n.a.a.j.d(e);
        }
    }

    @Override // java.lang.Iterable
    public Spliterator<n.a.a.n.d.o0> spliterator() {
        return this.e.values().spliterator();
    }

    protected void write(OutputStream outputStream) throws IOException {
        boolean z;
        CTWorksheet cTWorksheet = this.d;
        if (cTWorksheet == null) {
            throw new n.a.a.j.d("Cannot write invalid sheet, internal data is missing");
        }
        if (cTWorksheet.sizeOfColsArray() == 1) {
            CTCols colsArray = this.d.getColsArray(0);
            if (colsArray.sizeOfColArray() == 0) {
                this.d.setColsArray(null);
                z = true;
            } else {
                l0(colsArray);
                z = false;
            }
        } else {
            z = false;
        }
        if (!this.f.isEmpty()) {
            if (this.d.getHyperlinks() == null) {
                this.d.addNewHyperlinks();
            }
            int size = this.f.size();
            CTHyperlink[] cTHyperlinkArr = new CTHyperlink[size];
            for (int i2 = 0; i2 < size; i2++) {
                s1 s1Var = this.f.get(i2);
                s1Var.a(getPackagePart());
                cTHyperlinkArr[i2] = s1Var.b();
            }
            this.d.getHyperlinks().setHyperlinkArray(cTHyperlinkArr);
        } else if (this.d.getHyperlinks() != null) {
            for (int iSizeOfHyperlinkArray = this.d.getHyperlinks().sizeOfHyperlinkArray() - 1; iSizeOfHyperlinkArray >= 0; iSizeOfHyperlinkArray--) {
                this.d.getHyperlinks().removeHyperlink(iSizeOfHyperlinkArray);
            }
            this.d.unsetHyperlinks();
        }
        n.a.a.n.e.m mVar = this.t;
        if (mVar == null) {
            int iMax = Integer.MIN_VALUE;
            Iterator<Map.Entry<Integer, f2>> it = this.e.entrySet().iterator();
            int iMin = Integer.MAX_VALUE;
            while (it.hasNext()) {
                f2 value = it.next().getValue();
                value.u();
                if (value.l() != -1) {
                    iMin = Math.min(iMin, (int) value.l());
                }
                if (value.n() != -1) {
                    iMax = Math.max(iMax, value.n() - 1);
                }
            }
            if (iMin != Integer.MAX_VALUE) {
                mVar = new n.a.a.n.e.m(V(), d(), iMin, iMax);
            }
        } else {
            Iterator<Map.Entry<Integer, f2>> it2 = this.e.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().u();
            }
        }
        if (mVar != null) {
            if (this.d.isSetDimension()) {
                this.d.getDimension().setRef(mVar.D());
            } else {
                this.d.addNewDimension().setRef(mVar.D());
            }
        }
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorksheet.type.getName().getNamespaceURI(), "worksheet"));
        this.d.save(outputStream, xmlOptions);
        if (z) {
            this.d.addNewCols();
        }
    }

    @Override // n.a.a.n.d.p0
    public n.a.a.n.d.g<z0> y(n.a.a.n.d.e eVar) throws IllegalStateException, n.a.a.n.c.x {
        if (eVar.getSheet() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
        }
        for (n.a.a.n.e.m mVar : this.f2560k) {
            if (mVar.A(eVar)) {
                this.f2560k.remove(mVar);
                n.a.a.n.d.g<z0> gVarO = O(mVar);
                Iterator<C> it = gVarO.iterator();
                while (it.hasNext()) {
                    ((z0) it.next()).y();
                }
                return gVarO;
            }
        }
        throw new IllegalArgumentException("Cell " + new n.a.a.n.e.s(eVar).g() + " is not part of an array formula.");
    }

    protected i2(n.a.a.k.b.m mVar) {
        super(mVar);
        this.e = new TreeMap();
    }
}
