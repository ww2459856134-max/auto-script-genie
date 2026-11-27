package org.apache.poi.xssf.usermodel;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public enum x0 {
    TableStyleDark1,
    TableStyleDark2,
    TableStyleDark3,
    TableStyleDark4,
    TableStyleDark5,
    TableStyleDark6,
    TableStyleDark7,
    TableStyleDark8,
    TableStyleDark9,
    TableStyleDark10,
    TableStyleDark11,
    TableStyleLight1,
    TableStyleLight2,
    TableStyleLight3,
    TableStyleLight4,
    TableStyleLight5,
    TableStyleLight6,
    TableStyleLight7,
    TableStyleLight8,
    TableStyleLight9,
    TableStyleLight10,
    TableStyleLight11,
    TableStyleLight12,
    TableStyleLight13,
    TableStyleLight14,
    TableStyleLight15,
    TableStyleLight16,
    TableStyleLight17,
    TableStyleLight18,
    TableStyleLight19,
    TableStyleLight20,
    TableStyleLight21,
    TableStyleMedium1,
    TableStyleMedium2,
    TableStyleMedium3,
    TableStyleMedium4,
    TableStyleMedium5,
    TableStyleMedium6,
    TableStyleMedium7,
    TableStyleMedium8,
    TableStyleMedium9,
    TableStyleMedium10,
    TableStyleMedium11,
    TableStyleMedium12,
    TableStyleMedium13,
    TableStyleMedium14,
    TableStyleMedium15,
    TableStyleMedium16,
    TableStyleMedium17,
    TableStyleMedium18,
    TableStyleMedium19,
    TableStyleMedium20,
    TableStyleMedium21,
    TableStyleMedium22,
    TableStyleMedium23,
    TableStyleMedium24,
    TableStyleMedium25,
    TableStyleMedium26,
    TableStyleMedium27,
    TableStyleMedium28,
    PivotStyleMedium1,
    PivotStyleMedium2,
    PivotStyleMedium3,
    PivotStyleMedium4,
    PivotStyleMedium5,
    PivotStyleMedium6,
    PivotStyleMedium7,
    PivotStyleMedium8,
    PivotStyleMedium9,
    PivotStyleMedium10,
    PivotStyleMedium11,
    PivotStyleMedium12,
    PivotStyleMedium13,
    PivotStyleMedium14,
    PivotStyleMedium15,
    PivotStyleMedium16,
    PivotStyleMedium17,
    PivotStyleMedium18,
    PivotStyleMedium19,
    PivotStyleMedium20,
    PivotStyleMedium21,
    PivotStyleMedium22,
    PivotStyleMedium23,
    PivotStyleMedium24,
    PivotStyleMedium25,
    PivotStyleMedium26,
    PivotStyleMedium27,
    PivotStyleMedium28,
    PivotStyleLight1,
    PivotStyleLight2,
    PivotStyleLight3,
    PivotStyleLight4,
    PivotStyleLight5,
    PivotStyleLight6,
    PivotStyleLight7,
    PivotStyleLight8,
    PivotStyleLight9,
    PivotStyleLight10,
    PivotStyleLight11,
    PivotStyleLight12,
    PivotStyleLight13,
    PivotStyleLight14,
    PivotStyleLight15,
    PivotStyleLight16,
    PivotStyleLight17,
    PivotStyleLight18,
    PivotStyleLight19,
    PivotStyleLight20,
    PivotStyleLight21,
    PivotStyleLight22,
    PivotStyleLight23,
    PivotStyleLight24,
    PivotStyleLight25,
    PivotStyleLight26,
    PivotStyleLight27,
    PivotStyleLight28,
    PivotStyleDark1,
    PivotStyleDark2,
    PivotStyleDark3,
    PivotStyleDark4,
    PivotStyleDark5,
    PivotStyleDark6,
    PivotStyleDark7,
    PivotStyleDark8,
    PivotStyleDark9,
    PivotStyleDark10,
    PivotStyleDark11,
    PivotStyleDark12,
    PivotStyleDark13,
    PivotStyleDark14,
    PivotStyleDark15,
    PivotStyleDark16,
    PivotStyleDark17,
    PivotStyleDark18,
    PivotStyleDark19,
    PivotStyleDark20,
    PivotStyleDark21,
    PivotStyleDark22,
    PivotStyleDark23,
    PivotStyleDark24,
    PivotStyleDark25,
    PivotStyleDark26,
    PivotStyleDark27,
    PivotStyleDark28;

    private static final Map<x0, n.a.a.n.d.s0> o2 = new EnumMap(x0.class);

    public static synchronized void b() {
        if (!o2.isEmpty()) {
            return;
        }
        try {
            InputStream resourceAsStream = x0.class.getResourceAsStream("presetTableStyles.xml");
            try {
                NodeList childNodes = n.a.a.j.o.a.d(resourceAsStream).getDocumentElement().getChildNodes();
                for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                    Node nodeItem = childNodes.item(i2);
                    if (nodeItem.getNodeType() == 1) {
                        Element element = (Element) nodeItem;
                        String tagName = element.getTagName();
                        x0 x0VarValueOf = valueOf(tagName);
                        Node nodeItem2 = element.getElementsByTagName("dxfs").item(0);
                        Node nodeItem3 = element.getElementsByTagName("tableStyles").item(0);
                        n.a.a.q.b.i iVar = new n.a.a.q.b.i();
                        i.b.ha.a.c.j.l lVar = i.b.ha.a.c.j.l.a().w(c(nodeItem2, nodeItem3).getBytes(StandardCharsets.UTF_8)).get();
                        try {
                            iVar.Y(lVar);
                            if (lVar != null) {
                                lVar.close();
                            }
                            o2.put(x0VarValueOf, new w0(x0VarValueOf, iVar.O(tagName)));
                        } finally {
                        }
                    }
                }
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } finally {
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private static String c(Node node, Node node2) throws TransformerException, DOMException {
        node.insertBefore(node.getOwnerDocument().createElement("dxf"), node.getFirstChild());
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<styleSheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:x14ac=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/ac\" xmlns:x16r2=\"http://schemas.microsoft.com/office/spreadsheetml/2015/02/main\" mc:Ignorable=\"x14ac x16r2\">\n" + d(node) + d(node2) + "</styleSheet>";
    }

    private static String d(Node node) throws TransformerException {
        i.b.ha.a.c.k.h hVar = new i.b.ha.a.c.k.h(1024);
        try {
            Transformer transformerM = n.a.a.o.r1.m();
            transformerM.setOutputProperty("omit-xml-declaration", "yes");
            transformerM.transform(new DOMSource(node), new StreamResult(hVar));
            String string = hVar.toString();
            hVar.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    hVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public n.a.a.n.d.s0 a() {
        b();
        return o2.get(this);
    }
}
