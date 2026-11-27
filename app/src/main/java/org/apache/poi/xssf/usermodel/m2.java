package org.apache.poi.xssf.usermodel;

import com.auto.exceldeps.log4j.Logger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement;

/* loaded from: classes.dex */
public class m2 implements n.a.a.n.d.s0 {
    private static final Logger b = n.a.a.i.b.a(m2.class);
    private final Map<n.a.a.n.d.h1, Object> a = new EnumMap(n.a.a.n.d.h1.class);

    public m2(int i2, CTDxfs cTDxfs, CTTableStyle cTTableStyle, u0 u0Var) {
        cTTableStyle.getName();
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTDxfs.newCursor();
        try {
            xmlCursorNewCursor.selectPath("declare namespace x='http://schemas.openxmlformats.org/spreadsheetml/2006/main' .//x:dxf | .//dxf");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                String nodeName = object.getDomNode().getParentNode().getNodeName();
                if (nodeName.equals("mc:Fallback") || nodeName.equals("x:dxfs") || nodeName.contentEquals("dxfs")) {
                    try {
                        CTDxf cTDxf = object instanceof CTDxf ? (CTDxf) object : CTDxf.Factory.parse(object.newXMLStreamReader(), new XmlOptions().setDocumentType(CTDxf.type));
                        if (cTDxf != null) {
                            arrayList.add(cTDxf);
                        }
                    } catch (XmlException e) {
                        b.atWarn().withThrowable(e).log("Error parsing XSSFTableStyle");
                    }
                }
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            for (CTTableStyleElement cTTableStyleElement : cTTableStyle.getTableStyleElementList()) {
                if (cTTableStyleElement.getType() == null) {
                    throw new IllegalArgumentException("Did not have a type in table-style " + cTTableStyleElement);
                }
                n.a.a.n.d.h1 h1VarValueOf = n.a.a.n.d.h1.valueOf(cTTableStyleElement.getType().toString());
                k1 k1Var = null;
                if (cTTableStyleElement.isSetDxfId()) {
                    CTDxf cTDxf2 = (CTDxf) arrayList.get((int) cTTableStyleElement.getDxfId());
                    int size = cTTableStyleElement.isSetSize() ? (int) cTTableStyleElement.getSize() : 0;
                    if (cTDxf2 != null) {
                        k1Var = new k1(cTDxf2, size, u0Var);
                    }
                }
                this.a.put(h1VarValueOf, k1Var);
            }
        } finally {
        }
    }
}
