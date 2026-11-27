package n.a.a.r.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRelId;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: classes.dex */
public class z0 implements c0 {
    private final CTR c;
    private final String d;
    private final b0 e;
    private final List<w0> f;
    private final List<h0> g;

    public z0(CTR ctr, b0 b0Var) {
        this.c = ctr;
        this.e = b0Var;
        for (CTDrawing cTDrawing : ctr.getDrawingArray()) {
            for (CTAnchor cTAnchor : cTDrawing.getAnchorArray()) {
                if (cTAnchor.getDocPr() != null) {
                    d().K().a(cTAnchor.getDocPr().getId());
                }
            }
            for (CTInline cTInline : cTDrawing.getInlineArray()) {
                if (cTInline.getDocPr() != null) {
                    d().K().a(cTInline.getDocPr().getId());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<XmlObject> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(ctr.getPictArray()));
        arrayList.addAll(Arrays.asList(ctr.getDrawingArray()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            for (XmlObject xmlObject : ((XmlObject) it.next()).selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:t")) {
                NodeList childNodes = xmlObject.getDomNode().getChildNodes();
                for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                    if (childNodes.item(i2) instanceof Text) {
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(childNodes.item(i2).getNodeValue());
                    }
                }
            }
        }
        this.d = sb.toString();
        this.f = new ArrayList();
        this.g = new ArrayList();
        for (XmlObject xmlObject2 : arrayList) {
            Iterator<CTPicture> it2 = b(xmlObject2).iterator();
            while (it2.hasNext()) {
                this.f.add(new w0(it2.next(), this));
            }
            XmlObject[] xmlObjectArrSelectPath = xmlObject2.selectPath("declare namespace c='" + CTChart.type.getName().getNamespaceURI() + "' .//*/c:chart");
            int length = xmlObjectArrSelectPath.length;
            for (int i3 = 0; i3 < length; i3++) {
                XmlObject xmlObject3 = xmlObjectArrSelectPath[i3];
                if (xmlObject3 instanceof CTRelId) {
                    n.a.a.j.c relationById = d().getRelationById(((CTRelId) xmlObject3).getId());
                    if (relationById instanceof h0) {
                        this.g.add((h0) relationById);
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(XmlObject xmlObject, StringBuilder sb) {
        StringBuilder sb2;
        String str;
        String stringValue;
        if (xmlObject instanceof CTText) {
            Node domNode = xmlObject.getDomNode();
            if (((!"instrText".equals(domNode.getLocalName()) && !"delInstrText".equals(domNode.getLocalName())) || !"http://schemas.openxmlformats.org/wordprocessingml/2006/main".equals(domNode.getNamespaceURI())) && (stringValue = ((CTText) xmlObject).getStringValue()) != null) {
                if (i() || j()) {
                    stringValue = stringValue.toUpperCase(n.a.a.o.a1.e());
                }
                sb.append(stringValue);
            }
        }
        if (xmlObject instanceof CTFldChar) {
            CTFldChar cTFldChar = (CTFldChar) xmlObject;
            if (cTFldChar.getFldCharType() == STFldCharType.BEGIN && cTFldChar.getFfData() != null) {
                for (CTFFCheckBox cTFFCheckBox : cTFldChar.getFfData().getCheckBoxList()) {
                    sb.append((cTFFCheckBox.getDefault() == null || !n.a.a.j.o.c.c(cTFFCheckBox.getDefault().xgetVal())) ? "|_|" : "|X|");
                }
            }
        }
        if (xmlObject instanceof CTPTab) {
            sb.append('\t');
        }
        if (xmlObject instanceof CTBr) {
            sb.append('\n');
        }
        if (xmlObject instanceof CTEmpty) {
            Node domNode2 = xmlObject.getDomNode();
            if ("http://schemas.openxmlformats.org/wordprocessingml/2006/main".equals(domNode2.getNamespaceURI())) {
                String localName = domNode2.getLocalName();
                localName.hashCode();
                switch (localName) {
                    case "br":
                    case "cr":
                        sb.append('\n');
                        break;
                    case "tab":
                        sb.append('\t');
                        break;
                    case "noBreakHyphen":
                        sb.append((char) 8209);
                        break;
                }
            }
        }
        if (xmlObject instanceof CTFtnEdnRef) {
            CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) xmlObject;
            int iIntValue = cTFtnEdnRef.getId() != null ? cTFtnEdnRef.getId().intValue() : -1;
            if (cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference")) {
                sb2 = new StringBuilder();
                str = "[footnoteRef:";
            } else {
                sb2 = new StringBuilder();
                str = "[endnoteRef:";
            }
            sb2.append(str);
            sb2.append(iIntValue);
            sb2.append("]");
            sb.append(sb2.toString());
        }
    }

    private List<CTPicture> b(XmlObject xmlObject) {
        ArrayList arrayList = new ArrayList();
        XmlObject[] xmlObjectArrSelectPath = xmlObject.selectPath("declare namespace pic='" + CTPicture.type.getName().getNamespaceURI() + "' .//pic:pic");
        int length = xmlObjectArrSelectPath.length;
        for (int i2 = 0; i2 < length; i2++) {
            CTPicture cTPicture = xmlObjectArrSelectPath[i2];
            if (cTPicture instanceof XmlAnyTypeImpl) {
                try {
                    cTPicture = CTPicture.Factory.parse(cTPicture.toString(), n.a.a.j.m.a);
                } catch (XmlException e) {
                    throw new n.a.a.j.d(e);
                }
            }
            if (cTPicture instanceof CTPicture) {
                arrayList.add((CTPicture) cTPicture);
            }
        }
        return arrayList;
    }

    private void g(XmlObject xmlObject, StringBuilder sb, boolean z) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.selectPath(".//*");
            boolean z2 = false;
            boolean z3 = false;
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTRubyContent) {
                    Node domNode = object.getDomNode();
                    if ("http://schemas.openxmlformats.org/wordprocessingml/2006/main".equals(domNode.getNamespaceURI())) {
                        String localName = domNode.getLocalName();
                        if ("rt".equals(localName)) {
                            z2 = true;
                        } else if ("rubyBase".equals(localName)) {
                            z2 = false;
                            z3 = true;
                        }
                    }
                } else if (z && z2) {
                    a(object, sb);
                } else if (!z && z3) {
                    a(object, sb);
                }
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

    private static boolean h(CTOnOff cTOnOff) {
        return !cTOnOff.isSetVal() || n.a.a.j.o.c.d(cTOnOff);
    }

    public CTR c() {
        return this.c;
    }

    public j0 d() {
        b0 b0Var = this.e;
        if (b0Var != null) {
            return b0Var.getDocument();
        }
        return null;
    }

    public String e() {
        StringBuilder sb = new StringBuilder(64);
        XmlCursor xmlCursorNewCursor = this.c.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTRuby) {
                    g(object, sb, true);
                }
            }
            String str = this.d;
            if (str != null && !str.isEmpty()) {
                sb.append("\n");
                sb.append(this.d);
                sb.append("\n");
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return sb.toString();
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

    protected CTRPr f(boolean z) {
        CTRPr rPr = this.c.isSetRPr() ? this.c.getRPr() : null;
        return (z && rPr == null) ? this.c.addNewRPr() : rPr;
    }

    public boolean i() {
        CTRPr cTRPrF = f(false);
        return cTRPrF != null && cTRPrF.sizeOfCapsArray() > 0 && h(cTRPrF.getCapsArray(0));
    }

    public boolean j() {
        CTRPr cTRPrF = f(false);
        return cTRPrF != null && cTRPrF.sizeOfSmallCapsArray() > 0 && h(cTRPrF.getSmallCapsArray(0));
    }

    public String k() {
        StringBuilder sb = new StringBuilder(64);
        XmlCursor xmlCursorNewCursor = this.c.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTRuby) {
                    g(object, sb, false);
                } else {
                    a(object, sb);
                }
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return sb.toString();
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

    public String toString() {
        String strE = e();
        if (strE.isEmpty()) {
            return k();
        }
        return k() + " (" + strE + ")";
    }
}
