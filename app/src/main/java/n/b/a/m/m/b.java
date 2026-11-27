package n.b.a.m.m;

import n.b.a.j;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public abstract class b implements j {
    protected final boolean c;
    protected final boolean d;
    protected NamespaceContext e;
    protected final Document f;

    protected b(Node node, boolean z, boolean z2) throws XMLStreamException {
        if (node == null) {
            throw new IllegalArgumentException("Can not pass null Node for constructing a DOM-based XMLStreamWriter");
        }
        this.c = z;
        this.d = z2;
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            this.f = node.getOwnerDocument();
        } else if (nodeType == 9) {
            this.f = (Document) node;
        } else {
            if (nodeType != 11) {
                throw new XMLStreamException("Can not create an XMLStreamWriter for a DOM node of type " + node.getClass());
            }
            this.f = node.getOwnerDocument();
        }
        if (this.f != null) {
            return;
        }
        throw new XMLStreamException("Can not create an XMLStreamWriter for given node (of type " + node.getClass() + "): did not have owner document");
    }

    protected static void f(String str) throws XMLStreamException {
        throw new XMLStreamException(str);
    }

    @Override // n.b.a.j
    public void a(String str, String str2, boolean z) throws XMLStreamException {
        writeStartDocument(str2, str);
    }

    protected abstract void c(Node node) throws IllegalStateException;

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void close() {
    }

    @Override // n.b.a.j
    public void d(String str) throws XMLStreamException {
        e("writeRaw()");
        throw null;
    }

    protected void e(String str) {
        throw new UnsupportedOperationException(str + " can not be used with DOM-backed writer");
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void flush() {
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setNamespaceContext(NamespaceContext namespaceContext) {
        this.e = namespaceContext;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCData(String str) throws IllegalStateException, XMLStreamException {
        c(this.f.createCDATASection(str));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCharacters(char[] cArr, int i2, int i3) throws IllegalStateException, XMLStreamException {
        writeCharacters(new String(cArr, i2, i3));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeComment(String str) throws IllegalStateException, XMLStreamException {
        c(this.f.createComment(str));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeDTD(String str) throws XMLStreamException {
        e("writeDTD()");
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEntityRef(String str) throws IllegalStateException, XMLStreamException {
        c(this.f.createEntityReference(str));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str) throws IllegalStateException, XMLStreamException {
        writeProcessingInstruction(str, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument() throws XMLStreamException {
        writeStartDocument("UTF-8", "1.0");
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str, String str2) throws XMLStreamException {
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCharacters(String str) throws IllegalStateException, XMLStreamException {
        c(this.f.createTextNode(str));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str, String str2) throws IllegalStateException, XMLStreamException {
        c(this.f.createProcessingInstruction(str, str2));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str) throws XMLStreamException {
        writeStartDocument(null, str);
    }
}
