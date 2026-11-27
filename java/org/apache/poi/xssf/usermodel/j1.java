package org.apache.poi.xssf.usermodel;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import n.a.a.j.c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;

/* loaded from: classes.dex */
public final class j1 extends n.a.a.j.c implements Object<g2> {
    private static final Logger d = n.a.a.i.b.a(j1.class);
    private CTDrawing c;

    protected j1() {
        this.c = R();
    }

    private void I(XmlCursor xmlCursor, List<g2> list) {
        XmlCursor xmlCursorNewCursor;
        g2 h2Var;
        do {
            xmlCursor.push();
            if (xmlCursor.toFirstChild()) {
                do {
                    XmlObject object = xmlCursor.getObject();
                    if (!(object instanceof CTMarker)) {
                        if (object instanceof CTPicture) {
                            h2Var = new w1(this, (CTPicture) object);
                        } else if (object instanceof CTConnector) {
                            h2Var = new f1(this, (CTConnector) object);
                        } else if (object instanceof CTShape) {
                            h2Var = Q(object) ? new v1(this, (CTShape) object) : new j2(this, (CTShape) object);
                        } else if (object instanceof CTGraphicalObjectFrame) {
                            h2Var = new r1(this, (CTGraphicalObjectFrame) object);
                        } else if (object instanceof CTGroupShape) {
                            h2Var = new h2(this, (CTGroupShape) object);
                        } else if (object instanceof XmlAnyTypeImpl) {
                            d.atWarn().log("trying to parse AlternateContent, this unlinks the returned Shapes from the underlying xml content, so those shapes can't be used to modify the drawing, i.e. modifications will be ignored!");
                            xmlCursor.push();
                            xmlCursor.toFirstChild();
                            try {
                                try {
                                    xmlCursorNewCursor = CTDrawing.Factory.parse(xmlCursor.newXMLStreamReader()).newCursor();
                                } catch (XmlException e) {
                                    d.atWarn().withThrowable(e).log("unable to parse CTDrawing in alternate content.");
                                }
                                try {
                                    if (xmlCursorNewCursor.toFirstChild()) {
                                        I(xmlCursorNewCursor, list);
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
                            } finally {
                                xmlCursor.pop();
                            }
                        }
                        K(object);
                        list.add(h2Var);
                    }
                } while (xmlCursor.toNextSibling());
            }
            xmlCursor.pop();
        } while (xmlCursor.toNextSibling());
    }

    private v0 K(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            XmlObject object = xmlCursorNewCursor.toParent() ? xmlCursorNewCursor.getObject() : null;
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            if (object == null) {
                return null;
            }
            if (object instanceof CTTwoCellAnchor) {
                CTTwoCellAnchor cTTwoCellAnchor = (CTTwoCellAnchor) object;
                return new d1(cTTwoCellAnchor.getFrom(), cTTwoCellAnchor.getTo());
            }
            if (object instanceof CTOneCellAnchor) {
                CTOneCellAnchor cTOneCellAnchor = (CTOneCellAnchor) object;
                return new d1(P(), cTOneCellAnchor.getFrom(), cTOneCellAnchor.getExt());
            }
            if (!(object instanceof CTAbsoluteAnchor)) {
                return null;
            }
            CTAbsoluteAnchor cTAbsoluteAnchor = (CTAbsoluteAnchor) object;
            return new d1(P(), cTAbsoluteAnchor.getPos(), cTAbsoluteAnchor.getExt());
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

    private boolean Q(XmlObject xmlObject) {
        QName qName = new QName(null, "uri");
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:extLst/a:ext");
            while (xmlCursorNewCursor.toNextSelection()) {
                if ("{63B3BB69-23CF-44E3-9099-C40C66FF867C}".equals(xmlCursorNewCursor.getAttributeText(qName))) {
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return true;
                }
            }
            if (xmlCursorNewCursor == null) {
                return false;
            }
            xmlCursorNewCursor.close();
            return false;
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

    private static CTDrawing R() {
        return CTDrawing.Factory.newInstance();
    }

    protected c.a J() {
        c2 c2Var;
        XSSFWorkbook workbook = P().getWorkbook();
        XSSFFactory xSSFFactory = workbook == null ? XSSFFactory.getInstance() : workbook.getXssfFactory();
        n.a.a.k.b.k kVarQ = getPackagePart().q();
        int size = kVarQ.G(c2.p.a()).size();
        do {
            size++;
            try {
                c2Var = c2.p;
            } catch (n.a.a.k.a.a e) {
                throw new IllegalStateException("Failed for " + size, e);
            }
        } while (kVarQ.B(n.a.a.k.b.s.b(c2Var.d(size))) != null);
        return createRelationship(c2Var, xSSFFactory, size, false);
    }

    public CTDrawing L() {
        return this.c;
    }

    public List<b1> M() {
        ArrayList arrayList = new ArrayList();
        for (n.a.a.j.c cVar : getRelations()) {
            if (cVar instanceof b1) {
                arrayList.add((b1) cVar);
            }
        }
        return arrayList;
    }

    public List<g2> N() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.c.newCursor();
        try {
            if (xmlCursorNewCursor.toFirstChild()) {
                I(xmlCursorNewCursor, arrayList);
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return arrayList;
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

    public List<g2> O(h2 h2Var) {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = h2Var.b().newCursor();
        try {
            I(xmlCursorNewCursor, arrayList);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return arrayList;
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

    public i2 P() {
        return (i2) getParent();
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTDrawing.type.getName().getNamespaceURI(), "wsDr", "xdr"));
        OutputStream outputStreamO = getPackagePart().o();
        try {
            this.c.save(outputStreamO, xmlOptions);
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

    public Iterator<g2> iterator() {
        return N().iterator();
    }

    public Spliterator<g2> spliterator() {
        return N().spliterator();
    }

    public j1(n.a.a.k.b.m mVar) throws XmlException, IOException {
        super(mVar);
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setLoadReplaceDocumentElement(null);
        InputStream inputStreamM = mVar.m();
        try {
            this.c = CTDrawing.Factory.parse(inputStreamM, xmlOptions);
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
