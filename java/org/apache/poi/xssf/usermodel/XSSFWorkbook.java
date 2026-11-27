package org.apache.poi.xssf.usermodel;

import com.auto.exceldeps.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.regex.Pattern;
import n.a.a.j.c;
import n.a.a.n.d.o0;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRefMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* loaded from: classes.dex */
public class XSSFWorkbook extends n.a.a.j.b implements n.a.a.n.d.i1, n.a.a.n.d.x {
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static final Pattern GET_ALL_PICTURES_PATTERN = Pattern.compile("/xl/media/.*?");
    private static final Logger LOG = n.a.a.i.b.a(XSSFWorkbook.class);
    private static final int MAX_NODE_DEPTH = 1000;
    public static final int PICTURE_TYPE_BMP = 11;
    public static final int PICTURE_TYPE_EPS = 10;
    public static final int PICTURE_TYPE_GIF = 8;
    public static final int PICTURE_TYPE_TIFF = 9;
    public static final int PICTURE_TYPE_WPG = 12;
    private g1 _creationHelper;
    private o0.a _missingCellPolicy;
    private final n.a.a.n.c.v1.b _udfFinder;
    private n.a.a.q.b.a calcChain;
    private boolean cellFormulaValidation;
    private List<n.a.a.q.b.e> externalLinks;
    private h1 formatter;
    private n.a.a.q.b.f mapInfo;
    private List<u1> namedRanges;
    private i.b.ha.a.a.d<String, u1> namedRangesByName;
    private List<x1> pictures;
    private List<CTPivotCache> pivotCaches;
    private final List<b2> pivotTables;
    private n.a.a.q.b.g sharedStringSource;
    private List<i2> sheets;
    private n.a.a.q.b.i stylesSource;
    private CTWorkbook workbook;
    private final XSSFFactory xssfFactory;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[n.a.a.n.d.q0.values().length];
            a = iArr;
            try {
                iArr[n.a.a.n.d.q0.VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[n.a.a.n.d.q0.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[n.a.a.n.d.q0.VERY_HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private final class b<T extends n.a.a.n.d.p0> implements Iterator<T> {
        private final Iterator<T> c;

        public b(XSSFWorkbook xSSFWorkbook) {
            this.c = xSSFWorkbook.sheets.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public T next() throws NoSuchElementException {
            return this.c.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    public XSSFWorkbook() {
        this(s2.XLSX);
    }

    private static boolean addRelation(c.a aVar, n.a.a.j.c cVar) throws n.a.a.k.a.b {
        n.a.a.k.b.q qVarB = aVar.b();
        if (qVarB.d() == n.a.a.k.b.v.EXTERNAL) {
            cVar.getPackagePart().d(qVarB.e(), qVarB.d(), qVarB.b(), qVarB.a());
            return true;
        }
        c2 c2VarI = c2.i(qVarB.b());
        if (c2VarI == null) {
            LOG.atWarn().log("Can't clone sheet relationship (some data will be lost in the cloned sheet) - unknown relation type found: {}", qVarB.b());
            return false;
        }
        cVar.addRelation(qVarB.a(), c2VarI, aVar.a());
        return true;
    }

    private CTSheet addSheet(String str) {
        CTSheet cTSheetAddNewSheet = this.workbook.getSheets().addNewSheet();
        cTSheetAddNewSheet.setName(str);
        return cTSheetAddNewSheet;
    }

    private boolean containsSheet(String str, int i2) {
        CTSheet[] sheetArray = this.workbook.getSheets().getSheetArray();
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        for (int i3 = 0; i3 < sheetArray.length; i3++) {
            String name = sheetArray[i3].getName();
            if (name.length() > 31) {
                name = name.substring(0, 31);
            }
            if (i2 != i3 && str.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private u1 createAndStoreName(CTDefinedName cTDefinedName) {
        u1 u1Var = new u1(cTDefinedName, this);
        this.namedRanges.add(u1Var);
        this.namedRangesByName.put(cTDefinedName.getName() == null ? null : cTDefinedName.getName().toLowerCase(Locale.ENGLISH), u1Var);
        return u1Var;
    }

    private static String getReferencePrintArea(String str, int i2, int i3, int i4, int i5) {
        n.a.a.n.e.s sVar = new n.a.a.n.e.s(str, i4, i2, true, true);
        n.a.a.n.e.s sVar2 = new n.a.a.n.e.s(str, i5, i3, true, true);
        return "$" + sVar.k()[2] + "$" + sVar.k()[1] + ":$" + sVar2.k()[2] + "$" + sVar2.k()[1];
    }

    private String getUniqueSheetName(String str) {
        int i2;
        String str2;
        int iLastIndexOf = str.lastIndexOf(40);
        if (iLastIndexOf <= 0 || !str.endsWith(")")) {
            i2 = 2;
        } else {
            try {
                i2 = Integer.parseInt(str.substring(iLastIndexOf + 1, str.length() - 1).trim()) + 1;
                try {
                    str = str.substring(0, iLastIndexOf).trim();
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
            }
        }
        while (true) {
            int i3 = i2 + 1;
            String string = Integer.toString(i2);
            if (str.length() + string.length() + 2 < 31) {
                str2 = str + " (" + string + ")";
            } else {
                str2 = str.substring(0, (31 - string.length()) - 2) + "(" + string + ")";
            }
            if (getSheetIndex(str2) == -1) {
                return str2;
            }
            i2 = i3;
        }
    }

    protected static n.a.a.k.b.k newPackage(s2 s2Var) throws IOException {
        n.a.a.k.b.k kVarO = null;
        try {
            kVarO = n.a.a.k.b.k.o(i.b.ha.a.c.k.j.p().get());
            n.a.a.k.b.o oVarB = n.a.a.k.b.s.b(c2.f2550i.c());
            kVarO.c(oVarB, n.a.a.k.b.v.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
            kVarO.p(oVarB, s2Var.a());
            kVarO.z().a(n.a.a.j.b.DOCUMENT_CREATOR);
            return kVarO;
        } catch (Exception e) {
            n.a.a.o.w0.f(kVarO);
            throw new n.a.a.j.d(e);
        }
    }

    private void onSheetDelete(int i2) {
        getSheetAt(i2).i0();
        this.workbook.getSheets().removeSheet(i2);
        n.a.a.q.b.a aVar = this.calcChain;
        if (aVar != null) {
            removeRelation(aVar);
            this.calcChain = null;
        }
        ArrayList arrayList = new ArrayList();
        for (u1 u1Var : this.namedRanges) {
            CTDefinedName cTDefinedNameE = u1Var.e();
            if (cTDefinedNameE.isSetLocalSheetId()) {
                long j2 = i2;
                if (cTDefinedNameE.getLocalSheetId() == j2) {
                    arrayList.add(u1Var);
                } else if (cTDefinedNameE.getLocalSheetId() > j2) {
                    cTDefinedNameE.setLocalSheetId(cTDefinedNameE.getLocalSheetId() - 1);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeName((u1) it.next());
        }
    }

    private void onWorkbookCreate() {
        CTWorkbook cTWorkbookNewInstance = CTWorkbook.Factory.newInstance();
        this.workbook = cTWorkbookNewInstance;
        cTWorkbookNewInstance.addNewWorkbookPr().setDate1904(false);
        setBookViewsIfMissing();
        this.workbook.addNewSheets();
        getProperties().b().b().setApplication(n.a.a.j.b.DOCUMENT_CREATOR);
        this.sharedStringSource = (n.a.a.q.b.g) createRelationship(c2.f2554m, this.xssfFactory);
        n.a.a.q.b.i iVar = (n.a.a.q.b.i) createRelationship(c2.f2555n, this.xssfFactory);
        this.stylesSource = iVar;
        iVar.a0(this);
        this.namedRanges = new ArrayList();
        this.namedRangesByName = new i.b.ha.a.a.m.c();
        this.sheets = new ArrayList();
        this.externalLinks = new ArrayList();
    }

    private void reprocessNamedRanges() {
        this.namedRangesByName = new i.b.ha.a.a.m.c();
        this.namedRanges = new ArrayList();
        if (this.workbook.isSetDefinedNames()) {
            for (CTDefinedName cTDefinedName : this.workbook.getDefinedNames().getDefinedNameArray()) {
                createAndStoreName(cTDefinedName);
            }
        }
    }

    private CTWorkbookProtection safeGetWorkbookProtection() {
        return !workbookProtectionPresent() ? this.workbook.addNewWorkbookProtection() : this.workbook.getWorkbookProtection();
    }

    private void saveCalculationChain() {
        n.a.a.q.b.a aVar = this.calcChain;
        if (aVar == null || aVar.I().sizeOfCArray() != 0) {
            return;
        }
        removeRelation(this.calcChain);
        this.calcChain = null;
    }

    private void saveNamedRanges() {
        if (this.namedRanges.isEmpty()) {
            if (this.workbook.isSetDefinedNames()) {
                this.workbook.unsetDefinedNames();
                return;
            }
            return;
        }
        CTDefinedNames cTDefinedNamesNewInstance = CTDefinedNames.Factory.newInstance();
        CTDefinedName[] cTDefinedNameArr = new CTDefinedName[this.namedRanges.size()];
        int i2 = 0;
        Iterator<u1> it = this.namedRanges.iterator();
        while (it.hasNext()) {
            cTDefinedNameArr[i2] = it.next().e();
            i2++;
        }
        cTDefinedNamesNewInstance.setDefinedNameArray(cTDefinedNameArr);
        if (this.workbook.isSetDefinedNames()) {
            this.workbook.unsetDefinedNames();
        }
        this.workbook.setDefinedNames(cTDefinedNamesNewInstance);
        reprocessNamedRanges();
    }

    private void setBookViewsIfMissing() {
        if (this.workbook.isSetBookViews()) {
            return;
        }
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
    }

    private void updateActiveSheetAfterSheetReorder(int i2, int i3) {
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i2) {
            setActiveSheet(i3);
            return;
        }
        if (activeSheetIndex >= i2 || activeSheetIndex >= i3) {
            if (activeSheetIndex <= i2 || activeSheetIndex <= i3) {
                if (i3 > i2) {
                    setActiveSheet(activeSheetIndex - 1);
                } else {
                    setActiveSheet(activeSheetIndex + 1);
                }
            }
        }
    }

    private void updateNamedRangesAfterSheetReorder(int i2, int i3) {
        for (u1 u1Var : this.namedRanges) {
            int iA = u1Var.a();
            if (iA != -1) {
                if (iA == i2) {
                    u1Var.c(i3);
                } else if (i3 <= iA && iA < i2) {
                    u1Var.c(iA + 1);
                } else if (i2 < iA && iA <= i3) {
                    u1Var.c(iA - 1);
                }
            }
        }
    }

    private void validateSheetIndex(int i2) {
        int size = this.sheets.size() - 1;
        if (i2 < 0 || i2 > size) {
            String str = "(0.." + size + ")";
            if (size == -1) {
                str = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i2 + ") is out of range " + str);
        }
    }

    private void validateSheetName(String str) throws IllegalArgumentException {
        if (containsSheet(str, this.sheets.size())) {
            throw new IllegalArgumentException("The workbook already contains a sheet named '" + str + "'");
        }
    }

    private boolean workbookProtectionPresent() {
        return this.workbook.isSetWorkbookProtection();
    }

    public void addExternalLinksTable(n.a.a.q.b.e eVar) {
        if (this.externalLinks == null) {
            this.externalLinks = new ArrayList();
        }
        this.externalLinks.add(eVar);
    }

    public int addOlePackage(byte[] bArr, String str, String str2, String str3) throws IOException {
        c2 c2Var = c2.D;
        n.a.a.k.b.k kVar = getPackage();
        try {
            int iN = kVar.N(c2Var.c());
            n.a.a.k.b.m mVarP = kVar.p(n.a.a.k.b.s.b(c2Var.d(iN)), c2Var.a());
            n.a.a.l.c.n nVar = new n.a.a.l.c.n(str, str2, str3, bArr);
            i.b.ha.a.c.k.j jVar = i.b.ha.a.c.k.j.p().p(bArr.length + 500).get();
            try {
                nVar.m(jVar);
                n.a.a.l.c.q qVar = new n.a.a.l.c.q();
                try {
                    n.a.a.l.c.f fVarB = qVar.B();
                    fVarB.b("\u0001Ole10Native", jVar.x());
                    fVarB.h(n.a.a.f.c.OLE_V1_PACKAGE.a());
                    OutputStream outputStreamO = mVarP.o();
                    try {
                        qVar.F(outputStreamO);
                        if (outputStreamO != null) {
                            outputStreamO.close();
                        }
                        qVar.close();
                        if (jVar != null) {
                            jVar.close();
                        }
                        return iN;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (jVar != null) {
                        try {
                            jVar.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (n.a.a.k.a.a e) {
            throw new IOException("ole object name not recognized", e);
        }
    }

    public int addPicture(byte[] bArr, int i2) throws IOException {
        int size = getAllPictures().size() + 1;
        x1 x1Var = (x1) createRelationship(x1.a[i2], this.xssfFactory, size, true).a();
        try {
            OutputStream outputStreamO = x1Var.getPackagePart().o();
            try {
                outputStreamO.write(bArr);
                if (outputStreamO != null) {
                    outputStreamO.close();
                }
                this.pictures.add(x1Var);
                return size - 1;
            } finally {
            }
        } catch (IOException e) {
            throw new n.a.a.j.d(e);
        }
    }

    protected CTPivotCache addPivotCache(String str) {
        CTWorkbook cTWorkbook = getCTWorkbook();
        CTPivotCache cTPivotCacheAddNewPivotCache = (cTWorkbook.isSetPivotCaches() ? cTWorkbook.getPivotCaches() : cTWorkbook.addNewPivotCaches()).addNewPivotCache();
        cTPivotCacheAddNewPivotCache.setCacheId(this.pivotTables.size() + 1);
        cTPivotCacheAddNewPivotCache.setId(str);
        if (this.pivotCaches == null) {
            this.pivotCaches = new ArrayList();
        }
        this.pivotCaches.add(cTPivotCacheAddNewPivotCache);
        return cTPivotCacheAddNewPivotCache;
    }

    public void addPivotTable(b2 b2Var) {
        this.pivotTables.add(b2Var);
    }

    public void addToolPack(n.a.a.n.c.v1.c cVar) {
        this._udfFinder.b(cVar);
    }

    protected void beforeDocumentRead() {
        if (getCorePart().l().equals(c2.f2552k.a())) {
            throw new n.a.a.q.a();
        }
        this.pivotCaches = new ArrayList();
    }

    @Override // n.a.a.j.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            n.a.a.o.w0.f(this.sharedStringSource);
        }
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        saveNamedRanges();
        saveCalculationChain();
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorkbook.type.getName().getNamespaceURI(), "workbook"));
        OutputStream outputStreamO = getPackagePart().o();
        try {
            this.workbook.save(outputStreamO, xmlOptions);
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

    u1 createBuiltInName(String str, int i2) {
        validateSheetIndex(i2);
        CTDefinedName cTDefinedNameAddNewDefinedName = (this.workbook.getDefinedNames() == null ? this.workbook.addNewDefinedNames() : this.workbook.getDefinedNames()).addNewDefinedName();
        cTDefinedNameAddNewDefinedName.setName(str);
        cTDefinedNameAddNewDefinedName.setLocalSheetId(i2);
        if (getBuiltInName(str, i2) == null) {
            return createAndStoreName(cTDefinedNameAddNewDefinedName);
        }
        throw new n.a.a.j.d("Builtin (" + str + ") already exists for sheet (" + i2 + ")");
    }

    protected i1 createDialogsheet(String str, CTDialogsheet cTDialogsheet) {
        return new i1(createSheet(str));
    }

    public int getActiveSheetIndex() {
        return (int) this.workbook.getBookViews().getWorkbookViewArray(0).getActiveTab();
    }

    public List<n.a.a.k.b.m> getAllEmbeddedParts() throws n.a.a.k.a.f {
        LinkedList linkedList = new LinkedList();
        for (i2 i2Var : this.sheets) {
            Iterator<n.a.a.k.b.q> it = i2Var.getPackagePart().v(c2.D.h()).iterator();
            while (it.hasNext()) {
                linkedList.add(i2Var.getPackagePart().s(it.next()));
            }
            Iterator<n.a.a.k.b.q> it2 = i2Var.getPackagePart().v(c2.E.h()).iterator();
            while (it2.hasNext()) {
                linkedList.add(i2Var.getPackagePart().s(it2.next()));
            }
        }
        return linkedList;
    }

    public List<u1> getAllNames() {
        return Collections.unmodifiableList(this.namedRanges);
    }

    public List<x1> getAllPictures() {
        if (this.pictures == null) {
            List<n.a.a.k.b.m> listH = getPackage().H(GET_ALL_PICTURES_PATTERN);
            this.pictures = new ArrayList(listH.size());
            Iterator<n.a.a.k.b.m> it = listH.iterator();
            while (it.hasNext()) {
                this.pictures.add(new x1(it.next()));
            }
        }
        return Collections.unmodifiableList(this.pictures);
    }

    u1 getBuiltInName(String str, int i2) {
        for (u1 u1Var : this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH))) {
            if (u1Var.a() == i2) {
                return u1Var;
            }
        }
        return null;
    }

    public CTWorkbook getCTWorkbook() {
        return this.workbook;
    }

    public n.a.a.q.b.a getCalculationChain() {
        return this.calcChain;
    }

    public boolean getCellFormulaValidation() {
        return this.cellFormulaValidation;
    }

    public n.a.a.n.d.h getCellReferenceType() {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        return calcPr == null ? n.a.a.n.d.h.UNKNOWN : calcPr.getRefMode() == STRefMode.R_1_C_1 ? n.a.a.n.d.h.R1C1 : calcPr.getRefMode() == STRefMode.A_1 ? n.a.a.n.d.h.A1 : n.a.a.n.d.h.UNKNOWN;
    }

    public Collection<t1> getCustomXMLMappings() {
        n.a.a.q.b.f fVar = this.mapInfo;
        return fVar == null ? new ArrayList() : fVar.I();
    }

    @Deprecated
    public List<n.a.a.q.b.e> getExternalLinksTable() {
        return this.externalLinks;
    }

    public List<n.a.a.q.b.e> getExternalLinksTables() {
        return this.externalLinks;
    }

    public int getFirstVisibleTab() {
        return (short) this.workbook.getBookViews().getWorkbookViewArray(0).getFirstSheet();
    }

    public boolean getForceFormulaRecalculation() {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        return calcPr != null && calcPr.isSetFullCalcOnLoad() && calcPr.getFullCalcOnLoad();
    }

    public n.a.a.q.b.f getMapInfo() {
        return this.mapInfo;
    }

    public o0.a getMissingCellPolicy() {
        return this._missingCellPolicy;
    }

    @Deprecated
    u1 getNameAt(int i2) {
        int size = this.namedRanges.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i2 >= 0 && i2 <= size) {
            return this.namedRanges.get(i2);
        }
        throw new IllegalArgumentException("Specified name index " + i2 + " is outside the allowable range (0.." + (size - 1) + ").");
    }

    @Deprecated
    int getNameIndex(String str) {
        u1 name = getName(str);
        if (name != null) {
            return this.namedRanges.indexOf(name);
        }
        return -1;
    }

    public List<u1> getNames(String str) {
        return Collections.unmodifiableList(this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH)));
    }

    public int getNumCellStyles() {
        return this.stylesSource.getNumCellStyles();
    }

    public int getNumberOfFonts() {
        return this.stylesSource.P().size();
    }

    @Deprecated
    public int getNumberOfFontsAsInt() {
        return getNumberOfFonts();
    }

    public int getNumberOfNames() {
        return this.namedRanges.size();
    }

    public int getNumberOfSheets() {
        return this.sheets.size();
    }

    public List<b2> getPivotTables() {
        return this.pivotTables;
    }

    public String getPrintArea(int i2) {
        u1 builtInName = getBuiltInName("_xlnm.Print_Area", i2);
        if (builtInName == null) {
            return null;
        }
        return builtInName.g();
    }

    public n.a.a.q.b.g getSharedStringSource() {
        return this.sharedStringSource;
    }

    public int getSheetIndex(String str) {
        Iterator<i2> it = this.sheets.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next().c())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String getSheetName(int i2) {
        validateSheetIndex(i2);
        return this.sheets.get(i2).c();
    }

    public n.a.a.n.d.q0 getSheetVisibility(int i2) {
        validateSheetIndex(i2);
        STSheetState.Enum state = this.sheets.get(i2).c.getState();
        if (state == STSheetState.VISIBLE) {
            return n.a.a.n.d.q0.VISIBLE;
        }
        if (state == STSheetState.HIDDEN) {
            return n.a.a.n.d.q0.HIDDEN;
        }
        if (state == STSheetState.VERY_HIDDEN) {
            return n.a.a.n.d.q0.VERY_HIDDEN;
        }
        throw new IllegalArgumentException("This should never happen");
    }

    public n.a.a.n.a getSpreadsheetVersion() {
        return n.a.a.n.a.EXCEL2007;
    }

    public n.a.a.q.b.i getStylesSource() {
        return this.stylesSource;
    }

    public k2 getTable(String str) {
        List<i2> list;
        if (str == null || (list = this.sheets) == null) {
            return null;
        }
        Iterator<i2> it = list.iterator();
        while (it.hasNext()) {
            for (k2 k2Var : it.next().a0()) {
                if (str.equalsIgnoreCase(k2Var.getName())) {
                    return k2Var;
                }
            }
        }
        return null;
    }

    public n.a.a.q.b.l getTheme() {
        n.a.a.q.b.i iVar = this.stylesSource;
        if (iVar == null) {
            return null;
        }
        return iVar.getTheme();
    }

    n.a.a.n.c.v1.c getUDFFinder() {
        return this._udfFinder;
    }

    public s2 getWorkbookType() {
        return isMacroEnabled() ? s2.XLSM : s2.XLSX;
    }

    public XSSFFactory getXssfFactory() {
        return this.xssfFactory;
    }

    @Override // n.a.a.n.d.x
    public boolean isDate1904() {
        CTWorkbookPr workbookPr = this.workbook.getWorkbookPr();
        return workbookPr != null && workbookPr.getDate1904();
    }

    public boolean isHidden() {
        throw new IllegalStateException("Not implemented yet");
    }

    public boolean isMacroEnabled() {
        return getPackagePart().l().equals(c2.f2551j.a());
    }

    public boolean isRevisionLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockRevision();
    }

    public boolean isSheetHidden(int i2) {
        validateSheetIndex(i2);
        return this.sheets.get(i2).c.getState() == STSheetState.HIDDEN;
    }

    public boolean isSheetVeryHidden(int i2) {
        validateSheetIndex(i2);
        return this.sheets.get(i2).c.getState() == STSheetState.VERY_HIDDEN;
    }

    public boolean isStructureLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockStructure();
    }

    public boolean isWindowsLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockWindows();
    }

    @Override // java.lang.Iterable
    public Iterator<n.a.a.n.d.p0> iterator() {
        return sheetIterator();
    }

    public int linkExternalWorkbook(String str, n.a.a.n.d.i1 i1Var) throws NumberFormatException {
        int nextPartNumber;
        if (getCreationHelper().d().containsKey(str)) {
            Iterator<c.a> it = getRelationParts().iterator();
            while (true) {
                if (!it.hasNext()) {
                    nextPartNumber = -1;
                    break;
                }
                c.a next = it.next();
                if ((next.a() instanceof n.a.a.q.b.e) && ((n.a.a.q.b.e) next.a()).L().equals(str)) {
                    String string = next.b().e().toString();
                    String strC = c2.G.c();
                    nextPartNumber = Integer.parseInt(string.substring(strC.indexOf(35), strC.indexOf(46)));
                    break;
                }
            }
        } else {
            c2 c2Var = c2.G;
            nextPartNumber = getNextPartNumber(c2Var, getPackagePart().q().G(c2Var.a()).size() + 1);
            c.a aVarCreateRelationship = createRelationship(c2Var, this.xssfFactory, nextPartNumber, false);
            n.a.a.q.b.e eVar = (n.a.a.q.b.e) aVarCreateRelationship.a();
            eVar.Q(str);
            addExternalLinksTable(eVar);
            getCTWorkbook().addNewExternalReferences().addNewExternalReference().setId(aVarCreateRelationship.b().a());
        }
        getCreationHelper().b(str, i1Var);
        return nextPartNumber;
    }

    public void lockRevision() {
        safeGetWorkbookProtection().setLockRevision(true);
    }

    public void lockStructure() {
        safeGetWorkbookProtection().setLockStructure(true);
    }

    public void lockWindows() {
        safeGetWorkbookProtection().setLockWindows(true);
    }

    protected void onDeleteFormula(z0 z0Var) {
        if (this.calcChain != null) {
            this.calcChain.K((int) z0Var.getSheet().c.getSheetId(), z0Var.V());
        }
    }

    @Override // n.a.a.j.c
    protected void onDocumentRead() throws IOException {
        try {
            InputStream inputStreamM = getPackagePart().m();
            try {
                this.workbook = WorkbookDocument.Factory.parse(inputStreamM, n.a.a.j.m.a).getWorkbook();
                if (inputStreamM != null) {
                    inputStreamM.close();
                }
                int iB = n.a.a.o.r1.b(this.workbook.getDomNode(), 1000);
                boolean z = true;
                if (iB > 1000) {
                    throw new IOException(String.format(Locale.ROOT, "The document is too complex, it has a node depth of %s, which exceeds the maximum allowed of %s", Integer.valueOf(iB), 1000));
                }
                n.a.a.q.b.l lVar = null;
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                for (c.a aVar : getRelationParts()) {
                    n.a.a.j.c cVarA = aVar.a();
                    if (cVarA instanceof n.a.a.q.b.g) {
                        this.sharedStringSource = (n.a.a.q.b.g) cVarA;
                    } else if (cVarA instanceof n.a.a.q.b.i) {
                        this.stylesSource = (n.a.a.q.b.i) cVarA;
                    } else if (cVarA instanceof n.a.a.q.b.l) {
                        lVar = (n.a.a.q.b.l) cVarA;
                    } else if (cVarA instanceof n.a.a.q.b.a) {
                        this.calcChain = (n.a.a.q.b.a) cVarA;
                    } else if (cVarA instanceof n.a.a.q.b.f) {
                        this.mapInfo = (n.a.a.q.b.f) cVarA;
                    } else if (cVarA instanceof i2) {
                        map.put(aVar.b().a(), (i2) cVarA);
                    } else if (cVarA instanceof n.a.a.q.b.e) {
                        map2.put(aVar.b().a(), (n.a.a.q.b.e) cVarA);
                    }
                }
                if (getPackage().y() != n.a.a.k.b.l.READ) {
                    z = false;
                }
                if (this.stylesSource == null) {
                    if (z) {
                        this.stylesSource = new n.a.a.q.b.i();
                    } else {
                        this.stylesSource = (n.a.a.q.b.i) createRelationship(c2.f2555n, this.xssfFactory);
                    }
                }
                this.stylesSource.a0(this);
                this.stylesSource.Z(lVar);
                if (this.sharedStringSource == null) {
                    if (z) {
                        this.sharedStringSource = new n.a.a.q.b.g();
                    } else {
                        n.a.a.k.b.k kVarQ = getPackagePart().q();
                        c2 c2Var = c2.f2554m;
                        ArrayList<n.a.a.k.b.m> arrayListG = kVarQ.G(c2Var.a());
                        if (arrayListG.isEmpty()) {
                            this.sharedStringSource = (n.a.a.q.b.g) createRelationship(c2Var, this.xssfFactory);
                        } else {
                            this.sharedStringSource = new n.a.a.q.b.g(arrayListG.get(0));
                        }
                    }
                }
                this.sheets = new ArrayList(map.size());
                CTWorkbook cTWorkbook = this.workbook;
                if (cTWorkbook == null || cTWorkbook.getSheets() == null || this.workbook.getSheets().getSheetArray() == null) {
                    throw new n.a.a.j.d("Cannot read a workbook without sheets");
                }
                for (CTSheet cTSheet : this.workbook.getSheets().getSheetArray()) {
                    parseSheet(map, cTSheet);
                }
                this.externalLinks = new ArrayList(map2.size());
                if (this.workbook.isSetExternalReferences()) {
                    for (CTExternalReference cTExternalReference : this.workbook.getExternalReferences().getExternalReferenceArray()) {
                        n.a.a.q.b.e eVar = (n.a.a.q.b.e) map2.get(cTExternalReference.getId());
                        if (eVar == null) {
                            LOG.atWarn().log("ExternalLinksTable with r:id {} was defined, but didn't exist in package, skipping", cTExternalReference.getId());
                        } else {
                            this.externalLinks.add(eVar);
                        }
                    }
                }
                reprocessNamedRanges();
            } finally {
            }
        } catch (n.a.a.c e) {
            throw new IOException(e);
        } catch (XmlException e2) {
            throw new n.a.a.j.d(e2);
        }
    }

    public void parseSheet(Map<String, i2> map, CTSheet cTSheet) {
        i2 i2Var = map.get(cTSheet.getId());
        if (i2Var == null) {
            LOG.atWarn().log("Sheet with name {} and r:id {} was defined, but didn't exist in package, skipping", cTSheet.getName(), cTSheet.getId());
            return;
        }
        i2Var.c = cTSheet;
        i2Var.onDocumentRead();
        this.sheets.add(i2Var);
    }

    public void removeName(n.a.a.n.d.m0 m0Var) {
        if (this.namedRangesByName.a(m0Var.d().toLowerCase(Locale.ENGLISH), m0Var) && this.namedRanges.remove(m0Var)) {
            return;
        }
        throw new IllegalArgumentException("Name was not found: " + m0Var);
    }

    public void removePrintArea(int i2) {
        u1 builtInName = getBuiltInName("_xlnm.Print_Area", i2);
        if (builtInName != null) {
            removeName(builtInName);
        }
    }

    public void removeSheetAt(int i2) {
        validateSheetIndex(i2);
        onSheetDelete(i2);
        removeRelation(getSheetAt(i2));
        this.sheets.remove(i2);
        if (this.sheets.isEmpty()) {
            return;
        }
        int size = i2 >= this.sheets.size() ? this.sheets.size() - 1 : i2;
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i2) {
            setActiveSheet(size);
        } else if (activeSheetIndex > i2) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    public void setActiveSheet(int i2) {
        validateSheetIndex(i2);
        for (CTBookView cTBookView : this.workbook.getBookViews().getWorkbookViewArray()) {
            cTBookView.setActiveTab(i2);
        }
    }

    public void setCellFormulaValidation(boolean z) {
        this.cellFormulaValidation = z;
    }

    public void setCellReferenceType(n.a.a.n.d.h hVar) {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        if (hVar == n.a.a.n.d.h.UNKNOWN) {
            if (calcPr != null) {
                calcPr.unsetRefMode();
            }
        } else {
            if (calcPr == null) {
                calcPr = getCTWorkbook().addNewCalcPr();
            }
            calcPr.setRefMode(hVar == n.a.a.n.d.h.R1C1 ? STRefMode.R_1_C_1 : STRefMode.A_1);
        }
    }

    public void setFirstVisibleTab(int i2) {
        this.workbook.getBookViews().getWorkbookViewArray(0).setFirstSheet(i2);
    }

    public void setForceFormulaRecalculation(boolean z) {
        CTWorkbook cTWorkbook = getCTWorkbook();
        CTCalcPr calcPr = cTWorkbook.isSetCalcPr() ? cTWorkbook.getCalcPr() : cTWorkbook.addNewCalcPr();
        calcPr.setFullCalcOnLoad(z);
        if (z && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    public void setHidden(boolean z) {
        throw new IllegalStateException("Not implemented yet");
    }

    public void setMissingCellPolicy(o0.a aVar) {
        this._missingCellPolicy = aVar;
    }

    public void setPrintArea(int i2, String str) {
        u1 builtInName = getBuiltInName("_xlnm.Print_Area", i2);
        if (builtInName == null) {
            builtInName = createBuiltInName("_xlnm.Print_Area", i2);
        }
        String[] strArrSplit = COMMA_PATTERN.split(str);
        StringBuilder sb = new StringBuilder(32);
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            n.a.a.n.c.c1.b(sb, getSheetName(i2));
            sb.append('!');
            sb.append(strArrSplit[i3]);
        }
        builtInName.i(sb.toString());
    }

    public void setRevisionsPassword(String str, n.a.a.l.b.e eVar) {
        if (str != null || workbookProtectionPresent()) {
            org.apache.poi.xssf.usermodel.u2.c.b(safeGetWorkbookProtection(), str, eVar, "revisions");
        }
    }

    public void setSelectedTab(int i2) {
        Iterator<i2> it = this.sheets.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            it.next().m0(i3 == i2);
            i3++;
        }
    }

    public void setSheetHidden(int i2, boolean z) {
        setSheetVisibility(i2, z ? n.a.a.n.d.q0.HIDDEN : n.a.a.n.d.q0.VISIBLE);
    }

    public void setSheetName(int i2, String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        validateSheetIndex(i2);
        String sheetName = getSheetName(i2);
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        n.a.a.n.e.e0.a(str);
        if (str.equals(sheetName)) {
            return;
        }
        if (containsSheet(str, i2)) {
            throw new IllegalArgumentException("The workbook already contains a sheet of this name");
        }
        new org.apache.poi.xssf.usermodel.u2.b(this).e(i2, sheetName, str);
        this.workbook.getSheets().getSheetArray(i2).setName(str);
    }

    public void setSheetOrder(String str, int i2) {
        int sheetIndex = getSheetIndex(str);
        List<i2> list = this.sheets;
        list.add(i2, list.remove(sheetIndex));
        CTSheets sheets = this.workbook.getSheets();
        XmlObject xmlObjectCopy = sheets.getSheetArray(sheetIndex).copy();
        this.workbook.getSheets().removeSheet(sheetIndex);
        sheets.insertNewSheet(i2).set(xmlObjectCopy);
        CTSheet[] sheetArray = sheets.getSheetArray();
        for (int i3 = 0; i3 < sheetArray.length; i3++) {
            this.sheets.get(i3).c = sheetArray[i3];
        }
        updateNamedRangesAfterSheetReorder(sheetIndex, i2);
        updateActiveSheetAfterSheetReorder(sheetIndex, i2);
    }

    public void setSheetVisibility(int i2, n.a.a.n.d.q0 q0Var) {
        validateSheetIndex(i2);
        CTSheet cTSheet = this.sheets.get(i2).c;
        int i3 = a.a[q0Var.ordinal()];
        if (i3 == 1) {
            cTSheet.setState(STSheetState.VISIBLE);
        } else if (i3 == 2) {
            cTSheet.setState(STSheetState.HIDDEN);
        } else {
            if (i3 != 3) {
                throw new IllegalArgumentException("This should never happen");
            }
            cTSheet.setState(STSheetState.VERY_HIDDEN);
        }
    }

    public void setVBAProject(InputStream inputStream) throws n.a.a.k.a.b, IOException {
        if (!isMacroEnabled()) {
            setWorkbookType(s2.XLSM);
        }
        try {
            c2 c2Var = c2.F;
            n.a.a.k.b.o oVarB = n.a.a.k.b.s.b(c2Var.c());
            n.a.a.k.b.k kVar = getPackage();
            OutputStream outputStreamO = !kVar.n(oVarB) ? createRelationship(c2Var, this.xssfFactory).getPackagePart().o() : kVar.B(oVarB).o();
            try {
                n.a.a.o.w0.h(inputStream, outputStreamO);
            } finally {
                n.a.a.o.w0.f(outputStreamO);
            }
        } catch (n.a.a.k.a.a e) {
            throw new n.a.a.j.d(e);
        }
    }

    public void setWorkbookPassword(String str, n.a.a.l.b.e eVar) {
        if (str != null || workbookProtectionPresent()) {
            org.apache.poi.xssf.usermodel.u2.c.b(safeGetWorkbookProtection(), str, eVar, "workbook");
        }
    }

    public void setWorkbookType(s2 s2Var) throws n.a.a.k.a.b {
        try {
            getPackagePart().F(s2Var.a());
        } catch (n.a.a.k.a.a e) {
            throw new n.a.a.j.d(e);
        }
    }

    public Iterator<n.a.a.n.d.p0> sheetIterator() {
        return new b(this);
    }

    @Override // java.lang.Iterable
    public Spliterator<n.a.a.n.d.p0> spliterator() {
        return this.sheets.spliterator();
    }

    public void unLock() {
        if (workbookProtectionPresent()) {
            this.workbook.unsetWorkbookProtection();
        }
    }

    public void unLockRevision() {
        safeGetWorkbookProtection().setLockRevision(false);
    }

    public void unLockStructure() {
        safeGetWorkbookProtection().setLockStructure(false);
    }

    public void unLockWindows() {
        safeGetWorkbookProtection().setLockWindows(false);
    }

    void updateName(u1 u1Var, String str) {
        i.b.ha.a.a.d<String, u1> dVar = this.namedRangesByName;
        Locale locale = Locale.ENGLISH;
        if (dVar.a(str.toLowerCase(locale), u1Var)) {
            this.namedRangesByName.put(u1Var.d().toLowerCase(locale), u1Var);
            return;
        }
        throw new IllegalArgumentException("Name was not found: " + u1Var);
    }

    public boolean validateRevisionsPassword(String str) {
        return !workbookProtectionPresent() ? str == null : org.apache.poi.xssf.usermodel.u2.c.c(safeGetWorkbookProtection(), str, "revisions");
    }

    public boolean validateWorkbookPassword(String str) {
        return !workbookProtectionPresent() ? str == null : org.apache.poi.xssf.usermodel.u2.c.c(safeGetWorkbookProtection(), str, "workbook");
    }

    public XSSFWorkbook(XSSFFactory xSSFFactory) {
        this(s2.XLSX, xSSFFactory);
    }

    public i2 cloneSheet(int i2) {
        return cloneSheet(i2, null);
    }

    public a1 createCellStyle() {
        return this.stylesSource.createCellStyle();
    }

    public h1 createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new h1(this.stylesSource);
        }
        return this.formatter;
    }

    public o1 createEvaluationWorkbook() {
        return o1.x(this);
    }

    public p1 createFont() {
        p1 p1Var = new p1();
        p1Var.p(this.stylesSource);
        return p1Var;
    }

    public u1 createName() {
        CTDefinedName cTDefinedNameNewInstance = CTDefinedName.Factory.newInstance();
        cTDefinedNameNewInstance.setName("");
        return createAndStoreName(cTDefinedNameNewInstance);
    }

    public p1 findFont(boolean z, short s, short s2, String str, boolean z2, boolean z3, short s3, byte b2) {
        return this.stylesSource.findFont(z, s, s2, str, z2, z3, s3, b2);
    }

    public a1 getCellStyleAt(int i2) {
        return this.stylesSource.S(i2);
    }

    @Override // n.a.a.n.d.i1
    public g1 getCreationHelper() {
        if (this._creationHelper == null) {
            this._creationHelper = new g1(this);
        }
        return this._creationHelper;
    }

    public n.a.a.q.b.e getExternalLinksTable(int i2) {
        List<n.a.a.q.b.e> list = this.externalLinks;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    public p1 getFontAt(int i2) {
        return this.stylesSource.getFontAt(i2);
    }

    public u1 getName(String str) {
        List<u1> names = getNames(str);
        if (names.isEmpty()) {
            return null;
        }
        return names.iterator().next();
    }

    public i2 getSheet(String str) {
        for (i2 i2Var : this.sheets) {
            if (str.equalsIgnoreCase(i2Var.c())) {
                return i2Var;
            }
        }
        return null;
    }

    public i2 getSheetAt(int i2) {
        validateSheetIndex(i2);
        return this.sheets.get(i2);
    }

    public XSSFWorkbook(s2 s2Var) {
        this(s2Var, (XSSFFactory) null);
    }

    public i2 cloneSheet(int i2, String str) throws n.a.a.k.a.b, IllegalArgumentException {
        validateSheetIndex(i2);
        i2 i2Var = this.sheets.get(i2);
        if (str == null) {
            str = getUniqueSheetName(i2Var.c());
        } else {
            validateSheetName(str);
        }
        i2 i2VarCreateSheet = createSheet(str);
        j1 j1Var = null;
        for (c.a aVar : i2Var.getRelationParts()) {
            n.a.a.j.c cVarA = aVar.a();
            if (cVarA instanceof j1) {
                j1Var = (j1) cVarA;
            } else {
                addRelation(aVar, i2VarCreateSheet);
            }
        }
        for (n.a.a.j.n nVar : i2Var.getReferenceRelationships()) {
            if (nVar instanceof n.a.a.j.a) {
                createHyperlink(nVar.b(), nVar.c(), nVar.a());
            }
        }
        try {
            Iterator<n.a.a.k.b.q> it = i2Var.getPackagePart().u().iterator();
            while (it.hasNext()) {
                n.a.a.k.b.q next = it.next();
                if (next.d() == n.a.a.k.b.v.EXTERNAL) {
                    i2VarCreateSheet.getPackagePart().c(next.e().toASCIIString(), next.b(), next.a());
                }
            }
            try {
                i.b.ha.a.c.k.j jVar = i.b.ha.a.c.k.j.p().get();
                try {
                    i2Var.write(jVar);
                    InputStream inputStreamX = jVar.x();
                    try {
                        i2VarCreateSheet.j0(inputStreamX);
                        if (inputStreamX != null) {
                            inputStreamX.close();
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        CTWorksheet cTWorksheetN = i2VarCreateSheet.N();
                        if (cTWorksheetN.isSetLegacyDrawing()) {
                            LOG.atWarn().log("Cloning sheets with comments is not yet supported.");
                            cTWorksheetN.unsetLegacyDrawing();
                        }
                        if (cTWorksheetN.isSetPageSetup()) {
                            LOG.atWarn().log("Cloning sheets with page setup is not yet supported.");
                            cTWorksheetN.unsetPageSetup();
                        }
                        i2VarCreateSheet.m0(false);
                        if (j1Var != null) {
                            if (cTWorksheetN.isSetDrawing()) {
                                cTWorksheetN.unsetDrawing();
                            }
                            j1 j1VarJ = i2VarCreateSheet.J();
                            j1VarJ.L().set(j1Var.L().copy());
                            j1 j1VarT = i2Var.T();
                            if (j1VarT != null) {
                                for (c.a aVar2 : j1VarT.getRelationParts()) {
                                    n.a.a.j.c cVarA2 = aVar2.a();
                                    if (cVarA2 instanceof b1) {
                                        b1 b1Var = (b1) j1VarJ.J().a();
                                        b1Var.T((b1) cVarA2);
                                        b1Var.U(i2VarCreateSheet);
                                    } else {
                                        addRelation(aVar2, j1VarJ);
                                    }
                                }
                                for (n.a.a.j.n nVar2 : j1VarT.getReferenceRelationships()) {
                                    if (nVar2 instanceof n.a.a.j.a) {
                                        j1VarJ.createHyperlink(nVar2.b(), nVar2.c(), nVar2.a());
                                    }
                                }
                            }
                        }
                        i2.I(i2VarCreateSheet);
                        return i2VarCreateSheet;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                throw new n.a.a.j.d("Failed to clone sheet", e);
            }
        } catch (n.a.a.k.a.a e2) {
            throw new n.a.a.j.d("Failed to clone sheet", e2);
        }
    }

    public i2 createSheet() {
        String str = "Sheet" + this.sheets.size();
        int i2 = 0;
        while (getSheet(str) != null) {
            str = "Sheet" + i2;
            i2++;
        }
        return createSheet(str);
    }

    public int getSheetIndex(n.a.a.n.d.p0 p0Var) {
        Iterator<i2> it = this.sheets.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next() == p0Var) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private XSSFWorkbook(s2 s2Var, XSSFFactory xSSFFactory) {
        super(newPackage(s2Var));
        this._udfFinder = new n.a.a.n.c.v1.b(n.a.a.n.c.v1.a.b);
        this._missingCellPolicy = o0.a.RETURN_NULL_AND_BLANK;
        this.cellFormulaValidation = true;
        this.pivotTables = new ArrayList();
        this.xssfFactory = xSSFFactory == null ? XSSFFactory.getInstance() : xSSFFactory;
        onWorkbookCreate();
    }

    public i2 createSheet(String str) throws IllegalArgumentException {
        if (str != null) {
            validateSheetName(str);
            if (str.length() > 31) {
                String strSubstring = str.substring(0, 31);
                LOG.atWarn().log("Sheet '{}' will be added with a trimmed name '{}' for MS Excel compliance.", str, strSubstring);
                str = strSubstring;
            }
            n.a.a.n.e.e0.a(str);
            CTSheet cTSheetAddSheet = addSheet(str);
            int iMax = 1;
            loop0: while (true) {
                Iterator<i2> it = this.sheets.iterator();
                while (it.hasNext()) {
                    iMax = (int) Math.max(it.next().c.getSheetId() + 1, iMax);
                }
                String strD = c2.f2553l.d(iMax);
                for (n.a.a.j.c cVar : getRelations()) {
                    if (cVar.getPackagePart() == null || !strD.equals(cVar.getPackagePart().r().f())) {
                    }
                }
                iMax++;
            }
            c.a aVarCreateRelationship = createRelationship(c2.f2553l, this.xssfFactory, iMax, false);
            i2 i2Var = (i2) aVarCreateRelationship.a();
            i2Var.c = cTSheetAddSheet;
            cTSheetAddSheet.setId(aVarCreateRelationship.b().a());
            cTSheetAddSheet.setSheetId(iMax);
            if (this.sheets.isEmpty()) {
                i2Var.m0(true);
            }
            this.sheets.add(i2Var);
            return i2Var;
        }
        throw new IllegalArgumentException("sheetName must not be null");
    }

    public int addPicture(InputStream inputStream, int i2) throws IOException {
        int size = getAllPictures().size() + 1;
        x1 x1Var = (x1) createRelationship(x1.a[i2], this.xssfFactory, size, true).a();
        OutputStream outputStreamO = x1Var.getPackagePart().o();
        try {
            n.a.a.o.w0.h(inputStream, outputStreamO);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
            this.pictures.add(x1Var);
            return size - 1;
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

    public XSSFWorkbook(n.a.a.k.b.k kVar) throws IOException {
        super(kVar);
        this._udfFinder = new n.a.a.n.c.v1.b(n.a.a.n.c.v1.a.b);
        this._missingCellPolicy = o0.a.RETURN_NULL_AND_BLANK;
        this.cellFormulaValidation = true;
        this.pivotTables = new ArrayList();
        XSSFFactory xSSFFactory = XSSFFactory.getInstance();
        this.xssfFactory = xSSFFactory;
        beforeDocumentRead();
        load(xSSFFactory);
        setBookViewsIfMissing();
    }

    public void setPrintArea(int i2, int i3, int i4, int i5, int i6) {
        setPrintArea(i2, getReferencePrintArea(getSheetName(i2), i3, i4, i5, i6));
    }

    public void setVBAProject(XSSFWorkbook xSSFWorkbook) throws n.a.a.k.a.a, n.a.a.k.a.b, IOException {
        InputStream inputStreamB;
        if (xSSFWorkbook.isMacroEnabled() && (inputStreamB = c2.F.b(xSSFWorkbook.getCorePart())) != null) {
            setVBAProject(inputStreamB);
        }
    }

    public XSSFWorkbook(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public XSSFWorkbook(InputStream inputStream, boolean z) throws IOException {
        this(n.a.a.j.o.d.a(inputStream, z));
    }

    public XSSFWorkbook(File file) throws n.a.a.k.a.a, IOException {
        this(n.a.a.k.b.k.Q(file));
    }

    public XSSFWorkbook(String str) throws IOException {
        this(n.a.a.j.b.J(str));
    }

    public XSSFWorkbook(n.a.a.k.b.m mVar) throws IOException {
        this(mVar.m(), true);
    }
}
