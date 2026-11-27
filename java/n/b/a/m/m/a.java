package n.b.a.m.m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.xml.transform.dom.DOMSource;
import n.b.a.c;
import n.b.a.h;
import n.b.a.i;
import n.b.a.m.j;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.w3c.dom.Attr;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public abstract class a implements i, n.b.a.a, n.b.a.b, c, NamespaceContext, XMLStreamConstants {
    protected final Node c;
    protected final boolean d;
    protected final boolean e;

    /* renamed from: i, reason: collision with root package name */
    protected Node f2535i;

    /* renamed from: k, reason: collision with root package name */
    protected String f2537k;
    protected boolean f = false;
    protected boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    protected int f2534h = 7;

    /* renamed from: j, reason: collision with root package name */
    protected int f2536j = 0;
    protected j t = new j();
    protected List<Node> A = null;
    protected List<String> C = null;

    protected a(DOMSource dOMSource, boolean z, boolean z2) throws XMLStreamException {
        Node node = dOMSource.getNode();
        if (node == null) {
            throw new IllegalArgumentException("Can not pass null Node for constructing a DOM-based XMLStreamReader");
        }
        this.d = z;
        this.e = z2;
        dOMSource.getSystemId();
        short nodeType = node.getNodeType();
        if (nodeType == 1 || nodeType == 9 || nodeType == 11) {
            this.f2535i = node;
            this.c = node;
        } else {
            throw new XMLStreamException("Can not create an XMLStreamReader for a DOM node of type " + node.getClass());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List<org.w3c.dom.Node>] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(boolean z) {
        String localName;
        NamedNodeMap attributes = this.f2535i.getAttributes();
        int length = attributes.getLength();
        if (length == 0) {
            this.A = Collections.emptyList();
            this.C = Collections.emptyList();
            return;
        }
        int i2 = 0;
        if (!this.d) {
            this.A = new ArrayList(length);
            while (i2 < length) {
                this.A.add(attributes.item(i2));
                i2++;
            }
            this.C = Collections.emptyList();
            return;
        }
        ?? EmptyList = 0;
        ArrayList arrayList = null;
        while (i2 < length) {
            Node nodeItem = attributes.item(i2);
            String prefix = nodeItem.getPrefix();
            if (prefix == null || prefix.length() == 0) {
                EmptyList = EmptyList;
                if ("xmlns".equals(nodeItem.getLocalName())) {
                    localName = null;
                    if (arrayList == null) {
                        arrayList = new ArrayList((length - i2) * 2);
                    }
                    arrayList.add(d(localName));
                    arrayList.add(e(nodeItem.getNodeValue()));
                } else if (z) {
                    if (EmptyList == 0) {
                        EmptyList = new ArrayList(length - i2);
                    }
                    EmptyList.add(nodeItem);
                }
            } else {
                EmptyList = EmptyList;
                if ("xmlns".equals(prefix)) {
                    localName = nodeItem.getLocalName();
                    if (arrayList == null) {
                    }
                    arrayList.add(d(localName));
                    arrayList.add(e(nodeItem.getNodeValue()));
                } else if (z) {
                    if (EmptyList == 0) {
                        EmptyList = new ArrayList(length - i2);
                    }
                    EmptyList.add(nodeItem);
                }
            }
            i2++;
            EmptyList = EmptyList;
            arrayList = arrayList;
        }
        if (EmptyList == 0) {
            EmptyList = Collections.emptyList();
        }
        this.A = EmptyList;
        ArrayList arrayListEmptyList = arrayList;
        if (arrayList == null) {
            arrayListEmptyList = Collections.emptyList();
        }
        this.C = arrayListEmptyList;
    }

    private QName b(String str, String str2, String str3) {
        return new QName(e(str), d(str2), d(str3));
    }

    private String f(Node node) {
        String localName = node.getLocalName();
        return localName == null ? node.getNodeName() : localName;
    }

    private void l(int i2) {
        Element element = (Element) this.f2535i;
        int length = element.getAttributes().getLength();
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal attribute index ");
        sb.append(i2);
        sb.append("; element <");
        sb.append(element.getNodeName());
        sb.append("> has ");
        sb.append(length == 0 ? "no" : String.valueOf(length));
        sb.append(" attributes");
        throw new IllegalArgumentException(sb.toString());
    }

    private void m(int i2) {
        throw new IllegalArgumentException("Illegal namespace declaration index " + i2 + " (has " + getNamespaceCount() + " ns declarations)");
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public void close() throws XMLStreamException {
    }

    protected String d(String str) {
        return str == null ? "" : this.f ? str.intern() : str;
    }

    protected String e(String str) {
        return str == null ? "" : this.g ? str.intern() : str;
    }

    protected void g(int i2) {
        short nodeType;
        this.t.c();
        this.t.a(this.f2535i.getNodeValue());
        while (true) {
            Node nextSibling = this.f2535i.getNextSibling();
            if (nextSibling == null || !((nodeType = nextSibling.getNodeType()) == 3 || nodeType == 4)) {
                break;
            }
            this.f2535i = nextSibling;
            this.t.a(nextSibling.getNodeValue());
        }
        this.f2537k = this.t.b();
        this.f2534h = 4;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getAttributeCount() {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        return this.A.size();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeLocalName(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        if (i2 < this.A.size() && i2 >= 0) {
            return d(f((Attr) this.A.get(i2)));
        }
        l(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public QName getAttributeName(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        if (i2 >= this.A.size() || i2 < 0) {
            l(i2);
            throw null;
        }
        Attr attr = (Attr) this.A.get(i2);
        return b(attr.getNamespaceURI(), f(attr), attr.getPrefix());
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeNamespace(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        if (i2 < this.A.size() && i2 >= 0) {
            return e(((Attr) this.A.get(i2)).getNamespaceURI());
        }
        l(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributePrefix(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        if (i2 < this.A.size() && i2 >= 0) {
            return d(((Attr) this.A.get(i2)).getPrefix());
        }
        l(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeType(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        if (i2 < this.A.size() && i2 >= 0) {
            return "CDATA";
        }
        l(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeValue(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        if (this.A == null) {
            a(true);
        }
        if (i2 < this.A.size() && i2 >= 0) {
            return ((Attr) this.A.get(i2)).getValue();
        }
        l(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getCharacterEncodingScheme() {
        return null;
    }

    @Override // n.b.a.i
    public n.b.a.b getDTDInfo() throws XMLStreamException {
        if (this.f2534h != 11) {
            return null;
        }
        return this;
    }

    @Override // n.b.a.b
    public String getDTDInternalSubset() {
        return null;
    }

    @Override // n.b.a.b
    public String getDTDPublicId() {
        if (this.f2534h == 11) {
            return ((DocumentType) this.f2535i).getPublicId();
        }
        return null;
    }

    @Override // n.b.a.b
    public String getDTDRootName() {
        if (this.f2534h == 11) {
            return d(((DocumentType) this.f2535i).getName());
        }
        return null;
    }

    @Override // n.b.a.b
    public String getDTDSystemId() {
        if (this.f2534h == 11) {
            return ((DocumentType) this.f2535i).getSystemId();
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getElementText() throws XMLStreamException {
        if (this.f2534h != 1) {
            n(1);
            throw null;
        }
        if (this.e) {
            String text = null;
            while (true) {
                int next = next();
                if (next == 2) {
                    return text == null ? "" : text;
                }
                if (next != 5 && next != 3) {
                    if (((1 << next) & 4688) == 0) {
                        n(4);
                        throw null;
                    }
                    if (text == null) {
                        text = getText();
                    } else {
                        text = text + getText();
                    }
                }
            }
        } else {
            this.t.c();
            while (true) {
                int next2 = next();
                if (next2 == 2) {
                    return this.t.b();
                }
                if (next2 != 5 && next2 != 3) {
                    if (((1 << next2) & 4688) == 0) {
                        n(4);
                        throw null;
                    }
                    this.t.a(getText());
                }
            }
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getEncoding() {
        return getCharacterEncodingScheme();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getEventType() {
        return this.f2534h;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getLocalName() {
        int i2 = this.f2534h;
        if (i2 == 1 || i2 == 2) {
            return d(f(this.f2535i));
        }
        if (i2 == 9) {
            return d(this.f2535i.getNodeName());
        }
        o(7);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final Location getLocation() {
        return k();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public QName getName() {
        int i2 = this.f2534h;
        if (i2 == 1 || i2 == 2) {
            return b(this.f2535i.getNamespaceURI(), f(this.f2535i), this.f2535i.getPrefix());
        }
        o(1);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public NamespaceContext getNamespaceContext() {
        return this;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getNamespaceCount() {
        int i2 = this.f2534h;
        if (i2 != 1 && i2 != 2) {
            o(2);
            throw null;
        }
        if (this.C == null) {
            if (!this.d) {
                return 0;
            }
            a(i2 == 1);
        }
        return this.C.size() / 2;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespacePrefix(int i2) {
        int i3 = this.f2534h;
        if (i3 != 1 && i3 != 2) {
            o(2);
            throw null;
        }
        if (this.C == null) {
            if (!this.d) {
                m(i2);
                throw null;
            }
            a(i3 == 1);
        }
        if (i2 >= 0 && i2 + i2 < this.C.size()) {
            return this.C.get(i2 + i2);
        }
        m(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI() {
        int i2 = this.f2534h;
        if (i2 == 1 || i2 == 2) {
            return e(this.f2535i.getNamespaceURI());
        }
        o(2);
        throw null;
    }

    @Override // n.b.a.i
    public NamespaceContext getNonTransientNamespaceContext() {
        return n.b.a.m.b.a();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPIData() {
        if (this.f2534h == 3) {
            return this.f2535i.getNodeValue();
        }
        o(3);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPITarget() {
        if (this.f2534h == 3) {
            return d(this.f2535i.getNodeName());
        }
        o(3);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPrefix() {
        int i2 = this.f2534h;
        if (i2 == 1 || i2 == 2) {
            return d(this.f2535i.getPrefix());
        }
        o(2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        String prefix = getPrefix(str);
        return prefix == null ? n.b.a.m.a.a() : n.b.a.m.c.a(prefix);
    }

    @Override // n.b.a.b
    public Object getProcessedDTD() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getText() {
        String str = this.f2537k;
        if (str != null) {
            return str;
        }
        if (((1 << this.f2534h) & 6768) != 0) {
            return this.f2535i.getNodeValue();
        }
        o(4);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public char[] getTextCharacters() {
        return getText().toCharArray();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextLength() {
        if (((1 << this.f2534h) & 4208) != 0) {
            return getText().length();
        }
        o(5);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextStart() {
        if (((1 << this.f2534h) & 4208) != 0) {
            return 0;
        }
        o(5);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getVersion() {
        return null;
    }

    protected String h(int i2, int i3) {
        String strA = n.b.a.m.i.a(i3);
        switch (i2) {
            case 1:
                return "Current event " + strA + ", needs to be START_ELEMENT";
            case 2:
                return "Current event " + strA + ", needs to be START_ELEMENT or END_ELEMENT";
            case 3:
                return "Current event (" + strA + ") needs to be PROCESSING_INSTRUCTION";
            case 4:
                return "Current event (" + strA + ") not a textual event";
            case 5:
                return "Current event " + strA + ", needs to be one of CHARACTERS, CDATA, SPACE or COMMENT";
            case 6:
                return "Current event (" + strA + " not START_ELEMENT, END_ELEMENT, CHARACTERS or CDATA";
            case 7:
                return "Current event (" + strA + ") has no local name";
            default:
                return "Internal error (unrecognized error type: " + i2 + ")";
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasName() {
        int i2 = this.f2534h;
        return i2 == 1 || i2 == 2;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasNext() {
        return this.f2534h != 8;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasText() {
        return ((1 << this.f2534h) & 6768) != 0;
    }

    public h i() {
        return h.z;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isAttributeSpecified(int i2) {
        if (this.f2534h != 1) {
            o(1);
            throw null;
        }
        Attr attr = (Attr) ((Element) this.f2535i).getAttributes().item(i2);
        if (attr != null) {
            return attr.getSpecified();
        }
        l(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isCharacters() {
        return this.f2534h == 4;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isEndElement() {
        return this.f2534h == 2;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isStandalone() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isStartElement() {
        return this.f2534h == 1;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isWhiteSpace() {
        int i2 = this.f2534h;
        if (i2 != 4 && i2 != 12) {
            return i2 == 6;
        }
        String text = getText();
        int length = text.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (text.charAt(i3) > ' ') {
                return false;
            }
        }
        return true;
    }

    protected Location j() {
        h hVarI = i();
        return hVarI == null ? getLocation() : hVarI;
    }

    public h k() {
        return h.z;
    }

    protected void n(int i2) throws XMLStreamException {
        r(h(i2, this.f2534h));
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        this.f2537k = null;
        int i2 = this.f2534h;
        if (i2 != 1) {
            if (i2 == 2) {
                this.f2536j--;
                this.A = null;
                this.C = null;
                if (this.f2535i == this.c) {
                    this.f2534h = 8;
                    return 8;
                }
            } else if (i2 == 7) {
                short nodeType = this.f2535i.getNodeType();
                if (nodeType == 1) {
                    this.f2534h = 1;
                    return 1;
                }
                if (nodeType != 9 && nodeType != 11) {
                    throw new XMLStreamException("Internal error: unexpected DOM root node type " + ((int) this.f2535i.getNodeType()) + " for node '" + this.f2535i + "'");
                }
                Node firstChild = this.f2535i.getFirstChild();
                this.f2535i = firstChild;
                if (firstChild == null) {
                    this.f2534h = 8;
                    return 8;
                }
            } else if (i2 == 8) {
                throw new NoSuchElementException("Can not call next() after receiving END_DOCUMENT");
            }
            Node nextSibling = this.f2535i.getNextSibling();
            if (nextSibling == null) {
                Node parentNode = this.f2535i.getParentNode();
                this.f2535i = parentNode;
                short nodeType2 = parentNode.getNodeType();
                if (nodeType2 == 1) {
                    this.f2534h = 2;
                    return 2;
                }
                if (this.f2535i == this.c && (nodeType2 == 9 || nodeType2 == 11)) {
                    this.f2534h = 8;
                    return 8;
                }
                throw new XMLStreamException("Internal error: non-element parent node (" + ((int) nodeType2) + ") that is not the initial root node");
            }
            this.f2535i = nextSibling;
        } else {
            this.f2536j++;
            this.A = null;
            Node firstChild2 = this.f2535i.getFirstChild();
            if (firstChild2 == null) {
                this.f2534h = 2;
                return 2;
            }
            this.C = null;
            this.f2535i = firstChild2;
        }
        switch (this.f2535i.getNodeType()) {
            case 1:
                this.f2534h = 1;
                break;
            case 2:
            case 6:
            case 12:
                throw new XMLStreamException("Internal error: unexpected DOM node type " + ((int) this.f2535i.getNodeType()) + " (attr/entity/notation?), for node '" + this.f2535i + "'");
            case 3:
                if (!this.e) {
                    this.f2534h = 4;
                    break;
                } else {
                    g(4);
                    break;
                }
            case 4:
                if (!this.e) {
                    this.f2534h = 12;
                    break;
                } else {
                    g(12);
                    break;
                }
            case 5:
                this.f2534h = 9;
                break;
            case 7:
                this.f2534h = 3;
                break;
            case 8:
                this.f2534h = 5;
                break;
            case 9:
            case 11:
            default:
                throw new XMLStreamException("Internal error: unrecognized DOM node type " + ((int) this.f2535i.getNodeType()) + ", for node '" + this.f2535i + "'");
            case 10:
                this.f2534h = 11;
                break;
        }
        return this.f2534h;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int nextTag() throws XMLStreamException {
        while (true) {
            int next = next();
            if (next != 12) {
                switch (next) {
                    case 1:
                    case 2:
                        return next;
                    case 3:
                    case 5:
                    case 6:
                    case 4:
                        break;
                    default:
                        r("Received event " + n.b.a.m.i.a(next) + ", instead of START_ELEMENT or END_ELEMENT.");
                        throw null;
                }
            }
            if (!isWhiteSpace()) {
                r("Received non-all-whitespace CHARACTERS or CDATA event in nextTag().");
                throw null;
            }
        }
    }

    protected void o(int i2) {
        throw new IllegalStateException(h(i2, this.f2534h));
    }

    protected void p(boolean z) {
        this.f = z;
    }

    protected void q(boolean z) {
        this.g = z;
    }

    protected void r(String str) throws XMLStreamException {
        s(str, j());
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public void require(int i2, String str, String str2) throws XMLStreamException {
        int i3 = this.f2534h;
        if (i3 != i2 && (i3 == 12 || i3 == 6)) {
            i3 = 4;
        }
        if (i2 != i3) {
            r("Required type " + n.b.a.m.i.a(i2) + ", current type " + n.b.a.m.i.a(i3));
            throw null;
        }
        if (str2 != null) {
            if (i3 != 1 && i3 != 2 && i3 != 9) {
                r("Required a non-null local name, but current token not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE (was " + n.b.a.m.i.a(this.f2534h) + ")");
                throw null;
            }
            String localName = getLocalName();
            if (localName != str2 && !localName.equals(str2)) {
                r("Required local name '" + str2 + "'; current local name '" + localName + "'.");
                throw null;
            }
        }
        if (str != null) {
            if (i3 != 1 && i3 != 2) {
                r("Required non-null NS URI, but current token not a START_ELEMENT or END_ELEMENT (was " + n.b.a.m.i.a(i3) + ")");
                throw null;
            }
            String namespaceURI = getNamespaceURI();
            if (str.length() == 0) {
                if (namespaceURI == null || namespaceURI.length() <= 0) {
                    return;
                }
                r("Required empty namespace, instead have '" + namespaceURI + "'.");
                throw null;
            }
            if (str == namespaceURI || str.equals(namespaceURI)) {
                return;
            }
            r("Required namespace '" + str + "'; have '" + namespaceURI + "'.");
            throw null;
        }
    }

    protected abstract void s(String str, Location location) throws XMLStreamException;

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean standaloneSet() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextCharacters(int i2, char[] cArr, int i3, int i4) {
        if (((1 << this.f2534h) & 4208) != 0) {
            String text = getText();
            if (i4 > text.length()) {
                i4 = text.length();
            }
            text.getChars(i2, i2 + i4, cArr, i3);
            return i4;
        }
        o(5);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(int i2) {
        int i3 = this.f2534h;
        if (i3 != 1 && i3 != 2) {
            o(2);
            throw null;
        }
        if (this.C == null) {
            if (this.d) {
                a(i3 == 1);
            } else {
                m(i2);
                throw null;
            }
        }
        if (i2 >= 0 && i2 + i2 < this.C.size()) {
            return this.C.get(i2 + i2 + 1);
        }
        m(i2);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        if (str == null) {
            str = "";
        }
        for (Node parentNode = this.f2535i; parentNode != null; parentNode = parentNode.getParentNode()) {
            NamedNodeMap attributes = parentNode.getAttributes();
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                Node nodeItem = attributes.item(i2);
                String prefix = nodeItem.getPrefix();
                if (prefix != null && prefix.length() != 0) {
                    if ("xmlns".equals(prefix) && str.equals(nodeItem.getNodeValue())) {
                        return nodeItem.getLocalName();
                    }
                } else if ("xmlns".equals(nodeItem.getLocalName()) && str.equals(nodeItem.getNodeValue())) {
                    return "";
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeValue(String str, String str2) {
        if (this.f2534h == 1) {
            NamedNodeMap attributes = ((Element) this.f2535i).getAttributes();
            if (str != null && str.length() == 0) {
                str = null;
            }
            Attr attr = (Attr) attributes.getNamedItemNS(str, str2);
            if (attr == null) {
                return null;
            }
            return attr.getValue();
        }
        o(1);
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(String str) {
        boolean z = str == null || str.length() == 0;
        for (Node parentNode = this.f2535i; parentNode != null; parentNode = parentNode.getParentNode()) {
            NamedNodeMap attributes = parentNode.getAttributes();
            if (attributes != null) {
                int length = attributes.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    Node nodeItem = attributes.item(i2);
                    String prefix = nodeItem.getPrefix();
                    if (prefix != null && prefix.length() != 0) {
                        if (!z && "xmlns".equals(prefix) && str.equals(nodeItem.getLocalName())) {
                            return nodeItem.getNodeValue();
                        }
                    } else if (z && "xmlns".equals(nodeItem.getLocalName())) {
                        return nodeItem.getNodeValue();
                    }
                }
            }
        }
        return null;
    }
}
