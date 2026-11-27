package n.b.a.o;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamWriter;

/* loaded from: classes2.dex */
public abstract class b implements XMLStreamWriter {
    protected XMLStreamWriter c;

    public b(XMLStreamWriter xMLStreamWriter) {
        this.c = xMLStreamWriter;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void close() throws XMLStreamException {
        this.c.close();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void flush() throws XMLStreamException {
        this.c.flush();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public NamespaceContext getNamespaceContext() {
        return this.c.getNamespaceContext();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public String getPrefix(String str) throws XMLStreamException {
        return this.c.getPrefix(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public Object getProperty(String str) throws IllegalArgumentException {
        return this.c.getProperty(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setDefaultNamespace(String str) throws XMLStreamException {
        this.c.setDefaultNamespace(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this.c.setNamespaceContext(namespaceContext);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setPrefix(String str, String str2) throws XMLStreamException {
        this.c.setPrefix(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2) throws XMLStreamException {
        this.c.writeAttribute(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCData(String str) throws XMLStreamException {
        this.c.writeCData(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCharacters(String str) throws XMLStreamException {
        this.c.writeCharacters(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeComment(String str) throws XMLStreamException {
        this.c.writeComment(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeDTD(String str) throws XMLStreamException {
        this.c.writeDTD(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        this.c.writeDefaultNamespace(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str) throws XMLStreamException {
        this.c.writeEmptyElement(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEndDocument() throws XMLStreamException {
        this.c.writeEndDocument();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEndElement() throws XMLStreamException {
        this.c.writeEndElement();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEntityRef(String str) throws XMLStreamException {
        this.c.writeEntityRef(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        this.c.writeNamespace(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str) throws XMLStreamException {
        this.c.writeProcessingInstruction(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument() throws XMLStreamException {
        this.c.writeStartDocument();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str) throws XMLStreamException {
        this.c.writeStartElement(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        this.c.writeAttribute(str, str2, str3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCharacters(char[] cArr, int i2, int i3) throws XMLStreamException {
        this.c.writeCharacters(cArr, i2, i3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        this.c.writeEmptyElement(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        this.c.writeProcessingInstruction(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str) throws XMLStreamException {
        this.c.writeStartDocument(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        this.c.writeStartElement(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        this.c.writeAttribute(str, str2, str3, str4);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        this.c.writeEmptyElement(str, str2, str3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        this.c.writeStartDocument(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        this.c.writeStartElement(str, str2, str3);
    }
}
