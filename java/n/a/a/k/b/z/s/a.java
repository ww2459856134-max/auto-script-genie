package n.a.a.k.b.z.s;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InputStream;
import n.a.a.k.b.j;
import n.a.a.k.b.x;
import n.a.a.k.b.z.k;
import n.a.a.k.b.z.m;
import n.a.a.k.b.z.q;
import org.apache.poi.javax.xml.XMLConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public final class a implements m {
    private j a;

    public a(j jVar) {
        this.a = jVar;
    }

    private String c(Document document) {
        return s(document, "category", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String d(Document document) {
        return s(document, "contentStatus", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String e(Document document) {
        return s(document, "contentType", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String f(Document document) {
        return s(document, "created", "http://purl.org/dc/terms/");
    }

    private String g(Document document) {
        return s(document, "creator", "http://purl.org/dc/elements/1.1/");
    }

    private String h(Document document) {
        return s(document, SocialConstants.PARAM_COMMENT, "http://purl.org/dc/elements/1.1/");
    }

    private String i(Document document) {
        return s(document, "identifier", "http://purl.org/dc/elements/1.1/");
    }

    private String j(Document document) {
        return s(document, "keywords", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String k(Document document) {
        return s(document, "language", "http://purl.org/dc/elements/1.1/");
    }

    private String l(Document document) {
        return s(document, "lastModifiedBy", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String m(Document document) {
        return s(document, "lastPrinted", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String n(Document document) {
        return s(document, "modified", "http://purl.org/dc/terms/");
    }

    private String o(Document document) {
        return s(document, "revision", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String p(Document document) {
        return s(document, "subject", "http://purl.org/dc/elements/1.1/");
    }

    private String q(Document document) {
        return s(document, "title", "http://purl.org/dc/elements/1.1/");
    }

    private String r(Document document) {
        return s(document, "version", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String s(Document document, String str, String str2) {
        Element element = (Element) document.getDocumentElement().getElementsByTagNameNS(str2, str).item(0);
        if (element == null) {
            return null;
        }
        return element.getTextContent();
    }

    @Override // n.a.a.k.b.z.m
    public n.a.a.k.b.m a(b bVar, InputStream inputStream) throws n.a.a.k.a.a, DOMException, IOException {
        k kVar = new k(bVar.a(), bVar.b());
        if (inputStream == null) {
            if (bVar.c() != null) {
                inputStream = ((x) bVar.a()).m0().v(bVar.c());
            } else {
                if (bVar.a() == null) {
                    throw new IOException("Error while trying to get the part input stream.");
                }
                inputStream = ((x) bVar.a()).m0().v(q.b((x) bVar.a()));
            }
        }
        try {
            Document documentD = n.a.a.j.o.a.d(inputStream);
            b(documentD.getDocumentElement());
            kVar.i0(c(documentD));
            kVar.j0(d(documentD));
            kVar.k0(e(documentD));
            kVar.l0(f(documentD));
            kVar.a(g(documentD));
            kVar.n0(h(documentD));
            kVar.o0(i(documentD));
            kVar.p0(j(documentD));
            kVar.q0(k(documentD));
            kVar.r0(l(documentD));
            kVar.s0(m(documentD));
            kVar.t0(n(documentD));
            kVar.u0(o(documentD));
            kVar.v0(p(documentD));
            kVar.w0(q(documentD));
            kVar.x0(r(documentD));
            return kVar;
        } catch (SAXException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void b(Element element) throws n.a.a.k.a.a, DOMException {
        if (this.a.b()) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                Attr attr = (Attr) attributes.item(0);
                if (attr != null && "http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()) && "http://schemas.openxmlformats.org/markup-compatibility/2006".equals(attr.getValue())) {
                    throw new n.a.a.k.a.a("OPC Compliance error [M4.2]: A format consumer shall consider the use of the Markup Compatibility namespace to be an error.");
                }
            }
        }
        String localName = element.getLocalName();
        if (this.a.c() && "http://purl.org/dc/terms/".equals(element.getNamespaceURI()) && !"created".equals(localName) && !"modified".equals(localName)) {
            throw new n.a.a.k.a.a("OPC Compliance error [M4.3]: Producers shall not create a document element that contains refinements to the Dublin Core elements, except for the two specified in the schema: <dcterms:created> and <dcterms:modified> Consumers shall consider a document element that violates this constraint to be an error.");
        }
        if (this.a.d() && element.getAttributeNodeNS(XMLConstants.XML_NS_URI, "lang") != null) {
            throw new n.a.a.k.a.a("OPC Compliance error [M4.4]: Producers shall not create a document element that contains the xml:lang attribute. Consumers shall consider a document element that violates this constraint to be an error.");
        }
        if (this.a.e() && "http://purl.org/dc/terms/".equals(element.getNamespaceURI())) {
            if (!localName.equals("created") && !localName.equals("modified")) {
                throw new n.a.a.k.a.a("Namespace error : " + localName + " shouldn't have the following namespace -> http://purl.org/dc/terms/");
            }
            Attr attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", SocialConstants.PARAM_TYPE);
            if (attributeNodeNS == null) {
                throw new n.a.a.k.a.a("The element '" + localName + "' must have the 'xsi:type' attribute present !");
            }
            if (!attributeNodeNS.getValue().equals(element.getPrefix() + ":W3CDTF")) {
                throw new n.a.a.k.a.a("The element '" + localName + "' must have the 'xsi:type' attribute with the value '" + element.getPrefix() + ":W3CDTF', but had '" + attributeNodeNS.getValue() + "' !");
            }
        }
        NodeList elementsByTagName = element.getElementsByTagName("*");
        int length2 = elementsByTagName.getLength();
        for (int i3 = 0; i3 < length2; i3++) {
            b((Element) elementsByTagName.item(i3));
        }
    }
}
