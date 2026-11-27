package i.e.a.g;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import i.e.a.k.w;
import java.util.HashMap;
import java.util.Objects;
import javax.xml.transform.dom.DOMResult;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public final class d extends n.b.a.m.m.b {
    HashMap<String, String> A;
    protected final w g;

    /* renamed from: h, reason: collision with root package name */
    protected b f1557h;

    /* renamed from: i, reason: collision with root package name */
    protected b f1558i;

    /* renamed from: j, reason: collision with root package name */
    protected int[] f1559j;

    /* renamed from: k, reason: collision with root package name */
    protected String f1560k;
    protected String t;

    private d(w wVar, Node node) throws XMLStreamException {
        super(node, true, wVar.L());
        this.f1560k = null;
        this.A = null;
        this.g = wVar;
        this.f1559j = null;
        this.t = wVar.w();
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            b bVarK = b.l().k((Element) node);
            this.f1557h = bVarK;
            this.f1558i = bVarK;
        } else if (nodeType == 9 || nodeType == 11) {
            this.f1557h = b.l();
            this.f1558i = null;
        } else {
            throw new XMLStreamException("Can not create an XMLStreamWriter for a DOM node of type " + node.getClass());
        }
    }

    public static d g(w wVar, DOMResult dOMResult) throws XMLStreamException {
        return new d(wVar, dOMResult.getNode());
    }

    private final String l(String str, String str2, b bVar) throws XMLStreamException {
        if (str2 != null && str2.length() != 0) {
            if (bVar.e(str, str2, true) == 1) {
                return str;
            }
            return null;
        }
        String strC = bVar.c();
        if (strC == null || strC.length() == 0) {
            return "";
        }
        return null;
    }

    @Override // n.b.a.j
    public void b(String str, String str2, String str3, String str4) throws XMLStreamException {
        if (this.f1557h != null) {
            throw new IllegalStateException("Operation only allowed to the document before adding root element");
        }
        e("writeDTD()");
        throw null;
    }

    @Override // n.b.a.m.m.b
    protected void c(Node node) throws IllegalStateException {
        this.f1557h.i(node);
        this.f1558i = null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public NamespaceContext getNamespaceContext() {
        return !this.c ? n.b.a.m.b.a() : this.f1557h;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public String getPrefix(String str) {
        String prefix;
        if (!this.c) {
            return null;
        }
        NamespaceContext namespaceContext = this.e;
        return (namespaceContext == null || (prefix = namespaceContext.getPrefix(str)) == null) ? this.f1557h.getPrefix(str) : prefix;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public Object getProperty(String str) {
        return this.g.a(str, false);
    }

    protected void h(String str, String str2, String str3, boolean z) throws DOMException, XMLStreamException {
        b bVarJ;
        if (this.c) {
            if (this.d) {
                String strL = l(str2, str, this.f1557h);
                if (strL == null) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    String strJ = j(str2, str, this.f1557h);
                    boolean z2 = strJ.length() != 0;
                    if (z2) {
                        str3 = strJ + ParameterizedMessage.ERROR_MSG_SEPARATOR + str3;
                    }
                    b bVarJ2 = this.f1557h.j(this.f.createElementNS(str, str3));
                    this.f1558i = bVarJ2;
                    if (z2) {
                        writeNamespace(strJ, str);
                        bVarJ2.a(strJ, str);
                    } else {
                        writeDefaultNamespace(str);
                        bVarJ2.o(str);
                    }
                    bVarJ = bVarJ2;
                } else if (strL.length() != 0) {
                    bVarJ = this.f1557h.j(this.f.createElementNS(str, strL + ParameterizedMessage.ERROR_MSG_SEPARATOR + str3));
                } else {
                    bVarJ = this.f1557h.j(this.f.createElementNS(str, str3));
                }
            } else {
                if (str2 == null && str != null && str.length() > 0) {
                    HashMap<String, String> map = this.A;
                    str2 = map == null ? null : map.get(str);
                    if (str2 == null) {
                        n.b.a.m.m.b.f("Can not find prefix for namespace \"" + str + "\"");
                        throw null;
                    }
                }
                if (str2 != null && str2.length() != 0) {
                    str3 = str2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + str3;
                }
                bVarJ = this.f1557h.j(this.f.createElementNS(str, str3));
            }
        } else {
            if (str != null && str.length() > 0) {
                n.b.a.m.m.b.f("Can not specify non-empty uri/prefix in non-namespace mode");
                throw null;
            }
            bVarJ = this.f1557h.j(this.f.createElement(str3));
        }
        this.f1558i = bVarJ;
        if (z) {
            return;
        }
        this.f1557h = bVarJ;
    }

    protected final String i(String str, String str2, b bVar) throws XMLStreamException {
        String strB = null;
        if (str2 != null && str2.length() != 0) {
            if (str != null) {
                int iE = bVar.e(str, str2, false);
                if (iE == 1) {
                    return str;
                }
                if (iE == 0) {
                    bVar.a(str, str2);
                    writeNamespace(str, str2);
                    return str;
                }
            }
            String strD = bVar.d(str2);
            if (strD != null) {
                return strD;
            }
            if (str == null) {
                HashMap<String, String> map = this.A;
                str = map != null ? map.get(str2) : strD;
            }
            if (str == null || (str.length() != 0 && bVar.getNamespaceURI(str) == null)) {
                strB = str;
            }
            if (strB == null) {
                if (this.f1559j == null) {
                    this.f1559j = new int[]{1};
                }
                strB = this.f1557h.b(this.t, str2, this.f1559j);
            }
            bVar.a(strB, str2);
            writeNamespace(strB, str2);
        }
        return strB;
    }

    protected final String j(String str, String str2, b bVar) throws XMLStreamException {
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        if (str != null) {
            return str;
        }
        String str3 = this.f1560k;
        if (str3 != null && str3.equals(str2)) {
            return "";
        }
        HashMap<String, String> map = this.A;
        String str4 = map == null ? null : map.get(str2);
        if (str4 != null) {
            return str4;
        }
        if (this.f1559j == null) {
            this.f1559j = new int[]{1};
        }
        return bVar.b(this.t, str2, this.f1559j);
    }

    protected void k(String str, String str2, String str3, String str4) throws DOMException, XMLStreamException {
        b bVar = this.f1558i;
        if (bVar == null) {
            throw new IllegalStateException("No currently open START_ELEMENT, cannot write attribute");
        }
        if (!this.c) {
            if (str2 != null && str2.length() > 0) {
                str3 = str2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + str3;
            }
            this.f1558i.g(str3, str4);
            return;
        }
        if (this.d) {
            str2 = i(str2, str, bVar);
        }
        if (str2 != null && str2.length() > 0) {
            str3 = str2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + str3;
        }
        this.f1558i.h(str, str3, str4);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setDefaultNamespace(String str) {
        if (str == null || str.length() == 0) {
            str = null;
        }
        this.f1560k = str;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setPrefix(String str, String str2) throws XMLStreamException {
        Objects.requireNonNull(str, "Can not pass null 'prefix' value");
        if (str.length() == 0) {
            setDefaultNamespace(str2);
            return;
        }
        Objects.requireNonNull(str2, "Can not pass null 'uri' value");
        if (str.equals("xml")) {
            if (!str2.equals(XMLConstants.XML_NS_URI)) {
                n.b.a.m.m.b.f("Trying to redeclare prefix 'xml' from its default URI 'http://www.w3.org/XML/1998/namespace' to \"" + str2 + "\"");
                throw null;
            }
        } else {
            if (str.equals("xmlns")) {
                if (str2.equals("http://www.w3.org/2000/xmlns/")) {
                    return;
                }
                n.b.a.m.m.b.f("Trying to declare prefix 'xmlns' (illegal as per NS 1.1 #4)");
                throw null;
            }
            if (str2.equals(XMLConstants.XML_NS_URI)) {
                n.b.a.m.m.b.f("Trying to bind URI 'http://www.w3.org/XML/1998/namespace to prefix \"" + str + "\" (can only bind to 'xml')");
                throw null;
            }
            if (str2.equals("http://www.w3.org/2000/xmlns/")) {
                n.b.a.m.m.b.f("Trying to bind URI 'http://www.w3.org/2000/xmlns/ to prefix \"" + str + "\" (can not be explicitly bound)");
                throw null;
            }
        }
        if (this.A == null) {
            this.A = new HashMap<>(16);
        }
        this.A.put(str2, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2) throws DOMException, XMLStreamException {
        k(null, null, str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeDefaultNamespace(String str) throws DOMException {
        if (this.f1558i == null) {
            throw new IllegalStateException("No currently open START_ELEMENT, cannot write attribute");
        }
        setDefaultNamespace(str);
        this.f1558i.h("http://www.w3.org/2000/xmlns/", "xmlns", str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str) throws DOMException, XMLStreamException {
        writeEmptyElement(null, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEndDocument() {
        this.f1558i = null;
        this.f1557h = null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEndElement() {
        b bVar = this.f1557h;
        if (bVar == null || bVar.n()) {
            throw new IllegalStateException("No open start element to close");
        }
        this.f1558i = null;
        this.f1557h = this.f1557h.m();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeNamespace(String str, String str2) throws DOMException, XMLStreamException {
        if (str == null || str.length() == 0) {
            writeDefaultNamespace(str2);
        } else {
            if (!this.c) {
                n.b.a.m.m.b.f("Can not write namespaces with non-namespace writer.");
                throw null;
            }
            k("http://www.w3.org/2000/xmlns/", "xmlns", str, str2);
            this.f1557h.a(str, str2);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str) throws DOMException, XMLStreamException {
        writeStartElement(null, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3) throws DOMException, XMLStreamException {
        k(str, null, str2, str3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2) throws DOMException, XMLStreamException {
        h(str, null, str2, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2) throws DOMException, XMLStreamException {
        h(str, null, str2, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3, String str4) throws DOMException, XMLStreamException {
        k(str2, str, str3, str4);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2, String str3) throws DOMException, XMLStreamException {
        if (str == null) {
            str = "";
        }
        h(str3, str, str2, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2, String str3) throws DOMException, XMLStreamException {
        h(str3, str, str2, false);
    }
}
