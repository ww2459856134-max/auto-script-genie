package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.regex.Pattern;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.schemas.vmldrawing.XmlDocument;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* loaded from: classes.dex */
public final class r2 extends n.a.a.j.c {
    public static final QName d = new QName("urn:schemas-poi-apache-org:vmldrawing", "xml");
    private static final Pattern e = Pattern.compile("_x0000_s(\\d+)");
    private XmlDocument a;
    private String b;
    private int c;

    protected r2() {
        this.c = 1024;
        I();
    }

    private void I() {
        XmlDocument xmlDocumentNewInstance = XmlDocument.Factory.newInstance();
        this.a = xmlDocumentNewInstance;
        XmlCursor xmlCursorNewCursor = xmlDocumentNewInstance.addNewXml().newCursor();
        try {
            i.g.a.a.a.e eVarNewInstance = i.g.a.a.a.e.f1728n.newInstance();
            i.g.a.a.a.b bVarI = eVarNewInstance.i();
            i.g.a.b.e eVar = i.g.a.b.f.u;
            bVarI.a(eVar);
            i.g.a.a.a.a aVarS = bVarI.s();
            aVarS.a(eVar);
            aVarS.setData("1");
            xmlCursorNewCursor.toEndToken();
            XmlCursor xmlCursorNewCursor2 = eVarNewInstance.newCursor();
            try {
                xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
                if (xmlCursorNewCursor2 != null) {
                    xmlCursorNewCursor2.close();
                }
                i.g.a.b.a aVarNewInstance = i.g.a.b.a.p.newInstance();
                i.g.a.b.c cVarM = aVarNewInstance.m();
                this.b = "_x0000_t202";
                cVarM.setId("_x0000_t202");
                cVarM.o("21600,21600");
                cVarM.c(202.0f);
                cVarM.d("m,l,21600r21600,l21600,xe");
                cVarM.p().q(i.g.a.b.h.x);
                i.g.a.b.b bVarAddNewPath = cVarM.addNewPath();
                bVarAddNewPath.n(STTrueFalse.T);
                bVarAddNewPath.f(i.g.a.a.a.d.f1727m);
                xmlCursorNewCursor.toEndToken();
                xmlCursorNewCursor2 = aVarNewInstance.newCursor();
                try {
                    xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
                    if (xmlCursorNewCursor2 != null) {
                        xmlCursorNewCursor2.close();
                    }
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected void J(InputStream inputStream) throws XmlException, IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setLoadSubstituteNamespaces(Collections.singletonMap("", d.getNamespaceURI()));
        xmlOptions.setDocumentType(XmlDocument.type);
        XmlDocument xmlDocument = XmlDocument.Factory.parse(new n.a.a.o.g1(new n.a.a.o.g1(inputStream, "<br>", "<br/>"), " xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\"", ""), xmlOptions);
        this.a = xmlDocument;
        if (xmlDocument.getXml() == null) {
            return;
        }
        XmlCursor xmlCursorNewCursor = this.a.getXml().newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                xmlCursorNewCursor.getObject();
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
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

    protected void write(OutputStream outputStream) throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveImplicitNamespaces(Collections.singletonMap("", d.getNamespaceURI()));
        this.a.save(outputStream, xmlOptions);
    }

    protected r2(n.a.a.k.b.m mVar) throws XmlException, IOException {
        super(mVar);
        this.c = 1024;
        InputStream inputStreamM = getPackagePart().m();
        try {
            J(inputStreamM);
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
