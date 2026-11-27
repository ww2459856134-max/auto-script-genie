package n.a.a.r.a;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* loaded from: classes.dex */
public final class y0 extends n.a.a.j.l {

    /* renamed from: h, reason: collision with root package name */
    private static final Map<String, y0> f2526h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public static final y0 f2527i;

    /* renamed from: j, reason: collision with root package name */
    public static final y0 f2528j;

    /* renamed from: k, reason: collision with root package name */
    public static final y0 f2529k;

    /* renamed from: l, reason: collision with root package name */
    public static final y0 f2530l;

    /* renamed from: m, reason: collision with root package name */
    public static final y0 f2531m;

    /* renamed from: n, reason: collision with root package name */
    public static final y0 f2532n;

    /* renamed from: o, reason: collision with root package name */
    public static final y0 f2533o;
    public static final y0 p;
    public static final y0 q;
    public static final y0 r;
    public static final y0 s;
    public static final y0 t;
    public static final y0 u;
    public static final y0 v;
    public static final y0 w;

    static {
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        new y0("application/vnd.ms-word.document.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        new y0("application/vnd.ms-word.template.macroEnabledTemplate.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml");
        f2527i = new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/glossaryDocument", "/word/glossary/document.xml");
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/numbering", "/word/numbering.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.i
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new u0();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.h
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new u0(mVar);
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable", "/word/fontTable.xml");
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings", "/word/settings.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.f
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new e1();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.t
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new e1(mVar);
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles", "/word/styles.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.x
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new f1();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.o
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new f1(mVar);
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings", "/word/webSettings.xml");
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.header+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/header", "/word/header#.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.a
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new r0();
            }
        }, new n.a.a.j.k() { // from class: n.a.a.r.a.g
            @Override // n.a.a.j.k
            public final n.a.a.j.c a(n.a.a.j.c cVar, n.a.a.k.b.m mVar) {
                new r0(cVar, mVar);
                throw null;
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer", "/word/footer#.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.d
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new o0();
            }
        }, new n.a.a.j.k() { // from class: n.a.a.r.a.m
            @Override // n.a.a.j.k
            public final n.a.a.j.c a(n.a.a.j.c cVar, n.a.a.k.b.m mVar) {
                new o0(cVar, mVar);
                throw null;
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/word/theme/theme#.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.b
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new l1();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.w
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new l1(mVar);
            }
        });
        f2528j = new y0("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", n.a.a.j.b.PACK_OBJECT_REL_TYPE, "/word/embeddings/Microsoft_Excel_Worksheet#.xlsx", new n.a.a.j.i() { // from class: n.a.a.r.a.p
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new XSSFWorkbook();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.l
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new XSSFWorkbook(mVar);
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/word/charts/chart#.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.k
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new h0();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.s
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new h0(mVar);
            }
        });
        new y0(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null);
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/word/comments.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.r
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new i0();
            }
        }, new n.a.a.j.k() { // from class: n.a.a.r.a.q
            @Override // n.a.a.j.k
            public final n.a.a.j.c a(n.a.a.j.c cVar, n.a.a.k.b.m mVar) {
                new i0(cVar, mVar);
                throw null;
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footnotes", "/word/footnotes.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.n
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new q0();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.e
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new q0(mVar);
            }
        });
        new y0("application/vnd.openxmlformats-officedocument.wordprocessingml.endnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/endnotes", "/word/endnotes.xml", new n.a.a.j.i() { // from class: n.a.a.r.a.c
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new l0();
            }
        }, new n.a.a.j.j() { // from class: n.a.a.r.a.v
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new l0(mVar);
            }
        });
        String str = n.a.a.e.a.c.EMF.c;
        u uVar = new n.a.a.j.i() { // from class: n.a.a.r.a.u
            @Override // n.a.a.j.i
            public final n.a.a.j.c a() {
                return new x0();
            }
        };
        j jVar = new n.a.a.j.j() { // from class: n.a.a.r.a.j
            @Override // n.a.a.j.j
            public final n.a.a.j.c a(n.a.a.k.b.m mVar) {
                return new x0(mVar);
            }
        };
        f2529k = new y0(str, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.emf", uVar, jVar);
        f2530l = new y0(n.a.a.e.a.c.WMF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.wmf", uVar, jVar);
        f2531m = new y0(n.a.a.e.a.c.PICT.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.pict", uVar, jVar);
        f2532n = new y0(n.a.a.e.a.c.JPEG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.jpeg", uVar, jVar);
        f2533o = new y0(n.a.a.e.a.c.PNG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.png", uVar, jVar);
        p = new y0(n.a.a.e.a.c.DIB.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.dib", uVar, jVar);
        q = new y0(n.a.a.e.a.c.GIF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.gif", uVar, jVar);
        r = new y0(n.a.a.e.a.c.TIFF.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.tiff", uVar, jVar);
        s = new y0(n.a.a.e.a.c.EPS.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.eps", uVar, jVar);
        t = new y0(n.a.a.e.a.c.BMP.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.bmp", uVar, jVar);
        u = new y0(n.a.a.e.a.c.WPG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.wpg", uVar, jVar);
        v = new y0(n.a.a.e.a.c.WDP.c, "http://schemas.microsoft.com/office/2007/relationships/hdphoto", "/ppt/media/hdphoto#.wdp", uVar, jVar);
        w = new y0(n.a.a.e.a.c.SVG.c, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.svg", uVar, jVar);
        new y0((String) null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", (String) null, uVar, jVar);
    }

    private y0(String str, String str2, String str3) {
        super(str, str2, str3);
        f2526h.put(str2, this);
    }

    public static y0 i(String str) {
        return f2526h.get(str);
    }

    public String toString() {
        return "XWPFRelation{" + a() + "/" + c() + "}";
    }

    private y0(String str, String str2, String str3, n.a.a.j.i iVar, n.a.a.j.j jVar) {
        super(str, str2, str3, iVar, jVar, null);
        f2526h.put(str2, this);
    }

    private y0(String str, String str2, String str3, n.a.a.j.i iVar, n.a.a.j.k kVar) {
        super(str, str2, str3, iVar, null, kVar);
        f2526h.put(str2, this);
    }
}
