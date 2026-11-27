package n.b.a.m;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLEventReader;
import org.apache.poi.javax.xml.stream.XMLEventWriter;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Attribute;
import org.apache.poi.javax.xml.stream.events.Characters;
import org.apache.poi.javax.xml.stream.events.Comment;
import org.apache.poi.javax.xml.stream.events.DTD;
import org.apache.poi.javax.xml.stream.events.EntityReference;
import org.apache.poi.javax.xml.stream.events.Namespace;
import org.apache.poi.javax.xml.stream.events.ProcessingInstruction;
import org.apache.poi.javax.xml.stream.events.StartDocument;
import org.apache.poi.javax.xml.stream.events.StartElement;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes2.dex */
public class f implements XMLEventWriter, XMLStreamConstants {
    protected final n.b.a.j c;

    public f(n.b.a.j jVar) {
        this.c = jVar;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter, org.apache.poi.javax.xml.stream.util.XMLEventConsumer
    public void add(XMLEvent xMLEvent) throws XMLStreamException {
        switch (xMLEvent.getEventType()) {
            case 1:
                StartElement startElementAsStartElement = xMLEvent.asStartElement();
                QName name = startElementAsStartElement.getName();
                this.c.writeStartElement(name.getPrefix(), name.getLocalPart(), name.getNamespaceURI());
                Iterator namespaces = startElementAsStartElement.getNamespaces();
                while (namespaces.hasNext()) {
                    add((Namespace) namespaces.next());
                }
                Iterator attributes = startElementAsStartElement.getAttributes();
                while (attributes.hasNext()) {
                    add((Attribute) attributes.next());
                }
                return;
            case 2:
                this.c.writeEndElement();
                return;
            case 3:
                ProcessingInstruction processingInstruction = (ProcessingInstruction) xMLEvent;
                this.c.writeProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
                return;
            case 4:
                Characters charactersAsCharacters = xMLEvent.asCharacters();
                String data = charactersAsCharacters.getData();
                if (charactersAsCharacters.isCData()) {
                    this.c.writeCData(data);
                    return;
                } else {
                    this.c.writeCharacters(data);
                    return;
                }
            case 5:
                this.c.writeComment(((Comment) xMLEvent).getText());
                return;
            case 6:
            default:
                if (xMLEvent instanceof n.b.a.k.b) {
                    ((n.b.a.k.b) xMLEvent).c(this.c);
                    return;
                }
                throw new XMLStreamException("Don't know how to output event " + xMLEvent);
            case 7:
                StartDocument startDocument = (StartDocument) xMLEvent;
                if (!startDocument.encodingSet()) {
                    this.c.writeStartDocument(startDocument.getVersion());
                    return;
                } else if (startDocument.standaloneSet()) {
                    this.c.a(startDocument.getVersion(), startDocument.getCharacterEncodingScheme(), startDocument.isStandalone());
                    return;
                } else {
                    this.c.writeStartDocument(startDocument.getCharacterEncodingScheme(), startDocument.getVersion());
                    return;
                }
            case 8:
                this.c.writeEndDocument();
                return;
            case 9:
                this.c.writeEntityRef(((EntityReference) xMLEvent).getName());
                return;
            case 10:
                Attribute attribute = (Attribute) xMLEvent;
                QName name2 = attribute.getName();
                this.c.writeAttribute(name2.getPrefix(), name2.getNamespaceURI(), name2.getLocalPart(), attribute.getValue());
                return;
            case 11:
                this.c.writeDTD(((DTD) xMLEvent).getDocumentTypeDeclaration());
                return;
            case 12:
                this.c.writeCData(xMLEvent.asCharacters().getData());
                return;
            case 13:
                Namespace namespace = (Namespace) xMLEvent;
                this.c.writeNamespace(namespace.getPrefix(), namespace.getNamespaceURI());
                return;
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public void close() throws XMLStreamException {
        this.c.close();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public void flush() throws XMLStreamException {
        this.c.flush();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public NamespaceContext getNamespaceContext() {
        return this.c.getNamespaceContext();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public String getPrefix(String str) throws XMLStreamException {
        return this.c.getPrefix(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public void setDefaultNamespace(String str) throws XMLStreamException {
        this.c.setDefaultNamespace(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this.c.setNamespaceContext(namespaceContext);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public void setPrefix(String str, String str2) throws XMLStreamException {
        this.c.setPrefix(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventWriter
    public void add(XMLEventReader xMLEventReader) throws XMLStreamException {
        while (xMLEventReader.hasNext()) {
            add(xMLEventReader.nextEvent());
        }
    }
}
