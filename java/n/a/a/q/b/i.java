package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import n.a.a.j.m;
import n.a.a.n.d.e0;
import n.a.a.n.d.f0;
import n.a.a.n.d.s0;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.a1;
import org.apache.poi.xssf.usermodel.m2;
import org.apache.poi.xssf.usermodel.p1;
import org.apache.poi.xssf.usermodel.t0;
import org.apache.poi.xssf.usermodel.u0;
import org.apache.poi.xssf.usermodel.x0;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;

/* loaded from: classes.dex */
public class i extends n.a.a.j.c {

    /* renamed from: l, reason: collision with root package name */
    private static final int f2506l = n.a.a.n.a.EXCEL2007.d();
    private final SortedMap<Short, String> a;
    private final List<p1> b;
    private final List<org.apache.poi.xssf.usermodel.t2.d> c;
    private final List<org.apache.poi.xssf.usermodel.t2.c> d;
    private final List<CTXf> e;
    private final List<CTXf> f;
    private final List<CTDxf> g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, s0> f2507h;

    /* renamed from: i, reason: collision with root package name */
    private u0 f2508i;

    /* renamed from: j, reason: collision with root package name */
    private StyleSheetDocument f2509j;

    /* renamed from: k, reason: collision with root package name */
    private l f2510k;

    public i() {
        this.a = new TreeMap();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.f2507h = new HashMap();
        this.f2508i = new t0();
        StyleSheetDocument styleSheetDocumentNewInstance = StyleSheetDocument.Factory.newInstance();
        this.f2509j = styleSheetDocumentNewInstance;
        styleSheetDocumentNewInstance.addNewStyleSheet();
        U();
    }

    private static CTBorder I() {
        CTBorder cTBorderNewInstance = CTBorder.Factory.newInstance();
        cTBorderNewInstance.addNewBottom();
        cTBorderNewInstance.addNewTop();
        cTBorderNewInstance.addNewLeft();
        cTBorderNewInstance.addNewRight();
        cTBorderNewInstance.addNewDiagonal();
        return cTBorderNewInstance;
    }

    private static CTFill[] J() {
        DocumentFactory<CTFill> documentFactory = CTFill.Factory;
        CTFill[] cTFillArr = {documentFactory.newInstance(), documentFactory.newInstance()};
        cTFillArr[0].addNewPatternFill().setPatternType(STPatternType.NONE);
        cTFillArr[1].addNewPatternFill().setPatternType(STPatternType.DARK_GRAY);
        return cTFillArr;
    }

    private static p1 K() {
        p1 p1Var = new p1(CTFont.Factory.newInstance(), 0, null);
        p1Var.v((short) 11);
        p1Var.r(p1.e);
        p1Var.w("Calibri");
        p1Var.t(e0.SWISS);
        p1Var.x(f0.MINOR);
        return p1Var;
    }

    private static CTXf L() {
        CTXf cTXfNewInstance = CTXf.Factory.newInstance();
        cTXfNewInstance.setNumFmtId(0L);
        cTXfNewInstance.setFontId(0L);
        cTXfNewInstance.setFillId(0L);
        cTXfNewInstance.setBorderId(0L);
        return cTXfNewInstance;
    }

    private void U() {
        this.b.add(K());
        CTFill[] cTFillArrJ = J();
        this.c.add(new org.apache.poi.xssf.usermodel.t2.d(cTFillArrJ[0], this.f2508i));
        this.c.add(new org.apache.poi.xssf.usermodel.t2.d(cTFillArrJ[1], this.f2508i));
        this.d.add(new org.apache.poi.xssf.usermodel.t2.c(I()));
        this.e.add(L());
        CTXf cTXfL = L();
        cTXfL.setXfId(0L);
        this.f.add(cTXfL);
    }

    public CTXf M(int i2) {
        try {
            return this.e.get(i2);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public CTXf N(int i2) {
        return this.f.get(i2);
    }

    public s0 O(String str) {
        return this.f2507h.get(str);
    }

    public List<p1> P() {
        return Collections.unmodifiableList(this.b);
    }

    public u0 Q() {
        return this.f2508i;
    }

    public String R(short s) {
        return this.a.get(Short.valueOf(s));
    }

    public a1 S(int i2) {
        if (i2 < 0 || i2 >= this.f.size()) {
            return null;
        }
        return new a1(i2, this.f.get(i2).getXfId() > 0 ? (int) this.f.get(i2).getXfId() : 0, this, this.f2510k);
    }

    public s0 T(String str) {
        if (str == null) {
            return null;
        }
        s0 s0VarO = O(str);
        if (s0VarO != null) {
            return s0VarO;
        }
        try {
            return x0.valueOf(str).a();
        } catch (IllegalArgumentException unused) {
            return O(str);
        }
    }

    public int V(CTXf cTXf) {
        this.f.add(cTXf);
        return this.f.size();
    }

    public int W(p1 p1Var, boolean z) {
        int iIndexOf = !z ? this.b.indexOf(p1Var) : -1;
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.b.size();
        this.b.add(p1Var);
        return size;
    }

    public int X(a1 a1Var) {
        CTXf cTXfC = a1Var.c();
        int iIndexOf = this.f.indexOf(cTXfC);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        this.f.add(cTXfC);
        return this.f.size() - 1;
    }

    public void Y(InputStream inputStream) throws IOException {
        try {
            StyleSheetDocument styleSheetDocument = StyleSheetDocument.Factory.parse(inputStream, m.a);
            this.f2509j = styleSheetDocument;
            CTStylesheet styleSheet = styleSheetDocument.getStyleSheet();
            org.apache.poi.xssf.usermodel.s0 s0VarB = org.apache.poi.xssf.usermodel.s0.b(styleSheet.getColors());
            if (s0VarB != null) {
                this.f2508i = s0VarB;
            }
            CTNumFmts numFmts = styleSheet.getNumFmts();
            if (numFmts != null) {
                for (CTNumFmt cTNumFmt : numFmts.getNumFmtArray()) {
                    this.a.put(Short.valueOf((short) r4.getNumFmtId()), cTNumFmt.getFormatCode());
                }
            }
            CTFonts fonts = styleSheet.getFonts();
            if (fonts != null) {
                int i2 = 0;
                for (CTFont cTFont : fonts.getFontArray()) {
                    this.b.add(new p1(cTFont, i2, this.f2508i));
                    i2++;
                }
            }
            CTFills fills = styleSheet.getFills();
            if (fills != null) {
                for (CTFill cTFill : fills.getFillArray()) {
                    this.c.add(new org.apache.poi.xssf.usermodel.t2.d(cTFill, this.f2508i));
                }
            }
            CTBorders borders = styleSheet.getBorders();
            if (borders != null) {
                for (CTBorder cTBorder : borders.getBorderArray()) {
                    this.d.add(new org.apache.poi.xssf.usermodel.t2.c(cTBorder, this.f2508i));
                }
            }
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs != null) {
                this.f.addAll(Arrays.asList(cellXfs.getXfArray()));
            }
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs != null) {
                this.e.addAll(Arrays.asList(cellStyleXfs.getXfArray()));
            }
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs != null) {
                this.g.addAll(Arrays.asList(dxfs.getDxfArray()));
            }
            CTTableStyles tableStyles = styleSheet.getTableStyles();
            if (tableStyles == null || dxfs == null) {
                return;
            }
            int i3 = 0;
            for (CTTableStyle cTTableStyle : tableStyles.getTableStyleArray()) {
                this.f2507h.put(cTTableStyle.getName(), new m2(i3, dxfs, cTTableStyle, this.f2508i));
                i3++;
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void Z(l lVar) {
        this.f2510k = lVar;
        if (lVar != null) {
            lVar.L(Q());
        }
        Iterator<p1> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().y(lVar);
        }
        Iterator<org.apache.poi.xssf.usermodel.t2.c> it2 = this.d.iterator();
        while (it2.hasNext()) {
            it2.next().f(lVar);
        }
    }

    public void a0(XSSFWorkbook xSSFWorkbook) {
    }

    public void b0(OutputStream outputStream) throws IOException {
        CTStylesheet styleSheet = this.f2509j.getStyleSheet();
        CTNumFmts cTNumFmtsNewInstance = CTNumFmts.Factory.newInstance();
        cTNumFmtsNewInstance.setCount(this.a.size());
        for (Map.Entry<Short, String> entry : this.a.entrySet()) {
            CTNumFmt cTNumFmtAddNewNumFmt = cTNumFmtsNewInstance.addNewNumFmt();
            cTNumFmtAddNewNumFmt.setNumFmtId(entry.getKey().shortValue());
            cTNumFmtAddNewNumFmt.setFormatCode(entry.getValue());
        }
        styleSheet.setNumFmts(cTNumFmtsNewInstance);
        CTFonts fonts = styleSheet.getFonts();
        if (fonts == null) {
            fonts = CTFonts.Factory.newInstance();
        }
        fonts.setCount(this.b.size());
        CTFont[] cTFontArr = new CTFont[this.b.size()];
        Iterator<p1> it = this.b.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            cTFontArr[i2] = it.next().b();
            i2++;
        }
        fonts.setFontArray(cTFontArr);
        styleSheet.setFonts(fonts);
        CTFills fills = styleSheet.getFills();
        if (fills == null) {
            fills = CTFills.Factory.newInstance();
        }
        fills.setCount(this.c.size());
        CTFill[] cTFillArr = new CTFill[this.c.size()];
        Iterator<org.apache.poi.xssf.usermodel.t2.d> it2 = this.c.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            cTFillArr[i3] = it2.next().a();
            i3++;
        }
        fills.setFillArray(cTFillArr);
        styleSheet.setFills(fills);
        CTBorders borders = styleSheet.getBorders();
        if (borders == null) {
            borders = CTBorders.Factory.newInstance();
        }
        borders.setCount(this.d.size());
        CTBorder[] cTBorderArr = new CTBorder[this.d.size()];
        Iterator<org.apache.poi.xssf.usermodel.t2.c> it3 = this.d.iterator();
        int i4 = 0;
        while (it3.hasNext()) {
            cTBorderArr[i4] = it3.next().e();
            i4++;
        }
        borders.setBorderArray(cTBorderArr);
        styleSheet.setBorders(borders);
        if (!this.f.isEmpty()) {
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs == null) {
                cellXfs = CTCellXfs.Factory.newInstance();
            }
            cellXfs.setCount(this.f.size());
            cellXfs.setXfArray((CTXf[]) this.f.toArray(new CTXf[0]));
            styleSheet.setCellXfs(cellXfs);
        }
        if (!this.e.isEmpty()) {
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs == null) {
                cellStyleXfs = CTCellStyleXfs.Factory.newInstance();
            }
            cellStyleXfs.setCount(this.e.size());
            cellStyleXfs.setXfArray((CTXf[]) this.e.toArray(new CTXf[0]));
            styleSheet.setCellStyleXfs(cellStyleXfs);
        }
        if (!this.g.isEmpty()) {
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs == null) {
                dxfs = CTDxfs.Factory.newInstance();
            }
            dxfs.setCount(this.g.size());
            dxfs.setDxfArray((CTDxf[]) this.g.toArray(new CTDxf[0]));
            styleSheet.setDxfs(dxfs);
        }
        this.f2509j.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            b0(outputStreamO);
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

    public a1 createCellStyle() {
        int numCellStyles = getNumCellStyles();
        int i2 = f2506l;
        if (numCellStyles > i2) {
            throw new IllegalStateException("The maximum number of Cell Styles was exceeded. You can define up to " + i2 + " style in a .xlsx Workbook");
        }
        int size = this.e.size();
        CTXf cTXfNewInstance = CTXf.Factory.newInstance();
        cTXfNewInstance.setNumFmtId(0L);
        cTXfNewInstance.setFontId(0L);
        cTXfNewInstance.setFillId(0L);
        cTXfNewInstance.setBorderId(0L);
        cTXfNewInstance.setXfId(0L);
        return new a1(V(cTXfNewInstance) - 1, size - 1, this, this.f2510k);
    }

    public p1 findFont(boolean z, short s, short s2, String str, boolean z2, boolean z3, short s3, byte b) {
        for (p1 p1Var : this.b) {
            if (p1Var.a() == z && p1Var.d() == s && p1Var.f() == s2 && p1Var.h().equals(str) && p1Var.i() == z2 && p1Var.k() == z3 && p1Var.m() == s3 && p1Var.n() == b) {
                return p1Var;
            }
        }
        return null;
    }

    public p1 getFontAt(int i2) {
        return this.b.get(i2);
    }

    public int getNumCellStyles() {
        return this.f.size();
    }

    public l getTheme() {
        return this.f2510k;
    }

    public i(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        this.a = new TreeMap();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.f2507h = new HashMap();
        this.f2508i = new t0();
        InputStream inputStreamM = mVar.m();
        try {
            Y(inputStreamM);
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamM != null) {
                    try {
                        inputStreamM.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
