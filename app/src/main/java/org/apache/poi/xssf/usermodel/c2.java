package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c2 extends n.a.a.j.l {
    public static final c2 A;
    public static final c2 B;
    public static final c2 C;
    public static final c2 D;
    public static final c2 E;
    public static final c2 F;
    public static final c2 G;

    /* renamed from: h, reason: collision with root package name */
    private static final Map<String, c2> f2549h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public static final c2 f2550i = new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/workbook", "/xl/workbook.xml");

    /* renamed from: j, reason: collision with root package name */
    public static final c2 f2551j = new c2("application/vnd.ms-excel.sheet.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");

    /* renamed from: k, reason: collision with root package name */
    public static final c2 f2552k;

    /* renamed from: l, reason: collision with root package name */
    public static final c2 f2553l;

    /* renamed from: m, reason: collision with root package name */
    public static final c2 f2554m;

    /* renamed from: n, reason: collision with root package name */
    public static final c2 f2555n;

    /* renamed from: o, reason: collision with root package name */
    public static final c2 f2556o;
    public static final c2 p;
    public static final c2 q;
    public static final c2 r;
    public static final c2 s;
    public static final c2 t;
    public static final c2 u;
    public static final c2 v;
    public static final c2 w;
    public static final c2 x;
    public static final c2 y;
    public static final c2 z;

    static {
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        new c2("application/vnd.ms-excel.template.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        new c2("application/vnd.ms-excel.addin.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml");
        f2552k = new c2("application/vnd.ms-excel.sheet.binary.macroEnabled.main", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.bin");
        f2553l = new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet", "/xl/worksheets/sheet#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.s
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new i2();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.k0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new i2(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.chartsheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chartsheet", "/xl/chartsheets/sheet#.xml", null, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.n
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new c1(mVar);
            }
        });
        new c2("application/vnd.ms-office.chartex+xml", "http://schemas.microsoft.com/office/2014/relationships/chartEx", "/xl/charts/chartEx#.xml");
        f2554m = new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/sharedStrings", "/xl/sharedStrings.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.k
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.g();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.m0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.g(mVar);
            }
        });
        f2555n = new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles", "/xl/styles.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.d
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.i();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.o
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.i(mVar);
            }
        });
        f2556o = new c2("application/vnd.openxmlformats-officedocument.drawing+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/drawing", "/xl/drawings/drawing#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.f
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new j1();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.c
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new j1(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/xl/drawings/vmlDrawing#.vml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.r
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new r2();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.l
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new r2(mVar);
            }
        });
        p = new c2("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/xl/charts/chart#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.i0
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new b1();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.a0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new b1(mVar);
            }
        });
        new c2("application/xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/xmlMaps", "/xl/xmlMaps.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.c0
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.f();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.l0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.f(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.tableSingleCells+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableSingleCells", "/xl/tables/tableSingleCells#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.q
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.h();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.b
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.h(mVar);
            }
        });
        q = new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.table+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/table", "/xl/tables/table#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.v
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new k2();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.d0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new k2(mVar);
            }
        });
        t tVar = new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.t
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new x1();
            }
        };
        j0 j0Var = new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.j0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new x1(mVar);
            }
        };
        new c2(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, tVar, j0Var);
        r = new c2(n.a.a.m.a.a.EMF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.emf", tVar, j0Var);
        s = new c2(n.a.a.m.a.a.WMF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.wmf", tVar, j0Var);
        t = new c2(n.a.a.m.a.a.PICT.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.pict", tVar, j0Var);
        u = new c2(n.a.a.m.a.a.JPEG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.jpeg", tVar, j0Var);
        v = new c2(n.a.a.m.a.a.PNG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.png", tVar, j0Var);
        w = new c2(n.a.a.m.a.a.DIB.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.dib", tVar, j0Var);
        x = new c2(n.a.a.m.a.a.GIF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.gif", tVar, j0Var);
        y = new c2(n.a.a.m.a.a.TIFF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.tiff", tVar, j0Var);
        z = new c2(n.a.a.m.a.a.EPS.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.eps", tVar, j0Var);
        A = new c2(n.a.a.m.a.a.BMP.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.bmp", tVar, j0Var);
        B = new c2(n.a.a.m.a.a.WPG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.wpg", tVar, j0Var);
        new c2(n.a.a.m.a.a.WDP.c, "http://schemas.microsoft.com/office/2007/relationships/hdphoto", "/xl/media/hdphoto#.wdp", tVar, j0Var);
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/xl/comments#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.p
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.c();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.e
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.c(mVar);
            }
        });
        C = new c2(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null);
        D = new c2("application/vnd.openxmlformats-officedocument.oleObject", n.a.a.j.b.OLE_OBJECT_REL_TYPE, "/xl/embeddings/oleObject#.bin");
        E = new c2(null, n.a.a.j.b.PACK_OBJECT_REL_TYPE, null);
        F = new c2("application/vnd.ms-office.vbaProject", "http://schemas.microsoft.com/office/2006/relationships/vbaProject", "/xl/vbaProject.bin", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.j
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new q2();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.z
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new q2(mVar);
            }
        });
        new c2("application/vnd.ms-office.activeX+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/control", "/xl/activeX/activeX#.xml");
        new c2("application/vnd.ms-office.activeX", "http://schemas.microsoft.com/office/2006/relationships/activeXControlBinary", "/xl/activeX/activeX#.bin");
        new c2("application/vnd.ms-excel.macrosheet", "http://schemas.microsoft.com/office/2006/relationships/xlMacrosheet", "/xl/macroSheets/sheet#.bin");
        new c2("application/vnd.ms-excel.macrosheet+xml", "http://schemas.microsoft.com/office/2006/relationships/xlMacrosheet", "/xl/macroSheets/sheet#.xml");
        new c2("application/vnd.ms-excel.intlmacrosheet", "http://schemas.microsoft.com/office/2006/relationships/xlIntlMacrosheet", "/xl/macroSheets/sheet#.bin");
        new c2("application/vnd.ms-excel.intlmacrosheet+xml", "http://schemas.microsoft.com/office/2006/relationships/xlIntlMacrosheet", "/xl/macroSheets/sheet#.xml");
        new c2(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/dialogsheet", "/xl/dialogSheets/sheet#.bin");
        new c2("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/xl/theme/theme#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.f0
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.l();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.b0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.l(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.calcChain+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/calcChain", "/xl/calcChain.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.i
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.a();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.m
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.a(mVar);
            }
        });
        G = new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLink", "/xl/externalLinks/externalLink#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.h0
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new n.a.a.q.b.e();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.h
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new n.a.a.q.b.e(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.printerSettings", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/printerSettings", "/xl/printerSettings/printerSettings#.bin");
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotTable", "/xl/pivotTables/pivotTable#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.w
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new b2();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.a
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new b2(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheDefinition+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheDefinition", "/xl/pivotCache/pivotCacheDefinition#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.g
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new z1();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.g0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new z1(mVar);
            }
        });
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheRecords+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheRecords", "/xl/pivotCache/pivotCacheRecords#.xml", new n.a.a.j.i() { // from class: org.apache.poi.xssf.usermodel.u
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new a2();
            }
        }, new n.a.a.j.j() { // from class: org.apache.poi.xssf.usermodel.e0
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new a2(mVar);
            }
        });
        new c2(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/ctrlProp", "/xl/ctrlProps/ctrlProp#.xml");
        new c2("application/vnd.openxmlformats-officedocument.spreadsheetml.customProperty", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/customProperty", "/xl/customProperty#.bin");
    }

    private c2(String str, String str2, String str3) {
        this(str, str2, str3, null, null);
    }

    public static c2 i(String str) {
        return f2549h.get(str);
    }

    private c2(String str, String str2, String str3, n.a.a.j.i iVar, n.a.a.j.j jVar) {
        super(str, str2, str3, iVar, jVar, null);
        f2549h.put(str2, this);
    }
}
